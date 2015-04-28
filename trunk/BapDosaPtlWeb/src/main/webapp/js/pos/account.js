if (!window.bapdosa.account) {
    if(!window.bapdosa.account) window.bapdosa.account = {};
}

$(document).ready(function(){		
	window.bapdosa.account.init();
});


$(document).on("mobileinit", function () {
    //$.mobile.ajaxEnabled = false;
});

window.bapdosa.account = (function() {
	var mTableId = ""; //테이블아이디
	var mOrderId = ""; //주문번호
	var mFoodPrice = 0;	//고객ID
	
	//고객정보
	var mCustomerInfo = {
			customerId: "",
			name: 10,
			totalCredit: 0,
			totalDeposit: 0			
		};		
	
	var isPriceDiffer;
	var isDPdiffer;
	var categoryInfoList;
	var selCategoryId;
	var mOrderDetailList;
	
	function eventReg(){
		
		mTableId = window.bapdosa.urlParams["tableId"] || "";
		mOrderId = window.bapdosa.urlParams["orderId"] || "";
		
		$(".class-event-credit-all").click(function(e){
			e.preventDefault();			
			$("#form_account input[name=creditAmount]").val(window.bapdosa.util.setComma(mCustomerInfo.totalCredit));
			initForm();
		});		
		
		$('.opn01').click(function(e){
			if($(this).hasClass("closed")){
				
				var lossAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=lossAmount]").val() || "0"));
				var discountAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=discountAmount]").val() || "0"));
				
				if(lossAmount > 0 || discountAmount > 0){
					if(confirm("손실및 할인 항목에 금액이 입력되어 있습니다.\n손실및 할인을 취소하시겠습니까?")){
						$("#form_account input[name=lossAmount]").val("0");
						$("#form_account input[name=discountAmount]").val("0").trigger("input");
						$('.tb01').toggleClass('shv');
						$('.tb01 .op_blt').toggleClass('closed');						
					} else {
						e.preventDefault();
					}
				} else {
					$('.tb01').toggleClass('shv');
					$('.tb01 .op_blt').toggleClass('closed');					
				}
			} else {
				$('.tb01').toggleClass('shv');
				$('.tb01 .op_blt').toggleClass('closed');				
			}
		});
		
		$("#form_account input[name=creditAmount],#form_account input[name=lossAmount],#form_account input[name=discountAmount], #form_account input[name=creditAmount]").on("input", function(e){
			e.preventDefault();
			var creditAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=creditAmount]").val() || "0"));
			var lossAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=lossAmount]").val() || "0"));
			var discountAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=discountAmount]").val() || "0"));	
			
			if(creditAmount > mCustomerInfo.totalCredit){
				$("#form_account input[name=creditAmount]").val(window.bapdosa.util.setComma(mCustomerInfo.totalCredit)).attr("beforeAmount", mCustomerInfo.totalCredit);
				return false;
			}
			
			if( (lossAmount+discountAmount) >  mFoodPrice){
				lossAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=lossAmount]").attr("beforeAmount") || "0"));
				discountAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=discountAmount]").attr("beforeAmount") || "0"));
				$("#form_account input[name=lossAmount]").val(window.bapdosa.util.setComma(lossAmount)).attr("beforeAmount", lossAmount);
				$("#form_account input[name=discountAmount]").val(window.bapdosa.util.setComma(discountAmount)).attr("beforeAmount", discountAmount);	
				
				return false;
			}			
			
			$("#form_account input[name=creditAmount]").val(window.bapdosa.util.setComma(creditAmount)).attr("beforeAmount", creditAmount);
			$("#form_account input[name=lossAmount]").val(window.bapdosa.util.setComma(lossAmount)).attr("beforeAmount", lossAmount);
			$("#form_account input[name=discountAmount]").val(window.bapdosa.util.setComma(discountAmount)).attr("beforeAmount", discountAmount);			
			
			initForm();			
		});
		
		//현금이 입력되면 카드금액은 0으로 한다.
		$("#form_account input[name=cash]").on("input", function(e){
			e.preventDefault();
			var cash = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=cash]").val() || "0"));
			var cardAmount = 0;
			
			$("#form_account input[name=cash]").val(window.bapdosa.util.setComma(cash)).attr("beforeAmount", cash);
			$("#form_account input[name=cardAmount]").val(window.bapdosa.util.setComma(cardAmount)).attr("beforeAmount", cardAmount);	
			balanceAccounts();
		});	
		
		//카드금액변경시
		$("#form_account input[name=cardAmount]").on("input", function(e){
			e.preventDefault();
			var cardAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=cardAmount]").val() || "0"));
			
			$("#form_account input[name=cardAmount]").val(window.bapdosa.util.setComma(cardAmount)).attr("beforeAmount", cardAmount);
			balanceAccounts();
		});	
		
		//카드 all 버튼클릭 (현금 0으로 세팅)
		$(".class-event-card-all").click(function(e){
			e.preventDefault();		
			//청구금액
			var chargeAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=chargeAmount]").val() || "0"));	
			$("#form_account input[name=cash]").val("0").attr("beforeAmount", 0);
			$("#form_account input[name=cardAmount]").val(chargeAmount).trigger("input");
		});		
		
		//카드 나머지 버튼클릭 (더받을돈으로)
		$(".class-event-card-left").click(function(e){
			e.preventDefault();		
			//청구금액
			var addAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=addAmount]").val() || "0"));	
			$("#form_account input[name=cardAmount]").val(addAmount).trigger("input");
		});	
		
		
		//예치금사용 all 버튼클릭 (현금 0으로 세팅)
		$(".class-event-deposit-all").click(function(e){
			e.preventDefault();		
			//청구금액
			var chargeAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=chargeAmount]").val() || "0"));	
			var cashAmount = 0;
			
			if(mCustomerInfo.totalDeposit < chargeAmount){
				cashAmount = chargeAmount - mCustomerInfo.totalDeposit; 
				chargeAmount = mCustomerInfo.totalDeposit; 
			}
			
			initForm();
			$("#form_account input[name=cash]").val(cashAmount).attr("beforeAmount", cashAmount);
			$("#form_account input[name=depositAmount]").val(chargeAmount).trigger("input");
		});			
		
		$("#account-page .cash_list ul").on("click", "li", function(e){
			e.preventDefault();
			var recommendPrice = parseInt(window.bapdosa.util.getNumberOnly($(this).attr("recommendPrice") || "0"));
			
			$("#form_account input[name=cash]").val(window.bapdosa.util.setComma(recommendPrice)).trigger("input");	
			
		});

	}
	
	//거스름돈과 더받을돈을 계산하여 입력한다.
	function balanceAccounts(){
		var cash = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=cash]").val() || "0"));
		var cardAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=cardAmount]").val() || "0"));
		//청구금액
		var chargeAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=chargeAmount]").val() || "0"));	
		var changeAmount = 0;	//거스름돈
		var addAmount = 0;		//더받을돈			
		var cashCardAmount = cash + cardAmount;
		
		if(cashCardAmount > chargeAmount){
			changeAmount = cashCardAmount - chargeAmount;
		} else {
			addAmount = chargeAmount - cashCardAmount;
		}
		
		$("#form_account input[name=changeAmount]").val(window.bapdosa.util.setComma(changeAmount)).attr("beforeAmount", changeAmount);
		$("#form_account input[name=addAmount]").val(window.bapdosa.util.setComma(addAmount)).attr("beforeAmount", addAmount);		
	}
	
	//입력금액 초기화
	function initForm(){

		var totalPrice = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=foodPrice]").val() || "0"));
		console.log(totalPrice);
		var creditAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=creditAmount]").val() || "0"));
		var lossAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=lossAmount]").val() || "0"));
		var discountAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=discountAmount]").val() || "0"));		
		var chargeAmount = totalPrice + creditAmount - lossAmount - discountAmount;
		$("#form_account input[name=chargeAmount]").val(window.bapdosa.util.setComma(chargeAmount));
		$("#form_account input[name=cash]").val(window.bapdosa.util.setComma(chargeAmount));	
		$("#form_account input[name=cashReceipt]").prop("checked", false).checkboxradio("refresh");
		$("#form_account input[name=cardAmount]").val("0");
		$("#form_account input[name=customPoint]").val("0");
		$("#form_account input[name=creditProcess]").prop("checked", false).checkboxradio("refresh");
		$("#form_account input[name=creditProcess]").prop("creditPay", false).checkboxradio("refresh");
		$("#form_account input[name=creditProcess]").prop("depositProcess", false).checkboxradio("refresh");
		$("#form_account input[name=changeAmount]").val("0");
		$("#form_account input[name=addAmount]").val("0");
		
