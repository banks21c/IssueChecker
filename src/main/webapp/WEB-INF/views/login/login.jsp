<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>로그인</title>
		<link rel="stylesheet" href="../../css/icon.css">
		<link rel="stylesheet" href="../../css/login.css">
		
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script>var console = (window.console = window.console || {});</script>
		<script>
		$(document).ready(function(){
			$(".class-event-login-apply").click(function(e){
				e.preventDefault();
				login();
			});
			$("#loginId").keydown(function(e){
				if(event.keyCode == 13){
					e.preventDefault();
					console.log(event.keyCode);
					login();
				}
			});
			
			login = function (){
				if(!$.trim($("input[name='loginId']").val())){
					alert("로그인ID를 입력해 주세요.");
					return false;
				}

				var url = "login.json";
				var param = "loginId=" + $.trim($("input[name='loginId']").val()) ;
				console.log("param: " + param);
				$.ajax({
					url: url,
					type: 'post',
					data: param,
					dataType: "json",
					error:function (xhr, ajaxOptions, thrownError){
						
						alert("error:"+thrownError);
					},
					success:function(data){
						console.log("data:"+data);					
						
						if(data.returnJsonVO){
							
							if(data.returnJsonVO.returnObj == "0"){
								alert(data.returnJsonVO.message);
							} else if(data.returnJsonVO.returnObj == "1"){

								//alert("로그인되었습니다.");
								
								var forwardUrl = $("input[name=forwardUrl]").val() || "";
								if(forwardUrl){
									document.location.href=forwardUrl;
								} else {
									document.location.href="/issue/issueList.do";
								}
								
														
							}
						} 
						
					}
				});	
				
				return false;					
			}
			
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
		
<script type="text/javascript">
	$(function() {
		$("input[type=text]").bind('focus blur',function(){$(this).toggleClass('focus')});
	});
</script>

		
		
	</head>
	<body>
		
<div class="login_wrap">
	<h1 style="text-align:center">로그인</h1>
	<div class="">
		<form method="post" action="">
			<fieldset>
				<span><input type="text" name="loginId" id="loginId"  value="" /></span>
				<button type="submit" class="class-event-login-apply"><i class="fa fa-lock"></i> Login</button>
			</fieldset>
		</form>
	</div>
</div>
		
	</body>
</html>