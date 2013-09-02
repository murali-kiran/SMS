
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script>

$(function(){
	
	$('#startTime').timepicker({ 'step': 15 });
	$('#endTime').timepicker({ 'step': 15 });
	
	$("#dateOfExam").datepicker({
		dateFormat : 'mm-dd-yy',
		maxDate : '0'
	});	
});

  function formValidation(){
	  
	  var status = true;
	  
	  if($("select[name='examTypeList'] :selected").val()==""){
		  status= false;
		  $("select[name='examTypeList'] ~ span").remove();
		  $("select[name='examTypeList']").after($('<span style="color:#ff0000">&nbsp;*</span>'));
	  }
	  if($("select[name='classList'] :selected").val()==""){
		  status= false;
		  $("select[name='classList'] ~ span").remove();
		  $("select[name='classList']").after($('<span style="color:#ff0000">&nbsp;*</span>'));
	  }
	  if($("select[name='subjectList'] :selected").val()==""){
		  status= false;
		  $("select[name='subjectList'] ~ span").remove();
		  $("select[name='subjectList']").after($('<span style="color:#ff0000">&nbsp;*</span>'));
	  } 
	  if($("select[name='teacherList'] :selected").val()==""){
		  status= false;
		  $("select[name='teacherList'] ~ span").remove();
		  $("select[name='teacherList']").after($('<span style="color:#ff0000">&nbsp;*</span>'));
	  }
	  if($("#dateOfExam").val()==""){
		  status= false;
		  $("#dateOfExam ~ span").remove();
		  $("#dateOfExam").after($('<span style="color:#ff0000">&nbsp;*</span>'));
	  }
	  
	  if($("#startTime").val()==""){
		  status= false;
		  $("#startTime ~ span").remove();
		  $("#startTime").after($('<span style="color:#ff0000">&nbsp;*</span>'));
	  }
	  if($("#endTime").val()==""){
		  status= false;
		  $("#endTime ~ span").remove();
		  $("#endTime").after($('<span style="color:#ff0000">&nbsp;*</span>'));
	  }
	  if($("#maxMarks").val()==""){
		  status= false;
		  $("#maxMarks ~ span").remove();
		  $("#maxMarks").after($('<span style="color:#ff0000">&nbsp;*</span>'));
	  }
	  if(!status){
		  $('.error').text("* Required Fields");
	  }else{
		  
// {"examTypeId","classclassId","subjectId","teachingStaffId","examDate","examStartTime","examEndTime","maximumMarks"};

          
          $.ajaxSetup({
        	  async: false
           });
		  
		  $.getJSON("${pageContext.servletContext.contextPath}/alreadyExamTimeTableExist", {examTypeId:$("select[name='examTypeList'] :selected").val(),classId:$("select[name='classList'] :selected").val(),
			  subjectId:$("select[name='subjectList'] :selected").val(),teachingStaffId:$("select[name='teacherList'] :selected").val(),examDate:$("#dateOfExam").val(),examStartTime:$("#startTime").val(),examEndTime:$("#endTime").val(),maximumMarks:$("#maxMarks").val()},function(json) {
			  if(json.status){
				  
				  alert("message : "+json.message);
				  $('.error').text(json.message);
				  status = false;
				  
				  }
		  });
		  
		  
	  }
	  
	  return status;
  }
  
 
</script>

<form method="post" action="${pageContext.servletContext.contextPath}/saveExamTimeTable" onsubmit="return formValidation();">
	
		<div class="error"></div>
		<div class="success"></div>
	
	<fieldset style="width: 80%;">
		<legend>Exam Time Table</legend>
		<div align="center">
			<table >
			<tr>
			<td>
			
			<label for="class" style="font-weight: bold;font-size: 13.5px;color: #333333;">ExamType : </label>
				<select name="examTypeList" onchange="getSubjectsOfTeacher()">
					<option value="">-Select-</option>
						<c:forEach items="${examTypes}" var="examType">
						   <option value="${examType.examTypeId}">${examType.examTypeName}</option>
						</c:forEach>
				</select>
			</td>
			</tr>
			<tr>
			<td>
				<label for="class" style="font-weight: bold;font-size: 13.5px;color: #333333;">Class : </label>
				<select name="classList" onchange="getSubjectsOfTeacher()">
					<option value="">-Select-</option>
						<c:forEach items="${classes}" var="class">
						   <option value="${class.classId}">${class.className}</option>
						</c:forEach>
				</select>
			</td>
			</tr>
			
			<tr>
			<td>
				<label for="class" style="font-weight: bold;font-size: 13.5px;color: #333333;">Subject : </label>
				<select name="subjectList" onchange="getSubjectsOfTeacher()">
					<option value="">-Select-</option>
						<c:forEach items="${subjects}" var="subject">
						   <option value="${subject.subjectId}">${subject.subjectName}</option>
						</c:forEach>
				</select>
			</td>
			</tr>
			<tr>
					<td>
						<label for="teacher" style="font-weight: bold;font-size: 13.5px;color: #333333;">Teacher :</label>
						<select name="teacherList" onchange="getSubjectsOfTeacher()">
							<option value="">-Select-</option>
							<c:forEach items="${teachers}" var="teacher">
								<option value="${teacher.id}">${teacher.name}</option>
							</c:forEach>
						</select>
					</td>
			</tr>
			<tr><td>
			<label for="doe">Date of Exam </label>
			 <input type="text" name="dateOfExam" id="dateOfExam" />
			</td></tr>
			
			<tr>
			<td>
			<label for="startTime">Start Time : </label>
			 <input type="text" name="startTime" id="startTime" class="time"/>
			</td>
			<td>&nbsp;</td>
			<td>
			<label for="endTime">End Time : </label>
			 <input type="text" name="endTime" id="endTime" class="time"/>
			</td>
			</tr>
			<tr><td>
			<label for="doe">Max Marks </label>
			 <input type="text" name="maxMarks" id="maxMarks" />
			</td></tr>
			
			</table>
			<br />
		</div>
		<div>
			&nbsp;<input type="submit" value="Save" />
		</div>
	</fieldset>

</form>