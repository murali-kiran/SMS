package com.sumadga.sms.model;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class JqGridData {
	
	private Integer total;
	private Integer page;
	private Integer records;
	private List<Cell> rows;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRecords() {
		return records;
	}
	public void setRecords(Integer records) {
		this.records = records;
	}
	public List<Cell> getRows() {
		return rows;
	}
	public void setRows(List<Cell> rows) {
		this.rows = rows;
	}
	
}




/** -- style of the response data to jqgrid

{
	total: "xxx",
	page: "yyy",
	records: "zzz",
	rows : [
	{id:"1", cell:["cell11", "cell12", "cell13"]},
	{id:"2", cell:["cell21", "cell22", "cell23"]},]
}

*/
