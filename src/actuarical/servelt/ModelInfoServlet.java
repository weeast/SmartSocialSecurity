package actuarical.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import actuarical.dao.ModelInfoDao;
import actuarical.dao.ModelInfoDaoImp;
import actuarical.model.ActuaryResult;
import actuarical.model.ModelInfo;

public class ModelInfoServlet extends HttpServlet {
	
	private int action = -1 ;
	private ModelInfo modelInfo = null ;
	private ModelInfoDao modelInfoDao = null ;
	private ModelInfoDaoImp modelInfoDaoImp = null ;
	private String modelCategory = "" ;   //模型类别
	private List<ModelInfo> modelInfoList = null ;
	private String modelName = "" ;
	private String modelId = "" ;
	
	
	public ModelInfoServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		action = Integer.parseInt(request.getParameter("action")) ;
		if(action==-1){
			System.out.println("error") ;
		}
		if(action==0){		//21：分类查询模型（返回某类别的所有模型）josn
			modelCategory = request.getParameter("modeltype") ;
			modelInfoDao = new ModelInfoDao() ;
			modelInfoList = modelInfoDao.categoryQueryModel(modelCategory) ;
			String outModelInfoList = "" ;
			if(modelInfoList!=null){
				outModelInfoList = "{\"succeed\":" + 1 + ",\"model\":[" ;
				for(int i=0;i<modelInfoList.size();i++){
					outModelInfoList = outModelInfoList + "{\"modelname\":\"" + modelInfoList.get(i).getModelName() + 
								"\",\"modelid\":\"" + modelInfoDao.queryModelId(modelInfoList.get(i).getModelName())+ "\"}";
					if(i<modelInfoList.size()-1){
						outModelInfoList = outModelInfoList + "," ;
					}
				}
				outModelInfoList = outModelInfoList + "]}" ; 
			}
			out.print(outModelInfoList) ;
		}
		if(action==1){      //22：查询模型细节
			modelId = request.getParameter("modelid") ;
			modelInfo = modelInfoDao.queryModelInfo(modelId) ;
			if(modelInfo!=null){
				String modelInfoStr = "{\"succeed\":" + 1 + ",\"model\":[" + "{\"modelname\":\"" + modelInfo.getModelName() +
						"\",\"modelformula\":\"" + modelInfo.getModelFormula()+
						"\",\"modeldetail\":\"" + modelInfo.getModelExplain() +
						"\",\"modelin\":\"" + modelInfo.getModelOutput() +
						"\",\"modelout\":\"" + modelInfo.getModelOutput() + "\"}]}" ;
				out.print(modelInfoStr) ;
			}else{
				out.print("{\"succeed\":0}") ;
			}
		}
		if(action==2){		//23：添加模型
			modelInfoDao = new ModelInfoDao() ;
			modelInfo = new ModelInfo() ;
			
			modelInfo.setModelName(request.getParameter("modelname")) ;
			modelInfo.setModelExplain(request.getParameter("modeldetail")) ;
			modelInfo.setModelFormula(request.getParameter("modelformu")) ;
			modelInfo.setModelCategory(request.getParameter("modelkind")) ;
			modelInfo.setModelInput("input") ;
			modelInfo.setModelOutput("output") ;
			
			boolean temp = modelInfoDao.saveModelInfo(modelInfo) ;
			if(temp){
				out.print("{\"succeed\":1}") ;
			}else{
				out.print("{\"succeed\":0}") ;
			}
		}
		if(action==3){		//24：模型对比
			int year = Integer.parseInt(request.getParameter("years")) ;
			modelInfoDao = new ModelInfoDao() ;
			String modelId1 = request.getParameter("Country_one") ;   	//农村人口模型
			String modelId2 = request.getParameter("Town_one") ;	//城镇人口模型
			String modelId3 = request.getParameter("PaymentPopulation_one") ;	//缴费人口模型
			String modelId4 = request.getParameter("AccountIncome_one") ;	//实帐账户收入模型
			String modelId5 = request.getParameter("FundIncome_one") ;	//养老金收入模型
			String modelId6 = request.getParameter("AccountPay_one") ;	//实帐账户支出模型
			String modelId7 = request.getParameter("EmptyPay_one") ;	//个人账户空帐支出
			String modelId8 = request.getParameter("FoundationPay_one") ;	//基础养老金支出
			String modelId9 = request.getParameter("ExcessivePay_one") ;	//过渡性养老金支出
			String modelId10 = request.getParameter("AccountLongevityPay_one") ;	//个人账户实帐长寿支出
			String modelId11 = request.getParameter("TotalPay_one") ; ;	//统筹基金支出模型
			
			
			String modelId12 = request.getParameter("Country_two") ;   	//农村人口模型
			String modelId22 = request.getParameter("Town_two") ;	//城镇人口模型
			String modelId32 = request.getParameter("PaymentPopulation_two") ;	//缴费人口模型
			String modelId42 = request.getParameter("AccountIncome_two") ;	//实帐账户收入模型
			String modelId52 = request.getParameter("FundIncome_two") ;	//养老金收入模型
			String modelId62 = request.getParameter("AccountPay_two") ;	//实帐账户支出模型
			String modelId72 = request.getParameter("EmptyPay_two") ;	//个人账户空帐支出
			String modelId82 = request.getParameter("FoundationPay_two") ;	//基础养老金支出
			String modelId92 = request.getParameter("ExcessivePay_two") ;	//过渡性养老金支出
			String modelId102 = request.getParameter("AccountLongevityPay_two") ;	//个人账户实帐长寿支出
			String modelId112 = request.getParameter("TotalPay_two") ; ;	//统筹基金支出模型
			
			List<String> modelIdList1 = new ArrayList<String>() ;
			List<String> modelIdList2 = new ArrayList<String>() ;
			
			modelIdList1.add(modelId1) ;
			modelIdList1.add(modelId2) ;
			modelIdList1.add(modelId3) ;
			modelIdList1.add(modelId4) ;
			modelIdList1.add(modelId5) ;
			modelIdList1.add(modelId6) ;
			modelIdList1.add(modelId7) ;
			modelIdList1.add(modelId8) ;
			modelIdList1.add(modelId9) ;
			modelIdList1.add(modelId10) ;
			modelIdList1.add(modelId11) ;
			
			modelIdList2.add(modelId12) ;
			modelIdList2.add(modelId22) ;
			modelIdList2.add(modelId32) ;
			modelIdList2.add(modelId42) ;
			modelIdList2.add(modelId52) ;
			modelIdList2.add(modelId62) ;
			modelIdList2.add(modelId72) ;
			modelIdList2.add(modelId82) ;
			modelIdList2.add(modelId92) ;
			modelIdList2.add(modelId102) ;
			modelIdList2.add(modelId112) ;
			
			List<List<ActuaryResult>> modelInfoList = modelInfoDao.comparisonModelInfo(modelIdList1, modelIdList2,year) ;
			HttpSession session = request.getSession(true); 
			session.setAttribute("modelInfoList", modelInfoList) ;
			session.setAttribute("modelName1", modelInfoDao.queryModelName(modelId1)) ;
			session.setAttribute("modelName2", modelInfoDao.queryModelName(modelId2)) ;
			session.setAttribute("modelName3", modelInfoDao.queryModelName(modelId3)) ;
			session.setAttribute("modelName4", modelInfoDao.queryModelName(modelId4)) ;
			session.setAttribute("modelName5", modelInfoDao.queryModelName(modelId5)) ;
			session.setAttribute("modelName6", modelInfoDao.queryModelName(modelId6)) ;
			session.setAttribute("modelName7", modelInfoDao.queryModelName(modelId7)) ;
			session.setAttribute("modelName8", modelInfoDao.queryModelName(modelId8)) ;
			session.setAttribute("modelName9", modelInfoDao.queryModelName(modelId9)) ;
			session.setAttribute("modelName10", modelInfoDao.queryModelName(modelId10)) ;
			session.setAttribute("modelName11", modelInfoDao.queryModelName(modelId11)) ;
			
			session.setAttribute("modelName12", modelInfoDao.queryModelName(modelId12)) ;
			session.setAttribute("modelName22", modelInfoDao.queryModelName(modelId22)) ;
			session.setAttribute("modelName32", modelInfoDao.queryModelName(modelId32)) ;
			session.setAttribute("modelName42", modelInfoDao.queryModelName(modelId42)) ;
			session.setAttribute("modelName52", modelInfoDao.queryModelName(modelId52)) ;
			session.setAttribute("modelName62", modelInfoDao.queryModelName(modelId62)) ;
			session.setAttribute("modelName72", modelInfoDao.queryModelName(modelId72)) ;
			session.setAttribute("modelName82", modelInfoDao.queryModelName(modelId82)) ;
			session.setAttribute("modelName92", modelInfoDao.queryModelName(modelId92)) ;
			session.setAttribute("modelName102", modelInfoDao.queryModelName(modelId102)) ;
			session.setAttribute("modelName112", modelInfoDao.queryModelName(modelId112)) ;
			
			if(modelInfoList!=null){
				out.print("{\"succeed\":" + 1 + "}") ;
			}else{
				out.print("{\"succeed\":" + 0 + "}");
			}
		}
		if(action==4){   //21：分类查询模型（返回某类别的所有模型）jsp
			modelCategory = request.getParameter("modeltype") ;
			modelInfoDao = new ModelInfoDao() ;
			modelInfoList = modelInfoDao.categoryQueryModel(modelCategory) ;
			//request.setAttribute("modelInfoList", modelInfoList) ;
			HttpSession session = request.getSession(true); 
			session.setAttribute("modelInfoList", modelInfoList) ;
			//request.getRequestDispatcher("/modeldetail.jsp").forward(request, response);
			//RequestDispatcher requestDispatcher = request.getRequestDispatcher("modeldetail.jsp");
			//requestDispatcher.forward(request, response);
			//response.sendRedirect("modeldetail.jsp");
			if(modelInfoList!=null){
				out.print("{\"succeed\":" + 1 + "}") ;
			}else{
				out.print("{\"succeed\":" + 0 + "}");
			}
		}
		if(action==5){	//分类查询模型 第二次请求
			HttpSession session = request.getSession(true); 
			List<ModelInfo> list = (List<ModelInfo>)session.getAttribute("modelInfoList") ;
			String outModelInfoList = "" ;
			if(list!=null){
				outModelInfoList = "{\"succeed\":" + 1 + ",\"model\":[" ;
				for(int i=0;i<list.size();i++){
					outModelInfoList = outModelInfoList + "{\"modelname\":\"" + list.get(i).getModelName() + 
								"\",\"modelid\":\"" + modelInfoDao.queryModelId(list.get(i).getModelName())+ "\"}"; ;
				}
				outModelInfoList = outModelInfoList + "]}" ; 
			}
			out.print(outModelInfoList) ;
		}
		if(action==6){
			HttpSession session = request.getSession(true); 
			List<List<ActuaryResult>>  list = (List<List<ActuaryResult>>)session.getAttribute("modelInfoList") ;
			int yearNum = list.get(0).size() ;
			String result = "" ;
			result = "{\"succeed\":" + 1 + ",\"result\":[" ;
			//农村人口1
			result = result + "{\"modeltype\":\""+ "CountryOne" +"\",\"modelname\":\"" + session.getAttribute("modelName1") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(0).get(i).getLastEndcountryPopulation()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//城镇人口1
			result = result + "{\"modeltype\":\""+ "TownOne" +"\",\"modelname\":\"" + session.getAttribute("modelName2") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(0).get(i).getLastEndTownPopulation()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//缴费人口模型11
			result = result + "{\"modeltype\":\""+ "PaymentPopulationOneOne" +"\",\"modelname\":\"" + session.getAttribute("modelName3") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(0).get(i).getCurrentEndInsuredPopulation()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			//缴费人口模型12
			result = result + "{\"modeltype\":\""+ "PaymentPopulationOneTwo" +"\",\"modelname\":\"" + session.getAttribute("modelName3") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(0).get(i).getFreeworkPopulation()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//实帐账户收入模型1
			result = result + "{\"modeltype\":\""+ "AccountIncomeOne" +"\",\"modelname\":\"" + session.getAttribute("modelName4") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(0).get(i).getPersonalAccountFundTotalIncome()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//养老金收入模型1
			result = result + "{\"modeltype\":\""+ "FundIncomeOne" +"\",\"modelname\":\"" + session.getAttribute("modelName5") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(0).get(i).getFundTotalIncome()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//实帐账户支出模型1
			result = result + "{\"modeltype\":\""+ "AccountPayOne" +"\",\"modelname\":\"" + session.getAttribute("modelName6") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(0).get(i).getPersonalAccountFundTotalPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//个人账户空帐支出1
			result = result + "{\"modeltype\":\""+ "EmptyPayOne" +"\",\"modelname\":\"" + session.getAttribute("modelName7") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(0).get(i).getPersonalEmptyPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//基础养老金支出1
			result = result + "{\"modeltype\":\""+ "FoundationPayOne" +"\",\"modelname\":\"" + session.getAttribute("modelName8") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(0).get(i).getFoundationAnnuityPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//过渡性养老金支出1
			result = result + "{\"modeltype\":\""+ "ExcessivePayOne" +"\",\"modelname\":\"" + session.getAttribute("modelName9") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(0).get(i).getExcessiveAnnuityPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//个人账户实帐长寿支出1
			result = result + "{\"modeltype\":\""+ "AccountLongevityPayOne" +"\",\"modelname\":\"" + session.getAttribute("modelName10") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(0).get(i).getPersonalAccountLongevityPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//统筹基金支出模型1
			result = result + "{\"modeltype\":\""+ "TotalPayOne" +"\",\"modelname\":\"" + session.getAttribute("modelName11") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(0).get(i).getAnnuityTotalPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			
			//农村人口2
			result = result + "{\"modeltype\":\""+ "CountryTwo" +"\",\"modelname\":\"" + session.getAttribute("modelName12") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(1).get(i).getLastEndcountryPopulation()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//城镇人口2
			result = result + "{\"modeltype\":\""+ "TownTwo" +"\",\"modelname\":\"" + session.getAttribute("modelName22") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(1).get(i).getLastEndTownPopulation()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//缴费人口模型21
			result = result + "{\"modeltype\":\""+ "PaymentPopulationTwoOne" +"\",\"modelname\":\"" + session.getAttribute("modelName32") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(1).get(i).getCurrentEndInsuredPopulation()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			//缴费人口模型22
			result = result + "{\"modeltype\":\""+ "PaymentPopulationTwoTwo" +"\",\"modelname\":\"" + session.getAttribute("modelName32") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(1).get(i).getFreeworkPopulation()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//实帐账户收入模型2
			result = result + "{\"modeltype\":\""+ "AccountIncomeTwo" +"\",\"modelname\":\"" + session.getAttribute("modelName42") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(1).get(i).getPersonalAccountFundTotalIncome()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//养老金收入模型2
			result = result + "{\"modeltype\":\""+ "FundIncomeTwo" +"\",\"modelname\":\"" + session.getAttribute("modelName52") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(1).get(i).getFundTotalIncome()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//实帐账户支出模型2
			result = result + "{\"modeltype\":\""+ "AccountPayTwo" +"\",\"modelname\":\"" + session.getAttribute("modelName62") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(1).get(i).getPersonalAccountFundTotalPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//个人账户空帐支出2
			result = result + "{\"modeltype\":\""+ "EmptyPayTwo" +"\",\"modelname\":\"" + session.getAttribute("modelName72") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(1).get(i).getPersonalEmptyPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//基础养老金支出2
			result = result + "{\"modeltype\":\""+ "FoundationPayTwo" +"\",\"modelname\":\"" + session.getAttribute("modelName82") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(1).get(i).getFoundationAnnuityPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//过渡性养老金支出2
			result = result + "{\"modeltype\":\""+ "ExcessivePayTwo" +"\",\"modelname\":\"" + session.getAttribute("modelName92") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(1).get(i).getExcessiveAnnuityPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//个人账户实帐长寿支出2
			result = result + "{\"modeltype\":\""+ "AccountLongevityPayTwo" +"\",\"modelname\":\"" + session.getAttribute("modelName102") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(1).get(i).getPersonalAccountLongevityPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}," ;
			
			//统筹基金支出模型2
			result = result + "{\"modeltype\":\""+ "TotalPayTwo" +"\",\"modelname\":\"" + session.getAttribute("modelName112") + "\",\"data\":\"" ;
			for(int i=0;i<yearNum;i++){
				result = result + new BigDecimal(list.get(1).get(i).getAnnuityTotalPay()).toPlainString() ;
				if(i!=yearNum-1){
					result = result + "-" ;
				}
			}
			result = result + "\"}]}" ;
			out.print(result) ;
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
