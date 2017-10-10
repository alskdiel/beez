<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header class="main-header">
	<!-- Logo -->
	
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top" role="navigation">

		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<spanclass="icon-bar"></span>
		</a>
		
		<a href="/" class="navbar-userinfo">
			<span class="logo-lg">
				<b>홍길동</b> 부서
			</span>
		</a>
		
		
	
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<li class="dropdown">
					<a href="#" class=""> <!-- mini logo for sidebar mini 50x50 pixels -->
						<i class="fa fa-bell-o" aria-hidden="true"></i>
					</a>
				</li>
			</ul>
		</div>
	</nav>
</header>

<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->

		<div class="user-panel beez-logo">
			<a href="">
				SSG BEEZ
			</a>
		</div>
		


		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="treeview">
				<a href="#">
					<i class="fa fa-dashboard"></i>
						<span>근태관리</span>
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					<li>
						<a href="/myattend.do">
							- 캘린더
						</a>
					</li>
					<li>
						<a href="/myattstat.do">
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
						<a href="/seats.do">
							- 전체좌석정보
						</a>
					</li>
					<li>
						<a href="/seatstat.do">
							- 좌석통계
						</a>
					</li>
					<li>
						<a href="/myseat.do">
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
	</section>
	<!-- /.sidebar -->
</aside>

<script type="text/javascript">
	
	function sendAndroidMsg(){
		window.beez.startActivityFunction('SSGKEYSETTING');
	}
	function getPosition(alias, addr){
		alert(alias);
	
	}
</script>