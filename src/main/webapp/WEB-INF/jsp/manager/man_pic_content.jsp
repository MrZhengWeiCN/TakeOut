<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%-- include the jstl --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<form name="addPic" action="manPicUpload" method="post" enctype="multipart/form-data">
		图片名: <input type="text" name="name"><br> 
		图片：<input type="file" name="imageEntity"><br>
		<input type="submit" value="提交">
	<form>
</div>

</br></br>

<div class="row">
<c:forEach var="pic" items="${pictures}">
    <div class="col-md-3">
        <div class="thumbnail">
            <img src="${pic.addr}">
            <h4 class="ib_man_pic_caption_h">${pic.name}</h4>
            <p class="ib_man_pic_caption_h">
                <button class="btn btn-primary" 
                    id="ib_man_pic_del_btn"
                    onclick='onBtnDelClick("name=${pic.name}&addr=${pic.addr}&opt=picDel&page=${currPage}");'>
                    删除</span>
                </button>
            </p>
        </div>
    </div>
</c:forEach>
</div>

<%-- the pagination --%>
<%@ include file="/WEB-INF/jsp/pagination.jsp" %>
