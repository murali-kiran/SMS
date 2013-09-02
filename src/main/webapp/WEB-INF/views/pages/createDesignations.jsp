<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script>
  function formValidation(){
	  
	  var status ;
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
		}
  }
</script>

<form method="post" action="${pageContext.servletContext.contextPath}/saveNewDesignation" onsubmit="return formValidation();">

	
		<div class="error"></div>
	

	<fieldset style="width: 80%;">
		<legend>New Subjects</legend>
		<div align="center">
			<table>
				<tr>
					<td><label for="designationName">Designation Name : </label></td>
					<td><input type="text" name="designationName" id="designationName" /></td>
				</tr>
				<tr>
					<td><label for="designationType">Designation Type : </label></td>
					<td><select name="designationType">
							<option>-Select-</option>
							<option value="1">Teaching</option>
							<option value="2">Non-Teaching</option>
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