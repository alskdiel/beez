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
			
			좌석통계	
				
			</section>

		</div>
		<div class='control-sidebar-bg'></div>
	</div>
	
	
	<%@include file="./../include/footer.jsp"%>
	<script type="text/javascript">


	$(document).ready(function() {
		$('#nav_title').text("좌석 통계");
	});
	
	</script>
</body>
</html>
