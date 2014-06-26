var data_name = new Array("当年本地区农村净迁入城镇人口占农村比例","当年外地区净迁入城镇人口","当年净迁入城镇人口","城镇生育率","城镇新生婴儿数","城镇死亡率","当年初城镇人口","当年末城镇人口","上年末城镇人口（城镇人口模型得到的结果）","劳动参与率","--上年末城镇经济活动人口","失业率","--上年城镇就业人口","上年末城镇未参保职工人数","当年新增参保率(新增参保人员)","当年年初参保人数","当年退休率","--当年新增退休人员","参保职工死亡率（死亡率）","--当年新增参保职工","--当年年末参保职工人数","??职工缴费工资","个人帐户空账缴费比例(？？)","统筹基金缴费比例（收入相关参数）","--参保职工征缴收入","基金征缴率(收入相关参数)","当年外地区净迁入农村人口","--当年净迁入农村人口","农村生育率","农村死亡率","当年初农村人口","--当年末农村人口","--上年末农村人口（迭代后的结果）","--城镇自由职业者","当年个人参保率（新增参保人员）","--灵活就业人口数","？？农民工缴费工资","--参保农民工征缴收入","财政补助","？？利息收入","其他收入??","--统筹基金总收入","？？个人账户实帐缴费比例","--单位参保职工缴费收入","--灵活就业人员缴费收入","--个人账户缴费收入","--实帐个人账户基金总收入","养老基金总收入","起始年平均空账余额","当年缴费工资占上年社平均工资比例（缴费工资比例）","缴费年限","??上年社会平均工资","空帐记账率（支出参数）","--平均个人账户空帐余额","？？计发月数","--个人账户空帐支出","起始年缴费工资基数","--平均缴费工资指数","--指数化平均工资","--基础性养老金支出","过渡年限","过渡系数","--过渡性养老金支出","实帐记账率","--个人账户实帐长寿支出","--统筹基金养老金支出","丧葬费","其他支出","--统筹基金养老金总支出","单位参保职工实帐养老金","单位退休人员数","--单位参保职工实帐养老金支出","个人参保人员实帐养老金","个人参保退休人数（人数情况）","--个人参保人员实帐养老金支出","--实帐个人账户基金总支出");
var data_code = new Array("localCountryToTown","outsideToTown","toTown","townFertilityRate","townNewBaby","townDieRate","currentTownPopulation","currentEndTownPopulation","lastEndTownPopulation","laborParticipationRate","currentLaborPopulation","unemploymentRate","townEmploymentPopulation","townNoInsuredPopulation","currentNewInsuredRate","currentInsuredPopulation","currentTownRetireRate","currentNewRetirePopulation","insuredDieRate","currentNewInsuredPopulation","currentEndInsuredPopulation","paySalary","personalEmptyAccountPaymentRate","coordinationFundPaymentRate","insuredCollectionIncome","fundPaymentRate","outsideToCountry","toCountryPopulation","countryFertilityRate","countryDieRate","currentCountryPopulation","currentEndCountryPopulation","lastEndcountryPopulation","townFreeworkPopulation","currentPersonalInsuredRate","freeworkPopulation","peasantPayment","insuredPeasantPaymentIncome","allowance","interestIncome","restIncome","coordinationFundTotalIncome","personalRealAccountPaymentRate","insuredPaymentIncome","freeworkPaymentIncome","personalAccountPaymentIncome","personalAccountFundTotalIncome","fundTotalIncome","currentAverageBalance","paymentSalaryRate","paymentAgeLimit","lastAverageSalary","emptyAccountRate","averagePersonalEmptyBalance","planMonths","personalEmptyPay","currentPaymentSalaryCardinality","averagePaymentSalaryIndex","indexAverageSalary","foundationAnnuityPay","excessiveAgeLimit","excessiveCoefficient","excessiveAnnuityPay","realAccountRate","personalAccountLongevityPay","coordinationFundAnnuityPay","funeralPay","restPay","coordinationFundAnnuityTotalPay","insuredAnnuity","retirePopulation","insuredAnnuityPay","personalInsuredAnnuity","personalRetirePopulation","personalInsuredAnnuityPay","personalAccountFundTotalPay");
$(document).ready(function(e) {
    for(var i =0;i<data_name.length;++i)
	{
		var data_span = "<span class=\"data_span\" id=\""+data_code[i]+"_data"+"\" onclick=\"SpanClick(this)\" >"+data_name[i]+"</span>";
		$("#data_board").append(data_span);
	}
});

function SpanClick(e){
	if($(e).css("color") == "rgb(0, 0, 0)")
		$(e).css("color","white");
	else
		$(e).css("color","black");
}

function DataChoose(){
	for(var i = 0;i<$("#data_board span").length;++i)
	{
		if($("#data_board span:eq("+i+")").css("color") == "rgb(255, 255, 255)")
		{
			var data = 	$("#data_board span:eq("+i+")").attr("id").split("_");
			var data_span = "<span id=\""+data[0]+"_cdata"+"\" class=\"newdata_span\" onclick=\"CSpanClick(this)\" >"+$("#data_board span:eq("+i+")").text()+"</span>";
			$("#cdata_board").append(data_span);
			$("#data_board span:eq("+i+")").css("color","black");
		}
	}
}

function DataCancel(){
	for(var i = 0;i<$("#data_board span").length;++i)
	{
		$("#data_board span:eq("+i+")").css("color","black");
	}
}

function CSpanClick(e){
	if($(e).css("color") == "rgb(0, 0, 0)")
	{
		var text =$(e).attr("id").split("_");
		$("#model_fromu").text($("#model_fromu").text() + text[0])  ;
		$(e).css("color","white");
	}
}

function CaulButton(e){
	var cal = $(e).attr("id");
	switch (cal){
		case "left_paren":
		$("#model_fromu").text($("#model_fromu").text() + "(")  ;
		break;	
		case "right_paren":
		$("#model_fromu").text($("#model_fromu").text() + ")")  ;
		break;	
		case "add_cal":
		$("#model_fromu").text($("#model_fromu").text() + "+")  ;
		break;	
		case "redu_cal":
		$("#model_fromu").text($("#model_fromu").text() + "-")  ;
		break;
		case "multi_cal":
		$("#model_fromu").text($("#model_fromu").text() + "*")  ;
		break;	
		case "divi_cal":
		$("#model_fromu").text($("#model_fromu").text() + "/")  ;
		break;	
		default:
		break;
	}
}

function AddModel(){
	var modelname=$("#model_name").val();
	var modeldetail = $("#model_detail").val();	
	var modelformu = $("#model_fromu").text();
	var modelkind = $("#model_kind").val();
	if(modelname=="")
		alert("输入名字");
	else if(modeldetail=="")
		alert("输入说明");
	else if(modelformu=="")
		alert("输入公式");
	else{
		$.post('/SmartSocialSecurity/modelInfo',{'action':2,'modelname':modelname,'modeldetail':modeldetail,'modelformu':modelformu,'modelkind':modelkind},function(data){
			var infodata = eval("(" + data + ")");
			if(infodata.succeed == 1)
				alert("添加成功");
			else
				alert("添加失败");
		});
	}
}