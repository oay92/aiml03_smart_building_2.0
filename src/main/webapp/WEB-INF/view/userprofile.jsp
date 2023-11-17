<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.aiml03.project.model.bean.Person" %>
<%@ page import="com.aiml03.project.model.bean.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>${webName}-personal</title>

<jsp:include page="${component}/common_dependencies.jsp" />

<style><%@include file="/WEB-INF/css/userprofile.css"%></style>

</head>

<body>
	<jsp:useBean id="userProfileData" class="com.aiml03.project.model.bean.Person" scope="request" />
	<jsp:setProperty name="userProfileData" property="*" />
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
										<p class="text-muted mb-0"><jsp:getProperty name="userProfileData" property="building_num" /></p>
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
								<button onclick="hideModal()">Close</button>
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>
	</main>

	<jsp:include page="${component}/footer.jsp" />
</body>


<script>//profile
  const userInfos = document.querySelectorAll(".userInfo");
  const xmarks = document.querySelectorAll(".xmark");

  userInfos.forEach((userInfo) => {
    userInfo.addEventListener("mouseenter", function () {
      this.previousElementSibling.classList.remove("xmark-hide");
    });
    userInfo.addEventListener("mouseleave", function (e) {
      if (e.relatedTarget.classList.contains("xmark")) {
        return;
      }
      this.previousElementSibling.classList.add("xmark-hide");
    });
  });

  xmarks.forEach((xmark) => {
    xmark.addEventListener("click", function () {
      if (confirm("Are you sure you want to delete this information?") == false) {
        return;
      }

      this.parentElement.parentElement.parentElement.remove();
    });
  });
</script>


<script>//Message
		function showModal() {
			var modal = document.getElementById('modalWrapper');
			modal.classList.add('active');
		}

		function addMessage(event) {
			event.preventDefault();
			var message = document.getElementById('messageInput').value;
			// 在留言區域添加新留言
			document.getElementById('messages').innerHTML += '<p>' + message
					+ '</p>';
			document.getElementById('messageInput').value = '';
			clearMessages();
		}

		function clearMessages() {
			var messagesContainer = document.getElementById('messages');
			messagesContainer.innerHTML = '';
		}

		function hideModal() {
			var modal = document.getElementById('modalWrapper');
			modal.classList.remove('active');
		}
	</script>
</html>
