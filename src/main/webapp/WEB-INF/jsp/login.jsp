<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <%-- the header --%>
        <%@ include file="/WEB-INF/jsp/header.jsp" %>

        <title>请登陆</title>
        <!-- 登陆页面是可以做成静态的 -->
    </head>
    <body>
        <%-- the navbar --%>
        <%@ include file="/WEB-INF/jsp/navbar.jsp" %>

        <%-- the content --%>
        <div class="container">
            <form method="post" id="ib_login_form" action="loginProcess" role="form">
                <div class="form-group">
                    <label id="ib_login_label" for="ib_login_user_input">
                        请登录
                    </label>
                    <br>
                  <input type="text" id="ib_login_user_input" name="userName" class="form-control input-lg" placeholder="用户名" />
                    <br>
                    <input type="password" id="ib_login_passwd_input" name="userPasswd" class="form-control input-lg" placeholder="密码" />
                    <div class="ib_login_error_div">
                        <span><strong>错误信息${logError }</strong></span>
                    </div>
                </div>
                <button id="ib_login_submit_btn" type="submit" class="btn btn-primary btn-lg">
                    登陆
                </button>
                <a id="ib_login_reg_btn" href="regPageEnter" class="btn btn-primary btn-lg" role="button">
                    注册
                </a>
            </form>
        </div>

        <%-- the javascript --%>
        <script type="text/javascript">
            $("#ib_login_submit_btn").click(
                function() {
                    if ($("#ib_login_user_input").val() == "" || $("#ib_login_passwd_input").val() == "") {
                        alert("用户名或者密码不能为空！");
                        return false;
                    }
                }
            )
        </script>

    </body>
</html>