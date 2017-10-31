<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<%@include file="./../include/resources.jsp"%>
	<link href="/resources/css/m_9f.css" rel="stylesheet" type="text/css" />
    
</head>

<body class="sidebar-mini">

	<div class="wrapper">
		
		<%@include file="./../include/header.jsp"%>


		  <div class="content-wrapper">
			  <!-- Content Header (Page header) -->
			  <section class="content-header">
				<div class="filter-container">
					<div class="search">
						<div class="input-container">
							<input type="text" class="form-control" id="name" placeholder="이름">
						</div>
						<div class="icon-container">
							<img src="/resources/images/seat_status/search_icon.png"/>
							
						</div>
  					</div>
  					
					<div class="my-team">
						<div class="team-container">
							<div class="btn btn-warning display-team-list">팀원목록</div>
						</div>
						<div class="toggle-container">
							<input type="checkbox" checked data-toggle="toggle" id="team-toggle" data-on=" " data-off=" ">
						</div>
					</div>
					
					<div class="refresh">
						<div class="icon-container">
							<img src="/resources/images/seat_status/refresh_icon.png"/>
						</div>
					</div>
				</div>
				
				
				<div class="status-container">
					<div class="my-modal">
						<div class="modal-header">
							<div>
								팀원 목록
							</div>
							<div class="dismiss">
								<img src="/resources/images/seat_status/popup_close_btn.png"/>
							</div>
							
						</div>
						<div class="modal-content">
							<table>
								<thead>
									<tr>
										<td>
											<div>사번</div>
										</td>
										<td>
											<div>이름</div>
										</td>
										<td></td>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<div>
							</div>
						</div>
					</div>
					
					<div class="floor-btn">
						<div id="to-9f" class="current_floor">9</div>
						<div id="to-10f">10</div>
						<div id="to-13f">13</div>
						<div id="to-14f">14</div>
					</div>
					
					<jsp:include page="status_9f.jsp" flush="false">
						<jsp:param name="floor" value="9" />
					</jsp:include>
					<jsp:include page="status_10f.jsp" flush="false">
						<jsp:param name="floor" value="10" />
					</jsp:include>
					<jsp:include page="status_13f.jsp" flush="false">
						<jsp:param name="floor" value="13" />
					</jsp:include>
					<jsp:include page="status_14f.jsp" flush="false">
						<jsp:param name="floor" value="14" />
					</jsp:include>
				</div> 	
			  </section>
		  </div>
		
		 <div class='control-sidebar-bg'></div>
	</div>
		
	<div class="chartModal fade" id="chartModal">
		<div class="title-chart">
			평균 좌석 점유 시간
		</div>
		
		<div id="hot-chart">
			<div class="chart-wrapper">
				<canvas id="hotChart" width="400" height="400"></canvas>
			</div>
		</div>
	</div>

	
			
	<%@include file="./../include/footer.jsp"%>
	
    
	
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet" type="text/css" />
	
	<script src="/resources/js/lib/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>
	
    
    <!-- 
    <link href="/resources/css/m_10f.css" rel="stylesheet" type="text/css" />
    <link href="/resources/css/m_13f.css" rel="stylesheet" type="text/css" />
    <link href="/resources/css/m_14f.css" rel="stylesheet" type="text/css" />
	-->
	<script src="/resources/js/lib/Chart.min.js"></script>
	
    <script src="/resources/js/seat_status.js"></script>  
    
    <link
		href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
		rel="stylesheet" >
	<script
		src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
    <script>

	var currentUser = "${user_id}";

    $(".btn").popover();      
    var seat_status = ${seatStatus};
   	var hot_places = ${hotPlaces};
   	
   	$(document).on("ready", function() {
   		$('#nav_title').text("좌석 현황");
   	});
	
    	
    </script>
</body>
</html>
