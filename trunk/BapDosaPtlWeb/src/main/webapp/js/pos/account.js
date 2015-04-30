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
	var mFoodPrice = 0;	//음식가격
	var mCreditProcessPrice = 0;	//외상처리금액
	var mCreditPayPrice = 0;		//외상갚기금액
	var mDepositProcessPrice = 0;		//예치하기금액	
	var mStartSalesDate;
	var mOrderName = "";		//주문명(불고기 외)
	
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
		
		$("#form_account input[name=creditAmount],#form_account input[name=lossAmount],#form_account input[name=discountAmount]").on("input", function(e){
			e.preventDefault();
			var creditAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=creditAmount]").val() || "0"));
			var lossAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=lossAmount]").val() || "0"));
			var discountAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=discountAmount]").val() || "0"));	
			
			if(creditAmount > mCustomerInfo.totalCredit){
				creditAmount = mCustomerInfo.totalCredit;
			} 
			
			if( (lossAmount+discountAmount) >  mFoodPrice){
				lossAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=lossAmount]").attr("beforeAmount") || "0"));
				discountAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=discountAmount]").attr("beforeAmount") || "0"));
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
			//현금 콤마처리
			$("#form_account input[name=cash]").val(window.bapdosa.util.setComma(cash)).attr("beforeAmount", cash);
			//카드초기화
			$("#form_account input[name=cardAmount]").val(window.bapdosa.util.setComma(cardAmount)).attr("beforeAmount", cardAmount);	
	
			//옵션초기화
			$("#form_account input[name=creditProcess]").prop("checked", false).checkboxradio("refresh");
			$("#form_account input[name=creditPay]").prop("checked", false).checkboxradio("refresh");	//외상갚기
			$("#form_account input[name=depositProcess]").prop("checked", false).checkboxradio("refresh");				
			balanceAccounts();
		});	
		
		//카드금액변경시
		$("#form_account input[name=cardAmount]").on("input", function(e){
			e.preventDefault();
			
			//청구금액
			var chargeAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=chargeAmount]").val() || "0"));	
			//예치금사용금액
			var depositAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=depositAmount]").val() || "0"));
			//카드금액
			var cardAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=cardAmount]").val() || "0"));	
			//카드금액이 (청구금액+예치금사용금액)보다 높으면 청구금액까지 한다. (제한없음으로 바꿈)
