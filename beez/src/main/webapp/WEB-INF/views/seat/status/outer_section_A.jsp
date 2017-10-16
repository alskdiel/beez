<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table class="outer">
	<tr>
		<td>
			<div>				
				<jsp:include page="status/inner_section.jsp" flush="false">
					<jsp:param name="seat_no" value="<%=1%>" />
				</jsp:include>
			</div>
		</td>
		<td>
			<div>
				<jsp:include page="status/inner_section.jsp" flush="false">
					<jsp:param name="seat_no" value="<%=9%>" />
				</jsp:include>
			</div>
		</td>
		<td>
			<div>
				<jsp:include page="status/inner_section.jsp" flush="false">
					<jsp:param name="seat_no" value="<%=17%>" />
				</jsp:include>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div>
				<jsp:include page="status/inner_section.jsp" flush="false">
					<jsp:param name="seat_no" value="<%=25%>" />
				</jsp:include>
			</div>
		</td>
		<td colspan="2">
			<div></div>
		</td>
	</tr>
</table>