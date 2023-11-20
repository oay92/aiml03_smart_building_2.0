<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${webName}</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
		
		<style><%@include file="/WEB-INF/css/default.css"%></style>
		
		<script><%@include file="/WEB-INF/js/index.js"%></script>			
	</head>
	<body>
		<form name="myForm" action="${root}/Index.do" method="post">
		
  			<header class="p-3 bg-dark text-white">
    			<div class="container">		
					<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
						<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
							<li><a class="nav-link px-2 text-white">Smart Building</a></li>
						</ul>
				        <div class="text-end">
				        	<button type="button" class="btn btn-outline-light me-2" onclick="submitForm('user')">User Login</button>
				          	<button type="button" class="btn btn-outline-light me-2" onclick="submitForm('admin')">Admin Login</button>
				        </div>
					</div>
				</div>
			</header>
		
			<br><br>
			<h1 style="text-align:center">Smart Buildings</h1>

			
			<input type="hidden" name="accountLevel" id="accountLevel">
		</form>		
	</body>
</html>