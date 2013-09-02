
function isValidEmail(email){
	var regEx = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	
	return regEx.test(email);
}

function isAlphabetic(target){
	var regEx = /^[a-zA-Z]+$/g;
    return regEx.test(target);
}

function isNumeric(target) {
	var regEx = /\d{6}/g;
    return regEx.test(target);
}

function isMoreThenOne_TxtBoxHaveSameValue(input){
	var status = false;
	var inputs = input.split(",");
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

function jqGridInclude()
{
var pathtojsfiles = "resources/js/jqgrid/"; // need to be ajusted
// if you do not want some module to be included
// set include to false.
// by default all modules are included.
var minver = false;
var modules = [
{ include: true, incfile:'src/grid.locale-en.js',minfile: 'src/grid.locale-en.js'}, // jqGrid translation
{ include: true, incfile:'src/grid.base.js',minfile: 'src/grid.base.js'}, // jqGrid base
{ include: true, incfile:'src/grid.common.js',minfile: 'src/grid.common.js' }, // jqGrid common for editing
{ include: true, incfile:'src/grid.formedit.js',minfile: 'src/grid.formedit.js' }, // jqGrid Form editing
{ include: true, incfile:'src/grid.inlinedit.js',minfile: 'src/grid.inlinedit.js' }, // jqGrid inline editing
{ include: true, incfile:'src/grid.celledit.js',minfile: 'src/grid.celledit.js' }, // jqGrid cell editing
{ include: true, incfile:'src/grid.subgrid.js',minfile: 'src/grid.subgrid.js'}, //jqGrid subgrid
{ include: true, incfile:'src/grid.treegrid.js',minfile: 'src/grid.treegrid.js'}, //jqGrid treegrid
{ include: true, incfile:'src/grid.custom.js',minfile: 'src/grid.custom.js'}, //jqGrid custom
{ include: true, incfile:'src/grid.postext.js',minfile: 'src/grid.postext.js'}, //jqGrid postext
{ include: true, incfile:'src/grid.tbltogrid.js',minfile: 'src/grid.tbltogrid.js'}, //jqGrid table to grid function
{ include: true, incfile:'src/grid.setcolumns.js',minfile: 'src/grid.setcolumns.js'}, //jqGrid hide/show columns function
{ include: true, incfile:'src/grid.import.js',minfile: 'src/grid.import.js'}, //jqGrid import
{ include: true, incfile:'src/jquery.fmatter.js',minfile: 'src/jquery.fmatter.js'}, //jqGrid formatter
{ include: true, incfile:'src/json2.js',minfile: 'src/json2.js'}, //json utils
{ include: true, incfile:'src/JsonXml.js',minfile: 'src/JsonXml.js'} //xmljson utils
];
for(var i=0;i<modules.length; i++)
{
if(modules[i].include === true) {
if (minver !== true) IncludeJavaScript(pathtojsfiles+modules[i].incfile,CallMe);
else IncludeJavaScript(pathtojsfiles+modules[i].minfile,CallMe);
}
}
function IncludeJavaScript(jsFile,oCallback)
{
var oHead = document.getElementsByTagName('head')[0];
var oScript = document.createElement('script');
oScript.type = 'text/javascript';
oScript.src = jsFile;
oHead.appendChild(oScript);
}
}
