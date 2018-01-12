package edu.zhwei.service.impl;



import java.io.IOException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import edu.zhwei.common.BookResult;
import edu.zhwei.common.CookieUtils;
import edu.zhwei.common.JsonUtils;
import edu.zhwei.mapper.OrderMapper;
import edu.zhwei.mapper.OrderdetailMapper;
import edu.zhwei.pojo.Order;
import edu.zhwei.pojo.OrderExample;
import edu.zhwei.pojo.OrderExample.Criteria;
import edu.zhwei.pojo.Orderdetail;
import edu.zhwei.pojo.OrderdetailExample;
import edu.zhwei.pojo.ShopDetail;
import edu.zhwei.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderdetailMapper detailMapper;
	
	@Override
	public BookResult orderCreate(Order order, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//开购物车中是否有东西
		String cookieValue = CookieUtils.getCookieValue(request, "SHOP");
		if (cookieValue==null) {
			return BookResult.build(400, "购物车中没有商品！");
		}
		//order补充属性，dateaccept，id
		Date date = new Date();
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		simpleDateFormat.format(date);
		order.setOrderTime(date);
		order.setOrderAccept(0);
		System.out.print(date);
		//插入
		orderMapper.insertSelective(order);
		Integer orderId = order.getOrderId();
		cookieValue = URLDecoder.decode(cookieValue, "UTF-8");
		List<ShopDetail> details = JsonUtils.jsonToList(cookieValue, ShopDetail.class);
		for (ShopDetail shopDetail : details) {
			Orderdetail orderdetail = new Orderdetail();
			orderdetail.setDetailOrderId(orderId);
			orderdetail.setDetailAmount(shopDetail.getNum());
			orderdetail.setDetailMenuName(shopDetail.getMenuName());
			orderdetail.setDetailMenuPrice(shopDetail.getTotalPrice());
			orderdetail.setDetailRemark(shopDetail.getRemark());
			//插入详情表
			try {
				detailMapper.insert(orderdetail);
			} catch (Exception e) {
				return BookResult.build(400, "未知错误发生！");
			}
		}
		//清空cookie中的购物车
		String orderJson = JsonUtils.objectToJson(order);
		return BookResult.ok(orderJson);
	}


	/**
	 * 照理来说应该是按照收货人的Id来搜索的
	 */
	@Override
	public List<Order> findAll(String orderUserName) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderUserNameEqualTo(orderUserName);
		List<Order> orders = orderMapper.selectByExample(example );
		return orders;
	}


	/**
	 * 找出一个订单下面的订单详情
	 */
	@Override
	public List<Orderdetail> findDetailByOrderId(Integer orderId) {
		OrderdetailExample example = new OrderdetailExample();
		edu.zhwei.pojo.OrderdetailExample.Criteria criteria = example.createCriteria();
		criteria.andDetailOrderIdEqualTo(orderId);
		List<Orderdetail> details = detailMapper.selectByExample(example );
		return details;
	}


	/**
	 * 找到所有的订单
	 */
	@Override
	public List<Order> findAll() {
		OrderExample example = new OrderExample();
		List<Order> orders = orderMapper.selectByExample(example );
		return orders;
	}
}
