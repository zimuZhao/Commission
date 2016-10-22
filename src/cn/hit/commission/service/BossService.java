package cn.hit.commission.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hit.commission.dao.IBossDAO;
import cn.hit.commission.dao.IUserDAO;
import cn.hit.commission.po.Commission;
import cn.hit.commission.po.Salesman;
import cn.hit.commission.po.Salesrecord;

public class BossService implements IBossService {
	IUserDAO dao;
	IBossDAO bossDao;

	public IUserDAO getDao() {
		return dao;
	}

	public void setDao(IUserDAO dao) {
		this.dao = dao;
	}

	public IBossDAO getBossDao() {
		return bossDao;
	}

	public void setBossDao(IBossDAO bossDao) {
		this.bossDao = bossDao;
	}

	@Override
	public List<Salesrecord> queryTodaySales() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date curDate = new Date();
		String hql = "from Salesrecord as c where c.saleDate='" + dateFormat.format(curDate) + "'";
		List<Salesrecord> saleList = new ArrayList<Salesrecord>();
		saleList = dao.findList(hql);
		if (saleList.size() > 0) {
			System.out.println("老板，今日全部销售情况已查询完毕," + saleList.size());
			return saleList;
		}
		System.out.println("老板，查询不到今日销售情况," + saleList.size());
		return saleList;
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
	 * 查询当月佣金结算信息
	 */
	public List<Commission> searchCommission(int salesmanID, String date) {
		// TODO Auto-generated method stub
		List<Commission> list = new ArrayList<Commission>();
		if (salesmanID == -1) {
			String hql = "from Commission as c where c.salesDate like '" + date + "%'";
			list = dao.findList(hql);
		} else {
			String hql = "from Commission as c where c.salesmanID = " + salesmanID + " and c.salesDate like '" + date
					+ "%'";
			list = dao.findList(hql);
		}
		return list;
	}

	@Override
	/**
	 * 查询上周或上个月的销售记录
	 */
	public List<Salesrecord> queryLastSales(String flag) {
		List<Salesrecord> list = null;
		Date endDate = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(endDate);
		if (flag.equals("month")) {
			cl.add(Calendar.MONTH, -1);
		}
		if (flag.equals("week")) {
			cl.add(Calendar.DATE, -7);
		}

		Date startDate = cl.getTime();
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");

		// 格式化开始日期和结束日期
		String start = dd.format(startDate);
		String end = dd.format(endDate);

		String hql = "from Salesrecord as c where c.saleDate >= '" + start + "' and c.saleDate <= '" + end + "'";
		list = dao.findList(hql);

		return list;
	}

	/**
	 * 查询上个月的销售情况
	 */
	@Override
	public List<int[]> queryLastMonth() {

		List<Salesrecord> list = null;
		List<int[]> salesList = new ArrayList<int[]>();

		// 计算当前日期前一天的日期
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, -1);
		Date lastMonth = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String lastMonthStr = sdf.format(lastMonth);
		System.out.println("defaultDat is " + lastMonthStr);
		// 查询上个月全部的销售
		String hql = "from Salesrecord as c where c.saleDate like '" + lastMonthStr + "%'";
		list = dao.findList(hql);

		// 获取该月的最大天数
		int MaxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		// 计算每天的销售记录
		int[] YLocks = new int[MaxDay];
		int[] YStocks = new int[MaxDay];
		int[] YBarrels = new int[MaxDay];

		for (int i = 0; i < MaxDay; i++) {
			YLocks[i] = 0;
			YStocks[i] = 0;
			YBarrels[i] = 0;
		}

