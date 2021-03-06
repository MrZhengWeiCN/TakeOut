<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<link rel="shortcut icon" href="/image/takeoutlogo.png">
<%-- the header --%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<title>首页</title>
</head>
<body>
	<%-- the navbar --%>
	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>
	<%@ include file="/WEB-INF/jsp/search.jsp"%>

	&nbsp;&nbsp;大家都在搜：
	<c:forEach items="${wordRanges}" var="wordRange">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/search?keyword=${wordRange}">${wordRange }
	</c:forEach>

	<div id="ib_idx_content_div">
		<!-- 展示一下菜单 -->
		<div class="row">
			<!-- 分类名 -->
			<h2 class="ib_idx_caption_h">${type==null?"全部": type.menuTypeName }</h2>
			<!-- 开始一个一个菜品 -->
			<c:forEach var="menu" items="${menus}">
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="/menu/${menu.menuId }"><img src="${menu.menuPicAddr }" ></a>
						<a href="/menu/${menu.menuId }"><h4 class="ib_idx_caption_h">${menu.menuName }</h4></a>
						<h5 class="ib_idx_caption_h">价格:￥${menu.menuPrice/10 }元</h5>
						<p class="ib_idx_caption_h">
							<%-- <button class="btn btn-primary" menuName='${menu.menuName }' menuId="${menu.menuId }"
								menuPrice='${menu.menuPrice }'>
								下单 <span class="badge">余量</span>
							</button> --%>
							<a href="/menuSubmit?menuName=${menu.menuName }&menuId=${menu.menuId }&menuPrice=${menu.menuPrice }" class="btn btn-primary">Shop!</a>
						</p>
					</div>
				</div>
			</c:forEach>
		</div>

		<%-- the pagination --%>
		<%@ include file="/WEB-INF/jsp/pagination.jsp"%>
	</div>

	<%-- the javascript --%>
	<script type="text/javascript">
		function fnSubmitBtn(data, code, request) {
			//exclude the error page
			var menuAmount = data.match(/<!DOCTYPE html>/);
			if (menuAmount == null) {
				var menuName = this.data.match(/menuName=(.+)&/);
				if (menuName != null && menuName[1] != null) {
					$("button").each(function() {
						if ($(this).attr("menuName") == menuName[1]) {
							$(this).children("span").text("done！");
						}
					});
				}
			}
		}

		$("button")
				.click(
						function() {
							var ajaxUrl = "menuSubmit";
							var ajaxData = "menuName="
									+ $(this).attr("menuName") + "&"
									+ "menuPrice=" + $(this).attr("menuPrice")+ "&"+"menuId=" + $(this).attr("menuId");

							jQuery
									.ajax({
										type : "POST",
										url : ajaxUrl,
										data : ajaxData,
										dataType : "html",
										async: false,
										contentType : "application/x-www-form-urlencoded; charset=utf-8",
										success : fnSubmitBtn
									});
						})
	</script>

</body>
</html>