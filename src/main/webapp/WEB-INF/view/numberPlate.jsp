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
		function submitForm()
		{        
			resetErrorMessage()
			
			var number_plate = document.getElementById("numberPlate").value
			
			var error = false
			if (number_plate == "")
			{
				document.getElementById('error1').innerHTML = "this field is required"
				error = true
			}
			
			if (!error)
			{
				document.forms["myForm"].submit();	
			}
		}
		
		function resetErrorMessage()
		{
			document.getElementById('error1').innerHTML = ""	
		}	
		
		function upperCase()
		{
			document.getElementById("numberPlate").value = document.getElementById("numberPlate").value.toUpperCase()
		}
		</script>	
	</head>
	<body>
		<jsp:include page="${component}/simpleHeader.jsp"></jsp:include>
		<br><br>
		<form name="myForm" action="${root}/addNumberPlate.do" method="post">
			<div style="margin:auto;min-height:100vh;width:40%">
				<div class="row">
					<div class="col"><p class="page-title">License Plate</p></div>
				</div>
				
				<!-- Building Number -->
				<div class="row default-height">
					<div class="col">Building #:<span style="margin-left:10px;color:#0000FF">${buildingNum}</span></div>
				</div>
				
				<!-- Unit Number -->
				<div class="row default-height">
					<div class="col">Unit #:<span style="margin-left:10px;color:#0000FF">${unitNum}</span></div>
				</div>
				
				<!-- License Plate -->
				<div class="row">
					<div class="col"><label for="numberPlate" class="form-label">License Plate:</label><span style="color:red;margin-left:20px" id="error1"></span></div>
				</div>
				<div class="row">
					<div class="col"><input type="text" class="form-control" name="numberPlate" id="numberPlate" onkeypress="if (event.keyCode == 13) submitForm()" onkeyup="upperCase()"></div>
				</div>
				
				<br>
				
				<!-- Submit Button -->
				<div class="row">
					<div class="col" style="text-align:right"><button type="button" class="btn btn-primary" style="width:100px" onclick="submitForm()">Submit</button></div>
				</div>	
			</div>
			
			<input type="hidden" name="buildingNum" value="${buildingNum}">
			<input type="hidden" name="unitNum" value="${unitNum}">
		</form>
		
		<br><br>
		<jsp:include page="${component}/footer.jsp"></jsp:include>	
	</body>
</html>