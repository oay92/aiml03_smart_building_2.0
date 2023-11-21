<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${webName}</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
		
		<style><%@include file="/WEB-INF/css/default.css"%></style>
		
		<script>
		function submitForm(page)
		{        
			document.getElementById("myPage").value = page;
			document.forms["myForm"].submit();				
		}
		</script>
	</head>
	<body>
		<jsp:include page="${component}/simpleHeader.jsp"></jsp:include>
		<br><br>
		<form name="myForm" action="${root}/User.do" method="post">		
			<div style="margin:auto; width:50%">
				<div class="row">
					<!-- Column 1-1 -->	
					<div class="col-sm-6">
						<div class="card">
					    	<div class="card-body">
					    		<div><img src="/SmartBuilding/img/profile.jpg" style="object-fit:cover;width:100%;opacity: 1;"></div>
					        	<div>
									<h3 class="card-title" style="top:80px;left:22px;position:absolute;color:#0D6EFD;"></h3>
									<br>	
					        		<a href="#" class="btn btn-primary" style="width:100%" onClick="submitForm('profile')">Profile</a>			        	
					        	</div>					        	
							</div>
						</div>
					</div>
				  
				  	<!-- Column 1-2 -->
					<div class="col-sm-6">
						<div class="card">
							<div class="card-body">
								<div><img src="/SmartBuilding/img/lobby.jpg" style="object-fit:cover;width:100%;opacity: 1;"></div>
								<div>
									<h3 class="card-title" style="top:80px;left:32px;position:absolute;color:#0D6EFD;"></h3>
									<br>	
									<a href="#" class="btn btn-primary" style="width:100%" onClick="submitForm('lobby')">Lobby Access Timestamp</a>
								</div>
							</div>
						</div>
					</div>
					<!-- Column 2-1 -->
					<div class="col-sm-6">
						<div class="card">
							<div class="card-body">
								<div><img src="/SmartBuilding/img/parking.jpg" style="object-fit:cover;width:100%;opacity: 1;"></div>
								<div>
									<div style="top:100px;left:28px;position:absolute;color:#FFFFED;font-size:22px"></div>
									<br>
									<a href="#" class="btn btn-primary" style="width:100%" onClick="submitForm('parking-lot')">Parking Lot Access Timestamp</a>
								</div>								
							</div>
						</div>
					</div>
					<!-- Column 2-2 -->
					<div class="col-sm-6">
						<div class="card">
							<div class="card-body">
								<div><img src="/SmartBuilding/img/chat.jpg" style="object-fit:cover;width:100%;opacity: 1;"></div>
								<div>
									<div style="top:100px;left:28px;position:absolute;color:#FFFFED;font-size:22px"></div>
									<br>
									<a href="#" class="btn btn-primary" style="width:100%" onClick="submitForm('chat')">Live Chat</a>
								</div>									
							</div>
						</div>
					</div>							  
				</div>
			</div>		
		
			<input type="hidden" name="myPage" id="myPage">
		</form>
		
		<br><br>
		<jsp:include page="${component}/footer.jsp"></jsp:include>	
	</body>
</html>