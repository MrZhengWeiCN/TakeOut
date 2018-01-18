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
<%@ include file="/WEB-INF/jsp/header.jsp"%>
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
	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>
	<div class="couponTitle">
		<div align="center" style="font-size:200%">
			<strong>优惠券中心</strong>
		</div>
	</div>

	<c:forEach items="${coupons }" var="coupon">
		<p>&nbsp;</p>
		<div class="item"
			style="color:white;margin-left: auto;margin-right: auto;border:3px solid #000;width:300px;height:210px;background:url(/image/diwen.jpg)">
			<div align="center">
				<p>
					<strong style="font-size:180%">￥${coupon.couponDiscount/10 }元</strong>
				</p>
				<p align="center">
					<strong>${coupon.couponDesc }</strong>
				</p>
				<p>
					<strong><fmt:formatDate value="${coupon.couponStartTime }"
							pattern="yyyy-MM-dd" />——<fmt:formatDate
							value="${coupon.couponEndTime }" pattern="yyyy-MM-dd" /> </strong>
				</p>
				<p>
					<strong>余量：${coupon.couponNum }</strong>
				</p>
				<p>
					<button onclick='getCoupon("couponId=${coupon.couponId }");'><strong
						style="font-size:120%">立即抢购</strong></button>
				</p>
			</div>
		</div>
		<p>&nbsp;</p>
	</c:forEach>
	<%@ include file="/WEB-INF/jsp/pagination.jsp"%>
</body>
<script type="text/javascript">
	function getCoupon(data) {
		var ajaxUrl = "getCoupon";
		jQuery.ajax({
			type : "POST",
			url : ajaxUrl,
			data : data,
			dataType : "json",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			success : function(data) {
				if (data.status == 200) {
					alert("抢购成功！");
				} else {
					alert(data.msg);
				}
			}
		});
	}
</script>
</html>
