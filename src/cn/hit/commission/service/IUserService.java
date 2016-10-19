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

	public List<Salesman> findAllSalesman();

	public boolean saveSalesrecord(Salesrecord transientInstance);
	public boolean saveCommission(Commission record);
	public boolean verifySaleReport(Salesman man, Date date, int locknum, int stocknum, int barrelnum);
	public boolean updateUserPwd(Salesman man);
	//更新用户详细信息
	public Salesman updateSalesmanDetail(Salesman salesman);
	
	//user分页查询销售记录
	public List<Salesrecord> selectSalesRecordBypage(int salesmanID,String startTime,String endTime,int pageSize,int pageNum);
	//user查询记录总页数
	public int selectSalesRecordCount(int salesmanID,int pageSize);
	//user分页查询佣金情况
	public List<Commission> selectCommissionBypage(int salesmanID,String startTime,String endTime,int pageSize,int pageNum);
	//user查询佣金记录总数
	public int selectCommissionCount(int salesmanID,int pageSize);

}
