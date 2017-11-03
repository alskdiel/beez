<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String floor = request.getParameter("floor"); %>
<table class="outer">
	<tr>
		<td>
			<div>				
				<jsp:include page="status/inner_section.jsp" flush="false">
					<jsp:param name="seat_no" value="<%=1%>" />
					<jsp:param name="section" value="A" />
					<jsp:param name="floor" value="<%=floor %>" />
				</jsp:include>
			</div>
		</td>
		<td>
			<div>
				<jsp:include page="status/inner_section.jsp" flush="false">
					<jsp:param name="seat_no" value="<%=9%>" />
					<jsp:param name="section" value="A" />
					<jsp:param name="floor" value="<%=floor %>" />
					
				</jsp:include>
			</div>
		</td>
		<td>
			<div>
				<jsp:include page="status/inner_section.jsp" flush="false">
					<jsp:param name="seat_no" value="<%=17%>" />
					<jsp:param name="section" value="A" />
					<jsp:param name="floor" value="<%=floor %>" />
				</jsp:include>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div>
				<jsp:include page="status/inner_bottomA.jsp" flush="false">
					<jsp:param name="seat_no" value="<%=25%>" />
					<jsp:param name="section" value="A" />
					<jsp:param name="floor" value="<%=floor %>" />
				</jsp:include>
			</div>
			<div class="enterance">
				출입구
			</div>
		</td>
		<td>
			<div></div>
		</td>
		<td class="ent-wrapper">
			<div>
				<div class="enterance alone">
					출입구
				</div>
			</div>
		</td>
	</tr>
</table>