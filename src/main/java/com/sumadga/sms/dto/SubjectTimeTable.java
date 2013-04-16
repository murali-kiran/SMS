package com.sumadga.sms.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the SubjectTimeTable database table.
 * 
 */
@Entity
public class SubjectTimeTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int subjectTimeTableId;

	private int duration;

	private Time endTime;

	private String notes;

	private int period;

	private Time startTime;

	private int weekDay;

	//bi-directional many-to-one association to Location
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="locationId")
	private Location location;

	//bi-directional many-to-one association to MainTable
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mainTableId")
	private MainTable mainTable;

	//bi-directional many-to-one association to Subject
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subjectId")
	private Subject subject;

	//bi-directional many-to-one association to TeachingStaff
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="teacherId")
	private TeachingStaff teachingStaff1;

	//bi-directional many-to-one association to TeachingStaff
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="alterNateTeacherId")
	private TeachingStaff teachingStaff2;

	public SubjectTimeTable() {
	}

	public int getSubjectTimeTableId() {
		return this.subjectTimeTableId;
	}

	public void setSubjectTimeTableId(int subjectTimeTableId) {
		this.subjectTimeTableId = subjectTimeTableId;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Time getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getPeriod() {
		return this.period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public Time getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public int getWeekDay() {
		return this.weekDay;
	}

	public void setWeekDay(int weekDay) {
		this.weekDay = weekDay;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public MainTable getMainTable() {
		return this.mainTable;
	}

	public void setMainTable(MainTable mainTable) {
		this.mainTable = mainTable;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public TeachingStaff getTeachingStaff1() {
		return this.teachingStaff1;
	}

	public void setTeachingStaff1(TeachingStaff teachingStaff1) {
		this.teachingStaff1 = teachingStaff1;
	}

	public TeachingStaff getTeachingStaff2() {
		return this.teachingStaff2;
	}

	public void setTeachingStaff2(TeachingStaff teachingStaff2) {
		this.teachingStaff2 = teachingStaff2;
	}

}