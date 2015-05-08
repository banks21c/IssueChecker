if (!window.bapdosa.order) {
    if(!window.bapdosa.order) window.bapdosa.setting = {};
}

$(document).ready(function(){		
	window.bapdosa.setting.init();
});


$(document).on("mobileinit", function () {
    $.mobile.ajaxEnabled = false;
});

window.bapdosa.setting = (function() {
	var tableInfoList;
	var orderMapList;
	var customerRequestList;
	
    function eventReg(){    	
    	$(".admin_list dt span").click(function(){
    		if($(this).parent().next().is(":hidden")){
    			$(".admin_list dt span").parent().next().hide();
    			$(".admin_list dt span, .admin_list dt a").removeClass("on");
    			$(this).parent().next().show();
    			$(this).addClass("on");
    			$(this).parent().find('.save').addClass("on");
    		}else if($(this).parent().next().is(":visible")){
    			$(this).parent().next().hide();
    			$(this).removeClass("on");
    			$(this).parent().find('.save').removeClass("on");
    		}
    	});		

		/*세팅 */
		//점심시간 점심메뉴 앞으로	
		$("#id_setting_set_time_differ li").click(function(e){
			e.preventDefault();
			$(this).children("a").addClass("active").end().siblings("li").children("a").removeClass("active");
		});
		
		$(".class_setting_time_differ").change(function(e){
			e.preventDefault();			
			
			if($(this).is(":checked")) {
				
		    	$("#id_setting_set_time_differ").show();
		    	$("#id_setting_time_same").hide();
		    	
			}else{
				
				$("#id_setting_set_time_differ").hide();
		    	$("#id_setting_time_same").show();		    
			}
		})
		
		$("#id_setting_am_btn").click(function(e){
			e.preventDefault();	
			if($("#id_setting_am_text").text() == '오후'){
			     $("#id_setting_am_text").text("오전");
			}else{
			     $("#id_setting_am_text").text("오후");
			}
		});
		$("#id_setting_pm_btn").click(function(e){
			e.preventDefault();	
			if($("#id_setting_pm_text").text() == '오후'){
			     $("#id_setting_pm_text").text("오전");
			}else{
			     $("#id_setting_pm_text").text("오후");
			}
		});
		
		$("#id_setting_minute_btn").click(function(e){
			e.preventDefault();	
			if($("#id_setting_minute_text").text() == '00'){
			     $("#id_setting_minute_text").text("30");
			}else{
			     $("#id_setting_minute_text").text("00");
			}
		});
		$("#id_setting_minute2_btn").click(function(e){
			e.preventDefault();	
			if($("#id_setting_minute2_text").text() == '00'){
			     $("#id_setting_minute2_text").text("30");
			}else{
			     $("#id_setting_minute2_text").text("00");
			}
		});
		
		$("#id_setting_hour_plus_btn").click(function(e){
			e.preventDefault();
			var hour = $("#id_setting_hour_text").text();
			if(hour == '12'){
				$("#id_setting_hour_text").text("01");
			}else{
				if(10 > parseInt(hour.substring(1,2)) && hour != "09" && hour != "10" && hour != "11"){
				    $("#id_setting_hour_text").text("0" + (parseInt(hour)+ 1));
				}else{
					$("#id_setting_hour_text").text(parseInt(hour)+ 1);					
				}
			}			
		});
		$("#id_setting_hour_minus_btn").click(function(e){
			e.preventDefault();	
			var hour = $("#id_setting_hour_text").text();
			if(hour == '01'){
				$("#id_setting_hour_text").text("12");
			}else{
				if( hour != "11" && hour != "12"){
				    $("#id_setting_hour_text").text("0" + (parseInt(hour) - 1));
				}else{
					$("#id_setting_hour_text").text(parseInt(hour) - 1);					
				}
			}			
		});
		$("#id_setting_hour2_plus_btn").click(function(e){
			e.preventDefault();
			var hour = $("#id_setting_hour2_text").text();
			if(hour == '12'){
				$("#id_setting_hour2_text").text("01");
			}else{
				if(10 > parseInt(hour.substring(1,2)) && hour != "09" && hour != "10" && hour != "11"){
				    $("#id_setting_hour2_text").text("0" + (parseInt(hour)+ 1));
				}else{
					$("#id_setting_hour2_text").text(parseInt(hour)+ 1);					
				}
			}			
		});
		$("#id_setting_hour2_minus_btn").click(function(e){
			e.preventDefault();	
			var hour = $("#id_setting_hour2_text").text();
			if(hour == '01'){
				$("#id_setting_hour2_text").text("12");
			}else{
				if( hour != "11" && hour != "12"){
				    $("#id_setting_hour2_text").text("0" + (parseInt(hour) - 1));
				}else{
					$("#id_setting_hour2_text").text(parseInt(hour) - 1);					
				}
			}			
		});
		$(".class_admin_save1").click(function(e){
			e.preventDefault();	
			tableSave();
			location.reload();
		});
		
		$(".class_admin_save3").click(function(e){
			e.preventDefault();	
			dcSave();
			location.reload();
		});	
		
		$(".class_admin_save4").click(function(e){
			e.preventDefault();
			
			rankSave();
			//rankSave2();
			 setTimeout(function () { 
			      location.reload();
			    }, 100);
		});	
		
		$(".class_admin_save5").click(function(e){
			e.preventDefault();	
			requestSave();
			location.reload();
		});	
	}
    
    function getTableInfoList(){
		var dfd = new jQuery.Deferred();
		var url="/pos/setting/getOrderTableList.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			//isPriceDiffer = returnObj.isPriceDiffer;
			//isDPdiffer = returnObj.isDPdiffer;			
			
			tableInfoList = returnObj.orderMapList;
			console.log("tableInfoList=" + tableInfoList);
			
			$(tableInfoList).each(function(index,obj){
				$(".class_table_count span").attr("totalCount",obj.TABLENO).text(obj.TABLENO);
				
			});
					
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
    
    function getPointDcList(){
		var dfd = new jQuery.Deferred();
		var menuBody = $(".class_dc_amount");
	    menuBody.empty();
	    
		var url="/pos/setting/getPointDcList.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			//isPriceDiffer = returnObj.isPriceDiffer;
			//isDPdiffer = returnObj.isDPdiffer;			
			
			pointList = returnObj.pointDcList;
			console.log("pointList=" + pointList);
			
			$(pointList).each(function(index,obj){
				
				var li = $("<li>",{						
					memberid : obj.MEMBERID,
					deviceid : obj.DEVICEID,
					settingid : obj.SETTINGID,
					settingkey : obj.SETTINGKEY,
					settingvalue : obj.SETTINGVALUE
				}).addClass("class_dc_input").append($("<input>").attr("type","number").val(obj.SETTINGVALUE)).append("%");
								  
				menuBody.append(li);
				
			});
					
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
    
    function getRankList(){
		var dfd = new jQuery.Deferred();
		
		var url="/pos/setting/getRankList.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			
			rankSetList = returnObj.rankList;
			console.log("rankSetList=" + rankSetList);
			
			$(rankSetList).each(function(index,obj){				
				$(".class_rank_pyung li").eq(index).attr("codename",obj.CODENAME).attr("settingkey",obj.SETTINGKEY).attr("settingvalue",obj.SETTINGVALUE).attr("memberid",obj.MEMBERID).attr("deviceid",obj.DEVICEID);							
				if($(".class_rank_pyung li").eq(index).attr("settingvalue") == "Y"){
					$(".class_rank_pyung li").eq(index).find("label").addClass("ui-radio-on").removeClass("ui-radio-off");
					$(".class_rank_pyung li").eq(index).find("input").prop("checked", true).attr("data-cacheval" , false);
				}else{
					
					$(".class_rank_pyung li").eq(index).find("label").addClass("ui-radio-off").removeClass("ui-radio-on");
					$(".class_rank_pyung li").eq(index).find("input").prop("checked", false).attr("data-cacheval" , true);
				}
			});
				
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
    
    function getRankList2(){
		var dfd = new jQuery.Deferred();
		
		var url="/pos/setting/getRankList2.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			
			rankSetList2 = returnObj.rankList2;
			console.log("rankSetList2=" + rankSetList2);
			
			$(rankSetList2).each(function(index,obj){				
				$(".class_rank_rent li").eq(index).attr("codename",obj.CODENAME).attr("settingkey",obj.SETTINGKEY).attr("settingvalue",obj.SETTINGVALUE).attr("memberid",obj.MEMBERID).attr("deviceid",obj.DEVICEID);							
				if($(".class_rank_rent li").eq(index).attr("settingvalue") == "Y"){
					$(".class_rank_rent li").eq(index).find("label").addClass("ui-radio-on").removeClass("ui-radio-off");
					$(".class_rank_rent li").eq(index).find("input").prop("checked", true).attr("data-cacheval" , false);
				}else{
					
					$(".class_rank_rent li").eq(index).find("label").addClass("ui-radio-off").removeClass("ui-radio-on");
					$(".class_rank_rent li").eq(index).find("input").prop("checked", false).attr("data-cacheval" , true);
				}
			});
				
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
    
    function getCustomerRequestList(){
		var dfd = new jQuery.Deferred();
		var menuBody = $(".class_customer_request");
		    menuBody.empty();
		
		var url="/pos/setting/getCustomerRequestList.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;			
			
			cusRequestList = returnObj.customerRequestList;
			console.log("cusRequestList=" + cusRequestList);
			
			$(cusRequestList).each(function(index,obj){
				
				var li = $("<li>",{						
					memberId : obj.MEMBERID,
					deviceId : obj.DEVICEID,
					requestId : obj.REQUESTID,
					isDeleted : obj.ISDELETED,
					reqContents : obj.CONTENTS
				}).addClass("class_request_list").append($("<input>").addClass("wp80").val(obj.CONTENTS));
								  
				menuBody.append(li);				
			});
					
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
    
    function tableSave(){
		 if(!confirm("저장하시겠습니까?")){
			 return false;
		 }	
		 var tableCount = $(".class_table_count span").text();		 
		 var tableNo = $(".class_table_input").val();
		 var totalCount = $(".class_table_count span").attr("totalCount");
		 
		 if(tableNo > 60){
				alert("테이블 갯수는 60개를 초과할수없습니다");
				 return false;
		 }	
		 if(tableCount > tableNo){		 
			 var isdeleted = "Y";
		 }else{
			 var isdeleted = "N";	
		 }
		 
		 var param = "tableno=" + tableNo + "&isdeleted=" + isdeleted + "&totalCount=" + totalCount; 
		 var url = "tableUpdatetOk.json";
			
		 if(typeof console != 'undefined'){
			console.log("param: " + param);
		 }
		 $.ajax({
			url: url,
			type: 'post',
			data: param,
			dataType: "json",
			error:function (xhr, ajaxOptions, thrownError){				
				//alert(thrownError);
			},
			success:function(data){
				if(typeof console != 'undefined'){		
					//console.log(data);					
				}				
				if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
					//$("#id_cate_save").click();		
				} else{
					//alert(data.returnJsonVO.message);
				}
			}
		 });			
	}
    
    function dcSave(){
		 if(!confirm("저장하시겠습니까?")){
			 return false;
		 }
		 
		 $(".class_dc_input").each(function(index ) {			 
		 
			 var memberid = $(this).attr("memberid");		 
			 var deviceid = $(this).attr("deviceid");
			 var settingid = $(this).attr("settingid");
			 var settingkey = $(this).attr("settingkey");
			 var settingvalue1 = $(this).attr("settingvalue");
			 var settingvalue2 = $(this).find("input").val();
			 var settingvalue;
			 
			 if(settingvalue2){
				 settingvalue = settingvalue2;
			 }else{
				 settingvalue = settingvalue1;
			 }
			 
			 var param = "memberid=" + memberid + "&deviceid=" + deviceid + "&settingid=" + settingid + "&settingkey=" + settingkey + "&settingvalue=" + settingvalue;
			 var url = "dcUpdatetOk.json";
				
			 if(typeof console != 'undefined'){
				console.log("param: " + param);
			 }
			 $.ajax({
				url: url,
				type: 'post',
				data: param,
				dataType: "json",
				error:function (xhr, ajaxOptions, thrownError){				
					//alert(thrownError);
				},
				success:function(data){
					if(typeof console != 'undefined'){		
						//console.log(data);					
					}					
					if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
						//$("#id_cate_save").click();		
					} else{
						//alert(data.returnJsonVO.message);
					}
				}
			 });
		 });
	}
    function rankSave(){
		 if(!confirm("저장하시겠습니까?")){
			 return false;
		 }
		 
		 $(".class_rank_check").each(function(index ) {
			 var settingvalue;
			 var settingkey = $(this).attr("settingkey");
			 
			 if($(this).find("input").is(":checked")) {
				 settingvalue = "Y"
			 }else{
				 settingvalue = "N"
			 }
			 
			 var param = "settingkey=" + settingkey + "&settingvalue=" + settingvalue;
			 var url = "rankUpdatetOk.json";
				
			 if(typeof console != 'undefined'){
				console.log("param: " + param);
			 }
			 $.ajax({
				url: url,
				type: 'post',
				data: param,
				dataType: "json",
				error:function (xhr, ajaxOptions, thrownError){				
					//alert(thrownError);
				},
				success:function(data){
					if(typeof console != 'undefined'){		
						//console.log(data);					
					}					
					if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
						//$("#id_cate_save").click();		
					} else{
						//alert(data.returnJsonVO.message);
					}
				}
			 });
		 });
	}
    
    function requestSave(){
		 if(!confirm("저장하시겠습니까?")){
			 return false;
		 }
		 
		 $(".class_request_list").each(function(index ) {			 
		 
			 var memberId = $(this).attr("memberId");		 
			 var deviceId = $(this).attr("deviceId");
			 var requestId = $(this).attr("requestId");
			 var reqContents = $(this).attr("reqContents");
			 var contents2 = $(this).find("input").val();
			 var contents;
			 
			 if(contents2){
				 contents = contents2;
			 }else{
				 contents = reqContents;
			 }
			 
			 var param = "memberid=" + memberId + "&deviceid=" + deviceId + "&requestid=" + requestId + "&contents=" + contents;
			 var url = "requestUpdatetOk.json";
				
			 if(typeof console != 'undefined'){
				console.log("param: " + param);
			 }
			 $.ajax({
				url: url,
				type: 'post',
				data: param,
				dataType: "json",
				error:function (xhr, ajaxOptions, thrownError){				
					//alert(thrownError);
				},
				success:function(data){
					if(typeof console != 'undefined'){		
						//console.log(data);					
					}					
					if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
						//$("#id_cate_save").click();		
					} else{
						//alert(data.returnJsonVO.message);
					}
				}
			 });
		 });
	} 
	
	return {
		init: function() {
			eventReg();	
			
			$.when(getTableInfoList()).then (
					function(status){
						console.log("status: " + status);
						$.when(getCustomerRequestList()).then (
								function(status){
									console.log("status: " + status);
									getRankList();
								}			
						);
						getRankList2();
						//getCustomerRequestList();
					}			
			);			
			getPointDcList();
			//getRankList()
		}	
	}   
})();

