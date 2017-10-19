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
				<div class="filter-container">
					<div class="search">
						<div class="input-container">
							<input type="text" class="form-control" id="name" placeholder="이름">
						</div>
						<div class="icon-container">
							<i class="fa fa-search" aria-hidden="true"></i>
						</div>
  					</div>
  					
					<div class="my-team">
						<div class="team-container">
							<div class="btn btn-warning display-team-list">팀원 목록</div>
						</div>
						<div class="toggle-container">
							<input type="checkbox" checked data-toggle="toggle" id="team-toggle" checked="false">
						</div>
					</div>
					
					<div class="refresh">
						<div class="icon-container">
							<i class="fa fa-refresh" aria-hidden="true"></i>
						</div>
					</div>
				</div>
				
				<div class="my-modal">
					<div class="modal-header">
						<div>
							팀원 목록
						</div>
						<div class="dismiss"><i class="fa fa-times" aria-hidden="true"></i></div>
						
					</div>
					<div class="modal-content">
						<table>
							<thead>
								<tr>
									<td>사번</td>
									<td>이름</td>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
				
				<div class="floor-btn">
					<div id="to-9f">9</div>
					<div id="to-10f">10</div>
					<div id="to-13f">13</div>
					<div id="to-14f">14</div>
				</div>
				
				<%@include file="status_9f.jsp"%>
				<%@include file="status_10f.jsp"%>
				<%@include file="status_13f.jsp"%>
				<%@include file="status_14f.jsp"%>

				   	
			  </section>
		  </div>
		
		 <div class='control-sidebar-bg'></div>
	</div>
		
			
	<%@include file="./../include/footer.jsp"%>
	
    <link href="/resources/css/m_9f.css" rel="stylesheet" type="text/css" />
    <!-- 
    <link href="/resources/css/m_10f.css" rel="stylesheet" type="text/css" />
    <link href="/resources/css/m_13f.css" rel="stylesheet" type="text/css" />
    <link href="/resources/css/m_14f.css" rel="stylesheet" type="text/css" />
	-->
    <script src="/resources/js/seat_status.js"></script>  
    
    	<link
		href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
		rel="stylesheet" >
	<script
		src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
    <script>
    	
    	//console.log(${tmp});
    	var seat_status = ${tmp};
    	$(document).on("ready", function() {
    		setStatus(seat_status);
    		$('#nav_title').text("좌석 현황");
    	});
		
    	
    </script>
</body>
</html>
