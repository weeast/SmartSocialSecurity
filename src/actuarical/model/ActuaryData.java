package actuarical.model;

public class ActuaryData {
	
/***************收入模块*********************/ //73个参数
	//当年本地区农村净迁入城镇人口占农村比例
	private double localCountryToTown = 0 ;
	//当年外地区净迁入城镇人口
	private double outsideToTown = 0 ;
	//当年净迁入城镇人口
	private double toTown = 0 ;
	//城镇生育率
	private double townFertilityRate = 0 ;
	//城镇新生婴儿数
	private double townNewBaby = 0  ;
	//城镇死亡率
	private double townDieRate = 0 ;
	//当年初城镇人口
	private double currentTownPopulation = 0 ;
	//当年末城镇人口
	private double currentEndTownPopulation = 0 ;
	//上年末城镇人口（城镇人口模型得到的结果）
	private double lastEndTownPopulation = 0 ;
	


	//劳动参与率
	private double laborParticipationRate = 0 ;
	
	//--上年末城镇经济活动人口
	private double currentLaborPopulation = 0 ;
	//失业率
	private double unemploymentRate = 0 ;
	//--上年城镇就业人口
	private double townEmploymentPopulation = 0 ;
	//上年末城镇未参保职工人数
	private double townNoInsuredPopulation = 0 ;
	//当年新增参保率(新增参保人员)
	private double currentNewInsuredRate = 0 ;
	//当年年初参保人数
	private double currentInsuredPopulation = 0 ;
	//当年退休率
	private double currentTownRetireRate = 0 ;
	//--当年新增退休人员
	private double currentNewRetirePopulation = 0 ;
	//参保职工死亡率（死亡率）
	private double insuredDieRate = 0 ;
	//--当年新增参保职工
	private double currentNewInsuredPopulation = 0 ;
	//--当年年末参保职工人数
	private double currentEndInsuredPopulation = 0 ;
	//??职工缴费工资
	private double paySalary = 0 ;
	//个人帐户空账缴费比例(？？)
	private double personalEmptyAccountPaymentRate ;
	//统筹基金缴费比例（收入相关参数）
	private double coordinationFundPaymentRate = 0 ;
	//--参保职工征缴收入
	private double insuredCollectionIncome = 0 ;
	//基金征缴率(收入相关参数)
	private double fundPaymentRate = 0 ;
	
	
	//当年外地区净迁入农村人口
	private double outsideToCountry = 0  ;
	//--当年净迁入农村人口
	private double toCountryPopulation = 0 ;
	//农村生育率
	private double countryFertilityRate = 0 ;
	//农村死亡率
	private double countryDieRate = 0 ;
	//当年初农村人口
	private double currentCountryPopulation = 0 ;
	//--当年末农村人口
	private double currentEndCountryPopulation = 0 ;
	//--上年末农村人口（迭代后的结果）
	private double lastEndcountryPopulation = 0 ;
	//--城镇自由职业者
	private double townFreeworkPopulation = 0 ; 
	//当年个人参保率（新增参保人员）
	private double currentPersonalInsuredRate = 0 ;
	//--灵活就业人口数
	private double freeworkPopulation = 0 ;
	//？？农民工缴费工资
	private double peasantPayment = 0 ;
	//--参保农民工征缴收入
	private double insuredPeasantPaymentIncome = 0 ;
	//财政补助
	private double allowance = 0 ;
	//？？利息收入
	private double interestIncome = 0 ;
	//其他收入??
	private double restIncome = 0 ;
	//--统筹基金总收入
	private double coordinationFundTotalIncome = 0 ;
	
	
	//？？个人账户实帐缴费比例
	private double personalRealAccountPaymentRate = 0 ;
	//--单位参保职工缴费收入
	private double insuredPaymentIncome = 0 ;
	//--灵活就业人员缴费收入
	private double freeworkPaymentIncome = 0 ;
	//--个人账户缴费收入
	private double personalAccountPaymentIncome = 0 ;
	//--实帐个人账户基金总收入
	private double personalAccountFundTotalIncome = 0 ;
	
