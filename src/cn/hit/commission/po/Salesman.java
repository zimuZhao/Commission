package cn.hit.commission.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Salesman {
	private int salesmanID;
	private String password;
	private String name;
	private String email;
	private String mobile;
	private Date createTime;
	private Date updateTime;
	private String address;
	private String linkman;
	private String description;
	private int deleteFlag;
	Set salesSet = new HashSet();
	
	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}



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
