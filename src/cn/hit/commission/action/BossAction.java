package cn.hit.commission.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.hit.commission.po.Commission;
import cn.hit.commission.po.Salesman;
import cn.hit.commission.po.Salesrecord;
import cn.hit.commission.service.IBossService;

public class BossAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private IBossService service;

	private String searchDate;
	private List<Salesman> salesmanLists = null;
	private List<Commission> commissionLists = null;
	private List<Commission> historyLists = null;
	private Map<String, Object> jsonResult;

	public IBossService getService() {
		return service;
	}

	public void setService(IBossService service) {
		this.service = service;
	}

	public Map<String, Object> getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(Map<String, Object> jsonResult) {
		this.jsonResult = jsonResult;
	}

	public List<Salesman> getSalesmanLists() {
		return salesmanLists;
	}

	public void setSalesmanLists(List<Salesman> salesmanLists) {
		this.salesmanLists = salesmanLists;
	}

	public List<Commission> getCommissionLists() {
		return commissionLists;
	}

	public void setCommissionLists(List<Commission> commissionLists) {
		this.commissionLists = commissionLists;
	}

	public List<Commission> getHistoryLists() {
		return historyLists;
	}

	public void setHistoryLists(List<Commission> historyLists) {
		this.historyLists = historyLists;
	}

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

	public String bossBriefInfo() {
		ActionContext ctx = ActionContext.getContext();
		salesmanLists = service.findAllSalesman();
		ctx.getSession().put("salesmanLists", salesmanLists);

		return "success";
	}

	// 供货商主页查看今日销售信息
	public String todaySalesInfo() {
		boolean status = false;
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();

		Map<String, Object> lockMap = new HashMap<String, Object>();
		Map<String, Object> stockMap = new HashMap<String, Object>();
		Map<String, Object> barrelMap = new HashMap<String, Object>();

		Map<String, Object> totalMap = new HashMap<String, Object>();

		Map<String, Object> data = new HashMap<String, Object>();
		List<Salesrecord> list = service.queryTodaySales();
		List<Salesrecord> lastWeek = service.queryLastSales("week");
		List<Salesrecord> lastMonth = service.queryLastSales("month");

		if (list.size() >= 0 && lastWeek.size() >= 0 && lastMonth.size() >= 0) {
			status = true;
		}
		int Locks, Stocks, Barrels;
		float price = 0.0f;
		Locks = Stocks = Barrels = 0;

		for (int i = 0; i < list.size(); i++) {
			Locks += list.get(i).getLocksnum();
			Stocks += list.get(i).getStocksnum();
			Barrels += list.get(i).getBarrelsnum();
		}
		lockMap.put("name", "Locks");
		lockMap.put("price", 45);
		lockMap.put("num", Locks);

		stockMap.put("name", "Stocks");
		stockMap.put("price", 30);
		stockMap.put("num", Stocks);

		barrelMap.put("name", "Barrels");
		barrelMap.put("price", 25);
		barrelMap.put("num", Barrels);

		mapList.add(lockMap);
		mapList.add(stockMap);
		mapList.add(barrelMap);

		price = Locks * 45 + Stocks * 30 + Barrels * 25;

		totalMap.put("price", price);
		totalMap.put("lastWeek", computeSales(lastWeek));
		totalMap.put("lastMonth", computeSales(lastMonth));

		data.put("data", mapList);
		data.put("total", totalMap);

		map.put("status", status);
		map.put("result", data);

		jsonResult = map;

		return "success";
	}

	// 销售额的计算方法
	public float computeSales(List<Salesrecord> list) {
		int Locks, Stocks, Barrels;
		float price = 0.0f;
		Locks = Stocks = Barrels = 0;

		for (int i = 0; i < list.size(); i++) {
			Locks += list.get(i).getLocksnum();
			Stocks += list.get(i).getStocksnum();
			Barrels += list.get(i).getBarrelsnum();
		}

		price = Locks * 45 + Stocks * 30 + Barrels * 25;

		return price;
	}

	// 供货商查询上个月的具体销售总量情况(用日销售量统计表会更好）
	public String lastMonthInfo() {
		boolean status = true;
		List<int[]> list = service.queryLastMonth();

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Integer> X = new ArrayList<Integer>();

		for (int i = 0; i < list.get(0).length; i++) {
			X.add(i + 1);
		}

		resultMap.put("x", X);
		resultMap.put("y", list);

		map.put("status", status);
		map.put("result", resultMap);

		jsonResult = map;
		return "success";
	}

	// 供货商查询TOP8销售员工
	public String topUserList() {
		// 查询Commission表,Sort后取出前八名员工
		boolean status = true;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		map.put("status", status);
		resultMap.put("data", service.queryTopUser());
		map.put("result", resultMap);
		jsonResult = map;

		return "success";
	}

	// 供货商查询地区销售排行
	public String topTownList() {
		// 查询salesrecord表，Sort后取出前十名地区
		service.queryTopTown();
		boolean status = true;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		map.put("status", status);
		resultMap.put("data", service.queryTopUser());
		map.put("result", service.queryTopTown());
		jsonResult = map;

		return "success";
	}
}
