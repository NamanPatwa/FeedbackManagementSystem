package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.CourseMaster;
import com.cg.bean.Faculty;
import com.cg.bean.Feedback;
import com.cg.exception.CourseNotFoundException;
import com.cg.exception.InvalidCourseException;

public class AdminDaoImpl implements AdminDao {

	@Override
	public int addCourse(CourseMaster course) throws InvalidCourseException {
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(saveCourseQuery);
			stmt.setInt(1, course.getCourseId());
			stmt.setString(2, course.getCourseName());
			stmt.setInt(3, course.getDays());
			
			stmt.executeUpdate();
			ResultSet result = conn.createStatement().executeQuery(getCourseIdQuery);
			if(result.next())
				return result.getInt(1);
			else 
				return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidCourseException(e.getMessage());
		} finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public List<CourseMaster> fetchAllCourses() throws CourseNotFoundException {
		List<CourseMaster> courses = new ArrayList<CourseMaster>();
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(getAllCoursesQuery);
			
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				CourseMaster course = new CourseMaster();
				course.setCourseId(result.getInt(1));
				course.setCourseName(result.getString(2));
				course.setDays(result.getInt(3));
				courses.add(course);
			}
			if(courses.size() == 0)
				throw new CourseNotFoundException();
			return courses;
		} catch (SQLException e) {
			throw new CourseNotFoundException(e.getMessage());
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public CourseMaster fetchCourseByCourseId(int id) throws InvalidCourseException {
		Connection conn = null;
		CourseMaster course = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(getCourseQuery);
			stmt.setInt(1, id);
			
			ResultSet result = stmt.executeQuery();
			if(result.next()) {
				course = new CourseMaster();
				course.setCourseId(result.getInt(1));
				course.setCourseName(result.getString(2));
				course.setDays(result.getInt(3));
			} else
				throw new InvalidCourseException("Course does not exist..");
			return course;
		} catch (SQLException e) {
			throw new InvalidCourseException(e.getMessage());
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public CourseMaster updateCourse(CourseMaster course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCourse(int id) throws InvalidCourseException {
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(removeCourseQuery);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new InvalidCourseException(e.getMessage());
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Faculty addFacultySkill(Faculty faculty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Faculty addFacultySkillset(List<String> skillSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> viewTrainingProgramReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> viewFacultyWiseReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> viewFeedbackDefaultersReport() {
		// TODO Auto-generated method stub
		return null;
	}

}
