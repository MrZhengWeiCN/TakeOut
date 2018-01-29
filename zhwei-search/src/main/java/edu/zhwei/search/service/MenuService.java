package edu.zhwei.search.service;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

import edu.zhwei.search.commons.BookResult;
import edu.zhwei.search.pojo.SearchMenu;

public interface MenuService  {

	BookResult importMenus() throws SolrServerException,IOException;
	
	List<SearchMenu> search(String queryString) throws Exception;
}
