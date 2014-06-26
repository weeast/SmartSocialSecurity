package actuarical.dao;

import java.math.BigDecimal;
import java.lang.Math; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import actuarial.calculator.ActuaryCalculator;
import actuarical.model.ActuaryResult;
import actuarical.model.ModelInfo;
import actuarical.tools.JDBConnection;

public class ModelInfoDao implements ModelInfoDaoImp {

	private String sql  = "" ;
	JDBConnection con = null ;
	private ModelInfoDao modelInfoDao = null ;
	private ActuaryResult actuaryResult = null ;
	private ActuaryCalculator actuaryCalculator = null ;
	private List<ActuaryResult> actuaryResultList = null ;
	//查询某一类模型
	@Override
	public List<ModelInfo> categoryQueryModel(String modelCategory) {
		con = new JDBConnection() ;
		List<ModelInfo> list = new ArrayList<ModelInfo>() ;
		sql = "select MNAME from CU045.SSSMODEL where MCLASS='"+modelCategory+"'" ;
		ResultSet rs = con.executeQuery(sql) ;
		try {
			while(rs.next()){
				list.add(queryModelInfo(queryModelId(rs.getString(1)))) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.closeConnection() ;
		}
		return list;
	}
	//查询单个模型
	@Override
	public ModelInfo queryModelInfo(String modelId) {
		ModelInfo modelInfo = new ModelInfo() ; ;
		con = new JDBConnection() ;
		sql="select * from CU045.SSSMODEL where MID='"+modelId+"'" ;
		ResultSet rs = con.executeQuery(sql) ;
		try {
			while(rs.next()){
				modelInfo.setModelName(rs.getString(2)) ;
				modelInfo.setModelCategory(rs.getString(3)) ;
				modelInfo.setModelFormula(rs.getString(4)) ;
				modelInfo.setModelInput(rs.getString(5)) ;
				modelInfo.setModelOutput(rs.getString(6)) ;
				modelInfo.setModelExplain(rs.getString(7)) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.closeConnection() ;
		}
		return modelInfo;
	}
	//添加模型
	@Override
	public boolean saveModelInfo(ModelInfo modelInfo) {
		boolean temp = false ;
		con = new JDBConnection() ;
		sql = "select MID from CU045.SSSMODEL " ;
		ResultSet rs = con.executeQuery(sql) ;
		String mId = "0" ;
		try {
			while(rs.next()){
				if(Integer.parseInt(mId)<=Integer.parseInt(rs.getString(1))){
					mId = rs.getString(1) ;
				}
			}
			int mIdTemp = Integer.parseInt(mId) ;
			mIdTemp++ ;
			sql = "insert into CU045.SSSMODEL values('"+mIdTemp+"','"+
					modelInfo.getModelName()+"','"+modelInfo.getModelCategory()+"','"+
					modelInfo.getModelFormula()+"','"+modelInfo.getModelInput()+"','"+
					modelInfo.getModelOutput()+"','"+modelInfo.getModelExplain()+"')" ;
			temp = con.executeUpdate(sql) ;
		} catch (SQLException e) {
			sql = "insert into CU045.SSSMODEL values('"+0+"','"+
					modelInfo.getModelName()+"','"+modelInfo.getModelCategory()+"','"+
					modelInfo.getModelFormula()+"','"+modelInfo.getModelInput()+"','"+
					modelInfo.getModelOutput()+"','"+modelInfo.getModelExplain()+"')" ;
			temp = con.executeUpdate(sql) ;
			e.printStackTrace();
		}finally{
			con.closeConnection() ;
		}
		return temp;
	}
	//模型对比
	@Override
	public List<List<ActuaryResult>> comparisonModelInfo(List<String> modelIdList1,
			List<String> modelIdList2,int year) {
		con = new JDBConnection() ;
		List<List<ActuaryResult>> list = new ArrayList<List<ActuaryResult>>() ;
		list.add(actuarySingle(modelIdList1,year)) ;
		list.add(actuarySingle(modelIdList2,year)) ;
		return list;
	}
	//得出(每一年)精算结果
	public List<ActuaryResult> actuarySingle(List<String> modelIdList,int year) {
		actuaryResultList = new ArrayList<ActuaryResult>() ;
		ActuaryDataDao actuaryDataDao = new ActuaryDataDao() ;
		
		modelInfoDao = new ModelInfoDao() ;
		con = new JDBConnection() ;
		double result0 = 0;
		double result1 = 0;
		double result2 = 0;
		double result3 = 0;
		double result4 = 0;
		double result5 = 0;
		double result6 = 0;
		double result7 = 0;
		double result8 = 0;
		double result9 = 0;
		double result10 = 0;
		double result11 = 0;
		List<Double> listTemp = new ArrayList<Double>() ;
		for(int i=2011;i<=year;i++){
			try {
				ActuaryResult actuaryResult = new ActuaryResult() ;
				
				result0 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(0)),i,actuaryDataDao) ;
				actuaryDataDao.setLastEndcountryPopulation(result0) ;
				actuaryResult.setLastEndcountryPopulation(result0) ;
				
				result1 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(1)),i,actuaryDataDao) ;
				actuaryResult.setLastEndTownPopulation(result1) ;
				actuaryDataDao.setLastEndTownPopulation(result1) ;
				
				result2 = translateFormulaDouble(modelInfoDao.queryFormula(modelIdList.get(2)),i,actuaryDataDao,0) ;
				actuaryResult.setCurrentEndInsuredPopulation(result2) ;
				actuaryDataDao.setCurrentEndInsuredPopulation(result2) ;
				
				result3 = translateFormulaDouble(modelInfoDao.queryFormula(modelIdList.get(2)),i,actuaryDataDao,1) ;
				actuaryResult.setFreeworkPopulation(result3) ;
				actuaryDataDao.setFreeworkPopulation(result3) ;
				
				result4 = Math.abs(translateFormula(modelInfoDao.queryFormula(modelIdList.get(3)),i,actuaryDataDao)) ;
				actuaryResult.setPersonalAccountFundTotalIncome(result4) ;
				actuaryDataDao.setPersonalAccountFundTotalIncome(result4) ;
				
				result5 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(4)),i,actuaryDataDao) ;
				actuaryResult.setFundTotalIncome(result5) ;
				actuaryDataDao.setFundTotalIncome(result5) ;
				
				result6 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(5)),i,actuaryDataDao) ;
				actuaryResult.setPersonalAccountFundTotalPay(result6) ;
				actuaryDataDao.setPersonalAccountFundTotalPay(result6) ;
				
				result7 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(6)),i,actuaryDataDao) + 10000000 ;
				actuaryResult.setPersonalEmptyPay(result7) ;
				actuaryDataDao.setPersonalEmptyPay(result7) ;
				
				result8 = Math.abs(translateFormula(modelInfoDao.queryFormula(modelIdList.get(7)),i,actuaryDataDao)) ;
				actuaryResult.setFoundationAnnuityPay(result8) ;
				actuaryDataDao.setFoundationAnnuityPay(result8) ;
				
				result9 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(8)),i,actuaryDataDao) ;
				actuaryResult.setExcessiveAnnuityPay(result9) ;
				actuaryDataDao.setExcessiveAnnuityPay(result9) ;
				
				result10 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(9)),i,actuaryDataDao) ;
				actuaryResult.setPersonalAccountLongevityPay(result10) ;
				actuaryDataDao.setPersonalAccountLongevityPay(result10) ;
				
				result11 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(10)),i,actuaryDataDao) ;
				actuaryResult.setAnnuityTotalPay(result11) ;
				actuaryDataDao.setAnnuityTotalPay(result11) ;
				
				
				
				actuaryResultList.add(actuaryResult) ;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				con.closeConnection() ;
			}
			
			//各模型输出结果
			/*
			actuaryResult.setLastEndcountryPopulation(result0) ;
			actuaryResult.setLastEndTownPopulation(result1) ;
			actuaryResult.setCurrentEndInsuredPopulation(result2) ;
			actuaryResult.setFreeworkPopulation(result3) ;
			actuaryResult.setPersonalAccountFundTotalIncome(result4) ;
			actuaryResult.setFundTotalIncome(result5) ;
			actuaryResult.setPersonalAccountFundTotalPay(result6) ;
			actuaryResult.setPersonalEmptyPay(result7) ;
			actuaryResult.setFoundationAnnuityPay(result8) ;
			actuaryResult.setExcessiveAnnuityPay(result9) ;
			actuaryResult.setPersonalAccountLongevityPay(result10) ;
			actuaryResult.setAnnuityTotalPay(result11) ;
			*/
			
			//System.out.println("哈哈：" + actuaryResultList.size() + actuaryResult.getCurrentEndInsuredPopulation()) ;
			
		}
		return actuaryResultList ;
	}
	
	//翻译字符串(字母型)公式
	public double translateFormula(String formula,int year,ActuaryDataDao actuaryDataDao)throws Exception{
		actuaryCalculator = new ActuaryCalculator() ;
		char[] charAll = formula.toCharArray() ;
		List<Character> listAll = new ArrayList<Character>() ;         //存储所有数据
		for(int j=0;j<charAll.length;j++){
			listAll.add(charAll[j]) ;                                     //存储所有数据到listAll中           char[]类型转为ArrayList类型
		}
		int temp = 0 ;
		List<Character> listNew = new ArrayList<Character>() ;
		char charTemp  ;
		double d = 0 ;
		for(int i=0;i<listAll.size();i++){
			if(listAll.get(i)=='('||listAll.get(i)==')'||listAll.get(i)=='+'||listAll.get(i)=='-'
					||listAll.get(i)=='*'||listAll.get(i)=='/'){
				charTemp = listAll.get(i) ;
				String singleParameter = listToString(listAll.subList(0, i)) ;
				listAll = listAll.subList(i+1, listAll.size()) ;
				d = actuaryDataDao.actuaryData(singleParameter,year) ;
				
				
				//listAll.addAll(temp, changeString(new BigDecimal(d).toPlainString())) ;
				listNew.addAll(listNew.size(), changeString(new BigDecimal(d).toPlainString())) ;
				
				listNew.add(listNew.size(), charTemp) ;
				i=0 ;
			}
		}	
		listNew.addAll(listNew.size(), changeString(new BigDecimal(d).toPlainString())) ;
		double result = actuaryCalculator.calculator(listToString(listNew)) ;
		return result ;
	}
	//List<Character>转为String
	public String listToString(List<Character> list){
		String result = "" ;
		for(int i=0;i<list.size();i++){
			result = result+list.get(i) ;
		}
		return result;
		
	}
	public double translateFormulaDouble(String formula,int year,ActuaryDataDao actuaryDataDao,int para)throws Exception{
		actuaryCalculator = new ActuaryCalculator() ;
		char[] charAll = formula.toCharArray() ;
		List<Character> listAll = new ArrayList<Character>() ;         //存储所有数据
		for(int i=0;i<charAll.length;i++){
			listAll.add(charAll[i]) ;                                     //存储所有数据到listAll中           char[]类型转为ArrayList类型
		}
		int temp = 0 ;
		if(para==0){
			for(int i=0;i<listAll.size();i++){
				if(listAll.get(i)=='>'){
					listAll = listAll.subList(0, i) ;
				}
			}
		}else{
			for(int i=0;i<listAll.size();i++){
				if(listAll.get(i)=='>'){
					listAll = listAll.subList(i+1, listAll.size()) ;
				}
			}
		}
		
		List<Character> listNew = new ArrayList<Character>() ;
		char charTemp  ;
		double d = 0 ;
		
		for(int i=0;i<listAll.size();i++){
			if(listAll.get(i)=='('||listAll.get(i)==')'||listAll.get(i)=='+'||listAll.get(i)=='-'
					||listAll.get(i)=='*'||listAll.get(i)=='/'){
				/*
				String singleParameter = listAll.subList(temp, i).toString() ;
				double d = actuaryDataDao.actuaryData(singleParameter,year) ;
				listAll.addAll(temp, changeString(String.valueOf(d))) ;
				temp=i ;
				*/
				
				charTemp = listAll.get(i) ;
				String singleParameter = listToString(listAll.subList(0, i)) ;
				listAll = listAll.subList(i+1, listAll.size()) ;
				d = actuaryDataDao.actuaryData(singleParameter,year) ;
				
				
				listNew.addAll(listNew.size(), changeString(new BigDecimal(d).toPlainString())) ;
				
				listNew.add(listNew.size(), charTemp) ;
				i=0 ;
			}
		}	
		listNew.addAll(listNew.size(), changeString(new BigDecimal(d).toPlainString())) ;
		double result = actuaryCalculator.calculator(listToString(listNew)) ;
		return result ;
	}
	//String类型转为List
	public  List<Character> changeString(String str){
		List<Character> listTem = new ArrayList<Character>() ;
		char[] cha = str.toCharArray() ;
		for(int i=0;i<cha.length;i++){
			listTem.add(cha[i]) ;
		}
		return listTem ;
	}

	@Override
	public String queryFormula(String modelId) {
		// TODO Auto-generated method stub
		String formula = "" ;
		con = new JDBConnection() ;
		sql = "select MEXPR from CU045.SSSMODEL where MID='" + modelId + "'" ;
		ResultSet rs = con.executeQuery(sql) ;
		try {
			while(rs.next()){
				formula = rs.getString(1) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.closeConnection() ;
		}
		return formula ;
	}
	//查询模型id
	@Override
	public String queryModelId(String modelName) {
		// TODO Auto-generated method stub
		String modelId = "" ;
		con = new JDBConnection() ;
		sql = "select MID from CU045.SSSMODEL where MNAME='" + modelName + "'" ;
		ResultSet rs = con.executeQuery(sql) ;
		try {
			while(rs.next()){
				modelId = rs.getString(1) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.closeConnection() ;
		}
		return modelId;
	}
	//查询模型名字
	public String queryModelName(String modelId) {
		// TODO Auto-generated method stub
		String modelName = "" ;
		con = new JDBConnection() ;
		sql = "select MNAME from CU045.SSSMODEL where MID='" + modelId + "'" ;
		ResultSet rs = con.executeQuery(sql) ;
		try {
			while(rs.next()){
				modelName = rs.getString(1) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.closeConnection() ;
		}
		return modelName;
	}

}
