package actuarical.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import actuarical.model.AdminInfo;
import actuarical.tools.JDBConnection;

public class AdminInfoDao implements AdminInfoDaoImp {
	
	JDBConnection con = null ;
	private String sql = "" ;
	@Override
	//修改下属信息
	public boolean updateAdminInfo(String adminId, AdminInfo adminInfo) {
		con = new JDBConnection() ;
		boolean temp = false ;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			sql = "update CU045.SSSADMIN set AWID='"+adminInfo.getAdminId()+"',APWD='"+
					adminInfo.getAdminPassword()+"',ARNAME='"+adminInfo.getAdminName()+"',ASEX='"+
					adminInfo.getAdminSex()+"',AWUNIT='"+adminInfo.getAdminDepartment()+"',AWPOS='"+
					adminInfo.getAdminPosition()+"',AADD='"+adminInfo.getAdminAddress()+"',AIDCARD='"+adminInfo.getAdminIC()+"',ATEL='"+
					adminInfo.getAdminCellPhone()+"',ABIRTH='"+df.parse(adminInfo.getAdminBirthday())+"',APID='"+
					adminInfo.getAdminImage()+"',APERM='"+adminInfo.getAdminLimit()+"',AFREFUN='"+adminInfo.getAdminCommonFunction()+"',APRECODE='"+
					adminInfo.getAdminFatherSong()+"'  where AWID='"+adminId+"'" ;
			temp = con.executeUpdate(sql) ;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	//查询管理员信息
	@Override
	public AdminInfo queryAdminInfo(String adminId) {
		con = new JDBConnection() ;
		AdminInfo adminInfo = new AdminInfo() ;
		sql = "select * from CU045.SSSADMIN where AWID='"+adminId+"'" ;
		ResultSet rs = con.executeQuery(sql) ;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			while(rs.next()){
				adminInfo.setAdminId(rs.getString(2)) ;
				adminInfo.setAdminPassword(rs.getString(3)) ;
				adminInfo.setAdminName(rs.getString(4)) ;
				adminInfo.setAdminSex(rs.getString(5)) ;
				adminInfo.setAdminDepartment(rs.getString(6)) ;
				adminInfo.setAdminPosition(rs.getString(7)) ;
				adminInfo.setAdminAddress(rs.getString(8)) ;
				adminInfo.setAdminIC(rs.getString(9)) ;
				adminInfo.setAdminCellPhone(rs.getString(10)) ;
				adminInfo.setAdminBirthday(df.format(rs.getDate(11))) ;
				adminInfo.setAdminImage(rs.getString(12)) ;
				adminInfo.setAdminLimit(rs.getString(13)) ;
				adminInfo.setAdminCommonFunction(rs.getString(14)) ;
				adminInfo.setAdminFatherSong(rs.getString(15)) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.closeConnection() ;
		}
		return adminInfo;
	}
	//添加下属
	@Override
	public boolean saveAdminInfo(AdminInfo adminInfo) {
		con = new JDBConnection() ;
		boolean temp = false ;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String sqlTemp = "select AID from CU045.SSSADMIN" ;
		ResultSet rs = con.executeQuery(sqlTemp) ;
		String aId = "" ;
		try {
			while(rs.next()){
				aId = rs.getString(1);
			}
			int aIdTemp = Integer.parseInt(aId) ;
			aIdTemp++ ;
			sql = "insert into CU045.SSSADMIN values('"+ aIdTemp +"','"+
					adminInfo.getAdminId()+"','"+adminInfo.getAdminPassword()+"','"+
					adminInfo.getAdminName()+"','"+adminInfo.getAdminSex()+"','"+
					adminInfo.getAdminDepartment()+"','"+adminInfo.getAdminPosition()+"','"+
					adminInfo.getAdminIC()+"','"+adminInfo.getAdminCellPhone()+"','"+
					df.parse(adminInfo.getAdminBirthday())+"','"+adminInfo.getAdminImage()+"','"+
					adminInfo.getAdminLimit()+"','"+adminInfo.getAdminCommonFunction()+"','"+
					adminInfo.getAdminFatherSong()+"')" ;
			temp = con.executeUpdate(sql) ;
		} catch (Exception e) {
			try {
				sql = "insert into CU045.SSSADMIN values('"+ 0 +"','"+
						adminInfo.getAdminId()+"','"+adminInfo.getAdminPassword()+"','"+
						adminInfo.getAdminName()+"','"+adminInfo.getAdminSex()+"','"+
						adminInfo.getAdminDepartment()+"','"+adminInfo.getAdminPosition()+"','"+
						adminInfo.getAdminIC()+"','"+adminInfo.getAdminCellPhone()+"','"+
						df.parse(adminInfo.getAdminBirthday())+"','"+adminInfo.getAdminImage()+"','"+
						adminInfo.getAdminLimit()+"','"+adminInfo.getAdminCommonFunction()+"','"+
						adminInfo.getAdminFatherSong()+"')" ;
				temp = con.executeUpdate(sql) ;
 			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			con.closeConnection() ;
		}
		
		return temp;
	}
	//删除下属账号
	@Override
	public boolean delAdminInfo(String adminId) {
		con = new JDBConnection() ;
		boolean temp = false ;
		sql = "delete from CU045.SSSADMIN where AWID = '"+adminId+"'" ;
		temp = con.executeUpdate(sql) ;
		con.closeConnection() ;
		return temp;
	}
	//修改密码
	@Override
	public boolean modifyPassword(String adminId, String oldPassword,
			String newPassword) {
		con = new JDBConnection() ;
		boolean temp = false ;
		sql = "update CU045.SSSADMIN set APWD='"+ newPassword + "'where AWID='"+ adminId +"'" ;
		temp = con.executeUpdate(sql) ;
		con.closeConnection() ;
		return temp;
	}
	//登陆
	@Override
	public boolean login(String adminId, String password) {
		con = new JDBConnection() ;
		boolean temp = false ;
		sql = "select APWD from CU045.SSSADMIN where AWID='"+ adminId +"'" ;
		ResultSet rs = con.executeQuery(sql);
		String passwordTemp = "" ;
		try {
			while(rs.next()){
				passwordTemp = rs.getString(1) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.closeConnection() ;
		}
		System.out.println(passwordTemp + password + "ok") ;
		if(passwordTemp.equals(password)){
			temp = true ;
		}
		return temp ;
	}
	//查询下属权限
	@Override
	public String queryLimit(String adminId) {
		con = new JDBConnection() ;
		String limit = "" ;
		sql = "select APERM from CU045.SSSADMIN where AWID='"+adminId+"'" ;
		ResultSet rs = con.executeQuery(sql) ;
		try {
			while(rs.next()){
				limit = rs.getString(1) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.closeConnection() ;
		}
		return limit;
	}
	//修改下属权限
	@Override
	public boolean modifyLimit(String adminId, String limit) {
		con = new JDBConnection() ;
		boolean temp = false ;
		sql = "update CU045.SSSADMIN set APERM='"+limit+"'where AWID='"+adminId+"'" ;
		temp = con.executeUpdate(sql) ;
		con.closeConnection() ;
		return temp;
	}
	//查询所有下属
	@Override
	public List<AdminInfo> queryTotalAdminInfo(String adminId) {
		con = new JDBConnection() ;
		List<AdminInfo> list = new ArrayList<AdminInfo>() ;
		String sqlTemp = "select APRECODE from CU045.SSSADMIN where AWID='"+adminId+"'" ;
		ResultSet rsTemp = con.executeQuery(sqlTemp) ;
		String fatherSongTemp = "" ;
		try {
			while(rsTemp.next()){
				fatherSongTemp = rsTemp.getString(1) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "select AWID from CU045.SSSADMIN where APRECODE like '"+fatherSongTemp+"%'" ;
		ResultSet rs = con.executeQuery(sql) ;
		try {
			while(rs.next()){
				list.add(queryAdminInfo(rs.getString(1))) ;
				System.out.println(rs.getString(1)) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.closeConnection() ;
		}
		return list;
	}

	

}
