if (!window.bapdosa.order) {
    if(!window.bapdosa.order) window.bapdosa.order = {};
}

$(document).ready(function(){		
	window.bapdosa.order.init();
	
	
	
//	console.log("window.bapdosa.util.hourTo12('00'):" + window.bapdosa.util.hourTo12('00'));
//	console.log("window.bapdosa.util.hourTo12('01'):" + window.bapdosa.util.hourTo12('01'));
//	console.log("window.bapdosa.util.hourTo12('12'):" + window.bapdosa.util.hourTo12('12'));
//	console.log("window.bapdosa.util.hourTo12('23'):" + window.bapdosa.util.hourTo12('23'));
//	
//	console.log("window.bapdosa.util.hourTo24('오전','12'):" + window.bapdosa.util.hourTo24('오전','12'));
//	console.log("window.bapdosa.util.hourTo24('오전','01'):" + window.bapdosa.util.hourTo24('오전','01'));
//	console.log("window.bapdosa.util.hourTo24('오후''12'):" + window.bapdosa.util.hourTo24('오후','12'));
//	console.log("window.bapdosa.util.hourTo24('오후''01'):" + window.bapdosa.util.hourTo24('오후','01'));
//	
//	console.log("window.bapdosa.util.hourToampm('00'):" + window.bapdosa.util.hourToampm('00'));
//	console.log("window.bapdosa.util.hourToampm('01'):" + window.bapdosa.util.hourToampm('01'));
//	console.log("window.bapdosa.util.hourToampm('12'):" + window.bapdosa.util.hourToampm('12'));
//	console.log("window.bapdosa.util.hourToampm('23'):" + window.bapdosa.util.hourToampm('23'));
	
});


$(document).on("mobileinit", function () {
    $.mobile.ajaxEnabled = false;
});

