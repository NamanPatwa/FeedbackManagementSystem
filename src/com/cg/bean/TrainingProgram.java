package com.cg.bean;

import java.util.Date;

public class TrainingProgram {
	private int trainingCode;
	private int courseCode;
	private int facultyCode;
	private Date startDate;
	private Date endDate;
	public int getTrainingCode() {
		return trainingCode;
	}
	public void setTrainingCode(int trainingCode) {
		this.trainingCode = trainingCode;
	}
	public int getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}
	public int getFacultyCode() {
		return facultyCode;
	}
	public void setFacultyCode(int facultyCode) {
		this.facultyCode = facultyCode;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "TrainingProgram [trainingCode=" + trainingCode + ", courseCode=" + courseCode + ", facultyCode="
				+ facultyCode + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
}
