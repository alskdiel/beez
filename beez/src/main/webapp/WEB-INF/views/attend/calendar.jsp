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
			  <div class="content-title">
			  	나의 근태
			  </div>
			  <div class="cd_box">
			  	<div class="calendar-wrapper">
			  		<div class="calendar-container">
			  			<div id="canvas-calendar">
			  			</div>
			  		</div>
			  	</div>
			  </div>
			</section>
		<div class='control-sidebar-bg'></div>
	</div>
	
	
	<%@include file="./../include/footer.jsp"%>
    
    <link href="/resources/css/calender.css" rel="stylesheet" type="text/css" />
    <script src="/resources/js/calendar.js" type="text/javascript"></script>
    <script>


	$(document).ready(function() {
    	var data_cal = ${data_cal};
    	var data_cal_yr = ${data_cal_yr}
    	var data_cal_mon = ${data_cal_mon}

	setCalData(data_cal, data_cal_yr+"-"+data_cal_mon+"-01");
	
	var date = {};
	date.from = pad(data_cal_mon) + "/01/" + data_cal_yr;
	date.to = pad((parseInt(data_cal_mon) + 1)) + "/01/" + data_cal_yr;
	
	$.ajax({
		url  : "myattendAjax.do" , 
		type : "get" , 
		data : { from: date.from,
				 to: date.to } ,
		dataType : "json" , 
		success : function(data) {
			data_cal = data.data_cal;
			
			data_cal_yr = data.data_cal_yr;
			data_cal_mon = data.data_cal_mon;
			
			setCalData(data_cal, data_cal_yr+"-"+data_cal_mon+"-01");
		}
	});
	
	});
    </script>
    
    
	    
</body>
</html>
