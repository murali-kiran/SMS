<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<script>
  $(function() {
		
		$("#academicStartYear,#academicEndYear").datepicker({
			dateFormat : 'mm-dd-yy',
		});	
  });
  
  function formValidation(){
	  
	  var status = true;
	  
	  if($("select[name='classId'] :selected").val()==""){
		  status= false;
		  $("select[name='classId'] ~ span").remove();
		  $("select[name='classId']").after($('<span style="color:#ff0000">&nbsp;*</span>'));
	  }else{
		  $("select[name='classId'] ~ span").remove();
	  }
	  
	  if($("select[name='teacherId'] :selected").val()==""){
		  status= false;
		  $("select[name='teacherId'] ~ span").remove();
		  $("select[name='teacherId']").after($('<span style="color:#ff0000">&nbsp;*</span>'));
	  }else{
		  $("select[name='teacherId'] ~ span").remove(); 
	  }
	  
	  if($("select[name='sectionId'] :selected").val()==""){
		  status= false;
		  $("select[name='sectionId'] ~ span").remove();
		  $("select[name='sectionId']").after($('<span style="color:#ff0000">&nbsp;*</span>'));
	  }else{
		  $("select[name='sectionId'] ~ span").remove();
	  }
	  
	  if($("#academicStartYear").val()==""){
		  status= false;
		  $("#academicStartYear ~ span").remove();
		  $("#academicStartYear").after($('<span style="color:#ff0000">&nbsp;*</span>'));
	  }else{
		  $("#academicStartYear ~ span").remove();
	  }
	  
	  if($("#academicEndYear").val()==""){
		  status= false;
		  $("#academicEndYear ~ span").remove();
		  $("#academicEndYear").after($('<span style="color:#ff0000">&nbsp;*</span>'));
	  }else{
		  $("#academicEndYear ~ span").remove();
	  }
	  
	  return status;
  } 
  
</script>



<form method="post"	action="${pageContext.servletContext.contextPath}/saveClassDetails" onsubmit="return formValidation();">

	<c:if test="${not empty response}">
		<c:choose>
			<c:when test="${response.status}">
				<div class="success">${response.message}</div>
			</c:when>
			<c:otherwise>
				<div class="error">${response.message}</div>
			</c:otherwise>
		</c:choose>
	</c:if>

	<table >
			<tr>
				<td><label for="academicStartYear">Academic Start Year</label></td>
				<td><input type="text" name="academicStartYear" id="academicStartYear"/></td>
			</tr>
			<tr>
				<td><label  for="academicEndYear">Academic End Year</label></td>
				<td><input type="text" name="academicEndYear" id="academicEndYear"  /></td>
			</tr>
			<tr>
				<td><label  for="studentClass" style="font-weight: bold;font-size: 13.5px;color: #333333;">Select Class</label></td>
				<td>
				<select name="classId" >
					<option value="">-Select-</option>
						<c:forEach items="${classes}" var="class">
						   <option value="${class.classId}">${class.className}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td><label  for="section">Select Section</label></td>
				<td>
				    <select name="sectionId" >
							<option value="">-Select-</option>
							<c:forEach items="${sections}" var="section">
								<option value="${section.sectionId}">${section.sectionName}</option>
							</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><label  for="teacher">Select class Teacher</label></td>
				<td><select name="teacherId" >
							<option value="">-Select-</option>
							<c:forEach items="${teachers}" var="teacher">
								<option value="${teacher.id}">${teacher.name}</option>
							</c:forEach>
					</select>
				</td>
			</tr>
		
		</table>

	<div><input type="submit" value="Create" /></div>

</form>