package com.cg.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.bean.CourseMaster;
import com.cg.bean.Feedback;
import com.cg.bean.TrainingProgram;

public class Co_ordinatorDaoImpl implements Co_ordinatorDao {

	@Override
	public TrainingProgram addTrainingProgram(TrainingProgram training) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrainingProgram> fetchAllTrainingProgram() {
	List<TrainingProgram> programs=new ArrayList<TrainingProgram>();
	}

	@Override
	public TrainingProgram fetchTrainingProgramByTrainingCode(int code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TrainingProgram updateTrainingProgram(TrainingProgram training) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeTrainingProgram(int code) {
		// TODO Auto-generated method stub
		return false;
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
