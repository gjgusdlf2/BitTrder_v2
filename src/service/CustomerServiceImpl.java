package service;

import java.util.List;

import dao.CustomerDAOImpl;
import domain.CustomerDTO;
import proxy.Proxy;

public class CustomerServiceImpl implements CustomerService{
	private static CustomerServiceImpl instance = new CustomerServiceImpl();
	CustomerDAOImpl dao;
	private CustomerServiceImpl() {
		dao = CustomerDAOImpl.getInstance();
	}
	public static CustomerServiceImpl getInstance() {
		return instance;
	}

	

	@Override
	public void registCustomer(CustomerDTO cust) {
		dao.insertCustomer(cust);
	}

	@Override
	public List<CustomerDTO> bringCustomerList(Proxy pxy) {
		return dao.selectCustomerList(pxy);
	}

	@Override
	public List<CustomerDTO> retrieveCustomers(Proxy pxy) {
		return dao.selectCustomers(pxy);
	}

	@Override
	public CustomerDTO retrieveCustomer(CustomerDTO cust) {
		return dao.selectCustomer(cust);
	}

	@Override
	public int countCustomers(Proxy pxy) {
		return dao.countCustomers(pxy);
	}

	@Override
	public boolean existsCustomerID(CustomerDTO cust) {
		return dao.existsCustomerID(cust);
	}

	@Override
	public void modifyCustomer(CustomerDTO cust) {
		dao.updateCustomer(cust);
	}

	@Override
	public void removeCustomer(CustomerDTO cust) {
		dao.deleteCustomer(cust);
	}

	

}
