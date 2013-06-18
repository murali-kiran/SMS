<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script>

$(function(){	
	
	$("#creationTime").datepicker({ 
		dateFormat: 'mm-dd-yy',
		maxDate: '0'
	});		
	
	$('#sectionCount').live("focusout",function(){
		
		try{
			var sections = $(this).val();				
			$('#newClassDiv > #sectionFieldSetDiv').html("");
			if(sections > 0){
				$('#newClassDiv > #sectionFieldSetDiv').html("<fieldset  id='sectionFieldSet' style='display: none;'><legend>Sections</legend></fieldset>");
				for(var i = 0;i < sections;i++){
				$('#newClassDiv > #sectionFieldSetDiv > #sectionFieldSet').append("<input type='text' name='section' value='' title='section'/><br/>");
				}
				
				x('#newClassDiv > #sectionFieldSetDiv > #sectionFieldSet > input[type="text"]');
			}
			
			$("#sectionFieldSet").show("fold",1000);
		}catch (e) {
			alert(e);
		}
		
	});
	
	
	$('#subjectCount').live("focusout",function(){
		
		try{
			var subjects = $(this).val();	
			$('#newClassDiv > #subjectFieldSetDiv').html("");
			if(subjects > 0){
				$('#newClassDiv > #subjectFieldSetDiv').html("<fieldset style='display: none;' id='subjectFieldSet'><legend>Subject</legend></fieldset>");
				for(var i = 0;i < subjects;i++){
				$('#newClassDiv > #subjectFieldSetDiv > #subjectFieldSet').append("<input type='text' name='subject' value='' title='subject'/><br/>");
				}
				x('#newClassDiv > #subjectFieldSetDiv > #subjectFieldSet > input[type="text"]');
			}
			$("#subjectFieldSet").show("fold",1000);
		}catch (e) {
			alert(e);
		}
		
		
	});
	

	
	
});

function x(id){

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

function showClassForm(){	
	try {
	$("#addClassDiv").show("fold",1000);
	} catch (e) {
		alert(e);
	}
}

function getSections(section){
	
	$.Ajax({
		
		 url:"to get the sections url using class id",
		 async:false,
		 success:function(date){},
		 error:function(xhr){
		      alert("An error occured: " + xhr.status + " " + xhr.statusText);
		    }
		 });	
}

function getSubjects(section){
	
	$.Ajax({
		 url:"to get the sections url using class id",
		 async:false,
		 success:function(date){},
		 error:function(xhr){
		      alert("An error occured: " + xhr.status + " " + xhr.statusText);
		    }
		 });
	
}

</script>

<!-- <iframe src="https://www.facebook.com/video/embed?video_id=451699421590141" width="400" height="224" frameborder="0"></iframe> -->

<div>
	<table class="table table-bordered table-striped table-condensed">
		<thead>
			<tr>
				<th>Serial No</th>
				<th>Class Name</th>
				<th>Sections Count</th>
				<th>Subject Count</th>
				<th>Modify</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(classes) eq 0}">
					<tr>
						<td colspan="5" class="msg" style="text-align: center;">No
							Classes Added Yet :)</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${classes}" var="class" varStatus="status">
						<tr>
							<%--    <fmt:formatDate value="${event.when.time}" type="both" pattern="yyyy-MM-dd HH:mm" var="when"/> --%>
							<td><c:out value="${status.count}" /></td>
							<td><c:out value="${class.className}" /></td>
							<td><c:out value="${class.sectionCount}" /></td>
							<td><c:url value="${class.subjectCount}" /></td>
							<td><input type="button" value="update"
								id="${class.classId}" /></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<div align="right">
		<input type="button" value="Add Class" id="addClassBtn"
			onclick="showClassForm()" />
	</div>
</div>
<div id="addClassDiv">
	<fieldset style="width: 100%;">
		<legend>Class Details</legend>

		<form:form method="post" action="${pageContext.servletContext.contextPath}/saveClassDetails" modelAttribute="classForm">

			<c:if test="${error}">
				<div class="error">* Required Fields are Mandatory</div>
			</c:if>

			<table>
				<tr>
					<td><form:label path="className">Class Name</form:label></td>
					<td><form:input path="className" title=""/></td>
					<td><form:errors path="className" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="sectionCount">Number of sections</form:label></td>
					<td><form:input path="sectionCount" title=""/></td>
					<td><form:errors path="sectionCount" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="subjectCount">Number of subject</form:label></td>
					<td><form:input path="subjectCount" title=""/></td>
					<td><form:errors path="subjectCount" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="creationTime">Creation Time</form:label></td>
					<td><form:input path="creationTime" id="creationTime" /></td>
					<td><form:errors path="creationTime" cssClass="error" /></td>
				</tr>
			</table>

			<input type="submit" value=" Add " />
			
	<!-- 		<table style="" border="1">
				<tr>
					<td>
						<fieldset style="display: none;" id="sectionFieldSet">
							<legend>Sections</legend>
						</fieldset>
					</td>
					<td>
						<fieldset style="display: none;" id="subjectFieldSet">
							<legend>Subjects</legend>
						</fieldset>
					</td>
				</tr>
			</table> -->
			<div style="border: 1px;" id="newClassDiv">
			<div style="width:50%;float: left" id="sectionFieldSetDiv"></div>
			<div style="width:50%;float: left;" id="subjectFieldSetDiv"></div>
			</div>
		</form:form>
	</fieldset>
</div>





