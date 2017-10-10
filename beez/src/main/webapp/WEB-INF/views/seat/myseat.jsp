<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="false" %>
<html>
<head>
	<%@include file="./../include/resources.jsp"%>

</head>

<body class="sidebar-mini">

	<div class="wrapper">
		
		<%@include file="./../include/header.jsp"%>


		<div class="content-wrapper seat-history">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			
				<div class="filter-wrapper">
					<div class="filter-header">
						<span>내 자리 이력</span>
						<div class="icon-filter" id="seat-history-filter">
							<i class="fa fa-filter" aria-hidden="true"></i>
						</div>
					</div>
					<div class="filter-body" id="filter-body">
						<div class="filter-container">
							<div class="dropdown">
								<button type="button" id="filter-type" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
									전체보기
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
									<li role="presentation">
										<a role="menuitem" tabindex="-1" href="javascript:setFilterType('all')">전체보기</a>
									</li>
									<li role="presentation" class="divider"></li>
									<li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:setFilterType('loc')">위치</a>
									</li>
									<li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:setFilterType('date')">날짜</a>
									</li>
							  </ul>
							</div>
							
							<div>
								<div class="filter-content all">
									
								</div>
								<div class="filter-content loc">
									<input type="text" class="form-control" placeholder="14F or CENTRAL"/>
								</div>
								<div class="filter-content date">
									<input type="text" name="daterange" value="01/01/2015 - 01/31/2015" />
								</div>
							</div>
							<div class="icon-search" id="icon-search">
								<i class="fa fa-search" aria-hidden="true"></i>
							</div>
						</div>
					</div>
				</div>
			</section>
			
			<section class="content-body">
			
				<%-- <div data-spy="scroll" data-offset="0" class="scrollspy-example"> --%>
				
					<table id="table-seat-history" class="table table-striped">
						<thead>
							<tr>
								<td>번호</td>
								<td>위치</td>
								<td>자리번호</td>
								<td>날짜</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userSeatVO}" var="userSeatVO" varStatus="status">
								<tr>
									<td>${status.index+1}</td>
									<td>${userSeatVO.building_name} / ${userSeatVO.floor_num}F / ${userSeatVO.seat_real_location}</td>
									<td>${userSeatVO.seat_id}</td>
									<td>
										<fmt:formatDate value="${userSeatVO.seated_Date}" pattern="yyyy MM dd, hh:mm"/>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="btn" id="myseat">call ajax</div>
				<%-- </div> --%>

			</section>

		</div>
		<div class='control-sidebar-bg'></div>
	</div>
	
	
	
	<!-- jQuery -->
	<script src="/resources/js/lib/jQuery/jQuery-2.1.4.min.js"></script>
	
	<!-- Bootstrap 3.3.2 JS -->
    <script src="/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='/resources/js/lib/fastclick/fastclick.min.js'></script>
    
    
    <!-- daterangePicker -->
    <script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>

    <script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
    
    
    <!-- AdminLTE App -->
    <script src="/resources/dist/js/app.min.js" type="text/javascript"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="/resources/dist/js/demo.js" type="text/javascript"></script>
    <script src="/resources/js/seat.js"></script>  
	<link href="/resources/css/seat.css" rel="stylesheet" type="text/css" />
        
</body>
</html>
