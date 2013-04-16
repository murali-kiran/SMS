package com.sumadga.sms.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TeachingStaff database table.
 * 
 */
@Entity
public class TeachingStaff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int teachingStaffId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	private String extradetails;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTime;

	//bi-directional many-to-one association to MainTable
	@OneToMany(mappedBy="teachingStaff")
	private List<MainTable> mainTables;

	//bi-directional many-to-one association to SubjectTimeTable
	@OneToMany(mappedBy="teachingStaff1")
	private List<SubjectTimeTable> subjectTimeTables1;

	//bi-directional many-to-one association to SubjectTimeTable
	@OneToMany(mappedBy="teachingStaff2")
	private List<SubjectTimeTable> subjectTimeTables2;

	//bi-directional one-to-one association to Staff
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="teachingStaffId")
	private Staff staff;

	//bi-directional many-to-one association to TeachingStaffSubject
	@OneToMany(mappedBy="teachingStaff")
	private List<TeachingStaffSubject> teachingStaffSubjects;

	public TeachingStaff() {
	}

	public int getTeachingStaffId() {
		return this.teachingStaffId;
	}

	public void setTeachingStaffId(int teachingStaffId) {
		this.teachingStaffId = teachingStaffId;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getExtradetails() {
		return this.extradetails;
	}

	public void setExtradetails(String extradetails) {
		this.extradetails = extradetails;
	}

	public Date getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public List<MainTable> getMainTables() {
		return this.mainTables;
	}

	public void setMainTables(List<MainTable> mainTables) {
		this.mainTables = mainTables;
	}

	public List<SubjectTimeTable> getSubjectTimeTables1() {
		return this.subjectTimeTables1;
	}

	public void setSubjectTimeTables1(List<SubjectTimeTable> subjectTimeTables1) {
		this.subjectTimeTables1 = subjectTimeTables1;
	}

	public List<SubjectTimeTable> getSubjectTimeTables2() {
		return this.subjectTimeTables2;
	}

	public void setSubjectTimeTables2(List<SubjectTimeTable> subjectTimeTables2) {
		this.subjectTimeTables2 = subjectTimeTables2;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<TeachingStaffSubject> getTeachingStaffSubjects() {
		return this.teachingStaffSubjects;
	}

	public void setTeachingStaffSubjects(List<TeachingStaffSubject> teachingStaffSubjects) {
		this.teachingStaffSubjects = teachingStaffSubjects;
	}

}