package edu.zhwei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zhwei.common.BookResult;
import edu.zhwei.mapper.MenuMapper;
import edu.zhwei.mapper.MenutypeMapper;
import edu.zhwei.pojo.Menu;
import edu.zhwei.pojo.MenuExample;
import edu.zhwei.pojo.Menutype;
import edu.zhwei.pojo.MenutypeExample;
import edu.zhwei.pojo.MenutypeExample.Criteria;
import edu.zhwei.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	private static final String ADD = "menuTypeAdd";
	private static final String MOD = "menuTypeMod";
	private static final String DEL = "menuTypeDel";
	
	
	private static final String MENUADD = "menuAdd";
	private static final String MENUDEL = "menuDel";
	private static final String MENUMOD = "menuMod";
	
	@Autowired
	private MenutypeMapper typeMapper;
	@Autowired
	private MenuMapper menuMapper;

	//菜单类型的操作
	@Override
	public BookResult doOpt(String opt, String menuTypeName, Integer id) {
		if (opt.equals(ADD)) {
			return add(menuTypeName);
		}
		if (opt.equals(MOD)) {
			return mod(id, menuTypeName);
		}
		if (opt.equals(DEL)) {
			return del(id);
		}
		return null;
	}

	private BookResult del(Integer id) {
		try {
			typeMapper.deleteByPrimaryKey(id);
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "未知错误发生！");
		}
	}

	@Override
	public List<Menutype> findAll() {
		MenutypeExample example = new MenutypeExample();
		List<Menutype> types = typeMapper.selectByExample(example);
		return types;
	}

	public BookResult mod(Integer id, String menuTypeName) {
		Menutype typeMenutype = new Menutype();
		// 对menuTypeName进行校验
		MenutypeExample example = new MenutypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andMenuTypeNameEqualTo(menuTypeName);
		List<Menutype> list = typeMapper.selectByExample(example);
		if (list != null && list.size() > 0)
			return BookResult.build(400, "类型已存在！");

		typeMenutype.setMenuTypeId(id);
		typeMenutype.setMenuTypeName(menuTypeName);
		try {
			typeMapper.updateByPrimaryKeySelective(typeMenutype);
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "发生了未知错误！");
		}
	}

	public BookResult add(String menuTypeName) {
		Menutype typeMenutype = new Menutype();
		typeMenutype.setMenuTypeName(menuTypeName);
		typeMenutype.setMenuTypeNum(0);
		try {
			MenutypeExample example = new MenutypeExample();
			Criteria criteria = example.createCriteria();
			criteria.andMenuTypeNameEqualTo(menuTypeName);
			List<Menutype> types = typeMapper.selectByExample(example);
			if (types != null && types.size() > 0)
				return BookResult.build(400, "类型已经存在！");
			typeMapper.insert(typeMenutype);
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "发生了未知的错误！");
		}
	}

	//关于菜单的操作
	@Override
	public BookResult menuChange(String opt, Menu menu,Integer id) {
		if(opt.equals(MENUADD)){
			return menuAdd(menu);
		}
		if(opt.equals(MENUDEL)){
			return menuDel(id);
		}
		if(opt.equals(MENUMOD)){
			return menuMod(menu,id);
		}
		return null;
	}

	private BookResult menuMod(Menu menu, Integer id) {
		//先检验菜名是否存在
		menu.setMenuId(id);
		//菜名是否改变
		Menu oldMenu = menuMapper.selectByPrimaryKey(id);
		if(!oldMenu.getMenuName().endsWith(menu.getMenuName())){
			MenuExample example = new MenuExample();
			edu.zhwei.pojo.MenuExample.Criteria criteria = example.createCriteria();
			criteria.andMenuNameEqualTo(menu.getMenuName());
			List<Menu> menus = menuMapper.selectByExample(example );
			if(menus!=null&&menus.size()>0){
				return BookResult.build(400, "菜品已经存在！");
			}
		}
		//更新
		try {
			menuMapper.updateByPrimaryKey(menu);
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "未知错误发生！");
		}
	}

	private BookResult menuDel(Integer id) {
		try {
			menuMapper.deleteByPrimaryKey(id);
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "未知错误发生！");
		}
	}

	private BookResult menuAdd(Menu menu) {
		//先校验是否已经有相同的菜名了
		MenuExample example = new MenuExample();
		edu.zhwei.pojo.MenuExample.Criteria criteria = example.createCriteria();
		criteria.andMenuNameEqualTo(menu.getMenuName());
		List<Menu> menus = menuMapper.selectByExample(example);
		if(menus!=null&&menus.size()>0)
			return BookResult.build(400, "菜品已存在，无需重复添加！");
		try {
			menuMapper.insert(menu);
			//类型数量加一
			Menutype type = typeMapper.selectByPrimaryKey(menu.getMenuTypeId());
			type.setMenuTypeNum(type.getMenuTypeNum()+1);
			typeMapper.updateByPrimaryKey(type);
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "未知错误发生！");
		}
	}

	@Override
	public List<Menu> findAllMenu() {
		MenuExample example = new MenuExample();
		edu.zhwei.pojo.MenuExample.Criteria criteria = example.createCriteria();
		List<Menu> types = menuMapper.selectByExample(example );
		return types;
	}

	//找到某一个类型的菜单
	@Override
	public List<Menu> selectTypeMenu(Integer typeId) {
		MenuExample example = new MenuExample();
		edu.zhwei.pojo.MenuExample.Criteria criteria = example.createCriteria();
		criteria.andMenuTypeIdEqualTo(typeId);
		List<Menu> menus = menuMapper.selectByExample(example );
		return menus;
	}

}
