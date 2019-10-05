package com.cg.bean;

public class CourseMaster {
	private int courseId;
	private String courseName;
	private int days;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "CourseMaster [courseId=" + courseId + ", courseName=" + courseName + ", days=" + days + "]";
	}
	
}
