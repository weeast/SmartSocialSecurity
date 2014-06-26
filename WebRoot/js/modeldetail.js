// JavaScript Document
var model_arry = new Array("AccountLongevityPay","ExcessivePay","FoundationPay","EmptyPay","Town","Country","FundIncome","AccountPay","TotalPay","PaymentPopulation");
$(document).ready(function(e) {
    if($("#model_detail").length>0)
	{
		$.post('/SmartSocialSecurity/modelInfo',{'action':5},function(data){
			var infodata = eval("(" + data + ")");
			$.each(infodata.model,function(index,entry){
				var button = "<button class=\"font_button\" value=\""+entry.modelid+"\" onclick=\"QueryModelDetail(this)\">农村人口模型1</button>";
				$("#model_buttons").append(button);
			});
		});
	}
});


function CheckOn(){
	$('#total_model').css('visibility','visible');	
}

function CheckOut(){
	$('#total_model').css('visibility','hidden');
}

function PmodelOn(){
	$('#Pmodel').css('visibility','visible');	
}

function PmodelOut(){
	$('#Pmodel').css('visibility','hidden');
}

function WmodelOn(){
	$('#Wmodel').css('visibility','visible');	
}

function WmodelOut(){
	$('#Wmodel').css('visibility','hidden');
}

function MultiModel(e){
	var div = "<div id=\"new_div\" style=\"float:left;width:400px;margin-top:8px\"><div style=\"float:left;width:120px; text-align:center;\"><button id=\"choose_button_two\" class=\"choose_button\" style=\"margin-top:50px\" onclick=\"ModelChoose(this)\"></button><button id=\"delete_button_two\" class=\"delete_button\" style=\"margin-top:10px\"></button></div><div id=\"model_two\" style=\"float:left;width:250px;height:165px;border:1px solid #7d7d7d; border-radius:5px; overflow:auto\"></button></div></div>";
	if(e.checked)
	{
		$("#choose_button_one").css("margin-top","50px");
		$("#model_one").css("height","165px");
		$("#model_board:last").after(div);
		if($("input:last").attr("checked"))
		{
			for(var i = 0;i<10;++i)
				$("#model_two").append("<button id=\""+model_arry[i]+"_two"+"\" class=\"model_button\" ></button>");
		}
		else
			$("#model_two").append("<button class=\"model_button\" ></button>"); 
	}
	else
	{
		$("#choose_button_one").css("margin-top","130px");
		$("#model_one").css("height","340px");
		$("#new_div").remove();
	}
}

function CompModel(e){
	$("#model_one button").remove();
	$("#model_two button").remove();
	if(e.checked)
	{
		for(var i = 0;i<10;++i)
		{
			$("#model_one").append("<button id=\""+model_arry[i]+"_one"+"\" class=\"model_button\" ></button>");
			if($("#model_two"))
				$("#model_two").append("<button id=\""+model_arry[i]+"_two"+"\" class=\"model_button\" ></button>");
		}
	}
	else
	{
		$("#model_one").append("<button class=\"model_button\" ></button>");
		if($("#model_two"))
		{
			$("#model_two button").remove();
			$("#model_two").append("<button class=\"model_button\" ></button>");
		}
	}
}

function QueryModel(e)
{
	var i = $("#model_buttons").css("background-color");
	$("#model_buttons button").remove();
	var kind = $(e).val();
	if(	$("#model_buttons").css("background-color") != "rgba(0, 0, 0, 0)"){
	$("#model_name").text(" ");
	$("#model_form").text(" ");
	$("#model_detail").text(" ");
	$("#model_in").text(" ");
	$("#model_out").text(" ");	
	}
	$.post('/SmartSocialSecurity/modelInfo',{'action':0,'modeltype':kind},function(data){
		var infodata = eval("(" + data + ")");
		$.each(infodata.model,function(index,entry){
			var button;
			if(	$("#model_buttons").css("background-color") != "rgba(0, 0, 0, 0)")
				button = "<button name=\""+$(e).val()+"\"  class=\"font_button\" value=\""+entry.modelid+"\" onclick=\"QueryModelDetail(this)\">"+entry.modelname+"</button>";
			else
			{
				button = "<button name=\""+$(e).val()+"\" class=\"font_button1\" value=\""+entry.modelid+"\" onclick=\"ModelButtonClick(this)\">"+$(e).val()+"1"+"</button>";
				
			}
			$("#model_buttons").append(button);
		});
	});
}

