package com.cg.bean;

public class Feedback {
	private int trainingCode;
	private int participantId;
	private int presentationAndCommunication;
	private int doubtClarification;
	private int timeManagement;
	private int handout;
	private int hwSwNwAvailability;
	public int getTrainingCode() {
		return trainingCode;
	}
	public void setTrainingCode(int trainingCode) {
		this.trainingCode = trainingCode;
	}
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public int getPresentationAndCommunication() {
		return presentationAndCommunication;
	}
	public void setPresentationAndCommunication(int presentationAndCommunication) {
		this.presentationAndCommunication = presentationAndCommunication;
	}
	public int getDoubtClarification() {
		return doubtClarification;
	}
	public void setDoubtClarification(int doubtClarification) {
		this.doubtClarification = doubtClarification;
	}
	public int getTimeManagement() {
		return timeManagement;
	}
	public void setTimeManagement(int timeManagement) {
		this.timeManagement = timeManagement;
	}
	public int getHandout() {
		return handout;
	}
	public void setHandout(int handout) {
		this.handout = handout;
	}
	public int getHwSwNwAvailability() {
		return hwSwNwAvailability;
	}
	public void setHwSwNwAvailability(int hwSwNwAvailability) {
		this.hwSwNwAvailability = hwSwNwAvailability;
	}
	@Override
	public String toString() {
		return "Feedback [trainingCode=" + trainingCode + ", participantId=" + participantId
				+ ", presentationAndCommunication=" + presentationAndCommunication + ", doubtClarification="
				+ doubtClarification + ", timeManagement=" + timeManagement + ", handout=" + handout
				+ ", hwSwNwAvailability=" + hwSwNwAvailability + "]";
	}
	
	
}
