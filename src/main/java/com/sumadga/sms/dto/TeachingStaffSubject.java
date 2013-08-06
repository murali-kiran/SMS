package com.sumadga.sms.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TeachingStaffSubjects database table.
 * 
 */
@Entity
@Table(name="TeachingStaffSubjects")
public class TeachingStaffSubject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int teachingStaffSubjectId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTime;

	//bi-directional many-to-one association to Subject
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="subjectId")
	private Subject subject;

	//bi-directional many-to-one association to TeachingStaff
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="teachingStaffId")
	private TeachingStaff teachingStaff;

	public TeachingStaffSubject() {
	}

	public int getTeachingStaffSubjectId() {
		return this.teachingStaffSubjectId;
	}

	public void setTeachingStaffSubjectId(int teachingStaffSubjectId) {
		this.teachingStaffSubjectId = teachingStaffSubjectId;
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

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public TeachingStaff getTeachingStaff() {
		return this.teachingStaff;
	}

	public void setTeachingStaff(TeachingStaff teachingStaff) {
		this.teachingStaff = teachingStaff;
	}

}