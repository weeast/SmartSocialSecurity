package actuarical.dao;

import actuarical.model.InternalData;

public interface InternalDataDaoImp {
	//内部数据查询
	public InternalData queryInternalData(String agentId) ;
	//内部数据录入
	public boolean saveInternalData(InternalData internalData) ;
	//内部数据修改(管理员修改)
	public boolean modifyInternalData(String adminId,InternalData internalData) ;
}
