<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%-- the header --%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<title><s:text name="indexTitle" /></title>
</head>
<body>
	<%-- the navbar --%>
	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>

	<div id="ib_idx_content_div">
		<!-- 展示一下菜单 -->
		<%-- <s:iterator value="lstMenuTypeBean" id="bean"> --%>
		<div class="row">
			<!-- 分类名 -->
			<h2 class="ib_idx_caption_h">${classify.name }</h2>
			<!-- 开始一个一个菜品 -->
			<c:forEach var="food" items="foods">
				<div class="col-md-3">
					<div class="thumbnail">
						<img src="${food.image }">
						<h4 class="ib_idx_caption_h">${food.name }</h4>
						<h5 class="ib_idx_caption_h">价格: ${food.price }</h5>
						<p class="ib_idx_caption_h">
							<button class="btn btn-primary" menuName='${food.name }'
								menuPrice='${food.price }'>
								下单！ <span class="badge">${food.amount } </span>
							</button>
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