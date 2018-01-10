<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%-- include the jstl --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <tr>
        <th>菜品类型</th>
        <th>操作</th>
    </tr>
    <tr>
        <td>
            <input type="text" 
                id="ib_man_menu_type_new_name_input"
                class="form-control" 
                value=""
                readOnly="true" />
        </td>
        <td>
            <button class="btn btn-primary btn-xs" 
                id="ib_man_menu_type_new_btn"
                status="new"
                onclick='onBtnNewClick();'>
                新建
            </button>
            <button class="btn btn-primary btn-xs" disabled="disabled"
                id="ib_man_menu_type_add_btn"
                onclick='onBtnAddClick("opt=menuTypeAdd&page=${currPage}");'>
                添加
            </button>
        </td>
    </tr>
    <c:forEach var="type" items="${menutypes }">
    <tr>
        <td>
            <label class="ib_man_menu_type_id_label" style="display:none">id</label>
            <input type="text" 
                class="form-control ib_man_menu_type_name_input" 
                value='${type.menuTypeName }'
                readOnly="true" />
        </td>
        <td>
            <button class="btn btn-primary btn-xs" 
                id="ib_man_menu_type_edit_btn"
                status="edit"
                onclick='onBtnEditClick("${type.menuTypeId }");'>
                编辑
            </button>
            <button class="btn btn-primary btn-xs" disabled="disabled"
                id="ib_man_menu_type_mod_btn"
                onclick='onBtnModClick("id=${type.menuTypeId }&opt=menuTypeMod&page=${currPage}");'>
                修改
            </button>
            <button class="btn btn-primary btn-xs"
                id="ib_man_menu_type_del_btn"
                onclick='onBtnDelClick("id=${type.menuTypeId  }&opt=menuTypeDel&page=${currPage}");'>
                删除
            </button>
        </td>
    </tr>
    </c:forEach>
</table>

<%-- the pagination --%>
<%@ include file="/WEB-INF/jsp/pagination.jsp" %>
