package edu.zhwei.service;

import java.util.List;

import edu.zhwei.pojo.SearchMenu;

public interface SearchService {

	List<SearchMenu> search(String keyword);
}
