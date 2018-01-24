<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			type : "POST",
			url : "autoLog",
			dataType:"json",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			success:function(data){
				
			}
		});
	})
</script>
<nav id="ib_navbar_nav" class="navbar navbar-default navbar-fixed-top"
	role="navigation">
	<div class="container">
		<a href="/" id="ib_navbar_link_index_a" class="navbar-brand">重庆大学点餐系统</a>
		<ul class="nav navbar-nav navbar-right">

			<li class="dropdown"><a href="#" id="ib_navbar_manager_menu_a"
				class="dropdown-toggle" data-toggle="dropdown"> 菜品分类 <span
					class="caret"></span> </a>
				<ul class="dropdown-menu" role="menu">
					<li><a href="/">全部</a>
					</li>
					<c:forEach items="${sessionScope.types }" var="type">
						<li><a href="/${type.menuTypeId}">${type.menuTypeName}(${type.menuTypeNum})</a>
						</li>
					</c:forEach>
				</ul></li>
			<!-- 登陆的是管理员 -->
			<c:if test="${sessionScope.user.userAuth=='0'}">
				<li class="dropdown"><a href="#" id="ib_navbar_manager_menu_a"
					class="dropdown-toggle" data-toggle="dropdown"> 管理 <span
						class="caret"></span> </a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/manUserPageEnter">用户管理</a>
						</li>
						<li><a href="/manOrderPageEnter">订单管理</a>
						</li>
						<li><a href="/manMenuPageEnter">菜单管理</a>
						</li>
						<li><a href="/manMenuTypePageEnter">菜品类型管理</a>
						</li>
						<li><a href="/manCouponPageEnter">优惠券管理</a>
						</li>
						<li><a href="/manCommentPageEnter">评论券管理</a>
						</li>
					</ul></li>
			</c:if>
			<li><a href="/coupon" id="ib_navbar_reg_a" class="navbar-link">
					领卷中心 </a></li>
			<!-- 如果用户已经登陆 -->
			<c:if test="${sessionScope.user!=null}">
				<li class="dropdown"><a href="#" id="ib_navbar_option_menu_a"
					class="dropdown-toggle" data-toggle="dropdown"> 选项 <span
						class="caret"></span> </a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/shoppingPageEnter">购物车</a>
						</li>
						<li><a
							href="/orderListPageEnter/${sessionScope.user.userName }">订单列表</a>
						</li>
						<li><a href="/mycoupon/${sessionScope.user.userId }">优惠券列表</a>
						</li>
						<li class="divider"></li>
						<li><a href="/perInfoPageEnter">个人信息</a>
						</li>
					</ul></li>
			</c:if>
			<c:choose>
				<c:when test="${sessionScope.user==null}">
					<li><a href="/loginPageEnter" id="ib_navbar_login_a"
						class="navbar-link"> 登陆 </a></li>
				</c:when>
				<c:otherwise>

					<li><a href="/logoutProcess" id="ib_navbar_login_a"
						class="navbar-link"> 注销 </a></li>
				</c:otherwise>
			</c:choose>
			<li><a href="/regPageEnter" id="ib_navbar_reg_a"
				class="navbar-link"> 注册 </a></li>
			<li><a href="/perInfoPageEnter" id="ib_navbar_reg_a"
				class="navbar-link"> ${sessionScope.user.userName} </a></li>
		</ul>
	</div>
</nav>
