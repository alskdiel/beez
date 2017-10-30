<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<%@include file="./../include/resources.jsp"%>
	<link href="/resources/css/seat.css" rel="stylesheet" type="text/css" />
    
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
							<img src="/resources/images/seat_history/filter_btn.png"/>
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
									<li role="presentation" class="divider"></li>
									<li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:setFilterType('date')">날짜</a>
									</li>
							  </ul>
							</div>
							
							<div>
								<div class="filter-content all">
									
								</div>
								<div class="filter-content loc">
									<input type="text" class="form-control" placeholder="14F or CENTRAL" id="entered-loc"/>
								</div>
								<div class="filter-content date">
									<input type="text" name="daterange" value="01/01/2015 - 01/31/2015" readonly/>
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
				
					<table id="table-seat-history" class="table">
						<thead>
							<tr>
								<td>
									<div>번호</div>
								</td>
								<td>
									<div>위치</div>
								</td>
								<td>
									<div>자리번호</div>
								</td>
								<td>
									<div>날짜</div>
								</td>
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
				<%-- </div> --%>

			</section>

		</div>
		<div class='control-sidebar-bg'></div>
	</div>
	
	
	<%@include file="./../include/footer.jsp"%>
	
	
    <!-- daterangePicker -->
    <script type="text/javascript" src="/resources/js/lib/moment.min.js"></script>

    <script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
    
    <script src="/resources/js/seat.js"></script>  
	    
        <script type="text/javascript">

		$(document).ready(function() {
			$('#nav_title').text("내 좌석 이력");
		});
        </script>
    
</body>
</html>
