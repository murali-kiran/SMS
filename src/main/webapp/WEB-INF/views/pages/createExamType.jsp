<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<script>
  
  function AddMoreExamType(){
	  try {
		$('#examTypeTable').append("<tr><td><label  for='examType'>Exam Name :&nbsp;</label></td><td><input type='text' name='examType' id='examType' /></td></tr>");
		} catch (e) {
			alert(e);
		}
  }
  
  function formValidation(){
	  var status = true;
	  
	  try {
	      var examNamesEle = $('input[name="examType"]');
	      var count = 0;
	      var examTypeStr = "";
	      for(var i=0;i<examNamesEle.length;i++){
	    	  var examName = examNamesEle[i].value;
	    	  if($.trim(examName) == ''){
	    	    count++;
	    	  }else{
	    		  if(i==0){
	    			  examTypeStr+=examNamesEle[i].value;
					}else{
					  examTypeStr=examTypeStr+","+examNamesEle[i].value;
					}
	    	  }
	    		  
	      }
	      if(count == examNamesEle.length){
	    	  $('.error').text("* No Exam Name is Filled");
			  status = false;
	      }else{
	    	  if(isMoreThenOne_TxtBoxHaveSameValue(examTypeStr)){
	    		  $('.error').text("* More than one exam name has same value");	
	    		  status = false;
	    	  }else{
	    		  
	    		  $.ajaxSetup({
	            	  async: false
	               });
	    		  
				  $.getJSON("${pageContext.servletContext.contextPath}/alreadyExamTypeExist", {examNames:examTypeStr},function(json) {
					  if(json.status){
						  alert("message : "+json.message);
						  $('.error').text(json.message);
						  status = false;
						  }
				  });
	    		  
	    	  }
	      }
		} catch (e) {
			alert(e);
		}
		
		return status;
  }
  
</script>

<form method="post"	action="${pageContext.servletContext.contextPath}/saveExamType" onsubmit="return formValidation();">

	<div class="error"></div>
	<c:if test="${not empty successMsg}"><div class="success">${successMsg}</div></c:if>
	<fieldset style="width: 80%;" >
		<legend>Exam Type</legend>
		<div align="right" ><input type="button" name="Add More" value="Add More" onclick="AddMoreExamType()"/>&nbsp;</div>
		<div align="center">
		<table id="examTypeTable">
			<tr>
				<td><label  for="examType">Exam Name :&nbsp;</label></td>
				<td><input type="text" name="examType" id="examType"  /></td>
			</tr>
		</table>
		</div>
		<div align="right"><input type="submit" value="Save" />&nbsp;</div>
	</fieldset>

</form>







