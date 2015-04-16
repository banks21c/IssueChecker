if (!window.bapdosa.order) {
    if(!window.bapdosa.order) window.bapdosa.order = {};
}

$(document).ready(function(){		
	window.bapdosa.order.init();
});


$(document).on("mobileinit", function () {
    $.mobile.ajaxEnabled = false;
});

window.bapdosa.order = (function() {	
	
	var isPriceDiffer;
	var isDPdiffer;
	var categoryInfoList;
	var selCategoryId;
	var orderArea;
	
	function eventReg(){
		
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
            console.log($(this).attr("menuId"));            
            $(this).addClass("active").siblings().removeClass("active");
        });
		
		//+버튼클릭(추가)
		$(".class-event-order-add").click(function(e){
			e.preventDefault();
			
			var selOrderDetail = orderArea.children("tr.active");
			if(selOrderDetail.length >= 1){
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
		
	}
	
	//total개수, 합계금액 계산
	function displayTotal(){
		var orderAreaList = orderArea.children("tr");
		var sumPrice = 0;
		orderAreaList.each(function(i){				
			var orderCount = parseInt($(this).find("td:eq(1)").text());
			var defaultPrice =  parseInt($(this).attr("defaultPrice"));			
			var isService = $(this).attr("isService") || "";			
			if(isPriceDiffer == "Y"){
				defaultPrice = parseInt(selArea.attr("storePrice")); 
			}			
			
			if(isService == "Y"){
				defaultPrice = 0;
			}
			sumPrice += defaultPrice * orderCount;
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
					console.log(menuObj);
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
		var selArea = orderArea.find("tr[orderDetailId=" + orderDetailId + "]");		
		var orderCount = parseInt(selArea.find("td:eq(1)").text()) + 1;
		var defaultPrice =  parseInt(selArea.attr("defaultPrice"));
		var isService = selArea.attr("isService") || "";
		
		if(isPriceDiffer == "Y"){
			defaultPrice = parseInt(selArea.attr("storePrice")); 
		}		
				
		if(isService == "Y"){
			defaultPrice = 0;
		}
		selArea.find("td:eq(1)").text(orderCount);
		selArea.find("td:eq(3)").text(window.bapdosa.util.setComma(defaultPrice * orderCount));		
	}
	
	function countDelMenu(orderDetailId){
		var selArea = orderArea.find("tr[orderDetailId=" + orderDetailId + "]");		
		var orderCount = parseInt(selArea.find("td:eq(1)").text()) - 1;
		var defaultPrice =  parseInt(selArea.attr("defaultPrice"));
		var isService = selArea.attr("isService") || "";
		
		if(isPriceDiffer == "Y"){
			defaultPrice = parseInt(selArea.attr("storePrice")); 
		}		
		
		if(isService == "Y"){
			defaultPrice = 0;
		}

		if(orderCount < 1){
			selArea.remove();
		} else {		
			selArea.find("td:eq(1)").text(orderCount);
			selArea.find("td:eq(3)").text(window.bapdosa.util.setComma(defaultPrice * orderCount));
		}
	}	
	
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
					console.log($(this).attr("orderDetailId"));
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
					
					var displayPrice = selMenuObj.DEFAULTPRICE;
					if(isPriceDiffer == "Y"){
						displayPrice = selMenuObj.STOREPRICE;
					}
					
					$("<tr>", {
						orderDetailId: 'temp_' + new Date().getTime(),
						categoryId: categoryId,
						menuId: menuId,
						defaultPrice: selMenuObj.DEFAULTPRICE,
						storePrice: selMenuObj.STOREPRICE,
						deliveryPrice: selMenuObj.DELIVERYPRICE,
						takeoutPrice: selMenuObj.TAKEOUTPRICE,
						defaultDiscount: selMenuObj.DEFAULTDISCOUNT,
						deliveryDiscount: selMenuObj.DELIVERYDISCOUNT,
						storeDiscount: selMenuObj.STOREDISCOUNT,
						takeoutDiscount: selMenuObj.TAKEOUTDISCOUNT,
						isService: selCategoryIsService,
						newFlag: "Y"
					}).append(
						$("<td>").addClass("a_tl")
								 .text(selMenuObj.NAME)
					).append(
						$("<td>").text("1")	
					).append(
						$("<td>").text(now_hm)
					).append(
						$("<td>").addClass("price")
							 	 .text(window.bapdosa.util.setComma(displayPrice))	
					).appendTo(orderArea);
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
		
		var url="/pos/category/getCategoryJsonList.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			isPriceDiffer = returnObj.isPriceDiffer;
			isDPdiffer = returnObj.isDPdiffer;
			categoryInfoList = returnObj.categoryJsonList;
			console.log(categoryInfoList);
			
			$(categoryInfoList).each(function(index,obj){
				console.log(obj);
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
		};

		commonAjaxCall(url, param, success);		
	}
	
	return {
		init: function() {
			eventReg();
			getCategoryInfoList();
			

		}
	}   
})();
