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
    
    <!-- 订单条目 -->
    <c:forEach items="${OrderDetails }" var="detail">
    <tr>
        <td>
            <label class="ib_man_orderdetail_id_label" style="display:none">${detail.detailId }</label>
            <input type="text" 
                class="form-control ib_man_orderdetail_menu_input" 
                value='${detail.detailMenuName }'
                readOnly="true" />
        </td>
        <td>
            <input type="text" 
                class="form-control ib_man_orderdetail_price_input" 
                value='${detail.detailMenuPrice }'
                readOnly="true" />
        </td>
        <td>
            <input type="text" 
                class="form-control ib_man_orderdetail_amount_input" 
                value='${detail.detailAmount }'
                readOnly="true" />
        </td>
        <td>
            <input type="text" 
                class="form-control ib_man_orderdetail_remark_input" 
                value='${detail.detailRemark }'
                readOnly="true" />
        </td>
        <td>
            <button class="btn btn-primary btn-xs" 
                id="ib_man_orderdetail_edit_btn"
                status="edit"
                onclick='onBtnEditClick("${detail.detailId }");'>
                编辑
            </button>
            <button class="btn btn-primary btn-xs" disabled="disabled"
                id="ib_man_orderdetail_mod_btn"
                onclick='onBtnModClick("id=${detail.detailId }&orderId=${detail.detailOrderId }&opt=orderDetailMod");'>
                修改
            </button>
            <button class="btn btn-primary btn-xs"
                id="ib_man_orderdetail_del_btn"
                onclick='onBtnDelClick("id=${detail.detailId }&orderId=${detail.detailOrderId }&opt=orderDetailDel");'>
                删除
            </button>
        </td>
    </tr>
    </c:forEach>
</table>
