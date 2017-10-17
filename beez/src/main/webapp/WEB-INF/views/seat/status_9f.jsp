<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 
<div class="all">
	<div class="box1">
		<ul>
			<li></li>
			<li></li>
		</ul>
		<ul>
			<li></li>
			<li></li>
		</ul>
		<ul>
			<li></li>
			<li></li>
		</ul>
		<ul>
			<li></li>
			<li></li>
		</ul>
	</div>
	<div class="box2">
		<ul>
			<li></li>
			<li></li>
		</ul>
		<ul>
			<li></li>
			<li></li>
		</ul>
		<ul>
			<li></li>
			<li></li>
		</ul>
		<ul>
			<li></li>
			<li></li>
		</ul>
	</div>
	<div class="box3">
		<ul>
			<li></li>
			<li></li>
		</ul>
		<ul>
			<li></li>
			<li></li>
		</ul>
		<ul>
			<li></li>
			<li></li>
		</ul>
		<ul>
			<li></li>
			<li></li>
		</ul>
	</div>
</div>
 -->



<div class="floor 9f" id="floor-9">
	<div class="floor-container">
		<div>
			<span>9층</span>
		</div>
		<div class="tab-content">
			<div class="tab-pane active" id="section-9A">
				<%@include file="status/outer_section_A.jsp"%>
			</div>

			<div class="tab-pane" id="section-9B">
				<%@include file="status/outer_section_B.jsp"%>
			</div>

		</div>
		<ul class="nav nav-tabs">
			<li class="active"><a href="#section-9A" data-toggle="tab">A</a></li>
			<li><a href="#section-9B" data-toggle="tab">B</a></li>
		</ul>

	</div>
</div>
