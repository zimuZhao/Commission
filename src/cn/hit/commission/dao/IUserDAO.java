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
	
}
