<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:if test="${empty userInfo}">
<script type="text/javascript">
alert("회원전용입니다 로그인 후 이용하세요.!");
document.location.href="${root}/index.jsp";
</script>
</c:if>