//			if(cardAmount > (chargeAmount + depositAmount)){
//				cardAmount = chargeAmount + depositAmount;
//			}
			
			$("#form_account input[name=cardAmount]").val(window.bapdosa.util.setComma(cardAmount)).attr("beforeAmount", cardAmount);
			
			//예치금초기화
			//$("#form_account input[name=depositAmount]").val("0").attr("beforeAmount", "0");
			//옵션초기화
			$("#form_account input[name=creditProcess]").prop("checked", false).checkboxradio("refresh");
			$("#form_account input[name=creditPay]").prop("checked", false).checkboxradio("refresh");	//외상갚기
			$("#form_account input[name=depositProcess]").prop("checked", false).checkboxradio("refresh");			
		
			balanceAccounts();
		});	
		
		//카드 all 버튼클릭 (현금 0으로 세팅)
		$(".class-event-card-all").click(function(e){
			e.preventDefault();	
			
			//청구금액
			var chargeAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=chargeAmount]").val() || "0"));	
			var depositAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=depositAmount]").val() || "0"));
			
			var cardAmount = chargeAmount - depositAmount;
			
			$("#form_account input[name=cash]").val("0").attr("beforeAmount", 0);
			$("#form_account input[name=cardAmount]").val(cardAmount).trigger("input");
			
		});		
		
		//카드 나머지 버튼클릭 : 청구금액 - (예치금 + 현금), 현금은 많이 낼수 있으므로 청구금액보다 많으면 0
		$(".class-event-card-left").click(function(e){
			e.preventDefault();	
			var chargeAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=chargeAmount]").val() || "0"));
			var cash = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=cash]").val() || "0"));
			var depositAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=depositAmount]").val() || "0"));
			
			var cardAmount = (chargeAmount - (cash+depositAmount)) < 0 ? 0 : (chargeAmount - (cash+depositAmount)); 
			$("#form_account input[name=cardAmount]").val(cardAmount).trigger("input");
		});	
		
		//예치금사용 금액변경시
		$("#form_account input[name=depositAmount]").on("input", function(e){
			e.preventDefault();
			var chargeAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=chargeAmount]").val() || "0"));
			var depositAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=depositAmount]").val() || "0"));
			
			//예치금사용은 청구금액까지만 가능
			if(depositAmount > chargeAmount || depositAmount > mCustomerInfo.totalDeposit){
				depositAmount = chargeAmount > mCustomerInfo.totalDeposit ? mCustomerInfo.totalDeposit : chargeAmount; 
			}
						
			$("#form_account input[name=depositAmount]").val(window.bapdosa.util.setComma(depositAmount)).attr("beforeAmount", depositAmount);
			
			//옵션초기화
			$("#form_account input[name=creditProcess]").prop("checked", false).checkboxradio("refresh");
			$("#form_account input[name=creditPay]").prop("checked", false).checkboxradio("refresh");	//외상갚기
			$("#form_account input[name=depositProcess]").prop("checked", false).checkboxradio("refresh");
			
			balanceAccounts();
		});			
		
		
		//예치금사용 all 버튼클릭 (현금 0으로 세팅)
		$("#form_account input[name=depositUse]").change(function(e){
			e.preventDefault();	
			var checked = $(this).prop("checked");
			
			if(checked){
				$(this).prop("readonly", false);
				$("#form_account input[name=depositAmount]").prop("readonly", false);
			} else {
				$("#form_account input[name=depositAmount]").prop("readonly", true);
			}
			initForm();
			
//			if(checked){
//				//청구금액
//				var chargeAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=chargeAmount]").val() || "0"));	
//				var cashAmount = 0;
//				
//				//청구금액이 예치금보다 클경우는 예치금 최대금액으로
//				if(chargeAmount > mCustomerInfo.totalDeposit){
//					chargeAmount = mCustomerInfo.totalDeposit;
//				}
//				
//				
//				//initForm();
//				//$("#form_account input[name=cash]").val(cashAmount).attr("beforeAmount", cashAmount);
//				//$("#form_account input[name=chargeAmount]").val(chargeAmount).trigger("input");
//			} else {
//				
//			}
		});	
		
