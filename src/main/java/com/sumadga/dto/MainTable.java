package com.sumadga.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MainTable database table.
 * 
 */
@Entity
public class MainTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mainTableId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date academicEndYear;

	@Temporal(TemporalType.TIMESTAMP)
	private Date academicStartYear;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTime;

	//bi-directional many-to-one association to AcademicStudent
	@OneToMany(mappedBy="mainTable")
	private List<AcademicStudent> academicStudents;

	//bi-directional many-to-one association to ClassSection
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="classSectionId")
	private ClassSection classSection;

	//bi-directional many-to-one association to TeachingStaff
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="classTeacherId")
	private TeachingStaff teachingStaff;

	//bi-directional many-to-one association to SubjectTimeTable
	@OneToMany(mappedBy="mainTable")
	private List<SubjectTimeTable> subjectTimeTables;

	public MainTable() {
	}

	public int getMainTableId() {
		return this.mainTableId;
	}

	public void setMainTableId(int mainTableId) {
		this.mainTableId = mainTableId;
	}

	public Date getAcademicEndYear() {
		return this.academicEndYear;
	}

	public void setAcademicEndYear(Date academicEndYear) {
		this.academicEndYear = academicEndYear;
	}

	public Date getAcademicStartYear() {
		return this.academicStartYear;
	}

	public void setAcademicStartYear(Date academicStartYear) {
		this.academicStartYear = academicStartYear;
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

	public List<AcademicStudent> getAcademicStudents() {
		return this.academicStudents;
	}

	public void setAcademicStudents(List<AcademicStudent> academicStudents) {
		this.academicStudents = academicStudents;
	}

	public ClassSection getClassSection() {
		return this.classSection;
	}

	public void setClassSection(ClassSection classSection) {
		this.classSection = classSection;
	}

	public TeachingStaff getTeachingStaff() {
		return this.teachingStaff;
	}

	public void setTeachingStaff(TeachingStaff teachingStaff) {
		this.teachingStaff = teachingStaff;
	}

	public List<SubjectTimeTable> getSubjectTimeTables() {
		return this.subjectTimeTables;
	}

	public void setSubjectTimeTables(List<SubjectTimeTable> subjectTimeTables) {
		this.subjectTimeTables = subjectTimeTables;
	}

}