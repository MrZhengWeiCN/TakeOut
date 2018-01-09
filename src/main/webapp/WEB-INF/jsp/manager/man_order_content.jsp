<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
    </tr>
  
    <c:forEach var="order" items="${orders }">
    <tr>
        <td>
            <a href='manOrderDetailPageEnter?orderId=${order.id }'>
                ${order.id }
            </a>
        </td>
        <td>${order.username }</td>
        <td>${order.time }</td>
        <td>${order.accept==1?"已处理":"未处理" }</td>
        <td>${order.tel }</td>
        <td>${order.addr }</td>
        <td>
        <c:choose>
        <c:when test="${order.accept==1}">
        	 <button class="btn btn-primary btn-xs" 
                onclick='onBtnChangeClick("id=${order.id}&opt=orderUnAccept&page=${currPage}");'>
                取消处理
            </button>
        </c:when>
        <c:otherwise>
        	<button class="btn btn-primary btn-xs" 
                onclick='onBtnChangeClick("id=${order.id}&opt=orderAccept&page=${currPage}");'>
                处理
            </button>
        </c:otherwise>
        </c:choose>
            <button class="btn btn-primary btn-xs" 
                onclick='onBtnChangeClick("id=${order.id}&opt=orderDel&page=${currPage}");'>
                删除订单
            </button>
        </td>
    </tr>
    </c:forEach>
</table>
</br>

<%-- the pagination --%>
<%@ include file="/WEB-INF/jsp/pagination.jsp" %>
