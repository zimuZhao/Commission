package cn.hit.commission.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.hit.commission.po.Gunsmith;
import cn.hit.commission.po.Salesman;
import cn.hit.commission.service.ILoginService;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int loginID;
	private String type;
	private String password;

	private Salesman salesman;
	private Gunsmith gunsmith;
	private ILoginService service;

	public int getLoginID() {
		return loginID;
	}

	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setService(ILoginService service) {
		this.service = service;
	}

	public Salesman getSalesman() {
		return salesman;
	}

	public Gunsmith getGunsmith() {
		return gunsmith;
	}

	public String loginValid() {
		System.out.println("LoginAction----------------------------------------------");
		ActionContext ctx = ActionContext.getContext();
		// 用户已经登陆
		if (ctx.getSession().get("user") != null && ("salesman").equals(type)) {
			System.out.println("用户已经登陆");
			return "UserSuccess";
		}if(ctx.getSession().get("boss") != null && ("gunsmith").equals(type)){
			System.out.println("老板已经登陆");
			return "BossSuccess";
		}else {// 用户还未登录
			if (loginID == 0 || password == null) {
				System.out.println("用户非法登陆 ");
				return "LogIllegal";
			}
			System.out.println("Validation---------------------------------------------");
			// 销售员登陆验证
			if (("salesman").equals(type)) {
				// 在数据库中查找该账户
				Salesman loginSucc = service.salesmanLogin(loginID, password);
				salesman = loginSucc;
				// 若存在该用户，则获取用户当月的销售信息
				if (salesman != null) {
					salesman.setPassword("");
					ctx.getSession().put("user", salesman);
					System.out.println("login Success");
					return "UserSuccess";
				} else {
					return "LogFailed";
				}
				// 供货商登陆验证
			} else if (("gunsmith").equals(type)) {
				Gunsmith loginSucc = service.gunsmithLogin(loginID, password);
				gunsmith = loginSucc;
				if (gunsmith != null) {
					gunsmith.setPassword("");
					ctx.getSession().put("boss", gunsmith);
					return "BossSuccess";
				} else {
					return "LogFailed";
				}
			} else {
				return "LogFailed";
			}
		}
	}
	
	public String Logout(){
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().remove("user");
		ctx.getSession().remove("boss");
		return "success";
	}
}
