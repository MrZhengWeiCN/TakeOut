<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%@ include file="/WEB-INF/jsp/header.jsp"%>
<title>评论列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<script type="text/javascript">
	function onBtnDelClick(data){
	if(window.confirm("删除后不可恢复，确定删除？")){
		var ajaxUrl = "/manDelComment";
		jQuery.ajax({
			type : "POST",
			url : ajaxUrl,
			data : data,
			dataType : "json",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			success : function(data) {
				if (data.status == 200) {
					alert("删除成功！");
				} else {
					alert(data.msg);
				}
				window.location.reload();
			}
		});
	}
	}
</script>

	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>
	<h1 style="text-align:center">评论列表</h1>
	

	
	<table class="table">
		<tr>
			<th>序号</th>
			<th>评论菜品</th>
			<th>评论人</th>
			<th>内容</th>
			<th>评论时间</th>
			<th>是否根评论</th>
			<th>操作</th>
		</tr>

		<c:forEach items="${comments }" var="comment" varStatus="i">
			<tr>
				<td>${i.index+1 }</td>
				<td>${comment.menuName }</td>
				<td>${comment.userName }</td>
				<td><textarea style="resize:none;font-size:50%" readOnly="true">${comment.commentContent }</textarea></td>
				<td><fmt:formatDate value="${comment.commentDate}"
						pattern="yyyy/MM/dd HH:mm:ss" />
				</td>
				<td>${comment.commentParentid==0?"是":"否"}</td>
				<td>
					<button class="btn btn-primary btn-xs"
						onclick='onBtnDelClick("commentId=${comment.commentId }");'>
						x</button></td>

			</tr>
		</c:forEach>
	</table>
	</br>
	<%@ include file="/WEB-INF/jsp/pagination.jsp"%>	
</body>
</html>
