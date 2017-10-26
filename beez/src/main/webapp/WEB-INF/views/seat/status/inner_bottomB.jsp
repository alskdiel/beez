<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% int seat_no = Integer.parseInt(request.getParameter("seat_no")); %>
<table class="inner">
	<tr>
		<td id="<%= seat_no++ %>">
			<div title="<%=seat_no -1%>" class="btn" data-container="body" data-toggle="popover" data-placement="top">
			</div>
		</td>
		<td id="<%= seat_no++ %>">
			<div title="<%=seat_no -1%>" class="btn" data-container="body" data-toggle="popover" data-placement="top">
			</div>
		</td>
	</tr>
	<tr>
		<td id="<%= seat_no++ %>">
			<div title="<%=seat_no -1%>" class="btn" data-container="body" data-toggle="popover" data-placement="top">
			</div>
		</td>
		<td id="<%= seat_no++ %>">
			<div title="<%=seat_no -1%>" class="btn" data-container="body" data-toggle="popover" data-placement="top">
			</div>
		</td>
	</tr>
	<tr>
		<td id="<%= seat_no++ %>">
			<div title="<%=seat_no -1%>" class="btn" data-container="body" data-toggle="popover" data-placement="top">
			</div>
		</td>
		<td id="<%= seat_no++ %>">
			<div title="<%=seat_no -1%>" class="btn" data-container="body" data-toggle="popover" data-placement="top">
			</div>
		</td>
	</tr>
	<tr>
		<td id="<%= seat_no++ %>">
			<div title="<%=seat_no -1%>" class="btn" data-container="body" data-toggle="popover" data-placement="top">
			</div>
		</td>
		<td id="<%= seat_no++ %>">
			<div title="<%=seat_no -1%>" class="btn" data-container="body" data-toggle="popover" data-placement="top">
			</div>
		</td>
	</tr>
	<tr>
		<td id="<%= seat_no++ %>">
			<div title="<%=seat_no -1%>" class="btn" data-container="body" data-toggle="popover" data-placement="top">
			</div>
		</td>
		<td id="<%= seat_no++ %>">
			<div title="<%=seat_no -1%>" class="btn" data-container="body" data-toggle="popover" data-placement="top">
			</div>
		</td>
	</tr>
	<tr>
		<td class="blank"></td>
	</tr>
</table>