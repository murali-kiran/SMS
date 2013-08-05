<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<script>
  $(function() {
		
		$("#dateOfBirth,#joiningDate").datepicker({
			dateFormat : 'mm-dd-yy',
			maxDate : '0'
		});
		
		$('#subjectCount').on("focusout",function(){
			
			try{
				
				var subjects = $(this).val();				
				$('#newSubjectDiv > #subjectFieldSetDiv').html("");
				
				if(subjects > 0){
					
					$('#newSubjectDiv > #subjectFieldSetDiv').html("<fieldset  id='sectionFieldSet' style='display: none;'><legend>Subjects</legend></fieldset>");
					for(var i = 0;i < subjects;i++){
					$('#newSubjectDiv > #subjectFieldSetDiv > #sectionFieldSet').append("<input type='text' id='subject' name='subject' value='' title='subject'/>&nbsp;&nbsp;");
					if((i+1)%3 == 0)
					$('#newSubjectDiv > #subjectFieldSetDiv > #sectionFieldSet').append('<br/>');
					}
					
					dynamicCreateInputField('#newSubjectDiv > #subjectFieldSetDiv > #sectionFieldSet > input[type="text"]');
				}
				
				$("#sectionFieldSet").show("fold",1000);
				
			}catch (e) {
				alert(e);
			}
			
		});
		
  });
  
  function dynamicCreateInputField(id){

		$(id).each(function(){
			 
		    this.value = $(this).attr('title');
		    $(this).css('color','#cdcdcd');
		 
		    $(this).focus(function(){
		        if(this.value == $(this).attr('title')) {
		            this.value = '';
		            $(this).css('color','');
		        }
		    });
		 
		    $(this).blur(function(){
		        if(this.value == '') {
		            this.value = $(this).attr('title');
		            $(this).css('color','#cdcdcd');
		        }
		    });
		});

		}
  
  function formValidation(){
	  
	  var status = true;
	  
	  try {
	  
	  if($('#subjectCount').val() == '0'){
		  $('#error').val("Number of subjects are zero");
		  return false;
	  }else{
		  
		  var $inputs = $('[name="subject"]');
		  
			for(var i=0;i < $inputs.length;i++){
				for(var j=i+1;j<$inputs.length;j++){
					if($inputs.eq(i).val()== $inputs.eq(j).val()){
						$('.error').text("* More then one subjects are Same"); 
						status = false;
						break;
					}
				}
			}
			
			if(status){
				var $inputs = $('[name="subject"]');
				var subjectStr = "";
				for(var i=0;i < $inputs.length;i++){
					if(i==0){
						subjectStr+=$inputs.eq(i).val();
					}else{
						subjectStr=subjectStr+","+$inputs.eq(i).val();
					}
				}
				  $.getJSON("${pageContext.servletContext.contextPath}/alreadySubjectExist", { subjectsCount : $('#subjectCount').val(),subjects:subjectStr},function(json) {
					  if(json.status){
						  alert("message : "+json.message);
						  $('.error').text(json.message);
						  status = false;
						  }
					  else{
						  status = true;
						  }
				  });
			}
			alert(status);
			return status;
		  
	  }
		} catch (e) {
			alert(e);
		}
  }
  
  function isMoreThenOne_TxtBoxHaveSameValue(inputs){
		var status = false;
		for(var i=0;i<inputs.length;i++){
			for(var j=i+1;j<inputs.length;j++){
				if(inputs[i] == inputs[j]){
					status = true;
					break;
					
				}
			}
		}
		
		return status;
	}

</script>

<form method="post"	action="${pageContext.servletContext.contextPath}/saveNewSubjects" onsubmit="return formValidation();">

		<div class="error"></div>

	<fieldset style="width: 80%;" >
		<legend>New Subjects</legend>
		<div align="center">
		<table >
			<tr>
				<td><label  for="subjectCount">Number Of Subjects To Save : </label></td>
				<td><input type="text" name="subjectCount" id="subjectCount"  /></td>
			</tr>
		</table>
		
		<div style="border: 1px;" id="newSubjectDiv">
			<div style="width:90%;" id="subjectFieldSetDiv" align="center"></div>
		</div>
		<br/>
		
		</div>

		<div>&nbsp;<input type="submit" value="Save" /></div>
	</fieldset>

</form>