package actuarical.dao;

import java.util.List;

import actuarical.model.AdminInfo;

public interface AdminInfoDaoImp {
	//更新管理员信息
	public boolean updateAdminInfo(String adminId,AdminInfo adminInfo) ;
	//查询管理员信息
	public AdminInfo queryAdminInfo(String adminId) ;
	//查询所有下属的信息
	public List<AdminInfo> queryTotalAdminInfo(String adminId) ;
	//创建管理员(添加下属)
	public boolean saveAdminInfo(AdminInfo adminInfo) ;
	//删除管理员
	public boolean delAdminInfo(String adminId) ;
	//修改密码
	public boolean modifyPassword(String adminId,String oldPassword,String newPassword) ;
	//登陆
	public boolean login(String adminId,String password) ;
	//查询权限
	public String queryLimit(String adminId) ;
	//修改权限
	public boolean modifyLimit(String adminId,String limit) ;
}