	//养老基金总收入
	private double fundTotalIncome = 0  ;
	
/******************************基金支出模块***************************/
	//起始年平均空账余额
	private double currentAverageBalance = 0 ;
	//当年缴费工资占上年社平均工资比例（缴费工资比例）
	private double paymentSalaryRate = 0 ;
	//缴费年限
	private int paymentAgeLimit = 0 ;
	//??上年社会平均工资
	private double lastAverageSalary = 0 ;
	//空帐记账率（支出参数）
	private double emptyAccountRate = 0 ;
	//--平均个人账户空帐余额
	private double averagePersonalEmptyBalance = 0 ;
	//？？计发月数
	private double planMonths = 0 ;
	//--个人账户空帐支出
	private double personalEmptyPay = 0 ;
	
	
	//起始年缴费工资基数
	private double currentPaymentSalaryCardinality = 0 ;
	//--平均缴费工资指数
	private double averagePaymentSalaryIndex = 0 ;
	//--指数化平均工资
	private double indexAverageSalary = 0 ;
	//--基础性养老金支出
	private double foundationAnnuityPay = 0 ;
	
	
	//过渡年限
	private double excessiveAgeLimit = 0 ;
	//过渡系数
	private double excessiveCoefficient = 0 ;
	//--过渡性养老金支出
	private double excessiveAnnuityPay = 0 ;
	
	//实帐记账率
	private double realAccountRate = 0 ;
	//--个人账户实帐长寿支出
	private double personalAccountLongevityPay = 0 ;
	
	//--统筹基金养老金支出
	private double coordinationFundAnnuityPay = 0 ;
	//丧葬费
	private double funeralPay = 0 ;
	//其他支出
	private double restPay = 0 ;
	//--统筹基金养老金总支出
	private double coordinationFundAnnuityTotalPay = 0 ;
	
	//单位参保职工实帐养老金
	private double insuredAnnuity = 0 ;
	//单位退休人员数
	private double retirePopulation = 0 ;
	//--单位参保职工实帐养老金支出
	private double insuredAnnuityPay = 0 ;
	
	//个人参保人员实帐养老金
	private double personalInsuredAnnuity = 0 ;
	//个人参保退休人数（人数情况）
	private double personalRetirePopulation = 0 ;
	//--个人参保人员实帐养老金支出
	private double personalInsuredAnnuityPay = 0 ;
	//--实帐个人账户基金总支出
	private double personalAccountFundTotalPay = 0 ;
	
	
	//--养老基金总支出
	private double annuityTotalPay = 0 ;


	public double getLocalCountryToTown() {
		return localCountryToTown;
	}


	public void setLocalCountryToTown(double localCountryToTown) {
		this.localCountryToTown = localCountryToTown;
	}


	public double getOutsideToTown() {
		return outsideToTown;
	}


	public void setOutsideToTown(double outsideToTown) {
		this.outsideToTown = outsideToTown;
	}


	public double getToTown() {
		return toTown;
	}


	public void setToTown(double toTown) {
		this.toTown = toTown;
	}


	public double getTownFertilityRate() {
		return townFertilityRate;
	}


	public void setTownFertilityRate(double townFertilityRate) {
		this.townFertilityRate = townFertilityRate;
	}


	public double getTownNewBaby() {
		return townNewBaby;
	}


	public void setTownNewBaby(double townNewBaby) {
		this.townNewBaby = townNewBaby;
	}


	public double getTownDieRate() {
		return townDieRate;
	}


	public void setTownDieRate(double townDieRate) {
		this.townDieRate = townDieRate;
	}


	public double getCurrentTownPopulation() {
		return currentTownPopulation;
	}


	public void setCurrentTownPopulation(double currentTownPopulation) {
		this.currentTownPopulation = currentTownPopulation;
	}


