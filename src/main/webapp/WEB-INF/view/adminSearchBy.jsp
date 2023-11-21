<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${webName}</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
		
		<style><%@include file="/WEB-INF/css/default.css"%></style>
		<title>Insert title here</title>
		
		<script>
		function toUpper()
		{
			input = document.getElementById('buildingNum').value
			document.getElementById('buildingNum').value = input.toUpperCase()
		}
		function submitForm()
		{
			document.forms["myForm"].submit();	
		}
		</script>
	</head>
	<body>
		<jsp:include page="${component}/adminHeader.jsp"></jsp:include>
		<br><br>
		<form name="myForm" action="${root}/AdminSearchBy.do" method="post">
			<div class="container" style="margin:auto;width:40%">			
				<div><p class="page-title">"Discover your ideal residence effortlessly with our intuitive search function."</p></div>
				<br>
				
				<!-- Building Number -->
				<div class="row">
					<div class="col"><label for="buildingNum" class="form-label">Building #:</label><span style="color:red;margin-left:20px" id="error1"></span></div>					
				</div>				
				<div class="row">
					<div class="col"><input type="text" class="form-control" name="buildingNum" id="buildingNum" onkeypress="if (event.keyCode == 13) document.getElementById('unitNum').focus()" onkeyup="toUpper()"></div>
				</div>
				<!-- Unit Number -->
				<div class="row">
					<div class="col"><label for="unitNum" class="form-label">Unit #:</label><span style="color:red;margin-left:20px" id="error2"></span></div>					
				</div>
				<div class="row">
					<div class="col"><input type="text" class="form-control" name="unitNum" id="unitNum" onkeypress="if (event.keyCode == 13) submitForm()"></div>				
				</div>	
				<br>
				<!-- Search Button -->
				<div class="row">
					<div class="col" style="text-align:right"><button type="button" class="btn btn-primary" style="width:100px" onclick="submitForm()">Search</button></div>
				</div>	
			</div>
			<br><br>
		<div class="container">
			<div class="row mb-2">
				<c:forEach items="${personList}" var="p">
					<div class="col-md-6 mb-4">
						<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
							<div class="col p-4 d-flex flex-column position-static">
								<strong class="d-inline-block mb-2 text-primary-emphasis">Building ${p.buildingNum}, Unit ${p.unitNum}</strong>
								<h3 class="mb-0">${p.name }</h3>
								<div class="mb-1 text-body-secondary">
									Access  <a href="History.jsp">History</a>
								</div>
								<p class="card-text mb-auto">${p.phone }</p>
								<p class="card-text mb-auto">${p.email }</p>
								<a href="#" class="icon-link gap-1 icon-link-hover stretched-link">More informations 
									<svg class="bi"><use xlink:href="#chevron-right" /></svg>
								</a>
							</div>
							<div class="col-auto d-none d-lg-block">
								<img src="${p.photo}" alt="${p.name} Image" class="bd-placeholder-img w-24 h-24 md:w-48 md:h-auto" width="200" height="250 " style="object-fit: cover;">
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>			
				
		</form>
		<br><br>
		<jsp:include page="${component}/footer.jsp"></jsp:include>	
	</body>
</html>