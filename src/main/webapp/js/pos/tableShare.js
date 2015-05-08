if(!window.bapdosa.tableShare) window.bapdosa.tableShare = {};
$(document).ready(function(){	
	
	window.bapdosa.tableShare.init();

});

//$(document).on("mobileinit", function () {
//    $.mobile.ajaxEnabled = false;
//});

window.bapdosa.tableShare = (function() {	
	
	var mTableId = ""; //테이블아이디
	
	function eventReg(){
		
		//mTableId = window.bapdosa.urlParams["tableId"] || "";	
		
		$("#tableShare-page .table_map ul").on("click","li",function(e){
			e.preventDefault();
			
			var tableId = $(this).data("tableId") || "";
			var orderId = $(this).data("orderId") || "";
			var tableName = $(this).data("tableName") || "";
			
			if(!orderId){			
				return false;
			}
			
			
			console.log("tableId: " + mTableId);
			
			var shareA = $("#tableShare-page #id_area_share_a").text() || "";
			var shareB = $("#tableShare-page #id_area_share_b").text() || "";
			var shareA_orderId = $("#tableShare-page #id_area_share_a").attr("orderId") || "";
			var shareB_orderId = $("#tableShare-page #id_area_share_b").attr("orderId") || "";
			
			
			if(shareA){				
				if(orderId == shareA_orderId){
					return false;
				}
				$("#tableShare-page #id_area_share_b").text(tableName).attr({"tableId": tableId, "orderId": orderId});
			} else {				
				if(orderId == shareB_orderId){
					return false;
				}				
				$("#tableShare-page #id_area_share_a").text(tableName).attr({"tableId": tableId, "orderId": orderId});
			}	
			
			$(this).children("div").addClass("choice").end().siblings().children("div").removeClass("choice");
		});
		
		$("#tableShare-page #id_area_share_a,#tableShare-page #id_area_share_b").click(function(e){
			e.preventDefault();
			$(this).empty().removeAttr("tableId").removeAttr("orderId");
		});
		
		//합석하기
		$("#tableShare-page .class-event-share-save").click(function(e){
			e.preventDefault();
			
			var shareA = $("#tableShare-page #id_area_share_a").text() || "";
			var shareA_tableId = $("#tableShare-page #id_area_share_a").attr("tableId") || "";
			var shareA_orderId = $("#tableShare-page #id_area_share_a").attr("orderId") || "";
			var shareB = $("#tableShare-page #id_area_share_b").text() || "";	
			var shareB_tableId = $("#tableShare-page #id_area_share_b").attr("tableId") || "";
			var shareB_orderId = $("#tableShare-page #id_area_share_b").attr("orderId") || "";
			
			if(!shareA_orderId || !shareB_tableId){
				alert("합석할 테이블을 선택해 주세요.");
				return false;
			}
						
			var contents = "[테이블합석]" + $.trim($("#tableShare-page input[name=contents]").val());
			
			var param =   "contents=" + contents 
						+ "&orderId=" + shareA_orderId
						+ "&subOrderId=" + shareB_orderId
						+ "&tableId=" + shareA_tableId;
			var url = "/pos/sepcial/tableShareOk.json";
			var success = function(returnJsonVO){
				var returnObj = returnJsonVO.returnObj;
				document.location.href="/pos/main/posMain.do";
			}
			
			commonAjaxCall(url, param, success);
		});
		
		//합석취소
		$("#tableShare-page .class-event-share-cancel").click(function(e){
			e.preventDefault();
			var shareA = $("#tableShare-page #id_area_share_a").text() || "";
			var shareA_tableId = $("#tableShare-page #id_area_share_a").attr("tableId") || "";
			var shareA_orderId = $("#tableShare-page #id_area_share_a").attr("orderId") || "";	
			
			if(!shareA){
				alert("합석취소할 테이블을 선택해 주세요.");
				return false;
			}
			
			//var contents = "[합석취소]" + $.trim($("#tableShare-page input[name=contents]").val());
			
			var param = "newOrderId=" + shareA_orderId
			var url = "/pos/sepcial/tableShareDelOk.json";
			var success = function(returnJsonVO){
				var returnObj = returnJsonVO.returnObj;
				if(returnObj == 1){
					document.location.href="/pos/main/posMain.do";
				} else if(returnObj == 2){
					alert("취소할수 없습니다.");
				} else if(returnObj == 3){
					
				}
			}
			
			commonAjaxCall(url, param, success);			
			
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
			var ulList = $("#tableShare-page .table_map ul");
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
				  		   $("<span>").addClass("number").text(obj.TABLENAME ||  obj.TABLENO)
		  		);
				
				div.append(a);				
				
				ulList.append($("<li>").data( {tableId: obj.TABLEID, orderId: obj.ORDERID, tableName: obj.TABLENAME || obj.TABLENO})
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

