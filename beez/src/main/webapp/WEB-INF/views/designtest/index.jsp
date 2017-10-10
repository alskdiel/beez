<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" 
		 language="java" 
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Beez</title>
    
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    
    <!-- Bootstrap 3.3.4 -->
    <link href="../../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />



    
    <script src="../../../resources/js/navbar.js"></script>  

    <!-- Theme style -->
    <link href="../../../resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
	     folder instead of downloading all of them to reduce the load. -->
    <link href="../../../resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />

	<!-- customed css -->
    <link href="../../../resources/css/header.css" rel="stylesheet" type="text/css" />

</head>

<body class="sidebar-mini">

	<div class="wrapper">
		
	    <header class="main-header">
		    <!-- Logo -->
		    
		    <!-- Header Navbar: style can be found in header.less -->
		    <nav class="navbar navbar-static-top" role="navigation">

			    <!-- Sidebar toggle button-->
			    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
				    <span class="icon-bar"></span>
				    <span class="icon-bar"></span>
				    <span class="icon-bar"></span>
			    </a>
			    
			    <a href="#" class="navbar-userinfo">
				    <span class="logo-lg">
					   <b>홍길동</b>
					   부서
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
							    <a href="#">
								    - 캘린더
							    </a>
						    </li>
						    <li>
							    <a href="#">
								    - 근태통계
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
							    <a href="/tablet/9f.do">
								    - 전체좌석정보
							    </a>
						    </li>
						    <li>
							    <a href="#">
								    - 좌석통계
							    </a>
						    </li>
						    <li>
							    <a href="#">
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
								    - 설정
							    </a>
						    </li>
						    <li>
							    <a href="javascript:sendAndroidMsg()">
								    - SSG KEY 연동 설정
							    </a>
							    </li>
					    </ul>
				    </li>
			    </ul>
		    </section>
		    <!-- /.sidebar -->
	    </aside>


		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">인덱스</section>
		</div>
		
		<div class='control-sidebar-bg'></div>
	</div>
	
	
	
	<!-- jQuery -->
	<script src="../../../resources/js/lib/jQuery/jQuery-2.1.4.min.js"></script>
	
	<!-- Bootstrap 3.3.2 JS -->
    <script src="../../../resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='../../../resources/js/lib/fastclick/fastclick.min.js'></script>
    
    <!-- AdminLTE App -->
    <script src="../../../resources/dist/js/app.min.js" type="text/javascript"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="../../../resources/dist/js/demo.js" type="text/javascript"></script>
    
    

    <script type="text/javascript">
	    function sendAndroidMsg(){
		    window.beez.startActivityFunction('SSGKEYSETTING');
	    }
    </script>
    
    
    
</body>
</html>
