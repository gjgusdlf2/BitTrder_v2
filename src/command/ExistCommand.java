package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command{
	public ExistCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		HttpSession session = request.getSession();
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS:
			System.out.println("--------6 ExistCommad-------");
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmployeeID(request.getParameter("empno"));
			emp.setName(request.getParameter("name"));
			boolean exist = EmployeeServiceImpl
			.getInstance()
			.existsEmployee(emp);
			if(exist) {
				System.out.println("사원 접근허용 exist: "+exist);
				Pagination paging = new Pagination();
				paging.carryOut(request);
				Proxy pagePxy = new PageProxy();
				pagePxy.carryOut(paging);
				List<CustomerDTO> list = CustomerServiceImpl.getInstance()
				.bringCustomerList(pagePxy);
				System.out.println("총 고객의 수 : "+list.size());
				System.out.println("가장 최근에 가입한 고객명: "+list.get(0).getCustomerName());
				request.setAttribute("list", list);
			}else {
				System.out.println("접근불가");
				super.setDomain("home");
				super.setPage("main");
				super.execute();
			}
			break;
		case SIGNIN:
			CustomerDTO cust = new CustomerDTO();
			cust.setCustomerID(request.getParameter("customer_id"));
			cust.setPassword(request.getParameter("password"));
			cust = CustomerServiceImpl.getInstance()
				.retrieveCustomer(cust);
			
			if(cust != null) {
				System.out.println("로그인 성공");
				session.setAttribute("customer", cust);
			}else {
				System.out.println("로그인 실패");
				super.setDomain("customer");
				super.setPage("signin");
				super.execute();
			}
			break;
		default:
			break;
		
		}
		
		
	}
}
