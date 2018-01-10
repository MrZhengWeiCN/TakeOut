<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <%-- the header --%>
        <%@ include file="/WEB-INF/jsp/header.jsp" %>

        <title>用户注册</title>
    </head>
    <body>
        <%-- the navbar --%>
        <%@ include file="/WEB-INF/jsp/navbar.jsp" %>

        <%-- the content --%>
        <div class="container">
            <form method="post" id="ib_reg_form" action="regProcess" role="form">
                <div class="form-group">
                    <label for="ib_reg_user_input" id="ib_reg_label">
                        请填写用户信息
                    </label><br>
                    <input type="hidden" name="userAuth" value="1" />
                    <input type="text" id="ib_reg_user_input" name="userName" class="form-control input-lg" placeholder="用户名"/><br>
                    <br>
                    <input type="password" id="ib_reg_passwd_input" name="userPasswd" class="form-control input-lg" placeholder="密码"/><br>
                    <br>
                    <input type="text" id="ib_reg_tel_input" name="userTel" class="form-control input-lg" placeholder="手机号码"/><br>
                    <br>
                    <input type="text" id="ib_reg_addr_input" name="userAddr" class="form-control input-lg" placeholder="地址"/>
                    <div class="ib_reg_error_div">
                        ${registerError }
                    </div>
                </div>
                <button id="ib_reg_submit_btn" type="submit" class="btn btn-primary btn-lg btn-block">
                   立即注册
                </button>
            </form>
        </div>

        <%-- the javascript --%>
        <script type="text/javascript">
            $("#ib_reg_submit_btn").click(
                function() {
                    if ($("#ib_reg_user_input").val() == "" || $("#ib_reg_passwd_input").val() == ""
                        || $("#ib_reg_tel_input").val() == "" || $("#ib_reg_addr_input").val() == "") {
                        alert("请填写所有项目信息！");
                        return false;
                    }
                }
            )
        </script>

    </body>
</html>