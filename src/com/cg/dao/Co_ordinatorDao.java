package com.cg.dao;

import java.util.List;

import com.cg.bean.Feedback;
import com.cg.bean.TrainingProgram;
import com.cg.exception.CourseNotFoundException;
import com.cg.exception.InvalidCourseException;
import com.cg.exception.TrainingProgramNotFoundException;

public interface Co_ordinatorDao {
	
	String addTrainingProgramQuery = "INSERT into TRAINING_MASTER "
			+ "values(tra_code.nextval, ?, ?, ?, ?)";
	String fetchAllTrainingProgramQuery = "SELECT * from TRAINING_MASTER ";
	String fetchTrainingProgramByTrainingCodeQuery = "SELECT * from TRAINING_MASTER "
			+ "where= TRAINING_CODE=?";
    String updateTrainingProgramQuery = "UPDATE TRAINING_MASTER SET FACULTY_CODE=?, "
    		+ "COURSE_CODE=?, START_DATE = ?, END_DATE = where TRAINING_CODE=?";
    String removeTrainingProgramQuery="DELETE from TRAINING_MASTER where TRAINING_CODE=?";
    
    

	TrainingProgram addTrainingProgram(TrainingProgram training);
	// first getcourse_code match course table if exist
	// get course: select * from course_master where course_id = ?;
	// check for faculty code exist and role is faculty
	// query : select * from faculty_master where faculty_id = ? and role = ?
	// then add : insert into training_master values(?, ?, ?, ? ,?)
	// for service ONLY -->> 
	// date validation : date should be valid, end date should be greater than start date
	// current date se jyada dono
	
	List<TrainingProgram> fetchAllTrainingProgram() throws TrainingProgramNotFoundException;
	
	TrainingProgram fetchTrainingProgramByTrainingCode(int code) throws TrainingProgramNotFoundException;
	
	TrainingProgram updateTrainingProgram(int code) throws TrainingProgramNotFoundException;
	
	boolean removeTrainingProgram(int code) throws TrainingProgramNotFoundException;
	
	
	ParticipantDao addParticipant(ParticipantDao participant);
	// check whether available & check role in employee master
	// query : select * from employee_master where employee_id = ? and role = ?
	// for given training code not already enrolled
	// query: select * from training_participant_master where training_code = ? and participant_id = ?
	// for given training check whether available and upcoming date mai hai
	// query : select start_date from training_master where training_code = ?
	// Then, add...
	// query: insert into training_participant_master values (?, ?)
	
	List<Feedback> viewTrainingProgramReport();
	
	List<Feedback> viewFacultyWiseReport();
	
	List<Feedback> viewFeedbackDefaultersReport();
}
	
	
