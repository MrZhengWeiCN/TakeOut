<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>
div.search {
	padding: 10px 0;
}

form {
	position: relative;
	width: 300px;
	margin: 0 auto;
}

input,button {
	border: none;
	outline: none;
}

input {
	width: 100%;
	height: 42px;
	padding-left: 13px;
}

button {
	height: 42px;
	width: 42px;
	cursor: pointer;
	position: absolute;
}
/*搜索框6*/
.bar6 input {
	border: 2px solid #c5464a;
	border-radius: 5px;
	background: transparent;
	top: 0;
	right: 0;
}

.bar6 button {
	background: #c5464a;
	border-radius: 0 5px 5px 0;
	width: 60px;
	top: 0;
	right: 0;
}

.bar6 button:before {
	content: "搜索";
	font-size: 13px;
	color: #F9F0DA;
}
</style>
<div id="container">
	<div class="search bar6">
		<form action="/search" method="get">
			<input type="text" placeholder="想要搜索的内容" name="keyword" value=${keyword }>
			<button type="submit"></button>
		</form>
	</div>
</div>