<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- include the jstl --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 style="text-align:center">购物车列表</h1>
<table class="table">
	<tr>
		<th>菜单</th>
		<th>价格</th>
		<th>数量</th>
		<th>总价</th>
		<th>操作</th>
		<th>备注</th>
	</tr>
	<c:forEach var="detail" items="${details }">
		<tr>
			<td>${detail.menuName }</td>
			<td>￥${detail.menuPrice/10 }元</td>
			<td>${detail.num}</td>
			<td>￥${detail.totalPrice/10 }元</td>
			<td>
				<button class="btn btn-primary btn-xs"
					onclick='onBtnChangeClick("menuId=${detail.menuId }&opt=Inc&page=${currPage}");'>
					+</button>
				<button class="btn btn-primary btn-xs"
					onclick='onBtnChangeClick("menuId=${detail.menuId }&opt=Dec&page=${currPage}");'>
					-</button>
				<button class="btn btn-primary btn-xs"
					onclick='onBtnChangeClick("menuId=${detail.menuId }&opt=Del&page=${currPage}");'>
					x</button></td>
			<td><input type="text" menuName='${detail.menuName }'
				remark='${detail.remark }'
				onblur='onInputRemarkChange("menuId=${detail.menuId }&opt=remarkChange&page=${currPage}");'
				class=" form-control ib_shop_remark_input" value="${detail.remark }" />
			</td>
		</tr>
	</c:forEach>
</table>
</br>
<form action="/shoppingSubmit" method="post">
	<div class="input-group">
		<span id="ib_shop_price_span" class="input-group-addon">总价</span> <input
			type="text" address='totalPrice' id="ib_shop_price_input"
			class="form-control" value="￥${totalPrice/10 }元" readOnly="true" />
		<input type="hidden" name="orderPrice" value="${totalPrice}">
		<span >优惠券：<select>
		<option value="0">未使用优惠券</option>
		<c:forEach var="coupon" items="${coupons }">
					<option value="${coupon.couponDiscount }">${coupon.couponName}</option></c:forEach>
				</select>
		</span>
	</div>
	</br>
	<div class="input-group">
		<span id="ib_shop_addr_span" class="input-group-addon">收货人姓名</span> <input
			type="text" name="orderUserName" address="strAddress"
			id="ib_shop_addr_input" class="form-control"
			<%-- onblur='onInputAddrChange("opt=addrChange&page=${currPage}");' --%>
        value="${sessionScope.user.userName }"
			readOnly="true" />
	</div>
	</br>
	<div class="input-group">
		<span id="ib_shop_addr_span" class="input-group-addon">收货地址</span> <input
			type="text" name="orderAddr" address="strAddress"
			id="ib_shop_addr_input" class="form-control"
			<%-- onblur='onInputAddrChange("opt=addrChange&page=${currPage}");' --%>
        value="${sessionScope.user.userAddr }" />
	</div>

	</br>
	<div class="input-group">
		<span id="ib_shop_addr_span" class="input-group-addon">联系电话</span> <input
			type="text" name="orderTel" address="strAddress"
			id="ib_shop_addr_input" class="form-control"
			<%-- onblur='onInputAddrChange("opt=addrChange&page=${currPage}");' --%>
        value="${sessionScope.user.userTel }" />
	</div>
	</br>
	<c:if test="${totalPrice > 0 }">
		<div id="ib_shop_submit">
			<!--  <a href="shoppingSubmit" class="btn btn-primary" role="button">
            提交
        </a> -->
			<input type="submit" class="btn btn-primary" value="提交" />
		</div>
	</c:if>
</form>
<%-- the pagination --%>
<%@ include file="/WEB-INF/jsp/pagination.jsp"%>
