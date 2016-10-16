package cn.hit.commission.dao;

import java.util.List;

import cn.hit.commission.po.Commission;
import cn.hit.commission.po.Gunsmith;
import cn.hit.commission.po.Salesman;
import cn.hit.commission.po.Salesrecord;

public interface IUserDAO {
	public Salesman findBySalesID(int salesmanID);
	public Gunsmith findByGunsmithID(int gunsmithID);
	public List findList(String hql);
	
	public boolean save(Salesrecord transientInstance);
	public boolean saveComRecord(Commission transientInstance);
	public boolean updateUserPwd(Salesman salesman); 
	
	//销售员信息更新
	public Salesman updateSalesman(Salesman salesman);
	//boss查询所有销售员并分页显示
	public List<Salesman> selectSalesmenBypage(int pageSize,int pageNum);
	//查询销售员总页数
	public int selectSalesmenCount(int pageSize);
	//boss删除单个用户
	public boolean deleteSalesman(int salesmanID);
	//boss添加用户
	public Salesman saveSalesman(Salesman salesman);
	//boss更新用户
	public Salesman updateSalesmanByBoss(Salesman salesman);
	
}
