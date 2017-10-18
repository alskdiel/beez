<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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
					<h2 id="t_box00">근무중</h2>
					<div id="t_box01">-</div>
					<div id="t_box02">-</div>
					
					<img alt="share" src="/img/chat.png"  id="chatimg"  style="width: 10%; height: 10% ; display: none"  onclick="javascript:shareMyLocation()">
				</div>
			</section>
			<div class="bar_01" onclick="javascript:href_page('bar01');">
				<p class="sub_img01">
					<!--이미지-->
				</p>
				<div class="m_t">
					<a href="#">내 근태 정보</a>
				</div>
				<i class="fa fa-angle-right" aria-hidden="true"></i>
			</div>
			<div class="bar_02" onclick="javascript:href_page('bar02');">
				<p class="sub_img02">
					<!--이미지-->
				</p>
				<div class="m_t">
					<a href="">전체 좌석 정보</a>
				</div>
				<i class="fa fa-angle-right" aria-hidden="true"></i>
			</div>
			<div class='control-sidebar-bg'></div>
		</div>


		<%@include file="./include/footer.jsp"%>

		<link href="/resources/css/main.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript">
		$(document).ready(function() {
			$('#nav_title').text("SSG BEEZ");
			sendAndroidMsg("MAINONLOADCALL");
			setInterval("sendAndroidMsg('MAINONLOADCALL')", 3000);
			
			
			
		});
		
		function setUserStateToWeb(name, date, position){
	//		alert(name + " / " + date + " / "+ position);
			
			if(date == 'null'){
				$('#t_box00').text("충전 중");
				$('#t_box02').text("아직 출근하지 않았네요~");
			}else{
				$('#t_box00').text("근무 중");
				$('#t_box02').text("출근시간 : "+date);
				if(position == 'null'){
					$('#t_box01').text("자리에 앉지 않았네요~");
				}else{
					$('#t_box01').text(name+"님의 위치 : "+position);
					document.getElementById("chatimg").style.display = "block";
					document.getElementById("chatimg").style.textalign = "center";
				}
			}
			
			
		}
		

		function href_page(bar){
			var url;
			if(bar == 'bar01'){
				url = '/att/myattend.do';
			}	
			if(bar == 'bar02'){
				url = '/seat/list.do';
			}
			location.href=url;
		}
		
		function shareMyLocation(){
			sendAndroidMsg("KAKAOSHARE");
		}
		</script>
</body>
</html>
