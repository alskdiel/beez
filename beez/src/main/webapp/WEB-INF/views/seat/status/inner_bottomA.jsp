<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% int seat_no = Integer.parseInt(request.getParameter("seat_no")); %>
<table class="inner">
	<tr>
		<td id="<%= seat_no++ %>"></td>
		<td id="<%= seat_no++ %>"></td>
	</tr>
	<tr>
		<td id="<%= seat_no++ %>"></td>
		<td id="<%= seat_no++ %>"></td>
	</tr>
	<tr>
		<td id="<%= seat_no++ %>"></td>
		<td id="<%= seat_no++ %>"></td>
	</tr>
	<tr>
		<td id="<%= seat_no++ %>"></td>
		<td id="<%= seat_no++ %>"></td>
	</tr>
	<tr>
		<td id="<%= seat_no++ %>"></td>
		<td id="<%= seat_no++ %>"></td>
	</tr>
	<tr>
		<td id="<%= seat_no++ %>"></td>
	</tr>
</table>