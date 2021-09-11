package mainClasses;

import java.io.Serializable;
import java.util.Objects;

import wspEnums.TextGrade;

public class Mark implements Serializable {
	private static final long serialVersionUID = -7542549934306186398L;
	private int firstAtt;
	private int secondAtt;
	private int finalScore;
	private String textGrade;

	// this method is called in a constructor & other methods, so i put it here
	public void setTextGrade() {
		if (this.firstAtt >= 0 && this.secondAtt >= 0 && this.finalScore >= 0) {
			int totalScore = this.firstAtt + this.secondAtt + this.finalScore;
			this.textGrade = TextGrade.getTextGrade(totalScore);
		}
	}

	public Mark() {
		textGrade = "F";
		this.firstAtt = 0;
		this.secondAtt = 0;
		this.finalScore = 0;
	}

	public Mark(int firstAtt) {
		this();
		this.firstAtt = firstAtt;
	}

	public Mark(int firstAtt, int secondAtt) {
		this(firstAtt);
		this.secondAtt = secondAtt;
	}

	public Mark(int firstAtt, int secondAtt, int finalScore) {
		this(firstAtt, secondAtt);
		this.finalScore = finalScore;
		this.setTextGrade();
	}

	public int getFirstAtt() {
		return firstAtt;
	}

	public void setFirstAtt(int firstAtt) {
		this.firstAtt = firstAtt;
		this.setTextGrade();
	}

	public int getSecondAtt() {
		return secondAtt;
	}

	public void setSecondAtt(int secondAtt) {
		this.secondAtt = secondAtt;
		this.setTextGrade();
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
		this.setTextGrade();
	}

	public String getTextGrade() {
		return textGrade;
	}

	public double calcGPA(Course course) {
		int credits = course.getCredits(); // That's my only idea how to access credits
		return (credits * TextGrade.getDigitalGrade(this.textGrade)) / credits;
	}

	public String toString() {
		return "Mark [firstAtt = " + firstAtt + ", secondAtt = " + secondAtt + ", finalScore = " + finalScore
				+ ", textGrade = " + textGrade + "]";
	}

	public int hashCode() {
		return Objects.hash(finalScore, firstAtt, secondAtt, textGrade);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
		return finalScore == other.finalScore && firstAtt == other.firstAtt && secondAtt == other.secondAtt
				&& Objects.equals(textGrade, other.textGrade);
	}

	// this class doesn't need clone, right? I hope it doesn't.

}
