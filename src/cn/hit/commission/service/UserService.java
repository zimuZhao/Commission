package cn.hit.commission.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import cn.hit.commission.dao.IUserDAO;
import cn.hit.commission.po.Commission;
import cn.hit.commission.po.Gunsmith;
import cn.hit.commission.po.Salesman;
import cn.hit.commission.po.Salesrecord;

public class UserService implements IUserService {
	IUserDAO dao;

	public IUserDAO getDao() {
		return dao;
	}

	public void setDao(IUserDAO dao) {
		this.dao = dao;
	}

	@Override
	/*
	 * 销售员登陆验证
	 */
	public Salesman salesmanLogin(int salesmanID, String pwd) {
		// TODO Auto-generated method stub
		Salesman man = dao.findBySalesID(salesmanID);
		if (man != null && man.getPassword().equals(pwd)) {
			return man;
		}
		return null;
	}

	@Override
	/**
	 * 供货商登陆验证
	 */
	public Gunsmith gunsmithLogin(int gunsmithID, String pwd) {
		// TODO Auto-generated method stub
		Gunsmith man = dao.findByGunsmithID(gunsmithID);
		if (man != null && man.getPassword().equals(pwd)) {
			return man;
		}
		return null;
	}

	@Override
	/**
	 * 保存销售员的电报信息
	 */
	public boolean saveSalesrecord(Salesrecord transientInstance) {
		return dao.save(transientInstance);
	}

	@Override
	/**
	 * 查看某销售员当前月的销售记录
	 */
	public List<Salesrecord> curMonthSaleRecord(int salesmanID) {
		String hql = "from Salesrecord as c where c.salesmanID=" + salesmanID;
		List<Salesrecord> saleList;
		List<Salesrecord> curSaleList = new ArrayList<Salesrecord>();
		saleList = dao.findList(hql);
		Date currentDate = new Date();
		Date recordDate;
		Calendar calCurrent = Calendar.getInstance();
		calCurrent.setTime(currentDate);
		int curYear = calCurrent.get(Calendar.YEAR);
		int curMonth = calCurrent.get(Calendar.MONTH);
		for (int i = 0; i < saleList.size(); i++) {
			recordDate = saleList.get(i).getSaleDate();
			Calendar calRecord = Calendar.getInstance();
			calRecord.setTime(recordDate);
			int year = calRecord.get(Calendar.YEAR);
			int month = calRecord.get(Calendar.MONTH);
			if (curYear == year && curMonth == month) {
				curSaleList.add(saleList.get(i));
			}
		}
		return curSaleList;
	}

	@Override
	/**
	 * 计算Locks销售金额
	 */
	public float computeLocksPrice(List<Salesrecord> lists) {
		// TODO Auto-generated method stub
		float sum = 0.0f;
		for (int i = 0; i < lists.size(); i++) {
			Salesrecord record = lists.get(i);
			if (record.getLocksnum() != -1) {
				sum += record.getLocksnum() * 45;
			}
		}
		return sum;
	}

	@Override
	/**
	 * 计算Stocks销售金额
	 */
	public float computeStocksPrice(List<Salesrecord> lists) {
		// TODO Auto-generated method stub
		float sum = 0.0f;
		for (int i = 0; i < lists.size(); i++) {
			Salesrecord record = lists.get(i);
			if (record.getLocksnum() != -1) {
				sum += record.getStocksnum() * 30;
			}
		}
		return sum;
	}

	@Override
	/**
	 * 计算Barrels销售金额
	 */
	public float computeBarrelsPrice(List<Salesrecord> lists) {
		// TODO Auto-generated method stub
		float sum = 0.0f;
		for (int i = 0; i < lists.size(); i++) {
			Salesrecord record = lists.get(i);
			if (record.getLocksnum() != -1) {
				sum += record.getBarrelsnum() * 25;
			}
		}
		return sum;
	}

