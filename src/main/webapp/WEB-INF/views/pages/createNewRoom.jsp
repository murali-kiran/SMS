<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<script>
  
  function AddMoreRooms(){
	  try {
		$('#roomNameTable').append("<tr><td><label  for='roomName'>Room No :&nbsp;</label></td><td><input type='text' name='roomName' id='roomName'  /></td></tr>");
		} catch (e) {
			alert(e);
		}
  }
  
  function formValidation(){
	  var status = true;
	  
	  try {
	      var roomNamesEle = $('input[name="roomName"]');
	      var count = 0;
	      var roomNameStr = "";
	      for(var i=0;i<roomNamesEle.length;i++){
	    	  var roomName = roomNamesEle[i].value;
	    	  if($.trim(roomName) == ''){
	    		  count++;
	    	  }else{
	    		  if(i==0){
	    			  roomNameStr+=roomNamesEle[i].value;
					}else{
					  roomNameStr=roomNameStr+","+roomNamesEle[i].value;
					}
	    	  }
	    		  
	      }
	      if(count == roomNamesEle.length){
	    	  $('.error').text("* No Room Name is Filled");
			  status = false;
	      }else{
	    	  if(isMoreThenOne_TxtBoxHaveSameValue(roomNameStr)){
	    	  $('.error').text("* More than one Room Name has same value");	
	    	  status = false;
	    	  }else{
	    		  
	    		  $.ajaxSetup({
	            	  async: false
	               });
	    		  
	    		  
				  $.getJSON("${pageContext.servletContext.contextPath}/alreadyRoomExist", {roomNames:roomNameStr},function(json) {
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

<form method="post"	action="${pageContext.servletContext.contextPath}/saveRoomInfo" onsubmit="return formValidation();">

	<div class="error"></div>
	<c:if test="${not empty successMsg}"><div class="success">${successMsg}</div></c:if>
	<fieldset style="width: 80%;" >
		<legend>Room Names</legend>
		<div align="right" ><input type="button" name="Add More" value="Add More" onclick="AddMoreRooms()"/>&nbsp;</div>
		<div align="center">
		<table id="roomNameTable">
			<tr>
				<td><label  for="roomName">Room No :&nbsp;</label></td>
				<td><input type="text" name="roomName" id="roomName"  /></td>
			</tr>
		</table>
		</div>
		<div align="right"><input type="submit" value="Save" />&nbsp;</div>
	</fieldset>

</form>