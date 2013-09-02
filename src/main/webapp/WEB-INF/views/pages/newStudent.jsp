<!DOCTYPE html>
<html>
<head>
<title>SMS</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/layout.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.css"
	media="screen">
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/css/style.css"
	media="screen">
	

	

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script type="text/javascript"	src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script> -->
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/sliding.form.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/validations.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/newStudentValidation.js"></script>
</head>
<body style="margin: 0px; padding: 0px;">

<script>
$(function() {
	
	$("#joiningDate").datepicker({
		dateFormat : 'mm-dd-yy',
		minDate : new Date()
	});
	
	$("#dateOfBirth").datepicker({
		dateFormat : 'mm-dd-yy',
		maxDate : '0'
	});

});

</script>

	<table border="1" cellspacing="0" cellpadding="0" class="layout">
		<tr class="header">
			<td colspan="2" align="center">SUMADGA HEADER</td>
		</tr>

		<tr class="content">

			<td class="side-panel" nowrap="nowrap" align="center">

				<div class="menu-title"></div>
				<div class="menu-content">
				
				<table >
	<tr height="30px;">
		<td><a href="${pageContext.servletContext.contextPath}/newStudent">New Student</a></td>
	</tr>
	
<%-- 	
   <tr height="30px;">
		<td><a href="${pageContext.servletContext.contextPath}/student">Student Form</a></td>
	</tr>
 --%>
 	
<%-- 	<tr height="30px;">
		<td><a href="${pageContext.servletContext.contextPath}/classesInfo">Class Info</a></td>
	</tr>
 --%>	
<%-- 	<tr height="30px;">
		<td><a href="${pageContext.servletContext.contextPath}/createNewClass">NewClass(no use)</a></td>
	</tr>
 --%>	
	<tr height="30px;">
		<td><a href="${pageContext.servletContext.contextPath}/showNewClass">New Class</a></td>
	</tr>
	
	<tr height="30px;">
		<td><a href="${pageContext.servletContext.contextPath}/createNewSubject">New Subject</a></td>
	</tr>
	
	<tr height="30px;">
		<td><a href="${pageContext.servletContext.contextPath}/createStaff">New Staff</a></td>
	</tr>
	
	<tr height="30px;">
		<td><a href="${pageContext.servletContext.contextPath}/createDesignations">Add Designation</a></td>
	</tr>
	
	<tr height="30px;">
		<td><a href="${pageContext.servletContext.contextPath}/showTeacherAndSubjectMapping">Teacher And SubjectsMapping</a></td>
	</tr>
	
	<tr height="30px;">
		<td><a href="${pageContext.servletContext.contextPath}/createExamType">Add Exams Type</a></td>
	</tr>
 
	<tr height="30px;">
		<td><a href="${pageContext.servletContext.contextPath}/createExamTimeTable">Add Exam TimeTable</a></td>
	</tr>
	
	<tr height="30px;">
		<td><a href="${pageContext.servletContext.contextPath}/showExamTimeTable">Show Exam TimeTable</a></td>
	</tr>
	
</table>
				
