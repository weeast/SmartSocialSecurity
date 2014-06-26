package actuarical.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import actuarical.dao.AdminInfoDao;
import actuarical.dao.AdminInfoDaoImp;
import actuarical.model.AdminInfo;

public class AdminInfoServelt extends HttpServlet {
	
	private int method = -1 ;
	private AdminInfo adminInfo = null ;
	private AdminInfoDao adminInfoDao = null ;
	private AdminInfoDaoImp adminInfoDaoImp = null ;
	private String adminId = "" ;
	private String oldPassword = "" ;
	private String newPassword = "" ;
	private String password = "" ;
	private String limit = "" ;
	List<AdminInfo> adminInfoList = null ;
	
	public AdminInfoServelt() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8") ;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		method = Integer.parseInt(request.getParameter("action")) ;
		
		if(method==-1){
			System.out.println("error") ;
		}
		
		if(method==0){
			HttpSession session = request.getSession(true); 
			adminId = session.getAttribute("adminId").toString() ;
			adminInfoDao = new AdminInfoDao() ;
			adminInfo = adminInfoDao.queryAdminInfo(adminId) ; //1：个人信息查询  
			int temp = 0 ;
			if(adminInfo!=null){
				temp = 1 ;
			}
			String adminInfoStr = "{\"succeed\":" + temp + ",\"user\":[" +
					"{\"username\":\"" + adminInfo.getAdminName() + "\",\"useracount\":\"" + adminInfo.getAdminId()+ "\",\"usersex\":\"" +
					adminInfo.getAdminSex() + "\",\"userage\":\"" + adminInfo.getAdminBirthday()+ "\",\"userplace\":\"" +
					adminInfo.getAdminAddress()+ "\",\"userapart\":\"" +adminInfo.getAdminDepartment()+ "\",\"userwork\":\"" +
					adminInfo.getAdminPosition()+ "\",\"userlimit\":\"" +adminInfo.getAdminLimit()+ "\",\"useronuse\":\"" +
					adminInfo.getAdminCommonFunction()+ "\",\"userpic\":\"" +adminInfo.getAdminImage()+"\"}]}" ;
			out.print(adminInfoStr) ;
		}
		
		if(method==1){
			adminInfoDao = new AdminInfoDao() ;
			HttpSession session = request.getSession(true); 
			adminId = session.getAttribute("adminId").toString() ;
			oldPassword = request.getParameter("oldpassword") ;
			newPassword = request.getParameter("newpassword") ;
			boolean temp = adminInfoDao.modifyPassword(adminId, oldPassword, newPassword) ; //2：管理员修改密码
			String succeedTemp = "" ;
			if(temp){
				succeedTemp = "{\"succeed\":" + 1 + "}" ;
			}else{
				succeedTemp = "{\"succeed\":" + 0 + "}" ;
			}
			out.print(succeedTemp) ;
		}
		
		if(method==2){ //5:登陆
			adminInfoDao = new AdminInfoDao() ;
			String adminId = request.getParameter("useracount") ;
			String adminPassword = request.getParameter("userpassword") ;
			boolean temp = adminInfoDao.login(adminId, adminPassword) ;
			if(temp){
				out.print("{\"succeed\":" + 1 + "}") ;
			}else{
				out.print("{\"succeed\":" + 0 + "}") ;
			}
			HttpSession session = request.getSession(true); 
			session.setAttribute("adminId", adminId) ; 
			out.close() ;
		}
		
		if(method==3){                //6：修改下属信息
			adminInfo = new AdminInfo() ;
			adminInfoDao = new AdminInfoDao() ;
			adminInfo.setAdminAddress("") ;
			adminInfo.setAdminBirthday("") ;
			adminInfo.setAdminCellPhone("") ;
			adminInfo.setAdminCommonFunction("") ;
			adminInfo.setAdminDepartment("") ;
			adminInfo.setAdminDepartment("") ;
			adminInfo.setAdminFatherSong("") ;
			adminInfo.setAdminIC("") ;
			adminInfo.setAdminId("");
			adminInfo.setAdminImage("") ;
			adminInfo.setAdminLimit("") ;
			adminInfo.setAdminName("") ;
			adminInfo.setAdminPassword("") ;
			adminInfo.setAdminPosition("") ;
			adminInfo.setAdminSex("") ;
			
			adminInfoDao.updateAdminInfo(adminId,adminInfo) ;
		}
		
		if(method==4){   //7：添加下属
			adminInfo = new AdminInfo() ;
			adminInfoDao = new AdminInfoDao() ;
			adminInfo.setAdminAddress("") ;
			adminInfo.setAdminBirthday("") ;
			adminInfo.setAdminCellPhone("") ;
			adminInfo.setAdminCommonFunction("") ;
			adminInfo.setAdminDepartment("") ;
			adminInfo.setAdminDepartment("") ;
			adminInfo.setAdminFatherSong("") ;
			adminInfo.setAdminIC("") ;
			adminInfo.setAdminId("");
			adminInfo.setAdminImage("") ;
			adminInfo.setAdminLimit("") ;
			adminInfo.setAdminName("") ;
			adminInfo.setAdminPassword("") ;
			adminInfo.setAdminPosition("") ;
			adminInfo.setAdminSex("") ;
			
			adminInfoDao.saveAdminInfo(adminInfo) ;
		}
		
		if(method==5){    //8：删除下属
			adminInfoDao = new AdminInfoDao() ;
			adminInfoDao.delAdminInfo(adminId) ;
		}
		
		if(method==6){    //9：查询下属权限
			adminInfoDao = new AdminInfoDao() ;
			String subordinateLimit = adminInfoDao.queryLimit(adminId) ;
		}
		
		if(method==7){    //10：修改下属权限
			adminInfoDao = new AdminInfoDao() ;
			adminInfoDao.modifyLimit(adminId, limit) ;
		}
		
		if(method==8){	  //5：查询所有下属信息(获取当前管理员的adminId)
			adminInfoDao = new AdminInfoDao() ;
			HttpSession session = request.getSession(true);
			adminId = session.getAttribute("adminId").toString() ;
			adminInfoList = adminInfoDao.queryTotalAdminInfo(adminId) ;
			String outAdminInfoList = "" ;
			if(adminInfoList!=null){
				outAdminInfoList = "{\"succeed\":" + 1 + ",\"account\":[" ;
				for(int i=0;i<adminInfoList.size();i++){
					
							outAdminInfoList = outAdminInfoList + "{\"accountnum\":\"" + adminInfoList.get(i).getAdminId() + "\",\"accountname\":\"" + adminInfoList.get(i).getAdminName()+ "\",\"accountage\":\"" +
							adminInfoList.get(i).getAdminBirthday() + "\",\"accountsex\":\"" + adminInfoList.get(i).getAdminSex()+ "\",\"accountplace\":\"" +
							adminInfoList.get(i).getAdminAddress()+ "\",\"accountapart\":\"" +adminInfoList.get(i).getAdminDepartment()+ "\",\"accountwork\":\"" +
							adminInfoList.get(i).getAdminPosition()+ "\"}";
							if(i<adminInfoList.size()-1){
								outAdminInfoList = outAdminInfoList + ",\n" ;
							}
				}
				outAdminInfoList = outAdminInfoList + "]}" ; 
				out.print(outAdminInfoList) ;
			}
		}
	}

	public void init() throws ServletException {
	
	}

}
