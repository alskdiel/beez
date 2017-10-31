<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<%@include file="./include/resources.jsp"%>
	<link href="/resources/css/main.css" rel="stylesheet" type="text/css" />
		
</head>
<body class="sidebar-mini">
	<div class="wrapper">
		<%@include file="./include/header.jsp"%>
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">

				<div class="textbox">
					<h2 id="t_box00">근무 중</h2>
					<div id="t_box01">-</div>
					<div id="t_box02">-</div>
					<div id="t_box03"></div>
					
					
					<!-- <div class="book-cancel-wrapper" onclick="javascript:CancelBook()">	
								<p id = "canbook" style="display: none;">좌석 예약 취소</p>
						</div>	
					 -->
						
					<div class="icon-container">
					<div class="kakao-icon-wrapper" onclick="javascript:shareMyLocation()" style="text-align: center;">
						<img alt="share" src="/resources/images/main/kakao_icon.png"  id="chatimg"  style="display: none"  >
					</div>
					<div class="qr-icon-wrapper" onclick="javascript:ReadQR()">	
						<img id="qrbtn" style="display: none;" src="/resources/images/main/qr_icon.png"/>
						<!-- <p id = "qrbtn" style="display: none;">QR코드로 좌석 인식</p> -->
					</div>
					
					
					</div>
				</div>
			</section>
			<div class="bar_01" onclick="javascript:href_page('bar01');">
				<div class="sub-img-container">
					<img src="/resources/images/main/icon_1.png"/>
				</div>
				
				<div class="m_t">
					<a>내 근태 정보</a>
				</div>
				<div class="sub-icon-container">
					<img src="/resources/images/main/arrow_icon.png"/>
				</div>
			</div>
			<div class="bar_02" onclick="javascript:href_page('bar02');">
				<div class="sub-img-container">
					<img src="/resources/images/main/icon_2.png"/>
				</div>
				
				<div class="m_t">
					<a>전체 좌석 정보</a>
				</div>
				<div class="sub-icon-container">
					<img src="/resources/images/main/arrow_icon.png"/>
				</div>
			</div>
			<div class='control-sidebar-bg'></div>
		</div>


		<%@include file="./include/footer.jsp"%>

		
		<script type="text/javascript">
		$(document).ready(function() {
			$('#nav_title').text("SSG BEEZ");
			sendAndroidMsg("MAINONLOADCALL");
			setInterval("sendAndroidMsg('MAINONLOADCALL')", 1000);
		});
		//setUserStateToWeb('조현재', '2017/06/05', 'booked//14F-B-57//121//3');
		setUserStateToWeb('조현재', '2017/06/05', '14F-B-12');
		function setUserStateToWeb(name, date, position){
	// if booked 
	// position : booked//location//date
	// else
	// position : location
	
			var arr = position.split("//");
			//arr[0] :booked

			if(position == 'leaved'){
				$('#t_box00').text("오늘도 수고하셨습니다!");
				$('#t_box01').text("퇴근");
				$('#t_box02').text(date.substr(0,10));

				document.getElementById("chatimg").style.display = "none";
				document.getElementById("qrbtn").style.display = "none";
				
			}
			else 	if(date == 'null'){
				$('#t_box00').text("충전 중");
				$('#t_box02').text("아직 출근하지 않았네요~");
				//document.getElementById("canbook").style.display = "none";
			}else{

				$('#t_box00').text("근무 중");
				$('#t_box02').text("출근시간 : "+date);
				document.getElementById("qrbtn").style.display = "block";
				if(position == 'null'){
					$('#t_box01').text("자리에 앉지 않았네요~");

					$('#t_box03').text("");
					//document.getElementById("canbook").style.display = "none";
				}else{
					$('#t_box01').text(name+"님의 위치 : "+position);

					//document.getElementById("canbook").style.display = "none";
					document.getElementById("chatimg").style.display = "block";
					document.getElementById("chatimg").style.textalign = "center";
					$('#t_box03').text('');
				}
			}			
			if(arr[0] == "booked"){
				$('#t_box01').text("예약중인 위치 : "+arr[1]);
				if(arr[3]=='0'){
					$('#t_box03').text("예약 시간이 지났습니다.");
					//document.getElementById("canbook").style.display = "none";
				}
				//document.getElementById("canbook").style.display = "block";
				var txt = arr[2]+"까지 [<span class='time'>"+arr[3]+"</span>초 남음]"
				
				
						+ "<div class='book-cancel-wrapper' onclick='javascript:CancelBook()'>"	
						+		"<p id = 'canbook'>예약취소</p>"
						+ "</div>";
						
					$('#t_box03').append(txt);
					
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
		function ReadQR(){
			sendAndroidMsg("STARTQRREADER");
		}
		function CancelBook(){
			sendAndroidMsg("CANCELBOOKING");
		}
		</script>
</body>
</html>
