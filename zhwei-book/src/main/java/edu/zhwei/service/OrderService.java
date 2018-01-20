package edu.zhwei.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.zhwei.common.BookResult;
import edu.zhwei.pojo.Order;
import edu.zhwei.pojo.Orderdetail;

public interface OrderService {

	BookResult orderCreate(Order order, HttpServletRequest request,
			HttpServletResponse response, Integer userId, Integer couponId) throws IOException;

	List<Order> findAll(String orderUserName);

	List<Orderdetail> findDetailByOrderId(Integer orderId);

	//找出所有的order
	List<Order> findAll();

	BookResult orderChange(String opt, Integer id);

}
