package cn.hit.commission.service;

import cn.hit.commission.po.Gunsmith;
import cn.hit.commission.po.Salesman;

public interface ILoginService {
	
	public Salesman salesmanLogin(int salesmanID, String pwd);
	public Gunsmith gunsmithLogin(int gunsmithID, String pwd);

}
