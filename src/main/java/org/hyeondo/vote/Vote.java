package org.hyeondo.vote;

public class Vote {
	String pollId;
	String userId;
	String name;
	int choice;
	String cdate;

	/*
	 * Getter and Setter methods
	 */
	public String getPollId() {
		return pollId;
	}

	public void setPollId(String pollId) {
		this.pollId = pollId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCdate() {
		return cdate;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	@Override
	public String toString() {
		return "\nVote [pollId=" + pollId + ", userId=" + userId + ", name=" + name + ", choice=" + choice + ", cdate="
				+ cdate + "]";
	}
}