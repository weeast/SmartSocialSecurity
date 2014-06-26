// JavaScript Document
// JavaScript Document
$(document).ready(function(e) {
	var infodata;
	var limits;
	limits = new Array(1,1,1,1,1,1,1,1,1,1,1,1);
	var onuselimit;
	$("#user_name").text("huanglei");
	$("#user_sex").text("男");
	$("#user_place").text("chongqing");
	$("#user_work").text("google");
	$("#user_acount").text("001");
	$("#user_age").text("22");
	$("#user_apart").text("");	
	$("#user_pic").attr("src","img/1.jpg");	
	/*$.post('/adminInfo',{'action':0},function(data){
		infodata = eval("(" + data + ")");
		$.each(infodata.user,function(index,entry){
			limits = entry.userlimit;
			$("#user_name").val(entry.username);
			$("#user_sex").val(entry.usersex);
			$("#user_place").val(entry.userplace);
			$("#user_work").val(entry.userwork);
			$("#user_acount").val(entry.useracount);
			$("#user_age").val(entry.userage);
			$("#user_apart").val(entry.userapart);	
			$("#user_pic").attr("src",entry.userpic);	
		});*/
		for(var i =0; i <limits.length;++i)
		{
			if(limits[i] == 1)
				$("#limit_"+i).attr("checked","checked");	
		}
	//});
	
});

function closec(){
	
	alert('成功');
	window.open('limits.html','_self');
}