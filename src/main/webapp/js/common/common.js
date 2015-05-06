if (!window.bapdosa) {
    window.bapdosa = {};
    if(!window.bapdosa.util) window.bapdosa.util = {};
}
var console = window.console || {log:function(){}};

var console = window.console || {log:function(){}};
$(document).ready(function(){	
	
	//get방식으로 넘어오는 파라미터 object화
	window.bapdosa.urlParams = window.bapdosa.util.parseQueryString(decodeURI( window.location.search.substring(1) ));
	console.log(window.bapdosa.urlParams);

	//숫자 타입일 경우  숫자만 입력받게처리	
	$(".inputOnlyNumber").keypress(function(e) {

		if (e.keyCode < 48 || e.keyCode > 57) { 			
			e.preventDefault();
			e.returnValue = false;
			return false;
		}			  
	});	
	
	$("a.topbtn.btn_poshome").click(function(e){
		e.preventDefault();
		document.location.href="/pos/main/posMain.do";
	});
});


function commonAjaxCall(url, param, success, fail){
	if(typeof console != 'undefined'){
		console.log("url: " + url + ", param: " + param);
	}
	return $.ajax({
		url: url,
		type: 'post',
		data: param,
		dataType: "json",
		error:function (xhr, ajaxOptions, thrownError){
			alert("error");
			alert(thrownError);
			
			if(fail){
				fail();
			}
		},
		success:function(data){
			if(typeof console != 'undefined'){		
				console.log(data);					
			}
			
			if(data.returnJsonVO){
				
				//console.log("data.returnJsonVO.returnVal: " + data.returnJsonVO.returnVal);
				if(data.returnJsonVO.returnCode == 1){
					//alert("success: " + data.returnJsonVO.returnVal);
					success(data.returnJsonVO);
				} else {
					//alert("fail: " + data.returnJsonVO.returnVal)
					
					if(data.returnJsonVO.returnErrorCode == "201"){
						if(confirm("로그인이 필요합니다.\n로그인하러 가시겠습니까?")){
							var forwardUrl = location.pathname;
							var queryString = location.search;
							document.location.href="/login/login.do?forwardUrl="+forwardUrl+queryString;							
						}
						
						return false;
					}						
					
					if(fail){
						fail(data.returnJsonVO);
					} else {
						alert(data.returnJsonVO.message);
					}
				}
			} else {
				alert("error.");
			}
			
		}
	});		
}

$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [o[this.name]];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};

Date.prototype.addDate = function(i){
	var currentDate;//계산된 날
	currentDate = this.getDate() + i*1;// 현재날짜에 더해(빼)줄날짜를계산
	this.setDate(currentDate);//계산된날짜로 다시 세팅	
};

Date.prototype.addHours= function(h){
    this.setHours(this.getHours()+h);
    return this;
}

Date.prototype.addMinutes= function(m){
    this.setMinutes(this.getMinutes()+m);
    return this;
}

jQuery.nl2br = function(varTest){
    return varTest.replace(/(\r\n|\n\r|\r|\n)/g, "<br>");
};

if ( typeof String.prototype.startsWith != 'function' ) {
	String.prototype.startsWith = function( str ) {
		return str.length > 0 && this.substring( 0, str.length ) === str;
	}
};

if ( typeof String.prototype.endsWith != 'function' ) {
String.prototype.endsWith = function( str ) {
return str.length > 0 && this.substring( this.length - str.length, this.length ) === str;
}
};