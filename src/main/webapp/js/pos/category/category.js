$(document).ready(function() {	
	
	var name;
	var categoryid;
	var sortorder;
	
	$("#id_cate_save").click(function(e){		
			e.preventDefault();			
			updateCate(sortorder,name,categoryid);
			location.reload();
	});	
	
	$("#id_menu_save").click(function(e){		
		e.preventDefault();			
		insertMenu();
		//location.reload();
    });	
	
	$("#menu-page .class_category_area > li").click(function(e){
		e.preventDefault();
		alert('11111');
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
		}else if($("#id_cate_main_4").is(":focus")){
			$('a[id^=id_cate_main_]').removeClass("on");
			$('#id_cate_main_4').addClass("on");
		}else if($("#id_cate_main_5").is(":focus")){
			$('a[id^=id_cate_main_]').removeClass("on");
			$('#id_cate_main_5').addClass("on");
		}
	})	
	
	$(".class_menu_check").change(function(e){
		e.preventDefault();			
		
		if($(this).is(":checked")) {
			$("#id_long_menu").show();
			$("#id_short_menu").hide();
		}else{
			$("#id_long_menu").hide();
			$("#id_short_menu").show();
		}
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
		
		var data = "<tr>" + 
					"<td><label>" + "<input type=\"checkbox\"/>" + "</label></td>" +
					"<td>" + "<input type=\"text\" data-role=\"none\" />" + "</td>" +
					"<td>" + "<input type=\"text\" data-role=\"none\" />" + "</td>" +
					"<td><label>" + "<input type=\"checkbox\" />" + "</label></td>" +
				     "</tr>"
					
		var data1 = "<tr>" + 
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
		if($("input[name=otherL]:checked").val() == 1){	
			$(parent.location).attr('href','/pos/category/categoryMenuManage.do?categoryid=6');
			window.opener.parent.location.reload();
			//$("#id_etc_menu_close").click();
		}else if($("input[name=otherL]:checked").val() == 2){	
			$(parent.location).attr('href','/pos/category/categoryMenuManage.do?categoryid=7');
			window.opener.parent.location.reload();
			//$("#id_etc_menu_close").click();
		}else if($("input[name=otherL]:checked").val() == 3){
			$(parent.location).attr('href','/pos/category/categoryMenuManage.do?categoryid=8');
			window.opener.parent.location.reload();
			//$("#id_etc_menu_close").click();
		}else if($("input[name=otherL]:checked").val() == 4){
			$(parent.location).attr('href','/pos/category/categoryMenuManage.do?categoryid=9');
			window.opener.parent.location.reload();
			//$("#id_etc_menu_close").click();
		}else if($("input[name=otherL]:checked").val() == 5){
			$(parent.location).attr('href','/pos/category/categoryMenuManage.do?categoryid=10');
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
});

function updateCate(sortorder,name,categoryid){
	
	if(!confirm("저장하시겠습니까?")){
		return false;
	}
	
	 $(".class_cate").each(function() {
		 
		 var name = $(this).val();
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

function insertMenu(){
	
	if(!confirm("저장하시겠습니까?")){
		return false;
	}
	
	$(".class_menu_main").each(function() {
		 var name = $('.class_menu_main input').eq(1).val();
		 var sortorder = $(this).attr('sortorder');
		 var categoryid = $(this).attr('categoryid');
		 var storeprice = $('.class_menu_main input').eq(2).val();
		 
		 var param ="sortorder=" + sortorder + "&name=" + name+ "&categoryid=" + categoryid + "&storeprice=" + storeprice;
		 	
		 alert(param);
		 
		 var url = "MenuInsertOk.json";
			
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
	
	/* $(".class_cate").each(function() {
		 
		 var name = $(this).val();
		 var sortorder = $(this).attr('sortorder');
		 var categoryid = $(this).attr('categoryid');
		 var memberid = $(this).attr('memberid');
		 var deviceid = $(this).attr('deviceid');
		 
		 var param ="sortorder=" + sortorder + "&name=" + name+ "&categoryid=" + categoryid + "&memberid=" + memberid + "&deviceid=" + deviceid;		 
		 var url = "MenuInsertOk.json";
			
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
	});*/	
}