package cn.hit.commission.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.hit.commission.po.Commission;
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
	private Salesman newSaleman;
	private String newPassword;

	private List<Salesrecord> lists = null;
	private List<Commission> commissionLists = null;
	private List<Commission> historyLists = null;

	private Map<String, Object> jsonResult;

	private Salesman salesmanDetail;

	public Salesman getSalesmanDetail() {
		return salesmanDetail;
	}

	public void setSalesmanDetail(Salesman salesmanDetail) {
		this.salesmanDetail = salesmanDetail;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Salesman getNewSaleman() {
		return newSaleman;
	}

	public void setNewSaleman(Salesman newSaleman) {
		this.newSaleman = newSaleman;
	}

	public Map<String, Object> getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(Map<String, Object> jsonResult) {
		this.jsonResult = jsonResult;
	}

	public List<Commission> getHistoryLists() {
		return historyLists;
	}

	public void setHistoryLists(List<Commission> historyLists) {
		this.historyLists = historyLists;
	}

	public List<Commission> getCommissionLists() {
		return commissionLists;
	}

	public void setCommissionLists(List<Commission> commissionLists) {
		this.commissionLists = commissionLists;
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
	public String userSaleBriefInfo() {
		ActionContext ctx = ActionContext.getContext();
		// 计算当前月的销售信息
		Salesman user = (Salesman) ctx.getSession().get("user");
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

	// 更新销售员个人基本信息
	public String updateUserInfo() {

		return "success";
	}

	// 更新销售员登陆密码
	public String updateUserPwd() {
		Map<String, Object> map = new HashMap<String, Object>();
		ActionContext ctx = ActionContext.getContext();
		String status = "false";

		Salesman tmpman = (Salesman) ctx.getSession().get("user");
		tmpman.setPassword(newPassword);
		if (newPassword != null && ser.updateUserPwd(tmpman)) {
			status = "true";
			System.out.println("密码修改成功");
		} else {
			System.out.println("密码修改失败");
		}
		map.put("status", status);

		jsonResult = map;
		return "success";
	}

	// 更新用户信息
	public String updateSalesmanDetail() {
		// System.out.print("jsdhjsah");
		Map<String, Object> map = new HashMap<String, Object>();

		/*
		 * salesmanDetail = new Salesman(); salesmanDetail.setName("12");
		 * salesmanDetail.setLinkman("12"); salesmanDetail.setEmail("1234");
		 * salesmanDetail.setMobile("3434"); salesmanDetail.setAddress("3255");
		 * salesmanDetail.setSalesmanID(100601);
		 * salesmanDetail.setUpdateTime(new Date());
		 */

		Salesman newSalesman = ser.updateSalesmanDetail(salesmanDetail);
		String status = "";
		if (newSalesman == null) {
			status = "false";
		} else {
			status = "success";
			ActionContext ctx = ActionContext.getContext();
			newSalesman.setPassword("");
			ctx.getSession().put("user", newSalesman);
		}
		map.put("status", status);
		map.put("result", newSalesman);
		jsonResult = map;
		return "success";
	}

}