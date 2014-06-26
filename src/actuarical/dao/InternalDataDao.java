package actuarical.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import actuarical.model.InternalData;
import actuarical.tools.JDBConnection;

public class InternalDataDao implements InternalDataDaoImp {
	private InternalData internalData = null ;
	private JDBConnection con = null ;
	private String sql = "" ;
	//内部数据查询
	@Override
	public InternalData queryInternalData(String agentId) {
		internalData = new InternalData() ;
		con = new JDBConnection() ;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		sql = "select * from CU045.SSSIDATA where IAID='"+agentId+"'" ;
		ResultSet rs = con.executeQuery(sql) ;
		try {
			while(rs.next()){
				internalData.setUserId(rs.getString(2)) ;
				internalData.setMoney(rs.getDouble(3)) ;
				try {
					internalData.setDate(df.parse(rs.getString(4))) ;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				internalData.setAgentId(rs.getString(5)) ;
				internalData.setIncomeExpend(rs.getString(6)) ;
				internalData.setWetherModify(rs.getString(7)) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return internalData;
	}
	//添加外部数据
	@Override
	public boolean saveInternalData(InternalData internalData) {
		boolean temp = false ;
		con = new JDBConnection() ;
		String sqlTemp = "select IID from CU045.SSSIDATA" ;
		ResultSet rsTemp = con.executeQuery(sqlTemp) ;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String iId = "" ;
		try {
			while(rsTemp.next()){
				iId = rsTemp.getString(1) ;
			}
			int iIdTemp = Integer.parseInt(iId) ;
			iIdTemp++ ;
			sql = "insert into CU045.SSSIDATA values('"+iIdTemp+"','"+
					internalData.getUserId()+"','"+internalData.getMoney()+"','"+
					df.format(internalData.getDate())+"','"+internalData.getAgentId()+"','"+
					internalData.getIncomeExpend()+"','"+internalData.getWetherModify()+"')" ;
			temp = con.executeUpdate(sql) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			sql = "insert into CU045.SSSIDATA values('"+0+"','"+
					internalData.getUserId()+"','"+internalData.getMoney()+"','"+
					df.format(internalData.getDate())+"','"+internalData.getAgentId()+"','"+
					internalData.getIncomeExpend()+"','"+internalData.getWetherModify()+"')" ;
			temp = con.executeUpdate(sql) ;
			e.printStackTrace();
		}
		return temp;
	}
	//修改内部数据
	@Override
	public boolean modifyInternalData(String agentId, InternalData internalData) {
		boolean temp = false ;
		con = new JDBConnection() ;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		sql = "update CU045.SSSIDATA set IUID='"+internalData.getUserId()+"',IMONEY='"+
				internalData.getMoney()+"',IDATE='"+df.format(internalData.getDate())+"',IAID='"+
				internalData.getAgentId()+"',IIORO='"+internalData.getIncomeExpend()+"',IIFMOD='"+
				internalData.getWetherModify()+"' where IAID = '"+agentId+"'" ;
		temp = con.executeUpdate(sql) ;
		return temp;
	}
}
