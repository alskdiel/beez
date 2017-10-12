<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ko-KR">
<head>
<meta charset="UTF-8">
<title>14F</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>

<!-- Bootstrap 3.3.4 -->
<link href="../../../resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<script src="../../../resources/js/navbar.js"></script>
<!-- Theme style -->
<link href="../../../resources/dist/css/AdminLTE.min.css"
	rel="stylesheet" type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
	     folder instead of downloading all of them to reduce the load. -->
<link href="../../../resources/dist/css/skins/_all-skins.min.css"
	rel="stylesheet" type="text/css" />

<!-- customed css -->
<link href="../../../resources/css/header.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="../../../resources/css/lib/normalize.css" />
<link rel="stylesheet" href="../../../resources/css/14f.css" />
<style>

/*   파란색   */
.available {
	background-image: url(../../img/f_box.png);
}

/*   노란색   */
.occupied {
	background-image: url(../../img/f_box02.png);
}

/*   주황색   */
.unavailable {
	background-image: url(../../img/f_box03.png);
}
</style>

</head>

<body>
	<div id="wrap">
		<div id="header">
			<h1>14F</h1>
			<nav id="gnb">
				<ul>
					<li><a href="9f.do">9F</a></li>
					<li><a href="10f.do">10F</a></li>
					<li><a href="13f.do">13F</a></li>
					<li><a href="14f.do">14F</a></li>
				</ul>
			</nav>
		</div>
		<section id="all">
			<div class="box1">
				<ul>
					<li class="available" id='1'></li>
					<li class="available" id='2'></li>
				</ul>
				<ul>
					<li class="available" id='3'></li>
					<li class="available" id='4'></li>
				</ul>
				<ul>
					<li class="available" id='5'></li>
					<li class="available" id='6'></li>
				</ul>
				<ul>
					<li class="available" id='7'></li>
					<li class="available" id='8'></li>
				</ul>
			</div>
			<div class="box2">
				<ul>
					<li class="available" id='9'></li>
					<li class="available" id='10'></li>
				</ul>
				<ul>
					<li class="available" id='11'></li>
					<li class="available" id='12'></li>
				</ul>
				<ul>
					<li class="available" id='13'></li>
					<li class="available" id='14'></li>
				</ul>
				<ul>
					<li class="available" id='15'></li>
					<li class="available" id='16'></li>
				</ul>
			</div>
			<div class="box3">
				<ul>
					<li class="available" id='17'></li>
					<li class="available" id='18'></li>
				</ul>
				<ul>
					<li class="available" id='19'></li>
					<li class="available" id='20'></li>
				</ul>
				<ul>
					<li class="available" id='21'></li>
					<li class="available" id='22'></li>
				</ul>
				<ul>
					<li class="available" id='23'></li>
					<li class="available" id='24'></li>
				</ul>
			</div>
			<div class="box4">
				<ul>
					<li class="available" id='25'></li>
					<li class="available" id='26'></li>
				</ul>
				<ul>
					<li class="available" id='27'></li>
					<li class="available" id='28'></li>
				</ul>
				<ul>
					<li class="available" id='29'></li>
					<li class="available" id='30'></li>
				</ul>
				<ul>
					<li class="available" id='31'></li>
					<li class="available" id='32'></li>
				</ul>
			</div>
			<div class="box5">
				<ul>
					<li class="available" id='33'></li>
					<li class="available" id='34'></li>
				</ul>
				<ul>
					<li class="available" id='35'></li>
					<li class="available" id='36'></li>
				</ul>
				<ul>
					<li class="available" id='37'></li>
					<li class="available" id='38'></li>
				</ul>
				<ul>
					<li class="available" id='39'></li>
					<li class="available" id='40'></li>
				</ul>
			</div>
			<div class="box6">
				<ul>
					<li class="available" id='41'></li>
					<li class="available" id='42'></li>
				</ul>
				<ul>
					<li class="available" id='43'></li>
					<li class="available" id='44'></li>
				</ul>
				<ul>
					<li class="available" id='45'></li>
					<li class="available" id='46'></li>
				</ul>
				<ul>
					<li class="available" id='47'></li>
					<li class="available" id='48'></li>
				</ul>
			</div>
			<div class="box7">
				<ul>
					<li class="available" id='49'></li>
					<li class="available" id='50'></li>
				</ul>
				<ul>
					<li class="available" id='51'></li>
					<li class="available" id='52'></li>
				</ul>
				<ul>
					<li class="available" id='53'></li>
					<li class="available" id='54'></li>
				</ul>
				<ul>
					<li class="available" id='55'></li>
					<li class="available" id='56'></li>
				</ul>
				<ul>
					<li class="available" id='57'></li>
					<li class="available" id='58'></li>
				</ul>
				<ul>
					<li class="available" id='59'></li>
				</ul>
			</div>
			<div class="box8">
				<ul>
					<li class="available" id='60'></li>
					<li class="available" id='61'></li>
				</ul>
				<ul>
					<li class="available" id='62'></li>
					<li class="available" id='63'></li>
				</ul>
				<ul>
					<li class="available" id='64'></li>
					<li class="available" id='65'></li>
				</ul>
				<ul>
					<li class="available" id='66'></li>
					<li class="available" id='67'></li>
				</ul>
				<ul>
					<li class="available" id='68'></li>
					<li class="available" id='69'></li>
				</ul>
				<!--   <ul>
          <li class="lastbox"></li>
        </ul> -->
			</div>
			<div id="ar_box">
				<span> <!--img-->
				</span>
			</div>
		</section>

	</div>

	<!-- jQuery -->
	<script src="../../../resources/js/lib/jQuery/jQuery-2.1.4.min.js"></script>

	<script type="text/javascript">
	
		function tabletsinc() {

			var floor = 4;

			$.ajax({
				url : "/tablet/getListForSeat.do",
				type : "post",
				data : {
					floor : floor
				},
				dataType : "json",
				success : function(tabletdto) {

					$(tabletdto).each(function(idx, data)  {
						if (data.seat_useable_state == 'N') {
							$('#'+data.seat_id).attr("class", "unavailable");
						}
						else{
							if(data.user_leave_yn == 'Y') {
								$('#'+data.seat_id).attr("class", "available");
							} else {
								if (data.user_leave_yn != null || data.user_leave_yn == 'N') {
									$('#'+data.seat_id).attr("class", "occupied");
								}
								else{
									$('#'+data.seat_id).attr("class", "available");
								}
							}
						}
					});
				}
			});
		}
		$(document).ready(function() {
			setInterval("tabletsinc()", 3000);
		});
	</script>

</body>
</html>