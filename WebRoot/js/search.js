// JavaScript Document
function PmodelOn(){
	$("#Pmodel").css('visibility','visible');
}

function PmodelOut(){
	$("#Pmodel").css('visibility','hidden');	
}

function MmodelOn(){
	$("#Mmodel").css('visibility','visible');
}

function MmodelOut(){
	$("#Mmodel").css('visibility','hidden');	
}

function QueryModel(e){
	var kind = $(e).val();
	$.post('/SmartSocialSecurity/modelInfo',{'action':4,'modeltype':kind},function(data){
		var redata = eval("(" + data + ")");
		if(redata.succeed = 1)
			window.open("modeldetail.html",'_self');
	});
}
