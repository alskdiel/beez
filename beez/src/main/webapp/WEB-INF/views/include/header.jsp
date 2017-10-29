<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header class="main-header">
	<!-- Logo -->
	
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top" role="navigation">
	
	 <!-- Sidebar toggle button-->
	 <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
	  
	 </a>
	 <div>
	 	<span class="logo-lg">
	 		SSG BEEZ
	 		<!-- <a class="navbar-userinfo" id ="nav_title"></a> -->
	  	</span>
	 </div>
	 
	<!-- 
	 <div class="navbar-custom-menu">
	  <ul class="nav navbar-nav">
	   <li class="dropdown">
	    <a href="#" class="">
			    <i class="fa fa-bell-o" aria-hidden="true"></i>
		    </a>
	    </li>
	   </ul>
	  </div>
	   -->
	 </nav>
	</header>
	
	<!-- Left side column. contains the logo and sidebar -->
	<aside class="main-sidebar">
	 <!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
	 <!-- Sidebar user panel -->
	
	 <div class="user-panel beez-logo">
	 	<div class="beez-logo-left">
		  <a href="/">
		  	<img src="/resources/images/sidebar/slidebar_logo.png">
		  </a>
	  	</div>
		  <div id="dismiss" class="beez-logo-right">
		  <img src="/resources/images/sidebar/close_btn.png">
		  </div>
		  
	 </div>
	 <!-- 
	<div class="beez-sidebar-content">
		<div>
			<div class="user-name" id = "uname"></div>
			<div class="user-id">p908vd</div>
		</div>
	</div>
 	-->
 
	<div class="beez-sidebar-menus">
		<div class="sidebar-menu-wrapper">
			<div class="sidebar-menu-container">
				<div class="sidebar-menu-row">
					
					<a class="sidebar-icon" href="/att/myattend.do">
						<img src="/resources/images/sidebar/slidebar_icon_1.png"/>
						<div class="sidebar-ititle">캘린더</div>
					</a>
					<a class="sidebar-icon" href="/seat/list.do">
						<img src="/resources/images/sidebar/slidebar_icon_2.png"/>
						<div class="sidebar-ititle">좌석 현황 확인</div>
					</a>
					<a class="sidebar-icon" href="/seat/myseat.do">
						<img src="/resources/images/sidebar/slidebar_icon_3.png"/>
						<div class="sidebar-ititle">좌석 이력</div>
					</a>
					<!-- 
					<a class="sidebar-icon" href="/att/myattstat.do">
						<img src="/resources/images/sidebar/c_statistics.png"/>
					</a>
					-->
				</div>
				<!-- 
				<div class="sidebar-menu-row">
					
					<a class="sidebar-icon" href="/seat/list.do">
						<img src="/resources/images/sidebar/seat.png"/>
					</a>
					<a class="sidebar-icon" href="/seat/seatstat.do">
						<img src="/resources/images/sidebar/s_statistics.png"/>
					</a>
					<a class="sidebar-icon" href="/seat/myseat.do">
						<img src="/resources/images/sidebar/seat-history.png"/>
					</a>
				</div>
				 -->
				<div class="sidebar-menu-row">
					
					<a class="sidebar-icon" href="/settings/AlramSettings.do">
						<img src="/resources/images/sidebar/slidebar_icon_4.png"/>
						<div class="sidebar-ititle">설정 기능</div>
					</a>
					<!-- 
					<a class="sidebar-icon" href="javascript:sendAndroidMsg('SSGKEYSETTING')">
						<img src="/resources/images/sidebar/ssgkey.png"/>
					</a>
					 -->
					<a class="sidebar-icon" href="javascript:sendAndroidMsg('REMOTELOGOFF')">
						<img src="/resources/images/sidebar/slidebar_icon_5.png"/>
						<div class="sidebar-ititle">PC 로그오프</div>
					</a>
					<a class="sidebar-icon" href="javascript:sendAndroidMsg('REMOTELOGOFFRELEASE')">
						<img src="/resources/images/sidebar/slidebar_icon_6.png"/>
						<div class="sidebar-ititle">PC 잠금해제</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	 <!-- sidebar menu: : style can be found in sidebar.less -->
	 
	<!-- 	 
	 <ul class="sidebar-menu">
	 
	 
	 
	  <li class="treeview">
	   <a href="#">
	    <i class="fa fa-dashboard"></i>
		    <span>근태관리</span>
	    <i class="fa fa-angle-left pull-right"></i>
	   </a>
	   <ul class="treeview-menu">
	    <li>
		    <a href="/att/myattend.do">
			    - 캘린더
		    </a>
	    </li>
	    <li>
		    <a href="/att/myattstat.do">
			    - 근태통계
		    </a>
	    </li>
	   </ul>
	  </li>
	  <li class="treeview">
	   <a href="#">
	    <i class="fa fa-dashboard"></i>
		    <span>좌석관리</span>
	    <i class="fa fa-angle-left pull-right"></i>
	   </a>
	   <ul class="treeview-menu">
	    <li>
		    <a href="/seat/list.do">
			    - 전체좌석정보
		    </a>
	    </li>
	    <li>
		    <a href="#">
			    - 좌석통계
		    </a>
	    </li>
	    <li>
		    <a href="/seat/myseat.do">
			    - 자리 이력
		    </a>
	    </li>
	   </ul>
	  </li>
	  <li class="treeview">
	   <a href="#">
	    <i class="fa fa-dashboard"></i>
		    <span>설정</span>
	    <i class="fa fa-angle-left pull-right"></i>
	   </a>
	   <ul class="treeview-menu">
	    <li>
		    <a href="#">
			    - 설정
		    </a>
	    </li>
	    <li>
		    <a href="javascript:sendAndroidMsg()">
			    - SSG KEY 연동 설정
		    </a>
		    </li>
	   </ul>
	  </li>
	 </ul>
	-->
	
	</section>
	<!-- /.sidebar -->
	</aside>
	

<script type="text/javascript">
	
	function sendAndroidMsg(option){
		window.beez.startActivityFunction(option);
	}
	function sendAndroidMsgTwoValue(option, value){
		window.beez.startActivityFunctionTwoValue(option, value);
		
	}
	function getPosition(alias, addr){
//		alert(alias);
	
	}
</script>