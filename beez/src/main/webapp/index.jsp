<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user = (String)request.getParameter("SessionOnlyUserId");
	session.setAttribute("currentUserId", user);

%>
<script>
	location.href = "main.do";
</script>