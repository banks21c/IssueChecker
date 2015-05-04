if(!window.bapdosa.customerRequest) window.bapdosa.customerRequest = {};
$(document).ready(function(){	
	
	window.bapdosa.customerRequest.init();

});

//$(document).on("mobileinit", function () {
//    $.mobile.ajaxEnabled = false;
//});

window.bapdosa.customerRequest = (function() {	
	
	var mTableId = ""; //테이블아이디
	var mOrderId = ""; //주문번호
	
	function eventReg(){
		
		mTableId = window.bapdosa.urlParams["tableId"] || "";
		mOrderId = window.bapdosa.urlParams["orderId"] || "";		
		
		$("#customerRequest-page .table_map ul").on("click","li",function(e){
			e.preventDefault();
			
			var tableId = $(this).data("tableId");
			var orderId = $(this).data("orderId") || "";
			
			console.log("tableId: " + tableId);
			console.log("orderId: " + orderId);
			
			//주문에서 온경우 선택변경을 지원하지 않음
//			if(mOrderId){
//				alert("테이블을 변경할수 없습니다.");
//				return false;
//			} 
			
			if(orderId){
				
			}
			
//			var url = "/pos/order/orderList.do?tableId=" + tableId + "&orderId=" + orderId;
//			//$.mobile.changePage(url);
//			location.href = url;  
			
		});
		
		$("#customerRequest-page .class-event-direct-insert").click(function(e){
			e.preventDefault();
			
			if($(this).hasClass("choice")){
				$(this).removeClass("choice").text("직접입력");
			} else {
				$("#form_ask_self input[name=contents]").val("");
				$("#form_ask_self input[name=isDefault]").prop("checked", false);
				$("#ask_self").popup("open");
			}
			
		});
		
		$("#customerRequest-page .class-event-save").click(function(e){
			e.preventDefault();
			
			var ask_write_area = $("#customerRequest-page .ask_write ul");
			
			var isDefault = $("#form_ask_self input[name=isDefault]").prop("checked");
			var contents = $.trim($("#form_ask_self input[name=contents]").val() || "");
			if(contents){
				
				if(isDefault){
					var ask_write_area_liList = ask_write_area.children("li");
					console.log(ask_write_area_liList.size());
					if(ask_write_area_liList.size() > 9){
						alert("고객요구 리스트에 추가하기는 9개까지만 가능합니다.");
						return false;
					} else {
						var url = "/pos/setting/setCustomerRequest.json";
						var param = "contents=" + contents;
						var success = function(returnJsonVO){
							var returnObj = returnJsonVO.returnObj;

							console.log(returnObj);
						};

						commonAjaxCall(url, param, success);	
						
					}
				} else {
					$("#customerRequest-page .class-event-direct-insert").addClass("choice").text(contents);
				}
				
			} else {
				alert("고객요구사항을 입력해 주세요.");
				return false;
			}
			$("#ask_self").popup("close");
		});
	}
	
	function getOrderTablePresentList(){
		var dfd = new jQuery.Deferred();
		var url="/pos/order/getOrderTablePresentList.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;

			console.log(returnObj);
			
			//기존 리스트 삭제
			var ulList = $("#customerRequest-page .table_map ul");
			ulList.empty();
			
			$(returnObj).each(function(index,obj){
				console.log(obj);
				
//				<li>
//					<div class="table_info active">
//						<a href="#">
//							<span class="number">1</span>
//							<span class="sales">999</span>
//						</a>
//					</div>
//				</li>				
				
				var div = $("<div>").addClass("table_info");
				
				if(obj.ORDERID == mOrderId){
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
			getOrderTablePresentList();
		}
	}   
})();