function ModelButtonClick(e)
{
	for(var i =0;i<$("#model_buttons button").length;++i)
	{
		if($("#model_buttons button:eq("+i+")").css("background-color") == "rgb(204, 204, 204)")
			$("#model_buttons button:eq("+i+")").css("background-color","rgb(170, 170, 170)");
	}
	$(e).css("background-color","#CCCCCC");
}

function QueryModelDetail(e)
{
	var kind = $(e).attr("name");
	var modeldid=$(e).val();	
	$.post('/SmartSocialSecurity/modelInfo',{'action':1,'modelid':modeldid},function(data){
		var infodata = eval("(" + data + ")");
			$.each(infodata.model,function(index,entry){
				$("#model_name").text("农村人口模型1");
				$("#model_form").text(entry.modelformula);
				$("#model_detail").text();
				$("#model_in").text(entry.modelin);
				$("#model_out").text(entry.modelout);	
			});
	});
}

function ModelChoose(e){
	var modelid;
	var modelname;
	var modelkind;
	for(var i =0;i<$("#model_buttons button").length;++i)
	{
		if($("#model_buttons button:eq("+i+")").css("background-color") == "rgb(204, 204, 204)")
		{
			modelid = 	$("#model_buttons button:eq("+i+")").val();
			modelname = $("#model_buttons button:eq("+i+")").text();
			modelkind = $("#model_buttons button:eq("+i+")").attr("name");
		}
	}
	var id ="_" + ($(e).attr("id").split("_"))[2];
	if($("#comp_check").attr("checked")){
		$("#"+modelkind+id).val(modelid);
		$("#"+modelkind+id).text(modelname);
	}
	else
	{
		$("#model"+id+" button").val(modelid);
		$("#model"+id+" button").text(modelname);
		$("#model"+id+" button").attr("name",modelkind);
	}
}

function TextModel(){
	var years = $("#text_year").val();
	var modeloneid = new Array(9,8,7,6,1,0,4,5,10,2);
	var modeltwoid = new Array(9,8,7,6,1,0,4,5,10,2);
	modeloneid[10] = 3;
	modeltwoid[10] = 3;
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
	$.post('/SmartSocialSecurity/modelInfo',{'action':3,'years':years,"AccountLongevityPay_one":modeloneid[0],"ExcessivePay_one":modeloneid[1],"FoundationPay_one":		modeloneid[2],"EmptyPay_one":modeloneid[3],"Town_one":modeloneid[4],"Country_one":modeloneid[5],"FundIncome_one":modeloneid[6],"AccountPay_one":modeloneid[7],"TotalPay_one":modeloneid[8],"PaymentPopulation_one":modeloneid[9],"AccountIncome_one":modeloneid[10],"AccountLongevityPay_two":modeltwoid[0],"ExcessivePay_two":modeltwoid[1],"FoundationPay_two":modeltwoid[2],"EmptyPay_two":modeltwoid[3],"Town_two":modeltwoid[4],"Country_two":modeltwoid[5],"FundIncome_two":modeltwoid[6],"AccountPay_two":modeltwoid[7],"TotalPay_two":modeltwoid[8],"PaymentPopulation_two":modeltwoid[9],"AccountIncome_two":modeltwoid[10]},function(data){
		var infodata = eval("(" + data + ")");
		if(infodata.succeed == 1)
			window.open("compareresult.html","_self") ;
	});	
}
