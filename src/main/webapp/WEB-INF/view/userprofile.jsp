<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.aiml03.project.model.bean.Person" %>
<%@ page import="com.aiml03.project.model.bean.NumberPlate" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>${webName}-personal</title>
<jsp:include page="${component}/common_dependencies.jsp" />
<style><%@include file="/WEB-INF/css/userprofile.css"%></style>
<script><%@include file="/WEB-INF/js/userprofile.js"%></script>

</head>

<body>

	<jsp:useBean id="userProfileData" class="com.aiml03.project.model.bean.Person" scope="request" />
	<jsp:setProperty name="userProfileData" property="*" />
	
	<jsp:useBean id="numberPlateData" class="com.aiml03.project.model.bean.NumberPlate" scope="request" />
	<jsp:setProperty name="numberPlateData" property="*" />
	
	<jsp:include page="${component}/header.jsp" />

	<main>
		<div class="container py-5">
			<div class="row">
				<div class="col-lg-4">
					<div class="card mb-4 mb-lg-0">
						<div class="card mb-4">
							<div class="card-body">
								<div class="row">
									<div class="col-sm-3">
										<p class="mb-0">Name</p>
									</div>
									<div class="col-sm-9">
										<p class="text-muted mb-0"><jsp:getProperty name="userProfileData" property="name" /></p>
									</div>
								</div>
								<hr />

								<div class="row">
									<div class="col-sm-3">
										<p class="mb-0">Phone Number</p>
									</div>
									<div class="col-sm-9">
										<p class="text-muted mb-0"><jsp:getProperty name="userProfileData" property="phone" /></p>
									</div>
								</div>
								<hr />

								<div class="row">
									<div class="col-sm-3">
										<p class="mb-0">Building</p>
									</div>
									<div class="col-sm-9">
										<p class="text-muted mb-0"><jsp:getProperty name="userProfileData" property="building_num" /></p>
									</div>
								</div>
								<hr />

								<div class="row">
									<div class="col-sm-3">
										<p class="mb-0">Unit</p>
									</div>
									<div class="col-sm-9">
										<p class="text-muted mb-0"><jsp:getProperty name="userProfileData" property="unit_num" /></p>
									</div>
								</div>
								<hr />

								<div class="row">
									<div class="col-sm-3">
										<p class="mb-0">Email</p>
									</div>
									<div class="col-sm-9">
										<p class="text-muted mb-0"><jsp:getProperty name="userProfileData" property="email" /></p>
									</div>
								</div>
								<hr />

								<div class="row">
									<div class="col-sm-3">
										<p class="mb-0">Primary Contact</p>
									</div>
									<div class="col-sm-9">
										<p class="text-muted mb-0"><jsp:getProperty name="userProfileData" property="primary_contact" /></p>
									</div>
								</div>
								<hr />

								<div class="row">
									<div class="col-sm-3">
										<p class="mb-0">License Plate</p>
									</div>
									<div class="col-sm-9">
										<p class="text-muted mb-0"><jsp:getProperty name="numberPlateData" property="number_plate" /></p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div>
					<button onclick="showModal()">Leave a message</button>
					<div id="modalWrapper">
						<div class="modal-content">
							<h1>Leave a message</h1>

							<div id="messages">
								<!-- 這裡顯示留言 Show messages here -->
							</div>

							<form>
								<label for="messageInput">your message:</label><br>
								<textarea id="messageInput" rows="5" cols="50"></textarea>
								<br> <input type="button" value="Send"
									onclick="addMessage()">
								<button class="text-muted mb-0" onclick="hideModal()">Close</button>
							</form>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-3">
						<form action="/ToHistory" method="get">
							<button class="btn btn-link" type="submit">View History</button>
						</form>
					</div>
				</div>
				
			</div>
		</div>
	</main>

		<br><br>
		<jsp:include page="${component}/footer.jsp"></jsp:include>
</body>

</html>
