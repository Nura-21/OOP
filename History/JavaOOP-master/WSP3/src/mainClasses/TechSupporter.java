package mainClasses;

import wspEnums.UserType;

public class TechSupporter extends Employee {
	private static final long serialVersionUID = -3540967659527266674L;

	public TechSupporter() {
		super();
	}

	public TechSupporter(String name, String surname) {
		super(name, surname, UserType.TECHSUPPORT);
	}

	public TechSupporter(String name, String surname, int salary, int workExperience) {
		super(name, surname, UserType.TECHSUPPORT, salary, workExperience);
	}

	public String viewCurrentOrders() {
		String res = "";
		for (Order o : DataBase.getInstance().getCurrentOrders())
			res += o;
		return res;
	}

	public String viewDoneOrders() {
		String res = "";
		for (Order o : DataBase.getInstance().getDoneOrders())
			res += o;
		return res;
	}

	public boolean acceptOrder(int id) {
		for (Order o : DataBase.getInstance().getCurrentOrders())
			if (o.getId() == id) {
				o.setStatus(true);
				DataBase.getInstance().getDoneOrders().add(o);
				DataBase.getInstance().getCurrentOrders().remove(o);
				return true;
			}
		return false;
	}
	

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TechSupport[" + super.toString() + "]";
	}

	@Override
	public boolean send(Message message) {
		return false;
	}

}
