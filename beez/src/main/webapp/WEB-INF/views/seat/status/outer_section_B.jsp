<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table class="outer">
	<tr>
		<td>
			<div>				
				<jsp:include page="status/inner_section.jsp" flush="false">
					<jsp:param name="seat_no" value="<%=36%>" />
				</jsp:include>
			</div>
		</td>
		<td>
			<div>
				<jsp:include page="status/inner_section.jsp" flush="false">
					<jsp:param name="seat_no" value="<%=44%>" />
				</jsp:include>
			</div>
		</td>
		<td>
			<div>
				<jsp:include page="status/inner_section.jsp" flush="false">
					<jsp:param name="seat_no" value="<%=52%>" />
				</jsp:include>
			</div>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<div></div>
		</td>
		<td>
			<div>
				<jsp:include page="status/inner_bottomB.jsp" flush="false">
					<jsp:param name="seat_no" value="<%=60%>" />
				</jsp:include>
			</div>
		</td>
	</tr>
</table>