if(!window.bapdosa.tableNameChange) window.bapdosa.tableNameChange = {};
$(document).ready(function(){	
	
	window.bapdosa.tableNameChange.init();

});

window.bapdosa.tableNameChange = (function() {	
	
	function eventReg(){
		
		$(".class_table_name_change_save").click(function(e){
			e.preventDefault();	
			tableNameChangeSave();
			setTimeout(function () { 
			      location.reload();
			    }, 500);
		});	
	}
	
	function getTableNameList(){
		var dfd = new jQuery.Deferred();
		var menuBody = $(".class_table_name_change_main");
		    menuBody.empty();
		
		var url="/pos/setting/getOrderTableList.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;			
			
			tableInfoList = returnObj.orderMapList;
			console.log("tableInfoList=" + tableInfoList);
			
			$(tableInfoList).each(function(index,obj){
				
				var li = $("<li>",{						
					memberId : obj.MEMBERID,
					deviceId : obj.DEVICEID,
					tableId : obj.TABLEID,
					tableNo : obj.TABLENO,
					tableName : obj.TABLENAME,
					linkedTableId : obj.LINKEDTABLEID,
					isDeleted : obj.ISDELETED
				}).append($("<a>").text(obj.TABLENAME));
								  
				menuBody.append(li);				
			});
					
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
	function getTableNameChangeList(){
		var dfd = new jQuery.Deferred();
		var menuBody = $(".class_table_name_change_sub");
		    menuBody.empty();
		
		var url="/pos/setting/getOrderTableList.json";
		var param="";
		var success = function(returnJsonVO){
			var returnObj = returnJsonVO.returnObj;			
			
			tableInfoList = returnObj.orderMapList;
			console.log("tableInfoList=" + tableInfoList);
			
			$(tableInfoList).each(function(index,obj){
				
				var li = $("<li>",{						
					memberId : obj.MEMBERID,
					deviceId : obj.DEVICEID,
					tableId : obj.TABLEID,
					tableNo : obj.TABLENO,
					tableName : obj.TABLENAME,
					linkedTableId : obj.LINKEDTABLEID,
					isDeleted : obj.ISDELETED
				}).addClass("class_table_name_change_input").append($("<span>").append($("<input>").attr("type" ,"text").attr("maxlength" ,4).attr("data-role" ,"none")));
								  
				menuBody.append(li);				
			});
					
			dfd.resolve( "complete.." );
		};

		commonAjaxCall(url, param, success);	
		 return dfd.promise();
	}
	function tableNameChangeSave(){
		 if(!confirm("저장하시겠습니까?")){
			 return false;
		 }
		 
		 $(".class_table_name_change_input").each(function(index ) {
			 
			 var tableId = $(this).attr("tableId");
			 var tableName1 = $(this).attr("tableName");
			 var tableName2 = $(this).find("input").val();
			 var tableName;
			 
			 if(tableName2){
				 tableName = tableName2;
			 }else{
				 tableName = tableName1;
			 }
			 
			 var param = "tableName=" + tableName + "&tableId=" + tableId;
			 var url = "tableNameUpdateOk.json";
				
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
			getTableNameList();
			getTableNameChangeList();
		}
	}   
})();

