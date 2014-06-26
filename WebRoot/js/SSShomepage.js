// JavaScript Document
$(document).ready(function(e) {
	var pp;
	var infodata;
	var name;
	var place;
	var limits;
	var onuselimit;
	var elements = new Array("AccountManagement","UserManagement","DataManagement","ModelManagement","ActuarialAnalyst");
	var menulistbuttons = new Array("selfinformation","fixPassword","account","limits","usersearch","outer","inner","search","add","compare","analysis","history","add");
	var iconbutton = new Array("icon-ActuarialAnalyst","icon-AddNew","icon-AuditDeclaration","icon-SearchUesr","icon-ViewModel","icon-AddNew");
	$.post('/SmartSocialSecurity/adminInfo',{'action':0},function(data){
		infodata = eval("(" + data + ")");
			$.each(infodata.user,function(index,entry){
				name = entry.username;
				place = entry.userplace;
				limits = entry.userlimit.split("");
				onuselimit = entry.useronuse.split("");
			});
			$("#user_name").text(name);
			$("#user_place").text(place);
			for(var h = 0 ;h<6;++h)
			{
				if(onuselimit[h] == 1)
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
						for (var i = 0;i<num;++i)
						{
							if(i==num-1)
							{
								str = str +"."+ arr[1];
							}
							else if(i==0)
							{
								str = arr1[i];
							}
							else
								str= str+"-"+arr1[i];
						}
						$(this).css("background-image",str); 
					});
					logout.click(function(e){
							var name = $(this).attr("name");
							$("#child_frame").attr("src",name+".html");
					});
				}
			}
			
			var num = 0;
			for(var i = 0;i<elements.length;++i)
			{
				for(var j = 0;j<4;++j){
					if(i==1&&j==1)
						break;
					else if(i==2&&j==2)
						break;
					else if(i==3&&j==3)
						break;
					else if(i==4&&j==2)
						break;
					else if(limits[num] == 1)
					{
						var button = $("<button id=\""+menulistbuttons[num]+"\" class=\"list_button\" style=\"background-image:url(img/menu/"+menulistbuttons[num]+".png)\"></button>").appendTo($("#"+elements[i]));
						button.hover(function(e){
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
							for (var i = 0;i<num;++i)
							{
								if(i==num-1)
								{
									str = str +"."+ arr[1];
								}
								else if(i==0)
								{
									str = arr1[i];
								}
								else
									str= str+"-"+arr1[i];
							}
							$(this).css("background-image",str); 
						});
						button.click(function(e) {
							$("#icon_buttons").css("width","0px");
							$("#icon_buttons").css("visibility","hidden");
							for(var i = 0;i<$("#menu_board button").length;++i)
							{
								if($("#menu_board button:eq("+i+")").attr("disabled") == "disabled" )
								{
									var pills = $("#menu_board button:eq("+i+")").attr("id").split("_");
									if(pills.length == 1)
									{
										$("#menu_board button:eq("+i+")").removeAttr("disabled");
										var pic = $("#menu_board button:eq("+i+")").css("background-image");
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
										$("#menu_board button:eq("+i+")").css("background-image",str); 
									}
								}
							}
							var id = $(this).attr("id");
							$(this).attr("disabled","disabled");
							var pic = $(this).css("background-image");
							var arr2 = new Array();
							arr = pic.split(".");
							pic = arr2[0]+"-hover."+arr2[1];
							$(this).css("background-image",pic); 
							$("#child_frame").attr("src",id+".html");
						});
						num++;
					}
				}			
			}
	});
});

function MenuClick(e){
	var id = e.id;
	for(var i = 0;i<$("#menu_board button").length;++i)
	{
		if($("#menu_board button:eq("+i+")").attr("disabled") == "disabled" )
		{
			var pills = $("#menu_board button:eq("+i+")").attr("id").split("_");
			if(pills.length > 1)
			{
				$("#menu_board button:eq("+i+")").removeAttr("disabled");			
				var name = new Array();
				name = $("#menu_board button:eq("+i+")").attr("id").split("_");
				$("#menu_board button:eq("+i+")").removeAttr("style");
				$("#menu_board button:eq("+i+")").css("background-image","url(img/homepage/menu-"+name[2]+".png");
				$("#"+name[2]).animate({height:"0px"},"slow",function (){
					$("#"+name[2]).css("visibility","hidden");	
				});
			}
		}
	}
	var attr = new Array();
	attr = id.split("_");
	var height = ($("#"+attr[2]+" button").length)*30+30;
	$("#"+attr[2]).css("visibility","visible");
	$("#"+attr[2]).animate({height:height+"px"},{queue:false,duration:"slow"});
	$("#"+id).attr("disabled","disabled");
	var img = $("#"+id).css("background-image");
	var imgarr = new Array();
	imgarr = img.split("-");
	var num = imgarr.length - 2;
	$("#"+id).css("background-image","url(img/homepage/menu-"+imgarr[num]+"-current.png)");	
}

function LogOut(){
	var retdata;
    $.post('/SmartSocialSecurity/logout',function(data){
		retdata = eval("(" + data + ")");
		if(retdata.succeed == 1)
			window.open("SSSlogin.html",'_self');
		else
			alert("退出登录失败");
	});	
}
