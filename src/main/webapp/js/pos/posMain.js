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
	
	var timeoutVar;
	
	function eventReg(){
		$("#pos-main .table_map ul").on("click", "li", function(e){
			e.preventDefault();
			
			var tableId = $(this).attr("tableId") || "";
			var orderId = $(this).attr("orderId") || "";
			var linkedTableId = $(this).attr("linkedTableId") || "";
			
			if(linkedTableId){
				tableId = linkedTableId;
			}			
			
			console.log("tableId: " + tableId);
			console.log("orderId: " + orderId);
			var url = "/pos/order/orderList.do?tableId=" + tableId + "&orderId=" + orderId;
			//$.mobile.changePage(url);
			location.href = url;  
			
		});
		
		//특수 선택시
		$("#pos-main input[name=specialM]").change(function(e){
			e.preventDefault();
			var selVal = $(this).val();
			var url;
			//테이블이동
			if(selVal == 1){
				url = "/pos/special/tableMove.do";
			} 
			//테이블합석
			else if(selVal == 2){
				url = "/pos/special/tableShare.do";
			}
			//테이블연결
			else if(selVal == 3){
				url = "/pos/special/tableConnect.do";
			}
			//테이블이름변경
			else if(selVal == 8){				
				url = "/pos/special/tableNameChange.do";
			}				
			
			if(url){
				document.location.href=url;
			}
		});
	}
	
	function getOrderTablePresentList(){
		
		var url="/pos/order/getOrderTablePresentList.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			//기존 리스트 삭제
			var ulList = $("#pos-main .table_map ul");
			ulList.empty();
			
			$(returnObj).each(function(index,obj){
				
				var div = $("<div>").addClass("table_info");
				var a = $("<a>", { href: "#"});	
				//현재 주문이 있는경우 
				if(obj.ORDERID){
					div.addClass("active");
					
//					<span class="in_time">1:58</span>
//					<span class="ico_list">
//						<span class="ico m">M</span><span class="ico p">포</span><span class="ico s">서</span><span class="ico b">대</span>
//					</span>
//					<span class="connect">연결(+9)</span>
//					<span class="sales">999</span>	
//					console.log(moment().valueOf());
//					console.log(new Date().getTime());

//					var usedHours = moment(obj.CREATIONDATE_STR, "YYYYMMDD HH:mm:ss").fromNow();
					a.append(
							//사용시간넣기
							$("<span>", {
								creationDate: obj.CREATIONDATE_STR
							}).addClass("in_time").text(window.bapdosa.util.getUsedDateFromNow(obj.CREATIONDATE_STR))
					);
					
					a.append(
							//사용금액
							$("<span>").addClass("sales").text(window.bapdosa.util.setComma(parseInt(obj.SUM_PRICE/1000)))
					);					
				}	
				
				//연결된테이블일경우
				if(obj.LINKEDTABLECOUNT > 0 || obj.LINKEDTABLEID ? true:false){
					
					var connectStr = "연결";
					if(obj.LINKEDTABLEID){
						connectStr += "(+" + obj.LINKEDTABLENAME + ")";
					}
					a.append(
							//연결정보넣기
							$("<span>").addClass("connect").text(connectStr)
					);						
				}
					
				if(obj.TAKEOUTCOUNT > 0 || obj.SERVICECOUNT > 0 || obj.MEMO_COUNT > 0 || obj.CUSTOMERREQUEST_COUNT > 0 || obj.DAERI_COUNT > 0){					
					var pspan = $("<span>").addClass("ico_list");
					//메모가 있을경우
					if(obj.MEMO_COUNT > 0 || obj.CUSTOMERREQUEST_COUNT > 0){
						pspan.append(
								$("<span>").addClass("ico")
					   			   .addClass("m")
					   			   .text("M")									
						);
					}						
					//포장이있을시
					if(obj.TAKEOUTCOUNT > 0){
						pspan.append(
								$("<span>").addClass("ico")
					   			   .addClass("p")
					   			   .text("포")									
						);
					}
					//서비스가 있을시
					if(obj.SERVICECOUNT > 0){
						pspan.append(
								$("<span>").addClass("ico")
					   			   .addClass("s")
					   			   .text("서")									
						);
					}
					//대리가 있을시
					if(obj.DAERI_COUNT > 0){
						pspan.append(
								$("<span>").addClass("ico")
					   			   .addClass("b")
					   			   .text("대")									
						);
					}					
					a.append(pspan);				
				}
				
				a.append( 
				  		   $("<span>").addClass("number").text(obj.TABLENAME)
		  		);
				
				div.append(a);				
				
				ulList.append($("<li>")
								.attr({
									tableId: obj.TABLEID,
									orderId: obj.ORDERID,
									linkedTableCount: obj.LINKEDTABLECOUNT,
									linkedTableId:obj.LINKEDTABLEID,
									isConnected: obj.LINKEDTABLECOUNT > 0 || obj.LINKEDTABLEID ? true:false								
								})
								//.data( {tableId: obj.TABLEID, orderId: obj.ORDERID})
								.append(div));
				
			});
			
			timeoutVar = setTimeout(refreshUsedDate, 60000);
			

			
		};

		commonAjaxCall(url, param, success);		
	}
	
	function refreshUsedDate(){
		
		if(timeoutVar){
			$("#pos-main .table_map ul .in_time").each(function(){
				$(this).text(window.bapdosa.util.getUsedDateFromNow($(this).attr("creationDate")));
			});
			
			timeoutVar = setTimeout(refreshUsedDate, 60000);
		}
	}
	
	return {
		init: function() {
			eventReg();
			getOrderTablePresentList();
		}
	}   
})();

