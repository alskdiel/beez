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


		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			
			내 자리 이력
				<table id="table-seat-history">
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
									<fmt:formatDate value="${userSeatVO.seated_Date}" pattern="yy MM dd, hh:mm"/>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			<div class="btn" id="myseat">call ajax</div>
			<input type="hidden" value='${endPageNo}' id="endPageNo"/>
			
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
    
    <!-- AdminLTE App -->
    <script src="/resources/dist/js/app.min.js" type="text/javascript"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="/resources/dist/js/demo.js" type="text/javascript"></script>
    <script src="/resources/js/seat.js"></script>  
    
</body>
</html>