		for (int i = 0; i < list.size(); i++) {
			int locksnum, stocksnum, barrelsnum;
			locksnum = stocksnum = barrelsnum = 0;
			int index = 0;
			Salesrecord recordAdd = list.get(i);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(recordAdd.getSaleDate());
			index = recordAdd.getSaleDate().getDate() - 1;

			locksnum = YLocks[index];
			stocksnum = YStocks[index];
			barrelsnum = YBarrels[index];

			locksnum += recordAdd.getLocksnum();
			stocksnum += recordAdd.getStocksnum();
			barrelsnum += recordAdd.getBarrelsnum();

			YLocks[index] = locksnum;
			YStocks[index] = stocksnum;
			YBarrels[index] = barrelsnum;

		}
		salesList.add(YLocks);
		salesList.add(YStocks);
		salesList.add(YBarrels);
		return salesList;
	}

	/*
	 * 查询排行前8的员工名单(Service)
	 */
	@Override
	public List<Map<String, Object>> queryTopUser() {
		List<Commission> list = new ArrayList<Commission>();
		// 计算当前日期前一天的日期
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, -1);
		Date lastMonth = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String lastMonthStr = sdf.format(lastMonth);
		String hql = "from Commission c where c.salesDate like '" + lastMonthStr + "%' order by c.totalPrice desc";
		list = dao.findList(hql);

		int topNum = 8;
		if (list.size() < topNum) {
			topNum = list.size();
		}

		List<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < topNum; i++) {
			Commission c = list.get(i);
			System.out.println(c.getSalesmanID().getName());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("num", i + 1);
			map.put("Salesman", c.getSalesmanID().getName());
			map.put("LocksNum", c.getLocksum());
			map.put("StocksNum", c.getStocksum());
			map.put("BarrelsNum", c.getBarrelsum());
			map.put("TotalPrice", c.getTotalPrice());
			map.put("Commission", c.getTotalCommission());
			jsonList.add(map);
		}

		System.out.println("查询排行前8的员工名单," + jsonList.toString());

		return jsonList;
	}

	/**
	 * 查询销量排行前10的地区(Service)
	 */
	@Override
	public Map<String, Object> queryTopTown() {
		Map<String, Object> wrapper = new HashMap<String, Object>();
		String hql = "select s.town,sum(s.num) from Salesrecord s group by s.town order by sum(s.num) desc ";
		List<Object[]> queryList = dao.findList(hql);

		boolean status = true;

		List<String> towns = new ArrayList<String>();
		List<Long> sales = new ArrayList<Long>();
		Map<String, Object> innerMap = new HashMap<String, Object>();

		if (queryList == null) {
			status = false;
		} else {
			for (Object[] object : queryList) {
				String name = (String) object[0];
				Long num = (Long) object[1];
				towns.add(name);
				sales.add(num);
				System.out.println(name);
			}
			innerMap.put("name", towns);
			innerMap.put("data", sales);
		}
		wrapper.put("status", status);
		wrapper.put("result", innerMap);

		return wrapper;
	}

	public List<Salesrecord> queryLastMonthReport() {
		List<Salesrecord> list = null;
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, -1);
		Date lastMonth = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String lastMonthStr = sdf.format(lastMonth);
		System.out.println("defaultDat is " + lastMonthStr);
		// 查询上个月全部的销售
		String hql = "from Salesrecord as c where c.saleDate like '" + lastMonthStr + "%'";
		list = dao.findList(hql);
		return list;
	}

	@Override
	public List<Salesman> selectSalesmenBypage(int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		return dao.selectSalesmenBypage(pageSize, pageNum);
	}

	@Override
	public int selectSalesmenCount(int pageSize) {
		// TODO Auto-generated method stub
		return dao.selectSalesmenCount(pageSize);
	}

	@Override
	public boolean deleteSalesman(int salesmanID) {
		// TODO Auto-generated method stub
		return dao.deleteSalesman(salesmanID);
	}

	@Override
	public Salesman saveSalesman(Salesman salesman) {
		// TODO Auto-generated method stub
		return dao.saveSalesman(salesman);
	}

	@Override
	public Salesman updateSalesmanByBoss(Salesman salesman) {
		// TODO Auto-generated method stub
		return dao.updateSalesmanByBoss(salesman);
	}

	@Override
	public List<Commission> queryHistCommission(int pageSize, int pageNum, String startTime, String endTime) {
		// TODO Auto-generated method stub
		List<Commission> list = bossDao.queryHistCommission(pageSize, pageNum, startTime, endTime);

		return list;
	}

	@Override
	public int countCommissionPages(int pageSize, String startTime, String endTime) {
		String hql = "select count(*) from Commission as c where c.salesDate<='" + endTime + "' and c.salesDate>='"
				+ startTime + "'";
		int totalSize = 0;
		totalSize = bossDao.queryCount(pageSize, hql);

		return totalSize;
	}

	/*
	 * 查询指定时间区间内，各地区的销售情况
	 * (non-Javadoc)
	 * @see cn.hit.commission.service.IBossService#queryByTownTime(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> queryByTownTime(String startTime, String endTime) {
		Map<String, Object> wrapper = new HashMap<String, Object>();
		Map<String, Object> innerMap = new HashMap<String, Object>();

		boolean status = true;
		String hql = "select s.town,sum(s.num) from Salesrecord s where s.saleDate<='" + endTime + "' and s.saleDate>='"
				+ startTime + "' group by s.town";
		List<Object[]> queryList = dao.findList(hql);
		List<String> towns = new ArrayList<String>();
		List<Long> sales = new ArrayList<Long>();

		if (queryList != null) {
			for (Object[] object : queryList) {
				String name = (String) object[0];
				Long num = (Long) object[1];
				towns.add(name);
				sales.add(num);
			}
		}else{
			status = false;
		}

		wrapper.put("status", status);
		innerMap.put("name", towns);
		innerMap.put("data", sales);

		wrapper.put("result", innerMap);

		return wrapper;
	}

	@Override
	public Salesman querySalesman(int salesmanID) {
		// TODO Auto-generated method stub
		Salesman man = dao.findBySalesID(salesmanID);
		
		return man;
	}

}
