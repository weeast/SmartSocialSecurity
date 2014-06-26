package actuarical.model;

import java.util.Date;

public class ModifyInternalData {
	//id
	private String modifyInternalDataId = "" ;
	//内部数据id
	private String internalDataId = "" ;
	//更改差值
	private String modifyDifValue = "" ;
	//更改日期
	private Date modifyDate = null ;
	//修改人
	private String adminId = "" ;
	
	public String getModifyInternalDataId() {
		return modifyInternalDataId;
	}
	public void setModifyInternalDataId(String modifyInternalDataId) {
		this.modifyInternalDataId = modifyInternalDataId;
	}
	public String getInternalDataId() {
		return internalDataId;
	}
	public void setInternalDataId(String internalDataId) {
		this.internalDataId = internalDataId;
	}
	public String getModifyDifValue() {
		return modifyDifValue;
	}
	public void setModifyDifValue(String modifyDifValue) {
		this.modifyDifValue = modifyDifValue;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
}
