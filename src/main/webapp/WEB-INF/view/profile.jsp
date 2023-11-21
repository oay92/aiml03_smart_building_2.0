<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>${webName}</title>
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
		
		<style><%@include file="/WEB-INF/css/default.css"%></style>
	</head>
	
	<body>
		<jsp:include page="${component}/simpleHeader.jsp" />
		<br><br>
		<form name="myform">
			<div style="margin:auto;width:40%">
				<c:forEach items="${personList}" var="p">
				<div class="card mb-3" style="width: 540px;">
					<div class="row g-0">
						<div class="col-md-4">
						<img src="${p.photo}" style="width:180px">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">${p.name}</h5>
								<p class="card-text">Email: ${p.email}</p>
								<p class="card-text">Phone: ${p.phone}</p>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
			
			<hr>
			
			<div style="margin:auto;width:40%">
				<div class="row"><div class="col"><p class="pate-title">License Plates</div></div>
				<c:forEach items="${plateList}" var="p">
				<div class="row"><div class="col"><i class="fa-solid fa-car"></i><span style="margin-left:20px">${p.numberPlate}</span></div></div>
				</c:forEach>
			</div>
		</form>	
	
		<br><br>
		<jsp:include page="${component}/footer.jsp"></jsp:include>
	</body>

</html>