	public double getCurrentEndTownPopulation() {
		return currentEndTownPopulation;
	}


	public void setCurrentEndTownPopulation(double currentEndTownPopulation) {
		this.currentEndTownPopulation = currentEndTownPopulation;
	}


	public double getLastEndTownPopulation() {
		return lastEndTownPopulation;
	}


	public void setLastEndTownPopulation(double lastEndTownPopulation) {
		this.lastEndTownPopulation = lastEndTownPopulation;
	}


	public double getLaborParticipationRate() {
		return laborParticipationRate;
	}


	public void setLaborParticipationRate(double laborParticipationRate) {
		this.laborParticipationRate = laborParticipationRate;
	}


	public double getCurrentLaborPopulation() {
		return currentLaborPopulation;
	}


	public void setCurrentLaborPopulation(double currentLaborPopulation) {
		this.currentLaborPopulation = currentLaborPopulation;
	}


	public double getUnemploymentRate() {
		return unemploymentRate;
	}


	public void setUnemploymentRate(double unemploymentRate) {
		this.unemploymentRate = unemploymentRate;
	}


	public double getTownEmploymentPopulation() {
		return townEmploymentPopulation;
	}


	public void setTownEmploymentPopulation(double townEmploymentPopulation) {
		this.townEmploymentPopulation = townEmploymentPopulation;
	}


	public double getTownNoInsuredPopulation() {
		return townNoInsuredPopulation;
	}


	public void setTownNoInsuredPopulation(double townNoInsuredPopulation) {
		this.townNoInsuredPopulation = townNoInsuredPopulation;
	}


	public double getCurrentNewInsuredRate() {
		return currentNewInsuredRate;
	}


	public void setCurrentNewInsuredRate(double currentNewInsuredRate) {
		this.currentNewInsuredRate = currentNewInsuredRate;
	}


	public double getCurrentInsuredPopulation() {
		return currentInsuredPopulation;
	}


	public void setCurrentInsuredPopulation(double currentInsuredPopulation) {
		this.currentInsuredPopulation = currentInsuredPopulation;
	}


	public double getCurrentTownRetireRate() {
		return currentTownRetireRate;
	}


	public void setCurrentTownRetireRate(double currentTownRetireRate) {
		this.currentTownRetireRate = currentTownRetireRate;
	}


	public double getCurrentNewRetirePopulation() {
		return currentNewRetirePopulation;
	}


	public void setCurrentNewRetirePopulation(double currentNewRetirePopulation) {
		this.currentNewRetirePopulation = currentNewRetirePopulation;
	}


	public double getInsuredDieRate() {
		return insuredDieRate;
	}


	public void setInsuredDieRate(double insuredDieRate) {
		this.insuredDieRate = insuredDieRate;
	}


	public double getCurrentNewInsuredPopulation() {
		return currentNewInsuredPopulation;
	}


	public void setCurrentNewInsuredPopulation(double currentNewInsuredPopulation) {
		this.currentNewInsuredPopulation = currentNewInsuredPopulation;
	}


	public double getCurrentEndInsuredPopulation() {
		return currentEndInsuredPopulation;
	}


	public void setCurrentEndInsuredPopulation(double currentEndInsuredPopulation) {
		this.currentEndInsuredPopulation = currentEndInsuredPopulation;
	}


	public double getPaySalary() {
		return paySalary;
	}


	public void setPaySalary(double paySalary) {
		this.paySalary = paySalary;
	}


	public double getPersonalEmptyAccountPaymentRate() {
		return personalEmptyAccountPaymentRate;
	}


	public void setPersonalEmptyAccountPaymentRate(
			double personalEmptyAccountPaymentRate) {
		this.personalEmptyAccountPaymentRate = personalEmptyAccountPaymentRate;
	}


	public double getCoordinationFundPaymentRate() {
		return coordinationFundPaymentRate;
	}


