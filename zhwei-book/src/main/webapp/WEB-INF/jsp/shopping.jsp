<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<link rel="shortcut icon" href="/image/shopCar.png">
<%-- the header --%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<title>购物车</title>

<script type="text/javascript">
         window.onload = function () {
             document.getElementById('discount').addEventListener('change',function(){
              var totalprice = document.getElementById('oldPrice').value;
 			  var index = this.selectedIndex;
 			  var store_num = this.options[index].getAttribute("discount"); 
              var left = totalprice - store_num;
              document.getElementById('hidePrice').value = left;
              document.getElementById('ib_shop_price_input').value = "￥"+left/10+"元";
             },false);
         }
     </script>

</head>
<body>
	<%-- the navbar --%>
	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>

	<div id="ib_shop_content_div">
		<%@ include file="/WEB-INF/jsp/shopping_content.jsp"%>
	</div>

	<%-- the javascript --%>
	<script type="text/javascript">
		function fnChangeFinish(data, code, request) {
			setTimeout(function() {
				window.location.reload();//页面刷新
			}, 1000)
		}

		function onBtnChangeClick(data) {
			var ajaxUrl = "shoppingChange";

			jQuery
					.ajax({
						type : "POST",
						url : ajaxUrl,
						data : data,
						dataType : "html",
						contentType : "application/x-www-form-urlencoded; charset=utf-8",
						success : fnChangeFinish
					});
		}

		function onInputRemarkChange(data) {
			var ajaxUrl = "shoppingChange";

			var menuId = data.match(/menuId=(.+)&opt=remarkChange/);
			if (menuId != null && menuId[1] != null) {
				$(".ib_shop_remark_input")
						.each(
								function() {
									if (/* $(this).attr("menuId") == menuId[1]
											&& */ $(this).attr("remark") != $(this)
													.val()) {
										data = data + "&remark="
												+ $(this).val();

										jQuery
												.ajax({
													type : "POST",
													url : ajaxUrl,
													data : data,
													dataType : "html",
													contentType : "application/x-www-form-urlencoded; charset=utf-8",
													success : fnChangeFinish
												});
									}
								});
			}
		}
		
		
		function onInputAddrChange(data) {
			var ajaxUrl = "shoppingChange";

			if ($("#ib_shop_addr_input").attr("address") != $(
					"#ib_shop_addr_input").val()) {
				data = data + "&address=" + $("#ib_shop_addr_input").val();

				jQuery
						.ajax({
							type : "POST",
							url : ajaxUrl,
							data : data,
							dataType : "html",
							contentType : "application/x-www-form-urlencoded; charset=utf-8",
							success : fnChangeFinish
						});
			}
		}
	</script>

</body>
</html>