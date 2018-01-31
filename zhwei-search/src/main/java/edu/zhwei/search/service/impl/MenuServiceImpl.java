package edu.zhwei.search.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zhwei.search.commons.BookResult;
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

		List<SearchMenu> result = searchDao.search(solrQuery);
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
