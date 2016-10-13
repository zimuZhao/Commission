package cn.hit.commission.service;

import java.util.Date;
import java.util.List;

import cn.hit.commission.po.Commission;
import cn.hit.commission.po.Gunsmith;
import cn.hit.commission.po.Salesman;
import cn.hit.commission.po.Salesrecord;

public interface IUserService {
	public Salesman salesmanLogin(int salesmanID, String pwd);
	public Gunsmith gunsmithLogin(int gunsmithID, String pwd);
	public List<Salesrecord> curMonthSaleRecord(int salesmanID);
	public float computeLocksPrice(List<Salesrecord> lists);
	public float computeStocksPrice(List<Salesrecord> lists);
	public float computeBarrelsPrice(List<Salesrecord> lists);
	public Commission computeCommission(Salesman man, Date date);
	
	public int searchRecord(int salesmanID);
	public List<Commission> searchCommission(int salesmanID, String date);
	public List<Salesman> findAllSalesman();

	public boolean saveSalesrecord(Salesrecord transientInstance);
	public boolean saveCommission(Commission record);
	public boolean verifySaleReport(Salesman man, Date date, int locknum, int stocknum, int barrelnum);
}
