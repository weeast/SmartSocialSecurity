// JavaScript Document
$(document).ready(function(e) {
	var arr = new Array("黄磊","程逸蒙","陈东","吕琳洁","范焘","huanglei","chengyimeng","chendong","lvlinjie","fantao","张三","王大","陈二","李四","赵五");
	var arr1 = new Array("2013/6","2013/5","2013/10","2013/9","2013/10","2013/9","2013/8","2013/7","2013/8","2013/9","2013/8","2013/7","2013/6","2013/7","2013/10");
	var arr2 = new Array("江西","重庆","四川","四川","四川","江西","重庆","四川","四川","四川","江西","重庆","四川","四川","四川");
	var arr4 = new Array("30","10","3","8","7","8","7","30","10","3","3","8","7","30","10");
	for(var i = 0;i<15;++i){
		var newRow = "<tr><td style=\"background-color:#2e75b4\">"+(i+1)+"</td><td>"+"精算"+i+"</td><td>"+arr1[i]+"</td><td>"+arr2[i]+"</td><td>"+arr[i]+"</td><td>"+arr4[i]+"</td></tr>";
		$("#list_table tr:last").after(newRow);
	}
	$("#list_table tbody tr:odd").css("background-color","#dcecf6");
   	$("#list_table tbody tr:even").css("background-color","#9cc3e7");
	$("#list_table tr:first").css("background-color","#3a3939");
});
function PageChange(e){
	var page = $(e).val();
	for(var i=1;i<16;i++)
		$("#list_table tr:eq(1)").remove();
		if(page == "首页")
		{
			var retdata;
			$.post('/adminInfo',{'action':8},function(data){
			retdata = eval("(" + data + ")");
			$.each(infodata.account,function(index,entry){
				if(index < 15)
				{
					var newRow = "<tr><td style=\"background-color:#2e75b4\">"+(i+1)+"</td><td>"+entry.accountnum+"</td><td>"+entry.accountname+"</td><td>"+entry.accountplace+"</td><td></td><td>"+entry.accountapart+"</td><td><span style=\"cursor:pointer\" onclick=\"\">查看</span></td></tr>";
					$("#list_table tr:last").after(newRow);
				}
			});
		});		
	}
	else if(page == "上一页")
	{
		var moment =  ($("#moment_page").val()).parseInt();
		if(moment == 1)
		{
			var retdata;
			$.post('/adminInfo',{'action':8},function(data){
				retdata = eval("(" + data + ")");
				$.each(infodata.account,function(index,entry){
					if(index>=(15*(moment-2))&&index < (15*(moment-1)))
					{
						var newRow = "<tr><td style=\"background-color:#2e75b4\">"+(i+1)+"</td><td>"+entry.accountnum+"</td><td>"+entry.accountname+"</td><td>"+entry.accountplace+"</td><td></td><td>"+entry.accountapart+"</td><td><span style=\"cursor:pointer\" onclick=\"\">查看</span></td></tr>";
						$("#list_table tr:last").after(newRow);
					}
				});
			});
		}
	}
	else if(page == "下一页")
	{
		var moment =  ($("#moment_page").val()).parseInt();
		if(moment == retdata.lenght)
		{
			var retdata;
			$.post('/adminInfo',{'action':8},function(data){
				retdata = eval("(" + data + ")");
				$.each(infodata.account,function(index,entry){
					if(index>=(15*moment)&&index < (15*(moment+1)))
					{
						var newRow = "<tr><td style=\"background-color:#2e75b4\">"+(i+1)+"</td><td>"+entry.accountnum+"</td><td>"+entry.accountname+"</td><td>"+entry.accountplace+"</td><td></td><td>"+entry.accountapart+"</td><td><span style=\"cursor:pointer\" onclick=\"\">查看</span></td></tr>";
						$("#list_table tr:last").after(newRow);
					}
				});
			});	
		}	
	}
	else if(page == "末页")	
	{
		var retdata;
		$.post('/adminInfo',{'action':8},function(data){
			retdata = eval("(" + data + ")");
			$.each(infodata.account,function(index,entry){
				if(index>=(15*(retdata.lenght-1))&&index < (15*retdata.lenght))
				{
					var newRow = "<tr><td style=\"background-color:#2e75b4\">"+(i+1)+"</td><td>"+entry.accountnum+"</td><td>"+entry.accountname+"</td><td>"+entry.accountplace+"</td><td></td><td>"+entry.accountapart+"</td><td><span style=\"cursor:pointer\" onclick=\"\">查看</span></td></tr>";
					$("#list_table tr:last").after(newRow);
				}
			});
		});	
	}
}