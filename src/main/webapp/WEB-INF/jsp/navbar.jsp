<nav id="ib_navbar_nav" class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <a href="indexPageEnter" id="ib_navbar_link_index_a" class="navbar-brand"><s:property value="strTitle" /></a>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${loginUser!='admin'}">
                <li class="dropdown">
                    <a href="#" id="ib_navbar_manager_menu_a" class="dropdown-toggle" data-toggle="dropdown">
                        管理 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="manUserPageEnter">用户管理</a></li>
                        <li><a href="manOrderPageEnter">订单管理</a></li>
                        <li><a href="manPicPageEnter">图片管理</a></li>
                        <li><a href="manMenuPageEnter">菜单管理</a></li>
                        <li><a href="manMenuTypePageEnter">菜单分类管理</a></li>
                        <li><a href="manOptionPageEnter">选项管理</a></li>
                    </ul>
                </li>
            </c:if>
            <!-- 如果用户已经登陆 -->
            <c:if test="${loginUser!=null}">
                <li class="dropdown">
                    <a href="#" id="ib_navbar_option_menu_a" class="dropdown-toggle" data-toggle="dropdown">
                        选项 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="shoppingPageEnter">购买页面</a></li>
                        <li><a href="orderListPageEnter">订单管理</a></li>
                        <li class="divider"></li>
                        <li><a href="perInfoPageEnter">用户管理</a></li>
                    </ul>
                </li>
            </c:if>
            <c:if test="${loginUser==null">
                <li>
                    <a href="loginPageEnter" id="ib_navbar_login_a" class="navbar-link">
                        登陆
                    </a>
                </li>
            </c:if>
            <c:else>
                <li>
                    <a href="logoutProcess" id="ib_navbar_login_a" class="navbar-link">
                       注销
                    </a>
                </li>
            </c:else>
            <li>
                <a href="regPageEnter" id="ib_navbar_reg_a" class="navbar-link">
                   注册
                </a>
            </li>
        </ul>
    </div>
</nav>
