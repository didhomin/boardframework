<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
 <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<style type="text/css">
body {
	margin: 10px auto;
}

.board_list {
	width: 300px;
}

.category_name {
	padding: 5px 10px;
	cursor: pointer;
	position: relative;
	margin: 2px;
	font-weight: bold;
	text-align: left;
	background-color: #555;
}

.board_name {
	display: none;
	text-align: left;
}

.board_name a {
	display: block;
	color: #888;
	background-color: #e3e3e3;
	padding-left: 10px;
	text-decoration: none;
}

.board_name a:hover {
	color: #000000;
	text-decoration: underline;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("#boardmenu p.category_name").click(function() {
			$(this).next("div.board_name").slideDown(1000).siblings("div.board_name").slideUp("slow");
		});
	});
</script>
<div align="right">
			<a href="${root}/boardadmin?act=mvadmin">관리자</a>
		</div>
		<div class="board_list" id="boardmenu">
		<c:set var="ccode" value="0"/>
		<c:forEach var="boardListDto" items="${boardmenu}" varStatus="i">
			<c:if test="${ccode != boardListDto.ccode }">
				<c:set var="ccode" value="${boardListDto.ccode }"/>
				<p class="category_name">${boardListDto.cname}</p>
				<div class="board_name">
			</c:if>
			<a href="${root}/${boardListDto.control}/list.html?bcode=${boardListDto.bcode}&pg=1&key=&word="><img
				src="${root}/img/board/ico-m-${boardListDto.btype}.gif">
				${boardListDto.getBname()}</a>
				<c:if test="${i.index < boardmenu.size() -1 }">
					<c:if test="${ccode != boardmenu.get(i.index+1).ccode }">
						</div>
					</c:if>
				</c:if>
		</c:forEach>
		</div>
		</div>
		
		
		