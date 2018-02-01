package test;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrJ {

	@Test
	public void testSolrJ() throws SolrServerException, IOException {
		SolrServer solrServer = new HttpSolrServer("http://127.0.0.1:8080/solr");
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "测试一下menuId");
		document.addField("menu_name", "测试一下menunam");
		document.addField("menu_type", "测试一下menuIdtypr");
		document.addField("menu_price", 100);
		document.addField("menu_picture", "测试一下menuIdprice");
		solrServer.add(document);
		solrServer.commit();
	}

	@Test
	public void testQuery() throws SolrServerException {
		SolrServer solrServer = new HttpSolrServer("http://127.0.0.1:8080/solr");
		SolrQuery query = new SolrQuery();
		query.setQuery("id:测试一下menuId");
		QueryResponse response = solrServer.query(query);
		SolrDocumentList results = response.getResults();
		for (SolrDocument solrDocument : results) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("menu_name"));
			System.out.println(solrDocument.get("menu_type"));
			System.out.println(solrDocument.get("menu_price"));
			System.out.println(solrDocument.get("menu_picture"));
		}
	}

	@Test
	public void testSolrCluster() throws SolrServerException, IOException {
		CloudSolrServer cloudSolrServer = new CloudSolrServer(
				"127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183");
		//设置默认的collection
		cloudSolrServer.setDefaultCollection("collection1");
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "测试一下menuId");
		document.addField("menu_name", "测试一下menunam");
		document.addField("menu_type", "测试一下menuIdtypr");
		document.addField("menu_price", 100);
		document.addField("menu_picture", "测试一下menuIdprice");
		//添加文档
		cloudSolrServer.add(document);
		//提交
		cloudSolrServer.commit();

	}
}
