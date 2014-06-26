package actuarical.dao;

import java.io.File;

import actuarical.model.ActuaryData;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ActuaryDataDao {
	
	ActuaryData actuaryData = null ;
	
	private double lastEndcountryPopulation = 0 ; //农村人口模型输出
	private double lastEndTownPopulation  = 0 ; //城镇人口模型输出
	private double currentEndInsuredPopulation = 0 ;	//缴费人口模型输出1
	private double freeworkPopulation = 0 ;	//缴费人口模型输出2
	private double personalAccountFundTotalIncome =  0;	//实帐个人账户收入输出
	private double fundTotalIncome = 0 ;	//养老金收入模型输出
	private double personalAccountFundTotalPay = 0 ;	//	实帐账户支出模型
	public double getLastEndcountryPopulation() {
		return lastEndcountryPopulation;
	}
	public void setLastEndcountryPopulation(double lastEndcountryPopulation) {
		this.lastEndcountryPopulation = lastEndcountryPopulation;
	}
	public double getLastEndTownPopulation() {
		return lastEndTownPopulation;
	}
	public void setLastEndTownPopulation(double lastEndTownPopulation) {
		this.lastEndTownPopulation = lastEndTownPopulation;
	}
	public double getCurrentEndInsuredPopulation() {
		return currentEndInsuredPopulation;
	}
	public void setCurrentEndInsuredPopulation(double currentEndInsuredPopulation) {
		this.currentEndInsuredPopulation = currentEndInsuredPopulation;
	}
	public double getFreeworkPopulation() {
		return freeworkPopulation;
	}
	public void setFreeworkPopulation(double freeworkPopulation) {
		this.freeworkPopulation = freeworkPopulation;
	}
	public double getPersonalAccountFundTotalIncome() {
		return personalAccountFundTotalIncome;
	}
	public void setPersonalAccountFundTotalIncome(
			double personalAccountFundTotalIncome) {
		this.personalAccountFundTotalIncome = personalAccountFundTotalIncome;
	}
	public double getFundTotalIncome() {
		return fundTotalIncome;
	}
	public void setFundTotalIncome(double fundTotalIncome) {
		this.fundTotalIncome = fundTotalIncome;
	}
	public double getPersonalAccountFundTotalPay() {
		return personalAccountFundTotalPay;
	}
	public void setPersonalAccountFundTotalPay(double personalAccountFundTotalPay) {
		this.personalAccountFundTotalPay = personalAccountFundTotalPay;
	}
	public double getPersonalEmptyPay() {
		return personalEmptyPay;
	}
	public void setPersonalEmptyPay(double personalEmptyPay) {
		this.personalEmptyPay = personalEmptyPay;
	}
	public double getFoundationAnnuityPay() {
		return foundationAnnuityPay;
	}
	public void setFoundationAnnuityPay(double foundationAnnuityPay) {
		this.foundationAnnuityPay = foundationAnnuityPay;
	}
	public double getExcessiveAnnuityPay() {
		return excessiveAnnuityPay;
	}
	public void setExcessiveAnnuityPay(double excessiveAnnuityPay) {
		this.excessiveAnnuityPay = excessiveAnnuityPay;
	}
	public double getPersonalAccountLongevityPay() {
		return personalAccountLongevityPay;
	}
	public void setPersonalAccountLongevityPay(double personalAccountLongevityPay) {
		this.personalAccountLongevityPay = personalAccountLongevityPay;
	}
	public double getAnnuityTotalPay() {
		return annuityTotalPay;
	}
	public void setAnnuityTotalPay(double annuityTotalPay) {
		this.annuityTotalPay = annuityTotalPay;
	}
	private double personalEmptyPay = 0 ;	//个人账户空帐支出
	private double foundationAnnuityPay = 0 ;	//基础性养老金支出
	private double excessiveAnnuityPay = 0 ;	//过度性养老金支出
	private double personalAccountLongevityPay = 0 ;	//个人账户实帐长寿支出
	private double annuityTotalPay = 0 ;	//统筹基金支出模型
	
	private double stringToInt (String str){
		double result = Double.parseDouble(str);
		return result ;
	}
	//sheetNum:哪张表（提前1）  rowNum：从哪行开始(提前一行)  cellNum：数哪一列（比字母提前一）
	public double excelResult(int sheetNum,int rowNum,int cellNum)throws Exception{
		double result = 0.00 ;
		File excelFile = new File("D:\\Book2.xls");
		Workbook workBook = Workbook.getWorkbook(excelFile);
		 // 得到工作簿所有的工作表对象
		Sheet[] sheets = workBook.getSheets();
		
		for (int i = rowNum; i < sheets[sheetNum].getRows(); i++){
			Cell[] cells = sheets[sheetNum].getRow(i);
			if(cells[cellNum].getContents()==""||cells[cellNum].getContents().equals("")){
				break ;
			}
			result = result + stringToInt(cells[cellNum].getContents()) ;
		}
		return result ;
	}
	public double doubleExcelResult(int sheetNum1,int rowNum1,int cellNum1,int sheetNum2,int rowNum2,int cellNum2)throws Exception{
		double result = 0 ;
		File excelFile = new File("D:\\Book2.xls");
		Workbook workBook = Workbook.getWorkbook(excelFile);
		 // 得到工作簿所有的工作表对象
		Sheet[] sheets = workBook.getSheets();
		
		for (int i = rowNum1; i < sheets[sheetNum1].getRows(); i++){
			Cell[] cells1 = sheets[sheetNum1].getRow(i);
			Cell[] cells2 = sheets[sheetNum2].getRow(i);
			if(cells1[cellNum1].getContents()==""||cells1[cellNum1].getContents().equals("")||cells2[cellNum2].getContents()==""||cells2[cellNum2].getContents().equals("")){
				break ;
			}
			result = result + stringToInt(cells1[cellNum1].getContents())*stringToInt(cells2[cellNum2].getContents()) ;
		}
		return result;
	}
	public double excelSingleParameter(int sheetNum,int rowNum,int cellNum)throws Exception{
		double result = 0 ;
		File excelFile = new File("D:\\Book2.xls");
		Workbook workBook = Workbook.getWorkbook(excelFile);
		 // 得到工作簿所有的工作表对象
		Sheet[] sheets = workBook.getSheets();
		Cell[] cells = sheets[sheetNum].getRow(rowNum);
		result = stringToInt(cells[cellNum].getContents()) ;
		return result ;
	}
	public static double actuaryResult(String expression){
		double result = 0 ;
		
		return result ;
	}
	/*
	public static void main(String args[])throws Exception{
		actuaryData("funeralPay") ;
	}
	*/
	public double actuaryData(String data,int year)throws Exception{
		
		
		double result = 0 ;
		
		//目前没有的参数
		if(data.equals("personalEmptyAccountPaymentRate")){
			result = 0.8 ;
		}
		if(data.equals("paySalary")){
			result = 8000000 ;
		}
		if(data.equals("coordinationFundPaymentRate")){
			result = 0.8 ;
		}
		if(data.equals("restIncome")){
			result = 80000000 ;
		}
		if(data.equals("lastAverageSalary")){
			result = 3000 ;
		}
		if(data.equals("excessiveAgeLimit")){
			result = 10 ;
		}
		if(data.equals("planMonths")){
			result = 8 ;
		}
		if(data.equals("restPay")){
			result = 8000000 ;
		}
		
		
		//农村人口模型输出
		if(data.equals("lastEndcountryPopulation")){
			result = lastEndcountryPopulation ;
		}
		//城镇人口模型输出
		if(data.equals("lastEndTownPopulation")){
			result = lastEndTownPopulation ;
		}
		//缴费人口模型输出1
		if(data.equals("currentEndInsuredPopulation")){
			result = currentEndInsuredPopulation ;
		}
		//缴费人口模型输出2
		if(data.equals("freeworkPopulation")){
			result = freeworkPopulation ;
		}
		//实帐个人账户收入输出
		if(data.equals("personalAccountFundTotalIncome")){
			result = personalAccountFundTotalIncome ;
		}
		//养老金收入模型输出
		if(data.equals("fundTotalIncome")){
			result = fundTotalIncome ;
		}
		//实帐账户支出模型
		if(data.equals("personalAccountFundTotalPay")){
			result = personalAccountFundTotalPay ;
		}
		//个人账户空帐支出
		if(data.equals("personalEmptyPay")){
			result = personalEmptyPay ;
		}
		//基础性养老金支出
		if(data.equals("foundationAnnuityPay")){
			result = foundationAnnuityPay ;
		}
		//过度性养老金支出
		if(data.equals("excessiveAnnuityPay")){
			result = excessiveAnnuityPay ;
		}
		//个人账户实帐长寿支出
		if(data.equals("personalAccountLongevityPay")){
			result = personalAccountLongevityPay ;
		}
		//统筹基金支出模型
		if(data.equals("annuityTotalPay")){
			result = annuityTotalPay ;
		}
		
		
		
		//起始年农村人口人数
		if(data.equals("currentCountryPopulation")){
			result = excelResult(24,3,1)*10000+excelResult(24, 3, 2)*10000 ;
		}
		//起始年城镇人口人数
		if(data.equals("currentTownPopulation")){
			result = excelResult(24,3,3)*10000+excelResult(24, 3, 4)*10000 ;
		}
		//农村生育率
		if(data.equals("countryFertilityRate")){
			//result = excelResult(26, 18, 1)/35 ;//2011
			//result = excelResult(26, 18, 2)/35 ;//2050
			double temp = excelResult(26, 18, 2)/35 - excelResult(26, 18, 1)/35 ;
			result = excelResult(26, 18, 1)/35 + temp*(year-2011) ;
		}
		//城镇生育率
		if(data.equals("townFertilityRate")){
			//result = excelResult(26, 18, 3)/35 ;//2011
			//result = excelResult(26, 18, 4)/35 ;//2050
			double temp = excelResult(26, 18, 4)/35 - excelResult(26, 18, 3)/35 ;
			result = excelResult(26, 18, 3)/35 + temp*(year-2011) ;
		}
		//农村死亡率
		if(data.equals("countryDieRate")){
			//result = excelResult(25,3,1)/101 + excelResult(25,3,3)/101 ;//2011
			//result = excelResult(25,3,2)/101 + excelResult(25,3,4)/101 ;//2050
			double temp = excelResult(25,3,2)/101 + excelResult(25,3,4)/101 - excelResult(25,3,1)/101 - excelResult(25,3,3)/101 ;
			result = excelResult(25,3,1)/101 + excelResult(25,3,3)/101 + temp*(year-2011) ;
		}
		//城镇死亡率
		if(data.equals("townDieRate")){
			//result = excelResult(25,3,5)/101 + excelResult(25,3,7)/101 ;//2011
			//result = excelResult(25,3,6)/101 + excelResult(25,3,8)/101 ;//2050
			double temp = excelResult(25,3,6)/101 + excelResult(25,3,8)/101-excelResult(25,3,5)/101 - excelResult(25,3,7)/101 ;
			result = excelResult(25,3,5)/101 + excelResult(25,3,7)/101 + temp*(year-2011) ;
		}
		//参保人员死亡率
		if(data.equals("insuredDieRate")){
			//result = excelResult(25,19,9)/85 + excelResult(25,19,11)/85 ;//2011
			//result = excelResult(25,19,10)/85 + excelResult(25,19,12)/85 ;//2050
			double temp = excelResult(25,19,10)/85 + excelResult(25,19,12)/85 - excelResult(25,19,9)/85 - excelResult(25,19,11)/85 ;
			result = excelResult(25,19,9)/85 + excelResult(25,19,11)/85 + temp*(year-2011) ;
		}
		//本地农村迁入城镇人口
		if(data.equals("localCountryToTown")){
			result = doubleExcelResult(24,3,1,27, 3, 1)*10000 + doubleExcelResult(24, 3, 2, 27, 3, 3)*10000 ; //2011
		}
		//外地迁入农村
		if(data.equals("outsideToCountry")){
			//result = excelResult(27, 3, 9)*10000 + excelResult(27, 3, 11)*10000 ;//2011
			//result = excelResult(27, 3, 10)*10000 + excelResult(27, 3, 12)*10000 ;//2050
			double temp = excelResult(27, 3, 10)*10000 + excelResult(27, 3, 12)*10000 - excelResult(27, 3, 9)*10000 - excelResult(27, 3, 11)*10000 ;
			result = excelResult(27, 3, 9)*10000 + excelResult(27, 3, 11)*10000 + temp*(year-2011) ;
		}
		//外地迁入城镇
		if(data.equals("outsideToTown")){
			//result = excelResult(27, 3, 13)*10000 + excelResult(27, 3, 15)*10000 ;//2011
			//result = excelResult(27, 3, 14)*10000 + excelResult(27, 3, 16)*10000 ;//2050
			double temp = excelResult(27, 3, 14)*10000 + excelResult(27, 3, 16)*10000 - excelResult(27, 3, 13)*10000 - excelResult(27, 3, 15)*10000 ;
			result = excelResult(27, 3, 13)*10000 + excelResult(27, 3, 15)*10000 + temp*(year-2011) ;
		}
		//劳动参与率
		if(data.equals("laborParticipationRate")){
			//result = excelResult(29,18,1)/51 + excelResult(29, 18, 3)/51 ; //2011
			//result = excelResult(29,18,2)/51 + excelResult(29, 18, 4)/51 ; //2050
			double temp = excelResult(29,18,2)/51 + excelResult(29, 18, 4)/51 - excelResult(29,18,1)/51 - excelResult(29, 18, 3)/51 ;
			result = excelResult(29,18,1)/51 + excelResult(29, 18, 3)/51 + temp*(year-2011) ;
		}
		//失业率
		if(data.equals("unemploymentRate")){
			//result = excelResult(30,18,1)/51 + excelResult(30, 18, 3)/51 ; //2011
			//result = excelResult(30,18,2)/51 + excelResult(30, 18, 4)/51 ; //2050
			double temp = excelResult(30,18,2)/51 + excelResult(30, 18, 4)/51 - excelResult(30,18,1)/51 - excelResult(30, 18, 3)/51 ;
			result = excelResult(30,18,1)/51 + excelResult(30, 18, 3)/51 + temp*(year-2011) ;
		}
		//当年城镇参保人数
		if(data.equals("currentInsuredPopulation")){
			result = excelResult(38,19,1)*10000 + excelResult(38, 19, 2)*10000 + excelResult(38, 19, 3)*10000+ excelResult(38, 19, 4)*10000 ;
		}
		//起始年个人参保人员数        *****模型之中是求的数
		if(data.equals("freeworkPopulation")){
			result = excelResult(38,19,5)*10000 + excelResult(38, 19, 6)*10000 + excelResult(38, 19, 7)*10000+ excelResult(38, 19, 8)*10000 ;
		}
		//起始年单位退休人员数
		if(data.equals("retirePopulation")){
			result = excelResult(38,43,9)*10000 + excelResult(38, 43, 10)*10000 ;
		}
		//起始年个人参保退休人员
		if(data.equals("personalRetirePopulation")){
			result = excelResult(38,43,11)*10000 + excelResult(38, 43, 12)*10000 ;
		}
		//当年新增单位参保人员比例
		if(data.equals("currentNewInsuredRate")){
			//result = excelResult(39, 19, 1)/37 + excelResult(39, 19, 4)/37 ;//2011
			//result = excelResult(39, 19, 3)/37 + excelResult(39, 19, 6)/37 ;//2050
			double temp = excelResult(39, 19, 3)/37 + excelResult(39, 19, 6)/37 - excelResult(39, 19, 1)/37 - excelResult(39, 19, 4)/37 ;
			result = excelResult(39, 19, 1)/37 + excelResult(39, 19, 4)/37 + temp*(year-2011) ;
		}
		//当年新增个人参保人员比例
		if(data.equals("currentPersonalInsuredRate")){
			//result = excelResult(39, 19, 7)/37 + excelResult(39, 19, 10)/37 ;//2011
			//result = excelResult(39, 19, 9)/37 + excelResult(39, 19, 12)/37 ;//2050
			double temp = excelResult(39, 19, 9)/37 + excelResult(39, 19, 12)/37 - excelResult(39, 19, 7)/37 - excelResult(39, 19, 10)/37 ;
			result = excelResult(39, 19, 7)/37 + excelResult(39, 19, 10)/37 + temp*(year-2011) ;
		}
		//当年单位职工退休率
		if(data.equals("currentTownRetireRate")){
			//result = excelResult(40, 43, 1)/27 + excelResult(40, 43, 4)/27 ;//2011
			//result = excelResult(40, 43, 3)/27 + excelResult(40, 43, 6)/27 ;//2050
			double temp = excelResult(40, 43, 3)/27 + excelResult(40, 43, 6)/27 - excelResult(40, 43, 1)/27 - excelResult(40, 43, 4)/27 ;
			result = excelResult(40, 43, 1)/27 + excelResult(40, 43, 4)/27 + temp*(year-2011) ;
		}
		//基金征缴率
		if(data.equals("fundPaymentRate")){
			result = excelResult(34, 3, 3)/50/100 ;
		}
		//财政补贴
		if(data.equals("allowance")){
			//result = excelSingleParameter(37, 4, 1)*100000000 + excelSingleParameter(37,4,2)*100000000 ;//2012
			//result = excelSingleParameter(37, 5, 1)*100000000 + excelSingleParameter(37,5,2)*100000000 ;//2013
			result = excelSingleParameter(37, year-2008, 1)*100000000 + excelSingleParameter(37,year-2008,2)*100000000 ;//2012
		}
		//单位参保职工实帐养老金
		if(data.equals("insuredAnnuity")){
			result = excelResult(46,43,1)/61 + excelResult(46, 43, 2)/61 ;
		}
		//个人参保人员实帐养老金
		if(data.equals("personalInsuredAnnuity")){
			result = excelResult(46,43,1)/61 + excelResult(46, 43, 2)/61 ;
		}
		//当年缴费工资占上年社平均工资比例（缴费工资比例）
		if(data.equals("paymentSalaryRate")){
			//result = excelResult(42, 18, 1)/51 + excelResult(42,18,3)/51 ;//2011
			//result = excelResult(42, 18, 2)/51 + excelResult(42,18,4)/51 ;//2050
			double temp = excelResult(42, 18, 2)/51 + excelResult(42,18,4)/51 - excelResult(42, 18, 1)/51 - excelResult(42,18,3)/51 ;
			result = excelResult(42, 18, 1)/51 + excelResult(42,18,3)/51 + temp*(year-2011) ;
		}
		//缴费年限
		if(data.equals("paymentAgeLimit")){
			//result = excelResult(44, 19, 5)/50 + excelResult(44, 19, 7)/50 ;//2011
			//result = excelResult(44, 19, 6)/50 + excelResult(44, 19, 8)/50 ;//2050
			double temp = excelResult(44, 19, 6)/50 + excelResult(44, 19, 8)/50 - excelResult(44, 19, 5)/50 - excelResult(44, 19, 7)/50 ;
			result = excelResult(44, 19, 5)/50 + excelResult(44, 19, 7)/50 + temp*(year-2011) ;
		}
		//空帐记账率（支出参数）
		if(data.equals("emptyAccountRate")){
			//result = excelSingleParameter(35, 3, 6)/100 ;//2011
			//result = excelSingleParameter(35, 4, 6)/100 ;//2012
			//result = excelSingleParameter(35, 5, 6)/100 ;//2013
			result = excelSingleParameter(35, year-2008, 6)/100 ;
			
		}
		//起始年缴费工资基数
		if(data.equals("currentPaymentSalaryCardinality")){
			result = excelResult(8, 7, 1)/50 + excelResult(8, 7, 2)/50 ;
		}
		//过渡系数
		if(data.equals("excessiveCoefficient")){
			//result = excelSingleParameter(35, 3, 1)/100 ;//2011
			//result = excelSingleParameter(35, 4, 1)/100 ;//2012
			result = excelSingleParameter(35, year-2008, 1)/100 ;
		}
		//实帐记账率
		if(data.equals("realAccountRate")){
			//result = excelSingleParameter(35, 3, 7)/100 ;//2011
			//result = excelSingleParameter(35, 4, 7)/100 ;//2012
			//result = excelSingleParameter(35, 5, 7)/100 ;//2013
			result = excelSingleParameter(35, year-2008, 7)/100 ;
		}
		//丧葬费
		if(data.equals("funeralPay")){
			//result = excelSingleParameter(35, 3, 5) ;//2011
			//result = excelSingleParameter(35, 4, 5) ;//2012
			//result = excelSingleParameter(35, 5, 5) ;//2013
			result = excelSingleParameter(35, year-2008, 5) ;
		}
		return result;
	}
}
