package com.sumadga.sms.dto;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the Staff database table.
 * 
 */
@Entity
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int staffId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	//bi-directional many-to-one association to Designation
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="designationId")
	private Designations designations;

	@Temporal(TemporalType.TIMESTAMP)
	private Date joiningDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTime;

	private String name;
	
	private String isTeachinfStaff;
	

	//bi-directional one-to-one association to TeachingStaff
	@OneToOne(mappedBy="staff", fetch=FetchType.EAGER)
	private TeachingStaff teachingStaff;

	public Staff() {
	}

	public int getStaffId() {
		return this.staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	

	public Designations getDesignations() {
		return designations;
	}

	public void setDesignations(Designations designations) {
		this.designations = designations;
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

	public TeachingStaff getTeachingStaff() {
		return this.teachingStaff;
	}

	public void setTeachingStaff(TeachingStaff teachingStaff) {
		this.teachingStaff = teachingStaff;
	}


	public String getIsTeachinfStaff() {
		return isTeachinfStaff;
	}

	public void setIsTeachinfStaff(String isTeachinfStaff) {
		this.isTeachinfStaff = isTeachinfStaff;
	}
	
	

}