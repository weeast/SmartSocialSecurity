package actuarical.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import actuarical.model.ModifyInternalData;
import actuarical.tools.JDBConnection;

public class ModifyInternalDataDao implements ModifyInternalDataDaoImp {
	private JDBConnection con = null ;
	private String sql = "" ;
	@Override
	public ModifyInternalData queryModifyInternalData(String adminId) {
		con = new JDBConnection() ;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		ModifyInternalData modifyInternalData = new ModifyInternalData() ;
		sql = "select * from CU045.SSSMHIS where MAID ='"+adminId+"'" ;
		ResultSet rs = con.executeQuery(sql) ;
		try {
			while(rs.next()){
				modifyInternalData.setInternalDataId(rs.getString(2)) ;
				modifyInternalData.setModifyDifValue(rs.getString(3)) ;
				try {
					modifyInternalData.setModifyDate(df.parse(rs.getString(4))) ;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				modifyInternalData.setAdminId(rs.getString(5)) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modifyInternalData;
	}

	
}
