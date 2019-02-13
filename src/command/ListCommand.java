package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;



public class ListCommand extends Command{
	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		PageProxy pagepxy = new PageProxy();
		Pagination page = new Pagination();
		page.carryOut(request);
		pagepxy.carryOut(page);
		List<CustomerDTO> list = CustomerServiceImpl
								.getInstance()
								.bringCustomerList(pagepxy);
		System.out.println("==================들어오나?");
		request.setAttribute("list", list);
	}
}
