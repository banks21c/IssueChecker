if(!window.bapdosa.ticketSale) window.bapdosa.ticketSale = {};
$(document).ready(function(){	
	
	window.bapdosa.ticketSale.init();

});

window.bapdosa.ticketSale = (function() {
	
	var now = new Date();     
    var getMonth = now.getMonth() + 1;
    var getDate = now.getDate();  
    var getDay = now.getDay();
    var week = new Array('일', '월', '화', '수', '목', '금', '토');
	
	var keyText = '';
	var setResult = '';
	
	function eventReg(){
		
		$('#id_get_month').text(getMonth);
		$('#id_get_day').text(getDate);
		$('#id_get_weekday').text(week[getDay]);		
		
		$('#numpad-page .keypad li a span').click(function (e) {
			e.preventDefault();			
			var inputKey = $(this).text();
			var downKey = $('#numpad-page .class_price_input').val();			
			
			 if(inputKey == '←'){
				var tmpKey = downKey.substr(0,downKey.length-1);
				if(tmpKey=="" || tmpKey==null) {
					tmpKey = "";
				}
				keyText = tmpKey;
				setResult = keyText;
				$('#numpad-page .class_price_input').val(setResult);
			}
			else if(inputKey != null){
				keyText = downKey + inputKey;
				setResult =keyText;
				$('#numpad-page .class_price_input').val(setResult);
							
			}
		});
		
		$("#id_numpad_next").click(function(){
			
		});
		
        $("#id_numpad_prev").click(function(){
			
		});
        
        $("#id_ticket_save").click(function(){
			//alert($("#id_ticket_calendar").val());
        	var calendarParam = $("#id_ticket_calendar").val();
        	var ticketParam = $('#numpad-page .class_price_input').val();  
        	
        	if(calendarParam == ""){
        		alert("날짜를 선택해주세요");
        		return false;
        	}
        	if(ticketParam == ""){
        		alert("식권판매금액을 입력해주세요");
        		return false;
        	}
        	ticketSave();
        	
		});
	};
	function ticketSave(){
		if(!confirm("저장하시겠습니까?")){
			return false;
		}
		
		var calendarParam = $("#id_ticket_calendar").val();
    	var calendarParam1 = calendarParam.substring(0,4);
    	var calendarParam2 = calendarParam.substring(5,7);
    	var calendarParam3 = calendarParam.substring(8,10);        	
    	var ticketParam = $('#numpad-page .class_price_input').val(); 
	}
	
	return{
		
		init : function(){
			/*var eventType = '';
			if ( window.scpjs.webInfo.deviceType=='web' ){
				eventType = 'click';
			}else {
				eventType = 'touchstart';
			}*/
			
			eventReg();
		},
		
		open : function(name){
			keyText = '0';
			setResult = '0';
			//$("#datepicker" ).datepicker();
			
		},
		confirm: function() {
			
		}
	}
})();

