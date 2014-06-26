// JavaScript Document
$(document).ready(function(e) {
	var infodata;
	var limits;
	var menulistbuttons = new Array("selfinformation","fixPassword","account","limits","usersearch","outer","inner","search","add","compare","analysis","history","add");
	var iconbutton = new Array("icon-ActuarialAnalyst","icon-AddNew","icon-AuditDeclaration","icon-SearchUesr","icon-ViewModel","icon-AddNew");
	$.post('/SmartSocialSecurity/adminInfo',{'action':0},function(data){
		infodata = eval("(" + data + ")");
		$.each(infodata.user,function(index,entry){
			limits = entry.userlimit;
			$("#user_name").text(entry.username);
			$("#user_sex").text(entry.usersex);
			$("#user_place").text(entry.userplace);
			$("#user_work").text(entry.userwork);
			$("#user_acount").text(entry.useracount);
			$("#user_age").text(entry.userage);
			$("#user_apart").text(entry.userapart);	
			$("#user_pic").attr("src",entry.userpic);	
	});
		for(var h = 0 ;h<6;++h)
		{
			if(limits[h] == 1)
			{
				var logout = $("<button name=\""+menulistbuttons[h]+"\" class=\"icon_button\" style=\"background-image:url(img/homepage/"+iconbutton[h]+".png)\"></button>").appendTo($("#icon_buttons"));
				logout.hover(function(e) {
					var pic = $(this).css("background-image");
					var arr = new Array();
					arr = pic.split(".");
					pic = arr[0]+"-hover."+arr[1];
					$(this).css("background-image",pic); 
				},function(e){
					var pic = $(this).css("background-image");
					var arr = new Array();
					var arr1 = new Array();
					arr = pic.split(".");
					arr1 = arr[0].split("-");
					var num = arr1.length;
					var str;
					for (var a = 0;a<num;++a)
					{
						if(a==num-1)
						{
							str = str +"."+ arr[1];
						}
						else if(a==0)
						{
							str = arr1[a];
						}
						else
							str= str+"-"+arr1[a];
					}
					$(this).css("background-image",str); 
				});
				logout.click(function(e){
						var name = $(this).attr("name");
						window.open(name+".html","_self");
				});
			}
		}
	});
	
});