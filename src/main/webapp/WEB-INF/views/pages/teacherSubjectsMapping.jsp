<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script>
  function formValidation(){
	  
/**	  var status ;
	  try {
		  
		  $.ajaxSetup({
        	  async: false
           });
		
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
		}*/
		
		return true;
  }
  
 function getSubjectsOfTeacher(){
	 var teachingStaffId = $("select[name='teacherList'] :selected").val();
	 try {
		
	// {"teachingStaffSubjectIds":[1],"status":true}
	 
	 if($.trim(teachingStaffId) !=  ''){
		 
		 $.ajaxSetup({
       	  async: false
          });
		 
	  $.getJSON( "${pageContext.servletContext.contextPath}/getSubjectsOfTeacher", { teacherId : $("select[name='teacherList'] :selected").val()},function(json) {
		  
		  $("input[type='checkbox'][name='subject']").each(function(){
			  
			  var isExist = false;
			  var subjectId = $(this).val();
			 
			  for(var i=0;i< json.teachingStaffSubjectIds.length;i++){
				  
				  if( subjectId == json.teachingStaffSubjectIds[i]){
				  $("input[type='checkbox'][name='subject'][value='"+json.teachingStaffSubjectIds[i]+"']").prop('checked', true);
				  isExist = true;
				  break;
				  }
			  }
			  
			  if(!isExist){
				  $("input[type='checkbox'][name='subject'][value='"+subjectId+"']").prop('checked', false);
			  }
		  });
	  });
	 }else{
		 $("input[type='checkbox'][name='subject']").each(function(){
			 $(this).prop('checked',false);
		 });
	 }
	 
	 } catch (e) {
			alert(e);
		}
 }
</script>

<form method="post" action="${pageContext.servletContext.contextPath}/saveTeacherAndSubjectMapping" onsubmit="return formValidation();">
	
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
	
	<fieldset style="width: 80%;">
		<legend>Teacher and Subjects Mapping</legend>
		<div align="center">
			<table >
				<tr>
					<td>
						<label for="teacher" style="font-weight: bold;font-size: 13.5px;color: #333333;">Select Teacher to map Subjects : </label>
						<select name="teacherList" onchange="getSubjectsOfTeacher()">
							<option value="">-Select-</option>
							<c:forEach items="${teachers}" var="teacher">
								<option value="${teacher.id}">${teacher.name}</option>
							</c:forEach>
						</select>
					</td>
					<td>&nbsp; ======> &nbsp;</td>
					<td>
						<label for="teacher" style="font-weight: bold;font-size: 13.5px;color: #333333;">Subjects : </label>
							<div class="scrollboxY" id="subjectsDiv">
							<c:forEach items="${subjects}" var="subject">
							<div><input type="checkbox" value="${subject.subjectId}" name ="subject" style="font-size: 12px;"/>${subject.subjectName}</div>
							</c:forEach>
							</div>
					</td>
				</tr>
			</table>
			<br />
		</div>
		<div>
			&nbsp;<input type="submit" value="Save" />
		</div>
	</fieldset>

</form>