<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <%-- the header --%>
        <%@ include file="/WEB-INF/jsp/header.jsp" %>

        <title>个人信息</title>
    </head>
    <body>
        <%-- the navbar --%>
        <%@ include file="/WEB-INF/jsp/navbar.jsp" %>

        <%-- the content --%>
        <div class="container">
            <form method="post" id="ib_perinfo_form" action="perInfoProcess" role="form">
                <div class="form-group">
                    <label for="ib_perinfo_old_passwd_input" id="ib_perinfo_label">
                        请填写更新的用户信息
                    </label><br>
                    <input type="hidden" name="userId" value="${sessionScope.user.userId }"/>
                    <input type="hidden" name="userAuth" value="${sessionScope.user.userAuth  }"/>
                    <input type="text" id="ib_perinfo_new_user_input" name="userName" class="form-control input-lg" value="${sessionScope.user.userName}" readOnly="true"/>
                    <br>
                    <input type="password" id="ib_perinfo_old_passwd_input" name="userOldPasswd" class="form-control input-lg" placeholder="旧密码" />
                    <br>
                    <input type="password" id="ib_perinfo_new_passwd_input" name="userPasswd" class="form-control input-lg" placeholder="新密码" />
                    <br>
                    <input type="text" id="ib_perinfo_new_tel_input" name="userTel" class="form-control input-lg" placeholder="新号码？${sessionScope.user.userTel}" />
                    <br>
                    <input type="text" id="ib_perinfo_new_addr_input" name="userAddr" class="form-control input-lg" placeholder="新地址？${sessionScope.user.userAddr}" />
                    <br>
                    <span><strong>${perInfoError }</strong></span>
                </div>
                <button id="ib_perinfo_submit_btn" type="submit" class="btn btn-primary btn-lg btn-block">
                    提交
                </button>
            </form>
        </div>

        <%-- the javascript --%>
        <script type="text/javascript">
            $("#ib_perinfo_submit_btn").click(
                function() {
                    if ($("#ib_perinfo_old_passwd_input").val() == "" 
                        || $("#ib_perinfo_new_user_input").val() == ""
                        || $("#ib_perinfo_new_passwd_input").val() == "" 
                        || $("#ib_perinfo_new_tel_input").val() == "" 
                        || $("#ib_perinfo_new_addr_input").val() == "") {
                        alert("请填写所有项目信息！");
                        return false;
                    }
                }
            )
        </script>

    </body>
</html>