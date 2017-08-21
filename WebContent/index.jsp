<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kitri.member.model.MemberDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/common/public.jsp" %>

<% 
MemberDto memberDto = new MemberDto();

memberDto.setName("호");
memberDto.setId("yang");
memberDto.setEmail1("didhomin");
memberDto.setEmail2("kitri.homin");

session.setAttribute("userInfo", memberDto);

response.sendRedirect(request.getContextPath()+"/boardadmin/boardmenu.html");
%>