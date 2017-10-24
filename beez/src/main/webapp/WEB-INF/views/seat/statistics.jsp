<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			
				
				<ul class="nav nav-tabs">
					<li class="active">
						<a href="#fav" data-toggle="tab">FAVORITE</a>
					</li>
					<li>
						<a href="#hot" data-toggle="tab">HOT PLACE</a>
					</li>
				</ul>
				<div class="tab-content carousel slide" id="carousel-example-generic">
					<div class="carousel-inner">
						<div class="tab-pane active item" id="fav">
							<div class="filter-container">
								<div class="year fav active">
									최근 1년
								</div>
								<div class="month fav">
									최근 1개월
								</div>
							</div>
						<!-- 
							<div class="datepicker-container">
								<div class="datepicker-wrapper">
            						<input type='text' class="form-control" id='datepicker-f-f' placeholder="mm/dd/yyyy"/>
								</div>
								<div class="datepicker-wrapper">
									<input type='text' class="form-control" id='datepicker-f-t' placeholder="mm/dd/yyyy" />
								</div>
								<div id="icon-search" class="icon-search fav">
									<i class="fa fa-search" aria-hidden="true"></i>
								</div>
							</div>
						-->
							<canvas id="favChart" width="400" height="400"></canvas>
							
						</div>
			
						<div class="tab-pane item" id="hot">
						<!-- 
							<div class="filter-container">
								<div class="year hot active">
									최근 1년
								</div>
								<div class="month hot">
									최근 1개월
								</div>
							</div>
						-->
						<!-- 
							<div class="datepicker-container">
								<div class="datepicker-wrapper">
            						<input type='text' class="form-control" id='datepicker-h-f' placeholder="mm/dd/yyyy"/>
								</div>
								<div class="datepicker-wrapper">
									<input type='text' class="form-control" id='datepicker-h-t' placeholder="mm/dd/yyyy" />
								</div>
								<div id="icon-search-hot" class="icon-search hot">
									<i class="fa fa-search" aria-hidden="true"></i>
								</div>
							</div>
						-->







							<div class="container">

								<button type="button" class="btn btn-success" data-toggle="collapse" data-target="#hot-chart-1">
								1등. 좌석 이름 보여준다.
								</button>
								<div id="hot-chart-1" class="collapse">
									<div class="chart-wrapper">
										<canvas id="hotChart-1" width="400" height="400"></canvas>
									</div>
								</div>
								
								<button type="button" class="btn btn-success" data-toggle="collapse" data-target="#hot-chart-2">
								2등. 좌석 이름 보여준다.
								</button>
								<div id="hot-chart-2" class="collapse">
									<div class="chart-wrapper">
										<canvas id="hotChart-2" width="400" height="400"></canvas>
									</div>
								</div>
								
								<button type="button" class="btn btn-success" data-toggle="collapse" data-target="#hot-chart-3">
								3등. 좌석 이름 보여준다.
								</button>
								<div id="hot-chart-3" class="collapse">
									<div class="chart-wrapper">
										<canvas id="hotChart-3" width="400" height="400"></canvas>
									</div>
								</div>
								
								<button type="button" class="btn btn-success" data-toggle="collapse" data-target="#hot-chart-4">
								4등. 좌석 이름 보여준다.
								</button>
								<div id="hot-chart-4" class="collapse">
									<div class="chart-wrapper">
										<canvas id="hotChart-4" width="400" height="400"></canvas>
									</div>
								</div>
								
								<button type="button" class="btn btn-success" data-toggle="collapse" data-target="#hot-chart-5">
								5등. 좌석 이름 보여준다.
								</button>
								<div id="hot-chart-5" class="collapse">
									<div class="chart-wrapper">
										<canvas id="hotChart-5" width="400" height="400"></canvas>
									</div>
								</div>
								
								<button type="button" class="btn btn-success" data-toggle="collapse" data-target="#hot-chart-6">
								6등. 좌석 이름 보여준다.
								</button>
								<div id="hot-chart-6" class="collapse">
									<div class="chart-wrapper">
										<canvas id="hotChart-6" width="400" height="400"></canvas>
									</div>
								</div>
								
								<button type="button" class="btn btn-success" data-toggle="collapse" data-target="#hot-chart-7">
								7등. 좌석 이름 보여준다.
								</button>
								<div id="hot-chart-7" class="collapse">
									<div class="chart-wrapper">
										<canvas id="hotChart-7" width="400" height="400"></canvas>
									</div>
								</div>
								
								<button type="button" class="btn btn-success" data-toggle="collapse" data-target="#hot-chart-8">
								8등. 좌석 이름 보여준다.
								</button>
								<div id="hot-chart-8" class="collapse">
									<div class="chart-wrapper">
										<canvas id="hotChart-8" width="400" height="400"></canvas>
									</div>
								</div>
								
								<button type="button" class="btn btn-success" data-toggle="collapse" data-target="#hot-chart-9">
								9등. 좌석 이름 보여준다.
								</button>
								<div id="hot-chart-9" class="collapse">
									<div class="chart-wrapper">
										<canvas id="hotChart-9" width="400" height="400"></canvas>
									</div>
								</div>
								
								<button type="button" class="btn btn-success" data-toggle="collapse" data-target="#hot-chart-10">
								10등. 좌석 이름 보여준다.
								</button>
								<div id="hot-chart-10" class="collapse">
									<div class="chart-wrapper">
										<canvas id="hotChart-10" width="400" height="400"></canvas>
									</div>
								</div>
							</div>



















							
						</div>
					</div>
				</div>
				
		
				
			</section>

		</div>
		<div class='control-sidebar-bg'></div>
	</div>
	
	<link href="/resources/css/seat_statistics.css" rel="stylesheet" type="text/css" />
	
	<%@include file="./../include/footer.jsp"%>
	
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet" type="text/css" />
	
	<script src="/resources/js/lib/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>
	
	
	<script src="/resources/js/lib/Chart.min.js"></script>
	<script src="/resources/js/seat_statistics.js"></script>  
	
	<script type="text/javascript">


	$(document).ready(function() {
		$('#nav_title').text("좌석 통계");
	});
	
	</script>
</body>
</html>
