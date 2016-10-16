package cn.hit.commission.Interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class AuthorityInterceptor extends AbstractInterceptor {
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = ActionContext.getContext();

		String actionName = invocation.getProxy().getActionName();
		System.out.println("Authority Interceptor executed!");

		// 对AccessAction不进行拦截
		if ("accessAction".equals(actionName)) {
			System.out.println("Let AccessAction Pass");
			String result = invocation.invoke();
			return result;
		}

		// 对其它Action进行拦截
		if (ctx.getSession().get("user") != null || ctx.getSession().get("boss") != null) {
			System.out.println("Authority Success");
			String result = invocation.invoke();
			return result;
		} else {
			System.out.println("Authority Failed");
			return Action.LOGIN;
		}

	}
}
