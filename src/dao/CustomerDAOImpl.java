package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CustomerDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;


public class CustomerDAOImpl implements CustomerDAO{
	
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	private CustomerDAOImpl() {}
	public static CustomerDAOImpl getInstance() {
		return instance;
	}

	@Override
	public void insertCustomer(CustomerDTO cust) {
		try {
			PreparedStatement ps = DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection()
				.prepareStatement(CustomerSQL.SIGNUP.toString());
			ps.setString(1, cust.getCustomerID());
			ps.setString(2, cust.getCustomerName());
			ps.setString(3, cust.getPassword());
			ps.setString(4, cust.getAddress());
			ps.setString(5, cust.getCity());
			ps.setString(6, cust.getPostalCode());
			ps.setString(7, cust.getSsn());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CustomerDTO> selectCustomerList(Proxy pxy) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			Pagination page = ((PageProxy)pxy).getPage();
			PreparedStatement stmt = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.LIST.toString());
			String startRow = String.valueOf(page.getStartRow());
			String endRow = String.valueOf(page.getEndRow());
			System.out.println("DAO 스타트로우: "+startRow);
			System.out.println("DAO 엔드로우: "+endRow);
			stmt.setString(1, startRow);
			stmt.setString(2, endRow);
			ResultSet rs =  stmt.executeQuery();
			CustomerDTO cust = null;
			while (rs.next()) {
				cust = new CustomerDTO();
				cust.setNo(rs.getString("no"));
				cust.setCustomerID(rs.getString("CUSTOMER_ID"));
				cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cust.setSsn(rs.getString("SSN"));
				cust.setPhone(rs.getString("PHONE"));
				cust.setPostalCode(rs.getString("CODE"));
				cust.setCity(rs.getString("CITY"));
				cust.setAddress(rs.getString("ADDRESS"));
				list.add(cust);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<CustomerDTO> selectCustomers(Proxy pxy) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			String sql ="";
			PreparedStatement stmt = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			stmt.setString(1, "");
			ResultSet rs = stmt.executeQuery();
			CustomerDTO cust = null;
			while (rs.next()) {
				list.add(null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public CustomerDTO selectCustomer(CustomerDTO cust) {
		CustomerDTO temp = null;
		try {
			PreparedStatement ps=DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.SIGNIN.toString());
			ps.setString(1, cust.getCustomerID());
			ps.setString(2, cust.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				temp = new CustomerDTO();
				temp.setAddress(rs.getString("ADDRESS"));
				temp.setCity(rs.getString("CITY"));
				temp.setCustomerID(rs.getString("CUSTOMER_ID"));
				temp.setCustomerName(rs.getString("CUSTOMER_NAME"));
				temp.setPassword(rs.getString("PASSWORD"));
				temp.setPostalCode(rs.getString("POSTALCODE"));
				temp.setSsn(rs.getString("SSN"));

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int countCustomers(Proxy pxy) {
		int count = 0;
		try {
			String sql = CustomerSQL.ROW_COUNT.toString();
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean existsCustomerID(CustomerDTO cust) {
		boolean b = false;
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public void updateCustomer(CustomerDTO cust) {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCustomer(CustomerDTO cust) {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
