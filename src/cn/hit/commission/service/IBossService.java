package cn.hit.commission.service;

import java.util.List;
import java.util.Map;

import cn.hit.commission.po.Commission;
import cn.hit.commission.po.Salesman;
import cn.hit.commission.po.Salesrecord;

public interface IBossService {
	public List<Salesrecord> queryTodaySales();

	public List<Salesman> findAllSalesman();

	public List<Salesrecord> queryLastSales(String flag);

	public List<int[]> queryLastMonth();

	public List<Map<String, Object>> queryTopUser();

	public List<Map<String, Object>> queryTopTown();

	public List<Commission> searchCommission(int salesmanID, String date);

	// boss查询历史佣金报表
	public List<Commission> queryHistCommission(int pageSize, int pageNum, String startTime, String endTime);
	// 查询指定时间内的佣金报表的总页数
	public int countCommissionPages(int pageSize, String startTime, String endTime);
	
	// 查询指定时间内地区销售情况
	public List queryByTownTime(String startTime, String endTime);

	// boss查询所有销售员并分页显示
	public List<Salesman> selectSalesmenBypage(int pageSize, int pageNum);
	// 查询销售员总页数
	public int selectSalesmenCount(int pageSize);

	// boss删除单个用户
	public boolean deleteSalesman(int salesmanID);

	// boss添加用户
	public Salesman saveSalesman(Salesman salesman);

	// boss更新用户
	public Salesman updateSalesmanByBoss(Salesman salesman);
}
