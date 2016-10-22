package cn.hit.commission.po;

import java.util.Date;

public class Salesrecord {
	private int salesID;
	private int locksnum;
	private int stocksnum;
	private int barrelsnum;
	private Salesman salesmanID;
	private Date saleDate;
	private Products productsId;
	private String town;
	private int num;
	private String description;
	private int deleteFlag;

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

	public Salesman getSalesmanID() {
		return salesmanID;
	}

	public void setSalesmanID(Salesman salesmanID) {
		this.salesmanID = salesmanID;
	}

	public Products getProductsId() {
		return productsId;
	}

	public void setProductsId(Products productsId) {
		this.productsId = productsId;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

}
