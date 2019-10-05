package com.cg.dao;

import java.util.List;

import com.cg.bean.Feedback;
import com.cg.bean.TrainingProgram;

public interface Co_ordinatorDao {

	TrainingProgram addTrainingProgram(TrainingProgram training);
	
	List<TrainingProgram> fetchAllTrainingProgram();
	
	TrainingProgram fetchTrainingProgramByTrainingCode(int code);
	
	TrainingProgram updateTrainingProgram(TrainingProgram training);
	
	boolean removeTrainingProgram(int code);
	
	Participant addParticipant(Participant participant);
	
	List<Feedback> viewTrainingProgramReport();
	
	List<Feedback> viewFacultyWiseReport();
	
	List<Feedback> viewFeedbackDefaultersReport();
}
	
	
