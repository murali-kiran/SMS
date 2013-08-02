<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script>
  $(function() {		
		$("#joiningDate").datepicker({
			dateFormat : 'mm-dd-yy',
			maxDate : '0'
		});		
  });
  
  function formValidation(){
	  var status ;
	  try {
		  $.getJSON( "${pageContext.servletContext.contextPath}/alreadyDesignationExist", { designationName : $('#designationName').val(), designationType : $("select[name='designationType'] :selected").val() },function(json) {
		  if(json.status){
			  alert("message : "+json.message);
			  $('.error').text(json.message);
			    status = false;
			  }
		  else{
				status = true;
			  }
	  });
	  return status; 
		} catch (e) {
		alert("exception : "+e);
		}
  }
</script>

<form method="post" action="${pageContext.servletContext.contextPath}/saveNewStaff" onsubmit="return formValidation();">

	
		<div class="error"></div>
	

	<fieldset style="width: 80%;">
		<legend>New Staff</legend>
		<div align="center">
			<table>
				<tr>
					<td><label for="empName">Employee Name : </label></td>
					<td><input type="text" name="empName" id="empName" /></td>
				</tr>
				<tr>
					<td><label for="designationType">Designation Type : </label></td>
					<td><select name="designationType" >
							<option>-Select-</option>
							<c:forEach items="${designations}" var="designation">
							<option value="${designation.designationId}">${designation.designation}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><label for="joiningDate">Joining Date : </label></td>
					<td><input type="text" name="joiningDate" id="joiningDate" /></td>
				</tr>
			</table>
			<br />
		</div>
		<div>
			&nbsp;<input type="submit" value="Save" />
		</div>
	</fieldset>
</form>