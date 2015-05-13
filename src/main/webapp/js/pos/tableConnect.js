if(!window.bapdosa.tableConnect) window.bapdosa.tableConnect = {};
$(document).ready(function(){	
	
	window.bapdosa.tableConnect.init();

});

//$(document).on("mobileinit", function () {
//    $.mobile.ajaxEnabled = false;
//});

window.bapdosa.tableConnect = (function() {	
	
	var connectGroupClass = ['group01','group02','group03','group04','group05','group06','group07','group08','group09','group10','group10','group10','group10','group10','group10','group10','group10','group10','group10','group10'];
	
	function eventReg(){
		
		//mTableId = window.bapdosa.urlParams["tableId"] || "";	
		
		//테이블클릭시
		$("#tableConnect-page .table_map ul").on("click","li",function(e){
			e.preventDefault();
			
			var tableId = $(this).attr("tableId") || "";
			var orderId = $(this).attr("orderId") || "";
			var tableName = $(this).attr("tableName") || "";
			var linkedTableCount = $(this).attr("linkedTableCount") || "";
			var linkedTableId = $(this).attr("linkedTableId") || "";
			var isConnected = ($(this).attr("isConnected") || "") == "true";
			var isLowTable = ($(this).attr("isLowTable") || "") == "true";
			var isHighTable = ($(this).attr("isHighTable") || "") == "true";
			var isType = $("#id_area_default_table").attr("flag") || "";
			var defaultTableId = $("#id_area_default_table").attr("defaultTableId") || "" ;
			
			if(($("#id_area_default_table").attr("flag") || "") == ""){
				isType = "M";
			}			
			
			var isChoicedFlag = false;
			var isChoiceConnected = false;
			var choiceConnectedTableId = "";
			//주문있는거 제외
			if($(this).children("div").hasClass("active")){
				return false;
			}
			
			var choiceList = $("#tableConnect-page .table_map ul li div.choice");
			if(choiceList.size() > 0){
				isChoicedFlag = true;
			}			
			
			choiceList.each(function(i){
				if($(this).parent().attr("linkedTableCount") > 0){
					isChoiceConnected = true;
					choiceConnectedTableId = $(this).parent().attr("tableId");
					return false;
				}
			});
			
			$("#tableConnect-page .class-event-connect-cancel").hide();	
			
			//이전에 선택된 주문
			if($(this).children("div").hasClass("choice")){		
				
				//연결된 테이블이면
				if(isConnected){
					$("#tableConnect-page .table_map ul li div.choice").removeClass("choice");
					$("#id_area_default_table").attr({
							defaultTableId: "",
							flag: "M"
					 }).text("");					
					
				} else {
					$(this).children("div").removeClass("choice");
					
					if(tableId == defaultTableId){
						$("#id_area_default_table").attr({
														defaultTableId: "",
														flag: "M"
												 }).text("");							
					}
					
					var afterChoiceList = $("#tableConnect-page .table_map ul li div.choice");
					if(afterChoiceList.size() > 0){
						$("#id_area_default_table").attr({
														defaultTableId: afterChoiceList.eq(0).parent().attr("tableId") || "",
														flag: "S"
												 }).text(afterChoiceList.eq(0).parent().attr("tableName") || "");
					}					
				}
			} 
			//이전에 선택안된 주문
			else {
				//연결된 테이블이면
				if(isConnected){
					
					if(isType == "S"){	//isType : S,C,M
						alert("이미연결되어 있는 테이블을 추가 할수 없습니다.");
						return false;
					} else {						
			
						$("#tableConnect-page .table_map ul li div.choice").removeClass("choice");	
						
						if(isHighTable){
							$(this).children("div").addClass("choice");
							$("#tableConnect-page .table_map ul li[linkedTableId='" + tableId + "']").children("div").addClass("choice");
							$("#id_area_default_table").attr({
															defaultTableId: tableId,
															flag: "C"
													 }).text(tableName);
							$("#tableConnect-page .class-event-connect-cancel").show();
						} else if(isLowTable){
							
							$("#tableConnect-page .table_map ul li[linkedTableId='" + linkedTableId + "']").children("div").addClass("choice");
							var defaultTableName =$("#tableConnect-page .table_map ul li[tableId='" + linkedTableId + "']").children("div").addClass("choice").end().attr("tableName");

							$("#id_area_default_table").attr({
															defaultTableId: linkedTableId,
															flag: "C"
													 }).text(defaultTableName);
							$("#tableConnect-page .class-event-connect-cancel").show();
						}					
					} 			
				} else {
					
					if(isType == "C" || isType == "M"){	//isType : S,C,M
						$("#tableConnect-page .table_map ul li div.choice").removeClass("choice");
						$("#id_area_default_table").attr({
														defaultTableId: tableId,
														flag: "S"
												 }).text(tableName);
					} 					
					
					$(this).children("div").addClass("choice");
				}
			}			
		});
	
		$("#tableConnect-page .class-event-connect-save").click(function(e){
			e.preventDefault();
			
			var isChoiceConnected = false;
			
			var choiceList = $("#tableConnect-page .table_map ul li div.choice");
			if(choiceList.size() == 0){
				alert("연결할 테이블을 선택해 주세요.");
				return false;
			} else if(choiceList.size() == 1) {
				alert("2개이상의 테이블을 선택해 주세요.");
				return false;				
			}	
			
			choiceList.each(function(i){
				if($(this).parent().attr("linkedTableCount") > 0){					
					isChoiceConnected = true;					
					return false;
				}
			});	
			
			if(isChoiceConnected){
				alert("이미 연결된 테이블 입니다.");
				return false;
			}
			
			var defaultTableId = $("#id_area_default_table").attr("defaultTableId") || "";
			
			if(!defaultTableId){
				alert("기준테이블이 없습니다.");
				return false;
			}
			var contents = "[테이블연결] " + $("#id_area_default_table").text();
			var connectTableInfo = {
					defaultTableId : defaultTableId,
					contents: contents
			};
			
			var linkedTableList = [];
			var choiceLiList = choiceList.parent();
			choiceLiList.each(function(i){
				if($(this).attr("tableId") == defaultTableId){
					return;
				}
				linkedTableList.push($(this).attr("tableId") || "");
			});
			
			connectTableInfo.linkedTableList = linkedTableList;
			var connectTableInfoJson = JSON.stringify(connectTableInfo);
			console.log(connectTableInfoJson);
			
			var param =   "connectTableInfo=" + connectTableInfoJson ;
			var url = "/pos/sepcial/tableConnectOk.json";
			var success = function(returnJsonVO){
				var returnObj = returnJsonVO.returnObj;
				document.location.href="/pos/main/posMain.do";
			}
			
			//commonAjaxCall(url, param, success);
		});
		
		//연결취소
		$("#tableConnect-page .class-event-connect-cancel").click(function(e){
			e.preventDefault();
			
			var defaultTableId = $("#id_area_default_table").attr("defaultTableId") || "";
			
			if(!defaultTableId){
				alert("기준테이블이 없습니다.");
				return false;
			}			
			
			var param =   "linkedTableId=" + defaultTableId ;
			var url = "/pos/sepcial/tableConnectCancelOk.json";
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
			var ulList = $("#tableConnect-page .table_map ul");
			ulList.empty();
			
			var connectGroup = [];
			
			$(returnObj).each(function(index,obj){
				var div = $("<div>").addClass("table_info");				
//				if(obj.TABLEID == mTableId){
//					div.addClass("choice");
//				}				
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
				
				ulList.append($("<li>").attr( {
										tableId: obj.TABLEID, 
										orderId: obj.ORDERID, 
										tableName: obj.TABLENAME || obj.TABLENO,
										linkedTableCount: obj.LINKEDTABLECOUNT,
										linkedTableId:obj.LINKEDTABLEID,
										isConnected: obj.LINKEDTABLECOUNT > 0 || obj.LINKEDTABLEID ? true:false,
										isHighTable: obj.LINKEDTABLECOUNT > 0,
										isLowTable: obj.LINKEDTABLEID ? true:false
										})
					  .append(div));	
				
				if(obj.LINKEDTABLECOUNT > 0){
					connectGroup.push(obj.TABLEID);
				}
			});
			
			$(connectGroup).each(function(i,tableId){
				console.log(tableId);
				$("#tableConnect-page .table_map ul > li[tableId='" + tableId + "'] div").addClass(connectGroupClass[i]);
				$("#tableConnect-page .table_map ul > li[linkedTableId='" + tableId + "'] div").addClass(connectGroupClass[i]);
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

				}					
			);
		}
	}   
})();

