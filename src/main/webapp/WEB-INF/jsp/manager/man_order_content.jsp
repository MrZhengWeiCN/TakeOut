<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- include the jstl --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <tr>
        <th>订单号</th>
        <th>客户</th>
        <th>下单时间</th>
        <th>状态</th>
        <th>联系电话</th>
        <th>地址</th>
        <th>操作</th>
       <th>价格</th>
    </tr>
  
    <c:forEach var="order" items="${orders }">
    <tr>
        <td>
            <a href='/manOrderDetailPageEnter?orderId=${order.orderId }'>
                ${order.orderId }
            </a>
        </td>
        <td>${order.orderUserName }</td>
        <td><fmt:formatDate value="${order.orderTime}" pattern="yyyy年MM月dd日--HH:mm:ss"/></td>
        <td>${order.orderAccept==1?"已处理":"未处理" }</td>
        <td>${order.orderTel }</td>
        <td>${order.orderAddr }</td>
         <td>￥${order.orderPrice/10}元</td>
        <td>
        <c:choose>
        <c:when test="${order.orderAccept==1}">
        	 <button class="btn btn-primary btn-xs" 
                onclick='onBtnChangeClick("id=${order.orderId}&opt=orderUnAccept&page=${currPage}");'>
                取消处理
            </button>
        </c:when>
        <c:otherwise>
        	<button class="btn btn-primary btn-xs" 
                onclick='onBtnChangeClick("id=${order.orderId}&opt=orderAccept&page=${currPage}");'>
                处理
            </button>
        </c:otherwise>
        </c:choose>
            <button class="btn btn-primary btn-xs" 
                onclick='onBtnChangeClick("id=${order.orderId}&opt=orderDel&page=${currPage}");'>
                删除
            </button>
        </td>
    </tr>
    </c:forEach>
</table>
</br>

<%-- the pagination --%>
<%@ include file="/WEB-INF/jsp/pagination.jsp" %>
