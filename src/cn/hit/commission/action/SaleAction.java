package cn.hit.commission.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.hit.commission.po.Commission;
import cn.hit.commission.po.Salesman;
import cn.hit.commission.po.Salesrecord;
import cn.hit.commission.service.IBossService;
import cn.hit.commission.service.IUserService;

public class SaleAction extends ActionSupport {

	private static final long serialVersionUID = -3957940672524312425L;

	private int locksnum, stocksnum, barrelsnum;
	IUserService ser;
	IBossService bossService;
	Salesman salesman;
	List<Salesrecord> lists = null;

	public IBossService getBossService() {
		return bossService;
	}

	public void setBossService(IBossService bossService) {
		this.bossService = bossService;
	}

	public List<Salesrecord> getLists() {
		return lists;
	}

	public void setLists(List<Salesrecord> lists) {
		this.lists = lists;
	}

	public Salesman getSalesman() {
		return salesman;
	}

	public void setSalesman(Salesman salesman) {
		this.salesman = salesman;
	}

	public IUserService getSer() {
		return ser;
	}

	public void setSer(IUserService ser) {
		this.ser = ser;
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

	public String saveSalesrecord() {
		Salesrecord record = new Salesrecord();
		Commission commission = new Commission();
		boolean saveRecordSucc = true;
		salesman = (Salesman) ActionContext.getContext().getSession().get("user");
		System.out.println("当前登录的用户为：" + salesman.getName());
		lists = ser.curMonthSaleRecord(salesman.getSalesmanID());
		if (salesman == null) {
			this.clearErrorsAndMessages();
			this.addActionMessage("<script>alert('无法获取当前用户信息！');</script>");
			return "fail";
		}
		record.setSaleDate(new Date());
		record.setSalesmanID(salesman);
		record.setLocksnum(locksnum);
		record.setStocksnum(stocksnum);
		record.setBarrelsnum(barrelsnum);
		record.setNum(locksnum * 45 + stocksnum * 30 + barrelsnum * 25);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		String tmp = dateFormat.format(new Date());

		if (bossService.searchCommission(salesman.getSalesmanID(), tmp).size() > 0) {
			this.clearErrorsAndMessages();
			this.addActionMessage("<script>alert('本月已结算！');</script>");
			return "success";
		} else {
			if (locksnum == -1) {
				commission = ser.computeCommission(salesman, new Date());
				if (ser.saveCommission(commission) && ser.saveSalesrecord(record)) {
					this.clearErrorsAndMessages();
					this.addActionMessage("<script>alert('本月结算成功！');</script>");
					return "success";
				} else {
					this.clearErrorsAndMessages();
					this.addActionMessage("<script>alert('本月结算失败！');</script>");
					return "fail";
				}
			} else {
				boolean flag = ser.verifySaleReport(salesman, new Date(), locksnum, stocksnum, barrelsnum);
				if (flag == false) {
					this.clearErrorsAndMessages();
					this.addActionMessage("<script>alert('您所提交的销售额超出最大限额！');</script>");
					return "fail";
				}
				if (ser.searchRecord(salesman.getSalesmanID()) == 1) {
					this.clearErrorsAndMessages();
					this.addActionMessage("<script>alert('已达到今日最大电报发送数！');</script>");
					return "fail";
				}
				saveRecordSucc = ser.saveSalesrecord(record);
				lists = ser.curMonthSaleRecord(salesman.getSalesmanID());
				if (saveRecordSucc) {
					this.clearErrorsAndMessages();
					this.addActionMessage("<script>alert('电报发送成功！');</script>");
					return "success";
				} else {
					this.clearErrorsAndMessages();
					this.addActionMessage("<script>alert('电报发送失败！');</script>");
					return "fail";
				}

			}

		}

	}

}
