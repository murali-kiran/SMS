<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<script>
  
  function AddMoreClasses(){
	  try {
		$('#classNameTable').append("<tr><td><label  for='className'>Class Name :&nbsp;</label></td><td><input type='text' name='className' id='className'  /></td></tr>");
		} catch (e) {
			alert(e);
		}
  }
  
  function formValidation(){
	  var status = true;
	  
	  try {
	      var classNamesEle = $('input[name="className"]');
	      var count = 0;
	      var classNameStr = "";
	      for(var i=0;i<classNamesEle.length;i++){
	    	  var className = classNamesEle[i].value;
	    	  if($.trim(className) == ''){
	    		  count++;
	    	  }else{
	    		  if(i==0){
	    			  classNameStr+=classNamesEle[i].value;
					}else{
					  classNameStr=classNameStr+","+classNamesEle[i].value;
					}
	    	  }
	    		  
	      }
	      if(count == classNamesEle.length){
	    	  $('.error').text("* No Class Name is Filled");
			  status = false;
	      }else{
	    	  if(isMoreThenOne_TxtBoxHaveSameValue(classNameStr)){
	    	  $('.error').text("* More than one Class Name has same value");	
	    	  status = false;
	    	  }else{
				  $.getJSON("${pageContext.servletContext.contextPath}/alreadyClassExist", {classNames:classNameStr},function(json) {
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

<form method="post"	action="${pageContext.servletContext.contextPath}/saveClassInfo" onsubmit="return formValidation();">

	<div class="error"></div>
	<c:if test="${not empty successMsg}"><div class="success">${successMsg}</div></c:if>
	<fieldset style="width: 80%;" >
		<legend>Class Names</legend>
		<div align="right" ><input type="button" name="Add More" value="Add More" onclick="AddMoreClasses()"/>&nbsp;</div>
		<div align="center">
		<table id="classNameTable">
			<tr>
				<td><label  for="className">Class Name :&nbsp;</label></td>
				<td><input type="text" name="className" id="className"  /></td>
			</tr>
		</table>
		</div>
		<div align="right"><input type="submit" value="Save" />&nbsp;</div>
	</fieldset>

</form>