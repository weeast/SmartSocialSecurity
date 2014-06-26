package actuarical.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import actuarical.dao.ActuaryInfoDao;
import actuarical.dao.ActuaryInfoDaoImp;
import actuarical.model.ActuaryInfo;
import actuarical.model.ActuaryResult;

public class ActuaryInfoServlet extends HttpServlet {
	private int method = -1 ;
	private ActuaryInfoDao actuaryInfoDao = null ;
	private String year = "" ; //所算的年份
	private String adminId = "" ; //当前账号
	
	public ActuaryInfoServlet() {
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
		PrintWriter out = response.getWriter() ;
		method = Integer.parseInt(request.getParameter("action")) ;
		String modelId1 = request.getParameter("Country") ;   	//农村人口模型
		String modelId2 = request.getParameter("Town") ;	//城镇人口模型
		String modelId3 = request.getParameter("PaymentPopulation") ;	//缴费人口模型
		String modelId4 = request.getParameter("AccountIncome") ;	//实帐账户收入模型
		String modelId5 = request.getParameter("FundIncome") ;	//养老金收入模型
		String modelId6 = request.getParameter("AccountPay") ;	//实帐账户支出模型
		String modelId7 = request.getParameter("EmptyPay") ;	//个人账户空帐支出
		String modelId8 = request.getParameter("FoundationPay") ;	//基础养老金支出
		String modelId9 = request.getParameter("ExcessivePay") ;	//过渡性养老金支出
		String modelId10 = request.getParameter("AccountLongevityPay") ;	//个人账户实帐长寿支出
		String modelId11 = request.getParameter("TotalPay") ; ;	//统筹基金支出模型
		
		List<String> modelIdList = new ArrayList<String> () ;
		modelIdList.add(modelId1) ;
		modelIdList.add(modelId2) ;
		modelIdList.add(modelId3) ;
		modelIdList.add(modelId4) ;
		modelIdList.add(modelId5) ;
		modelIdList.add(modelId6) ;
		modelIdList.add(modelId7) ;
		modelIdList.add(modelId8) ;
		modelIdList.add(modelId9) ;
		modelIdList.add(modelId10) ;
		modelIdList.add(modelId11) ;
		
		if(method==-1){
			System.out.println("error") ;
		}
		if(method==0){
			HttpSession session = request.getSession(true) ;
			actuaryInfoDao = new ActuaryInfoDao() ;
			String year = request.getParameter("years") ;
			
			adminId = session.getAttribute("adminId").toString() ;
			List<ActuaryResult> resultList = actuaryInfoDao.actuary(modelIdList,year,adminId) ;   //25返回精算结果
			
			session.setAttribute("resultList", resultList) ;
			
			if(resultList!=null){
				out.print("{\"succeed\":" + 1 + "}") ;
			}else{
				out.print("{\"succeed\":" + 0 + "}");
			}
		}
		if(method==1){
			List<String> historyResultList = actuaryInfoDao.queryHistoryRecord(adminId) ; //26返回精算结果的历史数据
		}
		if(method==2){
			HttpSession session = request.getSession(true) ;
			List<ActuaryResult> list = (List<ActuaryResult>)session.getAttribute("resultList") ;
			
			int yearNum = list.size() ;
			String result = "" ;
			result = "{\"succeed\":" + 1 + ",\"result\":[" ;
			//农村人口1
			result = result + "{\"modeltype\":\""+ "Country" +"\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(i).getLastEndcountryPopulation()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//城镇人口1
			result = result + "{\"modeltype\":\""+ "Town" +"\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(i).getLastEndTownPopulation()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//缴费人口模型11
			result = result + "{\"modeltype\":\""+ "PaymentPopulationOne" +"\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(i).getCurrentEndInsuredPopulation()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			//缴费人口模型12
			result = result + "{\"modeltype\":\""+ "PaymentPopulationTwo" +"\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(i).getFreeworkPopulation()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//实帐账户收入模型1
			result = result + "{\"modeltype\":\""+ "AccountIncome" +"\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(i).getPersonalAccountFundTotalIncome()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//养老金收入模型1
			result = result + "{\"modeltype\":\""+ "FundIncome" +"\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(i).getFundTotalIncome()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//实帐账户支出模型1
			result = result + "{\"modeltype\":\""+ "AccountPay" +"\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(i).getPersonalAccountFundTotalPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//个人账户空帐支出1
			result = result + "{\"modeltype\":\""+ "EmptyPay" +"\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(i).getPersonalEmptyPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//基础养老金支出1
			result = result + "{\"modeltype\":\""+ "FoundationPay" +"\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(i).getFoundationAnnuityPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//过渡性养老金支出1
			result = result + "{\"modeltype\":\""+ "ExcessivePay" +"\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(i).getExcessiveAnnuityPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//个人账户实帐长寿支出1
			result = result + "{\"modeltype\":\""+ "AccountLongevityPay" +"\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(i).getPersonalAccountLongevityPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//统筹基金支出模型1
			result = result + "{\"modeltype\":\""+ "TotalPay" +"\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(i).getAnnuityTotalPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}]}" ;
			
			out.print(result) ;
		}
	}

	public void init() throws ServletException {
	}

}
