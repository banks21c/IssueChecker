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
    	$("input[name=timeYN]").change(function(e){
			e.preventDefault();			
			if($(this).val() == "1") {				
		    	$(".class_lunch_wrap").show();
			}else{				
				$(".class_lunch_wrap").hide();
			}
		})
		
		$("#id_setting_set_time_differ li").click(function(e){
			e.preventDefault();
			$(this).children("a").addClass("active").end().siblings("li").children("a").removeClass("active");
			getLunchTimetap();			
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
			}else if(hour == '00'){
				$("#id_setting_hour_text").text("11");
			}else{
				if( hour != "11" && hour != "12" && hour != "00"){
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
			}else if(hour == '00'){
				$("#id_setting_hour2_text").text("11");
			}else{
				if( hour != "11" && hour != "12" && hour != "00"){
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
		
		$(".class_admin_save2").click(function(e){
			e.preventDefault();
			if($(".class_setting_time_differ").is(":checked")){
				lunchDifferSave();
			}else{				
				lunchEqualSave();
			}
			lunchFrontSave();
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
			location.reload();
		});	
		
		$(".class_admin_save5").click(function(e){
			e.preventDefault();	
			requestSave();
			location.reload();
		});	
		
		$(".class_admin_save6").click(function(e){
			e.preventDefault();	
			buildingSave();			
		});
		
		$(".class_admin_save7").click(function(e){
			e.preventDefault();	
			deliveryCollectMenuSave();			
		});
		
		$(".class_admin_save8").click(function(e){
			e.preventDefault();	
			deliveryCustomerInfoSave();			
		});
		
	}
    
    function getTableInfoList(){
		var dfd = new jQuery.Deferred();
		var url="/pos/setting/getOrderTableList.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			
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
    
    function getLunchTimeList(){
		var dfd = new jQuery.Deferred();
		var url="/pos/setting/getTimezoneSet.json";
		var timezonedivision = 0;
		var param="timezonedivision=" + timezonedivision;
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			
			timezoneSet = returnObj.timezoneSet;
			console.log("timezoneSet=" + timezoneSet);
			
			$(timezoneSet).each(function(index,obj){
				$(".class_time_line").attr("memberid", obj.MEMBERID);
				$(".class_setting_time_differ_main").attr("timezonedivision",timezonedivision).attr("starttime1",obj.STARTTIME1).attr("starttime2",obj.STARTTIME2).attr("starttime3",obj.STARTTIME3).attr("starttime4",obj.STARTTIME4).attr("starttime5",obj.STARTTIME5).attr("starttime6",obj.STARTTIME6).attr("starttime7",obj.STARTTIME7)
				.attr("endtime1",obj.ENDTIME1).attr("endtime2",obj.ENDTIME2).attr("endtime3",obj.ENDTIME3).attr("endtime4",obj.ENDTIME4).attr("endtime5",obj.ENDTIME5).attr("endtime6",obj.ENDTIME6).attr("endtime7",obj.ENDTIME7)	
                .attr("isusedtime1",obj.ISUSEDTIME1).attr("isusedtime2",obj.ISUSEDTIME2).attr("isusedtime3",obj.ISUSEDTIME3).attr("isusedtime4",obj.ISUSEDTIME4).attr("isusedtime5",obj.ISUSEDTIME5).attr("isusedtime6",obj.ISUSEDTIME6).attr("isusedtime7",obj.ISUSEDTIME7);	
				if(obj.ISDIFFERENTTIME == "Y"){
					$(".class_setting_time_differ").click();
				}else{
					if(obj.ISUSEDTIME1 == "Y"){					
						$(".class_setting_time_same_main li").eq(0).find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
						$(".class_setting_time_same_main li").eq(0).find("input").prop("checked", true).attr("data-cacheval" , false);					
					}
					if(obj.ISUSEDTIME2 == "Y"){					
						$(".class_setting_time_same_main li").eq(1).find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
						$(".class_setting_time_same_main li").eq(1).find("input").prop("checked", true).attr("data-cacheval" , false);					
					}
					if(obj.ISUSEDTIME3 == "Y"){					
						$(".class_setting_time_same_main li").eq(2).find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
						$(".class_setting_time_same_main li").eq(2).find("input").prop("checked", true).attr("data-cacheval" , false);					
					}
					if(obj.ISUSEDTIME4 == "Y"){					
						$(".class_setting_time_same_main li").eq(3).find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
						$(".class_setting_time_same_main li").eq(3).find("input").prop("checked", true).attr("data-cacheval" , false);					
					}
					if(obj.ISUSEDTIME5 == "Y"){					
						$(".class_setting_time_same_main li").eq(4).find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
						$(".class_setting_time_same_main li").eq(4).find("input").prop("checked", true).attr("data-cacheval" , false);					
					}
					if(obj.ISUSEDTIME6 == "Y"){					
						$(".class_setting_time_same_main li").eq(5).find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
						$(".class_setting_time_same_main li").eq(5).find("input").prop("checked", true).attr("data-cacheval" , false);					
					}
					if(obj.ISUSEDTIME7 == "Y"){					
						$(".class_setting_time_same_main li").eq(6).find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
						$(".class_setting_time_same_main li").eq(6).find("input").prop("checked", true).attr("data-cacheval" , false);					
					}
					
				}
				if(obj.STARTTIME1){					
					$("#id_setting_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME1.substring(0,2)));
					$("#id_setting_minute_text").text(obj.STARTTIME1.substring(2,4));
					$("#id_setting_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME1.substring(0,2)));
				}else{
					$("#id_setting_hour_text").text("00");
					$("#id_setting_minute_text").text("00");
					$("#id_setting_am_text").text("오전");
				}
				if(obj.ENDTIME1){
					$("#id_setting_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME1.substring(0,2)));
					$("#id_setting_minute2_text").text(obj.ENDTIME1.substring(2,4));
					$("#id_setting_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME1.substring(0,2)));
				}else{
					$("#id_setting_hour2_text").text("00");
					$("#id_setting_minute2_text").text("00");
					$("#id_setting_pm_text").text("오후");
				}				
			});
					
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
    
    function getLunchTimetap(){
		var dfd = new jQuery.Deferred();
		var url="/pos/setting/getTimezoneSet.json";
		var timezonedivision = 0;
		var param="timezonedivision=" + timezonedivision;
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			//isPriceDiffer = returnObj.isPriceDiffer;
			//isDPdiffer = returnObj.isDPdiffer;			
			
			timezoneSet = returnObj.timezoneSet;
			console.log("timezoneSet=" + timezoneSet);
			
			$(timezoneSet).each(function(index,obj){
				if($("#id_setting_set_time_differ li").eq(0).find("a").hasClass("active")){
					if(obj.STARTTIME1){					
						$("#id_setting_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME1.substring(0,2)));
						$("#id_setting_minute_text").text(obj.STARTTIME1.substring(2,4));
						$("#id_setting_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME1.substring(0,2)));
					}else{
						$("#id_setting_hour_text").text("00");
						$("#id_setting_minute_text").text("00");
						$("#id_setting_am_text").text("오전");
					}
					if(obj.ENDTIME1){
						$("#id_setting_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME1.substring(0,2)));
						$("#id_setting_minute2_text").text(obj.ENDTIME1.substring(2,4));
						$("#id_setting_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME1.substring(0,2)));
					}else{
						$("#id_setting_hour2_text").text("00");
						$("#id_setting_minute2_text").text("00");
						$("#id_setting_pm_text").text("오후");
					}
				}
				if($("#id_setting_set_time_differ li").eq(1).find("a").hasClass("active")){
					if(obj.STARTTIME2){					
						$("#id_setting_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME2.substring(0,2)));
						$("#id_setting_minute_text").text(obj.STARTTIME2.substring(2,4));
						$("#id_setting_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME2.substring(0,2)));
					}else{
						$("#id_setting_hour_text").text("00");
						$("#id_setting_minute_text").text("00");
						$("#id_setting_am_text").text("오전");
					}
					if(obj.ENDTIME2){
						$("#id_setting_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME2.substring(0,2)));
						$("#id_setting_minute2_text").text(obj.ENDTIME2.substring(2,4));
						$("#id_setting_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME2.substring(0,2)));
					}else{
						$("#id_setting_hour2_text").text("00");
						$("#id_setting_minute2_text").text("00");
						$("#id_setting_pm_text").text("오후");
					}
				}
				if($("#id_setting_set_time_differ li").eq(2).find("a").hasClass("active")){
					if(obj.STARTTIME3){					
						$("#id_setting_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME3.substring(0,2)));
						$("#id_setting_minute_text").text(obj.STARTTIME3.substring(2,4));
						$("#id_setting_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME3.substring(0,2)));
					}else{
						$("#id_setting_hour_text").text("00");
						$("#id_setting_minute_text").text("00");
						$("#id_setting_am_text").text("오전");
					}
					if(obj.ENDTIME3){
						$("#id_setting_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME3.substring(0,2)));
						$("#id_setting_minute2_text").text(obj.ENDTIME3.substring(2,4));
						$("#id_setting_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME3.substring(0,2)));
					}else{
						$("#id_setting_hour2_text").text("00");
						$("#id_setting_minute2_text").text("00");
						$("#id_setting_pm_text").text("오후");
					}
				}
				if($("#id_setting_set_time_differ li").eq(3).find("a").hasClass("active")){
					if(obj.STARTTIME4){					
						$("#id_setting_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME4.substring(0,2)));
						$("#id_setting_minute_text").text(obj.STARTTIME4.substring(2,4));
						$("#id_setting_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME4.substring(0,2)));
					}else{
						$("#id_setting_hour_text").text("00");
						$("#id_setting_minute_text").text("00");
						$("#id_setting_am_text").text("오전");
					}
					if(obj.ENDTIME4){
						$("#id_setting_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME4.substring(0,2)));
						$("#id_setting_minute2_text").text(obj.ENDTIME4.substring(2,4));
						$("#id_setting_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME4.substring(0,2)));
					}else{
						$("#id_setting_hour2_text").text("00");
						$("#id_setting_minute2_text").text("00");
						$("#id_setting_pm_text").text("오후");
					}
				}
				if($("#id_setting_set_time_differ li").eq(4).find("a").hasClass("active")){
					if(obj.STARTTIME5){					
						$("#id_setting_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME5.substring(0,2)));
						$("#id_setting_minute_text").text(obj.STARTTIME5.substring(2,4));
						$("#id_setting_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME5.substring(0,2)));
					}else{
						$("#id_setting_hour_text").text("00");
						$("#id_setting_minute_text").text("00");
						$("#id_setting_am_text").text("오전");
					}
					if(obj.ENDTIME5){
						$("#id_setting_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME5.substring(0,2)));
						$("#id_setting_minute2_text").text(obj.ENDTIME5.substring(2,4));
						$("#id_setting_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME5.substring(0,2)));
					}else{
						$("#id_setting_hour2_text").text("00");
						$("#id_setting_minute2_text").text("00");
						$("#id_setting_pm_text").text("오후");
					}
				}
				if($("#id_setting_set_time_differ li").eq(5).find("a").hasClass("active")){
					if(obj.STARTTIME6){					
						$("#id_setting_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME6.substring(0,2)));
						$("#id_setting_minute_text").text(obj.STARTTIME6.substring(2,4));
						$("#id_setting_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME6.substring(0,2)));
					}else{
						$("#id_setting_hour_text").text("00");
						$("#id_setting_minute_text").text("00");
						$("#id_setting_am_text").text("오전");
					}
					if(obj.ENDTIME6){
						$("#id_setting_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME6.substring(0,2)));
						$("#id_setting_minute2_text").text(obj.ENDTIME6.substring(2,4));
						$("#id_setting_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME6.substring(0,2)));
					}else{
						$("#id_setting_hour2_text").text("00");
						$("#id_setting_minute2_text").text("00");
						$("#id_setting_pm_text").text("오후");
					}
				}
				if($("#id_setting_set_time_differ li").eq(6).find("a").hasClass("active")){
					if(obj.STARTTIME7){					
						$("#id_setting_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME7.substring(0,2)));
						$("#id_setting_minute_text").text(obj.STARTTIME7.substring(2,4));
						$("#id_setting_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME7.substring(0,2)));
					}else{
						$("#id_setting_hour_text").text("00");
						$("#id_setting_minute_text").text("00");
						$("#id_setting_am_text").text("오전");
					}
					if(obj.ENDTIME7){
						$("#id_setting_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME7.substring(0,2)));
						$("#id_setting_minute2_text").text(obj.ENDTIME7.substring(2,4));
						$("#id_setting_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME7.substring(0,2)));
					}else{
						$("#id_setting_hour2_text").text("00");
						$("#id_setting_minute2_text").text("00");
						$("#id_setting_pm_text").text("오후");
					}
				}
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
				var index1 = obj.DISPORDER;
				var order = index1 -1;
				$(".class_rank_pyung li").eq(index).attr("codename",obj.CODENAME).attr("settingkey",obj.SETTINGKEY).attr("settingvalue",obj.SETTINGVALUE).attr("code",obj.CODE).attr("memberid",obj.MEMBERID).attr("deviceid",obj.DEVICEID).attr("parentcode",obj.PARENTCODE).attr("disporder",obj.DISPORDER);							
				if($(".class_rank_pyung li").eq(order).attr("settingvalue") == $(".class_rank_pyung li").eq(order).attr("code")){
					$(".class_rank_pyung li").eq(order).find("label").addClass("ui-radio-on").removeClass("ui-radio-off");
					$(".class_rank_pyung li").eq(order).find("input").prop("checked", true).attr("data-cacheval" , false);
				}else{					
					$(".class_rank_pyung li").eq(order).find("label").addClass("ui-radio-off").removeClass("ui-radio-on");
					$(".class_rank_pyung li").eq(order).find("input").prop("checked", false).attr("data-cacheval" , true);
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
				var index1 = obj.DISPORDER;
				var order = index1 -1;
				
				$(".class_rank_rent li").eq(index).attr("codename",obj.CODENAME).attr("settingkey",obj.SETTINGKEY).attr("settingvalue",obj.SETTINGVALUE).attr("code",obj.CODE).attr("memberid",obj.MEMBERID).attr("deviceid",obj.DEVICEID).attr("parentcode",obj.PARENTCODE).attr("disporder",obj.DISPORDER);
				
				if($(".class_rank_rent li").eq(order).attr("settingvalue") == $(".class_rank_rent li").eq(order).attr("code")){
					$(".class_rank_rent li").eq(order).find("label").addClass("ui-radio-on").removeClass("ui-radio-off");
					$(".class_rank_rent li").eq(order).find("input").prop("checked", true).attr("data-cacheval" , false);
				}else{
					
					$(".class_rank_rent li").eq(order).find("label").addClass("ui-radio-off").removeClass("ui-radio-on");
					$(".class_rank_rent li").eq(order).find("input").prop("checked", false).attr("data-cacheval" , true);
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
    
    function getLunchFront(){
		var dfd = new jQuery.Deferred();
		var url="/pos/setting/getLunchFront.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			
			lunchFront = returnObj.lunchFront;
			console.log("lunchFront=" + lunchFront);
			$(lunchFront).each(function(index,obj){
				if(obj.SETTINGVALUE == "CC00002402")	{
					$(".class_lunch_time_yn").find("label").eq(1).addClass("ui-radio-on").removeClass("ui-radio-off");
					$(".class_rank_pyung li").find("input").eq(1).prop("checked", true).attr("data-cacheval" , false);
					$(".class_lunch_wrap").hide();
				}else{
					$(".class_lunch_time_yn").find("label").eq(0).addClass("ui-radio-on").removeClass("ui-radio-off");
					$(".class_rank_pyung li").find("input").eq(0).prop("checked", true).attr("data-cacheval" , false);
					$(".class_lunch_wrap").show();
				}
			});
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
    
    function getBuildingList(){
		var dfd = new jQuery.Deferred();
		var menuBody = $(".class_building_list");
	    menuBody.empty();
	    
		var url="/pos/setting/getbuildingList.json";
		var isdeleted = "N";
		var param="isdeleted=" + isdeleted;
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			
			buildingList = returnObj.buildingList;
			console.log("buildingList=" + buildingList);
			
			$(buildingList).each(function(index,obj){
				var typetext;
				var classtype;
				if(obj.ISAPT == "A"){
					typetext = "아";
					classtype = "ico a"
				}else if(obj.ISAPT == "V"){
					typetext = "빌";
					classtype = "ico bd"
				}else if(obj.ISAPT == "S"){
					typetext = "상";
					classtype = "ico sg"
				}else if(obj.ISAPT == "E"){
					typetext = "기";
					classtype = "ico e"
				}
				var li = $("<li>",{						
					memberid : obj.MEMBERID,
					deviceid : obj.DEVICEID,
					buildingid : obj.BUILDINGID,
					isapt : obj.ISAPT,
					buildingtype : obj.BUILDINGTYPE,
					name : obj.NAME,
					isdeleted : obj.ISDELETED
				}).addClass("class_building_info").append($("<input>").addClass("wp60").attr("type","text").val(obj.NAME))
				.append("&nbsp;").append($("<span>").addClass(classtype).text(typetext)).append($("<a>" , {
					        click : function(e){
							e.preventDefault();
							buildingDelete($(this).attr("id"),$(this).attr("buildingname"));
					      }
				     }).addClass("del ui-link").addClass("class_building_delete").attr("href","#").attr("id" , obj.BUILDINGID).attr("buildingname" , obj.NAME).text("삭제"));
								  
				menuBody.append(li);	
				
			});
					
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
    
    function getDeliveryColllectMenu(){
		var dfd = new jQuery.Deferred();
		var url="/pos/setting/getDeliveryColllectMenu.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			
			deliveryColllectMenu = returnObj.deliveryColllectMenu;
			console.log("deliveryColllectMenu=" + deliveryColllectMenu);
			$(deliveryColllectMenu).each(function(index,obj){
				if(obj.SETTINGVALUE == "CC00002701")	{
					$(".class_delivery_collect_menu").find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
					$(".class_delivery_collect_menu").find("input").prop("checked", true).attr("data-cacheval" , false);
				}else{
					$(".class_delivery_collect_menu").find("label").removeClass("ui-checkbox-on").addClass("ui-checkbox-off");
					$(".class_delivery_collect_menu li").find("input").prop("checked", false).attr("data-cacheval" , true);
				}
			});
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
    
    function getDeliveryCustomerInfo(){
		var dfd = new jQuery.Deferred();
		var url="/pos/setting/getDeliveryCustomerInfo.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			
			deliveryCustomerInfo = returnObj.deliveryCustomerInfo;
			console.log("deliveryCustomerInfo=" + deliveryCustomerInfo);
			$(deliveryCustomerInfo).each(function(index,obj){
				if(obj.SETTINGVALUE == "CC00002801")	{
					$(".class_delivery_customer_info").find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
					$(".class_delivery_customer_info").find("input").prop("checked", true).attr("data-cacheval" , false);
				}else{
					$(".class_delivery_customer_info").find("label").removeClass("ui-checkbox-on").addClass("ui-checkbox-off");
					$(".class_delivery_customer_info li").find("input").prop("checked", false).attr("data-cacheval" , true);
				}
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
		 var url = "tableUpdateOk.json";
			
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
				}				
				if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
				} else{
					//alert(data.returnJsonVO.message);
				}
			}
		 });			
	}
    function lunchEqualSave(){
		 if(!confirm("저장하시겠습니까?")){
			 return false;
		 }
		 	 
			 var memberid= $(".class_time_line").attr("memberid");		 
			 var timezonedivision = "0";
			 var isdifferenttime = "N";
			 var isAmPm = $("#id_setting_am_text").text();
			 var isAmPm2 = $("#id_setting_pm_text").text();
			 
			 var starttime = window.bapdosa.util.hourTo24(isAmPm,$("#id_setting_hour_text").text()) + $("#id_setting_minute_text").text();
			 var endtime = window.bapdosa.util.hourTo24(isAmPm2,$("#id_setting_hour2_text").text()) + $("#id_setting_minute2_text").text();
			 
			 var starttime1 = $(".class_setting_time_differ_main").attr("starttime1");
			 var starttime2 = $(".class_setting_time_differ_main").attr("starttime2");
			 var starttime3 = $(".class_setting_time_differ_main").attr("starttime3");
			 var starttime4 = $(".class_setting_time_differ_main").attr("starttime4");
			 var starttime5 = $(".class_setting_time_differ_main").attr("starttime5");
			 var starttime6 = $(".class_setting_time_differ_main").attr("starttime6");
			 var starttime7 = $(".class_setting_time_differ_main").attr("starttime7");
			 var endtime1 = $(".class_setting_time_differ_main").attr("endtime1");
			 var endtime2 = $(".class_setting_time_differ_main").attr("endtime2");
			 var endtime3 = $(".class_setting_time_differ_main").attr("endtime3");
			 var endtime4 = $(".class_setting_time_differ_main").attr("endtime4");
			 var endtime5 = $(".class_setting_time_differ_main").attr("endtime5");
			 var endtime6 = $(".class_setting_time_differ_main").attr("endtime6");
			 var endtime7 = $(".class_setting_time_differ_main").attr("endtime7");
			 var isusedtime1 = $(".class_setting_time_differ_main").attr("isusedtime1");
			 var isusedtime2 = $(".class_setting_time_differ_main").attr("isusedtime2");
			 var isusedtime3 = $(".class_setting_time_differ_main").attr("isusedtime3");
			 var isusedtime4 = $(".class_setting_time_differ_main").attr("isusedtime4");
			 var isusedtime5 = $(".class_setting_time_differ_main").attr("isusedtime5");
			 var isusedtime6 = $(".class_setting_time_differ_main").attr("isusedtime6");
			 var isusedtime7 = $(".class_setting_time_differ_main").attr("isusedtime7");
			 
			 $(".class_setting_time_same").each(function(index ) {	
				 
				if($(".class_setting_time_same").eq(0).find("input").is(":checked")){					 
					 starttime1 = starttime;
					 endtime1 = endtime;
					 isusedtime1 = "Y";
				}else{
					starttime1;
					endtime1;
					isusedtime1 = "N";
				}
				if($(".class_setting_time_same").eq(1).find("input").is(":checked")){					 
					 starttime2 = starttime;
					 endtime2 = endtime;
					 isusedtime2 = "Y";
				}else{
					starttime2;
					endtime2;
					isusedtime2 = "N";
				}
				if($(".class_setting_time_same").eq(2).find("input").is(":checked")){					 
					 starttime3 = starttime;
					 endtime3 = endtime;
					 isusedtime3 = "Y";
				}else{
					starttime3;
					endtime3;
					isusedtime3 = "N";
				}
				if($(".class_setting_time_same").eq(3).find("input").is(":checked")){					 
					 starttime4 = starttime;
					 endtime4 = endtime;
					 isusedtime4 = "Y";
				}else{
					starttime4;
					endtime4;
					isusedtime4 = "N";
				}
				if($(".class_setting_time_same").eq(4).find("input").is(":checked")){					 
					 starttime5 = starttime;
					 endtime5 = endtime;
					 isusedtime5 = "Y";
				}else{
					starttime5;
					endtime5;
					isusedtime5 = "N";
				}
				if($(".class_setting_time_same").eq(5).find("input").is(":checked")){					 
					 starttime6 = starttime;
					 endtime6 = endtime;
					 isusedtime6 = "Y";
				}else{
					starttime6;
					endtime6;
					isusedtime6 = "N";
				}
				if($(".class_setting_time_same").eq(6).find("input").is(":checked")){					 
					 starttime7 = starttime;
					 endtime7 = endtime;
					 isusedtime7 = "Y";
				}else{
					starttime7;
					endtime7;
					isusedtime7 = "N";
				}
			 });
			 var param = "memberid=" + memberid + "&timezonedivision=" + timezonedivision + "&isdifferenttime=" + isdifferenttime +
			 "&starttime1=" + starttime1 + "&starttime2=" + starttime2 + "&starttime3=" + starttime3 + "&starttime4=" + starttime4 + "&starttime5=" + starttime5 + "&starttime6=" + starttime6+ "&starttime7=" + starttime7 +
			 "&endtime1=" + endtime1 + "&endtime2=" + endtime2 + "&endtime3=" + endtime3 + "&endtime4=" + endtime4 + "&endtime5=" + endtime5 + "&endtime6=" + endtime6 + "&endtime7=" + endtime7 +
			 "&isusedtime1=" + isusedtime1 + "&isusedtime2=" + isusedtime2 + "&isusedtime3=" + isusedtime3 + "&isusedtime4=" + isusedtime4 + "&isusedtime5=" + isusedtime5 + "&isusedtime6=" + isusedtime6 + "&isusedtime7=" + isusedtime7;
			 var url = "updateTimezoneSet.json";
				
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
					}					
					if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
					} else{
						//alert(data.returnJsonVO.message);
					}
				}
			 });
		
	}
    
    function lunchDifferSave(){
		 if(!confirm("저장하시겠습니까?")){
			 return false;
		 }
		 	 
			 var memberid= $(".class_time_line").attr("memberid");		 
			 var timezonedivision = "0";
			 var isdifferenttime = "Y";
			 var isAmPm = $("#id_setting_am_text").text();
			 var isAmPm2 = $("#id_setting_pm_text").text();
			 
			 var starttime = window.bapdosa.util.hourTo24(isAmPm,$("#id_setting_hour_text").text()) + $("#id_setting_minute_text").text();
			 var endtime = window.bapdosa.util.hourTo24(isAmPm2,$("#id_setting_hour2_text").text()) + $("#id_setting_minute2_text").text();
			 
			 var starttime1 = $(".class_setting_time_differ_main").attr("starttime1");
			 var starttime2 = $(".class_setting_time_differ_main").attr("starttime2");
			 var starttime3 = $(".class_setting_time_differ_main").attr("starttime3");
			 var starttime4 = $(".class_setting_time_differ_main").attr("starttime4");
			 var starttime5 = $(".class_setting_time_differ_main").attr("starttime5");
			 var starttime6 = $(".class_setting_time_differ_main").attr("starttime6");
			 var starttime7 = $(".class_setting_time_differ_main").attr("starttime7");
			 var endtime1 = $(".class_setting_time_differ_main").attr("endtime1");
			 var endtime2 = $(".class_setting_time_differ_main").attr("endtime2");
			 var endtime3 = $(".class_setting_time_differ_main").attr("endtime3");
			 var endtime4 = $(".class_setting_time_differ_main").attr("endtime4");
			 var endtime5 = $(".class_setting_time_differ_main").attr("endtime5");
			 var endtime6 = $(".class_setting_time_differ_main").attr("endtime6");
			 var endtime7 = $(".class_setting_time_differ_main").attr("endtime7");
			 var isusedtime1 = $(".class_setting_time_differ_main").attr("isusedtime1");
			 var isusedtime2 = $(".class_setting_time_differ_main").attr("isusedtime2");
			 var isusedtime3 = $(".class_setting_time_differ_main").attr("isusedtime3");
			 var isusedtime4 = $(".class_setting_time_differ_main").attr("isusedtime4");
			 var isusedtime5 = $(".class_setting_time_differ_main").attr("isusedtime5");
			 var isusedtime6 = $(".class_setting_time_differ_main").attr("isusedtime6");
			 var isusedtime7 = $(".class_setting_time_differ_main").attr("isusedtime7");
			 
			 $(".class_setting_time_differ_tap").each(function(index ) {	
				 
				if($(".class_setting_time_differ_tap").eq(0).find("a").hasClass("active")){		
					 starttime1 = starttime;
					 endtime1 = endtime;
					 isusedtime1 = "Y";					 
					 
				}else if($(".class_setting_time_differ_tap").eq(1).find("a").hasClass("active")){
					 starttime2 = starttime;
					 endtime2 = endtime;
					 isusedtime2 = "Y";
					
				}else if($(".class_setting_time_differ_tap").eq(2).find("a").hasClass("active")){
					 starttime3 = starttime;
					 endtime3 = endtime;
					 isusedtime3 = "Y";
					
				}else if($(".class_setting_time_differ_tap").eq(3).find("a").hasClass("active")){
					 starttime4 = starttime;
					 endtime4 = endtime;
					 isusedtime4 = "Y";
					
				}else if($(".class_setting_time_differ_tap").eq(4).find("a").hasClass("active")){
					 starttime5 = starttime;
					 endtime5 = endtime;
					 isusedtime5 = "Y";
					
				}else if($(".class_setting_time_differ_tap").eq(5).find("a").hasClass("active")){
					 starttime6 = starttime;
					 endtime6 = endtime;
					 isusedtime6 = "Y";
					
				}else if($(".class_setting_time_differ_tap").eq(6).find("a").hasClass("active")){
					 starttime7 = starttime;
					 endtime7 = endtime;
					 isusedtime7 = "Y";
					
				}else{
					
				}				
			 });
			
			 var param = "memberid=" + memberid + "&timezonedivision=" + timezonedivision + "&isdifferenttime=" + isdifferenttime +
			 "&starttime1=" + starttime1 + "&starttime2=" + starttime2 + "&starttime3=" + starttime3 + "&starttime4=" + starttime4 + "&starttime5=" + starttime5 + "&starttime6=" + starttime6+ "&starttime7=" + starttime7 +
			 "&endtime1=" + endtime1 + "&endtime2=" + endtime2 + "&endtime3=" + endtime3 + "&endtime4=" + endtime4 + "&endtime5=" + endtime5 + "&endtime6=" + endtime6 + "&endtime7=" + endtime7 +
			 "&isusedtime1=" + isusedtime1 + "&isusedtime2=" + isusedtime2 + "&isusedtime3=" + isusedtime3 + "&isusedtime4=" + isusedtime4 + "&isusedtime5=" + isusedtime5 + "&isusedtime6=" + isusedtime6 + "&isusedtime7=" + isusedtime7;
			 var url = "updateTimezoneSet.json";
				
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
					}					
					if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
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
			 var url = "dcUpdateOk.json";
				
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
					}					
					if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
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
				 settingvalue = $(this).attr("code");			 
				 var param = "settingkey=" + settingkey + "&settingvalue=" + settingvalue;
				 var url = "rankUpdateOk.json";
			 }	
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
					}					
					if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
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
			 var url = "requestUpdateOk.json";
				
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
					}					
					if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
					} else{
						//alert(data.returnJsonVO.message);
					}
				}
			 });
		 });
	} 
    
    function lunchFrontSave(){	
    	
		 var settingvalue;
		 
		 if($("input[name=timeYN]:checked").val() == "1"){
			 settingvalue = 'CC00002401';
		 }else{
			 settingvalue = 'CC00002402';
		 }		 
		 var param ="settingvalue=" + settingvalue;
		 var url = "lunchFrontUpdateOk.json";
			
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
				}					
				if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
				} else{
					//alert(data.returnJsonVO.message);
				}
			}
		 });
		 
	} 
    
    function buildingSave(){
		 if(!confirm("저장하시겠습니까?")){
			 return false;
		 }
		 
		 $(".class_building_info").each(function(index ) {			 
		 
			 var memberId = $(this).attr("memberId");		 
			 var deviceId = $(this).attr("deviceId");
			 var buildingid = $(this).attr("buildingid");
			 var isdeleted = $(this).attr("isdeleted");
			 var name = $(this).find("input").val();
			
			 var param = "memberid=" + memberId + "&deviceid=" + deviceId + "&buildingid=" + buildingid + "&name=" + name + "&isdeleted=" + isdeleted;			 
			 var url = "buildingUpdateOk.json";
				
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
					}					
					if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
					} else{
						//alert(data.returnJsonVO.message);
					}
					location.reload();
				}
			 });
		 });
	}
    
    function deliveryCollectMenuSave(){	
    	
		 var settingvalue;
		 
		 if($("input[name=delivery_view]").is(":checked")){
			 settingvalue = 'CC00002701';
		 }else{
			 settingvalue = 'CC00002702';
		 }		 
		 var param ="settingvalue=" + settingvalue;
		 var url = "deliveryCollectMenuUpdateOk.json";
			
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
				}					
				if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
				} else{
					//alert(data.returnJsonVO.message);
				}
				location.reload();
			}
		 });
		 
	} 
    
    function deliveryCustomerInfoSave(){	
    	
		 var settingvalue;
		 
		 if($("input[name=delivery_info_view]").is(":checked")){
			 settingvalue = 'CC00002801';
		 }else{
			 settingvalue = 'CC00002802';
		 }		 
		 var param ="settingvalue=" + settingvalue;
		 var url = "deliveryCustomerInfoUpdateOk.json";
			
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
				}					
				if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
				} else{
					//alert(data.returnJsonVO.message);
				}
				location.reload();
			}
		 });
		 
	} 
    function buildingDelete(id , name){
		 if(!confirm("정말 삭제하시겠습니까?")){
			 return false;
		 }		 
		 var isdeleted = "Y";		 
		
		 var param = "buildingid=" + id + "&name=" + name + "&isdeleted=" + isdeleted;		 
		 var url = "buildingUpdateOk.json";
			
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
				}					
				if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
				} else{
					//alert(data.returnJsonVO.message);
				}
				location.reload();
			}
		 });
		 
	} 
	
	return {
		init: function() {
			eventReg();		
			getTableInfoList();
			getCustomerRequestList();
			getRankList();
			getLunchTimeList();
			getLunchFront();
			getRankList2();
			getPointDcList();
			getBuildingList();
			getDeliveryColllectMenu();
			getDeliveryCustomerInfo();
		}	
	}   
})();

