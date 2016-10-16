package cn.hit.commission.po;

import java.util.Date;
/**
 * 佣金
 * 
 * @author Xueting Ou
 *
 */
public class Commission {
	private int commissionID;
	private Salesman salesmanID;
	private Date salesDate;
	private int locksum;
	private int stocksum;
	private int barrelsum;
	private double totalCommission;
	private double totalPrice;
	
	private Date createTime;
	private Date time;
	private double firstcom;
	private double secondcom;
	private double thirdcom;
	private int deleteFlag;

	
	public int getCommissionID() {
		return commissionID;
	}

	public void setCommissionID(int commissionID) {
		this.commissionID = commissionID;
	}

	

	public Salesman getSalesmanID() {
		return salesmanID;
	}

	public void setSalesmanID(Salesman salesmanID) {
		this.salesmanID = salesmanID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getFirstcom() {
		return firstcom;
	}

	public void setFirstcom(double firstcom) {
		this.firstcom = firstcom;
	}

	public double getSecondcom() {
		return secondcom;
	}

	public void setSecondcom(double secondcom) {
		this.secondcom = secondcom;
	}

	public double getThirdcom() {
		return thirdcom;
	}

	public void setThirdcom(double thirdcom) {
		this.thirdcom = thirdcom;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	public double getTotalCommission() {
		return totalCommission;
	}

	public void setTotalCommission(double totalCommission) {
		this.totalCommission = totalCommission;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	

}
