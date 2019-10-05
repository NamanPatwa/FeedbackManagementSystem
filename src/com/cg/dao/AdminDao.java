package com.cg.dao;

import java.util.List;

import com.cg.bean.CourseMaster;
import com.cg.bean.Faculty;
import com.cg.bean.Feedback;

public interface AdminDao {

	CourseMaster addCourse(CourseMaster course);
	
	List<CourseMaster> fetchAllCourses();
	
	CourseMaster fetchCourseByCourseId(int id);
	
	CourseMaster updateCourse(CourseMaster course);
	
	boolean removeCourse(int id);
	
	Faculty addFacultySkill(Faculty faculty);
	
	Faculty addFacultySkillset(List<String> skillSet);
	
	List<Feedback> viewTrainingProgramReport();
	
	List<Feedback> viewFacultyWiseReport();
	
	List<Feedback> viewFeedbackDefaultersReport();
	
}
