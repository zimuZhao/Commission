package cn.hit.commission.po;

import java.util.Date;

public class Commission {
	private int commissionID;
	private int salesmanID;
	private Date salesDate;
	private int locksum, stocksum, barrelsum;
	private float totalCommission, totalPrice;

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCommissionID() {
		return commissionID;
	}

	public void setCommissionID(int commissionID) {
		this.commissionID = commissionID;
	}

	public int getSalesmanID() {
		return salesmanID;
	}

	public void setSalesmanID(int salesmanID) {
		this.salesmanID = salesmanID;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public int getLocksum() {
		return locksum;
	}

	public void setLocksum(int locksum) {
		this.locksum = locksum;
	}

	public int getStocksum() {
		return stocksum;
	}

	public void setStocksum(int stocksum) {
		this.stocksum = stocksum;
	}

	public int getBarrelsum() {
		return barrelsum;
	}

	public void setBarrelsum(int barrelsum) {
		this.barrelsum = barrelsum;
	}

	public float getTotalCommission() {
		return totalCommission;
	}

	public void setTotalCommission(float totalCommission) {
		this.totalCommission = totalCommission;
	}

}
