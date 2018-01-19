<%-- include the jstl --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<h1 style="text-align:center">优惠券管理</h1>
<table class="table">
	<tr>
		<th>菜名</th>
		<th>价格</th>
		<th>图片</th>
		<th>类型</th>
		<th>操作</th>
	</tr>
	<tr>
		<td><input type="text" id="ib_man_menu_new_name_input"
			class="form-control" value="" readOnly="true" /></td>
		<td><input type="text" id="ib_man_menu_new_price_input"
			class="form-control" value="" readOnly="true" /></td>
		<td><input id="ib_man_menu_new_pic_select" class="form-control"
			disabled="disabled" /></td>
		<td><select id="ib_man_menu_new_type_select" class="form-control"
			disabled="disabled">
				<c:forEach var="type" items="${sessionScope.types }">
					<option value="${type.menuTypeId }">${type.menuTypeName }</option>
				</c:forEach>
		</select></td>
		<td>
			<button class="btn btn-primary btn-xs" id="ib_man_menu_new_btn"
				status="new" onclick='onBtnNewClick();'>新键</button>
			<button class="btn btn-primary btn-xs" disabled="disabled"
				id="ib_man_menu_add_btn"
				onclick='onBtnAddClick("opt=menuAdd&page=${currPage}");'>
				添加</button></td>
	</tr>
	<!-- 展示所有的菜单 -->
	<c:forEach var="menu" items="${menus}">
		<tr>
			<td><label class="ib_man_menu_id_label" style="display:none">${menu.menuId}</label>
				<input type="text" class="form-control ib_man_menu_name_input"
				value='${menu.menuName}' readOnly="true" /></td>
			<td><input type="text"
				class="form-control ib_man_menu_price_input" value='${menu.menuPrice}'
				readOnly="true" /></td>
			<td><input type="text" class="form-control ib_man_menu_pic_select" value='${menu.menuPicAddr}'
				disabled="disabled">
			</td>
			<td><select class="form-control ib_man_menu_type_select"
				disabled="disabled">
					<!-- 所有的菜单类型 -->
					<c:forEach var="type" items="${sessionScope.types }">
						<c:choose>
							<c:when test="${menu.menuTypeId==type.menuTypeId }">
								<option value="${type.menuTypeId }" selected="selected">
									${type.menuTypeName }</option>
							</c:when>
							<c:otherwise>
								<option value="${type.menuTypeId }">${type.menuTypeName }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			</select></td>
			<td>
				<button class="btn btn-primary btn-xs" id="ib_man_menu_edit_btn"
					status="edit" onclick='onBtnEditClick("${menu.menuId}");'>编辑</button>
				<button class="btn btn-primary btn-xs" disabled="disabled"
					id="ib_man_menu_mod_btn"
					onclick='onBtnModClick("id=${menu.menuId}&opt=menuMod&page=${currPage}");'>
					修改</button>
				<button class="btn btn-primary btn-xs" id="ib_man_menu_del_btn"
					onclick='onBtnDelClick("id=${menu.menuId}&opt=menuDel&page=${currPage}");'>
					删除</button></td>
		</tr>
	</c:forEach>
</table>

<%-- the pagination --%>
<%@ include file="/WEB-INF/jsp/pagination.jsp"%>
