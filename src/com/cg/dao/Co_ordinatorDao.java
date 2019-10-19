package com.cg.dao;

import java.util.List;

import com.cg.bean.Feedback;
import com.cg.bean.TrainingProgram;

public interface Co_ordinatorDao {
	
	String addTrainingProgramQuery = "INSERT into TRAINING_MASTER "
			+ "values(tra_code.nextval, ?, ?, ?, ?)";
	String fetchAllTrainingProgramQuery = "SELECT * from TRAINING_MASTER ";
	String fetchTrainingProgramByTrainingCodeQuery = "SELECT * from TRAINING_MASTER "
			+ "where= TRAINING_CODE=?";
    String updateTrainingProgramQuery = "UPDATE TRAINING_MASTER SET START_DATE = ?, END_DATE = ? "
    		+ "where TRAINING_CODE=?";
    String removeTrainingProgramQuery="DELETE from TRAINING_MASTER where TRAINING_CODE=?";
    String addParticipantQuery="INSERT into TRAINING_PARTICIPANT_MASTER values (?,?)";
    String viewTrainingProgramReportQuery="SELECT * from FEEDBACK_MASTER where TRAINING_CODE=?";
    String viewFacultyWiseReportQuery="SELECT * from FEEDBACK_MASTER where (select TRAINING_CODE "
    		+ "from TRAINING_MASTER)";
    String viewFeedbackDefaultersReportQuery="SELECT * FROM EMPLOYEE_MASTER where(SELECT "
    		+ "PARTICIPANT_ID from "
    		+ "FEEDBACK_MASTER where (FB_PRS_COMM==null OR FB_CLRFY_DBTS==null "
    		+ "OR FB_TM==null OR FB_HND_OUT==null OR FB_HW_SW_NTWRK==null OR COMMENTS==null "
    		+ "OR SUGGESTIONS==null)";
    

	TrainingProgram addTrainingProgram(TrainingProgram training);
	
	List<TrainingProgram> fetchAllTrainingProgram();
	
	TrainingProgram fetchTrainingProgramByTrainingCode(int code);
	
	TrainingProgram updateTrainingProgram(TrainingProgram training);
	
	boolean removeTrainingProgram(int code);
	
	ParticipantDao addParticipant(ParticipantDao participant);
	
	List<Feedback> viewTrainingProgramReport();
	
	List<Feedback> viewFacultyWiseReport();
	
	List<Feedback> viewFeedbackDefaultersReport();
}
	
	
