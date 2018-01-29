package edu.zhwei.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.zhwei.common.HttpClientUtil;
import edu.zhwei.common.JsonUtils;
import edu.zhwei.pojo.SearchMenu;
import edu.zhwei.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Override
	public List<SearchMenu> search(String keyword) {
		Map<String, String> param = new HashMap<String, String>();
		try {
			keyword = URLEncoder.encode(keyword, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		param.put("keyword", keyword);
		String json = HttpClientUtil.doGet("http://localhost:8083/q", param );
		List<SearchMenu> result = JsonUtils.jsonToList(json, SearchMenu.class);
		return result;
	}

}
