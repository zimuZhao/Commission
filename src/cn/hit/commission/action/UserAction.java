package cn.hit.commission.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.hit.commission.po.Commission;
import cn.hit.commission.po.Gunsmith;
import cn.hit.commission.po.Salesman;
import cn.hit.commission.po.Salesrecord;
import cn.hit.commission.service.IUserService;

public class UserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int loginID;
	private String type;
	private String password;
	private IUserService ser;
	private Salesman salesman;
	private Gunsmith gunsmith;

	private List<Salesrecord> lists = null;
	private List<Salesman> salesmanLists = null;
	private List<Commission> commissionLists = null;
	private List<Commission> historyLists = null;
	
	private String searchDate;

	public List<Commission> getHistoryLists() {
		return historyLists;
	}

	public void setHistoryLists(List<Commission> historyLists) {
		this.historyLists = historyLists;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

	public List<Commission> getCommissionLists() {
		return commissionLists;
	}

	public void setCommissionLists(List<Commission> commissionLists) {
		this.commissionLists = commissionLists;
	}

	public List<Salesman> getSalesmanLists() {
		return salesmanLists;
	}

	public void setSalesmanLists(List<Salesman> salesmanLists) {
		this.salesmanLists = salesmanLists;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Salesrecord> getLists() {
		return lists;
	}

	public void setLists(List<Salesrecord> lists) {
		this.lists = lists;
	}

	public Gunsmith getGunsmith() {
		return gunsmith;
	}

	public void setGunsmith(Gunsmith gunsmith) {
		this.gunsmith = gunsmith;
	}

	public Salesman getSalesman() {
		return salesman;
	}

	public void setSalesman(Salesman salesman) {
		this.salesman = salesman;
	}

	public int getLoginID() {
		return loginID;
	}

	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IUserService getSer() {
		return ser;
	}

	public void setSer(IUserService ser) {
		this.ser = ser;
	}
	
	// 获取销售员信息概要(Index)
	public String userSaleBriefInfo(){
		ActionContext ctx = ActionContext.getContext();
		// 计算当前月的销售信息
		Salesman user = (Salesman)ctx.getSession().get("user");
		lists = ser.curMonthSaleRecord(user.getSalesmanID());
		Commission tmp = ser.computeCommission(user, new Date());
		float locksprice = ser.computeLocksPrice(lists);
		float stocksprice = ser.computeStocksPrice(lists);
		float barrelsprice = ser.computeBarrelsPrice(lists);
		// 销售总额
		ctx.getSession().put("sumPrice", locksprice + stocksprice + barrelsprice);
		// 各组件销售额
		ctx.getSession().put("locksPrice", locksprice);
		ctx.getSession().put("stocksPrice", stocksprice);
		ctx.getSession().put("barrelsPrice", barrelsprice);
		// 各组件销售量
		ctx.getSession().put("locknum", tmp.getLocksum());
		ctx.getSession().put("stocknum", tmp.getStocksum());
		ctx.getSession().put("barrelnum", tmp.getBarrelsum());
		
		return "success";
	}

	//供货商查询本月销售及佣金报表
	public String searchMonthReport() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		String tmp = dateFormat.format(new Date());
		commissionLists = ser.searchCommission(-1, tmp);
		if (commissionLists.size() > 0) {
			this.clearErrorsAndMessages();
			return "success";
		} else {
			this.clearErrorsAndMessages();
			this.addActionMessage("<script>alert('本月还未有销售员结算！');</script>");
			return "fail";
		}
	}
	
	//供货商查询历史销售及佣金报表
	public String searchHistoryReport(){
		historyLists = ser.searchCommission(-1, searchDate);
		if (historyLists.size() > 0) {
			this.clearErrorsAndMessages();
			return "success";
		} else {
			this.clearErrorsAndMessages();
			this.addActionMessage("<script>alert('该月没有销售及佣金记录！');</script>");
			return "fail";
		}
	}

}