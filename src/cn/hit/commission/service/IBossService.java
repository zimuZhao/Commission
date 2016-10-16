package cn.hit.commission.service;

import java.util.List;
import java.util.Map;

import cn.hit.commission.po.Salesman;
import cn.hit.commission.po.Salesrecord;

public interface IBossService {	
	public List<Salesrecord> queryTodaySales();
	public List<Salesman> findAllSalesman();
	public List<Salesrecord> queryLastSales(String flag) ;
	public List<int[]> queryLastMonth();
	public List<Map<String,Object>> queryTopUser();
	public List<Map<String,Object>> queryTopTown();
}