</div>
			</td>
			<td class="content">
				<h1 class="title">SMS</h1>
				<div id="content">
					<div id="wrapper">
						<div id="steps">
							<form id="formElem" name="formElem"
								action="${pageContext.servletContext.contextPath}/saveStudentDetails"
								method="post" onsubmit="return studentFormValidateSteps();">

								<fieldset class="step">
									<legend>Student Details</legend>
								 
									<p>
										<span style="text-align: right;display: block;color:#ff0000;" id="errorName">*</span>
										<label for="name">Student Name</label> <input type="text"
											name="name" />
									</p>
									
									<p> 
									<span style="text-align: right;display: block;color:#ff0000;" id="errorSurName">*</span>
									<label for="surname" >Student Surname </label>
										 <input	type="text" name="surName" id="surName"/>
									
									</p>
								
									<p>
										<span style="text-align: right;display: block;color:#ff0000;" id="errorDOb">*</span>
										<label for="dob">Date of Birth </label> <input type="text"
											name="dateOfBirth" id="dateOfBirth" />
									</p>
								
									<p>
										<span style="text-align: right;display: block;color:#ff0000;" id="errorDoj">*</span>
										<label for="joiningDate">Date of joining </label> <input
											type="text" name="joiningDate" id="joiningDate" />
											
									</p>
								
									<p>
										<span style="text-align: right;display: block;color:#ff0000;" id="errorPc">*</span>
										<label for="pc">PhysicallyChallenged </label> <input
											type="radio" name="isPhysicallyChallenged" value="1"
											id="isPhysicallyChallenged" /> Yes &nbsp; <input
											type="radio" name="isPhysicallyChallenged" value="0" /> No
									</p>
								
									<p>
								    	<span style="text-align: right;display: block;color:#ff0000;" id="errorstudentDes">*</span>
										<label for="description">Description</label>
										<textarea name="description"></textarea>
									</p>
								</fieldset>

								<fieldset class="step">
									<legend>Parent Details</legend>
									<p>
											<span style="text-align: right;display: block;color:#ff0000;" id="errorFname">*</span>
										<label for="fathername">Father Name</label>
										<input type="text" name="fatherName"/>
									</p>
									<p>
											<span style="text-align: right;display: block;color:#ff0000;" id="errorFDesig">*</span>
										<label for="fatherDesignation">Father Designation</label>
										<input type="text" name="fatherDesignation"/>
									</p>
									<p>
											<span style="text-align: right;display: block;color:#ff0000;" id="errorMname">*</span>
										<label for="motherName">Mother Name</label>
										<input type="text" name="motherName"/>
									</p>
									<p>
										<span style="text-align: right;display: block;color:#ff0000;" id="errorMDesig">*</span>
										<label for="motherDesignation">Mother Designation</label>
										<input type="text" name="motherDesignation"/>
									</p>
									<p>
										<span style="text-align: right;display: block;color:#ff0000;" id="errorGaurdian">*</span>
										<label for="gaurdian">Gaurdian</label>
										<input type="text" name="gaurdian"/>
									</p>
								</fieldset>

								<fieldset class="step">
									<legend>Permanent Address</legend>
									<p>
										<span style="text-align: right;display: block;color:#ff0000;" id="errorHno1">*</span>
										<label for="address1">Hno </label>
										<textarea name="Addr1Hno"></textarea>
									</p>
									<p>
										<span style="text-align: right;display: block;color:#ff0000;" id="errorDist1">*</span>
										<label for="district1">District</label>
										<input type="text" name="district1"/>
									</p>
									<p>
										<span style="text-align: right;display: block;" id="errorPin1">*</span>
										<label for="pincode1">Pincode</label>
										<input type="text" name="pincode1"/>
									</p>
									<p>
										<span style="text-align: right;display: block;color:#ff0000;" id="errorState1">*</span>
										<label for="state1">State</label>
										<input type="text" name="state1"/>
									</p>
								</fieldset>

								<fieldset class="step">
									<legend>Temporary Address</legend>
									<p>
										<span style="text-align: right;display: block;color:#ff0000;" id="errorHno2">*</span>
										<label for="address2">Hno </label>
										<textarea name="address2"></textarea>
									</p>
									<p>
										<span style="text-align: right;display: block;color:#ff0000;" id="errorDist2">*</span>
										<label for="district2">District</label>
										<input type="text" name="district2"/>
									</p>
									<p>
										<span style="text-align: right;display: block;color:#ff0000;" id="errorPin2">*</span>
										<label for="pincode2">Pincode</label>
										<input type="text" name="pincode2"/>
									</p>
									<p>
										<span style="text-align: right;display: block;color:#ff0000;" id="errorState2">*</span>
										<label for="state2">State</label>
										<input type="text" name="state2"/>
									</p>

									<p class="submit">
									// registerButton
										<button id="newStudentRegisterBtn" type="submit">Save</button>
									</p>

								</fieldset>


							</form>
						</div>

						<div id="navigation" style="display: none;">
							<ul>
								<li class="selected" ><a href="#">Student Details</a></li>
								<li><a href="#" >Parent Details</a></li>
								<li><a href="#" >Permanent Address</a></li>
								<li><a href="#" >Temporary Address</a></li>
							</ul>
						</div>
					</div>
				</div>
			</td>
		</tr>
		<tr class="footer">
			<td colspan="2" align="center">
				<%-- <tiles:insertAttribute name="footer-content" /> --%> SUMADGA
				FOOTER
			</td>
		</tr>
	</table>

</body>
</html>