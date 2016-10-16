package cn.hit.commission.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.hit.commission.po.Commission;
import cn.hit.commission.po.Salesman;
import cn.hit.commission.service.IUserService;

public class BossAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IUserService service;
	
	private String searchDate;
	private List<Salesman> salesmanLists = null;
	private List<Commission> commissionLists = null;
	private List<Commission> historyLists = null;
	
	
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
	
	public IUserService getService() {
		return service;
	}

	public void setService(IUserService service) {
		this.service = service;
	}
	
	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
	
	//供货商主页概要信息
	public String bossBriefInfo(){
		ActionContext ctx = ActionContext.getContext();
		salesmanLists = service.findAllSalesman();
		ctx.getSession().put("salesmanLists", salesmanLists);
		return "success";
	}

	//供货商查询本月销售及佣金报表
	public String searchMonthReport() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		String tmp = dateFormat.format(new Date());
		commissionLists = service.searchCommission(-1, tmp);
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
		historyLists = service.searchCommission(-1, searchDate);
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
