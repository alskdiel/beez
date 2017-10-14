<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<%@include file="../include/resources.jsp"%>
</head>

<body class="sidebar-mini">

	<div class="wrapper">
		<%@include file="../include/header.jsp"%>
		<div align="center">
		알림설정
		<hr>
		</div>
		 <div class="content-wrapper">
		 출퇴근 PUSH 알림 받기<input type="checkbox" checked data-toggle="toggle" id = "AttPushSettings" name ="AttPushSettings">
		<hr>
		 좌석 PUSH 알림 받기<input type="checkbox" checked data-toggle="toggle" id = "SeatPushSettings" name ="SeatPushSettings">
		<hr>
		 SSG KEY 사용하기 <input type="checkbox" checked data-toggle="toggle" id ="SSGkeySettings" name ="SSGkeySettings">
		<hr>
		
		 
		 
		 </div>

	</div>

		<!-- jQuery -->
		<script src="/resources/js/lib/jQuery/jQuery-2.1.4.min.js"></script>

		<!-- Bootstrap 3.3.2 JS -->
		<script src="/resources/bootstrap/js/bootstrap.min.js"
			type="text/javascript"></script>
		<!-- FastClick -->
		<script src='/resources/js/lib/fastclick/fastclick.min.js'></script>

		<!-- AdminLTE App -->
		<script src="/resources/dist/js/app.min.js" type="text/javascript"></script>
		<!-- AdminLTE for demo purposes -->
		<script src="/resources/dist/js/demo.js" type="text/javascript"></script>
		<link href="/resources/css/main.css" rel="stylesheet" type="text/css" />

		<script src="/resources/js/sidebar.js" type="text/javascript"></script>
		
<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<script type="text/javascript">
		
	$(document).ready(function() {
		$("#AttPushSettings").on('change', function(){
			sendAndroidMsg("AttPushSettings");
		});
		$("#SeatPushSettings").on('change', function(){
			sendAndroidMsg("SeatPushSettings");\
		});
		$("#SSGkeySettings").on('change', function(){
			sendAndroidMsg("SSGkeySettings");\
		});
	});

</script>

</body>
</html>
