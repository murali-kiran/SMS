package com.sumadga.sms.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Sections database table.
 * 
 */
@Entity
@Table(name="Sections")
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sectionId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTime;

	private String sectionName;

	//bi-directional many-to-one association to ClassSection
	@OneToMany(mappedBy="section")
	private List<ClassSection> classSections;

	public Section() {
	}

	public int getSectionId() {
		return this.sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
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

	public String getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public List<ClassSection> getClassSections() {
		return this.classSections;
	}

	public void setClassSections(List<ClassSection> classSections) {
		this.classSections = classSections;
	}

}