package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;

public class Commander {
	public static Command order(Map<String,Proxy> pxy) {
		System.out.println("---------5 Commander-----------");
		Command cmd = null;
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		System.out.println("들어오나?"+request.getParameter("cmd"));
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case MOVE:
			cmd = new Command(pxy);
			break;
		case REGISTER: case SIGNUP:
			cmd = new CreateCommand(pxy);
			break;
		case ACCESS: case SIGNIN:
			cmd = new ExistCommand(pxy);
			break;
		case CUST_LIST:
			cmd = new ListCommand(pxy);
		default:
			break;
		}
		return cmd;
	}

}
