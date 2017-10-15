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
			<section class="content-header">
			  <div class="cd_box">
			  	<div class="calendar-wrapper">
			  		<div class="calendar-container">
			  			<div id="canvas-calendar">
			  			</div>
			  		</div>
			  	</div>
			  </div>
			</section>
          <a href="#"><p class="v_text">상세보기</p></a>
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
   	<link href="/resources/css/calender.css" rel="stylesheet" type="text/css" />

   
    <script src="/resources/js/sidebar.js" type="text/javascript"></script>
    <script src="/resources/js/calendar.js" type="text/javascript"></script>
    
    <script>
    	var data_cal = ${data_cal};
    	var data_cal_yr = ${data_cal_yr}
    	var data_cal_mon = ${data_cal_mon}
    	
    	setCalData(data_cal, data_cal_yr+"-"+data_cal_mon+"-01");
    </script>
    
    
</body>
</html>
