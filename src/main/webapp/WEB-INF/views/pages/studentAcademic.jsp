<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>

<form:form method="post"
	action="${pageContext.servletContext.contextPath}/saveStudentAcademicDetails"
	modelAttribute="student" onsubmit="return formValidation()">

	<c:if test="${error}">
		<div class="error">* Required Fields are Mandatory</div>
	</c:if>
	<table>
		<tr>
			<td><form:label path="name">Student Name </form:label></td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="surName">Student Surname </form:label></td>
			<td><form:input path="surName" /></td>
			<td><form:errors path="surName" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="dateOfBirth">Date of Birth </form:label></td>
			<td><form:input path="dateOfBirth" id="dateOfBirth" /></td>
			<td><form:errors path="dateOfBirth" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="description">Description</form:label></td>
			<td><form:textarea path="description" /></td>
			<td><form:errors path="description" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="class">Class</form:label></td>
			<td><select name="class">
					<c:forEach var="x" items="${classes}">
						<option value="${x.name}">${x.value}</option>
					</c:forEach>
			</select></td>
			<td><form:errors path="class" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="section">Section</form:label></td>
			<td><select name="section">
					<c:forEach var="x" items="${section}">
						<option value="${x.name}">${x.value}</option>
					</c:forEach>
			</select></td>
			<td><form:errors path="section" cssClass="error" /></td>
		</tr>
	</table>
	<input type="submit" value="Create" />

</form:form>