	public void setCoordinationFundPaymentRate(double coordinationFundPaymentRate) {
		this.coordinationFundPaymentRate = coordinationFundPaymentRate;
	}


	public double getInsuredCollectionIncome() {
		return insuredCollectionIncome;
	}


	public void setInsuredCollectionIncome(double insuredCollectionIncome) {
		this.insuredCollectionIncome = insuredCollectionIncome;
	}


	public double getFundPaymentRate() {
		return fundPaymentRate;
	}


	public void setFundPaymentRate(double fundPaymentRate) {
		this.fundPaymentRate = fundPaymentRate;
	}


	public double getOutsideToCountry() {
		return outsideToCountry;
	}


	public void setOutsideToCountry(double outsideToCountry) {
		this.outsideToCountry = outsideToCountry;
	}


	public double getToCountryPopulation() {
		return toCountryPopulation;
	}


	public void setToCountryPopulation(double toCountryPopulation) {
		this.toCountryPopulation = toCountryPopulation;
	}


	public double getCountryFertilityRate() {
		return countryFertilityRate;
	}


	public void setCountryFertilityRate(double countryFertilityRate) {
		this.countryFertilityRate = countryFertilityRate;
	}


	public double getCountryDieRate() {
		return countryDieRate;
	}


	public void setCountryDieRate(double countryDieRate) {
		this.countryDieRate = countryDieRate;
	}


	public double getCurrentCountryPopulation() {
		return currentCountryPopulation;
	}


	public void setCurrentCountryPopulation(double currentCountryPopulation) {
		this.currentCountryPopulation = currentCountryPopulation;
	}


	public double getCurrentEndCountryPopulation() {
		return currentEndCountryPopulation;
	}


	public void setCurrentEndCountryPopulation(double currentEndCountryPopulation) {
		this.currentEndCountryPopulation = currentEndCountryPopulation;
	}


	public double getLastEndcountryPopulation() {
		return lastEndcountryPopulation;
	}


	public void setLastEndcountryPopulation(double lastEndcountryPopulation) {
		this.lastEndcountryPopulation = lastEndcountryPopulation;
	}


	public double getTownFreeworkPopulation() {
		return townFreeworkPopulation;
	}


	public void setTownFreeworkPopulation(double townFreeworkPopulation) {
		this.townFreeworkPopulation = townFreeworkPopulation;
	}


	public double getCurrentPersonalInsuredRate() {
		return currentPersonalInsuredRate;
	}


	public void setCurrentPersonalInsuredRate(double currentPersonalInsuredRate) {
		this.currentPersonalInsuredRate = currentPersonalInsuredRate;
	}


	public double getFreeworkPopulation() {
		return freeworkPopulation;
	}


	public void setFreeworkPopulation(double freeworkPopulation) {
		this.freeworkPopulation = freeworkPopulation;
	}


	public double getPeasantPayment() {
		return peasantPayment;
	}


	public void setPeasantPayment(double peasantPayment) {
		this.peasantPayment = peasantPayment;
	}


	public double getInsuredPeasantPaymentIncome() {
		return insuredPeasantPaymentIncome;
	}


	public void setInsuredPeasantPaymentIncome(double insuredPeasantPaymentIncome) {
		this.insuredPeasantPaymentIncome = insuredPeasantPaymentIncome;
	}


