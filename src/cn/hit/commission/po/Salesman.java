package cn.hit.commission.po;

import java.util.HashSet;
import java.util.Set;

public class Salesman {
	private int salesmanID;
	private String password;
	private String name, email, mobile;
	Set salesSet = new HashSet();

	public Salesman() {
		salesmanID = 0;
		name = email = mobile = password = "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Set getSalesSet() {
		return salesSet;
	}

	public void setSalesSet(Set salesSet) {
		this.salesSet = salesSet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalesmanID() {
		return salesmanID;
	}

	public void setSalesmanID(int salesmanID) {
		this.salesmanID = salesmanID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