	@Override
	/**
	 * 查询销售记录(Salesman)
	 */
	public int searchRecord(int salesmanID) {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date curDate = new Date();
		String hql = "from Salesrecord as c where c.salesmanID=" + salesmanID + "and c.saleDate='"
				+ dateFormat.format(curDate) + "'";
		List<Salesrecord> saleList = new ArrayList<Salesrecord>();
		saleList = dao.findList(hql);
		if (saleList.size() > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	/**
	 * 查询全部销售员的信息(Gunsmith)
	 */
	public List<Salesman> findAllSalesman() {
		// TODO Auto-generated method stub
		List<Salesman> lists = new ArrayList<Salesman>();
		String hql = "from Salesman as s";
		lists = dao.findList(hql);
		return lists;
	}

	@Override
	/**
	 * 计算销售员在指定月份的佣金
	 */
	public Commission computeCommission(Salesman man, Date date) {
		// 局部变量初始化
		Commission commission = new Commission();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		String hql = "from Salesrecord as c where c.salesmanID = " + man.getSalesmanID() + " and c.saleDate like '"
				+ dateFormat.format(date) + "%'";
		List<Salesrecord> saleList = new ArrayList<Salesrecord>();
		saleList = dao.findList(hql);

		int locksnum, stocksnum, barrelsnum;
		float totalNumDollar, totalCommission;
		totalNumDollar = totalCommission = 0.0f;
		locksnum = stocksnum = barrelsnum = 0;

		for (int i = 0; i < saleList.size(); i++) {
			Salesrecord record = saleList.get(i);
			if (record.getLocksnum() != -1) {
				locksnum = locksnum + record.getLocksnum();
				stocksnum = stocksnum + record.getStocksnum();
				barrelsnum = barrelsnum + record.getBarrelsnum();
			}
		}
		if (locksnum > 0 && stocksnum > 0 && barrelsnum > 0) {
			totalNumDollar = locksnum * 45 + stocksnum * 30 + barrelsnum * 25;
		}

		if (totalNumDollar <= 1000) {
			totalCommission = totalNumDollar * 0.1f;
		} else if (totalNumDollar > 1000 && totalNumDollar <= 1800) {
			totalCommission = 100 + (totalNumDollar - 1000) * 0.15f;
		} else if (totalNumDollar > 1800) {
			totalCommission = 100 + 120 + (totalNumDollar - 1800) * 0.2f;
		}

		commission.setLocksum(locksnum);
		commission.setStocksum(stocksnum);
		commission.setBarrelsum(barrelsnum);
		commission.setTotalCommission(totalCommission);
		commission.setTotalPrice(totalNumDollar);
		commission.setSalesmanID(man);
		commission.setSalesDate(date);

		return commission;
	}

	@Override
	public boolean saveCommission(Commission record) {
		// TODO Auto-generated method stub
		boolean flag = true;
		flag = dao.saveComRecord(record);
		return flag;
	}

	@Override
	public List<Commission> searchCommission(int salesmanID, String date) {
		// TODO Auto-generated method stub
		List<Commission> list = new ArrayList<Commission>();
		if (salesmanID == -1) {
			String hql = "from Commission as c where c.salesDate like '" + date + "%'";
			list = dao.findList(hql);
		} else {
			String hql = "from Commission as c where c.salesmanID = " + salesmanID + " and c.salesDate like '"
					+ date + "%'";
			list = dao.findList(hql);
		}
		return list;
	}

	@Override
	/**
	 * 验证销售额的有效性
	 */
	public boolean verifySaleReport(Salesman man, Date date, int locknum, int stocknum, int barrelnum) {
		// TODO Auto-generated method stub
		Commission tmp = this.computeCommission(man, date);
		int tmpLock, tmpStock, tmpBarrel;
		tmpLock = tmp.getLocksum() + locknum;
		tmpStock = tmp.getStocksum() + stocknum;
		tmpBarrel = tmp.getBarrelsum() + barrelnum;

		if (tmpLock <= 70 && tmpStock <= 80 && tmpBarrel <= 90) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	/**
	 * 更新销售员登陆密码
	 */
	public boolean updateUserPwd(Salesman man) {
		// TODO Auto-generated method stub
		boolean flag = dao.updateUserPwd(man);
		return flag;
	}
	
	@Override
	public Salesman updateSalesmanDetail(Salesman salesman) {
		// TODO Auto-generated method stub
		return dao.updateSalesman(salesman);
	}

}
