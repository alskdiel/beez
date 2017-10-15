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
		<a href="javascript:sendAndroidMsg('SSGKEYSETTING');" style="color: black">
		 SSG KEY 노트북 설정하기 
		 </a>
		<hr>
		 
		 
		 </div>

	</div>

	<%@include file="./../include/footer.jsp"%>
	
	<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
	<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
	<script type="text/javascript">
			
		$(document).ready(function() {
			$("#AttPushSettings").on('change', function(){
				sendAndroidMsgTwoValue("AttPushSettings",this.checked);
			});
			$("#SeatPushSettings").on('change', function(){
				sendAndroidMsgTwoValue("SeatPushSettings",this.checked);
			});
			$("#SSGkeySettings").on('change', function(){
				sendAndroidMsgTwoValue("SSGkeySettings",this.checked);
			});
		});
	
	</script>

</body>
</html>
