<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${webName}</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
		
		<style><%@include file="/WEB-INF/css/default.css"%></style>
		
		<script><%@include file="/WEB-INF/js/admin.js"%></script>		
	</head>
	<body>
		<jsp:include page="${component}/header.jsp"></jsp:include>
		<br><br>
		<form name="myForm" action="${root}/Admin.do" method="post">		
			<div style="margin:auto; width:70%">
				<div class="row">
					<!-- Column 1 -->	
					<div class="col-sm-3">
						<div class="card">
					    	<div class="card-body">
					        	<h5 class="card-title">Account Registration</h5>
					        	<p class="card-text"><br><br></p>
					        	<a href="#" class="btn btn-primary" style="width:100px" onClick="submitForm('account')">Go</a>
							</div>
						</div>
					</div>
				  
				  	<!-- Column 2 -->
					<div class="col-sm-3">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Person Registration</h5>
								<p class="card-text"><br><br></p>
								<a href="#" class="btn btn-primary" style="width:100px" onClick="submitForm('person')">Go</a>
							</div>
						</div>
					</div>
					<!-- Column 3 -->
					<div class="col-sm-3">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">License Plate Registration</h5>
								<p class="card-text"><br><br></p>
								<a href="#" class="btn btn-primary" style="width:100px" onClick="submitForm('plate')">Go</a>
							</div>
						</div>
					</div>
					<!-- Column 4 -->
					<div class="col-sm-3">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Search</h5>
								<p class="card-text"><br><br></p>
								<a href="#" class="btn btn-primary" style="width:100px" onClick="submitForm('search')">Go</a>
							</div>
						</div>
					</div>							  
				</div>
			</div>		
		
			<input type="hidden" name="myPage" id="myPage">
		</form>
	</body>
</html>