//		var creditProcess = $("#form_account input[name=creditProcess]").prop("checked");	//외상처리
//		var creditPay = $("#form_account input[name=creditPay]").prop("checked");			//외상갚기
//		var depositProcess = $("#form_account input[name=depositProcess]").prop("checked");	//예치하기	
		
		//외상처리
		$("#form_account input[name=creditProcess]").change(function(e){
			e.preventDefault();
			var creditProcess = $("#form_account input[name=creditProcess]").prop("checked");	//외상처리
			var addAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=addAmount]").val() || "0"));		//더받을돈
			var depositAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=depositAmount]").val() || "0"));
			var creditAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=creditAmount]").val() || "0"));	//기존외상값갚기처리금액
			if(creditProcess){
				if(mCustomerInfo.totalDeposit > 0){
					var leftDeposit = mCustomerInfo.totalDeposit - depositAmount;
					if(leftDeposit > 0){
						alert("남아있는 예치금이 있습니다.");
						$("#form_account input[name=creditProcess]").prop("checked", false);
					}					
				} 
				
				if(creditAmount > 0){
					alert("외상값 갚기처리시 외상처리할수 없습니다.");
					$("#form_account input[name=creditProcess]").prop("checked", false);
				}
			}
			
			balanceAccounts();
		});
		
		//외상갚기
		$("#form_account input[name=creditPay]").change(function(e){
			e.preventDefault();
			var creditPay = $("#form_account input[name=creditPay]").prop("checked");			//외상갚기
			var depositProcess = $("#form_account input[name=depositProcess]").prop("checked");	//예치하기				

			var changeAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=changeAmount]").val() || "0"));	//거스름돈
			var addAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=addAmount]").val() || "0"));		//더받을돈		
			
			if(creditPay){						
				if(changeAmount > 0) {				
					if(mCustomerInfo.totalCredit <= 0 ) {
						
						alert("남아있는 외상값이 없습니다.");
						$("#form_account input[name=creditPay]").prop("checked", false);
					}			
				} else {
					alert("거스름돈이 없습니다.");
					$("#form_account input[name=creditPay]").prop("checked", false);					
				}
			}
			
			balanceAccounts();
		});	
		
		//예치하기
		$("#form_account input[name=depositProcess]").change(function(e){
			e.preventDefault();
			var creditPay = $("#form_account input[name=creditPay]").prop("checked");			//외상갚기
			var depositProcess = $("#form_account input[name=depositProcess]").prop("checked");	//예치하기				

			var changeAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=changeAmount]").val() || "0"));	//거스름돈
			var addAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=addAmount]").val() || "0"));		//더받을돈					
						
			if(depositProcess){
				
				if(creditPay){
					if(changeAmount > 0) {				
						if(mCustomerInfo.totalCredit > 0 ) {
							changeAmount = changeAmount - mCustomerInfo.totalCredit;
						}				
					}
				}
				
				if(changeAmount <= 0){
					if(creditPay){
						alert("예치할 금액이 없습니다.");
						$("#form_account input[name=depositProcess]").prop("checked", false);
					} else {
						alert("외상값이 남아 있습니다.\n외상갚기를 선택해 주세요.");
						$("#form_account input[name=depositProcess]").prop("checked", false);
					}
					
				}
			}			
			
			balanceAccounts();
		});			
		
		$("#account-page .cash_list ul").on("click", "li", function(e){
			e.preventDefault();
			var recommendPrice = parseInt(window.bapdosa.util.getNumberOnly($(this).attr("recommendPrice") || "0"));
			
			$("#form_account input[name=cash]").val(window.bapdosa.util.setComma(recommendPrice)).trigger("input");	
			
		});
		
		//결재완료
		$(".class-event-account-go").click(function(e){
			e.preventDefault();
			var param = $("#form_account").serialize();			
			
			var foodPrice = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=foodPrice]").val() || "0"));
			var creditAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=creditAmount]").val() || "0"));
			var lossAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=lossAmount]").val() || "0"));
			var discountAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=discountAmount]").val() || "0"));
			var point = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=point]").val() || "0"));
			var chargeAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=chargeAmount]").val() || "0"));
			var depositAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=depositAmount]").val() || "0"));
			var depositUse = $("#form_account input[name=depositUse]:checked").val() || "N";	//예치금사용여부
			var cashReceipt = $("#form_account input[name=cashReceipt]:checked").val() || "N";	//현금영수증 여부
			var cash = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=cash]").val() || "0"));
			var cardAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=cardAmount]").val() || "0"));
			
			var creditProcess = $("#form_account input[name=creditProcess]:checked").val() || "N";		//외상처리
			var creditPay = $("#form_account input[name=creditPay]:checked").val() || "N";				//외상갚기
			var depositProcess = $("#form_account input[name=depositProcess]:checked").val() || "N";	//예치하기		
			
			var customPoint = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=customPoint]").val() || "0"));
			var changeAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=changeAmount]").val() || "0"));	//거스름돈
			var addAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=addAmount]").val() || "0"));			//더받을돈		
			
			if(addAmount > 0){
				alert("더받을돈이 있습니다.");
				return false;
			}
			
			console.log(param);
			
			param = "tableId=" + mTableId + "&orderId=" + mOrderId + "&customerId=" + mCustomerInfo.customerId;
			
			var givebackcredit = creditAmount + mCreditPayPrice;	//외상상환금액(거스름돈외상갚기금액포함)
			var savedpoint = point + customPoint;
			chargeAmount += mCreditPayPrice;	//(거스름돈외상갚기금액포함)
			
			
			param += "&price=" + foodPrice					//음식금액
					+ "&givebackcredit=" + givebackcredit	//외상상환금액
					+ "&loss=" + lossAmount				//손실
					+ "&discount=" + discountAmount		//할인
					+ "&billmoney=" + chargeAmount		//청구금액
					+ "&cashpayment=" + cash			//현금결재금액
					+ "&cardpayment=" + cardAmount		//카드결재금액
					+ "&intocredit=" + mCreditProcessPrice	//외상처리금액
					+ "&intodeposit=" + mDepositProcessPrice	//예치금정립금액	
					+ "&savedpoint=" + savedpoint				//적립포인트
					+ "&useddeposit=" + depositAmount	//예치금사용금액					
					+ "&exchange=" + changeAmount				//거스름돈					
					+ "&iscashreceipt=" + cashReceipt			//현금영수증 발급여부		
					+ "&startSalesDate=" + mStartSalesDate
					+ "&contents=" + mOrderName;
					//+ "&creditPayPrice=" + mCreditPayPrice;	//거스름돈외상상환금액
			
			console.log(param);
			
			var url="/pos/account/setAccountComplete.json";
			var success = function(returnJsonVO){
				var returnObj = returnJsonVO.returnObj;
				console.log(returnObj);	
				
				document.location.href="/pos/main/posMain.do";
				
			};
			commonAjaxCall(url, param, success);			
		});

	}
	
	//거스름돈과 더받을돈을 계산하여 입력한다.
	function balanceAccounts(){
		var cash = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=cash]").val() || "0"));
		var cardAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=cardAmount]").val() || "0"));
		var depositAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=depositAmount]").val() || "0"));
		var creditAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=creditAmount]").val() || "0"));
		//남은외상값
		var leftCreditAmount = mCustomerInfo.totalCredit - creditAmount;
		//청구금액
		var chargeAmount = parseInt(window.bapdosa.util.getNumberOnly($("#form_account input[name=chargeAmount]").val() || "0"));	
		var changeAmount = 0;	//거스름돈
		var addAmount = 0;		//더받을돈	
		var creditProcessPrice = 0;	//외상처리금액
		var creditPayPrice = 0;		//외상갚기금액
		var depositProcessPrice = 0;		//예치하기금액
		var cashCardDepositAmount = cash + cardAmount + depositAmount;	//총 투입금액
		
		//거스름돈, 더받을돈 계산
		if(cashCardDepositAmount > chargeAmount){
			changeAmount = cashCardDepositAmount - chargeAmount;
		} else {
			addAmount = chargeAmount - cashCardDepositAmount;
		}
		
		if(mCustomerInfo.customerId){
			if(changeAmount > 0){
				$("#form_account input[name=creditPay]").parent("div.ui-checkbox").show();
				$("#form_account input[name=depositProcess]").parent("div.ui-checkbox").show();
				$("#form_account input[name=creditProcess]").prop("checked", false).checkboxradio("refresh").parent("div.ui-checkbox").hide();
			} else if(addAmount > 0) {
				$("#form_account input[name=creditProcess]").parent("div.ui-checkbox").show();
				$("#form_account input[name=creditPay]").prop("checked", false).checkboxradio("refresh").parent("div.ui-checkbox").hide();
				$("#form_account input[name=depositProcess]").prop("checked", false).checkboxradio("refresh").parent("div.ui-checkbox").hide();				
			}
		}	
		
		var creditProcess = $("#form_account input[name=creditProcess]").prop("checked");	//외상처리
		var creditPay = $("#form_account input[name=creditPay]").prop("checked");			//외상갚기
		var depositProcess = $("#form_account input[name=depositProcess]").prop("checked");	//예치하기	
		
		if(creditProcess){			
			if(addAmount > 0) {
				creditProcessPrice = addAmount;
				addAmount = 0;
			}			
		}
		
		if(creditPay){			
			if(changeAmount > 0) {				
				if(leftCreditAmount > 0 ) {					
					if(leftCreditAmount >= changeAmount){
						creditPayPrice = changeAmount;
						leftCreditAmount -= changeAmount;
						changeAmount = 0;
					} else {
						creditPayPrice = leftCreditAmount;
						changeAmount = changeAmount - leftCreditAmount;
						leftCreditAmount = 0;
					}					
				}				
			}		
		}	
		
		if(mCustomerInfo.customerId){
			if(depositProcess){
				depositProcessPrice = changeAmount;
				changeAmount = 0;
			}
		}		
		
		mCreditProcessPrice = creditProcessPrice;	//외상처리금액
		mCreditPayPrice = creditPayPrice;		//외상갚기금액
		mDepositProcessPrice = depositProcessPrice;		//예치하기금액	
		
		console.log("mCreditProcessPrice: " + mCreditProcessPrice);
		console.log("mCreditPayPrice: " + mCreditPayPrice);
		console.log("mDepositProcessPrice: " + mDepositProcessPrice);
		
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
		var depositAmount = 0;
		
		var depositUse = $("#form_account input[name=depositUse]").prop("checked");	
		
		if(depositUse){
			//청구금액이 예치금보다 클경우는 예치금 최대금액으로
			if(chargeAmount > mCustomerInfo.totalDeposit){
				depositAmount = mCustomerInfo.totalDeposit;
			} else {
				depositAmount = chargeAmount;
			}
		}
		
		$("#form_account input[name=chargeAmount]").val(window.bapdosa.util.setComma(chargeAmount));
		$("#form_account input[name=depositAmount]").val(window.bapdosa.util.setComma(depositAmount));	//예치금
		$("#form_account input[name=cash]").val(window.bapdosa.util.setComma(chargeAmount - depositAmount));	//현금
		$("#form_account input[name=cashReceipt]").prop("checked", false).checkboxradio("refresh");
		$("#form_account input[name=cardAmount]").val("0");
		$("#form_account input[name=customPoint]").val("0");
		$("#form_account input[name=creditProcess]").prop("checked", false).checkboxradio("refresh");
		$("#form_account input[name=creditPay]").prop("checked", false).checkboxradio("refresh");	//외상갚기
		$("#form_account input[name=depositProcess]").prop("checked", false).checkboxradio("refresh");
		$("#form_account input[name=changeAmount]").val("0");
		$("#form_account input[name=addAmount]").val("0");	
		
		console.log("initForm()");
		
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
		
		//예치금이 청구금액보다 크면 예치금row 보여주기
