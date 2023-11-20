<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${webName}</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
		
		<style><%@include file="/WEB-INF/css/default.css"%></style>	
		
		<script>
		function submitForm()
		{        
			document.forms["myForm"].submit();				
		}		
		</script>	
	</head>
	<body>
		<jsp:include page="${component}/adminHeader.jsp"></jsp:include>
		<br><br>
		<form name="myForm" action="${root}/userRegister" method="post">
			<div style="width:40%;margin:auto">
				<div class="row">
					<div class="col"><p class="page-title">Building &amp; Unit</p></div>
				</div>
				
				<!-- Building Number -->
				<div class="row">
					<div class="col"><label for="buildingNum" class="form-label">Building #:</label><span style="color:red;margin-left:20px" id="error1"></span></div>					
				</div>
				<div class="row">
					<div class="col">
						<select name="buildingNum" id="buildingNum" class="form-select form-select-lg mb-3">
							<option value=""></option>
							<option value="A">Building A</option>
							<option value="B">Building B</option>
							<option value="C">Building C</option>
						</select> 					
					</div>
				</div>
				
				<!-- Unit Number -->
				<div class="row">
					<div class="col"><label for="unitNum" class="form-label">Unit #:</label><span style="color:red;margin-left:20px" id="error2"></span></div>					
				</div>
				<div class="row">
					<input type="text" class="form-control" name="unitNum" id="unitNum" onkeypress="if (event.keyCode == 13) submitForm()">				
				</div>	
				<br>
				<!-- Submit Button -->
				<div class="row">
					<div class="col" style="text-align:right"><button type="button" class="btn btn-primary" style="width:100px" onclick="submitForm()">Submit</button></div>
				</div>	
			</div>
		</form>
	</body>
</html>