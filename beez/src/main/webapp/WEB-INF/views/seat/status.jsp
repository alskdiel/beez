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
					<%--
				  <c:forEach items="${seatlist}" var="SeatVO">
				  	${SeatVO}
				  </c:forEach>
				   --%>
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
    <script>
    	
    	//console.log(${tmp});
    	var seat_status = ${tmp};
    	$(document).on("ready", function() {
    		setStatus(seat_status);
    		console.log(seat_status);
    		$('#nav_title').text("좌석 현황");
    	});
		
    	
    </script>
</body>
</html>
