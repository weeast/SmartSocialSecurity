package actuarical.model;

import java.util.Date;

public class ActuaryInfo {
	
	//精算ID
	private int actuaryID = 0 ;
	//精算批次
	private String actuaryLot = "" ;
	//年份
	private Date actuaryYear = null ;
	//模型ID
	private int actuaryModelID = 0 ;
	//精算结果
	private double actuaryResult = 0 ;
	//精算日期
	private Date actuaryDate = null ;
	
	public int getActuaryID() {
		return actuaryID;
	}
	public void setActuaryID(int actuaryID) {
		this.actuaryID = actuaryID;
	}
	public String getActuaryLot() {
		return actuaryLot;
	}
	public void setActuaryLot(String actuaryLot) {
		this.actuaryLot = actuaryLot;
	}
	public Date getActuaryYear() {
		return actuaryYear;
	}
	public void setActuaryYear(Date actuaryYear) {
		this.actuaryYear = actuaryYear;
	}
	public int getActuaryModelID() {
		return actuaryModelID;
	}
	public void setActuaryModelID(int actuaryModelID) {
		this.actuaryModelID = actuaryModelID;
	}
	public double getActuaryResult() {
		return actuaryResult;
	}
	public void setActuaryResult(double actuaryResult) {
		this.actuaryResult = actuaryResult;
	}
	public Date getActuaryDate() {
		return actuaryDate;
	}
	public void setActuaryDate(Date actuaryDate) {
		this.actuaryDate = actuaryDate;
	}
}
