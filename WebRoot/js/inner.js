// JavaScript Document
// JavaScript Document
$(document).ready(function(e) {
	var arr = new Array("用户1","用户1","用户1","用户1","用户1","用户1","用户2","用户2","用户2","用户2","用户3","用户3","用户3","用户3","用户3");
	var arr1 = new Array("120","100","90","110","100","90","120","110","90","100","820","820","820","820","820");
	var arr2 = new Array("2013/10","2013/9","2013/8","2013/7","2013/6","2013/5","2013/10","2013/9","2013/8","2013/7","2013/10","2013/9","2013/8","2013/7","2013/6");
	var arr3 = new Array("002","002","002","002","002","002","003","003","003","003","000","000","000","000","000");
	var arr4 = new Array("收入","收入","收入","收入","收入","收入","收入","收入","收入","收入","支出","支出","支出","支出","支出");
	for(var i = 0;i<15;++i){
		var newRow = "<tr><td style=\"background-color:#2e75b4\">"+(i+1)+"</td><td>"+arr[i]+"</td><td>"+arr1[i]+"</td><td>"+arr2[i]+"</td><td>"+arr3[i]+"</td><td>"+arr4[i]+"</td></tr>";
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

function check(){
	var name =$("#user_name").val();
	switch(name){
		case '001':
		$("#u_name").text('黄磊');
		break;
		case '002':
		$("#u_name").text('陈东');
		break;
		case '003':
		$("#u_name").text('程逸蒙');
		break;
		case '004':
		$("#u_name").text('吕琳洁');
		break;
		case '005':
		$("#u_name").text('范焘');
		break;
		default:
		$("#u_name").text("用户"+$("#user_name").val());
		break;
	}		
}

function getinclick(){
	$("#getin").css("visibility","hidden");	
}

function getoutclick(){
	$("#getin").css("visibility","visible");	
}
