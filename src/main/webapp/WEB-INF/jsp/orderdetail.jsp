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
			<c:forEach var="menu" items="menus">
				<tr>
					<td>${menu.name}</td>
					<td>${menu.price}</td>
					<td>${menu.amount}</td>
					<td>${menu.remark}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>