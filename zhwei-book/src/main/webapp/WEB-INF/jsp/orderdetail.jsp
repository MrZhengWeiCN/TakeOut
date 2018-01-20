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

		<h1 style="text-align:center">订单详情</h1>
		<table class="table">
			<tr>
				<th>订单号</th>
				<th>菜单</th>
				<th>价格</th>
				<th>数量</th>
				<th>备注</th>
			</tr>
			<c:forEach var="detail" items="${details }">
				<tr>
					<td>${detail.detailOrderId }</td>
					<td>${detail.detailMenuName }</td>
					<td>￥${detail.detailMenuPrice/10}元</td>
					<td>${detail.detailAmount}</td>
					<td>${detail.detailRemark}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</div>
	<div style="text-align:center">
		<a href="javascript:back()" style="text-align:center" onclick="back()">返回</a>
	</div>

</body>

<script type="text/javascript">
	function back() {
		window.location.href = document.referrer;
	}
</script>
</html>