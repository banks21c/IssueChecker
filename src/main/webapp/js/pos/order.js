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
	
	var categoryInfoList;
	var selCategoryId;
	
	function eventReg(){
		
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
					//<li><span class="name">양념갈비 - 호주 양념갈비 - 호주</span><span>20</span></li>
					
					var li = $("<li>",{
						
						categoryId : menuObj.CATEGORYID,
						menuId : menuObj.MENUID,
						click : function(e){
							e.preventDefault();
							console.log($(this).attr("categoryId"));
							console.log($(this).attr("menuId"));
						}
						
						
					}).append($("<span>").addClass("name").text(menuObj.NAME))
									  .append($("<span>").text(parseInt(menuObj.STOREPRICE)/1000));
					menuBody.append(li);
				});
				
				return false;
			}
		});		
	}
	
	function getCategoryInfoList(){
		
		var url="/pos/category/getCategoryJsonList.json";
		var param="";
		var success = function(returnJsonVO){
			categoryInfoList = returnJsonVO.returnObj;

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

