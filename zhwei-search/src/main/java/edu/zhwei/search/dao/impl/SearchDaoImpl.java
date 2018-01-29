package edu.zhwei.search.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import edu.zhwei.search.dao.SearchDao;
import edu.zhwei.search.pojo.SearchMenu;

@Repository
public class SearchDaoImpl implements SearchDao {
	
	@Autowired
	private SolrServer solrServer;

	@Override
	public List<SearchMenu> search(SolrQuery query) throws SolrServerException {
		QueryResponse response = solrServer.query(query);
		//取查询结果列表
		SolrDocumentList solrDocumentList = response.getResults();
		List<SearchMenu> result = new ArrayList<>();
		for (SolrDocument solrDocument : solrDocumentList) {
			SearchMenu menu = new SearchMenu();
			menu.setId(Integer.valueOf((String)solrDocument.get("id")));
			menu.setPicture((String)solrDocument.get("menu_picture"));
			menu.setPrice((Integer)solrDocument.get("menu_price"));
			menu.setType((String)solrDocument.get("menu_type"));
			
			//取高亮显示
			Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
			List<String> list = highlighting.get(solrDocument.get("id")).get("menu_name");
			String menuNameString = "";
			if (list != null && list.size() > 0){
				menuNameString = list.get(0);
			}else {
				menuNameString = (String)solrDocument.get("menu_name");
			}
			menu.setName(menuNameString);
			result.add(menu);
		}
		return result;
	}

}
