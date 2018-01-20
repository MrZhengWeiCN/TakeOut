package edu.zhwei.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import edu.zhwei.common.BookResult;
import edu.zhwei.common.CookieUtils;
import edu.zhwei.common.JsonUtils;
import edu.zhwei.pojo.ShopDetail;
import edu.zhwei.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	private static final String DEL="Del";
	private static final String INC="Inc";
	private static final String DEC="Dec";
	
	private static final String RC="remarkChange";
	
	
	@Override
	public BookResult addDetail(ShopDetail shopDetail,
			HttpServletRequest request,HttpServletResponse response)  {
		String cookieValue = CookieUtils.getCookieValue(request, "SHOP");
		List<ShopDetail> details = null;
		if(cookieValue==null){
			details = new ArrayList<>();
		}else {
			details = JsonUtils.jsonToList(cookieValue, ShopDetail.class);
		}
		boolean exist = false;
		for (ShopDetail detail : details) {
			//如果已经存在只需要改数量就可
			if(detail.getMenuId().equals(shopDetail.getMenuId())){
				detail.setNum(detail.getNum()+1);
				exist = true;
				break;
			}
		}
		if(!exist){
			String name = shopDetail.getMenuName();
			try {
				name = URLEncoder.encode(name,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			shopDetail.setMenuName(name);
			shopDetail.setNum(1);
			details.add(shopDetail);
		}
		String json = JsonUtils.objectToJson(details);
		/*CookieUtils.setCookie(request, response, "SHOP", json, 60*60*24*14, true);*/
		CookieUtils.setCookie(request, response, "SHOP", json, 60*60*24*14);
		return BookResult.ok();

	}

	@Override
	public List<ShopDetail> findAllShopDetail(HttpServletRequest request) {
		/*String json = CookieUtils.getCookieValue(request, "SHOP", true);*/
		String json = CookieUtils.getCookieValue(request, "SHOP");
		if(json==null){
			return null;
		}
		try {
			json = URLDecoder.decode(json,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<ShopDetail> details = JsonUtils.jsonToList(json, ShopDetail.class);
		return details;
	}

	@Override
	public BookResult change(Integer menuId, String opt,
			HttpServletRequest request,String remark,HttpServletResponse response) {
		if(opt.equals(DEL)){
			return del(menuId,request,response);
		}
		if(opt.equals(INC)){
			return inc(menuId,request,response);
		}
		if(opt.equals(DEC)){
			return dec(menuId,request,response);
		}
		if(opt.equals(RC)){
			return remark(menuId,remark,request,response);
		}
		return null;
	}

	//修改备注
	private BookResult remark(Integer menuId, String remark,
			HttpServletRequest request, HttpServletResponse response) {
		String cookieValue = CookieUtils.getCookieValue(request, "SHOP");
		List<ShopDetail> detalis = JsonUtils.jsonToList(cookieValue, ShopDetail.class);
		for (ShopDetail shopDetail : detalis) {
			if(shopDetail.getMenuId()==menuId){
				try {
					remark = URLEncoder.encode(remark,"UTF-8");
					shopDetail.setRemark(remark);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		String json = JsonUtils.objectToJson(detalis);
		CookieUtils.setCookie(request, response, "SHOP", json, 60*60*24*14);
		return BookResult.ok();
	}

	private BookResult dec(Integer menuId, HttpServletRequest request,
			HttpServletResponse response) {
		String cookieValue = CookieUtils.getCookieValue(request, "SHOP");
		List<ShopDetail> detalis = JsonUtils.jsonToList(cookieValue, ShopDetail.class);
		for (ShopDetail shopDetail : detalis) {
			if(shopDetail.getMenuId()==menuId){
				shopDetail.setNum((shopDetail.getNum()-1)>0?shopDetail.getNum()-1:1);
				break;
			}
		}
		String json = JsonUtils.objectToJson(detalis);
		CookieUtils.setCookie(request, response, "SHOP", json, 60*60*24*14);
		return BookResult.ok();
	}

	private BookResult inc(Integer menuId, HttpServletRequest request,
			HttpServletResponse response) {
		String cookieValue = CookieUtils.getCookieValue(request, "SHOP");
		List<ShopDetail> detalis = JsonUtils.jsonToList(cookieValue, ShopDetail.class);
		for (ShopDetail shopDetail : detalis) {
			if(shopDetail.getMenuId()==menuId){
				shopDetail.setNum(shopDetail.getNum()+1);
				break;
			}
		}
		String json = JsonUtils.objectToJson(detalis);
		CookieUtils.setCookie(request, response, "SHOP", json, 60*60*24*14);
		return BookResult.ok();
	}

	private BookResult del(Integer menuId, HttpServletRequest request,
			HttpServletResponse response) {
		String cookieValue = CookieUtils.getCookieValue(request, "SHOP");
		List<ShopDetail> detalis = JsonUtils.jsonToList(cookieValue, ShopDetail.class);
		for (ShopDetail shopDetail : detalis) {
			if(shopDetail.getMenuId()==menuId){
				detalis.remove(shopDetail);
				break;
			}
		}
		String json = JsonUtils.objectToJson(detalis);
		CookieUtils.setCookie(request, response, "SHOP", json, 60*60*24*14);
		return BookResult.ok();
	}
}
