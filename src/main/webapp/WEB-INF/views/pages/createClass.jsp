<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
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
					$('#newSubjectDiv > #subjectFieldSetDiv > #sectionFieldSet').append("<input type='text' name='section' value='' title='subject'/>&nbsp;&nbsp;");
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
</script>



<form method="post"	action="${pageContext.servletContext.contextPath}/saveNewClass" onsubmit="<!-- return formValidation(); -->">

	<c:if test="${error}">
		<div class="error">* Required Fields are Mandatory</div>
	</c:if>

		<div align="right">
			<a href="#" onclick="enable('#studentTbl','editStudent()');">edit</a>
		</div>
		<table id="studentTbl">
			<tr>
				<td><label for="name">Class Name </label></td>
				<td><input type="text" name="className" id="className"/></td>
			</tr>
			<tr>
				<td><label  for="subjectCount">No of Subjects</label></td>
				<td><input type="text" name="subjectCount" id="subjectCount"  /></td>
			</tr>
		
		</table>
		
		<div id="newSubjectDiv"></div>
		
		<div style="border: 1px;" id="newSubjectDiv">
			<div style="width:80%;" id="subjectFieldSetDiv" align="center"></div>
		</div>
		<br/>

	<div><input type="submit" value="Create" /></div>

</form>