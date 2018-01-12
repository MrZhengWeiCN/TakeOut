<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<title>下单成功！</title>


</head>

<body>
	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>
	<h3>恭喜您下单成功，订单预计于<fmt:formatDate value="${order.orderTime}" pattern="HH:mm"/>送达！</h3>

	<div class="input-group">
		<span id="ib_shop_price_span" class="input-group-addon">订单号</span> <input
			type="text" address='totalPrice' id="ib_shop_price_input"
			class="form-control" value="${order.orderId }" readOnly="true" />
	</div>
	</br>
	<div class="input-group">
		<span id="ib_shop_price_span" class="input-group-addon">总价</span> <input
			type="text" address='totalPrice' id="ib_shop_price_input"
			class="form-control" value="￥${order.orderPrice/10 }元" readOnly="true" />
	</div>
	</br>
	<div class="input-group">
		<span id="ib_shop_addr_span" class="input-group-addon">收货地址</span> <input
			type="text" name="orderAddr" address="strAddress"
			id="ib_shop_addr_input" class="form-control"
			value="${order.orderAddr }" readOnly="true" />
	</div>
	</br>
	<div class="input-group">
		<span id="ib_shop_addr_span" class="input-group-addon">收货人姓名</span> <input
			type="text" name="orderUserName" address="strAddress"
			id="ib_shop_addr_input" class="form-control"
			value="${order.orderUserName }" readOnly="true" />
	</div>
	</br>
	<div class="input-group">
		<span id="ib_shop_addr_span" class="input-group-addon">联系电话</span> <input
			type="text" name="orderTel" address="strAddress"
			id="ib_shop_addr_input" class="form-control"
			value="${order.orderTel }" readOnly="true" />
	</div>
	
	<br>
</body>
</html>
