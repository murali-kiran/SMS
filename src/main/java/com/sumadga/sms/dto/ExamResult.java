package com.sumadga.sms.dto;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the ExamResults database table.
 * 
 */
@Entity
@Table(name="ExamResults")
public class ExamResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String examResultId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	private int marksObtained;

	private Timestamp modifiedTime;

	//bi-directional many-to-one association to Class
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="studentId")
		private Student student;

	//bi-directional many-to-one association to ExamTimeTable
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="examTimeTableId")
	private ExamTimeTable examTimeTable;

	public ExamResult() {
	}

	public String getExamResultId() {
		return this.examResultId;
	}

	public void setExamResultId(String examResultId) {
		this.examResultId = examResultId;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public int getMarksObtained() {
		return this.marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ExamTimeTable getExamTimeTable() {
		return this.examTimeTable;
	}

	public void setExamTimeTable(ExamTimeTable examTimeTable) {
		this.examTimeTable = examTimeTable;
	}

}