//		if(mCustomerInfo.totalDeposit >= chargeAmount){
//			$("#account-page .class-area-deposit").show();
//		} else {
//			$("#account-page .class-area-deposit").hide();
//		}				
		
		recommendCash();
		
		//옵션hide()
		$("#form_account input[name=creditProcess]").parent("div.ui-checkbox").hide();
		$("#form_account input[name=creditPay]").parent("div.ui-checkbox").hide();
		$("#form_account input[name=depositProcess]").parent("div.ui-checkbox").hide();
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
				
				//예치금이 있으면 예치금row show, 예치금 사용 체크
				if(mCustomerInfo.totalDeposit > 0){
					$("#account-page .class-area-deposit").show();
					$("#form_account input[name=depositUse]").prop("checked", true).checkboxradio("refresh");
					$("#form_account input[name=depositAmount]").prop("readonly", false);
				}
				
				initForm();				
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
			mStartSalesDate = orderInfoObj.STARTSALESDATE;
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
					mOrderName = obj.MENU_NAME;
					orderListStr = preStr + obj.MENU_NAME + "(" + obj.QUANTITY + ")";
				} else {
					if(index == 1){
						mOrderName += " 외";
					}
					orderListStr += " " + preStr + obj.MENU_NAME + "(" + obj.QUANTITY + ")"
				}
				
				totalPrice += obj.DISCOUNTPRICE;
			});	
			
			mFoodPrice = totalPrice;
			
			orderListArea.text(orderListStr);
			$("#form_account input[name=foodPrice]").val(window.bapdosa.util.setComma(totalPrice));
			$("#form_account input[name=chargeAmount]").val(window.bapdosa.util.setComma(totalPrice));
			//$("#form_account input[name=cash]").val(window.bapdosa.util.setComma(totalPrice));			
			
			if(orderInfoObj.CUSTOMERID){
				displayCustomerInfo(orderInfoObj.CUSTOMERID);
			} else {
				initForm();
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

