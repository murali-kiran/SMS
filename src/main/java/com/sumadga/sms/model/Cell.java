package com.sumadga.sms.model;

import java.util.List;

public class Cell{
	
	private Integer id;
	private List<String> cell;
	
	public List<String> getCell() {
		return cell;
	}
	public void setCell(List<String> cell) {
		this.cell = cell;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}