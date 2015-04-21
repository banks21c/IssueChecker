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
	var categoryid;
	var sortorder;
	var catemenuname;
	 var defaultprice;
	
    function eventReg(){    	
    	
		$("#id_cate_save").click(function(e){		
			e.preventDefault();			
			updateCate(sortorder,name,categoryid);
			location.reload();
		});	
		$(".class_menu_check").change(function(e){
			e.preventDefault();			
			
			if($(this).is(":checked")) {
				$("#id_long_menu").show();
				$("#id_short_menu").hide();
				$("#id_menu_save").addClass("class_long_save").removeClass("class_short_save");
			}else{
				$("#id_long_menu").hide();
				$("#id_short_menu").show();
				$("#id_menu_save").addClass("class_short_save").removeClass("class_long_save");
			}
		})
		$(".class_menu_save").click(function(e){
			e.preventDefault();
			if($(".class_menu_check").is(":checked")){
				updateLongMenu();
			}else{
				updateShortMenu();
			}			
			location.reload();
	    });
		$("#id_menu_delete").click(function(e){
			e.preventDefault();
			$(this).remove();			
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
				
			
		$('tr.class_short_menu_main').find("input:eq(0)").change(function(e){
			e.preventDefault();				
			
		})
		
		$(".class_point_check").change(function(e){
			e.preventDefault();			
			
			if($(this).is(":checked")) {
				$("#id_long_point_menu").show();
				$("#id_short_point_menu").hide();
				$("#id_check_point_dc").show();
				
			}else{
				$("#id_long_point_menu").hide();
				$("#id_short_point_menu").show();
				$("#id_check_point_dc").hide();
			}
		})
		
		$("#id_menu_add_row").click(function(){
			var memberid = $("tr.class_short_menu_main").attr('memberid');
			var deviceid = $("tr.class_short_menu_main").attr('deviceid');
			var categoryid = $("tr.class_short_menu_main").attr('categoryid');
			var sortorder = parseInt($("tr.class_short_menu_main").last().attr('sortorder')) + 1;
			var menuid = 'temp_' + new Date().getTime();
			
			var data = "<tr class=\"class_short_menu_main class_menu_main_delete\" memberid=\""+ memberid +"\" deviceid=\""+ deviceid +"\" sortorder=\""+ sortorder +"\" menuid=\""+ menuid +"\" categoryid=\""+categoryid +"\" >" + 
						"<td><label>" + "<input type=\"checkbox\"/>" + "</label></td>" +
						"<td>" + "<input type=\"text\" data-role=\"none\" />" + "</td>" +
						"<td>" + "<input type=\"text\" data-role=\"none\" />" + "</td>" +
						"<td><label>" + "<input type=\"checkbox\" />" + "</label></td>" +
					     "</tr>"
						
			var data1 = "<tr class=\"class_long_menu_main class_menu_main_delete\" memberid=\""+ memberid +"\" deviceid=\""+ deviceid +"\" sortorder=\""+ sortorder +"\" menuid=\""+ menuid +"\" categoryid=\""+categoryid +"\" >" + 
						"<td><label>" + "<input type=\"checkbox\"/>" + "</label></td>" +
						"<td>" + "<input type=\"text\" data-role=\"none\" />" + "</td>" +
						"<td>" + "<input type=\"text\" data-role=\"none\" />" + "</td>" +
						"<td>" + "<input type=\"text\" data-role=\"none\" />" + "</td>" +
						"<td>" + "<input type=\"text\" data-role=\"none\" />" + "</td>" +
						"<td><label>" + "<input type=\"checkbox\" />" + "</label></td>" +
					     "</tr>"
			
			$("#id_tbodylist > tbody:last").append(data);
			$("#id_tbodylist2 > tbody:last").append(data1);
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
			if($("#po_otherL_01").is(":checked")){	
				$(parent.location).attr('href','/pos/category/categoryPointManage.do?categoryid=6');
				window.opener.parent.location.reload();
				$("#id_etc_point_close").click();
			}else if($("#po_otherL_02").is(":checked")){			
				$(parent.location).attr('href','/pos/category/categoryPointManage.do?categoryid=7');
				window.opener.parent.location.reload();
				$("#id_etc_point_close").click();
			}else if($("#po_otherL_03").is(":checked")){
				$(parent.location).attr('href','/pos/category/categoryPointManage.do?categoryid=8');
				window.opener.parent.location.reload();
				$("#id_etc_point_close").click();
			}else if($("#po_otherL_04").is(":checked")){
				$(parent.location).attr('href','/pos/category/categoryPointManage.do?categoryid=9');
				window.opener.parent.location.reload();
				$("#id_etc_point_close").click();
			}else{
				$(parent.location).attr('href','/pos/category/categoryPointManage.do?categoryid=10');
				window.opener.parent.location.reload();
				$("#id_etc_point_close").click();
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
		
		$("tr.class_short_menu_main").each(function() {			 
			
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
			
			 var defaultprice = $(this).attr('defaultprice');
			 var defaultprice2 = $(this).find("input:eq(2)").val();
			 
			 if(defaultprice != defaultprice2){			 
				 defaultprice = defaultprice2;
			 }else {
				 defaultprice;
			 }
			 var storeprice = defaultprice;			 
			 var deliveryprice = defaultprice;			 
			 var takeoutprice = defaultprice;			
			// var defaultprice = $(this).attr('defaultprice');			 
			 var param ="sortorder=" + sortorder + "&name=" + catemenuname+ "&categoryid=" + categoryid + "&menuid=" + menuid + "&memberid=" + memberid + "&defaultprice=" + defaultprice + "&storeprice=" + storeprice + "&deliveryprice=" + deliveryprice + "&takeoutprice=" + takeoutprice;
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
	
    function updateLongMenu(){
		
		if(!confirm("저장하시겠습니까?")){
			return false;
		}
		
		$("tr.class_long_menu_main").each(function() {			 
			
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
			 var storeprice2 = $(this).find("input:eq(2)").val();
			 if(storeprice != storeprice2){			 
				 storeprice = storeprice2;
			 }else {
				 storeprice;
			 }	
			 var deliveryprice = $(this).attr('deliveryprice');
			 var deliveryprice2 = $(this).find("input:eq(3)").val();
			 if(deliveryprice != deliveryprice2){			 
				 deliveryprice = deliveryprice2;
			 }else {
				 deliveryprice;
			 }
			 var takeoutprice = $(this).attr('takeoutprice');
			 var takeoutprice2 = $(this).find("input:eq(4)").val();
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
		
	}
	
	return {
		init: function() {
			eventReg();			

		}
	}   
})();

