package actuarical.dao;

import java.util.List;

import actuarical.model.ActuaryResult;
import actuarical.model.ModelInfo;

public interface ModelInfoDaoImp {
	//分类查询模型（返回某模型的所有）
	public List<ModelInfo> categoryQueryModel(String modelCategory) ;
	//查询模型
	public ModelInfo queryModelInfo(String modelId) ;
	//添加模型
	public boolean saveModelInfo(ModelInfo modelInfo) ;
	//模型对比
	public List<List<ActuaryResult>> comparisonModelInfo(List<String> modelNameList1,List<String> modelNameList2,int year) ;
	//根据模型名查询公式
	public String queryFormula(String modelName) ;
	//根据模型名查询模型ID
	public String queryModelId(String modelName) ;
}
