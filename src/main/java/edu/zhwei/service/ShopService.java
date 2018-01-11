package edu.zhwei.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.zhwei.common.BookResult;
import edu.zhwei.pojo.ShopDetail;

public interface ShopService {

	BookResult addDetail(ShopDetail shopDetail,HttpServletRequest request,HttpServletResponse response);

	List<ShopDetail> findAllShopDetail(HttpServletRequest request);

	BookResult change(Integer menuId, String opt, HttpServletRequest request,
			HttpServletResponse response);
}
