// JavaScript Document
function LogIn(){
	var retdata;
    $.post('/SmartSocialSecurity/adminInfo',{'action':2,'useracount':$("#user_acount").val(),'userpassword':$("#user_pass").val()},function(data){
		retdata = eval("(" + data + ")");
		if(retdata.succeed == 1)
			window.open("SSSHomepage.html",'_self');
		else
			alert("登录失败");
	});	
}