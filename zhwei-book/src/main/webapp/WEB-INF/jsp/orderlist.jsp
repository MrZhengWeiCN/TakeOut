<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
    <link rel="shortcut icon" href="/image/order.png">
        <%-- the header --%>
        <%@ include file="/WEB-INF/jsp/header.jsp" %>

        <title>订单列表</title>
    </head>
    <body>
        <%-- the navbar --%>
        <%@ include file="/WEB-INF/jsp/navbar.jsp" %>

        <div id="ib_orderlist_content_div">
            <%@ include file="/WEB-INF/jsp/orderlist_content.jsp" %>
        </div>

        <%-- the javascript --%>
        <script type="text/javascript">
            function fnChangeFinish(data, code, request) {
                if (code == "success") {
                    $("#ib_orderlist_content_div").html(data);
                }
            }

            function onBtnDelClick(data) {
                var ajaxUrl = "orderListChange";
 
                jQuery.ajax({
                    type: "POST",
                    url: ajaxUrl,
                    data: data,
                    dataType: "html",
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    success: fnChangeFinish
                });
            }
        </script>

    </body>
</html>