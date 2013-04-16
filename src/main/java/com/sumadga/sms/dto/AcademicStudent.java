package com.sumadga.sms.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the AcademicStudents database table.
 * 
 */
@Entity
@Table(name="AcademicStudents")
public class AcademicStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String academicStudentId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTime;

	private String notes;

	private int rollnumber;

	//bi-directional many-to-one association to MainTable
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mainTableId")
	private MainTable mainTable;

	//bi-directional many-to-one association to Student
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="studentId")
	private Student student;

	public AcademicStudent() {
	}

	public String getAcademicStudentId() {
		return this.academicStudentId;
	}

	public void setAcademicStudentId(String academicStudentId) {
		this.academicStudentId = academicStudentId;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getRollnumber() {
		return this.rollnumber;
	}

	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}

	public MainTable getMainTable() {
		return this.mainTable;
	}

	public void setMainTable(MainTable mainTable) {
		this.mainTable = mainTable;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}