package enums;
/*
				   employeeID,
				   manager,
				   name,
				   birthDate,
				   photo,
				   notes;
 * */
public enum CustomerSQL {
	SIGNUP, SIGNIN , LIST, ROW_COUNT;
	
	@Override
	public String toString() {
		StringBuffer query= new StringBuffer();
		switch (this) {
		case SIGNUP:
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID,"
					+ "CUSTOMER_NAME,"
					+ "PASSWORD,"
					+ "SSN,"
					+ "PHONE,"
					+ "CODE,"
					+ "CITY,"
					+ "ADDRESS)\n" + 
					"VALUES (?,?,?,?,?,?,?)");
			break;
		case SIGNIN:
			query.append("SELECT CUSTOMER_ID,PASSWORD \n"
					+ "FROM CUSTOMERS \n"
					+ "WHERE CUSTOMER_ID LIKE ? AND  PASSWORD LIKE ?");
			break;
		case LIST:
			query.append("SELECT T2.*\n" + 
					"FROM\n" + 
					"(SELECT ROWNUM NO1,T.*\n" + 
					"    FROM\n" + 
					"    (SELECT ROWNUM \"NO\",C.*\n" + 
					"    FROM CUSTOMERS C\n" + 
					"    ORDER BY NO DESC) T)T2\n" + 
					"WHERE NO1 BETWEEN ? AND ?\n");
			break;
		case ROW_COUNT:
			query.append("SELECT COUNT(*) AS COUNT FROM CUSTOMERS");
			break;
		default:
			break;
		}
		return query.toString();
	}
	
}
