package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.CourseMaster;
import com.cg.bean.Feedback;
import com.cg.bean.TrainingProgram;
import com.cg.exception.CourseNotFoundException;
import com.cg.exception.InvalidCourseException;
import com.cg.exception.TrainingProgramNotFoundException;

public class Co_ordinatorDaoImpl implements Co_ordinatorDao {

	@Override
	public TrainingProgram addTrainingProgram(TrainingProgram training) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrainingProgram> fetchAllTrainingProgram() throws TrainingProgramNotFoundException {
	List<TrainingProgram> programs=new ArrayList<TrainingProgram>();
	Connection conn = null;
	try {
		conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement(fetchAllTrainingProgramQuery);
		
		ResultSet result = stmt.executeQuery();
		while(result.next()) {
			TrainingProgram program = new TrainingProgram();
			program.setCourseCode(result.getInt(1));
			program.setFacultyCode(result.getInt(2));
			program.setStartDate(result.getDate(3));
			program.setEndDate(result.getDate(4));
			programs.add(program);
		}
		if(programs.size() == 0)
			throw new TrainingProgramNotFoundException("No Training Programs exists as of now!!");
		return programs;
	} catch (SQLException e) {
		throw new TrainingProgramNotFoundException(e.getMessage());
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
	public TrainingProgram fetchTrainingProgramByTrainingCode(int code) throws TrainingProgramNotFoundException {
		Connection conn = null;
		TrainingProgram program=null;

		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(fetchTrainingProgramByTrainingCodeQuery);
			stmt.setInt(1, code);
			
			ResultSet result = stmt.executeQuery();
			if(result.next()) {
				program = new TrainingProgram();
				program.setCourseCode(result.getInt(1));
				program.setFacultyCode(result.getInt(1));
				program.setStartDate(result.getDate(2));
				program.setEndDate(result.getDate(3));
			} else
				throw new TrainingProgramNotFoundException("Training Program does not exist..");
			return program;
		} catch (SQLException e) {
			throw new TrainingProgramNotFoundException(e.getMessage());
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
	public TrainingProgram updateTrainingProgram(int code) throws TrainingProgramNotFoundException {
		Connection conn=null;
		TrainingProgram program=null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(updateTrainingProgramQuery);
			stmt.setInt(1, code);
			
			ResultSet result = stmt.executeQuery();
			if(result.next()) {
				program = new TrainingProgram();
				program.setTrainingCode(result.getInt(1));
				program.setCourseCode(result.getInt(1));
				program.setStartDate(result.getDate(2));
				program.setEndDate(result.getDate(3));
			} else
				throw new TrainingProgramNotFoundException("Training Program does not exist..");
			return program;
		} catch (SQLException e) {
			throw new TrainingProgramNotFoundException(e.getMessage());
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
	public boolean removeTrainingProgram(int code) throws TrainingProgramNotFoundException {
Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement( removeTrainingProgramQuery);
			stmt.setInt(1, code);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new TrainingProgramNotFoundException(e.getMessage());
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
	public ParticipantDao addParticipant(ParticipantDao participant) {
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
