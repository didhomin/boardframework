<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/css/skin_purple.css" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
<form id="commonForm" name="comonForm" method="get" action="">
	<input type="hidden" id="bcode" name="bcode">
	<input type="hidden" id="pg" name="pg">
	<input type="hidden" id="key" name="key">
	<input type="hidden" id="word" name="word">
	<input type="hidden" id="seq" name="seq">
</form>
<script type="text/javascript">


function moveWrite() {
	
	document.commonForm.act.value="mvwrite";
	document.commonForm.bcode.value=bcode;
	document.commonForm.pg.value="1";
	document.commonForm.key.value="";
	document.commonForm.word.value="";
	document.commonForm.action=root+control;
	document.commonForm.submit();
	
}
function firstArticle() {
	
	document.commonForm.act.value="list";
	document.commonForm.bcode.value=bcode;
	document.commonForm.pg.value="1";
	document.commonForm.key.value="";
	document.commonForm.word.value="";
	document.commonForm.action=root+control;
	document.commonForm.submit();
	
}

function listArticle(mvpg) {
	
	document.commonForm.act.value="list";
	document.commonForm.bcode.value=bcode;
	document.commonForm.pg.value=mvpg;
	document.commonForm.key.value=key;
	document.commonForm.word.value=word;
	document.commonForm.action=root+control;
	document.commonForm.submit();
	
}

</script>