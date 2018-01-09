<%-- include the jstl --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<table class="table">
	<tr>
		<th>序号</th>
		<th>下单时间
		<th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	
	<c:forEach items="${orders }" var="order" >
		<tr>
			<td><a href='orderDetailPageEnter?orderId=${order.id }'>
					${order.id } </a>
			</td>
			<td>${order.time }</td>
			<c:choose>
				<c:when test=" ${order.accept==1}">
					<td>已处理</td>
				</c:when>
				<c:otherwise>
					<td>未处理</td>
				</c:otherwise>
			</c:choose>

			<c:if test="${order.accept==0 }">
				<td>
					<button class="btn btn-primary btn-xs"
						onclick='onBtnDelClick("orderId=${order.id }&opt=orderDel&page=${currPage}");'>
						x</button>
				</td>
			</c:if>
		</tr>
	</c:forEach>
</table>
</br>

<%-- the pagination --%>
<%@ include file="/WEB-INF/jsp/pagination.jsp"%>
