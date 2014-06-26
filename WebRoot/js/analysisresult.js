// JavaScript Document
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
	var ruyears = new Array();
	$.post("/SmartSocialSecurity/actuaryInfo",{'action':2},function(data){
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
				if(type == modeltype[i]){
					dataone[i] = result;
					break;
				}
			}
		});
	//});
		for(var i = 0;i<dataone[0].data.length;++i)
			ruyears[i] = "第"+(i+1)+"年";
		var a = 0;
		for(var i = 0;i<5;++i)
		{
			var table = "<div id=\"table"+i+"\" style=\"border:1px solid #ccc;width:700px;height:420px; opacity:0.8; float:left\"></div>"	
			$("#tables").append(table);
		}
		require(
		[
			'echarts',
			'echarts/chart/bar',
			'echarts/chart/line'
		],
		function(ec) {				
			var myChart = ec.init(document.getElementById("table4"));
			option = {
				title:{
					text:"人口分布"
				},
				tooltip : {
					trigger: 'axis'
				},
					legend: {
					 data:["上年末农村人口","上年末城镇人口"]
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
						name:"上年末农村人口",
						type:'line',
						stack: '总量',
						data:dataone[0].data
					},
					{
						name:"上年末城镇人口",
						type:'line',
						stack: '总量',
						data:dataone[1].data
					}
				]
			};
			
			myChart.setOption(option);
		});  
		require(
		[
			'echarts',
			'echarts/chart/bar',
			'echarts/chart/line'
		],
		function(ec) {				
			var myChart = ec.init(document.getElementById("table3"));
			option = {
				title:{
					text:"在职人口分布"
				},
				tooltip : {
					trigger: 'axis'
				},
					legend: {
					 data:["当年年末参保职工人数","城镇自由职业者"]
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
						name:"当年年末参保职工人数",
						type:'line',
						smooth:true,
						itemStyle: {normal: {areaStyle: {type: 'default'}}},
						data:dataone[2].data
					},
					{
						name:"城镇自由职业者",
						type:'line',
						smooth:true,
						itemStyle: {normal: {areaStyle: {type: 'default'}}},
						data:dataone[3].data
					}
				]
			};
			
			myChart.setOption(option);
		});
		require(
		[
			'echarts',
			'echarts/chart/bar',
			'echarts/chart/line'
		],
		function(ec) {				
			var myChart = ec.init(document.getElementById("table2"));
			option = {
				title:{
					text:"实帐个人账户基金总收入"
				},
				tooltip : {
					trigger: 'axis'
				},
					legend: {
					 data:["实帐个人账户基金总收入"]
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
						name:"实帐个人账户基金总收入",
						type:'line',
						stack: '总量',
						data:dataone[4].data
					}
				]
			};
			
			myChart.setOption(option);
		});
		require(
		[
			'echarts',
			'echarts/chart/bar',
			'echarts/chart/line'
		],
		function(ec) {				
			var myChart = ec.init(document.getElementById("table1"));
			option = {
				title:{
					text:"支出分布"
				},
				tooltip : {
					trigger: 'axis'
				},
					legend: {
					 data:["实帐个人账户基金总支出","个人账户空帐支出","基础性养老金支出","过渡性养老金支出","个人账户实帐长寿支出"]
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
						name:"实帐个人账户基金总支出",
						type:'line',
						stack: '总量',
						itemStyle: {normal: {areaStyle: {
							color: 'rgba(255, 69, 0, 0.7)'
						}}},
						data:dataone[6].data
					},
					{
						name:"个人账户空帐支出",
						type:'line',
						stack: '总量',
						itemStyle: {normal: {areaStyle: {
							color: 'rgba(30, 144, 255, 0.6)'
						}}},
						data:dataone[7].data
					},
					{
						name:"基础性养老金支出",
						type:'line',
						stack: '总量',
						itemStyle: {normal: {areaStyle: {
							color: 'rgba(138, 43, 226, 0.5)'
						}}},
						data:dataone[8].data
					},
					{
						name:"过渡性养老金支出",
						type:'line',
						stack: '总量',
						itemStyle: {normal: {areaStyle: {
							color: 'rgba(34, 139, 34, 0.4)'
						}}},
						data:dataone[9].data
					},
					{
						name:"个人账户实帐长寿支出",
						type:'line',
						stack: '总量',
						itemStyle: {normal: {areaStyle: {
							color: 'rgba(220, 20, 60, 0.3)'
						}}},
						data:dataone[10].data
					}
				]
			};
			
			myChart.setOption(option);
		});  
		var remain = new Array();
		var giveout = new Array();
		for(var i =0;i<dataone[11].data.length;++i)
		{
			giveout[i] = 0 -(dataone[11].data)[i];
			remain[i] = parseInt((dataone[5].data)[i]) + parseInt(giveout[i]);
		}
		require(
		[
			'echarts',
			'echarts/chart/bar',
			'echarts/chart/line'
		],
		function(ec) {				
			var myChart = ec.init(document.getElementById("table0"));
			option = {
    				tooltip : {
						trigger: 'axis',
						axisPointer : {            
							type : 'shadow'        
						}
					},
					legend: {
						data:["统筹基金结余", "统筹基金养老金总支出", "统筹基金总收入"]
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
							type : 'value',
							splitArea: {show : true}
						}
					],
					yAxis : [
						{
							type : 'category',
							data : ruyears
						}
					],
					series : [
						{
							name:"统筹基金结余",
							type:'bar',
							itemStyle : { normal: {label : {show: true, position: 'inside'}}},
							data:remain
						},
						{
							name:"统筹基金总收入",
							type:'bar',
							stack: '总量',
							barWidth : 5,
							itemStyle: {normal: {
								color: 'rgba(138, 43, 226, 0.3)',
								label : {show: true}
							}},
							data:dataone[5].data
						},
						{
							name: "统筹基金养老金总支出", 
							type:'bar',
							stack: '总量',
							itemStyle: {normal: {
								color: 'rgba(30, 144, 255, 0.3)',
								label : {show: true, position: 'left'}
							}},
							data:giveout
						}
					]
				};
                    
			
			myChart.setOption(option);
		});  
	});
});