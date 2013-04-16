package com.sumadga.sms.dto;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ExamTimeTable database table.
 * 
 */
@Entity
public class ExamTimeTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String examTimeTableId;

	//bi-directional many-to-one association to Class
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="classId")
		private StudentClass studentClass;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@Temporal(TemporalType.DATE)
	private Date examDate;

	private Time examEndTime;

	private Time examStartTime;

	private int maximumMarks;

	private Timestamp modifiedTime;

	private int subjectId;

	private int teachingStaffId;

	//bi-directional many-to-one association to ExamResult
	@OneToMany(mappedBy="examTimeTable")
	private List<ExamResult> examResults;

	//bi-directional many-to-one association to ExamType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="examTypeId")
	private ExamType examType;

	public ExamTimeTable() {
	}

	public String getExamTimeTableId() {
		return this.examTimeTableId;
	}

	public void setExamTimeTableId(String examTimeTableId) {
		this.examTimeTableId = examTimeTableId;
	}

	

	public StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getExamDate() {
		return this.examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public Time getExamEndTime() {
		return this.examEndTime;
	}

	public void setExamEndTime(Time examEndTime) {
		this.examEndTime = examEndTime;
	}

	public Time getExamStartTime() {
		return this.examStartTime;
	}

	public void setExamStartTime(Time examStartTime) {
		this.examStartTime = examStartTime;
	}

	public int getMaximumMarks() {
		return this.maximumMarks;
	}

	public void setMaximumMarks(int maximumMarks) {
		this.maximumMarks = maximumMarks;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public int getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getTeachingStaffId() {
		return this.teachingStaffId;
	}

	public void setTeachingStaffId(int teachingStaffId) {
		this.teachingStaffId = teachingStaffId;
	}

	public List<ExamResult> getExamResults() {
		return this.examResults;
	}

	public void setExamResults(List<ExamResult> examResults) {
		this.examResults = examResults;
	}

	public ExamType getExamType() {
		return this.examType;
	}

	public void setExamType(ExamType examType) {
		this.examType = examType;
	}

}