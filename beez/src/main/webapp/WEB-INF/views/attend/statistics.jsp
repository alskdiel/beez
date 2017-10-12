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
	
	
	
	<!-- jQuery -->
	<script src="/resources/js/lib/jQuery/jQuery-2.1.4.min.js"></script>
	
	<!-- Bootstrap 3.3.2 JS -->
    <script src="/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='/resources/js/lib/fastclick/fastclick.min.js'></script>
    
    <!-- AdminLTE App -->
    <script src="/resources/dist/js/app.min.js" type="text/javascript"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="/resources/dist/js/demo.js" type="text/javascript"></script>
    <link href="/resources/css/att.css" rel="stylesheet" type="text/css" />
    
    <script src="/resources/js/sidebar.js" type="text/javascript"></script>
    
</body>
</html>
