<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- include the jstl --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <tr>
        <th>菜名</th>
        <th>价格</th>
        <th>数量</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    <tr>
        <td>
            <input type="text" 
                id="ib_man_orderdetail_new_menu_input"
                class="form-control" 
                value=""
                readOnly="true" />
        </td>
        <td>
            <input type="text" 
                id="ib_man_orderdetail_new_price_input"
                class="form-control" 
                value=""
                readOnly="true" />
        </td>
        <td>
            <input type="text" 
                id="ib_man_orderdetail_new_amount_input"
                class="form-control" 
                value=""
                readOnly="true" />
        </td>
        <td>
            <input type="text" 
                id="ib_man_orderdetail_new_remark_input"
                class="form-control" 
                value=""
                readOnly="true" />
        </td>
        <td>
            <button class="btn btn-primary btn-xs" 
                id="ib_man_orderdetail_new_btn"
                status="new"
                onclick='onBtnNewClick();'>
                新建
            </button>
            <button class="btn btn-primary btn-xs" disabled="disabled"
                id="ib_man_orderdetail_add_btn"
                onclick='onBtnAddClick("orderId=${orderId}&opt=orderDetailAdd");'><!-- 新建的id，一般是传过来的 -->
               增加
            </button>
        </td>
    </tr>
    <!-- 订单条目 -->
    <c:forEach items="${OrderDetails }" var="detail">
    <tr>
        <td>
            <label class="ib_man_orderdetail_id_label" style="display:none">${detail.id }</label>
            <input type="text" 
                class="form-control ib_man_orderdetail_menu_input" 
                value='${detail.manuName }'
                readOnly="true" />
        </td>
        <td>
            <input type="text" 
                class="form-control ib_man_orderdetail_price_input" 
                value='${detail.manuPrice }'
                readOnly="true" />
        </td>
        <td>
            <input type="text" 
                class="form-control ib_man_orderdetail_amount_input" 
                value='${detail.amount }'
                readOnly="true" />
        </td>
        <td>
            <input type="text" 
                class="form-control ib_man_orderdetail_remark_input" 
                value='${detail.remark }'
                readOnly="true" />
        </td>
        <td>
            <button class="btn btn-primary btn-xs" 
                id="ib_man_orderdetail_edit_btn"
                status="edit"
                onclick='onBtnEditClick("${detail.id }");'>
                编辑
            </button>
            <button class="btn btn-primary btn-xs" disabled="disabled"
                id="ib_man_orderdetail_mod_btn"
                onclick='onBtnModClick("id=${detail.id }&orderId=${detail.orderId }&opt=orderDetailMod");'>
                修改
            </button>
            <button class="btn btn-primary btn-xs"
                id="ib_man_orderdetail_del_btn"
                onclick='onBtnDelClick("id=${detail.id }&orderId=${detail.orderId }&opt=orderDetailDel");'>
                删除
            </button>
        </td>
    </tr>
    </c:forEach>
</table>
