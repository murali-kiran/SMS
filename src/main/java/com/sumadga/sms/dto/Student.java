package com.sumadga.sms.dto;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Students database table.
 * 
 */
@Entity
@Table(name="Students")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String description;

	private byte isPhysicallyChallenged;

	@Temporal(TemporalType.DATE)
	private Date joiningDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTime;

	private String name;

	private String surName;

	//bi-directional many-to-one association to AcademicStudent
	@OneToMany(mappedBy="student")
	private List<AcademicStudent> academicStudents;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;

	//bi-directional many-to-one association to Parent
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="parentId")
	private Parent parent;

	public Student() {
	}

	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getIsPhysicallyChallenged() {
		return this.isPhysicallyChallenged;
	}

	public void setIsPhysicallyChallenged(byte isPhysicallyChallenged) {
		this.isPhysicallyChallenged = isPhysicallyChallenged;
	}

	public Date getJoiningDate() {
		return this.joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return this.surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public List<AcademicStudent> getAcademicStudents() {
		return this.academicStudents;
	}

	public void setAcademicStudents(List<AcademicStudent> academicStudents) {
		this.academicStudents = academicStudents;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Parent getParent() {
		return this.parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

}