// JavaScript Document
var model_arry = new Array("AccountLongevityPay","ExcessivePay","FoundationPay","EmptyPay","Town","Country","FundIncome","AccountPay","TotalPay","PaymentPopulation");
var model_arr = new Array(11);
var pointer = 0;
function QueryModel(e)
{
	$(e).css("background-image","url(img/actuaryAnalysis/button-edit-hover.png)");
	
	if(!($("#new_div").length>0)){
		var top = parseInt($(e).css("top"))+34+"px";
		var left = $(e).css("left");
		var kind = $(e).val();
		for(var i = 0;i<11;++i)
		{
			if(kind == model_arry[i])
				pointer = i;
		}
		var new_div="<div id=\"new_div\" style=\"position:absolute;top:"+top+";left:"+left+";padding-top:2px;width:142px\"><div style=\"border-radius:5px;background-color:#535353;height:90px;padding-top:5px; overflow:auto\">";
		$.post('/SmartSocialSecurity/modelInfo',{'action':0,'modeltype':kind},function(data){
			var infodata = eval("(" + data + ")");
			$.each(infodata.model,function(index,entry){
				new_div = new_div+"<button value=\""+entry.modelid+"\"  class=\"model_choose_button\" onclick= \"ModelDeClick(this)\"  >"+model_arry[index]+"</button>";
			});
			new_div = new_div+"</div></div>";
			$("#model_board button:last").after(new_div);
		});
	}
}

function ModelDeClick(e)
{
	var modelid = $(e).val();
	model_arr[pointer] = modelid;
}
function ModelDown()
{
	$("#new_div").remove();
	for(var i = 0; i<10 ; i++){
		var img = $("#model_board button:eq("+i+")").css("background-image").split("-");
		var a = $("#model_board button:eq("+i+")").val();
		if(img[img.length-1]=="hover.png)"&&$("#model_board button:eq("+i+")").val()=="" )
			$("#model_board button:eq("+i+")").css("background-image","url(img/actuaryAnalysis/button-addModel.png)");
		else if(img[img.length-1]=="hover.png)"&&$("#model_board button:eq("+i+")").val()!="")
			$("#model_board button:eq("+i+")").css("background-image","url(img/actuaryAnalysis/button-edit.png)");
	}
}