//		if($(".opn01").hasClass("closed")){
//			//$(this).click();			
//			$('.tb01').toggleClass('shv');
//			$('.tb01 .op_blt').toggleClass('closed');			
//		}
//		
//		if($(".opn02").hasClass("closed")){
//			//$(this).click();			
//			$('.tb02').toggleClass('shv');
//			$('.tb02 .op_blt').toggleClass('closed');		
//		}		
		
		recommendCash();
	}
	
	//현금추천
	function recommendCash(){
		var cashAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=cash]").val() || "0"));
		var default1 = 1000;
		var default2 = 5000;
		var default3 = 10000;
		var default4 = 50000;
		
		function calculator(cash, defaultVal){
			var val = Math.ceil(cash / defaultVal);
			var leftVal = cash % defaultVal;			
			//console.log(val + " : " + leftVal);			
			if(leftVal == 0){
				val = 0;
			}			
			return val*defaultVal;
		}
		
		var recommendVal1 = calculator(cashAmount, default1);
		var recommendVal2 = calculator(cashAmount, default2);
		var recommendVal3 = calculator(cashAmount, default3);
		var recommendVal4 = calculator(cashAmount, default4);		
		
		var ul = $("#account-page .cash_list ul").empty();
		
		if(recommendVal1 > 0){
			ul.append(	$("<li>", {recommendPrice: recommendVal1}).html("<a href='#'>" + window.bapdosa.util.setComma(recommendVal1) + "원</a>")	);
		}
		
		if(recommendVal2 > 0 && recommendVal1 != recommendVal2){
			ul.append(	$("<li>", {recommendPrice: recommendVal2}).html("<a href='#'>" + window.bapdosa.util.setComma(recommendVal2) + "원</a>")	);
		}
		
		if(recommendVal3 > 0 && recommendVal1 != recommendVal3 && recommendVal2 != recommendVal3){
			ul.append(	$("<li>", {recommendPrice: recommendVal3}).html("<a href='#'>" + window.bapdosa.util.setComma(recommendVal3) + "원</a>")	);
		}
		
		if(recommendVal4 > 0 && recommendVal1 != recommendVal4 && recommendVal2 != recommendVal4 && recommendVal3 != recommendVal4){
			ul.append(	$("<li>", {recommendPrice: recommendVal4}).html("<a href='#'>" + window.bapdosa.util.setComma(recommendVal4) + "원</a>")	);
		}		
		
	}
	
	//해당 customerId 로 고객정보를 가져와 뿌려준다.
	function displayCustomerInfo(customerId){
		var url="/pos/customer/getCustomerInfo.json";
		var param = "customerId=" + customerId;
		
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;			
			console.log(returnObj);
			
			if(returnObj){				
				mCustomerInfo.customerId = returnObj.CUSTOMERID;
				mCustomerInfo.name = returnObj.NAME;
				mCustomerInfo.totalCredit = returnObj.TOTALCREDIT;
				mCustomerInfo.totalDeposit = returnObj.TOTALDEPOSIT;
				
				//외상값이 있으면 외상값row 보여주기
				if(mCustomerInfo.totalCredit > 0){
					$("#account-page .class-area-credit").show();
				}
				
				
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
			}
		};	
		commonAjaxCall(url, param, success);		
	}	
	
	function getOrderInfoList(){
		
		if(!mOrderId){
			return false;
		}
		
		var url="/pos/order/getOrderInfoList.json";
		var param="tableId=" + mTableId + "&orderId=" + mOrderId;
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			console.log(returnObj);
			mOrderDetailList = returnObj.orderDetailList;
			var orderInfoObj = returnObj.orderInfo;
			var orderListArea = $(".class-area-order-list");
			var orderListStr = "";
			var totalPrice = 0;
			$(mOrderDetailList).each(function(index,obj){
				var preStr = "";
				if(obj.ISTAKEOUT == "Y"){
					preStr = "(포)";
				}				
				if(obj.ISSERVICE == "Y"){
					preStr +="(서)"
				}	
				
				if(index == 0){
					orderListStr = preStr + obj.MENU_NAME + "(" + obj.QUANTITY + ")";
				} else {
					orderListStr += " " + preStr + obj.MENU_NAME + "(" + obj.QUANTITY + ")"
				}
				
				totalPrice += obj.DISCOUNTPRICE;
			});	
			
			mFoodPrice = totalPrice;
			
			orderListArea.text(orderListStr);
			$("#form_account input[name=foodPrice]").val(window.bapdosa.util.setComma(totalPrice));
			$("#form_account input[name=chargeAmount]").val(window.bapdosa.util.setComma(totalPrice));
			//$("#form_account input[name=cash]").val(window.bapdosa.util.setComma(totalPrice));	
			initForm();
			
			if(orderInfoObj.CUSTOMERID){
				displayCustomerInfo(orderInfoObj.CUSTOMERID);
			}
			
		};
		commonAjaxCall(url, param, success);
	}
	
	function displayTableInfo(){
		var url="/pos/setting/getTableInfo.json";
		var param="tableId=" + mTableId;
		var success = function(returnJsonVO){
			var tableInfoObj = returnJsonVO.returnObj;
			console.log(tableInfoObj);
			
			$("#account-page .class-area-table-name").text(tableInfoObj.TABLENAME)
			
		};
		commonAjaxCall(url, param, success);		
	}		
	
	return {
		init: function() {
			eventReg();		

			getOrderInfoList();
			displayTableInfo();
		}
	}   
})();

