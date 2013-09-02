<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<script>

  $(function() {
	  
	  $.ajaxSetup({
    	  async: false
       });
		
		$("#dateOfBirth,#joiningDate").datepicker({
			dateFormat : 'mm-dd-yy',
			maxDate : '0'
		});

		$(':input').prop('disabled', true);
		
  });
  
  function editStudent(){
	  try {
		  
		 
		  
		 $.getJSON("${pageContext.request.contextPath}/saveStudentDetails",{studentId : $('#studentId').val(),name:$('#name').val(),surName:$('#surName').val(),dateOfBirth:$('#dateOfBirth').val(),joiningDate:$('#joiningDate').val(),isPhysicallyChallenged:$('#isPhysicallyChallenged').val(),description:$('#description').val()},function (json){ 
			 alert(data);
		 });
	  } catch (e) {
			alert(e);
		}
  } 
  function editParent(){
    	 $.getJSON("${pageContext.request.contextPath}/saveStudentParentDetails", {studentId : $('#studentId').val(),offset:$('#listCount').val(),name:$('').val()},function (json){});
  }
  function editPerAddress(){
	     $.getJSON("${pageContext.request.contextPath}/saveStudentPermanentAddress", {studentId : $('#studentId').val(),offset:$('#listCount').val(),name:$('').val()},function (json){});
  }
  function editTempAddress(){
	    $.getJSON("${pageContext.request.contextPath}/saveStudentTemporaryAddress", {studentId : $('#studentId').val(),name:$('#name').val(),surName:$('#surName').val(),dateOfBirth:$('#dateOfBirth').val(),joiningDate:$('#joiningDate').val(),isPhysicallyChallenged:$('#isPhysicallyChallenged').val(),description:$('#description').val()},function (json){});
  }
  function enable(id,funName) {
		$(id + ' :input').prop('disabled', false);
		$(id).append('<tr><td align="right" colspan="3" ><input type="button" value="Save"  onclick="'+funName+';"/></td></tr>');
  }
	
  function formValidation() {
		try {
			var dateStart = $("#dateOfBirth").val();
			var dateEnd = $.datepicker.formatDate('mm-dd-yy', new Date());

			var startDateSplit = dateStart.split('-');
			var endDateSplit = dateEnd.split('-');

			var stDate = new Date(startDateSplit[2], startDateSplit[0] - 1,
					startDateSplit[1]);
			var enDate = new Date(endDateSplit[2], endDateSplit[0] - 1,
					endDateSplit[1]);

			var diff = (enDate.getTime() - stDate.getTime())
					/ (1000 * 60 * 60 * 24);

			if (diff < 2) {
				/* 1245 */
				alert("Student as to above 3.5 years ");
				return false;
			} else {
				return true;
			}

		} catch (e) {
			alert(e);
		}
		alert(diff);
		return false;
	}
</script>

<form:form method="post"
	action="${pageContext.servletContext.contextPath}/saveStudentDetails"
	modelAttribute="student" onsubmit="<%-- return formValidation() --%>">

	<c:if test="${error}">
		<div class="error">* Required Fields are Mandatory</div>
	</c:if>

	<fieldset style="width: 50%;">
		<legend>Student Details</legend>
		<div align="right">
			<a href="#" onclick="enable('#studentTbl','editStudent()');">edit</a>
		</div>
		<table id="studentTbl">
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
				<td><form:radiobutton path="isPhysicallyChallenged" value="1"
						id="isPhysicallyChallenged" />Yes &nbsp; <form:radiobutton
						path="isPhysicallyChallenged" value="0" />No</td>
				<td><form:errors path="isPhysicallyChallenged" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:textarea path="description" /></td>
				<td><form:errors path="description" cssClass="error" /></td>
			</tr>
		</table>
	</fieldset>

	<fieldset style="width: 50%;">
		<legend>Parent Details</legend>
		<div align="right">
			<a href="#" onclick="enable('#parentTbl','editParent()');">edit</a>
		</div>
		<table id="parentTbl">
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
	</fieldset>

	<fieldset style="width: 50%;">
		<legend>Permanent Address</legend>
		<div align="right">
			<a href="#" onclick="enable('#perAddrTbl','editPerAddress()');">edit</a>
		</div>
		<table id="perAddrTbl">
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

	<fieldset style="width: 50%;">
		<legend>Temporary Address</legend>
		<div align="right">
			<a href="#" onclick="enable('#tempAddrTbl','editTempAddress()');">edit</a>
		</div>
		<table id="tempAddrTbl">
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

	<input type="hidden" id="studentId" value="${studentId}"></input>

	<input type="submit" value="Create" />

</form:form>