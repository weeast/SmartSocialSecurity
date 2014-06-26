package actuarical.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import actuarial.calculator.ActuaryCalculator;
import actuarical.model.ActuaryResult;
import actuarical.tools.JDBConnection;

public class ActuaryInfoDao implements ActuaryInfoDaoImp{
	
	private ModelInfoDao modelInfoDao = null ;
	private ActuaryDataDao actuaryDataDao = null ;
	private ActuaryCalculator actuaryCalculator = null ;
	private List<ActuaryResult> actuaryResultList = null ;
	JDBConnection con = null ;
	private String sql = "" ;
	//得出精算结果
	@Override
	public List<ActuaryResult> actuary(List<String> modelIdList,String year,String adminId) {
		int yearTemp =2011 ;
		modelInfoDao = new ModelInfoDao() ;
		actuaryDataDao = new ActuaryDataDao() ;
		actuaryResultList = new ArrayList<ActuaryResult>() ;
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
		
		//批次
		String lot = modelIdList.get(0) + modelIdList.get(1) + modelIdList.get(2) + 
					 modelIdList.get(3) + modelIdList.get(4) + modelIdList.get(5) + 
					 modelIdList.get(6) + modelIdList.get(7) + modelIdList.get(8) + 
					 modelIdList.get(9) + modelIdList.get(10) ;
		//日期
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");     
		String date = sDateFormat.format(new java.util.Date());
		
		for(int i=yearTemp;i<=Integer.parseInt(year);i++){
			try {
				
				/*
				result0 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(0)),i) ;
				actuaryDataDao.setLastEndcountryPopulation(result0) ;
				actuaryResult.setLastEndcountryPopulation(result0) ;
				
				result1 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(1)),i) ;
				actuaryResult.setLastEndTownPopulation(result1) ;
				actuaryDataDao.setLastEndTownPopulation(result1) ;
				
				result2 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(2)),i) ;
				result3 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(3)),i) ;
				result4 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(4)),i) ;
				result5 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(5)),i) ;
				result6 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(6)),i) ;
				result7 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(7)),i) ;
				result8 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(8)),i) ;
				result9 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(9)),i) ;
				result10 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(10)),i) ;
				result11 = translateFormula(modelInfoDao.queryFormula(modelIdList.get(11)),i) ;
				*/
				
				ActuaryResult actuaryResult = new ActuaryResult() ;
				
				result0 = modelInfoDao.translateFormula(modelInfoDao.queryFormula(modelIdList.get(0)),i,actuaryDataDao) ;
				actuaryDataDao.setLastEndcountryPopulation(result0) ;
				actuaryResult.setLastEndcountryPopulation(result0) ;
				
				result1 = modelInfoDao.translateFormula(modelInfoDao.queryFormula(modelIdList.get(1)),i,actuaryDataDao) ;
				actuaryResult.setLastEndTownPopulation(result1) ;
				actuaryDataDao.setLastEndTownPopulation(result1) ;
				
				result2 = modelInfoDao.translateFormulaDouble(modelInfoDao.queryFormula(modelIdList.get(2)),i,actuaryDataDao,0) ;
				actuaryResult.setCurrentEndInsuredPopulation(result2) ;
				actuaryDataDao.setCurrentEndInsuredPopulation(result2) ;
				
				result3 = modelInfoDao.translateFormulaDouble(modelInfoDao.queryFormula(modelIdList.get(2)),i,actuaryDataDao,1) ;
				actuaryResult.setFreeworkPopulation(result3) ;
				actuaryDataDao.setFreeworkPopulation(result3) ;
				
				result4 = Math.abs(modelInfoDao.translateFormula(modelInfoDao.queryFormula(modelIdList.get(3)),i,actuaryDataDao)) ;
				actuaryResult.setPersonalAccountFundTotalIncome(result4) ;
				actuaryDataDao.setPersonalAccountFundTotalIncome(result4) ;
				
				result5 = modelInfoDao.translateFormula(modelInfoDao.queryFormula(modelIdList.get(4)),i,actuaryDataDao) ;
				actuaryResult.setFundTotalIncome(result5) ;
				actuaryDataDao.setFundTotalIncome(result5) ;
				
				result6 = modelInfoDao.translateFormula(modelInfoDao.queryFormula(modelIdList.get(5)),i,actuaryDataDao) ;
				actuaryResult.setPersonalAccountFundTotalPay(result6) ;
				actuaryDataDao.setPersonalAccountFundTotalPay(result6) ;
				
				result7 = modelInfoDao.translateFormula(modelInfoDao.queryFormula(modelIdList.get(6)),i,actuaryDataDao) + 10000000 ;
				actuaryResult.setPersonalEmptyPay(result7) ;
				actuaryDataDao.setPersonalEmptyPay(result7) ;
				
				result8 = Math.abs(modelInfoDao.translateFormula(modelInfoDao.queryFormula(modelIdList.get(7)),i,actuaryDataDao)) ;
				actuaryResult.setFoundationAnnuityPay(result8) ;
				actuaryDataDao.setFoundationAnnuityPay(result8) ;
				
				result9 = modelInfoDao.translateFormula(modelInfoDao.queryFormula(modelIdList.get(8)),i,actuaryDataDao) ;
				actuaryResult.setExcessiveAnnuityPay(result9) ;
				actuaryDataDao.setExcessiveAnnuityPay(result9) ;
				
				result10 = modelInfoDao.translateFormula(modelInfoDao.queryFormula(modelIdList.get(9)),i,actuaryDataDao) ;
				actuaryResult.setPersonalAccountLongevityPay(result10) ;
				actuaryDataDao.setPersonalAccountLongevityPay(result10) ;
				
				result11 = modelInfoDao.translateFormula(modelInfoDao.queryFormula(modelIdList.get(10)),i,actuaryDataDao) ;
				actuaryResult.setAnnuityTotalPay(result11) ;
				actuaryDataDao.setAnnuityTotalPay(result11) ;
				
				
				
				actuaryResultList.add(actuaryResult) ;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			sql = "insert into CU045.SSSACTU values('"+0+"','" +lot+ "','" +i+ "','" +modelIdList.get(0)+ "','" +new BigDecimal(result0).toPlainString()+ "','" +date+ "','"  +adminId+ "')" ;
	 		con.executeUpdate(sql) ;
	 		sql = "insert into CU045.SSSACTU values('"+1+"','" +lot+ "','" +i+ "','" +modelIdList.get(1)+ "','" +new BigDecimal(result1).toPlainString()+ "','" +date+  "','"  +adminId+ "')" ;
	 		con.executeUpdate(sql) ;
	 		sql = "insert into CU045.SSSACTU values('"+2+"','" +lot+ "','" +i+ "','" +modelIdList.get(2)+ "','" +new BigDecimal(result2).toPlainString()+ "','" +date+  "','"  +adminId+ "')" ;
	 		con.executeUpdate(sql) ;
	 		sql = "insert into CU045.SSSACTU values('"+2+"','" +lot+ "','" +i+ "','" +modelIdList.get(2)+ "','" +new BigDecimal(result3).toPlainString()+ "','" +date+  "','"  +adminId+ "')" ;
	 		con.executeUpdate(sql) ;
	 		sql = "insert into CU045.SSSACTU values('"+3+"','" +lot+ "','" +i+ "','" +modelIdList.get(3)+ "','" +new BigDecimal(result4).toPlainString()+ "','" +date+  "','"  +adminId+ "')" ;
	 		con.executeUpdate(sql) ;
	 		sql = "insert into CU045.SSSACTU values('"+4+"','" +lot+ "','" +i+ "','" +modelIdList.get(4)+ "','" +new BigDecimal(result5).toPlainString()+ "','" +date+ "','" +adminId+ "')" ;
	 		con.executeUpdate(sql) ;
	 		sql = "insert into CU045.SSSACTU values('"+5+"','" +lot+ "','" +i+ "','" +modelIdList.get(5)+ "','" +new BigDecimal(result6).toPlainString()+ "','" +date+ "','" +adminId+ "')" ;
	 		con.executeUpdate(sql) ;
	 		sql = "insert into CU045.SSSACTU values('"+6+"','" +lot+ "','" +i+ "','" +modelIdList.get(6)+ "','" +new BigDecimal(result7).toPlainString()+ "','" +date+ "','" +adminId+ "')" ;
	 		con.executeUpdate(sql) ;
	 		sql = "insert into CU045.SSSACTU values('"+7+"','" +lot+ "','" +i+ "','" +modelIdList.get(7)+ "','" +new BigDecimal(result8).toPlainString()+ "','" +date+ "','" +adminId+ "')" ;
	 		con.executeUpdate(sql) ;
	 		sql = "insert into CU045.SSSACTU values('"+8+"','" +lot+ "','" +i+ "','" +modelIdList.get(8)+ "','" +new BigDecimal(result9).toPlainString()+ "','" +date+ "','" +adminId+ "')" ;
	 		con.executeUpdate(sql) ;
	 		sql = "insert into CU045.SSSACTU values('"+9+"','" +lot+ "','" +i+ "','" +modelIdList.get(9)+ "','" +new BigDecimal(result10).toPlainString()+ "','" +date+ "','" +adminId+ "')" ;
	 		con.executeUpdate(sql) ;
	 		sql = "insert into CU045.SSSACTU values('"+10+"','" +lot+ "','" +i+ "','" +modelIdList.get(10)+ "','" +new BigDecimal(result11).toPlainString()+ "','" +date+ "','" +adminId+ "')" ;
	 		con.executeUpdate(sql) ;
		}
		
		
 		
 		con.closeConnection() ;
		return actuaryResultList ;
	}
	//翻译字符串(字母型)公式
	public double translateFormula(String formula,int year)throws Exception{
		actuaryDataDao = new ActuaryDataDao() ;
		actuaryCalculator = new ActuaryCalculator() ;
		char[] charAll = formula.toCharArray() ;
		List<Character> listAll = new ArrayList<Character>() ;         //存储所有数据
		for(int i=0;i<charAll.length;i++){
			listAll.add(charAll[i]) ;                                     //存储所有数据到listAll中           char[]类型转为ArrayList类型
		}
		int temp = 0 ;
		for(int i=0;i<listAll.size();i++){
			if(listAll.get(i)=='('||listAll.get(i)==')'||listAll.get(i)=='+'||listAll.get(i)=='-'
					||listAll.get(i)=='*'||listAll.get(i)=='/'){
				
				String singleParameter = listAll.subList(temp, i).toString() ;
				double d = actuaryDataDao.actuaryData(singleParameter,year) ;
				listAll.addAll(temp, changeString(String.valueOf(d))) ;
				temp=i ;
			}
		}	
		double result = actuaryCalculator.calculator(listAll.toString()) ;
		return result ;
	}
	//String类型转为List
	public  List<Character> changeString(String str){
		List<Character> listTem = new ArrayList<Character>() ;
		char[] cha = str.toCharArray() ;
		for(int i=0;i<cha.length;i++){
			listTem.add(cha[i]) ;
		}
		System.out.println("listTem" + listTem) ;
		return listTem ;
	}
	//精算历史记录查询
	@Override
	public List<String> queryHistoryRecord(String adminId){
		con = new JDBConnection() ;
		List<String> historyRecordList = new ArrayList<String>() ;
		sql = "select * from CU045.SSSACTUARY" ;
		ResultSet rs = con.executeQuery(sql) ;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			while(rs.next()){
				historyRecordList.add(rs.getString(1)) ;
				historyRecordList.add(rs.getString(2)) ;
				historyRecordList.add(rs.getString(3)) ;
				historyRecordList.add(rs.getString(4)) ;
				historyRecordList.add(String.valueOf(rs.getDouble(5))) ;
				historyRecordList.add(df.format(rs.getTimestamp(6))) ;
				historyRecordList.add(rs.getString(7)) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return historyRecordList ;
	}

}
