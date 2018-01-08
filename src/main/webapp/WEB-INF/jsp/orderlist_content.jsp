<%-- include the jstl --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <tr>
        <th>订单号</th>
        <th>时间<th>
        <th>订单状态</th>
        <th>操作</th>
    </tr>
    <c:foreach items="${orders }" var="order" status="st">
    <tr>
        <td>
            <a href='orderDetailPageEnter?orderId=${order.id }'>
                ${order.id }
            </a>
        </td>
        <td>${order.time }</td>
        <c:if test="${order.accept==1 }">
            <td>已接收</td>
        </c:if>
        <c:else>
            <td>未接收</td>
        </c:else>
        <c:if test="${order.accept==0 }">
            <td>
                <button class="btn btn-primary btn-xs" 
                    onclick='onBtnDelClick("orderId=${order.id }&opt=orderDel&page=${currPage}");'>
                    删除订单
                </button>
            </td>
        </c:if>
    </tr>
    </c:foreach>
</table>
</br>

<%-- the pagination --%>
<%@ include file="/WEB-INF/jsp/pagination.jsp" %>
