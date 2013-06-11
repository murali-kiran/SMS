package com.sumadga.sms.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Classes database table.
 * 
 */
@Entity
@Table(name="Classes")
public class StudentClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int classId;

	private String className;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTime;

	//bi-directional many-to-one association to ClassSection
	@OneToMany(mappedBy="studentClass")
	private List<ClassSection> classSections;

	//bi-directional many-to-one association to ClassSubject
	@OneToMany(mappedBy="studentClass")
	private List<ClassSubject> classSubjects;

	public StudentClass() {
	}

	public int getClassId() {
		return this.classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public List<ClassSection> getClassSections() {
		return this.classSections;
	}

	public void setClassSections(List<ClassSection> classSections) {
		this.classSections = classSections;
	}

	public List<ClassSubject> getClassSubjects() {
		return this.classSubjects;
	}

	public void setClassSubjects(List<ClassSubject> classSubjects) {
		this.classSubjects = classSubjects;
	}

}