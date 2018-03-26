package edu.zhwei.search.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zhwei.search.commons.BookResult;
import edu.zhwei.search.commons.JsonUtils;
import edu.zhwei.search.component.JedisClient;
import edu.zhwei.search.dao.SearchDao;
import edu.zhwei.search.mapper.MenuMapper;
import edu.zhwei.search.pojo.SearchMenu;
import edu.zhwei.search.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private SolrServer solrServer;
	@Autowired
	private SearchDao searchDao;
	@Autowired
	private JedisClient jedisClient;

	@Override
	public BookResult importMenus() {
		List<SearchMenu> menuList = menuMapper.getMenuList();
		for (SearchMenu menu : menuList) {
			SolrInputDocument document = new SolrInputDocument();
			document.addField("id", menu.getId().toString());
			document.addField("menu_name", menu.getName());
			document.addField("menu_type", menu.getType());
			document.addField("menu_picture", menu.getPicture());
			document.addField("menu_price", menu.getPrice());
			try {
				solrServer.add(document);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			solrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return BookResult.ok();
	}

	@Override
	public List<SearchMenu> search(String queryString)
			throws Exception {
		//为了解决提高响应速度，对搜索实行缓存
		String searchResult = jedisClient.get("search:"+queryString);
		List<SearchMenu> result = null;
		if(searchResult==null){
			// 创建查询条件
			SolrQuery solrQuery = new SolrQuery();
			solrQuery.setQuery(queryString);
			// 设置分页条件
			/*solrQuery.setStart((page - 1) * rows);
		solrQuery.setRows(rows);*/
			// 设置默认搜索域
			solrQuery.set("df", "menu_keywords");
			//设置高亮
			solrQuery.setHighlight(true);
			solrQuery.addHighlightField("menu_name");
			solrQuery.addHighlightField("menu_type");
			solrQuery.setHighlightSimplePre("<strong style='color:red'>");
			solrQuery.setHighlightSimplePost("</strong>");
			result = searchDao.search(solrQuery);
			String resultToJson = JsonUtils.objectToJson(result);
			jedisClient.set("search:"+queryString, resultToJson);
		}else {
			result = JsonUtils.jsonToList(searchResult, SearchMenu.class);
		}
		Random ra = new Random();
		int random = ra.nextInt(30);
		jedisClient.expire("search:"+queryString,12*60*60+random*60);
		//对搜索词进行频率+1
		jedisClient.zIncryBy("searchWord", 1, queryString);
		return result;
	}

	@Override
	public BookResult synchronize(Integer id) {
		return searchDao.synchronize(id);
	}

	@Override
	public BookResult addMenu(Integer id) {
		SearchMenu menu = menuMapper.getMenu(id);
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", menu.getId().toString());
		document.addField("menu_name", menu.getName());
		document.addField("menu_type", menu.getType());
		document.addField("menu_picture", menu.getPicture());
		document.addField("menu_price", menu.getPrice());
		try {
			solrServer.add(document);
			solrServer.commit();
			return BookResult.ok();
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
			return BookResult.build(400,"发生未知错误，请联系技术人员解决");
		}
	}
}
