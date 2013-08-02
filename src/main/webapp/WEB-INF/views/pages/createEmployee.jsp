<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<script>
  $(function() {		
		$("#dateOfBirth,#joiningDate").datepicker({
			dateFormat : 'mm-dd-yy',
			maxDate : '0'
		});		
  });
</script>

<form method="post"
	action="${pageContext.servletContext.contextPath}/saveNewEmployee"
	onsubmit="<!-- return formValidation(); -->">

	<c:if test="${error}">
		<div class="error">* Required Fields are Mandatory</div>
	</c:if>

	<fieldset style="width: 80%;">
		<legend>New Subjects</legend>
		<div align="center">
			<table>
				<tr>
					<td><label for="empName">Employee Name : </label></td>
					<td><input type="text" name="empName" id="empName" /></td>
				</tr>
				<tr>
					<td><label for="empType">Employee Type : </label></td>
					<td><select name="">
							<option>-Select-</option>
							<option value="1">Teaching</option>
							<option value="2">Non-Teaching</option>
					</select></td>
				</tr>
				<tr>
					<td><label for="designation">Designation : </label></td>
					<td><select name="designation">
							<option>-Select-</option>
							<c:forEach items="${desigantions}" var="x">
								<option value="${x.id}">${x.name}</option>
							</c:forEach>
					</select></td>
				</tr>
			</table>
			<br />
		</div>
		<div>
			&nbsp;<input type="submit" value="Save" />
		</div>
	</fieldset>

</form>