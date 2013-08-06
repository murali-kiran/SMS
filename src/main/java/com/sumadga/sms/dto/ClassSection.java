package com.sumadga.sms.dto;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ClassSections database table.
 * 
 */
@Entity
@Table(name="ClassSections")
public class ClassSection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int classSectionId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTime;

	//bi-directional many-to-one association to Class
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="classId")
	private StudentClass studentClass;

	//bi-directional many-to-one association to Section
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sectionId")
	private Section section;

	//bi-directional many-to-one association to MainTable
	@OneToMany(mappedBy="classSection")
	private List<MainTable> mainTables;

	public ClassSection() {
	}

	public int getClassSectionId() {
		return this.classSectionId;
	}

	public void setClassSectionId(int classSectionId) {
		this.classSectionId = classSectionId;
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

	public StudentClass getStudentClass() {
		return this.studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public List<MainTable> getMainTables() {
		return this.mainTables;
	}

	public void setMainTables(List<MainTable> mainTables) {
		this.mainTables = mainTables;
	}

}