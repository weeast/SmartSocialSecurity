// JavaScript Document
$(document).ready(function(e) {
	for(var i = 0;i<15;++i){
    	var newRow = "<tr><td style=\"background-color:#2e75b4\">"+(i+1)+"</td><td></td><td></td><td></td><td></td><td></td></tr>";
		$("#list_table tr:last").after(newRow);
	}
	$("#list_table tbody tr:odd").css("background-color","#dcecf6");
   	$("#list_table tbody tr:even").css("background-color","#9cc3e7");
	$("#list_table tr:first").css("background-color","#3a3939");
});

function UpLoadTable()
{
	$("#table_src").click();
}

function GetResult()
{
	var years = $("#text_year").val();
	var modeloneid = new Array(9,8,7,6,1,0,4,5,10,2);
	
	modeloneid[10] = 3;
	/*if($("#comp_check").attr("checked")){
		for(var i = 0; i<10; ++i)
		{
			if($("#model_one button:eq("+i+")").val()=="");
			{
				alert("模型不完整");
				return;
			}
			modeloneid[i] = $("#model_one button:eq("+i+")").val();
			if($("#model_two"))
			{
				if($("#model_two button:eq("+i+")").val()=="")
				{
					alert("模型不完整");
					return;	
				}
				modeltwoid[i] = $("#model_two button:eq("+i+")").val();				
			}
			else
				modeltwoid[i] = "0";
		}	
	}*/
	$.post('/SmartSocialSecurity/actuaryInfo',{'action':0,'years':years,"AccountLongevityPay":modeloneid[0],"ExcessivePay":modeloneid[1],"FoundationPay":modeloneid[2],"EmptyPay":modeloneid[3],"Town":modeloneid[4],"Country":modeloneid[5],"FundIncome":modeloneid[6],"AccountPay":modeloneid[7],"TotalPay":modeloneid[8],"PaymentPopulation":modeloneid[9],"AccountIncome":modeloneid[10]},function(data){
		var infodata = eval("(" + data + ")");
		if(infodata.succeed == 1)
			window.open("analysisresult.html","_self") ;
	});	
}