<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- include the jstl --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <tr>
        <th>菜单</th>
        <th>价格</th>
        <th>数量</th>
        <th>操作</th>
        <th>备注</th>
    </tr>
    <c:forEach var="menu" items="shopMenu">
    <tr>
        <td><%-- ${menu.name } --%>鱼香肉丝</td>
        <td><%-- ${menu.price } --%>5元</td>
        <td><%-- ${menu.amount } --%>1</td>
        <td>
            <button class="btn btn-primary btn-xs" 
                 onclick='onBtnChangeClick("menuName=名字&opt=amountInc&page=${currPage}");'>
                +
            </button>
            <button class="btn btn-primary btn-xs" 
                onclick='onBtnChangeClick("menuName=<%-- ${menu.name } --%>&opt=amountDec&page=${currPage}");'>
                -
            </button>
            <button class="btn btn-primary btn-xs" 
                onclick='onBtnChangeClick("menuName=<%-- ${menu.name } --%>&opt=amountDel&page=${currPage}");'>
                x
            </button>
        </td>
        <td>
            <input type="text" 
                menuName='<%-- ${menu.name } --%>' 
                remark='<%-- ${menu.remark } --%>' 
                onblur='onInputRemarkChange("menuName=<%-- ${menu.name } --%>&opt=remarkChange&page=${currPage}");'
                class="form-control ib_shop_remark_input" value="<%-- ${menu.remark } --%>" />
        </td>
    </tr>
    </c:forEach>
</table>
</br>
<div class="input-group">
    <span id="ib_shop_price_span" class="input-group-addon">总价</span>
    <input type="text" 
        address='totalPrice' 
        id="ib_shop_price_input"
        class="form-control" 
        value="${totalPrice }"
        readOnly="true" />
</div>
</br>
<div class="input-group">
    <span id="ib_shop_addr_span" class="input-group-addon">收货地址</span>
    <input type="text" 
        address="strAddress" 
        id="ib_shop_addr_input"
        class="form-control" 
        onblur='onInputAddrChange("opt=addrChange&page=${currPage}");'
        value="默认收货地址" />
</div>
</br>
<c:if test="${totalPrice > 0 }">
    <div id="ib_shop_submit">
        <a href="shoppingSubmit" class="btn btn-primary" role="button">
            提交
        </a>
    </div>
</c:if>

<%-- the pagination --%>
<%@ include file="/WEB-INF/jsp/pagination.jsp" %>
