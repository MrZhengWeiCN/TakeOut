package edu.zhwei.service;

import java.util.List;

import edu.zhwei.common.BookResult;
import edu.zhwei.pojo.Menu;
import edu.zhwei.pojo.Menutype;

public interface MenuService {

	BookResult doOpt(String opt, String menuTypeName,Integer id);

	List<Menutype> findAll();

	BookResult menuChange(String menuAdd, Menu menu,Integer id);
	
	List<Menu> findAllMenu();

	List<Menu> selectTypeMenu(Integer typeId);
	
	Menutype findMenuTypeById(Integer typeId);

	Menu findMenuById(Integer menuId);

}
