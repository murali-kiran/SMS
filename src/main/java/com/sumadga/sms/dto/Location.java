package com.sumadga.sms.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Locations database table.
 * 
 */
@Entity
@Table(name="Locations")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int locationId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	private String locationName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTime;

	//bi-directional many-to-one association to SubjectTimeTable
	@OneToMany(mappedBy="location")
	private List<SubjectTimeTable> subjectTimeTables;

	public Location() {
	}

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Date getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public List<SubjectTimeTable> getSubjectTimeTables() {
		return this.subjectTimeTables;
	}

	public void setSubjectTimeTables(List<SubjectTimeTable> subjectTimeTables) {
		this.subjectTimeTables = subjectTimeTables;
	}

}