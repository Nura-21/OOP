package mainClasses;

import java.util.Objects;

public class Order extends Message {
	private static final long serialVersionUID = -2836229036182405362L;
	private boolean status;

	public Order() {
		super();
		status = false;
	}

	public Order(String title, String text, Employee sender, Employee receiver) {
		super(title, text, sender, receiver);
		status = false;
	}
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [status=" + status + " " + super.toString();
	}

	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hash(status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Order clone = (Order) super.clone();
		clone.status = status;
		return clone;
	}

}
