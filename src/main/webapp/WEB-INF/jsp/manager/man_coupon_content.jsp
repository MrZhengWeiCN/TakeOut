<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>优惠券列表</title>

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
<script type="text/javascript">
	function onBtnDelClick(data){
		window.confirm("删除后不可恢复，确定删除？");
		var ajaxUrl = "/manDeleteCoupon";
		jQuery.ajax({
			type : "POST",
			url : ajaxUrl,
			data : data,
			dataType : "json",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			success : function(data) {
				if (data.status == 200) {
					alert("删除成功！");
				} else {
					alert(data.msg);
				}
				window.location.reload();
			}
		});
	}
</script>

	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>
	<h1 style="text-align:center">优惠券列表</h1>
	
	<form action="/addProcess" method="post">
    	优惠券名称：<input type="text" name="couponName" /> 
    	优惠券描述：<input type="text" name="couponDesc" /> <br>
    	开始时间：<input type="datetime" name="couponStartTime" placeholder="yyyy/MM/dd HH:mm:ss"/> 
    	结束时间：<input type="datetime" name="couponEndTime" placeholder="yyyy/MM/dd HH:mm:ss"/> <br>
    	减免额度：<input type="text" name="couponDiscount" /> 
    	最低消费门槛：<input type="text" name="couponThreshold" /> <br>
    	发放数量：<input type="text" name="couponNum" /> 
    	开始抢购时间：<input type="datetime" name="couponKilltime" placeholder="yyyy/MM/dd HH:mm:ss"/> <br>
    	<input type="submit" value="提交"> 
    </form>
	
	<table class="table">
		<tr>
			<th>序号</th>
			<th>名称</th>
			<th>说明</th>
			<th>使用期限</th>
			<th>数量</th>
			<th>抢购时间</th>
			<th>操作</th>
		</tr>

		<c:forEach items="${coupons }" var="coupon" varStatus="i">
			<tr>
				<td>${i.index+1 }</td>
				<td>${coupon.couponName }</td>
				<td>${coupon.couponDesc }</td>
				<td><fmt:formatDate value="${coupon.couponStartTime}"
						pattern="yyyy-MM-dd" />——<fmt:formatDate
						value="${coupon.couponEndTime}" pattern="yyyy-MM-dd" />
				</td>
				<td>${coupon.couponNum }</td>
				<td><fmt:formatDate value="${coupon.couponKilltime}"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>
					<button class="btn btn-primary btn-xs"
						onclick='onBtnDelClick("couponId=${coupon.couponId }");'>
						x</button></td>

			</tr>
		</c:forEach>
	</table>
	</br>
	<%@ include file="/WEB-INF/jsp/pagination.jsp"%>	
</body>
</html>
