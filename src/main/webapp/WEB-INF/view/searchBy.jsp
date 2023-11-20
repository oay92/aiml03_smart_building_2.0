<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.3/examples/album/" />

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3" />

<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script src="../assets/js/color-modes.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>

</head>
<meta charset="UTF-8">
<title>Smart Building - Search By</title>





</head>
<body>
	<jsp:include page="${component}/header.jsp" />

	<main>


		<section class="py-5 text-center container"
			class="background-container">

			<div class="row py-lg-5">
				<div class="col-lg-6 col-md-8 mx-auto">
					<h1 class="fw-light">Search Resident</h1>
					<p class="lead text-body-secondary">"Discover your ideal
						residence effortlessly with our intuitive search function."</p>

					<form name="myForm" action="${root}/SearchResident.do"
						method="post">
						<label for="buildingNo" class="form-label">Building No.</label> <input
							type="text" class="form-control" id="buildingNo"
							name="buildingNo" placeholder="Enter Building No." value=""
							required>
						<div class="invalid-feedback">Valid [building No.] is
							required.</div>

						<div class="col-sm-6"></div>
						<label for="unitNo" class="form-label">Unit No.</label> <input
							type="text" class="form-control" id="unitNo" name="unitNo"
							placeholder="Enter Unit No." value="" required>
						<div class="invalid-feedback">Valid [unit No.] is required.</div>
						<div>

							<input type="submit" value="submit" color="gray">

						</div>

					</form>



					<svg xmlns="http://www.w3.org/2000/svg" class="d-none">
      <symbol id="check2" viewBox="0 0 16 16">
        <path
							d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
      </symbol>
      <symbol id="circle-half" viewBox="0 0 16 16">
        <path
							d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z" />
      </symbol>
      <symbol id="moon-stars-fill" viewBox="0 0 16 16">
        <path
							d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z" />
        <path
							d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z" />
      </symbol>
      <symbol id="sun-fill" viewBox="0 0 16 16">
        <path
							d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z" />
      </symbol>
    </svg>

					<div
						class="dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle">
						<button
							class="btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center"
							id="bd-theme" type="button" aria-expanded="false"
							data-bs-toggle="dropdown" aria-label="Toggle theme (auto)">
							<svg class="bi my-1 theme-icon-active" width="1em" height="1em">
								<use href="#circle-half"></use></svg>
							<span class="visually-hidden" id="bd-theme-text">Toggle
								theme</span>
						</button>
						<ul class="dropdown-menu dropdown-menu-end shadow"
							aria-labelledby="bd-theme-text">
							<li>
								<button type="button"
									class="dropdown-item d-flex align-items-center"
									data-bs-theme-value="light" aria-pressed="false">
									<svg class="bi me-2 opacity-50 theme-icon" width="1em"
										height="1em">
										<use href="#sun-fill"></use></svg>
									Light
									<svg class="bi ms-auto d-none" width="1em" height="1em">
										<use href="#check2"></use></svg>
								</button>
							</li>
							<li>
								<button type="button"
									class="dropdown-item d-flex align-items-center"
									data-bs-theme-value="dark" aria-pressed="false">
									<svg class="bi me-2 opacity-50 theme-icon" width="1em"
										height="1em">
										<use href="#moon-stars-fill"></use></svg>
									Dark
									<svg class="bi ms-auto d-none" width="1em" height="1em">
										<use href="#check2"></use></svg>
								</button>
							</li>
							<li>
								<button type="button"
									class="dropdown-item d-flex align-items-center active"
									data-bs-theme-value="auto" aria-pressed="true">
									<svg class="bi me-2 opacity-50 theme-icon" width="1em"
										height="1em">
										<use href="#circle-half"></use></svg>
									Auto
									<svg class="bi ms-auto d-none" width="1em" height="1em">
										<use href="#check2"></use></svg>
								</button>
							</li>
						</ul>
					</div>






				</div>
			</div>
		</section>
	</main>

	<section>
		<div id="searchResults" class="row mb-2">
			<!-- Search results will be dynamically added here -->
		</div>
		<div class="container">
			<div class="row mb-2">
				<c:forEach items="${Resident_information }" var="p">
					<div class="col-md-6 mb-4">
						<div
							class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
							<div class="col p-4 d-flex flex-column position-static">
								<strong class="d-inline-block mb-2 text-primary-emphasis">#${p.pID
									}</strong>
								<h3 class="mb-0">${p.name }</h3>
								<div class="mb-1 text-body-secondary">
									Access ${p.faceStamp } <a href="History.jsp">History</a>
								</div>
								<p class="card-text mb-auto">${p.name }</p>
								<p class="card-text mb-auto">${p.phoneNo }</p>
								<p class="card-text mb-auto">${p.email }</p>
								<p class="card-text mb-auto">${p.buildingNo }</p>
								<p class="card-text mb-auto">${p.unitNo }</p>
								<a href="#"
									class="icon-link gap-1 icon-link-hover stretched-link">
									More informations <svg class="bi">
								<use xlink:href="#chevron-right" /></svg>
								</a>
							</div>
							<div class="col-auto d-none d-lg-block">
								<img src="${p.photo}" alt="${p.name} Image"
									class="bd-placeholder-img w-24 h-24 md:w-48 md:h-auto"
									width="200" height="250 " style="object-fit: cover;">
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>

	<div class="album py-5 bg-body-tertiary">
		<div class="container">
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
				<div class="col">
					<!-- Card 1 -->
					<div class="card shadow-sm">
						<img
							src="https://i.pinimg.com/736x/15/fb/d4/15fbd4c6632c5b99502891b48fd36107.jpg"
							alt="Photo" class="bd-placeholder-img card-img-top" width="100%"
							height="225" style="object-fit: cover;">
						<div class="card-body">
							<p class="card-text">Conference room, Movie theater, KTV,
								Kitchen.</p>
							<div class="d-flex justify-content-between align-items-center">
								 <div class="btn-group">
								
								 
                                <input type="date" class="btn btn-sm btn-outline-secondary" id="date"></input>
                                <button type="submit" class="btn btn-sm btn-outline-secondary">Reservation</button>
                            </div>
                            <small class="text-body-secondary" id="status${p.pID}">${p.pID} Status: Available</small>
                        </div>
						</div>
					</div>
				</div>

				<!-- Card 2 -->
				<div class="col">
					<div class="card shadow-sm">
						<img
							src="https://i0.wp.com/theluxurytravelexpert.com/wp-content/uploads/2016/02/park-hyatt-new-york-usa.jpg?ssl=1"
							alt="Photo" class="bd-placeholder-img card-img-top" width="100%"
							height="225" style="object-fit: cover;">
						<div class="card-body">
							<p class="card-text">Swimming pool.</p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
			<!--  						<button type="button" class="btn btn-sm btn-outline-secondary" onclick="navigateToSite('https://www.humbleboutique.com.tw/websev?lang=en&ref=pages&cat=4&id=9')">
    View
