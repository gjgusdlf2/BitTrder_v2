package dao;

import java.util.List;

import domain.CustomerDTO;
import proxy.Proxy;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cust);
	public List<CustomerDTO> selectCustomerList(Proxy pxy);
	public List<CustomerDTO> selectCustomers(Proxy pxy);
	public CustomerDTO selectCustomer(CustomerDTO cust);
	public int countCustomers(Proxy pxy);
	public boolean existsCustomerID(CustomerDTO cust);
	public void updateCustomer(CustomerDTO cust);
	public void deleteCustomer(CustomerDTO cust);
}
