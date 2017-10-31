<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@include file="../include/resources.jsp"%>

<link rel="stylesheet" href="../../../resources/css/settings.css" />
</head>

<body class="sidebar-mini">

	<div class="wrapper">
		<%@include file="../include/header.jsp"%>
		 <div class="i_box">
		 
            <h2>알림설정</h2>
            <div class="icon-container">
            	<img src="/resources/images/settings/setting_icon.png">
            </div>
        </div>
			

		<div class="content-wrapper">
		  <ul>
		  <li class="chec_1">
		  	<div class="title">출퇴근 PUSH 알림 받기</div>
			<!-- checked data-toggle="toggle"  -->
			<input type="checkbox" class="putcon" checked data-toggle="toggle"
				id="AttPushSettings" name="AttPushSettings" data-on=" " data-off=" "/></li>
		  <li class="chec">
		  	<div class="title">좌석 PUSH 알림 받기</div>
		    <input type="checkbox" checked data-toggle="toggle"
				id="SeatPushSettings" name="SeatPushSettings" data-on=" " data-off=" "></li>
		  <li class="chec">
		  	<div class="title">SSG KEY 사용하기</div>
		  <input type="checkbox" checked data-toggle="toggle"
				id="SSGkeySettings" name="SSGkeySettings" data-on=" " data-off=" "></li>
		  <li class="chec_2">
			<a href="javascript:sendAndroidMsg('SSGKEYSETTING');">
				<div class="title">SSG KEY 노트북 설정하기</div>
			</a>
          </li>
        </ul>

		</div>

	</div>


	<%@include file="./../include/footer.jsp"%>


	<link
		href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
		rel="stylesheet" >
	<script
		src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			sendAndroidMsg('GETDEVICESETTINGS');
			$("#AttPushSettings").on('change', function() {
				sendAndroidMsgTwoValue("AttPushSettings", this.checked);
			});
			$("#SeatPushSettings").on('change', function() {
				sendAndroidMsgTwoValue("SeatPushSettings", this.checked);
			});
			$("#SSGkeySettings").on('change', function() {
				sendAndroidMsgTwoValue("SSGkeySettings", this.checked);
			});
		});
		/* <!--
		OFF : toggle btn btn-default off
		on : toggle btn btn-primary
		
		-->*/
		function setWebSettingOnOff(noti, seat, key) {
			if (noti == "false") {
				$('#AttPushSettings').attr('checked', false);
				$('#AttPushSettings').parent().attr("class",
						'toggle btn btn-default off');
			} else {
				$('#AttPushSettings').attr('checked', true);
			}
			if (seat == "false") {
				$('#SeatPushSettings').attr('checked', false);
				$('#SeatPushSettings').parent().attr("class",
						'toggle btn btn-default off');
			} else {
				$('#SeatPushSettings').attr('checked', true);
			}
			if (key == "false") {
				$('#SSGkeySettings').attr('checked', false);
				$('#SSGkeySettings').parent().attr("class",
						'toggle btn btn-default off');
			} else {
				$('#SSGkeySettings').attr('checked', true);
			}
		}
	</script>

</body>
</html>
