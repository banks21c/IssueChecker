if(!window.bapdosa.tableMove) window.bapdosa.tableMove = {};
$(document).ready(function(){	
	
	window.bapdosa.tableMove.init();

});

//$(document).on("mobileinit", function () {
//    $.mobile.ajaxEnabled = false;
//});

window.bapdosa.tableMove = (function() {	
	
	var mTableId = ""; //테이블아이디
	
	function eventReg(){
		
		//mTableId = window.bapdosa.urlParams["tableId"] || "";	
		
		$("#tableMove-page .table_map ul").on("click","li",function(e){
			e.preventDefault();
			
			var tableId = $(this).data("tableId") || "";
			var orderId = $(this).data("orderId") || "";
			var tableName = $(this).data("tableName") || "";
			
			$(this).children("div").addClass("choice").end().siblings().children("div").removeClass("choice");
			console.log("tableId: " + mTableId);
			
			var before = $("#tableMove-page #id_area_move_before").text() || "";
			var after = $("#tableMove-page #id_area_move_after").text() || "";
			
			if(before){
				$("#tableMove-page #id_area_move_after").text(tableName).attr({"tableId": tableId, "orderId": orderId});
			} else {
				$("#tableMove-page #id_area_move_before").text(tableName).attr({"tableId": tableId, "orderId": orderId});
			}
			
		});
		
		$("#tableMove-page #id_area_move_before, #tableMove-page #id_area_move_after").click(function(e){
			e.preventDefault();
			$(this).empty().removeAttr("tableId").removeAttr("orderId");
		});
		
		$("#tableMove-page .class-event-move-save").click(function(e){
			e.preventDefault();
			
			var before = $("#tableMove-page #id_area_move_before").text() || "";
			var before_tableId = $("#tableMove-page #id_area_move_before").attr("tableId") || "";
			var before_orderId = $("#tableMove-page #id_area_move_before").attr("orderId") || "";
			var after = $("#tableMove-page #id_area_move_after").text() || "";	
			var after_tableId = $("#tableMove-page #id_area_move_after").attr("tableId") || "";
			var after_orderId = $("#tableMove-page #id_area_move_after").attr("orderId") || "";
			
			if(!before_tableId || !after_tableId){
				alert("이동할 테이블을 선택해 주세요.");
				return false;
			}
			
			if(before_orderId){
				if(after_orderId){
					alert("대상테이블이 비어있지 않습니다.");
					return false;
				}
			} else {
				alert("이동할 테이블이 비어있습니다.");
				return false;
			}
			
			
			var contents = $.trim($("#tableMove-page input[name=contents]").val());
			
			var param =   "contents=" + contents 
						+ "&orderId=" + before_orderId
						+ "&tableId=" + after_tableId;
			var url = "/pos/sepcial/tableMoveOk.json";
			var success = function(returnJsonVO){
				var returnObj = returnJsonVO.returnObj;
				document.location.href="/pos/main/posMain.do";
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
			var ulList = $("#tableMove-page .table_map ul");
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

