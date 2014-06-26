package actuarical.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConnection {
	private String db2Driver = "com.ibm.db2.jcc.DB2Driver" ;
	private String url = "jdbc:db2://202.115.7.252:448/TSTDB202" ;
	private String userName = "CU004" ;
	private String password = "321" ;
	private ResultSet rs = null ;
	private Statement stmt = null ;
	private Connection con = null ;
	
	public JDBConnection(){
		try {
			Class.forName(db2Driver).newInstance() ;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean creatConnection() {
		try {
			con = DriverManager.getConnection(url, userName, password);
			con.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	public boolean executeUpdate(String sql) {
		if (null == con) {
			creatConnection();
		}
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public ResultSet executeQuery(String sql) {
		try {
			if (null == con) {
				creatConnection();
			}
			stmt = con.createStatement();
			try {
				rs = stmt.executeQuery(sql);
				return rs;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}	
	}

	public void closeConnection() {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != stmt) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != con) {
			try {
				con.close();
			} catch (SQLException e) {
			} finally {
				con = null;
			}
		}
	}
}
