package edu.zhwei.search.dao;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;

import edu.zhwei.search.pojo.SearchMenu;

public interface SearchDao {

	List<SearchMenu> search(SolrQuery query) throws SolrServerException;
}
