package actuarical.model;

import java.util.Date;

public class InternalData {
	//内部数据id
	private String internalDataId = "" ;
	//用户id
	private String userId = "" ;
	//金额
	private double money = 0 ;
	//日期
	private Date date = null ;
	//经办人ID
	private String agentId = "" ;
	//收支
	private String incomeExpend = "" ;
	//是否修改
	private String wetherModify = "" ;
	
	public String getInternalDataId() {
		return internalDataId;
	}
	public void setInternalDataId(String internalDataId) {
		this.internalDataId = internalDataId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getIncomeExpend() {
		return incomeExpend;
	}
	public void setIncomeExpend(String incomeExpend) {
		this.incomeExpend = incomeExpend;
	}
	public String getWetherModify() {
		return wetherModify;
	}
	public void setWetherModify(String wetherModify) {
		this.wetherModify = wetherModify;
	}
	
}
