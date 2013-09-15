<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true" %>

<%-- background-repeat: repeat-x; background-image: url('<%=request.getContextPath()%>/resources/img/headerBg.jpg'); --%>
<div style="height: 90px;">
	<table style="width: 100%; height: 100%;" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<sec:authorize access="isAuthenticated()">
				<td style="width: 200px; vertical-align: top; padding-right: 5px; padding-top: 5px; text-align: right;">
					<sec:authentication property="principal.username" />
				</td>	
			</sec:authorize>					
		</tr>
		<tr>
			<sec:authorize access="isAuthenticated()">
					<td style="width: 200px; vertical-align: bottom; text-align: right; padding-right: 5px; padding-bottom: 10px;"><a href="${pageContext.servletContext.contextPath}/logout">logout</a></td>
			</sec:authorize>			
		</tr>
	</table>
</div>

