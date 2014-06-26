package actuarical.model;

import java.util.Date;

public class UserInfo {
	//用户账号
	private String userId = "" ;
	//用户邮箱
	private String userEmail = "" ;
	//用户姓名
	private String userName = "" ;
	//用户性别
	private String userSex = "" ;
	//用户生日
	private Date userBirthday = null ;
	//用户密码
	private String userPassword = "" ;
	//用户工作单位
	private String userWorkUnit = "" ;
	//所在地
	private String userAddress = "" ;
	//用户照片
	private String userImage = "" ;
	//用户身份证号
	private String userIC = "" ;
	//用户手机号
	private String userCellPhone = "" ;
	//用户参保年限
	private int userInsuredAgeLimit = 0 ;
		
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserWorkUnit() {
		return userWorkUnit;
	}
	public void setUserWorkUnit(String userWorkUnit) {
		this.userWorkUnit = userWorkUnit;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getUserIC() {
		return userIC;
	}
	public void setUserIC(String userIC) {
		this.userIC = userIC;
	}
	public String getUserCellPhone() {
		return userCellPhone;
	}
	public void setUserCellPhone(String userCellPhone) {
		this.userCellPhone = userCellPhone;
	}
	public int getUserInsuredAgeLimit() {
		return userInsuredAgeLimit;
	}
	public void setUserInsuredAgeLimit(int userInsuredAgeLimit) {
		this.userInsuredAgeLimit = userInsuredAgeLimit;
	}
}
