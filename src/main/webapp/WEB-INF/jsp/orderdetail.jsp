<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%-- the header --%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<title>订单详情</title>
</head>
<body>
	<%-- the navbar --%>
	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>


	<%-- include the jstl --%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="ib_orderdetail_content_div">
		<table class="table">
			<tr>
				<th>菜单</th>
				<th>价格</th>
				<th>数量</th>
				<th>评价</th>
			</tr>
			<c:forEach var="orderDetail" items="${orderDetails }">
				<tr>
					<td>菜名<%-- ${menu.name} --%></td>
					<td>价格<%-- ${menu.price} --%></td>
					<td>数量<%-- ${menu.amount} --%></td>
					<td>备注<%-- ${menu.remark} --%></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<a href="${backURL}">返回</a>
	</div>

</body>
</html>