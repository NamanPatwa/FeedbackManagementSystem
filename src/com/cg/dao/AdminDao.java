package com.cg.dao;

import java.util.List;

import com.cg.bean.CourseMaster;
import com.cg.bean.Faculty;
import com.cg.bean.Feedback;
import com.cg.exception.CourseNotFoundException;
import com.cg.exception.InvalidCourseException;

public interface AdminDao {

	String saveCourseQuery = "INSERT INTO COURSE_MASTER VALUES(?,?,?)";
	String getCourseQuery = "SELECT * FROM COURSE_MASTER WHERE COURSE_ID=?";
	String getAllCoursesQuery = "SELECT * FROM COURSE_MASTER";
	String removeCourseQuery = "DELETE FROM COURSE_MASTER WHERE COURSE_ID=?";
	String getCourseIdQuery = "SELECT COURSE_ID FROM COURSE_MASTER";
	
	int addCourse(CourseMaster course) throws InvalidCourseException;
	
	List<CourseMaster> fetchAllCourses() throws CourseNotFoundException;
	
	CourseMaster fetchCourseByCourseId(int id) throws InvalidCourseException;
	
	CourseMaster updateCourse(CourseMaster course);
	
	boolean removeCourse(int id) throws InvalidCourseException;
	
	Faculty addFacultySkill(int id, String skillset);
	
	//Faculty addFacultySkillset(List<String> skillSet);
	
	List<Feedback> viewTrainingProgramReport();
	
	List<Feedback> viewFacultyWiseReport();
	
	List<Feedback> viewFeedbackDefaultersReport();
	
}
