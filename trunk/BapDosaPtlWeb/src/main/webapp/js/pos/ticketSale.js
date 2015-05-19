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
		$('#id_get_weekday').text(week[now.getDay()]);
		
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
	};		
	
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
			
		},
		confirm: function() {
			
		}
	}
})();

