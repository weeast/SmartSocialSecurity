// JavaScript Document
$(document).ready(function(e) {
	var infodata;
    $.post('/SmartSocialSecurity/adminInfo',{'action':0},function(data){
		infodata = eval("(" + data + ")");
		$.each(infodata.user,function(index,entry){
			$("#user_acount").text(entry.useracount);
		});
	});
});

function FixPassword(){
	var retdata;
    $.post('/SmartSocialSecurity/adminInfo',{'action':1,'oldpassword':$("#old_pass").val(),'newpassword':$("#new_pass").val()},function(data){
		retdata = eval("(" + data + ")");
		alert(retdata.succeed);
	});
}