package com.cg.service;

import java.util.List;

import com.cg.bean.CourseMaster;
import com.cg.bean.Faculty;
import com.cg.bean.Feedback;
import com.cg.dao.AdminDao;
import com.cg.dao.AdminDaoImpl;
import com.cg.exception.CourseNotFoundException;
import com.cg.exception.InvalidCourseException;

public class AdminServiceImpl implements AdminService {

	private AdminDao dao;
	
	public AdminServiceImpl() {
		dao = new AdminDaoImpl();
	}
	
	@Override
	public int saveCourse(CourseMaster course) throws InvalidCourseException {
		return dao.addCourse(course);
	}

	@Override
	public List<CourseMaster> getAllCourses() throws CourseNotFoundException {
		return dao.fetchAllCourses();
	}

	@Override
	public CourseMaster getCourseByCourseId(int id) throws InvalidCourseException {
		return dao.fetchCourseByCourseId(id);
	}

	@Override
	public CourseMaster updateCourse(CourseMaster course) {
		return dao.updateCourse(course);
	}

	@Override
	public boolean removeCourse(int id) throws InvalidCourseException {
		return dao.removeCourse(id);
	}

	@Override
	public Faculty saveFacultySkill(Faculty faculty) {
		return dao.addFacultySkill(faculty);
	}

	@Override
	public Faculty saveFacultySkillset(List<String> skillSet) {
		return dao.addFacultySkillset(skillSet);
	}

	@Override
	public List<Feedback> viewTrainingProgramReport() {
		return dao.viewTrainingProgramReport();
	}

	@Override
	public List<Feedback> viewFacultyWiseReport() {
		return dao.viewFacultyWiseReport();
	}

	@Override
	public List<Feedback> viewFeedbackDefaultersReport() {
		return dao.viewFeedbackDefaultersReport();
	}

}
