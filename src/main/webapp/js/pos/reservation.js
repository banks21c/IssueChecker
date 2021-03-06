if(!window.bapdosa.reservation) window.bapdosa.reservation = {};
$(document).ready(function(){	
	
	window.bapdosa.reservation.init();

});

//$(document).on("mobileinit", function () {
//    $.mobile.ajaxEnabled = false;
//});

window.bapdosa.reservation = (function() {	
	
	var mTableId = ""; //테이블아이디
	
	function eventReg(){
		
		mTableId = window.bapdosa.urlParams["tableId"] || "";	
		
		$("#reservation-page .table_map ul").on("click","li",function(e){
			e.preventDefault();
			
			mTableId = $(this).data("tableId") || "";
			
			if($(this).children("div").hasClass("choice")){
				$(this).children("div").removeClass("choice");
				mTableId = "";			
			} else {
			
				$(this).children("div").addClass("choice");
				
			}
						
			console.log("tableId: " + mTableId);
			
		});
		
		$("#reservation-page .class-event-memo-save").click(function(e){
			e.preventDefault();
			
//			var contents = $.trim($("textarea[name=contents]").val());
//			var isImportant = $("input[name=isImportant]:checked").val() || "N";
//			
//			if(contents == ""){
//				alert("내용을 입력해 주세요.");
//				return false;
//			}
//			
//			var param =   "contents=" + contents 
//						+ "&isImportant=" + isImportant 
//						+ "&tableId=" + mTableId
//						+ "&orderId=" + mOrderId;
//			var url = "/pos/memo/setMemoRegisterOk.json";
//			var success = function(returnJsonVO){
//				var returnObj = returnJsonVO.returnObj;
//
//				//console.log(returnObj);
//				if(window.bapdosa.urlParams["returnUrl"]){
//					document.location.href=$.base64Decode(window.bapdosa.urlParams["returnUrl"]);
//				} else {
//					history.back();
//				}
//			}
//			
//			commonAjaxCall(url, param, success);
		});
		

	}
	
	function getOrderTablePresentList(){
		var dfd = new jQuery.Deferred();
		var url="/pos/order/getOrderTablePresentList.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;

			//console.log(returnObj);
			
			//기존 리스트 삭제
			var ulList = $("#reservation-page .table_map ul");
			ulList.empty();
			
			$(returnObj).each(function(index,obj){
				var div = $("<div>").addClass("table_info");				
				if(obj.TABLEID == mTableId){
					div.addClass("choice");
				}				
				var a = $("<a>", { href: "#"});	
				//현재 주문이 있는경우 
				if(obj.ORDERID){
					div.addClass("active");					

					a.append(
							//사용금액
							$("<span>").addClass("sales").text(window.bapdosa.util.setComma(parseInt(obj.SUM_PRICE/1000)))
					);					
				}
				
				a.append( 
				  		   $("<span>").addClass("number").text(obj.TABLENAME)
		  		);
				
				div.append(a);				
				
				ulList.append($("<li>").data( {tableId: obj.TABLEID, orderId: obj.ORDERID})
					  .append(div));
				
			});
			
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);
		return dfd.promise();
	}
	

	
	return {
		init: function() {
			eventReg();
			$.when(getOrderTablePresentList()).then (
				function(status){
					console.log("status: " + status);
					if(mTableId){
						
					}
				}					
			);
		}
	}   
})();

