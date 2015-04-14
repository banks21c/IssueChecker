<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>로그인</title>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script>
		$(document).ready(function(){
			$(".class-event-login-apply").click(function(e){
				e.preventDefault();
				
				if(!$.trim($("input[name='businessNumber']").val())){
					alert("사업자번호를 입력해 주세요.");
					return false;
				}
				if(!$.trim($("input[name='businessNumber']").length != 10)){
					alert("사업자번호는 10자리입니다.");
					return false;
				}				
				var url = "loginOk.json";
				var param = "businessNumber=" + $.trim($("input[name='businessNumber']").val()) ;
				if(typeof console != 'undefined'){
					console.log("param: " + param);
				}
				$.ajax({
					url: url,
					type: 'post',
					data: param,
					dataType: "json",
					error:function (xhr, ajaxOptions, thrownError){
						
						alert(thrownError);
					},
					success:function(data){
						if(typeof console != 'undefined'){		
							console.log(data);					
						}
						
						if(data.returnJsonVO){
							
							if(data.returnJsonVO.returnObj == "0"){
								alert(data.returnJsonVO.message);
							} else if(data.returnJsonVO.returnObj == "1"){

								alert("로그인되었습니다.");
								
								var forwardUrl = $("input[name=forwardUrl]").val() || "";
								if(forwardUrl){
									document.location.href=forwardUrl;
								} else {
									document.location.href="/pos/main/posMain.do";
								}
								
														
							}
						} 
						
					}
				});	
				
				return false;					
			});
			
			$(".class-event-logout-apply").click(function(e){
				e.preventDefault();
				
				var url = "logout.json";
				$.ajax({
					url: url,
					type: 'post',
					dataType: "json",
					error:function (xhr, ajaxOptions, thrownError){
						
						alert(thrownError);
					},
					success:function(data){
						if(typeof console != 'undefined'){		
							console.log(data);					
						}
						
						if(data.returnJsonVO){
							
							if(data.returnJsonVO.returnObj == "0"){
								alert(data.returnJsonVO.message);
							} else if(data.returnJsonVO.returnObj == "1"){

								alert("로그아웃 되었습니다.");
								
								
								
														
							}
						} 
						
					}
				});					
			});
		});
		</script>
	</head>
	<body>
		<form name="loginForm" method="post">
		<input name="businessNumber" value="1234567890"/>
		<input type="button" value="로그인" class="class-event-login-apply"/>
		</form>
		<br/><br/>
		<input type="button" class="class-event-logout-apply" value="로그아웃"/>
	</body>
</html>