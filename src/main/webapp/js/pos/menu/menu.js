if (!window.bapdosa.order) {
    if(!window.bapdosa.order) window.bapdosa.menu = {};
}

$(document).ready(function(){		
	window.bapdosa.menu.init();
});


$(document).on("mobileinit", function () {
    $.mobile.ajaxEnabled = false;
});

window.bapdosa.menu = (function() {	
	
	var name;
	var sortorder;
	var catemenuname;
	var defaultprice;
	var memberid = $("tr.class_menu_main_view").attr('memberid');
	var deviceid = $("tr.class_menu_main_view").attr('deviceid');
	var categoryid = $("tr.class_menu_main_view").attr('categoryid');
	var sortorder = parseInt($("tr.class_menu_main_view").last().attr('sortorder')) + 1;
	var menuid = 'temp_' + new Date().getTime();
	
	
    function eventReg(){      	
    	
    	$("#id_menu_tab_top3").hide();
    	$("#id_menu_tab_top4").hide();
    	//$("#id_menu_col_top1").show();
    	$("#id_menu_col_top3").hide();
    	$("#id_menu_col_top4").hide();
    	$(".class_menu_deliveryprice").hide();
    	$(".class_menu_takeoutprice").hide();
    	
    	$("#id_point_tab_top3").hide();
    	$("#id_point_tab_top4").hide();
    	$("#id_point_tab_top5").hide();
    	$("#id_point_col_top1").show();
    	$("#id_point_col_top2").show();
    	$("#id_point_col_top3").hide();
    	$("#id_point_col_top4").hide();
    	$("#id_point_col_top5").hide();
    	$(".class_point_storepoint").hide();    	
    	$(".class_point_deliverypoint").hide();
    	$(".class_point_takeoutpoint").hide();
    	$(".class_point_deliverydiscount").hide();
    	$(".class_point_takeoutdiscount").hide();
    	$(".class_point_storediscount1").hide(); 
    	
		$("#id_cate_save").click(function(e){		
			e.preventDefault();			
			updateCate(sortorder,name,categoryid);
			
		});	
		$(".class_menu_check").change(function(e){
			e.preventDefault();			
			
			if($(this).is(":checked")) {
				
		    	$("#id_menu_tab_top3").show();
		    	$("#id_menu_tab_top4").show();
		    	$("#id_menu_col_top3").show();
		    	$("#id_menu_col_top4").show();
		    	
		    	$(".class_menu_deliveryprice").show();
		    	$(".class_menu_takeoutprice").show();
				//$("#id_menu_save").addClass("class_long_save").removeClass("class_short_save");
		    	$("tr.class_menu_main_view").attr("menuFlag" , "true");
				
			}else{
				
		    	$("#id_menu_tab_top3").hide();
		    	$("#id_menu_tab_top4").hide();
		    	$("#id_menu_col_top3").hide();
		    	$("#id_menu_col_top4").hide();
		    	$(".class_menu_deliveryprice").hide();
		    	$(".class_menu_takeoutprice").hide();
				//$("#id_menu_save").addClass("class_short_save").removeClass("class_long_save");
		    	$("tr.class_menu_main_view").attr("menuFlag" , "false");
			}
		})
		
		$(".class_point_check").change(function(e){
			e.preventDefault();			
			
			if($(this).is(":checked")) {
				
				$("#id_point_tab_top1").hide();
				$("#id_point_tab_top2").hide();
		    	$("#id_point_tab_top3").show();
		    	$("#id_point_tab_top4").show();
		    	$("#id_point_tab_top5").show();
		    	$("#id_point_col_top1").hide();
		    	$("#id_point_col_top2").hide();
		    	$("#id_point_col_top3").show();
		    	$("#id_point_col_top4").show();
		    	$("#id_point_col_top5").show();
		    	$("#id_check_point_dc").show();
				
				if($("#id_dc_check_sub").hasClass("active")){
					$(".class_point_storediscount1").show();
					$(".class_point_deliverydiscount").show();
					$(".class_point_takeoutdiscount").show();
					$(".class_point_storepoint").hide();
					$(".class_point_deliverypoint").hide();
					$(".class_point_takeoutpoint").hide();
					$(".class_point_point").hide();
					$(".class_point_storediscount").hide();
					
				}else{				
		    	
			    	$(".class_point_storepoint").show();
			    	$(".class_point_deliverypoint").show();
			    	$(".class_point_takeoutpoint").show();
			    	$(".class_point_storediscount").hide();
			    	$(".class_point_point").hide();
			    	$(".class_point_deliverydiscount").hide();
			    	$(".class_point_takeoutdiscount").hide(); 
				}		    	
		    
			}else{
				
				$("#id_point_tab_top1").show();
				$("#id_point_tab_top2").show();
		    	$("#id_point_tab_top3").hide();
		    	$("#id_point_tab_top4").hide();
		    	$("#id_point_tab_top5").hide();
		    	$("#id_point_col_top1").show();
		    	$("#id_point_col_top2").show();
		    	$("#id_point_col_top3").hide();
		    	$("#id_point_col_top4").hide();
		    	$("#id_point_col_top5").hide();
		    	
		    	$(".class_point_point").show();
		    	$(".class_point_storediscount").show();
		    	$(".class_point_storepoint").hide();		    	
		    	$(".class_point_deliverypoint").hide();
		    	$(".class_point_takeoutpoint").hide();
		    	$(".class_point_deliverydiscount").hide();
		    	$(".class_point_takeoutdiscount").hide();
		    	$(".class_point_storediscount1").hide();
		    	
		    	$("#id_check_point_dc").hide();
				//$("#id_menu_save").addClass("class_short_save").removeClass("class_long_save");
		    	//$("tr.class_menu_main_view").attr("menuFlag" , "false");
			}
		})				
		
		$(".class_menu_save").click(function(e){
			e.preventDefault();			
			updateShortMenu();						
			
	    });
		$("#id_menu_delete").click(function(e){
			e.preventDefault();
			if(!confirm("정말로 삭제하시겠습니까?")){
				return false;
			}
			
			$('tr.class_menu_main_view').each(function(){
				if($(this).find("input:eq(0)").is(":checked")){
					if($(this).attr("catemenuname")){
						$(this).attr("isdeleted", "Y");
						menuSave();						
					}else{
						$(this).remove();
					}
				}
			})
			//						
	    });
		
		$("#id_point_save").click(function(e){
			e.preventDefault();	
			dcPointSave();			
			
	    });
		$("#id_dc_check_sub").click(function(e){
			e.preventDefault();
			$(this).addClass("active");
			$("#id_point_check_sub").removeClass("active");
			$(".class_point_storediscount1").show();
			$(".class_point_deliverydiscount").show();
			$(".class_point_takeoutdiscount").show();
			$(".class_point_storepoint").hide();
			$(".class_point_deliverypoint").hide();
			$(".class_point_takeoutpoint").hide();
	    });
		$("#id_point_check_sub").click(function(e){
			e.preventDefault();
			$(this).addClass("active");
			$("#id_dc_check_sub").removeClass("active");
			$(".class_point_storediscount1").hide();
			$(".class_point_deliverydiscount").hide();
			$(".class_point_takeoutdiscount").hide();
			$(".class_point_storepoint").show();
			$(".class_point_deliverypoint").show();
			$(".class_point_takeoutpoint").show();
	    });
		
		$("#menu-page .class_category_area > li").click(function(e){
			e.preventDefault();
			var tabcateid= $(this).attr("tabcateid");
			var url = '/pos/category/categoryMenuManage.do?categoryid=' + tabcateid ;
			if($(this).val() == 1){
				$(location).attr('href',url);
			}else if($(this).val() == 2){
				$(location).attr('href',url);
			}else if($(this).val() == 3){
				$(location).attr('href',url);
			}else if($(this).val() == 4){
				$(location).attr('href',url);
			}else{
				$("#others_menu").popup( "open" );
			}
			$(this).addClass("on").siblings().removeClass("on");
		});
		
		$("#point-page .class_category_point_area > li").click(function(e){
			e.preventDefault();
			var tabpointid= $(this).attr("tabpointid");
			var url = '/pos/category/categoryPointManage.do?categoryid=' + tabpointid ;
			if($(this).val() == 1){
				$(location).attr('href',url);
			}else if($(this).val() == 2){
				$(location).attr('href',url);
			}else if($(this).val() == 3){
				$(location).attr('href',url);
			}else if($(this).val() == 4){
				$(location).attr('href',url);
			}else{
				$("#others_menu1").popup( "open" );
			}
			$(this).addClass("on").siblings().removeClass("on");
		});
		
		//카테고리 위아래 이벤트 처리
		$("#id_cate_up").click(function(e){		
			e.preventDefault();				
			if($(".class_cate_index li a:eq(0)").hasClass("on") || !$(".class_cate_index li a").hasClass("on")){
				
			}else if($(".class_cate_index li a:eq(1)").hasClass("on")){				
				$(".class_cate_index li a:eq(1)").parent().prev("li").before($(".class_cate_index li a:eq(1)").parent());
				$(".class_cate_index_sub li span:eq(1)").parent().prev("li").before($(".class_cate_index_sub li span:eq(1)").parent());
			}else if($(".class_cate_index li a:eq(2)").hasClass("on")){
				$(".class_cate_index li a:eq(2)").parent().prev("li").before($(".class_cate_index li a:eq(2)").parent());
				$(".class_cate_index_sub li span:eq(2)").parent().prev("li").before($(".class_cate_index_sub li span:eq(2)").parent());
			}else{
				alert("고정된 항목입니다");
			}
	    });	
		
		$("#id_cate_down").click(function(e){
			e.preventDefault();	
			if($(".class_cate_index li a:eq(0)").hasClass("on")){
				$(".class_cate_index li a:eq(0)").parent().next("li").after($(".class_cate_index li a:eq(0)").parent());
				$(".class_cate_index_sub li span:eq(0)").parent().next("li").after($(".class_cate_index_sub li span:eq(0)").parent());
			}else if($(".class_cate_index li a:eq(1)").hasClass("on")){
				$(".class_cate_index li a:eq(1)").parent().next("li").after($(".class_cate_index li a:eq(1)").parent());
				$(".class_cate_index_sub li span:eq(1)").parent().next("li").after($(".class_cate_index_sub li span:eq(1)").parent());
			}else if($(".class_cate_index li a:eq(2)").hasClass("on") || !$(".class_cate_index li a").hasClass("on")){
				
			}else{
				alert("고정된 항목입니다");
			}
	    });	
		//카테고리 포커스 이벤트		
		$(".class_cate_index li").click(function(e){
			e.preventDefault();
			$(this).children("a").addClass("on").end().siblings("li").children("a").removeClass("on");
		});		
		
		//메뉴 위아래 이벤트 처리
		$("#id_menu_up").click(function(e){	
			
			e.preventDefault();
			//var index = $(".class_menu_main_top tr label:eq(0)").attr("sortorder");
			$('tr.class_menu_main_view').each(function(index){
				if($(this).find("input:eq(0)").is(":checked")){					
					index = index -1 ;
					
					if(index >=0 ){
					   $(".class_menu_main_top tr td").parent().prev("tr:eq("+index+")").before($(".class_menu_main_top tr td").parent());
					}
				}
			})	
	    });	
		
		$("#id_menu_down").click(function(e){
			e.preventDefault();	
			$('tr.class_menu_main_view').each(function(index){
				if($(this).find("input:eq(0)").is(":checked")){					
					index = index;				
					$(".class_menu_main_top tr td").parent().next("tr:eq("+index+")").after($(".class_menu_main_top tr td").parent());					
				}
			})
	    });	
		
		$("#id_menu_add_row").click(function(){
			var memberid = $("tr.class_menu_main_view").attr('memberid');
			var deviceid = $("tr.class_menu_main_view").attr('deviceid');
			var categoryid = $("tr.class_menu_main_view").attr('categoryid');
			var sortorder = parseInt($("tr.class_menu_main_view").last().attr('sortorder')) + 1;
			var menuid = 'temp_' + new Date().getTime();
			var storeprice;
			var deliveryprice;
			var takeoutprice;
			var ishidden = $("tr.class_menu_main_view").attr('ishidden');
			var isdeleted = $("tr.class_menu_main_view").attr('isdeleted');
			
			var data =  "<tr class=\"class_menu_main_view\" memberid=\""+ memberid +"\" deviceid=\""+ deviceid +"\" sortorder=\""+ sortorder +"\" menuid=\""+ menuid +"\" categoryid=\""+categoryid +"\" storeprice=\""+storeprice +"\" deliveryprice=\""+deliveryprice +"\" takeoutprice=\""+takeoutprice +"\" ishidden=\""+ishidden +"\" isdeleted=\""+isdeleted +"\">" + 
						"<td><label>" + "<input type=\"checkbox\"/>" + "</label></td>" +
						"<td>" + "<input type=\"text\" data-role=\"none\" />" + "</td>" +						
						"<td class=\"class_menu_storeprice\">" + "<input type=\"tel\" data-role=\"none\" />" + "</td>" +
						"<td class=\"class_menu_deliveryprice\">" + "<input type=\"tel\" data-role=\"none\" />" + "</td>" +
						"<td class=\"class_menu_takeoutprice\">" + "<input type=\"tel\" data-role=\"none\" />" + "</td>" +
						"<td><label>" + "<input type=\"checkbox\" />" + "</label></td>" +
					     "</tr>"			
			
			$("#id_tbodylist > tbody:last").append(data);
			
			if($(".class_menu_check").is(":checked")){
		    	$(".class_menu_deliveryprice").show();
		    	$(".class_menu_takeoutprice").show();				
				
			}else{
		    	$(".class_menu_deliveryprice").hide();
		    	$(".class_menu_takeoutprice").hide();								
				
			}
		});
		
		$(".class_menu_pop").change(function(e){
			e.preventDefault();
			var etccateid= $(this).attr("etccateid");
			var url = '/pos/category/categoryMenuManage.do?categoryid=' + etccateid ;
			
			if($("input[name=otherL]:checked").val() == 5){	
				$(parent.location).attr('href',url);
			}else if($("input[name=otherL]:checked").val() == 6){	
				$(parent.location).attr('href',url);
			}else if($("input[name=otherL]:checked").val() == 7){
				$(parent.location).attr('href',url);
			}else if($("input[name=otherL]:checked").val() == 8){
				$(parent.location).attr('href',url);
			}else if($("input[name=otherL]:checked").val() == 9){
				$(parent.location).attr('href',url);
				//window.opener.parent.location.reload();
				//$("#id_etc_menu_close").click();
			}	
			$("#menu-page .class_category_area > li").addClass("on").siblings().removeClass("on");
		});
		$(".class_point_pop").change(function(){
			var etcpointid= $(this).attr("etcpointid");
			var url = '/pos/category/categoryPointManage.do?categoryid=' + etcpointid ;
			
			if($("input[name=otherL_point]:checked").val() == 5){	
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
			}else if($("input[name=otherL_point]:checked").val() == 6){	
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
			}else if($("input[name=otherL_point]:checked").val() == 7){
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
			}else if($("input[name=otherL_point]:checked").val() == 8){
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
			}else if($("input[name=otherL_point]:checked").val() == 9){
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
			}		
		});		
		
		$("tr.class_menu_main_view").each(function() {
			if( $(this).attr("ishidden") == "Y"){
				$(this).find("label:eq(1)").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
				$(this).find("input:eq(6)").prop("checked", true).attr("data-cacheval" , false);
			}else{
				$(this).find("label:eq(1)").addClass("ui-checkbox-off").removeClass("ui-checkbox-on");
				$(this).find("input:eq(6)").prop("checked", false).attr("data-cacheval" , true);
			}
		});
		
		/*포인트|할인율 */
		//할인 시간대 설정 이벤트 처리	
		$("#id_point_set_time_differ li").click(function(e){
			e.preventDefault();
			$(this).children("a").addClass("active").end().siblings("li").children("a").removeClass("active");
			getDcTimetap();
		});
		
		$(".class_point_time_differ").change(function(e){
			e.preventDefault();			
			
			if($(this).is(":checked")) {
				
		    	$("#id_point_set_time_differ").show();
		    	$("#id_point_time_same").hide();
		    	
			}else{
				
				$("#id_point_set_time_differ").hide();
		    	$("#id_point_time_same").show();		    
			}
		})
		
		$("#id_point_am_btn").click(function(e){
			e.preventDefault();	
			if($("#id_point_am_text").text() == '오후'){
			     $("#id_point_am_text").text("오전");
			}else{
			     $("#id_point_am_text").text("오후");
			}
		});
		$("#id_point_pm_btn").click(function(e){
			e.preventDefault();	
			if($("#id_point_pm_text").text() == '오후'){
			     $("#id_point_pm_text").text("오전");
			}else{
			     $("#id_point_pm_text").text("오후");
			}
		});
		
		$("#id_point_minute_btn").click(function(e){
			e.preventDefault();	
			if($("#id_point_minute_text").text() == '00'){
			     $("#id_point_minute_text").text("30");
			}else{
			     $("#id_point_minute_text").text("00");
			}
		});
		$("#id_point_minute2_btn").click(function(e){
			e.preventDefault();	
			if($("#id_point_minute2_text").text() == '00'){
			     $("#id_point_minute2_text").text("30");
			}else{
			     $("#id_point_minute2_text").text("00");
			}
		});
		
		$("#id_point_hour_plus_btn").click(function(e){
			e.preventDefault();
			var hour = $("#id_point_hour_text").text();
			if(hour == '12'){
				$("#id_point_hour_text").text("01");
			}else{
				if(10 > parseInt(hour.substring(1,2)) && hour != "09" && hour != "10" && hour != "11"){
				    $("#id_point_hour_text").text("0" + (parseInt(hour)+ 1));
				}else{
					$("#id_point_hour_text").text(parseInt(hour)+ 1);					
				}
			}			
		});
		$("#id_point_hour_minus_btn").click(function(e){
			e.preventDefault();	
			var hour = $("#id_point_hour_text").text();
			if(hour == '01'){
				$("#id_point_hour_text").text("12");
			}else if(hour == '00'){
				$("#id_point_hour_text").text("11");
			}else{
				if( hour != "11" && hour != "12" && hour != "00"){
				    $("#id_point_hour_text").text("0" + (parseInt(hour) - 1));
				}else{
					$("#id_point_hour_text").text(parseInt(hour) - 1);					
				}
			}			
		});
		$("#id_point_hour2_plus_btn").click(function(e){
			e.preventDefault();
			var hour = $("#id_point_hour2_text").text();
			if(hour == '12'){
				$("#id_point_hour2_text").text("01");
			}else{
				if(10 > parseInt(hour.substring(1,2)) && hour != "09" && hour != "10" && hour != "11"){
				    $("#id_point_hour2_text").text("0" + (parseInt(hour)+ 1));
				}else{
					$("#id_point_hour2_text").text(parseInt(hour)+ 1);					
				}
			}			
		});
		$("#id_point_hour2_minus_btn").click(function(e){
			e.preventDefault();	
			var hour = $("#id_point_hour2_text").text();
			if(hour == '01'){
				$("#id_point_hour2_text").text("12");
			}else if(hour == '00'){
				$("#id_point_hour2_text").text("11");
			}else{
				if( hour != "11" && hour != "12" && hour != "00"){
				    $("#id_point_hour2_text").text("0" + (parseInt(hour) - 1));
				}else{
					$("#id_point_hour2_text").text(parseInt(hour) - 1);					
				}
			}			
		});
		
		$(".class_menu_dc_save").click(function(e){
			e.preventDefault();
			if($(".class_point_time_differ").is(":checked")){
				dcDifferSave();
			}else{				
				dcEqualSave();
			}
			location.reload();
		});	
		
	}
	
	function updateCate(sortorder,name,categoryid){
		
		if(!confirm("저장하시겠습니까?")){
			return false;
		}
		
		 $(".class_cate").each(function(index ) {
			 
			 var name = $(this).find("input").val();
			 
			 if(name){			 
				  name = $(this).find("input").val();
			 }else {
				  name = $(this).attr('catename');
			 }
			 var sortorder = index+1;
			 
			 var categoryid = $(this).attr('categoryid');
			 var memberid = $(this).attr('memberid');
			 var deviceid = $(this).attr('deviceid');
			 
			 var param ="sortorder=" + sortorder + "&name=" + name+ "&categoryid=" + categoryid + "&memberid=" + memberid + "&deviceid=" + deviceid;	
			 var url = "update_ok.json";
				
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

	function updateShortMenu(){
		
		if(!confirm("저장하시겠습니까?")){
			return false;
		}
		menuSave();			
		menuDifferSave();
	}
    function dcPointSave(){
		
		if(!confirm("저장하시겠습니까?")){
			return false;
		}
		pointSave();
		dcPoDifferSave();
		dcPointChoiceSave();
	}
	function menuSave(){
		$("tr.class_menu_main_view").each(function(index) {			 
			
			 var catemenuname = $(this).attr('catemenuname');
			 var catemenuname2 = $(this).find("input:eq(1)").val();
			 
			 if(catemenuname != catemenuname2){
				 catemenuname = catemenuname2;
			 }else {
				 catemenuname;
			 }			
			 //var catemenuname = $(this).attr('catemenuname');
			 var sortorder = index+1;
			 var categoryid = $(this).attr('categoryid');			 
			 //var menuid = $(this).attr('menuid');
			 var menuid = ($(this).attr("menuid") || "").startsWith("temp_") ? "" : $(this).attr("menuid");
			 var memberid = $(this).attr('memberid');
			
			 var storeprice = $(this).attr('storeprice');
			 var storeprice2 = $(this).find("input:eq(2)").val();
			 
			 if(storeprice != storeprice2){			 
				 storeprice = storeprice2 * 1000;
			 }else {
				 storeprice;
			 }
			 
			 var deliveryprice = $(this).attr('deliveryprice');
			 if(deliveryprice == "" || deliveryprice == "undefined"){
				 deliveryprice = storeprice;
			 }else{
				 deliveryprice = $(this).attr('deliveryprice');
				 var deliveryprice2 = $(this).find("input:eq(3)").val();
				 if(deliveryprice != deliveryprice2){	
					 deliveryprice = deliveryprice2 * 1000;
				 }else {
					 deliveryprice;
				 }
			 }
			 var takeoutprice = $(this).attr('takeoutprice');
			 if(takeoutprice == "" || takeoutprice == "undefined"){
				 takeoutprice = storeprice;
			 }else{
				 takeoutprice = $(this).attr('takeoutprice');
				 var takeoutprice2 = $(this).find("input:eq(4)").val();
				 if(takeoutprice != takeoutprice2){	
					 takeoutprice = takeoutprice2 * 1000;
				 }else {
					 takeoutprice;
				 }
			 }
			 var ishidden = $(this).attr('ishidden');
			 if(ishidden == "" || ishidden == "undefined" ){
				 ishidden = "N";
			 }else{
				 if($(this).find("input:last").is(":checked")){
					 $(this).attr("ishidden", "Y");
					 ishidden = "Y";
				 }else{
					 $(this).attr("ishidden", "N");
					 ishidden = "N";
				 }
			 }
			 var isdeleted = $(this).attr('isdeleted');
			 var menuFlag = $(this).attr('menuFlag');
			 
			 var param ="sortorder=" + sortorder + "&name=" + catemenuname+ "&categoryid=" + categoryid + "&menuid=" + menuid + "&memberid=" + memberid + 
			 "&storeprice=" + storeprice + "&deliveryprice=" + deliveryprice + "&takeoutprice=" + takeoutprice + "&ishidden=" + ishidden + "&isdeleted=" + isdeleted + "&menuFlag=" + menuFlag;
			 //alert(param);
			 if(menuid){
				 var url = "MenuUpdatetOk.json";
			 }else{
				 var url = "MenuInsertOk.json";
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
					location.reload();
				}
			 });	
		});	
	}
	
	function pointSave(){		
		
		$("tr.class_point_main_view").each(function() {			 
			
			 var catepointname = $(this).attr('catepointname');
			 var catepointname2 = $(this).find("input:eq(0)").val();
			 
			 if(catepointname != catepointname2){
				 catepointname = catepointname2;
			 }else {
				 catepointname;
			 }			
			 //var catemenuname = $(this).attr('catemenuname');
			 var sortorder = $(this).attr('sortorder');
			 var categoryid = $(this).attr('categoryid');			 
			 //var menuid = $(this).attr('menuid');
			 var menuid = ($(this).attr("menuid") || "").startsWith("temp_") ? "" : $(this).attr("menuid");
			 var memberid = $(this).attr('memberid');
			
			 var storepoint = $(this).attr('storepoint');
			 var storepoint2 = $(this).find("input:eq(1)").val();
			 
			 if(storepoint != storepoint2){			 
				 storepoint = storepoint2;
			 }else {
				 storepoint;
			 }
			
			 var deliverypoint = $(this).attr('deliverypoint');
			 if(deliverypoint == "" || deliverypoint == "undefined"){
				 deliverypoint = storepoint;
			 }else{
				 deliverypoint = $(this).attr('deliverypoint');
				 var deliverypoint2 = $(this).find("input:eq(4)").val();
				 if(deliverypoint != deliverypoint2){	
					 deliverypoint = deliverypoint2;
				 }else {
					 deliverypoint;
				 }
			 }
			 var takeoutpoint = $(this).attr('takeoutpoint');
			 if(takeoutpoint == "" || takeoutpoint == "undefined"){
				 takeoutpoint = storepoint;
			 }else{
				 takeoutpoint = $(this).attr('takeoutpoint');
				 var takeoutpoint2 = $(this).find("input:eq(5)").val();
				 if(takeoutpoint != takeoutpoint2){	
					 takeoutpoint = takeoutpoint2;
				 }else {
					 takeoutpoint;
				 }
			 }
			 
			 var storediscount = $(this).attr('storediscount');
			 var storediscount2 = $(this).find("input:eq(2)").val();
			 
			 if(storediscount != storediscount2){			 
				 storediscount = storediscount2;
			 }else {
				 storediscount;
			 }
			
			 var deliverydiscount = $(this).attr('deliverydiscount');
			 if(deliverydiscount == "" || deliverydiscount == "undefined"){
				 deliverydiscount = storediscount;
			 }else{
				 deliverydiscount = $(this).attr('deliverydiscount');
				 var deliverydiscount2 = $(this).find("input:eq(7)").val();
				 if(deliverydiscount != deliverydiscount2){	
					 deliverydiscount = deliverydiscount2;
				 }else {
					 deliverydiscount;
				 }
			 }
			 var takeoutdiscount = $(this).attr('takeoutdiscount');
			 if(takeoutdiscount == "" || takeoutdiscount == "undefined"){
				 takeoutdiscount = storediscount;
			 }else{
				 takeoutdiscount = $(this).attr('takeoutdiscount');
				 var takeoutdiscount2 = $(this).find("input:eq(8)").val();
				 if(takeoutdiscount != takeoutdiscount2){	
					 takeoutdiscount = takeoutdiscount2;
				 }else {
					 takeoutdiscount;
				 }
			 }	
			 
			// var defaultprice = $(this).attr('defaultprice');			 
			 var param ="sortorder=" + sortorder + "&name=" + catepointname+ "&categoryid=" + categoryid + "&menuid=" + menuid + "&memberid=" + memberid + 
			 "&storepoint=" + storepoint + "&deliverypoint=" + deliverypoint + "&takeoutpoint=" + takeoutpoint + "&storediscount=" + storediscount + "&deliverydiscount=" + deliverydiscount + "&takeoutdiscount=" + takeoutdiscount;
			 //alert(param);
			 if(menuid){
				 var url = "PointUpdatetOk.json";
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
					location.reload();
				}
			 });	
		});	
	} 
	
	function displayCategoryMenu(){
		categoryid = window.bapdosa.urlParams["categoryid"] || "";
		console.log("categoryid: " + categoryid);
		var name = $(".class_category_area li[tabcateid='" + categoryid + "']").attr("catename");
		var isetc = $(".class_category_area li[tabcateid='" + categoryid + "']").attr("isetc");
		$(".class_menu_tab_top").text(name);
		
		if(isetc == "N"){
		    $(".class_category_area li[tabcateid='" + categoryid + "']").addClass("on");
		}else{
			$(".class_category_area li[tabcateid=tabcateid5]").addClass("on");
			var popname = $(".class_menu_pop_tap li input[etccateid='" + categoryid + "']").attr("popname");
			$(".class_menu_tab_top").text(popname);
		}			
	}
	
	function displayCategoryPoint(){
		categoryid = window.bapdosa.urlParams["categoryid"] || "";
		console.log("categoryid: " + categoryid);
		
		var name = $(".class_category_point_area li[tabpointid='" + categoryid + "']").attr("pointname");
		var isetc = $(".class_category_point_area li[tabpointid='" + categoryid + "']").attr("isetc");
		$(".class_point_tab_top").text(name);
		
		if(isetc == "N"){
		    $(".class_category_point_area li[tabpointid='" + categoryid + "']").addClass("on");
		}else{
			$(".class_category_point_area li[tabpointid=tabpointid5]").addClass("on");
			var pointname = $(".class_point_pop_tap li input[etcpointid='" + categoryid + "']").attr("pointname");
			$(".class_point_tab_top").text(pointname);
		}		
	}
	function getMenuDiffer(){
		var dfd = new jQuery.Deferred();
		var url="/pos/category/getMenuDiffer.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			
			menuDiffer = returnObj.menuDiffer;
			console.log("menuDiffer=" + menuDiffer);
			$(menuDiffer).each(function(index,obj){
				if(obj.SETTINGVALUE == "CC00002102")	{
					$(".class_menu_differ_check div").find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
					$(".class_menu_differ_check div").find("input").prop("checked", true).attr("data-cacheval" , false);
					$("#id_menu_tab_top3").show();
			    	$("#id_menu_tab_top4").show();
			    	$("#id_menu_col_top3").show();
			    	$("#id_menu_col_top4").show();			    	
			    	$(".class_menu_deliveryprice").show();
			    	$(".class_menu_takeoutprice").show();
				}else{
					$(".class_menu_differ_check div").find("label").removeClass("ui-checkbox-on").addClass("ui-checkbox-off");
					$(".class_menu_differ_check div").find("input").prop("checked", false).attr("data-cacheval" , true);
					$("#id_menu_tab_top3").hide();
			    	$("#id_menu_tab_top4").hide();
			    	$("#id_menu_col_top3").hide();
			    	$("#id_menu_col_top4").hide();
			    	$(".class_menu_deliveryprice").hide();
			    	$(".class_menu_takeoutprice").hide();
				}
			});
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
	
	function getDcDiffer(){
		var dfd = new jQuery.Deferred();
		var url="/pos/category/getDcDiffer.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			
			dcDiffer = returnObj.dcDiffer;
			console.log("dcDiffer=" + dcDiffer);
			$(dcDiffer).each(function(index,obj){
				if(obj.SETTINGVALUE == "CC00002202")	{
					$(".class_dc_differ_check div").find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
					$(".class_dc_differ_check div").find("input").prop("checked", true).attr("data-cacheval" , false);
					
					$("#id_point_tab_top1").hide();
					$("#id_point_tab_top2").hide();
			    	$("#id_point_tab_top3").show();
			    	$("#id_point_tab_top4").show();
			    	$("#id_point_tab_top5").show();
			    	$("#id_point_col_top1").hide();
			    	$("#id_point_col_top2").hide();
			    	$("#id_point_col_top3").show();
			    	$("#id_point_col_top4").show();
			    	$("#id_point_col_top5").show();
			    	$("#id_check_point_dc").show();					
					
					
				}else{
					$(".class_dc_differ_check div").find("label").removeClass("ui-checkbox-on").addClass("ui-checkbox-off");
					$(".class_dc_differ_check div").find("input").prop("checked", false).attr("data-cacheval" , true);
					
					$("#id_point_tab_top1").show();
					$("#id_point_tab_top2").show();
			    	$("#id_point_tab_top3").hide();
			    	$("#id_point_tab_top4").hide();
			    	$("#id_point_tab_top5").hide();
			    	$("#id_point_col_top1").show();
			    	$("#id_point_col_top2").show();
			    	$("#id_point_col_top3").hide();
			    	$("#id_point_col_top4").hide();
			    	$("#id_point_col_top5").hide();
			    	
			    	$(".class_point_point").show();
			    	$(".class_point_storediscount").show();
			    	$(".class_point_storepoint").hide();		    	
			    	$(".class_point_deliverypoint").hide();
			    	$(".class_point_takeoutpoint").hide();
			    	$(".class_point_deliverydiscount").hide();
			    	$(".class_point_takeoutdiscount").hide();
			    	$(".class_point_storediscount1").hide();
			    	
			    	$("#id_check_point_dc").hide();
					
				}
			});
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
	
	function getDcPointChoice(){
		var dfd = new jQuery.Deferred();
		var url="/pos/category/getDcPointChoice.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			
			dcPointChoice = returnObj.dcPointChoice;
			console.log("dcPointChoice=" + dcPointChoice);
			$(dcPointChoice).each(function(index,obj){
				if(obj.SETTINGVALUE == "CC00002302")	{	
					$("#id_dc_check_sub").addClass("active");
					$("#id_point_check_sub").removeClass("active");	
					
					$(".class_point_storediscount1").show();
					$(".class_point_deliverydiscount").show();
					$(".class_point_takeoutdiscount").show();
					$(".class_point_storepoint").hide();
					$(".class_point_deliverypoint").hide();
					$(".class_point_takeoutpoint").hide();
					$(".class_point_point").hide();
					$(".class_point_storediscount").hide();
					
				}else{
					$("#id_dc_check_sub").removeClass("active");
					$("#id_point_check_sub").addClass("active");
					
					$(".class_point_storepoint").show();
			    	$(".class_point_deliverypoint").show();
			    	$(".class_point_takeoutpoint").show();
			    	$(".class_point_storediscount").hide();
			    	$(".class_point_point").hide();
			    	$(".class_point_deliverydiscount").hide();
			    	$(".class_point_takeoutdiscount").hide();
					
				}
			});
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
	
	function getDcTimeList(){
		var dfd = new jQuery.Deferred();
		var url="/pos/category/getDcTimezoneSet.json";
		var timezonedivision = 1;
		var param="timezonedivision=" + timezonedivision;
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			
			dcTimezoneSet = returnObj.dcTimezoneSet;
			console.log("dcTimezoneSet=" + dcTimezoneSet);
			
			$(dcTimezoneSet).each(function(index,obj){
				$(".class_dc_time_line").attr("memberid", obj.MEMBERID);
				$(".class_dc_time_differ_main").attr("timezonedivision",timezonedivision).attr("starttime1",obj.STARTTIME1).attr("starttime2",obj.STARTTIME2).attr("starttime3",obj.STARTTIME3).attr("starttime4",obj.STARTTIME4).attr("starttime5",obj.STARTTIME5).attr("starttime6",obj.STARTTIME6).attr("starttime7",obj.STARTTIME7)
				.attr("endtime1",obj.ENDTIME1).attr("endtime2",obj.ENDTIME2).attr("endtime3",obj.ENDTIME3).attr("endtime4",obj.ENDTIME4).attr("endtime5",obj.ENDTIME5).attr("endtime6",obj.ENDTIME6).attr("endtime7",obj.ENDTIME7)	
                .attr("isusedtime1",obj.ISUSEDTIME1).attr("isusedtime2",obj.ISUSEDTIME2).attr("isusedtime3",obj.ISUSEDTIME3).attr("isusedtime4",obj.ISUSEDTIME4).attr("isusedtime5",obj.ISUSEDTIME5).attr("isusedtime6",obj.ISUSEDTIME6).attr("isusedtime7",obj.ISUSEDTIME7);	
				if(obj.ISDIFFERENTTIME == "Y"){
					$(".class_point_time_differ").click();
				}else{
					if(obj.ISUSEDTIME1 == "Y"){					
						$(".class_dc_time_same_main li").eq(0).find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
						$(".class_dc_time_same_main li").eq(0).find("input").prop("checked", true).attr("data-cacheval" , false);					
					}
					if(obj.ISUSEDTIME2 == "Y"){					
						$(".class_dc_time_same_main li").eq(1).find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
						$(".class_dc_time_same_main li").eq(1).find("input").prop("checked", true).attr("data-cacheval" , false);					
					}
					if(obj.ISUSEDTIME3 == "Y"){					
						$(".class_dc_time_same_main li").eq(2).find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
						$(".class_dc_time_same_main li").eq(2).find("input").prop("checked", true).attr("data-cacheval" , false);					
					}
					if(obj.ISUSEDTIME4 == "Y"){					
						$(".class_dc_time_same_main li").eq(3).find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
						$(".class_dc_time_same_main li").eq(3).find("input").prop("checked", true).attr("data-cacheval" , false);					
					}
					if(obj.ISUSEDTIME5 == "Y"){					
						$(".class_dc_time_same_main li").eq(4).find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
						$(".class_dc_time_same_main li").eq(4).find("input").prop("checked", true).attr("data-cacheval" , false);					
					}
					if(obj.ISUSEDTIME6 == "Y"){					
						$(".class_dc_time_same_main li").eq(5).find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
						$(".class_dc_time_same_main li").eq(5).find("input").prop("checked", true).attr("data-cacheval" , false);					
					}
					if(obj.ISUSEDTIME7 == "Y"){					
						$(".class_dc_time_same_main li").eq(6).find("label").addClass("ui-checkbox-on").removeClass("ui-checkbox-off");
						$(".class_dc_time_same_main li").eq(6).find("input").prop("checked", true).attr("data-cacheval" , false);					
					}
					
				}
				if(obj.STARTTIME1){					
					$("#id_point_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME1.substring(0,2)));
					$("#id_point_minute_text").text(obj.STARTTIME1.substring(2,4));
					$("#id_point_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME1.substring(0,2)));	
				}else{
					$("#id_point_hour_text").text("00");
					$("#id_point_minute_text").text("00");
					$("#id_point_am_text").text("오전");
				}
				if(obj.ENDTIME1){					
					$("#id_point_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME1.substring(0,2)));
					$("#id_point_minute2_text").text(obj.ENDTIME1.substring(2,4));
					$("#id_point_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME1.substring(0,2)));
				}else{
					$("#id_point_hour2_text").text("00");
					$("#id_point_minute2_text").text("00");	
					$("#id_point_pm_text").text("오후");
				}				
			});
					
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
    
    function getDcTimetap(){
		var dfd = new jQuery.Deferred();
		var url="/pos/category/getDcTimezoneSet.json";
		var timezonedivision = 1;
		var param="timezonedivision=" + timezonedivision;
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;
			
			dcTimezoneSet = returnObj.dcTimezoneSet;
			console.log("dcTimezoneSet=" + dcTimezoneSet);
			
			$(dcTimezoneSet).each(function(index,obj){
				if($("#id_point_set_time_differ li").eq(0).find("a").hasClass("active")){
					if(obj.STARTTIME1){					
						$("#id_point_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME1.substring(0,2)));
						$("#id_point_minute_text").text(obj.STARTTIME1.substring(2,4));
						$("#id_point_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME1.substring(0,2)));	
					}else{
						$("#id_point_hour_text").text("00");
						$("#id_point_minute_text").text("00");
						$("#id_point_am_text").text("오전");
					}
					if(obj.ENDTIME1){					
						$("#id_point_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME1.substring(0,2)));
						$("#id_point_minute2_text").text(obj.ENDTIME1.substring(2,4));
						$("#id_point_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME1.substring(0,2)));
					}else{
						$("#id_point_hour2_text").text("00");
						$("#id_point_minute2_text").text("00");	
						$("#id_point_pm_text").text("오후");
					}
				}
				if($("#id_point_set_time_differ li").eq(1).find("a").hasClass("active")){
					if(obj.STARTTIME2){					
						$("#id_point_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME2.substring(0,2)));
						$("#id_point_minute_text").text(obj.STARTTIME2.substring(2,4));
						$("#id_point_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME2.substring(0,2)));	
					}else{
						$("#id_point_hour_text").text("00");
						$("#id_point_minute_text").text("00");
						$("#id_point_am_text").text("오전");
					}
					if(obj.ENDTIME2){					
						$("#id_point_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME2.substring(0,2)));
						$("#id_point_minute2_text").text(obj.ENDTIME2.substring(2,4));
						$("#id_point_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME2.substring(0,2)));
					}else{
						$("#id_point_hour2_text").text("00");
						$("#id_point_minute2_text").text("00");	
						$("#id_point_pm_text").text("오후");
					}
				}
				if($("#id_point_set_time_differ li").eq(2).find("a").hasClass("active")){
					if(obj.STARTTIME3){					
						$("#id_point_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME3.substring(0,2)));
						$("#id_point_minute_text").text(obj.STARTTIME3.substring(2,4));
						$("#id_point_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME3.substring(0,2)));	
					}else{
						$("#id_point_hour_text").text("00");
						$("#id_point_minute_text").text("00");
						$("#id_point_am_text").text("오전");
					}
					if(obj.ENDTIME3){					
						$("#id_point_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME3.substring(0,2)));
						$("#id_point_minute2_text").text(obj.ENDTIME3.substring(2,4));
						$("#id_point_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME3.substring(0,2)));
					}else{
						$("#id_point_hour2_text").text("00");
						$("#id_point_minute2_text").text("00");	
						$("#id_point_pm_text").text("오후");
					}
				}
				if($("#id_point_set_time_differ li").eq(3).find("a").hasClass("active")){
					if(obj.STARTTIME4){					
						$("#id_point_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME4.substring(0,2)));
						$("#id_point_minute_text").text(obj.STARTTIME4.substring(2,4));
						$("#id_point_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME4.substring(0,2)));	
					}else{
						$("#id_point_hour_text").text("00");
						$("#id_point_minute_text").text("00");
						$("#id_point_am_text").text("오전");
					}
					if(obj.ENDTIME4){					
						$("#id_point_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME4.substring(0,2)));
						$("#id_point_minute2_text").text(obj.ENDTIME4.substring(2,4));
						$("#id_point_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME4.substring(0,2)));
					}else{
						$("#id_point_hour2_text").text("00");
						$("#id_point_minute2_text").text("00");	
						$("#id_point_pm_text").text("오후");
					}
				}
				if($("#id_point_set_time_differ li").eq(4).find("a").hasClass("active")){
					if(obj.STARTTIME5){					
						$("#id_point_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME5.substring(0,2)));
						$("#id_point_minute_text").text(obj.STARTTIME5.substring(2,4));
						$("#id_point_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME5.substring(0,2)));	
					}else{
						$("#id_point_hour_text").text("00");
						$("#id_point_minute_text").text("00");
						$("#id_point_am_text").text("오전");
					}
					if(obj.ENDTIME5){					
						$("#id_point_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME5.substring(0,2)));
						$("#id_point_minute2_text").text(obj.ENDTIME5.substring(2,4));
						$("#id_point_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME5.substring(0,2)));
					}else{
						$("#id_point_hour2_text").text("00");
						$("#id_point_minute2_text").text("00");	
						$("#id_point_pm_text").text("오후");
					}
				}
				if($("#id_point_set_time_differ li").eq(5).find("a").hasClass("active")){
					if(obj.STARTTIME6){					
						$("#id_point_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME6.substring(0,2)));
						$("#id_point_minute_text").text(obj.STARTTIME6.substring(2,4));
						$("#id_point_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME6.substring(0,2)));	
					}else{
						$("#id_point_hour_text").text("00");
						$("#id_point_minute_text").text("00");
						$("#id_point_am_text").text("오전");
					}
					if(obj.ENDTIME6){					
						$("#id_point_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME6.substring(0,2)));
						$("#id_point_minute2_text").text(obj.ENDTIME6.substring(2,4));
						$("#id_point_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME6.substring(0,2)));
					}else{
						$("#id_point_hour2_text").text("00");
						$("#id_point_minute2_text").text("00");	
						$("#id_point_pm_text").text("오후");
					}
				}
				if($("#id_point_set_time_differ li").eq(6).find("a").hasClass("active")){
					if(obj.STARTTIME7){					
						$("#id_point_hour_text").text(window.bapdosa.util.hourTo12(obj.STARTTIME7.substring(0,2)));
						$("#id_point_minute_text").text(obj.STARTTIME7.substring(2,4));
						$("#id_point_am_text").text(window.bapdosa.util.hourToampm(obj.STARTTIME7.substring(0,2)));	
					}else{
						$("#id_point_hour_text").text("00");
						$("#id_point_minute_text").text("00");
						$("#id_point_am_text").text("오전");
					}
					if(obj.ENDTIME7){					
						$("#id_point_hour2_text").text(window.bapdosa.util.hourTo12(obj.ENDTIME7.substring(0,2)));
						$("#id_point_minute2_text").text(obj.ENDTIME7.substring(2,4));
						$("#id_point_pm_text").text(window.bapdosa.util.hourToampm(obj.ENDTIME7.substring(0,2)));
					}else{
						$("#id_point_hour2_text").text("00");
						$("#id_point_minute2_text").text("00");	
						$("#id_point_pm_text").text("오후");
					}
				}
			});
					
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
    function menuDifferSave(){	
    	
		 var settingvalue;
		 
		 if($("input[name=name_menu_input]").is(":checked")){
			 settingvalue = 'CC00002102';
		 }else{
			 settingvalue = 'CC00002101';
		 }		 
		 var param ="settingvalue=" + settingvalue;
		 var url = "menuDifferUpdateOk.json";
			
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
    function dcPoDifferSave(){	
    	
		 var settingvalue;
		 
		 if($("input[name=name_dc_input]").is(":checked")){
			 settingvalue = 'CC00002202';
		 }else{
			 settingvalue = 'CC00002201';
		 }		 
		 var param ="settingvalue=" + settingvalue;
		 var url = "dcDifferUpdateOk.json";
			
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
    
    function dcPointChoiceSave(){	
    	
		 var settingvalue;
		 
		 if($("#id_dc_check_sub").hasClass("active")){
			 settingvalue = 'CC00002302';
		 }else{
			 settingvalue = 'CC00002301';
		 }		 
		 var param ="settingvalue=" + settingvalue;
		 var url = "dcPointChoiceUpdateOk.json";
			
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
    
    function dcEqualSave(){
		 if(!confirm("저장하시겠습니까?")){
			 return false;
		 }
		 	 
			 var memberid= $(".class_dc_time_line").attr("memberid");		 
			 var timezonedivision = "1";
			 var isdifferenttime = "N";
			 var isAmPm = $("#id_point_am_text").text();
			 var isAmPm2 = $("#id_point_pm_text").text();
			 var starttime = window.bapdosa.util.hourTo24(isAmPm,$("#id_point_hour_text").text()) + $("#id_point_minute_text").text();
			 var endtime = window.bapdosa.util.hourTo24(isAmPm2,$("#id_point_hour2_text").text()) + $("#id_point_minute2_text").text();
			 
			 var starttime1 = $(".class_dc_time_differ_main").attr("starttime1");
			 var starttime2 = $(".class_dc_time_differ_main").attr("starttime2");
			 var starttime3 = $(".class_dc_time_differ_main").attr("starttime3");
			 var starttime4 = $(".class_dc_time_differ_main").attr("starttime4");
			 var starttime5 = $(".class_dc_time_differ_main").attr("starttime5");
			 var starttime6 = $(".class_dc_time_differ_main").attr("starttime6");
			 var starttime7 = $(".class_dc_time_differ_main").attr("starttime7");
			 var endtime1 = $(".class_dc_time_differ_main").attr("endtime1");
			 var endtime2 = $(".class_dc_time_differ_main").attr("endtime2");
			 var endtime3 = $(".class_dc_time_differ_main").attr("endtime3");
			 var endtime4 = $(".class_dc_time_differ_main").attr("endtime4");
			 var endtime5 = $(".class_dc_time_differ_main").attr("endtime5");
			 var endtime6 = $(".class_dc_time_differ_main").attr("endtime6");
			 var endtime7 = $(".class_dc_time_differ_main").attr("endtime7");
			 var isusedtime1 = $(".class_dc_time_differ_main").attr("isusedtime1");
			 var isusedtime2 = $(".class_dc_time_differ_main").attr("isusedtime2");
			 var isusedtime3 = $(".class_dc_time_differ_main").attr("isusedtime3");
			 var isusedtime4 = $(".class_dc_time_differ_main").attr("isusedtime4");
			 var isusedtime5 = $(".class_dc_time_differ_main").attr("isusedtime5");
			 var isusedtime6 = $(".class_dc_time_differ_main").attr("isusedtime6");
			 var isusedtime7 = $(".class_dc_time_differ_main").attr("isusedtime7");
			 
			 $(".class_dc_time_same").each(function(index ) {	
				 
				if($(".class_dc_time_same").eq(0).find("input").is(":checked")){
					 starttime1 = starttime;
					 endtime1 = endtime;
					 isusedtime1 = "Y";
				}else{
					starttime1;
					endtime1;
					isusedtime1 = "N";
				}
				if($(".class_dc_time_same").eq(1).find("input").is(":checked")){					 
					 starttime2 = starttime;
					 endtime2 = endtime;
					 isusedtime2 = "Y";
				}else{
					starttime2;
					endtime2;
					isusedtime2 = "N";
				}
				if($(".class_dc_time_same").eq(2).find("input").is(":checked")){					 
					 starttime3 = starttime;
					 endtime3 = endtime;
					 isusedtime3 = "Y";
				}else{
					starttime3;
					endtime3;
					isusedtime3 = "N";
				}
				if($(".class_dc_time_same").eq(3).find("input").is(":checked")){					 
					 starttime4 = starttime;
					 endtime4 = endtime;
					 isusedtime4 = "Y";
				}else{
					starttime4;
					endtime4;
					isusedtime4 = "N";
				}
				if($(".class_dc_time_same").eq(4).find("input").is(":checked")){					 
					 starttime5 = starttime;
					 endtime5 = endtime;
					 isusedtime5 = "Y";
				}else{
					starttime5;
					endtime5;
					isusedtime5 = "N";
				}
				if($(".class_dc_time_same").eq(5).find("input").is(":checked")){					 
					 starttime6 = starttime;
					 endtime6 = endtime;
					 isusedtime6 = "Y";
				}else{
					starttime6;
					endtime6;
					isusedtime6 = "N";
				}
				if($(".class_dc_time_same").eq(6).find("input").is(":checked")){					 
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
			 //alert(param);
			 var url = "updateDcTimezoneSet.json";
				
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
   
   function dcDifferSave(){
		 if(!confirm("저장하시겠습니까?")){
			 return false;
		 }
		 	 
			 var memberid= $(".class_dc_time_line").attr("memberid");		 
			 var timezonedivision = "1";
			 var isdifferenttime = "Y";
			 var isAmPm = $("#id_point_am_text").text();
			 var isAmPm2 = $("#id_point_pm_text").text();
			 var starttime = window.bapdosa.util.hourTo24(isAmPm,$("#id_point_hour_text").text()) + $("#id_point_minute_text").text();
			 var endtime = window.bapdosa.util.hourTo24(isAmPm2,$("#id_point_hour2_text").text()) + $("#id_point_minute2_text").text();
			 
			 var starttime1 = $(".class_dc_time_differ_main").attr("starttime1");
			 var starttime2 = $(".class_dc_time_differ_main").attr("starttime2");
			 var starttime3 = $(".class_dc_time_differ_main").attr("starttime3");
			 var starttime4 = $(".class_dc_time_differ_main").attr("starttime4");
			 var starttime5 = $(".class_dc_time_differ_main").attr("starttime5");
			 var starttime6 = $(".class_dc_time_differ_main").attr("starttime6");
			 var starttime7 = $(".class_dc_time_differ_main").attr("starttime7");
			 var endtime1 = $(".class_dc_time_differ_main").attr("endtime1");
			 var endtime2 = $(".class_dc_time_differ_main").attr("endtime2");
			 var endtime3 = $(".class_dc_time_differ_main").attr("endtime3");
			 var endtime4 = $(".class_dc_time_differ_main").attr("endtime4");
			 var endtime5 = $(".class_dc_time_differ_main").attr("endtime5");
			 var endtime6 = $(".class_dc_time_differ_main").attr("endtime6");
			 var endtime7 = $(".class_dc_time_differ_main").attr("endtime7");
			 var isusedtime1 = $(".class_dc_time_differ_main").attr("isusedtime1");
			 var isusedtime2 = $(".class_dc_time_differ_main").attr("isusedtime2");
			 var isusedtime3 = $(".class_dc_time_differ_main").attr("isusedtime3");
			 var isusedtime4 = $(".class_dc_time_differ_main").attr("isusedtime4");
			 var isusedtime5 = $(".class_dc_time_differ_main").attr("isusedtime5");
			 var isusedtime6 = $(".class_dc_time_differ_main").attr("isusedtime6");
			 var isusedtime7 = $(".class_dc_time_differ_main").attr("isusedtime7");
			 
			 $(".class_dc_time_differ_tap").each(function(index ) {	
				 
				if($(".class_dc_time_differ_tap").eq(0).find("a").hasClass("active")){		
					 starttime1 = starttime;
					 endtime1 = endtime;
					 isusedtime1 = "Y";					 
					 
				}else if($(".class_dc_time_differ_tap").eq(1).find("a").hasClass("active")){
					 starttime2 = starttime;
					 endtime2 = endtime;
					 isusedtime2 = "Y";
					
				}else if($(".class_dc_time_differ_tap").eq(2).find("a").hasClass("active")){
					 starttime3 = starttime;
					 endtime3 = endtime;
					 isusedtime3 = "Y";
					
				}else if($(".class_dc_time_differ_tap").eq(3).find("a").hasClass("active")){
					 starttime4 = starttime;
					 endtime4 = endtime;
					 isusedtime4 = "Y";
					
				}else if($(".class_dc_time_differ_tap").eq(4).find("a").hasClass("active")){
					 starttime5 = starttime;
					 endtime5 = endtime;
					 isusedtime5 = "Y";
					
				}else if($(".class_dc_time_differ_tap").eq(5).find("a").hasClass("active")){
					 starttime6 = starttime;
					 endtime6 = endtime;
					 isusedtime6 = "Y";
					
				}else if($(".class_dc_time_differ_tap").eq(6).find("a").hasClass("active")){
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
			 var url = "updateDcTimezoneSet.json";
				
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
   
	return {
		init: function() {
			eventReg();				
			displayCategoryMenu();
			displayCategoryPoint();
			getDcTimeList();
			getMenuDiffer();
			$.when(getDcPointChoice()).then (
					function(status){
						console.log("status: " + status);
						getDcDiffer();
					}			
				);	
			//getDcDiffer();
			//getDcPointChoice();
		}
	}   
})();

