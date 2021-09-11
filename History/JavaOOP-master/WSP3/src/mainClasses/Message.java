package mainClasses;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Message implements Comparable<Object>, Cloneable, Serializable {
	private int id;
	private String title;
	private String text;
	private Employee sender;
	private Employee receiver;
	private Date date;

	public Message() {
		id = generateId();
		title = "new message " + Integer.toString(id);
		text = " ";
		date = new Date();
	}

	public Message(String title, String text, Employee sender, Employee receiver) {
		this();
		this.title = title;
		this.text = text;
		this.sender = sender;
		this.receiver = receiver;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int generateId() {
		int mx = -1;
		for(Order m : DataBase.getInstance().getCurrentOrders())
			if(m.getId()>mx)
				mx = m.getId();
		for(Order m : DataBase.getInstance().getDoneOrders())
			if(m.getId()>mx)
				mx = m.getId();
		for(Message m : DataBase.getInstance().getMessages())
			if(m.getId()>mx)
				mx = m.getId();
		return ++mx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Employee getSender() {
		return sender;
	}

	public void setSender(Employee sender) {
		this.sender = sender;
	}

	public Employee getReceiver() {
		return receiver;
	}

	public void setReceiver(Employee receiver) {
		this.receiver = receiver;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", text=" + text + ", sender=" + sender + ", receiver="
				+ receiver + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, text, sender, receiver, date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Message clone = (Message) super.clone();
		clone.date = (Date) date.clone();
		return clone;
	}

	public int compareTo(Object o) {
		Message m = (Message) o;
		return Integer.compare(this.id, m.id);
	}

}
