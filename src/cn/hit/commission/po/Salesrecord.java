package cn.hit.commission.po;

import java.util.Date;

public class Salesrecord {
	int salesID;
	int locksnum, stocksnum, barrelsnum;
	int salesmanID;
	Date saleDate;
	
	public int getSalesID() {
		return salesID;
	}
	public void setSalesID(int salesID) {
		this.salesID = salesID;
	}
	public int getLocksnum() {
		return locksnum;
	}
	public void setLocksnum(int locksnum) {
		this.locksnum = locksnum;
	}
	public int getStocksnum() {
		return stocksnum;
	}
	public void setStocksnum(int stocksnum) {
		this.stocksnum = stocksnum;
	}
	public int getBarrelsnum() {
		return barrelsnum;
	}
	public void setBarrelsnum(int barrelsnum) {
		this.barrelsnum = barrelsnum;
	}
	public int getSalesmanID() {
		return salesmanID;
	}
	public void setSalesmanID(int salesmanID) {
		this.salesmanID = salesmanID;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	
}
