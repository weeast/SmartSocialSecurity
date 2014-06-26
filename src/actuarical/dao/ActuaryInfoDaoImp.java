package actuarical.dao;

import java.util.List;

import actuarical.model.ActuaryResult;

public interface ActuaryInfoDaoImp {
	//得出精算结果
	public List<ActuaryResult> actuary(List<String> modelNameList,String year,String adminId) ;
	//精算历史记录查询
	public List<String> queryHistoryRecord(String adminId) ;
}
