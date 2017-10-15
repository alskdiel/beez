<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<%@include file="./include/resources.jsp"%>

</head>

<body class="sidebar-mini">

	<div class="wrapper">
		
		<%@include file="./include/header.jsp"%>


		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">

			  <div class="textbox">
                <h2>근무중</h2>
                <div id="t_box01">나의위치</div>
                <div id="t_box02">2017년 0월 00일 09시 30분에 출근하셨습니다.</div>  
              </div>
			</section>
		    <div class="bar_01">
              <p class="sub_img01"><!--이미지--></p>
		      <div class="m_t"><a href="#">내 근태 정보</a></div>
		      <i class="fa fa-angle-right" aria-hidden="true"></i>
		    </div>
		    <div class="bar_02">
		      <p class="sub_img02"><!--이미지--></p>
		      <div class="m_t"><a href="#">전체 좌석 정보</a></div>
		      <i class="fa fa-angle-right" aria-hidden="true"></i>
		    </div>
		<div class='control-sidebar-bg'></div>
	</div>
	
	
	<%@include file="./include/footer.jsp"%>
	
    <link href="/resources/css/main.css" rel="stylesheet" type="text/css" />
    
</body>
</html>
