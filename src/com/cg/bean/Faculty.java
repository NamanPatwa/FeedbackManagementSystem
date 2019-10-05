package com.cg.bean;

import java.util.List;

public class Faculty {
	private int facultyId;
	private List<String> skillSet;
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public List<String> getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(List<String> skillSet) {
		this.skillSet = skillSet;
	}
	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", skillSet=" + skillSet + "]";
	}
	
}
