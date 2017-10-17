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
	
	
	<%@include file="./../include/footer.jsp"%>
	    
    <link href="/resources/css/calender.css" rel="stylesheet" type="text/css" />
    <script src="/resources/js/calendar.js" type="text/javascript"></script>
    
    <script>
    	var data_cal = ${data_cal};
    	var data_cal_yr = ${data_cal_yr}
    	var data_cal_mon = ${data_cal_mon}
    	
    	setCalData(data_cal, data_cal_yr+"-"+data_cal_mon+"-01");


		$(document).ready(function() {
			$('#nav_title').text("나의근태");
		});
    </script>
    
    
</body>
</html>
