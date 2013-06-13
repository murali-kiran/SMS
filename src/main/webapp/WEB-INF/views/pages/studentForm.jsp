<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<script>

$(function(){
	$("#dateOfBirth,#joiningDate").datepicker({ 
		dateFormat: 'mm-dd-yy',
		maxDate: '0'
	});
});

function formValidation(){
	
	  try{
		  
      var dateStart = $("#dateOfBirth").val();
	  var dateEnd = $.datepicker.formatDate('mm-dd-yy', new Date()); 
	  
	  var startDateSplit =   dateStart.split('-');
	  var endDateSplit   =   dateEnd.split('-');

	  var stDate = new Date(startDateSplit[2], startDateSplit[0] - 1, startDateSplit[1]);
	  var enDate = new Date(endDateSplit[2], endDateSplit[0] - 1, endDateSplit[1]);

	  var diff = (enDate.getTime() - stDate.getTime()) / (1000 * 60 * 60 * 24);
	  
	  if(diff < 2){
		  /* 1245 */
		  alert("Student as to above 3.5 years ");
		  return false;
	  }else{
		  return true;
	  }
	  
	  }
	  catch (e) {
			alert(e);
		}
	  
	  alert(diff);
	  return false;
}

</script>

<form:form method="post" action="${pageContext.servletContext.contextPath}/saveStudentDetails" 
   modelAttribute="student" onsubmit="return formValidation()" >

<c:if test="${error}">
<div class="error">* Required Fields are Mandatory </div>
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
			<td><form:label path="joiningDate">Date of joining </form:label></td>
			<td><form:input path="joiningDate" id="joiningDate" /></td>
			<td><form:errors path="joiningDate" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="isPhysicallyChallenged">PhysicallyChallenged </form:label></td>
			<td><form:radiobutton path="isPhysicallyChallenged" value="true"/>Yes &nbsp;
			<form:radiobutton path="isPhysicallyChallenged" value="false"/>No</td>
			<td><form:errors path="isPhysicallyChallenged" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="description">Description</form:label></td>
			<td><form:textarea path="description" /></td>
			<td><form:errors path="description" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="fatherName">Father Name</form:label></td>
			<td><form:textarea path="fatherName" /></td>
			<td><form:errors path="fatherName" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="fatherDesignation">Father Designation</form:label></td>
			<td><form:textarea path="fatherDesignation" /></td>
			<td><form:errors path="fatherDesignation" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="motherName">Mother Name</form:label></td>
			<td><form:textarea path="motherName" /></td>
			<td><form:errors path="motherName" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="motherDesignation">Mother Designation</form:label></td>
			<td><form:textarea path="motherDesignation" /></td>
			<td><form:errors path="motherDesignation" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="gaurdian">Gaurdian</form:label></td>
			<td><form:textarea path="gaurdian" /></td>
			<td><form:errors path="gaurdian" cssClass="error" /></td>
		</tr>	
	</table>

	<fieldset >
		<legend>Permanent Address</legend>
		<table>
			<tr>
				<td><form:label path="address1">Hno </form:label></td>
				<td><form:textarea path="address1" /></td>
				<td><form:errors path="address1" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="district1">District</form:label></td>
				<td><form:textarea path="district1" /></td>
				<td><form:errors path="district1" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="pincode1">Pincode</form:label></td>
				<td><form:textarea path="pincode1" /></td>
				<td><form:errors path="pincode1" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="state1">State</form:label></td>
				<td><form:textarea path="state1" /></td>
				<td><form:errors path="state1" cssClass="error" /></td>
			</tr>
		</table>
	</fieldset>

     <fieldset >
		<legend>Temporary Address</legend>
		<table>
			<tr>
				<td><form:label path="address2">Hno </form:label></td>
				<td><form:textarea path="address2" /></td>
				<td><form:errors path="address2" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="district2">District</form:label></td>
				<td><form:textarea path="district2" /></td>
				<td><form:errors path="district2" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="pincode2">Pincode</form:label></td>
				<td><form:textarea path="pincode2" /></td>
				<td><form:errors path="pincode2" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="state2">State</form:label></td>
				<td><form:textarea path="state2" /></td>
				<td><form:errors path="state2" cssClass="error" /></td>
			</tr>
		</table>
	</fieldset>
	
	<input type="submit" value="Create" />
	
</form:form>