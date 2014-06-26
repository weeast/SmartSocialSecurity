package actuarical.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actuarical.dao.ModifyInternalDataDao;
import actuarical.dao.ModifyInternalDataDaoImp;
import actuarical.model.ModifyInternalData;

public class ModifyInfoQueryServlet extends HttpServlet {

	private ModifyInternalData modifyInternalData = null ;
	private ModifyInternalDataDao modifyInternalDataDao = null ;
	private ModifyInternalDataDaoImp modifyInternalDataDaoImp = null ;
	
	private String adminId = "" ;
	
	public ModifyInfoQueryServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//18：修改信息查看
		modifyInternalData = modifyInternalDataDao.queryModifyInternalData(adminId) ;
	}

	public void init() throws ServletException {
	}

}
