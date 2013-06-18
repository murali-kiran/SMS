<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>SMS | <%-- <tiles:insertAttribute name="header-title-content" /> --%></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<tiles:insertAttribute name="css-content" />
<tiles:insertAttribute name="js-content" />
</head>
<body style="margin: 0px; padding: 0px;">

	<table border="1" cellspacing="0" cellpadding="0" class="layout" >
		<tr class="header">
		<td colspan="2" align="center">
		
		<%-- <tiles:insertAttribute name="header-content" /> --%>
		
		SUMADGA HEADER
		
		</td>
		</tr>
		
		<tr class="content">
		
	 		<td class="side-panel" nowrap="nowrap" align="center" >
	
			<%-- 	
				<div class="menu-title">Usage</div>
				<div class="menu-content">
				<tiles:insertAttribute name="side-panel-content"/>
				</div> 
			--%>
			
			<tiles:insertAttribute name="side-panel-content"/>
			
			
			</td> 
			<td class="content">
				<h1 class="title"><tiles:insertAttribute name="title-content" /></h1>
				<tiles:insertAttribute name="body-content" />
			</td>
		</tr>
		<tr class="footer">
		<td colspan="2" align="center" ><%-- <tiles:insertAttribute name="footer-content" /> --%>
		    SUMADGA FOOTER
		</td>
		</tr>
	</table>
	
</body>
</html>