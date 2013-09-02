<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script>

$(function(){

	try {
		
	alert("sravan");

jQuery("#list").jqGrid({
		url : '${pageContext.request.contextPath}/getExamTimeTableData',
		datatype: "json",
		height: 250,
		width: 1000,
		colNames:['Class Name','subject Name','Exam Type','Exam Date','Start Time','End Time','Total'],
		colModel :[	{name:'className', label:'Class Name',index:'className',align:'center'},
					{name:'subjectName',label:'subject Name', index:'subjectName',align:'center'},
					{name:'examType', label:'Exam Type',index:'examType',align:'center'},
					{name:'examDate', label:'Exam Date',index:'examDate',align:'center'},
					{name:'startTime', label:'Start Time',index:'startTime',align:'center'},
					{name:'endTime', label:'End Time',index:'endTime',align:'center'},
					{name:'total',label:'Total', index:'Total',align:'center'} ],
		paging: true,
	    rowNum:10,
		rowList:[10,20,30],
	    pager: "#page",
        caption: "Exam Time Table", 
	    sortable: true,
        viewrecords: true,
        jsonReader : { 
        root: "rows", 
        page: "page", 
        total: "total", 
        repeatitems: false,
        id:"0"
       
      }
				        
});

	} catch (e) {
		alert(e);
	}

});

 

</script>


<div id="jQGrid" ><table id="list" class=".ui-jqgrid"></table><div id="page"></div></div>