	public double getAllowance() {
		return allowance;
	}


	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}


	public double getInterestIncome() {
		return interestIncome;
	}


	public void setInterestIncome(double interestIncome) {
		this.interestIncome = interestIncome;
	}


	public double getRestIncome() {
		return restIncome;
	}


	public void setRestIncome(double restIncome) {
		this.restIncome = restIncome;
	}


	public double getCoordinationFundTotalIncome() {
		return coordinationFundTotalIncome;
	}


	public void setCoordinationFundTotalIncome(double coordinationFundTotalIncome) {
		this.coordinationFundTotalIncome = coordinationFundTotalIncome;
	}


	public double getPersonalRealAccountPaymentRate() {
		return personalRealAccountPaymentRate;
	}


	public void setPersonalRealAccountPaymentRate(
			double personalRealAccountPaymentRate) {
		this.personalRealAccountPaymentRate = personalRealAccountPaymentRate;
	}


	public double getInsuredPaymentIncome() {
		return insuredPaymentIncome;
	}


	public void setInsuredPaymentIncome(double insuredPaymentIncome) {
		this.insuredPaymentIncome = insuredPaymentIncome;
	}


	public double getFreeworkPaymentIncome() {
		return freeworkPaymentIncome;
	}


	public void setFreeworkPaymentIncome(double freeworkPaymentIncome) {
		this.freeworkPaymentIncome = freeworkPaymentIncome;
	}


	public double getPersonalAccountPaymentIncome() {
		return personalAccountPaymentIncome;
	}


	public void setPersonalAccountPaymentIncome(double personalAccountPaymentIncome) {
		this.personalAccountPaymentIncome = personalAccountPaymentIncome;
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


	public double getCurrentAverageBalance() {
		return currentAverageBalance;
	}


	public void setCurrentAverageBalance(double currentAverageBalance) {
		this.currentAverageBalance = currentAverageBalance;
	}


	public double getPaymentSalaryRate() {
		return paymentSalaryRate;
	}


	public void setPaymentSalaryRate(double paymentSalaryRate) {
		this.paymentSalaryRate = paymentSalaryRate;
	}


	public int getPaymentAgeLimit() {
		return paymentAgeLimit;
	}


	public void setPaymentAgeLimit(int paymentAgeLimit) {
		this.paymentAgeLimit = paymentAgeLimit;
	}


	public double getLastAverageSalary() {
		return lastAverageSalary;
	}


	public void setLastAverageSalary(double lastAverageSalary) {
		this.lastAverageSalary = lastAverageSalary;
	}


	public double getEmptyAccountRate() {
		return emptyAccountRate;
	}


	public void setEmptyAccountRate(double emptyAccountRate) {
		this.emptyAccountRate = emptyAccountRate;
	}


	public double getAveragePersonalEmptyBalance() {
		return averagePersonalEmptyBalance;
	}


	public void setAveragePersonalEmptyBalance(double averagePersonalEmptyBalance) {
		this.averagePersonalEmptyBalance = averagePersonalEmptyBalance;
	}


	public double getPlanMonths() {
		return planMonths;
	}


	public void setPlanMonths(double planMonths) {
		this.planMonths = planMonths;
	}


	public double getPersonalEmptyPay() {
		return personalEmptyPay;
	}


	public void setPersonalEmptyPay(double personalEmptyPay) {
		this.personalEmptyPay = personalEmptyPay;
	}


	public double getCurrentPaymentSalaryCardinality() {
		return currentPaymentSalaryCardinality;
	}


	public void setCurrentPaymentSalaryCardinality(
			double currentPaymentSalaryCardinality) {
		this.currentPaymentSalaryCardinality = currentPaymentSalaryCardinality;
	}


	public double getAveragePaymentSalaryIndex() {
		return averagePaymentSalaryIndex;
	}


	public void setAveragePaymentSalaryIndex(double averagePaymentSalaryIndex) {
		this.averagePaymentSalaryIndex = averagePaymentSalaryIndex;
	}


	public double getIndexAverageSalary() {
		return indexAverageSalary;
	}


	public void setIndexAverageSalary(double indexAverageSalary) {
		this.indexAverageSalary = indexAverageSalary;
	}


	public double getFoundationAnnuityPay() {
		return foundationAnnuityPay;
	}


	public void setFoundationAnnuityPay(double foundationAnnuityPay) {
		this.foundationAnnuityPay = foundationAnnuityPay;
	}


	public double getExcessiveAgeLimit() {
		return excessiveAgeLimit;
	}


	public void setExcessiveAgeLimit(double excessiveAgeLimit) {
		this.excessiveAgeLimit = excessiveAgeLimit;
	}


	public double getExcessiveCoefficient() {
		return excessiveCoefficient;
	}


	public void setExcessiveCoefficient(double excessiveCoefficient) {
		this.excessiveCoefficient = excessiveCoefficient;
	}


	public double getExcessiveAnnuityPay() {
		return excessiveAnnuityPay;
	}


	public void setExcessiveAnnuityPay(double excessiveAnnuityPay) {
		this.excessiveAnnuityPay = excessiveAnnuityPay;
	}


	public double getRealAccountRate() {
		return realAccountRate;
	}


	public void setRealAccountRate(double realAccountRate) {
		this.realAccountRate = realAccountRate;
	}


	public double getPersonalAccountLongevityPay() {
		return personalAccountLongevityPay;
	}


	public void setPersonalAccountLongevityPay(double personalAccountLongevityPay) {
		this.personalAccountLongevityPay = personalAccountLongevityPay;
	}


	public double getCoordinationFundAnnuityPay() {
		return coordinationFundAnnuityPay;
	}


	public void setCoordinationFundAnnuityPay(double coordinationFundAnnuityPay) {
		this.coordinationFundAnnuityPay = coordinationFundAnnuityPay;
	}


	public double getFuneralPay() {
		return funeralPay;
	}


	public void setFuneralPay(double funeralPay) {
		this.funeralPay = funeralPay;
	}


	public double getRestPay() {
		return restPay;
	}


	public void setRestPay(double restPay) {
		this.restPay = restPay;
	}


	public double getCoordinationFundAnnuityTotalPay() {
		return coordinationFundAnnuityTotalPay;
	}


	public void setCoordinationFundAnnuityTotalPay(
			double coordinationFundAnnuityTotalPay) {
		this.coordinationFundAnnuityTotalPay = coordinationFundAnnuityTotalPay;
	}


	public double getInsuredAnnuity() {
		return insuredAnnuity;
	}


	public void setInsuredAnnuity(double insuredAnnuity) {
		this.insuredAnnuity = insuredAnnuity;
	}


	public double getRetirePopulation() {
		return retirePopulation;
	}


	public void setRetirePopulation(double retirePopulation) {
		this.retirePopulation = retirePopulation;
	}


	public double getInsuredAnnuityPay() {
		return insuredAnnuityPay;
	}


	public void setInsuredAnnuityPay(double insuredAnnuityPay) {
		this.insuredAnnuityPay = insuredAnnuityPay;
	}


	public double getPersonalInsuredAnnuity() {
		return personalInsuredAnnuity;
	}


	public void setPersonalInsuredAnnuity(double personalInsuredAnnuity) {
		this.personalInsuredAnnuity = personalInsuredAnnuity;
	}


	public double getPersonalRetirePopulation() {
		return personalRetirePopulation;
	}


	public void setPersonalRetirePopulation(double personalRetirePopulation) {
		this.personalRetirePopulation = personalRetirePopulation;
	}


	public double getPersonalInsuredAnnuityPay() {
		return personalInsuredAnnuityPay;
	}


	public void setPersonalInsuredAnnuityPay(double personalInsuredAnnuityPay) {
		this.personalInsuredAnnuityPay = personalInsuredAnnuityPay;
	}


	public double getPersonalAccountFundTotalPay() {
		return personalAccountFundTotalPay;
	}


	public void setPersonalAccountFundTotalPay(double personalAccountFundTotalPay) {
		this.personalAccountFundTotalPay = personalAccountFundTotalPay;
	}


	public double getAnnuityTotalPay() {
		return annuityTotalPay;
	}


	public void setAnnuityTotalPay(double annuityTotalPay) {
		this.annuityTotalPay = annuityTotalPay;
	}
	
}
