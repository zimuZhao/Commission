package cn.hit.commission.action;

import com.opensymphony.xwork2.ActionSupport;

public class PageRedirect extends ActionSupport{

	private static final long serialVersionUID = 1L;

	// 重定向至historyMonthlyReport.jsp
	public String historyMonthlyReport(){
		return "success";
	}
	
	// 重定向至gsManageSalesman.jsp
	public String gsManageSalesman(){
		return "success";
	}
	
	// 重定向至gunsmithIndex.jsp
	public String gunsmithIndex(){
		return "success";
	}
	
	// 重定向至myProfile.jsp
	public String myProfile(){
		return "success";
	}
	
	// 重定向至resetPassword.jsp
	public String resetPassword(){
		return "success";
	}
	
	// 重定向至salesmanIndex.jsp
	public String salesmanIndex(){
		return "success";
	}
	
}
