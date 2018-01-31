package edu.zhwei.search.dao;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;

import edu.zhwei.search.commons.BookResult;
import edu.zhwei.search.pojo.SearchMenu;

public interface SearchDao {

	List<SearchMenu> search(SolrQuery query) throws SolrServerException;
	
	//同步索引库
	BookResult synchronize(Integer id);
}
