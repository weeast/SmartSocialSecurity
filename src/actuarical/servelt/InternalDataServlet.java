package actuarical.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actuarical.dao.InternalDataDao;
import actuarical.dao.InternalDataDaoImp;
import actuarical.model.InternalData;

public class InternalDataServlet extends HttpServlet {

	private InternalData internalData = null ;
	private InternalDataDao internalDataDao = null ;
	private InternalDataDaoImp internalDataDaoImp = null ;
	private int action = -1 ;
	private String agentId = "" ;
	private String adminId = "" ; //修改数据的管理员
	
	public InternalDataServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		if(action==-1){
			System.out.println("error") ;
		}
		if(action==0){      //17：内部数据查询
			internalData = internalDataDao.queryInternalData(agentId) ;
		}
		if(action==1){ 		//19：内部数据录入
			internalDataDao.saveInternalData(internalData) ;
		}
		if(action==2){		//20：内部数据修改
			internalDataDao.modifyInternalData(adminId, internalData) ;
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
