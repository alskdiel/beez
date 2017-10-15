<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<%@include file="./../include/resources.jsp"%>

</head>

<body class="sidebar-mini">

	<div class="wrapper">
		
		<%@include file="./../include/header.jsp"%>


		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-wrapper">

			<section class="content-header">
			  <div class="m_txt">Month</div>
			  <div class="m_box">박스1</div>
			  <div class="m_box">박스2</div>
			</section>
			
			<section class="content-header invalid">
			  <div class="m_txt">Year</div>
			  <div class="m_box">박스1</div>
			  <div class="m_box">박스2</div>
			</section>
			
			
		<div class='control-sidebar-bg'></div>
	</div>
	
	
	<%@include file="./../include/footer.jsp"%>
	
	<link href="/resources/css/att.css" rel="stylesheet" type="text/css" />
    
    
</body>
</html>
