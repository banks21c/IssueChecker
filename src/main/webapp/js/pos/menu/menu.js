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
			location.reload();
		});	
		$(".class_menu_check").change(function(e){
			e.preventDefault();			
			
			if($(this).is(":checked")) {
				
				//$("#id_menu_tab_top1").hide();
		    	$("#id_menu_tab_top3").show();
		    	$("#id_menu_tab_top4").show();
		    	$("#id_menu_col_top3").show();
		    	$("#id_menu_col_top4").show();
		    	
		    	$(".class_menu_deliveryprice").show();
		    	$(".class_menu_takeoutprice").show();
				//$("#id_menu_save").addClass("class_long_save").removeClass("class_short_save");
		    	$("tr.class_menu_main_view").attr("menuFlag" , "true");
				
			}else{
				
				//$("#id_menu_tab_top1").show();
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
			location.reload();
	    });
		$("#id_menu_delete").click(function(e){
			e.preventDefault();
			if(!confirm("delete??")){
				return false;
			}			
			$('tr.class_menu_main_view').each(function(){
				if($(this).find("input:eq(0)").is(":checked")){
					$(this).attr("isdeleted", "Y");
					menuSave();
				}
			})
			location.reload();						
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
		
		$("#point-page .class_category_area > li").click(function(e){
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
		
		$("#id_cate_up").click(function(e){		
			e.preventDefault();	
			if($("#id_cate_main_1").hasClass("on")){
				$("#id_cate_main_1").parent().prev("li").before($("#id_cate_main_1").parent());
			}else if($("#id_cate_main_2").hasClass("on")){
				$("#id_cate_main_2").parent().prev("li").before($("#id_cate_main_2").parent());
			}else if($("#id_cate_main_3").hasClass("on")){
				$("#id_cate_main_3").parent().prev("li").before($("#id_cate_main_3").parent());
			}
	    });	
		
		$("#id_cate_down").click(function(e){
			//var index = $(".class_cate_index > ul > li").index(this);
			//$("#order-page .class-category-area > li:eq(" + index + ")");
			//alert(index);
			e.preventDefault();	
			if($("#id_cate_main_1").hasClass("on")){
			   $("#id_cate_main_1").parent().next("li").after($("#id_cate_main_1").parent());
			   //$("li:eq(" + index + ")").attr("sortorder", index);
			}else if($("#id_cate_main_2").hasClass("on")){
				 $("#id_cate_main_2").parent().next("li").after($("#id_cate_main_2").parent());
				 //$("li:eq(" + index + ")").attr("sortorder", index);
			}else if($("#id_cate_main_3").hasClass("on")){
				$("#id_cate_main_3").parent().next("li").after($("#id_cate_main_3").parent());
				// $("li:eq(" + index + ")").attr("sortorder", index);
			}
	    });	
		
		$('a[id^=id_cate_main_]').click(function(){
			if($("#id_cate_main_1").is(":focus")){
				$('a[id^=id_cate_main_]').removeClass("on");
				$('#id_cate_main_1').addClass("on");			
			}else if($("#id_cate_main_2").is(":focus")){
				$('a[id^=id_cate_main_]').removeClass("on");
				$('#id_cate_main_2').addClass("on");
			}else if($("#id_cate_main_3").is(":focus")){
				$('a[id^=id_cate_main_]').removeClass("on");
				$('#id_cate_main_3').addClass("on");
			}else if($("#id_cate_main_5").is(":focus")){
				$('a[id^=id_cate_main_]').removeClass("on");
				$('#id_cate_main_5').addClass("on");
			}else if($("#id_cate_main_6").is(":focus")){
				$('a[id^=id_cate_main_]').removeClass("on");
				$('#id_cate_main_6').addClass("on");
			}
		})	
		
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
						"<td class=\"class_menu_storeprice\">" + "<input type=\"text\" data-role=\"none\" />" + "</td>" +
						"<td class=\"class_menu_deliveryprice\">" + "<input type=\"text\" data-role=\"none\" />" + "</td>" +
						"<td class=\"class_menu_takeoutprice\">" + "<input type=\"text\" data-role=\"none\" />" + "</td>" +
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
		
		$(".class_menu_pop").change(function(){
			var etccateid= $(this).attr("etccateid");
			var url = '/pos/category/categoryMenuManage.do?categoryid=' + etccateid ;
			
			if($("input[name=otherL]:checked").val() == 5){	
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
				//$("#id_etc_menu_close").click();
			}else if($("input[name=otherL]:checked").val() == 6){	
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
				//$("#id_etc_menu_close").click();
			}else if($("input[name=otherL]:checked").val() == 7){
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
				//$("#id_etc_menu_close").click();
			}else if($("input[name=otherL]:checked").val() == 8){
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
				//$("#id_etc_menu_close").click();
			}else if($("input[name=otherL]:checked").val() == 9){
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
				//$("#id_etc_menu_close").click();
			}		
		});
		$(".class_point_pop").change(function(){
			var etcpointid= $(this).attr("etcpointid");
			var url = '/pos/category/categoryPointManage.do?categoryid=' + etcpointid ;
			
			if($("input[name=otherL_point]:checked").val() == 5){	
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
				//$("#id_etc_menu_close").click();
			}else if($("input[name=otherL_point]:checked").val() == 6){	
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
				//$("#id_etc_menu_close").click();
			}else if($("input[name=otherL_point]:checked").val() == 7){
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
				//$("#id_etc_menu_close").click();
			}else if($("input[name=otherL_point]:checked").val() == 8){
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
				//$("#id_etc_menu_close").click();
			}else if($("input[name=otherL_point]:checked").val() == 9){
				$(parent.location).attr('href',url);
				window.opener.parent.location.reload();
				//$("#id_etc_menu_close").click();
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
		
	}
	
	function updateCate(sortorder,name,categoryid){
		
		if(!confirm("저장하시겠습니까?")){
			return false;
		}
		
		 $(".class_cate").each(function() {
			 var name = $(this).val();
			 
			 if(name){			 
				  name = $(this).val();
			 }else {
				  name = $(this).attr('catename');
			 }
			 var sortorder = $(this).attr('sortorder');
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
						//console.log(data);					
					}
					
					if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
						$("#id_cate_save").click();		
					} else{
						//alert(data.returnJsonVO.message);
					}
				}
			 });	
		});	
	}

	function updateShortMenu(){
		
		if(!confirm("저장하시겠습니까?")){
			return false;
		}
		menuSave();			
		
	}
	function menuSave(){
		$("tr.class_menu_main_view").each(function() {			 
			
			 var catemenuname = $(this).attr('catemenuname');
			 var catemenuname2 = $(this).find("input:eq(1)").val();
			 
			 if(catemenuname != catemenuname2){
				 catemenuname = catemenuname2;
			 }else {
				 catemenuname;
			 }			
			 //var catemenuname = $(this).attr('catemenuname');
			 var sortorder = $(this).attr('sortorder');
			 var categoryid = $(this).attr('categoryid');			 
			 //var menuid = $(this).attr('menuid');
			 var menuid = ($(this).attr("menuid") || "").startsWith("temp_") ? "" : $(this).attr("menuid");
			 var memberid = $(this).attr('memberid');
			
			 var storeprice = $(this).attr('storeprice');
			 var storeprice2 = $(this).find("input:eq(2)").val();
			 
			 if(storeprice != storeprice2){			 
				 storeprice = storeprice2;
			 }else {
				 storeprice;
			 }
			 /*var storeprice = $(this).attr('storeprice');
			 if(storeprice == "" || storeprice == "undefined"){
			     storeprice =  defaultprice2;
			 }else{
				 var storeprice2 = $(this).find("input:eq(3)").val();
				 if(storeprice != storeprice2){	
					 storeprice = storeprice2;
				 }else {
					 storeprice;
				 }
			 }*/
			
			 var deliveryprice = $(this).attr('deliveryprice');
			 if(deliveryprice == "" || deliveryprice == "undefined"){
				 deliveryprice = storeprice;
			 }else{
				 deliveryprice = $(this).attr('deliveryprice');
				 var deliveryprice2 = $(this).find("input:eq(3)").val();
				 if(deliveryprice != deliveryprice2){	
					 deliveryprice = deliveryprice2;
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
					 takeoutprice = takeoutprice2;
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
			 
			// var defaultprice = $(this).attr('defaultprice');			 
			 var param ="sortorder=" + sortorder + "&name=" + catemenuname+ "&categoryid=" + categoryid + "&menuid=" + menuid + "&memberid=" + memberid + 
			 "&storeprice=" + storeprice + "&deliveryprice=" + deliveryprice + "&takeoutprice=" + takeoutprice + "&ishidden=" + ishidden + "&isdeleted=" + isdeleted + "&menuFlag=" + menuFlag;
			 alert(param);
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
						//console.log(data);					
					}
					
					if(data.returnJsonVO && data.returnJsonVO.returnVal == "1"){
						$("#id_cate_save").click();		
					} else{
						//alert(data.returnJsonVO.message);
					}
				}
			 });	
		});	
	}
	
    /*function updateLongMenu(){
		
		if(!confirm("저장하시겠습니까?")){
			return false;
		}
		
		$("tr.class_menu_main_view").each(function() {			 
			
			 var catemenuname = $(this).attr('catemenuname');
			 var catemenuname2 = $(this).find("input:eq(1)").val();
			 
			 if(catemenuname != catemenuname2){
				 catemenuname = catemenuname2;
			 }else {
				 catemenuname;
			 }			
			 //var catemenuname = $(this).attr('catemenuname');
			 var sortorder = $(this).attr('sortorder');
			 var categoryid = $(this).attr('categoryid');			 
			 var menuid = $(this).attr('menuid');
			 var memberid = $(this).attr('memberid');				
			 var defaultprice = $(this).attr('defaultprice');
			 
			 var storeprice = $(this).attr('storeprice');
			 var storeprice2 = $(this).find("input:eq(3)").val();
			 if(storeprice != storeprice2){	
				 storeprice = storeprice2;
			 }else {
				 storeprice;
			 }
			 var deliveryprice = $(this).attr('deliveryprice');
			 var deliveryprice2 = $(this).find("input:eq(4)").val();
			 if(deliveryprice != deliveryprice2){			 
				 deliveryprice = deliveryprice2;
			 }else {
				 deliveryprice;
			 }
			 var takeoutprice = $(this).attr('takeoutprice');
			 var takeoutprice2 = $(this).find("input:eq(5)").val();
			 if(takeoutprice != takeoutprice2){			 
				 takeoutprice = takeoutprice2;
			 }else {
				 takeoutprice;
			 }
			// var defaultprice = $(this).attr('defaultprice');			 
			 var param ="sortorder=" + sortorder + "&name=" + catemenuname+ "&categoryid=" + categoryid + "&menuid=" + menuid + "&memberid=" + memberid + "&defaultprice=" + defaultprice + "&storeprice=" + storeprice +"&deliveryprice=" + deliveryprice + "&takeoutprice=" + takeoutprice;
			 				 
			 //var url = "MenuInsertOk.json";
			 var url = "MenuUpdatetOk.json";			
				
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
						$("#id_cate_save").click();		
					} else{
						//alert(data.returnJsonVO.message);
					}
				}
			 });	
		});		
		
	}*/
	
	return {
		init: function() {
			eventReg();			

		}
	}   
})();