window.bapdosa.order = (function() {
	var mTableId = ""; //테이블아이디
	var mOrderId = ""; //주문번호
	var mCustomerId = "";	//고객ID
	var mIsFirstCustomer = false;
	
	var isPriceDiffer;
	var isDPdiffer;
	var categoryInfoList;
	var selCategoryId;
	var orderArea;
	var mOrderAreaFirst;
	//var isDiscount = false;
	
	var mDcTimezoneSet;	//할인시간대설정값
	var mLunchTimezoneSet;	//점심시간할인대설정값
	var mIsDcPrice = false;	//할인시간대flag
	var mIsLunchTime = false;	//점심시간대flag
	
	var customerSearchInfo = {
		currentPage: 1,
		unitCount: 10,
		totalCount: 0		
	};	
	function eventReg(){
		
		mTableId = window.bapdosa.urlParams["tableId"] || "";
		mOrderId = window.bapdosa.urlParams["orderId"] || "";
		
		//주문영역세팅
		orderArea = $("#order-page .list.minh table tbody");
		
		//카테고리 선택시
		$("#order-page .class-category-area > li").click(function(e){
			//e.preventDefault();
			
			selCategoryId = $(this).attr("categoryId") || "";
			var isService = $(this).attr("isService") || "";
			
			console.log("categoryId: " + selCategoryId + ", isService: " + isService);
			
			$(this).addClass("on").siblings().removeClass("on");			
			$("#order-page .food_list .foodlist ul").empty();			
			if(selCategoryId){
				displayMenu(selCategoryId);
			} else {
				//초기화
				$("#others_menu input[name=otherL]").prop("checked", false).checkboxradio("refresh");
			}			
		});		
		
		//기타카테고리 선택시
		$("#others_menu input[name=otherL]").change(function(e){
			e.preventDefault();
			
			var categoryId = $(this).attr("categoryId") || "";
			var isService = $(this).attr("isService") || "";			
			console.log("categoryId: " + categoryId + ", isService: " + isService);			
			displayMenu(categoryId);			
			$("#others_menu").popup( "close" );
		});
		
		//주문된 요소 선택시
		orderArea.on("click", "tr", function() {
            //console.log($(this).attr("menuId"));            
            $(this).addClass("active").siblings().removeClass("active");
        });
		
		//+버튼클릭(추가)
		$(".class-event-order-add").click(function(e){
			e.preventDefault();
			
			var selOrderDetail = orderArea.children("tr.active");
			if(selOrderDetail.length >= 1){
				//console.log(selOrderDetail);
				countAddMenu(selOrderDetail.attr("orderDetailId"));
				displayTotal();
			} else {
				alert("먼저 주문목록을 선택해 주세요.");
			}
		});
		
		//-버튼클릭(빼기)
		$(".class-event-order-del").click(function(e){
			e.preventDefault();
			
			var selOrderDetail = orderArea.children("tr.active");
			if(selOrderDetail.length >= 1){
				countDelMenu(selOrderDetail.attr("orderDetailId"));
				displayTotal();
			} else {
				alert("먼저 주문목록을 선택해 주세요.");
			}
		});	

		//삭제
		$(".class-event-order-delete").click(function(e){
			e.preventDefault();
			
			var selOrderDetail = orderArea.children("tr.active");
			if(selOrderDetail.length >= 1){
				selOrderDetail.remove();
				displayTotal();
			} else {
				alert("먼저 주문목록을 선택해 주세요.");
			}
		});		
		
		//전체삭제
		$(".class-event-order-delete-all").click(function(e){
			e.preventDefault();			
			if(confirm("정말로 주문전체를 삭제하시겠습니까?")){
				orderArea.empty();
				displayTotal();
			} 	
		});
		
		//서비스버튼클릭
		$(".class-event-order-service").click(function(e){
			e.preventDefault();
			var selOrderDetail = orderArea.children("tr.active");
			if(selOrderDetail.length >= 1){
				setOrderDetailService(selOrderDetail);
				displayTotal();
			} else {
				alert("먼저 주문목록을 선택해 주세요.");
			}			
		});
		//포장버튼클릭
		$(".class-event-order-takeout").click(function(e){
			e.preventDefault();
			var selOrderDetail = orderArea.children("tr.active");
			if(selOrderDetail.length >= 1){
				setOrderDetailTakeout(selOrderDetail);
				displayTotal();
			} else {
				alert("먼저 주문목록을 선택해 주세요.");
			}			
		});	
		
		//저장
		$(".class-event-order-save").click(function(e){
			e.preventDefault();
			beforeOrderSave();
		});		
		
		//직접입력
		$(".fre_pop .class-event-direct-input").click(function(e){
			//e.preventDefault();
			$("#add_fre #add_fre_form")[0].reset();
		});
		
		//연락처입력 on/off
		$("#add_fre_form input[name=isContact]").change(function(e){
			e.preventDefault();
			var checked = $(this).prop("checked");
			//console.log(checked);
			
			if(checked){
				$("#add_fre .fre_addition dl:eq(0)").show();
			} else {
				$("#add_fre .fre_addition dl:eq(0)").hide();
			}			
		});
		//외상잔액입력 on/off
		$("#add_fre_form input[name=isCredit]").change(function(e){
			e.preventDefault();
			var checked = $(this).prop("checked");
			//console.log(checked);
			
			if(checked){
				$("#add_fre .fre_addition dl:eq(1)").show();
				$("#add_fre_form input[name=isDeposit]").prop("checked", false).checkboxradio('refresh').trigger("change");
			} else {
				$("#add_fre .fre_addition dl:eq(1)").hide();
			}			
		});
		//예치금입력 on/off
		$("#add_fre_form input[name=isDeposit]").change(function(e){
			e.preventDefault();
			var checked = $(this).prop("checked");
			//console.log(checked);
			
			if(checked){
				$("#add_fre .fre_addition dl:eq(2)").show();
				$("#add_fre_form input[name=isCredit]").prop("checked", false).checkboxradio('refresh').trigger("change");
			} else {
				$("#add_fre .fre_addition dl:eq(2)").hide();
			}			
		});		
		
		//단골저장
		$("#add_fre .class-event-save").click(function(e){
			e.preventDefault();
			
			
			var name = $.trim($("#add_fre_form input[name=name]").val() || "");
			var isContact = $("#add_fre_form input[name=isContact]").prop("checked");
			var isCredit = $("#add_fre_form input[name=isCredit]").prop("checked");
			var isDeposit = $("#add_fre_form input[name=isDeposit]").prop("checked");
			var totalCredit = $("#add_fre_form input[name=totalCredit]").val();
			var totalDeposit = $("#add_fre_form input[name=totalDeposit]").val();		
			
			var param = "";
			
			if(name == ""){
				alert("이름을 입력해 주세요.");
				return false;
			}
			param = "name=" + name;			
			
			if(isContact){
				var phone1 = $.trim($("#add_fre_form input[name=phone1]").val() || "");
				var phone2 = $.trim($("#add_fre_form input[name=phone2]").val() || "");
				var phone3 = $.trim($("#add_fre_form input[name=phone3]").val() || "");
				
				if(!window.bapdosa.util.isNumeric(phone1) || !window.bapdosa.util.isNumeric(phone2) || !window.bapdosa.util.isNumeric(phone3)){
					alert("연락처는 숫자만 입력가능합니다.");
					return false;
				} else {
					if(phone1.length < 3 || phone1.length < 3 || phone3.length < 4){
						alert("정확한 연락처를 입력해 주세요.");
						return false;
					}
				}				
				var phoneNumber = phone1 + phone2 + phone3; 
				param += "&phoneNumber=" + phoneNumber;
			}
			
			if(isCredit){	
				
				if(totalCredit){
					if(!window.bapdosa.util.isNumeric(totalCredit)){
						alert("외상잔액은 숫자만 입력가능합니다.");
						return false;
					} else {
						param += "&totalCredit=" + totalCredit;
					}
				} else {
					alert("외상잔액을 입력해 주세요.");
					return false;
				}
			}
			
			if(isDeposit){	
				
				if(totalDeposit){
					if(!window.bapdosa.util.isNumeric(totalDeposit)){
						alert("예치금은 숫자만 입력가능합니다.");
						return false;
					} else {
						param += "&totalDeposit=" + totalDeposit;
					}				
				} else {
					alert("예치금을 입력해 주세요.");
					return false;					
				}
			}
			var url="/pos/customer/customerRegister.json";
			
			var success = function(returnJsonVO){
				var returnObj = returnJsonVO.returnObj;
				
				//console.log(returnObj);
				
				if(returnObj){
					
					displayCustomerInfo(returnObj);
					
					$("#add_fre").popup("close");
					$(".fre_pop .ui-link").click();
				}
			};

			commonAjaxCall(url, param, success);
		});	
		
		//단골버튼클릭
		$(".class-event-customer-view").click(function(e){
			customerSearchInfoInit();
			
			searchCustomerList();
			
		});
		
		//ㄱㄴㄷㄹ 클릭
		$(".class-event-search-select-button li").click(function(e){
			e.preventDefault();
			$(this).children("a").addClass("active").end().siblings("li").children("a").removeClass("active");
			customerSearchInfoInit(1);
			searchCustomerList();
		});
		
		//orderBy 변경시
		$("#fre_pop_customer_search input[name=orderBy]").change(function(e){
			customerSearchInfoInit(2);
			searchCustomerList();
		});
		
		//단골고객이름클릭시 
		$(".class-event-search-select-customer").on("click", "a.class-event-customer-select", function(e){
			e.preventDefault();
			//console.log($(this).attr("customerId"));
			
			displayCustomerInfo($(this).attr("customerId"));
//			$(".fre_pop").hide();
//			$("#add_fre").popup("close");
			$(".fre_pop.shw .btn_x").click();
//			$(".fre_box .ui-link").click();
		});
		
		//검색어 입력시
		$("#fre_pop_customer_search input[name=searchName]").on("input", function(e){
			
			//console.log($(this).val());
			
			var search = $.trim($(this).val());
			
			//console.log(window.bapdosa.util.isInitialLetter(search));
			
			if(search.length == 1){
				
				
				if(window.bapdosa.util.isInitialLetter(search)){
					//초성검색 (구현 애매, 위에 초성검색버튼으로 해결바람)
					//searchCustomerList(search);
					return false;
				} else {
					customerSearchInfoInit(3);
					searchCustomerList();
				}
			} else {
				if(search.length > 1){
					//console.log(search.substring(search.length-1));
					
					var lastLetter = search.substring(search.length-1);
					
					//마지막이 한글초성이면 검색하지 않는다.
					if(window.bapdosa.util.isInitialLetter(lastLetter)){
						return false;
					} else {
						customerSearchInfoInit(3);
						searchCustomerList();						
					}
					
					//console.log(window.bapdosa.util.isInitialLetter(lastLetter));
				} else {
					customerSearchInfoInit(3);
					searchCustomerList();
				}
			}
			
			
		});
		
		//계산화면으로 가기
		$(".class-event-account-go").click(function(e){
			e.preventDefault();
			var saveFlag = false;
			var orderAreaList = orderArea.children("tr");
			if(orderAreaList.size() == 0){
				alert("선택한 메뉴가 없습니다.");
				return false;
			}
			
			orderAreaList.each(function(i){					
				var orderDetailId = ($(this).attr("orderDetailId") || "").startsWith("temp_") ? "" : $(this).attr("orderDetailId");
				if(!orderDetailId){
					saveFlag = true;
					return false;
				}
			});	
			var url="/pos/order/account.do?tableId=" + mTableId + "&orderId=" + mOrderId;
			
			if(saveFlag){				
				var afterurl = "/pos/order/account.do?tableId=" + mTableId;
				beforeOrderSave(afterurl);				
			} else {
				
				if(!mIsFirstCustomer && mCustomerId){
					var afterurl = "/pos/order/account.do?tableId=" + mTableId;
					beforeOrderSave(afterurl);						
				} else {
					document.location.href = url;
				}
			}				
		});
		
		//고객주문 버튼클릭
		$(".class-event-customer-request").click(function(e){
			e.preventDefault();			
			
			var orderAreaList = orderArea.children("tr");
			//console.log("orderAreaList.size(): " + orderAreaList.size());
			if(orderAreaList.size() == 0){
				alert("선택한 메뉴가 없습니다.");
				return false;
			}			
			
			if(!mOrderId){
				if(confirm("추가된 메뉴가 있습니다. 저장하시겠습니까?")){
					var afterurl = "/pos/memo/customerRequest.do?tableId=" + mTableId;
					beforeOrderSave(afterurl);	
					return false;
				} else {
					return false;
				}
			} else {
				
				var isDiffFlag = false;
				var orderAreaFirstList = mOrderAreaFirst.children("tr");
				$.each(orderAreaFirstList, function(i,obj){	
					//console.log(obj);
					var flag = true;
					$.each(orderAreaList, function(i2,obj2){	
						//console.log(obj2);
						//console.log($(obj).attr("orderDetailId") + " : " + $(obj2).attr("orderDetailId"));
						//console.log(($(obj).attr("orderDetailId") || "").startsWith("temp_"));
						if( ($(obj2).attr("orderDetailId") || "").startsWith("temp_") ){
							//console.log("startsWith(temp_) ");
							flag = true;
							return true;							
						} else if($(obj).attr("orderDetailId") == $(obj2).attr("orderDetailId")){		
							//console.log($(obj).children("td:eq(1)").text() + " : " + $(obj2).children("td:eq(1)").text());
							if($(obj).children("td:eq(1)").text() == $(obj2).children("td:eq(1)").text()){
								flag = false;
								//return false;
							} else {
								flag = true;
								return false;
							}
						}				
					});	
					
					//console.log("flag: " + flag);
					if(flag){
						isDiffFlag = true;
						return false;
					}					
				});	
				
				//console.log("isDiffFlag:" + isDiffFlag);
				
				if(isDiffFlag){					
					var afterurl = "/pos/memo/customerRequest.do?tableId=" + mTableId;
					beforeOrderSave(afterurl);	
					return false;
				}				
			}
			
			document.location.href="/pos/memo/customerRequest.do?tableId=" + mTableId + "&orderId=" + mOrderId;
		});
		
		
		//메모 버튼클릭
		$(".class-event-memo-register").click(function(e){
			e.preventDefault();		
			var returnUrl = $.base64Encode(document.location.href);
			//console.log(document.location.href);
			document.location.href="/pos/memo/memoRegister.do?tableId=" + mTableId + "&orderId=" + mOrderId + "&returnUrl=" + returnUrl;
		});		
		
		//예약버튼클릭		
		$(".class-event-reservation").click(function(e){
			e.preventDefault();		
			var returnUrl = $.base64Encode(document.location.href);
			//console.log(document.location.href);
			document.location.href="/pos/memo/reservation.do?tableId=" + mTableId + "&orderId=" + mOrderId + "&returnUrl=" + returnUrl;
		});			
	}
	
	
	
	//단골고객정보를 가져와서 뿌린다.
	function searchCustomerList(searchInitialLetter){
		var orderBy = $("#fre_pop_customer_search input[name=orderBy]:checked").val() || "";
		var orderOption = "ASC";
		if(orderBy == "TOTALSALES"){
			orderOption = "DESC";
		}
		var page = customerSearchInfo.currentPage;
		var unitCount = customerSearchInfo.unitCount;
		var notNoName = "Y";
		var initialLetter =  $(".class-event-search-select-button li a.active > span").attr("title") || "";
		var searchName = $.trim($("#fre_pop_customer_search input[name=searchName]").val() || "");
		
		//console.log("orderBy: " + orderBy + ", initialLetter: " + initialLetter + ", searchName:" + searchName);

		var url="/pos/customer/getCustomerList.json";
		var param="searchName=" + searchName + "&orderBy=" + orderBy + "&initialLetter=" + initialLetter + "&page=" + page + "&unitCount=" + unitCount + "&notNoName=" + notNoName;
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			//console.log(returnObj);
			var customerMapList = returnObj.customerMapList;
			var customerArea = $(".class-event-search-select-customer");
			$(customerMapList).each(function(i,obj){
				//console.log(obj);
				//<li><a href="#">김치과</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
				//<li><a href="#">세무그룹정명 <strong class="tc">17</strong></a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li><!-- 외상인 경우 -->
				//<li><a href="#">세무그룹 <strong class="ty">17</strong></a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li><!-- 예치금인 경우 -->
				var li = $("<li>");
				var a1 = $("<a>", {
					href: '#',
					customerId: obj.CUSTOMERID
				}).addClass("class-event-customer-select").text(obj.NAME);
				//외상이 있는경우
				if(obj.TOTALCREDIT > 0){
					a1.append($("<strong>").addClass("tc").text(window.bapdosa.util.setComma(parseInt(obj.TOTALCREDIT/1000))))
				}
				//예치금이 있는경우
				if(obj.TOTALDEPOSIT > 0){
					a1.append($("<strong>").addClass("ty").text(window.bapdosa.util.setComma(parseInt(obj.TOTALDEPOSIT/1000))))
				}	
				var a2 = $("<a>",{
					href: '#guest_detail',
					title: '자세히보기',
					customerId: obj.CUSTOMERID
						
				}).addClass("btn_go2").attr("data-rel", "popup").attr("data-position-to", "window").attr("data-transition", "pop");
				
				li.append(a1)
							.append(a2);
				customerArea.append(li);
			});
			
		};
		commonAjaxCall(url, param, success);		
		
	}
	
	//단골검색관련 초기화
	function customerSearchInfoInit(type){
		customerSearchInfo = {
				currentPage: 1,
				unitCount: 10,
				totalCount: 0				
			};
		
		//ㄱㄴㄷㄹ 검색시
		if(type == 1){
			$(".class-event-search-select-customer li:eq(0)").siblings("li").remove();
			//$("#fre_pop_customer_search input[name=searchName]").val("");			
		}
		//orderby 클릭시
		else if(type == 2){
			$(".class-event-search-select-customer li:eq(0)").siblings("li").remove();
		}
		//검색어 검색시
		else if(type ==3){
			$(".class-event-search-select-customer li:eq(0)").siblings("li").remove();
		}		
		else{		
			$(".class-event-search-select-button li:eq(0)").children("a").addClass("active").end().siblings("li").children("a").removeClass("active");
			$(".class-event-search-select-customer li:eq(0)").siblings("li").remove();
			$("#fre_pop_customer_search input[name=searchName]").val("");
			$("#fre_pop_customer_search input[name=orderBy][value='NAME']").prop("checked", true);	
			$("#fre_pop_customer_search input[name=orderBy]").checkboxradio("refresh");
		}
		
	}	
	
	//해당 customerId 로 고객정보를 가져와 뿌려준다.
	function displayCustomerInfo(customerId){
		var url="/pos/customer/getCustomerInfo.json";
		var param = "customerId=" + customerId;
		
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;			
			//console.log(returnObj);
			
			if(returnObj){				
				mCustomerId = returnObj.CUSTOMERID;
				
				
				// 이명필
				//<span class="ico c">외</span> <span><em class="tc">117</em> / 1,256</span>
				//<span class="ico y">예</span><span><em class="ty">117</em> / 1,256</span>	
				
				
				var customerArea = $(".class-area-customer-info").empty().text(returnObj.NAME + " ");
				var iconAdd;
				var addInfo ;
				
				if(returnObj.TOTALCREDIT > 0){
					iconAdd = $("<span>").addClass("ico").addClass("c").text("외");
					addInfo = $("<span>").append(
							  				$("<em>").addClass("tc").text(window.bapdosa.util.setComma(parseInt(returnObj.TOTALCREDIT/1000)))
							  			).append(
					  							" / " + window.bapdosa.util.setComma(parseInt(returnObj.TOTALSALES/1000))
					  					);
				} else if(returnObj.TOTALDEPOSIT > 0){
					iconAdd = $("<span>").addClass("ico").addClass("y").text("예");
					addInfo = $("<span>").append(
					  						$("<em>").addClass("ty").text(window.bapdosa.util.setComma(parseInt(returnObj.TOTALDEPOSIT/1000)))
					  					).append(
					  							" / " + window.bapdosa.util.setComma(parseInt(returnObj.TOTALSALES/1000))
					  					);					
				} else {
					addInfo = $("<span>").append(
					  							window.bapdosa.util.setComma(parseInt(returnObj.TOTALDEPOSIT/1000))
					  					).append(
					  							" / " + window.bapdosa.util.setComma(parseInt(returnObj.TOTALSALES/1000))
					  					);
				}
				if(iconAdd){
					customerArea.append(iconAdd);
				}
				customerArea.append(addInfo);
				
				
				//console.log("ok");
				
			}
		};

		commonAjaxCall(url, param, success);		
	}
	
	function beforeOrderSave(afterurl){
		var orderAreaList = orderArea.children("tr");
		
		var orderDataList = [];
		orderAreaList.each(function(i){	
			var deviceId = $(this).attr("deviceId") || "";
			var menuId = $(this).attr("menuId") || "";
			var menuName = $(this).attr("menuName") || "";
			var orderDetailId = ($(this).attr("orderDetailId") || "").startsWith("temp_") ? "" : $(this).attr("orderDetailId");
			var orderCount = parseInt($(this).find("td:eq(1)").text());
			var originalPrice = 0;
			var discountPrice = 0; 
			var takeoutPrice =  parseInt($(this).attr("takeoutPrice"));
			var storePrice =  parseInt($(this).attr("storePrice"));
			var takeoutDiscount =  parseInt($(this).attr("takeoutDiscount"));
			var storeDiscount =  parseInt($(this).attr("storeDiscount"));			
			var isService = $(this).attr("isService") || "";		
			var isTakeout = $(this).attr("isTakeout") || "";
			var newFlag = $(this).attr("newFlag") || "N";			
			
			//if(isPriceDiffer == "Y"){
				if(isTakeout == "Y"){
					originalPrice = takeoutPrice; 
					discountPrice = takeoutPrice;
					//할인시간대이면
					if(mIsDcPrice){
						discountPrice = takeoutDiscount;
					}					
				} else {
					originalPrice = storePrice;
					discountPrice = storePrice;
					//할인시간대이면
					if(mIsDcPrice){
						discountPrice = storeDiscount;
					}					
				}				
			//}			
			
			if(isService == "Y"){
				discountPrice = 0;
			}
			//originalPrice = originalPrice * orderCount;
			
			var data = {
					orderDetailId : orderDetailId,
					menuId: menuId,
					menuName: menuName,
					quantity: orderCount,
					isTakeout: isTakeout,
					isService: isService,
					originalPrice: originalPrice,
					discountPrice: discountPrice,
					newFlag: newFlag
			}
			orderDataList.push(data);
		});	
		
		var orderObj = {
				tableId: mTableId,
				orderId: mOrderId,
				customerId: mCustomerId,
				orderDataList: orderDataList
		};
		
		orderObjJson = JSON.stringify(orderObj);			
		//console.log(JSON.stringify(orderObj));
		orderSave(orderObjJson, afterurl);		
	}
	
	function orderSave(orderObjJson, afterurl){
		
		var url="/pos/order/orderSave.json";
		var param="orderObjJson=" + orderObjJson;
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			
			//console.log(returnObj);
			
			if(afterurl){
				var returnUrl = document.location.href;
				if(!mOrderId){
					returnUrl += returnObj;
				}
				returnUrl = $.base64Encode(returnUrl);
				document.location.href = afterurl + "&orderId=" + returnObj + "&returnUrl=" + returnUrl;
			} else {
				history.back();
			}
		};

		commonAjaxCall(url, param, success);		
	}	
	
	//선택한 주문을 포장으로 세팅
	function setOrderDetailTakeout(selOrderDetail){
		if(selOrderDetail.attr("isTakeout") == "Y"){
			selOrderDetail.attr("isTakeout", "N");
			selOrderDetail.find("td:eq(0) .ico.p").remove();			
		} else {
			selOrderDetail.attr("isTakeout", "Y");
			selOrderDetail.find("td:eq(0)").prepend(
					$("<span>").addClass("ico")
					   .addClass("p")
					   .text("포")
			);
		}		
		setOrderDetailPriceSync(selOrderDetail);
	}	
	
	//선택한 주문을 서비스로 세팅
	function setOrderDetailService(selOrderDetail){
		if(selOrderDetail.attr("isService") == "Y"){
			selOrderDetail.attr("isService", "N");
			selOrderDetail.find("td:eq(0) .ico.s").remove();			
		} else {
			selOrderDetail.attr("isService", "Y");
			selOrderDetail.find("td:eq(0)").prepend(
					$("<span>").addClass("ico")
					   .addClass("s")
					   .text("서")
			);
		}		
		setOrderDetailPriceSync(selOrderDetail);
	}
	
	function setOrderDetailPriceSync(selArea){		
		var orderCount = parseInt(selArea.find("td:eq(1)").text());		
		var displaylPrice = 0;
		var takeoutPrice =  parseInt(selArea.attr("takeoutPrice"));
		var storePrice =  parseInt(selArea.attr("storePrice"));
		var takeoutDiscount =  parseInt(selArea.attr("takeoutDiscount"));
		var storeDiscount =  parseInt(selArea.attr("storeDiscount"));		
		var isService = selArea.attr("isService") || "";
		var isTakeout = selArea.attr("isTakeout") || "";		
					
		if(isTakeout == "Y"){
			displaylPrice = takeoutPrice; 
			//할인시간대이면
			if(mIsDcPrice){
				displaylPrice = takeoutDiscount;
			}			
		} else {
			displaylPrice = storePrice;
			//할인시간대이면
			if(mIsDcPrice){
				displaylPrice = storeDiscount;
			}				
		}
		
		if(isService == "Y"){
			displaylPrice = 0;
		}
		selArea.find("td:eq(1)").text(orderCount);
		selArea.find("td:eq(3)").text(window.bapdosa.util.setComma(displaylPrice * orderCount));			
	}
	
	//total개수, 합계금액 계산
	function displayTotal(){
		var orderAreaList = orderArea.children("tr");
		var sumPrice = 0;
		orderAreaList.each(function(i){				
			var orderCount = parseInt($(this).find("td:eq(1)").text());
			var orderPrice = parseInt(window.bapdosa.util.getNumberOnly($(this).find("td:eq(3)").text()));
//			
//			var defaultPrice =  parseInt($(this).attr("storePrice"));			
//			var isService = $(this).attr("isService") || "";		
//			var isTakeout = $(this).attr("isTakeout") || "";
//			if(isPriceDiffer == "Y"){
//				if(isTakeout == "Y"){
//					defaultPrice = parseInt($(this).attr("takeoutPrice")); 
//				} else {
//					defaultPrice = parseInt($(this).attr("storePrice"));
//				}				
//			}			
//			
//			if(isService == "Y"){
//				defaultPrice = 0;
//			}
			sumPrice += orderPrice;
		});	
		
		$("#order-page .paging_count > span").text(orderAreaList.size());
		$("#order-page .price_total > span").text(window.bapdosa.util.setComma(sumPrice));
	}
	
	function displayMenu(categoryId){
		var menuBody = $("#order-page .food_list .foodlist ul");
		menuBody.empty();
		
		$(categoryInfoList).each(function(index,categoryObj){
			//console.log(categoryObj);
			if(categoryObj.CATEGORYID == categoryId){
				var categoryMenuList = categoryObj.categoryMenuList;
				
				$(categoryMenuList).each(function(c_index, menuObj){
					//console.log(menuObj);
					if(menuObj.ISHIDDEN == "Y"){
						return;
					}
					//<li><span class="name">양념갈비 - 호주 양념갈비 - 호주</span><span>20</span></li>
					
					var li = $("<li>",{						
						categoryId : menuObj.CATEGORYID,
						menuId : menuObj.MENUID,
						click : function(e){
							e.preventDefault();
							orderMenu($(this).attr("categoryId"), $(this).attr("menuId"));
						}						
					}).append($("<span>").addClass("name").text(menuObj.NAME))
									  .append($("<span>").text(parseInt(menuObj.STOREPRICE)/1000));
					menuBody.append(li);
				});
				
				return false;
			}
		});		
	}
	
	function countAddMenu(orderDetailId){
		var selArea = orderArea.find("tr[orderDetailId='" + orderDetailId + "']");		
		var orderCount = parseInt(selArea.find("td:eq(1)").text()) + 1;
		selArea.find("td:eq(1)").text(orderCount);
		setOrderDetailPriceSync(selArea);	
	}
	
	function countDelMenu(orderDetailId){
		var selArea = orderArea.find("tr[orderDetailId='" + orderDetailId + "']");		
		var orderCount = parseInt(selArea.find("td:eq(1)").text()) - 1;

		if(orderCount < 1){
			selArea.remove();
		} else {		
			selArea.find("td:eq(1)").text(orderCount);			
			setOrderDetailPriceSync(selArea);
		}
	}	
	
	//메뉴선택하여 주문처리
	function orderMenu(categoryId, menuId, orderDetailId){
		var now_hm = moment().format('h:mm');
		var selMenuObj ;
		var selCategoryIsService;
	
		if(orderDetailId){
			countAddMenu(orderDetailId);
		} else{
			
			var orderFlag = true;
			orderArea.children("tr").each(function(i){				
				if($(this).attr("newFlag") == "Y" && $(this).attr("categoryId") == categoryId && $(this).attr("menuId") == menuId){
					//console.log($(this).attr("orderDetailId"));
					countAddMenu($(this).attr("orderDetailId"));
					orderFlag = false;
					return false;
				}
			});			
			
			if(orderFlag){
				$(categoryInfoList).each(function(index,categoryObj){
					//console.log(categoryObj);
					if(categoryObj.CATEGORYID == categoryId){
						var categoryMenuList = categoryObj.categoryMenuList;
						
						$(categoryMenuList).each(function(c_index, menuObj){								
							if(menuObj.MENUID == menuId){
								selMenuObj = menuObj;
								selCategoryIsService = categoryObj.ISSERVICE;
								return false;
							}							
						});						
						return false;
					}
				});		
				
				if(selMenuObj){	
					
					//var displayPrice = selMenuObj.STOREPRICE;
					var displayPrice = selMenuObj.STOREPRICE;
					
					
					if(mIsDcPrice){
						displayPrice = selMenuObj.STOREPRICE * ((100-selMenuObj.STOREDISCOUNT)/100);
					}
					
					console.log("selMenuObj.STOREDISCOUNT: " + selMenuObj.STOREDISCOUNT);
					
					var td1 = $("<td>").addClass("a_tl")
					 				   .text(selMenuObj.NAME);
					if(selCategoryIsService == "Y"){
						
						//<span class="ico s">서</span>
						
						td1.prepend(
								$("<span>").addClass("ico")
										   .addClass("s")
										   .text("서")
						);
						
						displayPrice = 0;
					}
					
					$("<tr>", {
						deviceId: '',
						orderDetailId: 'temp_' + new Date().getTime(),
						categoryId: categoryId,
						menuId: menuId,
						menuName: selMenuObj.NAME,
						storePrice: selMenuObj.STOREPRICE,
						takeoutPrice: selMenuObj.TAKEOUTPRICE,
						storeDiscount: selMenuObj.STOREPRICE * ((100-selMenuObj.STOREDISCOUNT)/100),
						takeoutDiscount: selMenuObj.TAKEOUTPRICE * ((100-selMenuObj.TAKEOUTDISCOUNT)/100),
						isService: selCategoryIsService,
						isTakeout: "N",
						newFlag: "Y"
					}).append(td1)
					.append(
						$("<td>").text("1")	
					).append(
						$("<td>").text(now_hm)
					).append(
						$("<td>").addClass("price")
	 	 				   .text(window.bapdosa.util.setComma(displayPrice))
					)
					.appendTo(orderArea);
				}
			}
		}
		
		displayTotal();
		
		
/*		<tr>
		<td class="a_tl"><span class="ico p">포</span>소갈비 - 한우</td>
		<td>3</td>
		<td>16:43</td>
		<td class="price">60,000</td>
		</tr>	*/	
		
	}
	
	function getCategoryInfoList(){
		var dfd = new jQuery.Deferred();
		var url="/pos/category/getCategoryJsonList.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			isPriceDiffer = returnObj.isPriceDiffer;
			isDPdiffer = returnObj.isDPdiffer;
			categoryInfoList = returnObj.categoryJsonList;
			//console.log(categoryInfoList);
			
			mDcTimezoneSet = returnObj.dcTimezoneSet;
			mLunchTimezoneSet = returnObj.lunchTimezoneSet;

			$(categoryInfoList).each(function(index,obj){
				//console.log(obj);
				if(index < 4){
					var selLi = $("#order-page .class-category-area > li:eq(" + index + ")");
					
					selLi.attr("categoryId", obj.CATEGORYID)
						 .attr("isService", obj.ISSERVICE)
						 .find("a").text(obj.NAME);
				} else {
					var selInput = $("#others_menu .menu_list ul > li input:eq(" + (index - 4) + ")");
					selInput.attr("categoryId", obj.CATEGORYID)
							.attr("isService", obj.ISSERVICE)
							.prev("label").text(obj.NAME);
				}
			});
			
			//첫번째 카테고리 선택된 메뉴 뿌려주기
			var firstCategoryId = $("#order-page .class-category-area > li:eq(0)").attr("categoryId");
			displayMenu(firstCategoryId);
			
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
	
	function isTimeZoneCheck(nowHHMM, nowWeek, timezoneSet){
//		var nowHHMM = moment().format('HHmm');
//		var nowWeek = moment().format('E');
		console.log("nowWeek: " + nowWeek);
		console.log("nowHHMM: " + nowHHMM);		
		
		console.log("ISUSEDTIME" + nowWeek + ": " + timezoneSet["ISUSEDTIME" + nowWeek]);
		console.log("STARTTIME" + nowWeek + ": " + timezoneSet["STARTTIME" + nowWeek]);
		console.log("ENDTIME" + nowWeek + ": " + timezoneSet["ENDTIME" + nowWeek]);
		var returnVal = false;
	
		if(timezoneSet["ISUSEDTIME" + nowWeek] == 'Y'){
			if(nowHHMM >= timezoneSet["STARTTIME" + nowWeek] &&  nowHHMM  <= timezoneSet["ENDTIME" + nowWeek]){
				returnVal = true; 
			}
		}
		
		return returnVal;
		
	}
	
	function getOrderInfoList(){
		
		if(!mOrderId){
			var nowHHMM = moment().format('HHmm');
			var nowWeek = moment().format('E');			
			
			mIsDcPrice = isTimeZoneCheck(nowHHMM, nowWeek, mDcTimezoneSet);
			mIsLunchTime = isTimeZoneCheck(nowHHMM, nowWeek, mLunchTimezoneSet);
			
			return false;
		}
		
		var url="/pos/order/getOrderInfoList.json";
		var param="tableId=" + mTableId + "&orderId=" + mOrderId;
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			//console.log(returnObj);
			var orderDetailList = returnObj.orderDetailList;
			var orderInfoObj = returnObj.orderInfo;
			//var startSalesDate = orderInfoObj.STARTSALESDATE;
			var nowHHMM = moment(orderInfoObj.CREATIONDATE).format('HHmm');
			var nowWeek = moment(orderInfoObj.STARTSALESDATE, "YYYYMMDD").format('E');
			mIsDcPrice = isTimeZoneCheck(nowHHMM, nowWeek, mDcTimezoneSet);
			mIsLunchTime = isTimeZoneCheck(nowHHMM, nowWeek, mLunchTimezoneSet);				
			
			$(orderDetailList).each(function(index,obj){
				//console.log(obj);
				addOrder(obj);
			});	
			
			displayTotal();
			
			if(orderInfoObj.CUSTOMERID){
				mIsFirstCustomer = true;
				displayCustomerInfo(orderInfoObj.CUSTOMERID);
			}		
			
			mOrderAreaFirst = orderArea.clone();
			
		};
		commonAjaxCall(url, param, success);
	}
	
	function addOrder(orderObj){
		var orderDetailId = orderObj.ORDERDETAILID;
		var categoryId = orderObj.CATEGORYID;
		var menuId = orderObj.MENUID;
		var now_hm = orderObj.CREATIONDATE.hours + ":" + orderObj.CREATIONDATE.minutes;
		var selMenuObj ;
		var selCategoryIsService = orderObj.ISSERVICE;	
		var isTakeout = orderObj.ISTAKEOUT;

		$(categoryInfoList).each(function(index,categoryObj){
			//console.log(categoryObj);
			if(categoryObj.CATEGORYID == categoryId){
				var categoryMenuList = categoryObj.categoryMenuList;
				
				$(categoryMenuList).each(function(c_index, menuObj){								
					if(menuObj.MENUID == menuId){
						selMenuObj = menuObj;
						return false;
					}							
				});						
				return false;
			}
		});		
		
		if(selMenuObj){	
			
			var displayPrice = selMenuObj.STOREDISCOUNT;
//			if(isPriceDiffer == "Y"){
//				displayPrice = selMenuObj.STOREPRICE;
//			}
			
			var td1 = $("<td>").addClass("a_tl")
			 				   .text(orderObj.MENUNAME);
			
			if(isTakeout == "Y"){
				td1.prepend(
						$("<span>").addClass("ico")
						   .addClass("p")
						   .text("포")
				);		
				//if(isPriceDiffer == "Y"){
					displayPrice = selMenuObj.TAKEOUTDISCOUNT;
				//}				
			}
			
			if(selCategoryIsService == "Y"){						
				//<span class="ico s">서</span>						
				td1.prepend(
						$("<span>").addClass("ico")
								   .addClass("s")
								   .text("서")
				);						
				displayPrice = 0;
			}
			
			var tr = $("<tr>", {
				deviceId: '',
				orderDetailId: orderDetailId,
				categoryId: categoryId,
				menuId: menuId,
				menuName: orderObj.MENUNAME,
				storePrice: isTakeout == 'Y' ? selMenuObj.STOREPRICE : orderObj.ORIGINALPRICE,
				takeoutPrice: isTakeout == 'Y' ? orderObj.ORIGINALPRICE : selMenuObj.TAKEOUTPRICE,
				storeDiscount: isTakeout == 'Y' || selCategoryIsService == 'Y' ? selMenuObj.STOREPRICE * (100-selMenuObj.STOREDISCOUNT)/100 : orderObj.DISCOUNTPRICE,
				takeoutDiscount: isTakeout == 'Y' ? selCategoryIsService == 'Y' ? selMenuObj.TAKEOUTPRICE * (100-selMenuObj.TAKEOUTDISCOUNT)/100: orderObj.DISCOUNTPRICE : selMenuObj.TAKEOUTPRICE * (100-selMenuObj.TAKEOUTDISCOUNT)/100,
				isService: selCategoryIsService,
				isTakeout: isTakeout,
				newFlag: "N"
			}).append(td1)
			.append(
				$("<td>").text(orderObj.QUANTITY)	
			).append(
				$("<td>").text(now_hm)
			).append(
				$("<td>").addClass("price")
 				   .text(window.bapdosa.util.setComma(displayPrice*orderObj.QUANTITY))
			);
			tr.appendTo(orderArea);
			
			setOrderDetailPriceSync(tr);
		}
	}
	
	function displayTableInfo(){
		var url="/pos/setting/getTableInfo.json";
		var param="tableId=" + mTableId;
		var success = function(returnJsonVO){
			var tableInfoObj = returnJsonVO.returnObj;
			//console.log(tableInfoObj);
			
			$("#order-page .class-area-table-name").text(tableInfoObj.TABLENAME)
			
		};
		commonAjaxCall(url, param, success);		
	}
	
	return {
		init: function() {
			eventReg();
			
			$.when(getCategoryInfoList()).then (
				function(status){
					console.log("status: " + status);
					getOrderInfoList();
				}			
			);			
			
			displayTableInfo();
		},
	
		mVarInfo: function(){		
			console.log("mIsDcPrice: " + mIsDcPrice);
			console.log("mIsLunchTime: " + mIsLunchTime);
		}
	}   
})();

