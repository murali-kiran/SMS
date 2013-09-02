package com.sumadga.sms.model;

import java.util.List;

public class ExamTimeTableGrid {
	
	
	
	private String url;
	private String dataType;
	private String mtype;
	private String colNames = "['Class Name','subject Name', 'Exam Type','Start Time','End Time','Total']";
	private int rowNum;
	private List<Integer> rowList;
	private String sortname;
	private String sortorder;
	private boolean viewrecords;
	private String caption;
	
	
/*	url:'example.php',
	datatype: 'xml',
	mtype: 'GET',
	colNames:['Inv No','Date', 'Amount','Tax','Total','Notes'],
	colModel :[
	{name:'invid', index:'invid', width:55},
	{name:'invdate', index:'invdate', width:90},
	{name:'amount', index:'amount', width:80, align:'right'},
	{name:'tax', index:'tax', width:80, align:'right'},
	{name:'total', index:'total', width:80,align:'right'},
	{name:'note', index:'note', width:150, sortable:false} ],
	pager: jQuery('#pager'),
	rowNum:10,
	rowList:[10,20,30],
	sortname: 'id',
	sortorder: 'desc',
	viewrecords: true,
	imgpath: 'themes/basic/images',
	caption: 'My first grid'
*/

	public String getColNames() {
		return colNames;
	}

	public void setColNames(String colNames) {
		this.colNames = colNames;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public List<Integer> getRowList() {
		return rowList;
	}

	public void setRowList(List<Integer> rowList) {
		this.rowList = rowList;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	public boolean isViewrecords() {
		return viewrecords;
	}

	public void setViewrecords(boolean viewrecords) {
		this.viewrecords = viewrecords;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
		
}
