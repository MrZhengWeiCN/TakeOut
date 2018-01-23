<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<!-- saved from url=(0032)http://www.jq22.com/message12048 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="/css/font-awesome.min.css" rel="stylesheet" media="screen">
<link rel="stylesheet" type="text/css" href="/css/wangEditor.css">
<link type="text/css" rel="stylesheet" href="/css/shCoreEclipse.css">
<link rel="stylesheet" type="text/css" href="/css/pifu.css">
<!--[if lt IE 9]>
 	<script src="/js/respond.min.js"></script> 
	<script src="/js/html5shiv.min.js"></script>    
<![endif]-->
<link href="/css/my.css" rel="stylesheet" media="screen">
<link href="/css/dl.css" rel="stylesheet" media="screen">
<script src="/js/hm.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script>
	var n = 1;
</script>
<script src="/js/m.js"></script>

<%@ include file="/WEB-INF/jsp/header.jsp"%>

<style>
.project-header p {
	line-height: 30px
}

.project-header h1 {
	line-height: 50px
}

.project-content {
	padding-right: 3.1%;
	padding-left: 3.1%;
	background-color: #fff;
	padding-top: 10px;
}

.pl .plul {
	word-wrap: break-word;
	width: 100%;
	padding-top: 10px;
	padding-bottom: 10px;
	font-size: 14px;
	background-color: #fafafa;
}

.z13 {
	font-size: 13px
}

.plbg {
	background-color: #fafafa;
	border-bottom: 1px dotted #DCDCDC;
}

.pl {
	padding: 0px;
}

a {
	color: #000;
	text-decoration: none;
}

a:hover {
	color: #337ab7;
	text-decoration: none;
}

.project-header .yw {
	color: #009ade
}

.in100,.in2,.huif {
	border-top: 0px
}

.huif {
	padding-top: 0px
}

.y {
	animation-delay: 2s;
	animation: move 3s infinite;
}

@
keyframes move { 0%{
	border: 1px solid #e8e8e8;
}

50%{
border


:

 

1
px

 

solid

 

#f96c65


;
}
100%{
border


:

 

1
px

 

solid

 

#e8e8e8


;
}
}
.zuo h4 {
	line-height: 36px;
	font-size: 16px;
	font-weight: bold
}

.zuo a {
	display: block;
	line-height: 26px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.project-header2 {
	width: 921px;
	border-bottom: 1px solid #e8e8e8;
	border-radius: 3px 3px 0 0;
	border-top: 1px solid #fff;
	height: auto;
	margin: auto;
	padding: 20px 25px 0;
	z-index: 9;
	background-color: #fff
}

.affix-top {
	top: 121px
}

.adcssb {
	border: 1px solid #93d0a8
}

.foot a {
	color: #337ab7
}
</style>

</head>
<body data-spy="scroll" data-target=".navbar-example"
	style="background-color: rgb(244, 244, 244);">

	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>
	<%-- the navbar --%>
	<script type="text/javascript">
	function login() {
            $.ajax({
            //几个参数需要注意一下
                type: "POST",//方法类型 dataType: "json",//预期服务器返回的数据类型
				url: "/makeComment" ,//url
				data: $('#form1').serialize(),
                success:function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.status==
						200) {
                        alert("发表评论成功！");
                        window.location.reload();
                    }else
						alert(result.msg);
                    ;
                },
                error:function() {
                    alert("异常！");
                }
            });
        }
        
    function del(data){
           if(confirm("确定删除该评论吗？")){
           $.ajax({
                type: "POST",//方法类型 dataType: "json",//预期服务器返回的数据类型
			    url: "/delComment" ,//url
			    data: data,
                success:function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.status==
						200) {
                        alert("删除评论成功！");
                        window.location.reload();
                    }else
						alert(result.msg);
                    ;
                },
                error:function() {
                    alert("异常！");
                }
            });
        	}
        }
        
</script>
	<div id="ib_idx_content_div">
		<!-- 展示一下菜单 -->
		<div class="row">
			<div style="width:1100px;height:500px" align="center">
				<div class="thumbnail">
					<img src="${menu.menuPicAddr }" width="400"
						height="300>
					<h4 class="ib_idx_caption_h">${menu.menuName }</h4>
					<h5 class="ib_idx_caption_h">价格:￥${menu.menuPrice/10 }元</h5>
					<p class="ib_idx_caption_h">
						<a
							href="/menuSubmit?menuName=${menu.menuName }&menuId=${menu.menuId }&menuPrice=${menu.menuPrice }"
							class="btn btn-primary">加入购物车</a>
					</p>
				</div>
			</div>
		</div>
		</div>


		<div class="container m0 bod top70" id="zt">

			<div class="col-lg-9 col-md-12 col-sm-12">

				<div class="project">
					<div class="project-content">
						<c:forEach items="${comments }" var="comment" varStatus="i">
							<div class="pl  ">
								<div class="tx"> 
									<img src="/image/24.png"></a>
								</div>
								<ul class="plbg">
									<div class="f z13">
										${comment.userName }&nbsp;&nbsp;&nbsp;&nbsp;(${i.index+1}楼)<span
											class="jl">0</span>
									</div>
									<div class="r">
										<span class="z13"><fmt:formatDate
												value="${comment.commentDate }"
												pattern="yyyy/MM/dd HH:mm:ss" /></span>
									</div>
									<div class="dr"></div>
								</ul>
								<ul class="plul">
									<p>${comment.commentContent }</p>
									<!-- <ul>
									<div class="pl ">
										<div class="tx tx2">
											<img src="/image/0.png"> </a>
										</div>
										<ul class="plbg plbg2">
											<div class="f">
												流景扬辉<span class="jl">0</span>
											</div>
											<div class="r">
												<span class="z12">2017/11/2 14:04:49</span>
											</div>
											<div class="dr"></div>
										</ul>
										<ul
											style="padding-top: 10px; padding-bottom: 10px;word-wrap: break-word;width: 100%">
											<p>斯蒂芬</p>
										</ul>
									</div>
								</ul> -->
								<c:choose>
									<c:when test="${sessionScope.user!=null&&sessionScope.user.userId==comment.userId}">
										<a class="hf" name="455fr" onclick="del('menuId=${comment.menuId}&userId=${sessionScope.user.userId}')">删除</a><a class="hf" name="45517">编辑&nbsp;&nbsp;&nbsp;&nbsp;</a>
									</c:when>
									<c:otherwise>
									<a class="hf" name="45517">回复</a>
									</c:otherwise>
								</c:choose>
									<div class="lyhf"></div>

									<div class="dr"></div>
								</ul>
							</div>
						</c:forEach>
					<h4 name="a1">写下你的评价</h4>
					
					
					<form id="form1" action="/makeComment" method="post" align="center">
						<input type="hidden" name="userId"
							value="${sessionScope.user.userId }"> <input
							type="hidden" name="userName"
							value="${sessionScope.user.userName}"> <input
							type="hidden" name="menuId" value="${menu.menuId}"> <input
							type="hidden" name="menuName" value="${menu.menuName}">
						<textarea rows="4" cols="92" name="commentContent"></textarea>
						<br> <input type="button" value="发表评论" onclick="login()">
					</form>


				</div>
				<%-- the pagination --%>
				<%@ include file="/WEB-INF/jsp/pagination.jsp"%>
			</div>
		</div>
	</div>



</body>
</html>