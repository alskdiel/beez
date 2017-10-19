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
		 <div class="i_box">
            <p class="icon_boc_i"></p>
            <h2>알림설정</h2>
        </div>
			

		<div class="content-wrapper">
		  <ul>
		  <li class="chec_1">출퇴근 PUSH 알림 받기
			<!-- checked data-toggle="toggle"  -->
			<input type="checkbox" class="putcon" checked data-toggle="toggle"
				id="AttPushSettings" name="AttPushSettings" /></li>
		  <li class="chec">좌석 PUSH 알림 받기
		    <input type="checkbox" checked data-toggle="toggle"
				id="SeatPushSettings" name="SeatPushSettings"></li>
		  <li class="chec">SSG KEY 사용하기
		  <input type="checkbox" checked data-toggle="toggle"
				id="SSGkeySettings" name="SSGkeySettings"></li>
		  <li class="chec_2">
			<a href="javascript:sendAndroidMsg('SSGKEYSETTING');"> SSG KEY 노트북 설정하기 </a>
          </li>
        </ul>

		</div>

	</div>


	<%@include file="./../include/footer.jsp"%>

	<link rel="stylesheet" href="../../../resources/css/settings.css" />

	<link
		href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
		rel="stylesheet" >
	<script
		src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#nav_title').text("시스템 설정");
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
