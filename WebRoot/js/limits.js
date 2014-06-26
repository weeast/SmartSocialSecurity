// JavaScript Document
$(document).ready(function(e) {
	var retdata;
    $.post('/SmartSocialSecurity/adminInfo',{'action':8},function(data){
		retdata = eval("(" + data + ")");
		$("#total_page").val(((retdata.length)/15+1));
		$.each(retdata.account,function(index,entry){
			if(index < 15)
			{
				var newRow = "<tr><td style=\"background-color:#2e75b4;color:white\">"+(index+1)+"</td><td>"+entry.accountnum+"</td><td>"+entry.accountname+"</td><td>"+entry.accountplace+"</td><td>"+entry.accountapart+"</td><td><span style=\"cursor:pointer\" onclick=\"window.open('limitchange.html','_self');\">查看</span></td></tr>";
				$("#list_table tr:last").after(newRow);
			}
		});
		$("#list_table tbody tr:odd").css("background-color","#dcecf6");
	   	$("#list_table tbody tr:even").css("background-color","#9cc3e7");
		$("#list_table tr:first").css("background-color","#3a3939");
	});	
});

function PageChange(e){
	var page = $(e).val();
	for(var i=1;i<16;i++)
		$("#list_table tr:eq(1)").remove();
		if(page == "首页")
		{
			var retdata;
			$.post('/SmartSocialSecurity/adminInfo',{'action':8},function(data){
			retdata = eval("(" + data + ")");
			$.each(retdata.account,function(index,entry){
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
			$.post('/SmartSocialSecurity/adminInfo',{'action':8},function(data){
				retdata = eval("(" + data + ")");
				$.each(retdata.account,function(index,entry){
					if(index>=(15*(moment-2))&&index < (15*(moment-1)))
					{
						var newRow = "<tr><td style=\"background-color:#2e75b4\">"+(i+1)+"</td><td>"+entry.accountnum+"</td><td>"+entry.accountname+"</td><td>"+entry.accountplace+"</td><td></td><td>"+entry.accountapart+"</td><td><span style=\"cursor:pointer\" onclick=\"window.open('limitchange.html','_self');\">查看</span></td></tr>";
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
			$.post('/SmartSocialSecurity/adminInfo',{'action':8},function(data){
				retdata = eval("(" + data + ")");
				$.each(retdata.account,function(index,entry){
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
		$.post('/SmartSocialSecurity/adminInfo',{'action':8},function(data){
			retdata = eval("(" + data + ")");
			$.each(retdata.account,function(index,entry){
				if(index>=(15*(retdata.lenght-1))&&index < (15*retdata.lenght))
				{
					var newRow = "<tr><td style=\"background-color:#2e75b4\">"+(i+1)+"</td><td>"+entry.accountnum+"</td><td>"+entry.accountname+"</td><td>"+entry.accountplace+"</td><td></td><td>"+entry.accountapart+"</td><td><span style=\"cursor:pointer\" onclick=\"\">查看</span></td></tr>";
					$("#list_table tr:last").after(newRow);
				}
			});
		});	
	}
}
