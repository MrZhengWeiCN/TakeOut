<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

    <head>
        <%-- the header --%>
        <%@ include file="/WEB-INF/jsp/header.jsp" %>

        <title>注册成功</title>
    </head>
 
  
  <body>
  	<%-- the navbar --%>
        <%@ include file="/WEB-INF/jsp/navbar.jsp" %>
    <h3>${sucInfo }</h3><br>
    <a href="${clickURL }"><strong>${click }</strong></a>还是
    <a href="${OclickURL }"><strong>${Oclick }</strong></a>？
  </body>
</html>
