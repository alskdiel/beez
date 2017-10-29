<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="floor 13f" id="floor-13">
	<div class="floor-container">
		<div class="tab-content carousel slide" id="carousel-example-generic">
			<div class="carousel-inner">
				<div class="tab-pane active item" id="section-13A">
					<%@include file="status/outer_section_A.jsp"%>
				</div>
	
				<div class="tab-pane item" id="section-13B">
					<%@include file="status/outer_section_B.jsp"%>
				</div>
			</div>
		</div>

		<ul class="nav nav-tabs">
			<li class="active"><a href="#section-13A" data-toggle="tab">A</a></li>
			<li><a href="#section-13B" data-toggle="tab">B</a></li>
		</ul>

	</div>
</div>
