<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%-- the header --%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<title>首页</title>
</head>
<body>
	<%-- the navbar --%>
	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>

	<div id="ib_idx_content_div">
		<!-- 展示一下菜单 -->
		<%-- <s:iterator value="lstMenuTypeBean" id="bean"> --%>
		<div class="row">
			<!-- 分类名 -->
			<h2 class="ib_idx_caption_h">这里是菜品分类${classify.name }</h2>
			<!-- 开始一个一个菜品 -->
			<%-- <c:forEach var="food" items="foods"> --%>
				<div class="col-md-3">
					<div class="thumbnail">
						<img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515482070106&di=db25c1bc4d6a410ed95a9edbd3d40962&imgtype=0&src=http%3A%2F%2Fimg3.redocn.com%2Ftupian%2F20150121%2Fyuxiangrousi_3641848.jpg">
						<h4 class="ib_idx_caption_h">鱼香肉丝${food.name }</h4>
						<h5 class="ib_idx_caption_h">价格: ￥7${food.price }元</h5>
						<p class="ib_idx_caption_h">
							<button class="btn btn-primary" menuName='${food.name }'
								menuPrice='${food.price }'>
								下单 <span class="badge">余量：5${food.amount } </span>
							</button>
						</p>
					</div>
				</div>
			<%-- </c:forEach> --%>
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
							$(this).children("span").text(data);
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
									+ "menuPrice=" + $(this).attr("menuPrice");

							jQuery
									.ajax({
										type : "POST",
										url : ajaxUrl,
										data : ajaxData,
										dataType : "html",
										contentType : "application/x-www-form-urlencoded; charset=utf-8",
										success : fnSubmitBtn
									});
						})
	</script>

</body>
</html>