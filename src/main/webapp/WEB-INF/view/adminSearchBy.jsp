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
		
<style>
   /* Add your custom CSS styles here */
   .reserved-date {
    background-color: #ff0000; /* Red background for reserved dates */
    color: #ffffff; /* White text for better visibility */
         
            
    /* Add your custom CSS styles here */
    #dateList {
    /* Add any other styles for the dateList container here */
    position: relative;
    
    }

    #dateList::before {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        width: 10px; /* Set the width as needed */
        height: 100%; /* Set the height to cover the entire height of the container */
        background-color: #ff0000; /* Red background for the indicator */
    }

    .reserved-date {
        /* Add any styles for reserved dates here */
        color: #ffffff; /* White text for better visibility */
    }
        }
</style>
        

	</head>
	<body>
		<jsp:include page="${component}/adminHeader.jsp"></jsp:include>
		<br><br>
		<form name="myForm" action="${root}/AdminSearchBy.do" method="post">
			<div class="container" style="margin:auto;width:40%">		
				<h1 class="page-title" style="font-size: 48px;">Search Resident</h1>	
				<div><p class="page-title">"Discover your ideal residence effortlessly with our intuitive search function."</p></div>
				<br>
				
				<!-- Building Number -->
				<div class="row">
					<div class="col">
						<label for="buildingNum" class="form-label">Building #:</label>
							<span style="color:red;margin-left:20px" id="error1"></span>
				</div>					
				</div>				
				<div class="row">
					<div class="col">
						<input type="text" class="form-control" name="buildingNum" id="buildingNum" onkeypress="if (event.keyCode == 13) document.getElementById('unitNum').focus()" onkeyup="toUpper()">
				</div>
				</div>
				
				<!-- Unit Number -->
				<div class="row">
					<div class="col">
						<label for="unitNum" class="form-label">Unit #:</label>
							<span style="color:red;margin-left:20px" id="error2"></span>
				</div>					
				</div>
				
				<div class="row">
					<div class="col">
						<input type="text" class="form-control" name="unitNum" id="unitNum" onkeypress="if (event.keyCode == 13) submitForm()">
				</div>				
				</div>	
				<br>
				<!-- Search Button -->
				<div class="row">
					<div class="col" style="text-align:right">
						<button type="button" class="btn btn-primary" style="width:100px" onclick="submitForm()">Search</button>
				</div>
				</div>	
			</div>
			
			<br><br>
			<div class="container">
				<div class="row mb-2">
					<c:forEach items="${personList}" var="p">
						<div class="col-md-6 mb-4">
							<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
								<div class="col p-4 d-flex flex-column position-static">
									<strong class="d-inline-block mb-2 text-primary">Building ${p.buildingNum}, Unit ${p.unitNum}</strong>
									<h3 class="mb-0">${p.name }</h3>
									<div class="mb-1 text-body-secondary">
										<strong>Access</strong>  <a href="History.jsp">History</a>
									</div>
									<p class="card-text mb-auto"><strong>Resident ID:</strong> ${p.pID}</p>
									<p class="card-text mb-auto"><strong>Phone NO.</strong> ${p.phone }</p>
									<p class="card-text mb-auto"><strong>Email@:</strong> ${p.email }</p>
									<a href="#" class="icon-link gap-1 icon-link-hover stretched-link">More informations 			
									</a>
								</div>
								<div class="col-auto d-none d-lg-block">
									<img src="${p.photo}" 
									alt="${p.name} Image" 
									class="bd-placeholder-img w-24 h-24 md:w-48 md:h-auto" 
									width="200" 
									height="250" 
									style="object-fit: cover;"/>
									 <div class="overlay">
								</div>					
							  </div>					
							</div>
						</div>
					</c:forEach>
				</div>
			</div>			
				
		</form>	
		<div class="album py-5 bg	-body-tertiary">
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
                                <button type="submit" class="btn btn-sm btn-outline-secondary" onclick="reserveDate()">Reserve</button>
                            </div>
                            <small class="text-body-secondary" id="status_available">Status: <span id="availability">Available</span></small>
                        </div>
						</div>
					</div>
				</div>

 

<script>
    var reservedDates = []; // Array to store reserved dates

    function reserveDate() {
        var dateInput = document.getElementById('date');
        var selectedDate = dateInput.value;
        
        // Check if the selected date is today
        var today = new Date().toISOString().split('T')[0];

        // Check if the selected date is already reserved
        if (reservedDates.includes(selectedDate)) {
            alert('This date is already reserved.');
        } else {
            // Add the selected date to the reservedDates array
            reservedDates.push(selectedDate);

            // Enable the date input for selecting a different date
            dateInput.disabled = false;

            // Update availability status
            var availabilityElement = document.getElementById('availability');
            availabilityElement.textContent = 'Occupied';
            availabilityElement.style.color = 'red';

            // Update the date list
            updateDateList();
        }
    }

    // Function to update the date list
    function updateDateList() {
        var dateListContainer = document.getElementById('dateList');
        dateListContainer.innerHTML = '';

        // Display available and reserved dates
        for (var i = 0; i < reservedDates.length; i++) {
            var dateItem = document.createElement('div');
            dateItem.textContent = reservedDates[i];
            dateItem.classList.add('reserved-date');
            dateListContainer.appendChild(dateItem);
        }
    }

    // Call the function to update the date list on page load
    window.onload = updateDateList;
</script>

				<!-- 		<script>
						    var reservedDates = []; // Array to store reserved dates
						
						    function reserveDate() {
						        var dateInput = document.getElementById('date');
						        var selectedDate = dateInput.value;
						
						        // Check if the selected date is already reserved
						        if (reservedDates.includes(selectedDate)) {
						            alert('This date is already reserved. Please choose another date.');
						        } else {
						            // Add the selected date to the reservedDates array
						            reservedDates.push(selectedDate);
						
						            // Update the calendar (disable the selected date)
						            dateInput.disabled = false;
						
						            // Update availability status
						            var availabilityElement = document.getElementById('availability');
						            availabilityElement.textContent = 'Occupied';
						            availabilityElement.style.color = 'red';
						         
						        }
						    }
						</script>
				
				 -->	
					
				

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
								<small class="text-body-secondary" id="poolCount">${p.pID}#0</small>

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
								<small class="text-body-secondary" id="poolCount">${p.pID}#0</small>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
		<br><br>
		<!-- Display available and reserved dates outside the date picker -->
<div id="dateList">
    <!-- Dates will be dynamically generated here -->
		<jsp:include page="${component}/footer.jsp"></jsp:include>	
	</body>
</html>