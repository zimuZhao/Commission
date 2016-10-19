package cn.hit.commission.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.hit.commission.po.Commission;
import cn.hit.commission.po.Salesman;
import cn.hit.commission.po.Salesrecord;
import cn.hit.commission.service.ILoginService;
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
	private ILoginService loginService;
	private Salesman newSaleman;
	
	// 销售员修改密码
	private String newpassword;
	private String oldpassword;
	
	private List<Salesrecord> lists = null;
	private List<Commission> commissionLists = null;
	private List<Commission> historyLists = null;

	private Map<String, Object> jsonResult;

	private Salesman salesmanDetail;

	private String startTime;
	private String endTime;
	private String pageNum;
	private String salesmanID;

	
	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getSalesmanID() {
		return salesmanID;
	}

	public void setSalesmanID(String salesmanID) {
		this.salesmanID = salesmanID;
	}

	public Salesman getSalesmanDetail() {
		return salesmanDetail;
	}

	public void setSalesmanDetail(Salesman salesmanDetail) {
		this.salesmanDetail = salesmanDetail;
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

	// 更新销售员登陆密码
	public String updateUserPwd() {
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "false";
		ActionContext ctx = ActionContext.getContext();
		Salesman manInSess = (Salesman) ctx.getSession().get("user");
	    Salesman man = loginService.salesmanLogin(manInSess.getSalesmanID(), oldpassword);
	    if(man!=null){
	    	manInSess.setPassword(newpassword);
			if (newpassword != null && ser.updateUserPwd(manInSess)) {
				status = "true";
				System.out.println("密码修改成功");
			} else {
				status = "false";
				System.out.println("密码修改失败");
			}
	    }else{
	    	status = "false";
	    }
		
		map.put("status", status);
		jsonResult = map;
		return "success";
	}

	// 查询当前销售员的销售信息
	public String selectSalesRecordByPage(){
		if ("".equals(pageNum) || pageNum == null) {
			pageNum = "1";
		}

		ActionContext ctx = ActionContext.getContext();
		Salesman salesman2 = (Salesman) ctx.getSession().get("user");
		List<Salesrecord> salesRecordList = ser.selectSalesRecordBypage(salesman2.getSalesmanID(),startTime, endTime, 10, Integer.parseInt(pageNum));
		int pageCount = ser.selectSalesRecordCount(salesman2.getSalesmanID(),10);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		map.put("totalPages", pageCount);
		for(int i = 0; i < salesRecordList.size(); i++){
			Map<String, Object> innerMap = new HashMap<String, Object>();
			Salesrecord salesrecord = salesRecordList.get(i);
			innerMap.put("salesmanID", salesrecord.getSalesmanID().getSalesmanID());
			innerMap.put("Num", salesrecord.getNum());
			innerMap.put("Date", salesrecord.getSaleDate());
			innerMap.put("Saleman", salesrecord.getSalesmanID().getName());
			innerMap.put("Locks", salesrecord.getLocksnum());
			innerMap.put("Stocks", salesrecord.getStocksnum());
			innerMap.put("Barrels", salesrecord.getBarrelsnum());
			
			mapList.add(innerMap);
		}
		
		map.put("data", mapList);
		jsonResult = map;

		return "success";
	}

	// 查询当前销售员的佣金报表
	public String selectCommissionByPage(){
		if ("".equals(pageNum) || pageNum == null) {
			pageNum = "1";
		}
		ActionContext ctx = ActionContext.getContext();
		Salesman salesman2 = (Salesman) ctx.getSession().get("user");
		List<Commission> commissionList = ser.selectCommissionBypage(salesman2.getSalesmanID(),startTime, endTime, 10, Integer.parseInt(pageNum));
		int pageCount = ser.selectCommissionCount(salesman2.getSalesmanID(),10);
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		map.put("totalPages", pageCount);
		for(int i = 0; i < commissionList.size(); i++){
			Map<String, Object> innerMap = new HashMap<String, Object>();
			Commission commission = commissionList.get(i);
			innerMap.put("salesmanID", commission.getSalesmanID().getSalesmanID());
			innerMap.put("Num", commission.getCommissionID());
			innerMap.put("Date", commission.getSalesDate());
			innerMap.put("Saleman", commission.getSalesmanID().getName());
			innerMap.put("Locks", commission.getLocksum());
			innerMap.put("Stocks", commission.getStocksum());
			innerMap.put("Barrels", commission.getBarrelsum());
			innerMap.put("Sale", commission.getTotalPrice());
			innerMap.put("basic", commission.getFirstcom());
			innerMap.put("midCommission", commission.getSecondcom());
			innerMap.put("highCommision", commission.getThirdcom());
			innerMap.put("totalCommission", commission.getTotalCommission());
			mapList.add(innerMap);
		}
		
		map.put("data", mapList);
		jsonResult = map;
		return "success";
	}
	
	// 更新销售员信息
	public String updateSalesmanDetail() {
		Map<String, Object> map = new HashMap<String, Object>();
		ActionContext ctx = ActionContext.getContext();
		Salesman salesmanInSess = (Salesman) ctx.getSession().get("user");
		
		if(!"".equals(salesmanDetail.getName())){
			salesmanInSess.setName(salesmanDetail.getName());
		}
		if(!"".equals(salesmanInSess.getLinkman())){
			salesmanInSess.setLinkman(salesmanDetail.getLinkman());
		}
		if(!"".equals(salesmanInSess.getEmail())){
			salesmanInSess.setEmail(salesmanDetail.getEmail());
		}
		if(!"".equals(salesmanInSess.getMobile())){
			salesmanInSess.setAddress(salesmanDetail.getAddress());
		}
		
		Salesman newSalesman = ser.updateSalesmanDetail(salesmanInSess);
		String status = "";
		if (newSalesman == null) {
			status = "false";
		} else {
			status = "success";
			newSalesman.setPassword("");
			ctx.getSession().put("user", newSalesman);
		}
		map.put("status", status);
		map.put("result", newSalesman);
		jsonResult = map;
		return "success";
	}

}