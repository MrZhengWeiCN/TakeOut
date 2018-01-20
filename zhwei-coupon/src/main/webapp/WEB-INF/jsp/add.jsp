<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>优惠券添加</title>
    
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
    <form action="/addProcess" method="post">
    	couponName：<input type="text" name="couponName" /> <br>
    	couponDesc：<input type="text" name="couponDesc" /> <br>
    	couponStartTime：<input type="datetime" name="couponStartTime" /> <br>
    	couponEndTime：<input type="datetime" name="couponEndTime" /> <br>
    	couponDiscount：<input type="text" name="couponDiscount" /> <br>
    	couponThreshold：<input type="text" name="couponThreshold" /> <br>
    	couponNum：<input type="text" name="couponNum" /> <br>
    	couponKilltime：<input type="datetime" name="couponKilltime" /> <br>
    	<input type="submit" value="提交"> 
    </form>
  </body>
</html>
