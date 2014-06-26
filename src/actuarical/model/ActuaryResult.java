package actuarical.model;

public class ActuaryResult {
	
	
	//--上年末农村人口（迭代后的结果）
	private double lastEndcountryPopulation = 0 ;
	
	//上年末城镇人口（城镇人口模型得到的结果）
	private double lastEndTownPopulation = 0 ;
	
	//--当年年末参保职工人数
	private double currentEndInsuredPopulation = 0 ;
	
	//--灵活就业人口数
	private double freeworkPopulation = 0 ;	
	
	//--实帐个人账户基金总收入
	private double personalAccountFundTotalIncome = 0 ;	
	
	//养老基金总收入
	private double fundTotalIncome = 0  ;
	
	//--实帐个人账户基金总支出
	private double personalAccountFundTotalPay = 0 ;
	
	//--个人账户空帐支出
	private double personalEmptyPay = 0 ;
	
	//--基础性养老金支出
	private double foundationAnnuityPay = 0 ;
	
	//--过渡性养老金支出
	private double excessiveAnnuityPay = 0 ;
	
	//--个人账户实帐长寿支出
	private double personalAccountLongevityPay = 0 ;
	
	//--养老基金总支出
	private double annuityTotalPay = 0 ;

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
	
}
