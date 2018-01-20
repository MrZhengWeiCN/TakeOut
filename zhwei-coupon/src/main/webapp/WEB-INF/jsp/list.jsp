<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>优惠券添加</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div class="couponTitle">
		<div align="center" style="font-size:200%">
			<strong>优惠券中心</strong>
		</div>
	</div>

	<c:forEach items="${coupons }" var="coupon">
		<p>&nbsp;</p>
		<div class="item"
			style="margin-left: auto;margin-right: auto;border:3px solid #000;width:300px;height:210px;background:url(/image/底纹jpg)">
			<div align="center">
				<p>
					<strong style="font-size:180%">￥${coupon.couponDiscount }</strong>
				</p>
				<p align="center">
					<strong>${coupon.couponDesc }</strong>
				</p>
				<p>
					<strong><fmt:formatDate value="${coupon.couponStartTime }" pattern="yyyy-MM-dd"/>——<fmt:formatDate value="${coupon.couponEndTime }" pattern="yyyy-MM-dd"/></strong>
				</p>
				<p>
					<strong>余量：${coupon.couponNum }</strong>
				</p>
				<p>
					<a href="/getCoupon?couponId=${coupon.couponId }"<strong style="font-size:120%">立即抢购</strong></a>
				</p>
			</div>
		</div>
		<p>&nbsp;</p>
	</c:forEach>
</body>
</html>