</button>-->
								<input type="text" placeholder="Resident ID"class="form-control" id="accessID" required>
       						 <button type="button" class="btn btn-sm btn-outline-secondary" onclick="registerAccessID()">Register</button>
							</div>
								<small class="text-body-secondary" id="poolCount">${p.pID}
									#0</small>


							</div>
						</div>
					</div>
				</div>

				<!-- Card 3 -->
				<div class="col">
					<div class="card shadow-sm">
						<img
							src="https://s9i4v6w2.rocketcdn.me/wordpress/wp-content/uploads/2023/02/01-Bergman-Interiors_Accor-Gym-Day-View-01-Hires.jpg"
							alt="Photo" class="bd-placeholder-img card-img-top" width="100%"
							height="225" style="object-fit: cover;">
						<div class="card-body">
							<p class="card-text">Gym.</p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
								<!--  	<button type="button" class="btn btn-sm btn-outline-secondary" onclick="navigateToSite('https://www.humbleboutique.com.tw/websev?lang=en&ref=pages&cat=4&id=10')">
    View</button>-->
									
            				<input type="text" placeholder="Resident ID"class="form-control" id="accessID" required>
       						 <button type="button" class="btn btn-sm btn-outline-secondary" onclick="registerAccessID()">Register</button>
							</div>
								<small class="text-body-secondary" id="poolCount">${p.pID}
									#0</small>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>





	<jsp:include page="${component}/footer.jsp" />



<script>
    function registerAccessID() {
        // Get access ID from the input field
        var accessID = document.getElementById('accessID').value;

        // Perform registration logic (e.g., send data to the server using AJAX)
        // This is a simplified example; in a real application, you would send a request to a server endpoint
        // for access ID registration, and the server would handle the registration process securely.

        // After successful registration, you can redirect the user or display a success message.
        alert('Access ID registration successful. Redirect or display a success message.');
    }
</script>



<script>
    function navigateToSite(url) {
        window.location.href = url;
    }
</script>



	<script>
		var poolCount = 0; // Initialize the counter variable

		function viewPool() {
			// Implement view logic if needed
		}

		function registerPool() {
			var personID = "${p.pID}"; // Get the person ID dynamically
			poolCount++; // Increment the counter
			document.getElementById('poolCount').textContent = '#' + pID
					+ '.count: ' + poolCount; // Update the displayed count
		}
	</script>
	
	
</body>

</html>