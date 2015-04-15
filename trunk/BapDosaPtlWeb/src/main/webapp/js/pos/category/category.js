$(document).ready(function() {	
	
	var name;
	var categoryid;
	var sortorder;	
	
	$("#id_cate_save").click(function(e){		
			e.preventDefault();			
			updateCate(sortorder,name,categoryid);
	});	
	
	/*$("#id_menu_sub1").click(function(e){
		alert('1');
		e.preventDefault();
		
		$("#id_menu_sub2,#id_menu_sub3,#id_menu_sub4,#id_menu_sub5").removeClass("on");
		$(".class_menu_tab_top").text("요리류 메뉴");
		$(location).attr('href','/pos/category/categoryMenuManage.do?categoryid=1');
		$("#id_menu_sub1").addClass("on");
		
    });
	$("#id_menu_sub2").click(function(e){
		alert('2');
		e.preventDefault();
		
		$("#id_menu_sub1").removeClass("on");
		$(".class_menu_tab_top").text("식사류 메뉴");
		$(location).attr('href','/pos/category/categoryMenuManage.do?categoryid=2');
		$("#id_menu_sub2").addClass("on");
    });
	$("#id_menu_sub3").click(function(e){	
		alert('3');
		e.preventDefault();			
		
		$("#id_menu_sub1,#id_menu_sub2,#id_menu_sub4,#id_menu_sub5").removeClass("on");
		$(".class_menu_tab_top").text("주류 메뉴");
		$(location).attr('href','/pos/category/categoryMenuManage.do?categoryid=3');
		$("#id_menu_sub3").addClass("on");
    });
	$("#id_menu_sub4").click(function(e){		
		e.preventDefault();			
		
		$("#id_menu_sub1,#id_menu_sub2,#id_menu_sub3,#id_menu_sub5").removeClass("on");
		$(".class_menu_tab_top").text("음료류 메뉴");
		$(location).attr('href','/pos/category/categoryMenuManage.do?categoryid=4');
		$("#id_menu_sub4").addClass("on");
    });
	$("#id_menu_sub5").click(function(e){		
		e.preventDefault();			
		
		$("#id_menu_sub1,#id_menu_sub2,#id_menu_sub3,#id_menu_sub4").removeClass("on");
		$(".class_menu_tab_top").text("기타 메뉴");
		$("#id_menu_sub5").addClass("on");
		//$(location).attr('href','/pos/category/categoryMenuManage.do?categoryid=5');
    });*/
	
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
		alert('1');
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
	
	if(!confirm("save?")){
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
	location.reload();
}