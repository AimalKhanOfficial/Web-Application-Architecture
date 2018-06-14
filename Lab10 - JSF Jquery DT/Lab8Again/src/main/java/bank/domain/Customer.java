package bank.domain;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

public class Customer {
	private String name;

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
