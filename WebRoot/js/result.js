// JavaScript Document
var modeltype = new Array("Country","Town","PaymentPopulationOne","PaymentPopulationTwo","AccountIncome","FundIncome","AccountPay","EmptyPay","FoundationPay","ExcessivePay","AccountLongevityPay","TotalPay");
var modelname = new Array("上年末农村人口","上年末城镇人口","当年年末参保职工人数","城镇自由职业者","实帐个人账户基金总收入","统筹基金总收入","实帐个人账户基金总支出","个人账户空帐支出","基础性养老金支出","过渡性养老金支出","个人账户实帐长寿支出","统筹基金养老金总支出");
require.config({
			paths:{ 
				echarts:'./js/echarts',
				'echarts/chart/bar' : './js/echarts',
				'echarts/chart/line': './js/echarts'
			}
		});
function RusultData(mname,mdata){
	this.name = mname;
	this.data = mdata;
}
$(document).ready(function(e) {
	var dataone = new Array();
	var datatwo = new Array();
	var ruyears = new Array();
	$.post("/SmartSocialSecurity/modelInfo",{'action':6},function(data){
		var redata = eval("(" + data + ")");
		$.each(redata.result,function(index,entry){
			var type = entry.modeltype;
			var result = new RusultData(entry.modelname,(entry.data).split("-"));
			var cutlong;
			for(var i =0;i<result.data.length;++i)
			{
				var dataarrr = result.data[i].split('.');
				if(i == 0)
					{
						result.data[i] = result.data[i].substring(0,6);
						cutlong = dataarrr[0].length - result.data[i].length;
					}
				else
					result.data[i] = result.data[i].substring(0,dataarrr[0].length - cutlong);
			}
			for(var i =0;i<12;++i)
			{
				if(type == (modeltype[i]+"One"))
				{
					dataone[i] = result;
					break;	
				}
				else if(type == (modeltype[i]+"Two"))
				{
					datatwo[i] = result;
					break;	
				}
			}
		});
	//});
		for(var i = 0;i<dataone[0].data.length;++i)
			ruyears[i] = "第"+(i+1)+"年";
		var a = 0;
		for(var i = 0;i<12;++i)
		{
			var table = "<div id=\"table"+i+"\" style=\"border:1px solid #ccc;width:700px;height:420px; opacity:0.8; float:left\"></div>"	
			$("#tables").append(table);
			require(
			[
				'echarts',
				'echarts/chart/bar',
				'echarts/chart/line'
			],
			function(ec) {				
				var myChart = ec.init(document.getElementById("table"+a));
				option = {
					title:{
						text:modelname[a]
					},
					tooltip : {
						trigger: 'axis'
					},
					legend: {
						 data:[dataone[a].name,datatwo[a].name+"0"]
					},
					toolbox: {
						show : true,
						feature : {
							mark : false,
							dataView : {readOnly: false},
							magicType:['line', 'bar'],
							restore : true,
							saveAsImage : true
						}
					},
					calculable : true,
					xAxis : [
						{
							type : 'category',
							boundaryGap : false,
							data : ruyears
						}
					],
					yAxis : [
						{
							type : 'value',
							splitArea : {show : true}
						}
					],
					series : [
									
						{
							name:dataone[a].name,
							type:'line',
							itemStyle: {
								normal: {
									lineStyle: {
										shadowColor : 'rgba(0,0,0,0.4)'
									}
								}
							},
							data:dataone[a].data
						},
						{
							name:datatwo[a].name+"0",
							type:'line',
							itemStyle: {
								normal: {
									lineStyle: {
										shadowColor : 'rgba(0,0,0,0.4)'
									}
								}
							},
							data:datatwo[a].data
						}
					]
				};
				a++;
				
				myChart.setOption(option);
			}
		 );
		}
	});
});