<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <tr>
        <th>用户名</th>
        <th>密码</th>
        <th>权限</th>
        <th>联系方式</th>
        <th>地址</th>
        <th>操作</th>
    </tr>
    <tr>
        <td>
            <input type="text" 
                id="ib_man_user_new_user_input"
                class="form-control" 
                value=""
                readOnly="true" />
        </td>
        <td>
            <input type="text" 
                id="ib_man_user_new_passwd_input"
                class="form-control" 
                value=""
                readOnly="true" />
        </td>
        <td>
            <select id="ib_man_user_new_auth_select" class="form-control" disabled="disabled">
                <option value="customer" selected="selected">顾客</option>
                <option value="admin">管理员</option>
            </select>
        </td>
        <td>
            <input type="text" 
                id="ib_man_user_new_tel_input"
                class="form-control" 
                value=""
                readOnly="true" />
        </td>
        <td>
            <input type="text" 
                id="ib_man_user_new_addr_input"
                class="form-control" 
                value=""
                readOnly="true" />
        </td>
        <td>
            <button class="btn btn-primary btn-xs" 
                id="ib_man_user_new_btn"
                status="new"
                onclick='onBtnNewClick();'>
                新建
            </button>
            <button class="btn btn-primary btn-xs" disabled="disabled"
                id="ib_man_user_add_btn"
                onclick='onBtnAddClick("opt=userAdd&page=${currPage}");'>
               添加
            </button>
        </td>
    </tr>
    <c:forEach items="${users }" var="user">
    <tr>
        <td>
            <label class="ib_man_user_id_label" style="display:none">${user.id }</label>
            <input type="text" 
                class="form-control ib_man_user_user_input" 
                value='${user.name }'
                readOnly="true" />
        </td>
        <td>
            <input type="text" 
                class="form-control ib_man_user_passwd_input" 
                value='${user.password }'
                readOnly="true" />
        </td>
        <td>
            <select class="form-control ib_man_user_auth_select" disabled="disabled">
            <c:choose>
            	<c:when test="${user.auth== 'customer' }">
            		<option value="customer" selected="selected">顾客</option>
                    <option value="admin">管理员</option>
            	</c:when>
            	<c:otherwise>
            		<option value="customer">顾客</option>
                    <option value="admin" selected="selected">管理员</option>
            	</c:otherwise>
            </c:choose>
            </select>
        </td>
        <td>
            <input type="text" 
                class="form-control ib_man_user_tel_input" 
                value='${user.tel }'
                readOnly="true" />
        </td>
        <td>
            <input type="text" 
                class="form-control ib_man_user_addr_input" 
                value='${user.addr }'
                readOnly="true" />
        </td>
        <td>
            <button class="btn btn-primary btn-xs" 
                id="ib_man_user_edit_btn"
                status="edit"
                onclick='onBtnEditClick("${user.id }");'>
                编辑
            </button>
            <button class="btn btn-primary btn-xs" disabled="disabled"
                id="ib_man_user_mod_btn"
                onclick='onBtnModClick("id=${user.id }&opt=userMod&page=${currPage}");'>
                修改
            </button>
            <button class="btn btn-primary btn-xs"
                id="ib_man_user_del_btn"
                onclick='onBtnDelClick("id=${user.id }&opt=userDel&page=${currPage}");'>
               删除
            </button>
        </td>
    </tr>
    </c:forEach>
</table>

<%-- the pagination --%>
<%@ include file="/WEB-INF/jsp/pagination.jsp" %>
