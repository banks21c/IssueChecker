if (!window.bapdosa.posmain) {
    if(!window.bapdosa.posmain) window.bapdosa.posmain = {};
}

$(document).ready(function(){	
	
	window.bapdosa.posmain.init();

});

window.bapdosa.posmain = (function() {	
	
	function eventReg(){

	}
	
	function getOrderTablePresentList(){
		
		var url="/pos/order/getOrderTablePresentList.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;

			console.log(returnObj);
			
			//기존 리스트 삭제
			var ulList = $("#pos-main .table_map ul");
			ulList.empty();
			
			$(returnObj).each(function(index,obj){
				console.log(obj);
				
				var div = $("<div>").addClass("table_info");
				
				if(obj.ORDERID){
					div.addClass("active");
				}
				
				var a = $("<a>");
				
				
				
				a.append( 
				  		   $("<span>").addClass("number").text(obj.TABLENAME)
		  		  )
				
				div.append( 
								  a
								 );
				
				
				
				
				ulList.append($("<li>").append(div));
				
			});
			
		};

		commonAjaxCall(url, param, success);		
	}
	
	return {
		init: function() {
			eventReg();
			getOrderTablePresentList();
		}
	}   
})();

