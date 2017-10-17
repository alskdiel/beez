<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="floor 14f" id="floor-14">
	<div class="floor-container">
		<div>
			<span>14층</span>
		</div>

		<div class="tab-content">
			<div class="tab-pane active" id="section-14A">
				<%@include file="status/outer_section_A.jsp"%>
			</div>

			<div class="tab-pane" id="section-14B">
				<%@include file="status/outer_section_B.jsp"%>
			</div>

		</div>

		<ul class="nav nav-tabs">
			<li class="active"><a href="#section-14A" data-toggle="tab">A</a></li>
			<li><a href="#section-14B" data-toggle="tab">B</a></li>
		</ul>

	</div>
</div>
