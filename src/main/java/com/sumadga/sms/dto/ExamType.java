package com.sumadga.sms.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ExamTypes database table.
 * 
 */
@Entity
@Table(name="ExamTypes")
public class ExamType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int examTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	private String examTypeName;

	private Timestamp modifiedTime;

	//bi-directional many-to-one association to ExamTimeTable
	@OneToMany(mappedBy="examType")
	private List<ExamTimeTable> examTimeTables;

	public ExamType() {
	}

	public int getExamTypeId() {
		return this.examTypeId;
	}

	public void setExamTypeId(int examTypeId) {
		this.examTypeId = examTypeId;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getExamTypeName() {
		return this.examTypeName;
	}

	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public List<ExamTimeTable> getExamTimeTables() {
		return this.examTimeTables;
	}

	public void setExamTimeTables(List<ExamTimeTable> examTimeTables) {
		this.examTimeTables = examTimeTables;
	}

}