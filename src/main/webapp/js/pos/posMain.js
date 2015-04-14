if (!window.bapdosa.posmain) {
    if(!window.bapdosa.posmain) window.bapdosa.posmain = {};
}

$(document).ready(function(){	
	
	window.bapdosa.posmain.init();

});

// JQUERY MOBILE INIT
//$(document).bind("mobileinit", function () {
//    $.mobile.ajaxEnabled = false;
//    $.mobile.defaultPageTransition = 'none';
//    $.mobile.defaultDialogTransition = 'none';
//    $.mobile.useFastClick = true;
//
//});

$(document).on("mobileinit", function () {
    $.mobile.ajaxEnabled = false;
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
				var a = $("<a>");	
				//현재 주문이 있는경우 
				if(obj.ORDERID){
					div.addClass("active");
					
//					<span class="in_time">1:58</span>
//					<span class="ico_list">
//						<span class="ico m">M</span><span class="ico p">포</span><span class="ico s">서</span><span class="ico b">대</span>
//					</span>
//					<span class="connect">연결(+9)</span>
//					<span class="sales">999</span>	
					
					a.append(
							//사용시간넣기
							$("<span>").addClass("in_time").text("1:02")
					);
					a.append(
							$("<span>").addClass("ico_list")
									   .append( $("<span>").addClass("ico")
											   			   .addClass("m")
											   			   .text("M")											   
									   )
									   .append( $("<span>").addClass("ico")
											   			   .addClass("p")
											   			   .text("포")
											   
									   )
									   .append( $("<span>").addClass("ico")
											   			   .addClass("s")
											   			   .text("서")
											   
									   )
									   .append( $("<span>").addClass("ico")
											   			   .addClass("b")
											   			   .text("대")
											   
									   )
					);
					a.append(
							//사용금액
							$("<span>").addClass("sales").text(obj.SUM_PRICE)
					);
					
				}
				
				a.append( 
				  		   $("<span>").addClass("number").text(obj.TABLENAME)
		  		);
				
				div.append(a);				
				
				ulList.append($("<li>").data( {tableId: obj.TABLEID, orderId: obj.ORDERID})
					  .append(div));
				
			});
			
			$("#pos-main .table_map ul > li").click(function(e){
				e.preventDefault();
				
				var tableId = $(this).data("tableId");
				var orderId = $(this).data("orderId") || "";
				
				console.log("tableId: " + tableId);
				console.log("orderId: " + orderId);
				var url = "/pos/order/orderList.do?tableId=" + tableId + "&orderId=" + orderId;
				//$.mobile.changePage(url);
				location.href = url;  
				
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

