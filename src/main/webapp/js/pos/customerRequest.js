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
	var mDefaultCustomerRequestList;	//기본 고객요구사항리스트
	
	function eventReg(){
		
		mTableId = window.bapdosa.urlParams["tableId"] || "";
		mOrderId = window.bapdosa.urlParams["orderId"] || "";		
		
		$("#customerRequest-page .table_map ul").on("click","li",function(e){
			e.preventDefault();
			
			mTableId = $(this).data("tableId");
			mOrderId = $(this).data("orderId") || "";
			
//			if($(this).children("div").hasClass("choice")){
//				$(this).children("div").removeClass("choice");
//				mTableId = "";
//				mOrderId = "";				
//			} else {
//			
//				$(this).children("div").addClass("choice").end().siblings().children("div").removeClass("choice");
//				getSelCustomerRequestList(mTableId,mOrderId);
//			}
			
			$(this).children("div").addClass("choice").end().siblings().children("div").removeClass("choice");
			getSelCustomerRequestList(mTableId,mOrderId);
			
			console.log("tableId: " + mTableId);
			console.log("orderId: " + mOrderId);
			
			//주문에서 온경우 선택변경을 지원하지 않음
//			if(mOrderId){
//				alert("테이블을 변경할수 없습니다.");
//				return false;
//			} 
			
			
			
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
		
		$("#ask_self .class-event-direct-save").click(function(e){
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
							var ulList = $("#customerRequest-page .ask_write ul");		
							var li = $("<li>");				
							var a = $("<a>", { 
										href: "#",
										contentsText: contents,
										requestId: returnObj								
									}).addClass("choice").text(contents);	
							li.append(a);				
							ulList.append(li);			
						};

						commonAjaxCall(url, param, success);	
						
					}
				} else {
					$("#customerRequest-page .class-event-direct-insert").addClass("choice").attr("contentsText", contents).text(contents);
				}
				
			} else {
				alert("고객요구사항을 입력해 주세요.");
				return false;
			}
			$("#ask_self").popup("close");
		});
		
		//고객주문사항 선택시
		$("#customerRequest-page .ask_write ul").on("click", "li", function(e){
			e.preventDefault();
			if($(this).children("a").hasClass("class-event-direct-insert")){
				return;
			} else {
				$(this).children("a").toggleClass("choice");
			}
		});
		
		//고객주문사항 저장
		$("#customerRequest-page .class-event-request-save").click(function(e){
			e.preventDefault();
			var choiceList = $("#customerRequest-page .ask_write ul li a.choice");
			
			var selCustomerRequestList = [];
			choiceList.each(function(i){
				console.log($(this).attr("contentsText"));
				
				//if(!$(this).attr("memoId")){
					var data = {
						requestId: $(this).attr("requestId") || "",
						memoId: $(this).attr("memoId") || "",
						contents: $(this).attr("contentsText")
					};
					selCustomerRequestList.push(data);
				//}
			});
			console.log(selCustomerRequestList);
						
			var sendData = {
					tableId: mTableId, 
					orderId: mOrderId,	
					selCustomerRequestList: selCustomerRequestList
			};
			var selCustomerRequestJson = JSON.stringify(sendData);
	
			var url="/pos/memo/setSelCustomerRequest.json";
			var param="selCustomerRequestJson=" + selCustomerRequestJson;
			var success = function(returnJsonVO){
				var returnObj = returnJsonVO.returnObj;

				console.log(returnObj);
				
				var tableId = window.bapdosa.urlParams["tableId"] || "";
				var orderId = window.bapdosa.urlParams["orderId"] || "";
				
				if(tableId && orderId){
					document.location.href="/pos/order/orderList.do?tableId=" + tableId + "&orderId=" + orderId;
				} else {
					document.location.href="/pos/main/posMain.do";;
				}
			};

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
			var ulList = $("#customerRequest-page .table_map ul");
			ulList.empty();
			
			$(returnObj).each(function(index,obj){
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
	
	function getDefaultCustomerRequestList(){
		var dfd = new jQuery.Deferred();
		var url="/pos/setting/getCustomerRequestList.json";
		var param="";
		var success = function(returnJsonVO){
			mDefaultCustomerRequestList = returnJsonVO.returnObj.customerRequestList;

			//console.log(returnObj);
			//<li><a href="#">달지 않게 해 주세요</a></li>		
			var ulList = $("#customerRequest-page .ask_write ul");
			//ulList.empty();
			
			$(mDefaultCustomerRequestList).each(function(index,obj){
				console.log(obj);			
				var li = $("<li>");				
				var a = $("<a>", { 
							href: "#",
							contentsText: obj.CONTENTS,
							requestId: obj.REQUESTID								
						}).text(obj.CONTENTS);	
				li.append(a);				
				ulList.append(li);				
			});			
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);
		return dfd.promise();		
	}
	
	function getSelCustomerRequestList(tableId, orderId){
		var url="/pos/memo/getSelCustomerRequestList.json";
		//var param="tableId=" + tableId + "&orderId=" + orderId;
		var param="orderId=" + orderId;
		var ulArea = $("#customerRequest-page .ask_write ul");
		var success = function(returnJsonVO){
			var selCustomerRequestList= returnJsonVO.returnObj;

			//console.log(returnObj);
			//<li><a href="#">달지 않게 해 주세요</a></li>		
			
			//ulList.empty();
			
			$(selCustomerRequestList).each(function(index,obj){
				
				console.log(obj);	
				
				if(obj.REQUESTID){
					ulArea.find("a[requestId='" + obj.REQUESTID + "']").attr("memoId", obj.memoId)
																	   .attr("contentsText", obj.CONTENTS)	
																	   .addClass("choice")
				
				} 
				//직접입력케이스
				else {
					ulArea.find(".class-event-direct-insert").attr("memoId", obj.memoId)
					   .attr("contentsText", obj.CONTENTS)	
					   .addClass("choice")
					   .text(obj.CONTENTS);
				}
				
//				var li = $("<li>");				
//				var a = $("<a>", { 
//							href: "#",
//							contentsText: obj.CONTENTS,
//							requestId: obj.REQUESTID								
//						}).text(obj.CONTENTS);	
//				li.append(a);				
//				ulList.append(li);				
			});	
		};

		//초기화
		var liList = ulArea.children("li");
		liList.each(function(i,objl){
			console.log(objl);
			$(this).children("a").removeClass("choice").removeAttr("memoId");
			
			if(i == 0){
				$(this).children("a").text("직접입력");
			}
		});
		commonAjaxCall(url, param, success);
	}
	
	return {
		init: function() {
			eventReg();
			$.when(getOrderTablePresentList(), getDefaultCustomerRequestList()).then (
				function(status){
					console.log("status: " + status);
					if(mOrderId){
						getSelCustomerRequestList(mTableId,mOrderId);
					}
				}					
			);
		}
	}   
})();

