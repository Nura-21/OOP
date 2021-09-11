package mainClasses;

import java.io.Serializable;
import java.util.Objects;

public class CourseFile implements Serializable {
	private static final long serialVersionUID = -4932187788779876734L;
	private String title;
	private String content;

	public CourseFile() {
		this.title = "new file";
		this.content = " ";
	}

	public CourseFile(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String toString() {
		return "CourseFile [title = " + title + ", content = " + content + "]";
	}

	public int hashCode() {
		return Objects.hash(content, title);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseFile other = (CourseFile) obj;
		return Objects.equals(content, other.content) && Objects.equals(title, other.title);
	}

}
