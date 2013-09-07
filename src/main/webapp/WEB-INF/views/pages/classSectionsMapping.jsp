<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script>
  function formValidation(){
	  
	  var status = true ;
/* 	  try {
		var classId =  $('select[name="classList"]').val();
		
		} catch (e) {
		alert("exception : "+e);
		} */
		
		return true;
  }
  
 function getSectiontsOfClass(){
	 var classId = $("select[name='classList'] :selected").val();
	 try {
		
	// {"teachingStaffSubjectIds":[1],"status":true}
	 
	 if($.trim(classId) !=  ''){
		 
		 $.ajaxSetup({
       	  async: false
          });
		 
	  $.getJSON( "${pageContext.servletContext.contextPath}/getSectionsOfClass", { classId : $("select[name='classList'] :selected").val()},function(json) {
		  
		  $("input[type='checkbox'][name='section']").each(function(){
			  
			  var isExist = false;
			  var sectionId = $(this).val();
			 
			  for(var i=0;i< json.classSectionIds.length;i++){
				  
				  if( sectionId == json.classSectionIds[i]){
				  $("input[type='checkbox'][name='section'][value='"+json.classSectionIds[i]+"']").prop('checked', true);
				  isExist = true;
				  break;
				  }
			  }
			  
			  if(!isExist){
				  $("input[type='checkbox'][name='section'][value='"+sectionId+"']").prop('checked', false);
			  }
		  });
	  });
	  
	 }else{
		 $("input[type='checkbox'][name='section']").each(function(){
			 $(this).prop('checked',false);
		 });
	 }
	 
	 } catch (e) {
			alert(e);
		}
 }
</script>

<form method="post" action="${pageContext.servletContext.contextPath}/saveClassAndSectionMapping" onsubmit="return formValidation();">
	
	
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
		<legend>Class and Sections Mapping</legend>
		<div align="center">
			<table >
				<tr>
					<td>
						<label for="classes" style="font-weight: bold;font-size: 13.5px;color: #333333;">Select Class to map Sections : </label>
						<select name="classList" onchange="getSectiontsOfClass()">
							<option value="">-Select-</option>
							<c:forEach items="${classes}" var="class">
								<option value="${class.classId}">${class.className}</option>
							</c:forEach>
						</select>
					</td>
					<td>&nbsp; ======> &nbsp;</td>
					<td>
						<label for="section" style="font-weight: bold;font-size: 13.5px;color: #333333;">Sections : </label>
							<div class="scrollboxY" id="subjectsDiv">
							<c:forEach items="${sections}" var="section">
							<div><input type="checkbox" value="${section.sectionId}" name ="section" style="font-size: 12px;"/>&nbsp;${section.sectionName}-Section</div>
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