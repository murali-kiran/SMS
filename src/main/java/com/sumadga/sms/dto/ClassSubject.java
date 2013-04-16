package com.sumadga.sms.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ClassSubjects database table.
 * 
 */
@Entity
@Table(name="ClassSubjects")
public class ClassSubject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int classSubjectId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTime;

	//bi-directional many-to-one association to Class
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="classId")
	private StudentClass studentClass;

	//bi-directional many-to-one association to Subject
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subjectId")
	private Subject subject;

	public ClassSubject() {
	}

	public int getClassSubjectId() {
		return this.classSubjectId;
	}

	public void setClassSubjectId(int classSubjectId) {
		this.classSubjectId = classSubjectId;
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

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}