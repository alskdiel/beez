<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<%@include file="./include/resources.jsp"%>

</head>

<body class="sidebar-mini">

	<div class="wrapper">
		
		<%@include file="./include/header.jsp"%>


		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">

			  <div class="textbox">
                <h2>근무중</h2>
                <div id="t_box01">나의위치</div>
                <div id="t_box02">2017년 0월 00일 09시 30분에 출근하셨습니다.</div>  
              </div>
			</section>
		    <div class="bar_01">
              <p class="sub_img01"><!--이미지--></p>
		      <div class="m_t"><a href="#">내 근태 정보</a></div>
		      <i class="fa fa-angle-right" aria-hidden="true"></i>
		    </div>
		    <div class="bar_02">
		      <p class="sub_img02"><!--이미지--></p>
		      <div class="m_t"><a href="#">전체 좌석 정보</a></div>
		      <i class="fa fa-angle-right" aria-hidden="true"></i>
		    </div>
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
    <link href="/resources/css/main.css" rel="stylesheet" type="text/css" />
    
    <script src="/resources/js/sidebar.js" type="text/javascript"></script>
    
</body>
</html>
