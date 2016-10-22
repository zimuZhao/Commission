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
	
	// 重定向至curMonthlyReport.jsp
	public String currentMonthlyReport(){
		return "success";
	}
	
	// 重定向至myProfile.jsp
	public String myProfile(){
		return "success";
	}
	
	// 重定向至salesmanIndex.jsp
	public String salesmanIndex(){
		return "success";
	}
	
	// 重定向至salesResetPassword.jsp
	public String salesResetPassword(){
		return "success";
	}
	
	// 重定向至salesHistoryReport.jsp
	public String salesHistoryReport(){
		return "success";
	}
	
	// 重定向至salesCommission.jsp
	public String salesCommission(){
		return "success";
	}
	
}
