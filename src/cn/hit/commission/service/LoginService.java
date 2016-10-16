package cn.hit.commission.service;

import cn.hit.commission.dao.IUserDAO;
import cn.hit.commission.po.Gunsmith;
import cn.hit.commission.po.Salesman;

public class LoginService implements ILoginService {
	IUserDAO dao;

	public void setDao(IUserDAO dao) {
		this.dao = dao;
	}

	@Override
	/*
	 * 销售员登陆验证
	 */
	public Salesman salesmanLogin(int salesmanID, String pwd) {
		// TODO Auto-generated method stub
		Salesman man = dao.findBySalesID(salesmanID);
		if (man != null && man.getPassword().equals(pwd)) {
			return man;
		}
		return null;
	}

	@Override
	/**
	 * 供货商登陆验证
	 */
	public Gunsmith gunsmithLogin(int gunsmithID, String pwd) {
		// TODO Auto-generated method stub
		Gunsmith man = dao.findByGunsmithID(gunsmithID);
		if (man != null && man.getPassword().equals(pwd)) {
			return man;
		}
		return null;
	}

}
