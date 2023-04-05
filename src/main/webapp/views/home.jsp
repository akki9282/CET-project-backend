<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8" />
<link href="/logo.png" rel="icon" />
<meta content="width=device-width,initial-scale=1" name="viewport" />
<meta content="#000000" name="theme-color" />
<link rel="stylesheet" href="college_predict.css" />


<link href="https://fonts.googleapis.com" rel="preconnect" />
<link href="https://fonts.gstatic.com" rel="preconnect" crossorigin="" />

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" crossorigin="anonymous"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" />
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	crossorigin="anonymous"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	crossorigin="anonymous"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	crossorigin="anonymous"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"></script>
<title>MHT-CET College Predictor | No Login</title>
<meta content="index,follow" data-rh="true" name="robots" />


</head>
<body>
	<noscript>
		<iframe src="https://www.googletagmanager.com/ns.html?id=GTM-MGNNXQ9"
			height="0" width="0" style="display: none; visibility: hidden"></iframe>
	</noscript>
	<noscript>You need to enable JavaScript to run this app.</noscript>
	<div id="root">
		<div class="App">
			<div>
				<div>


					<nav class="navbar navbar-light bg-white">
						<div>
							<centre> <a class="navbar-brand" href="#"> <img
								src="img/logo1.png" width="256px" height="70px"
								class="d-inline-block align-top" alt="">
							</a>
							<p id="clgPr">
								<strong> <span style="color: #4285f4; font-size: 25px;">
										College </span> <span style="color: darkgreen; font-size: 25px;">
										Predictor </span>
								</strong>
							</p>
							</centre>
						</div>
						<div>
							<a href="check.html"><b> COLLEGE PREDICT &nbsp;</b></a> <b>
								News &nbsp;</b> <b> Admission Consulting &nbsp;</b> <b> Contact
								Us &nbsp;</b>
							<!--    <a href="data-table.jsp"><b> Admin Login </b></a> -->

						</div>
					</nav>



				</div>


				<div class="col-sm-12">
					<h2 class="font-weight-bold text-center font-size-res-24">YOUR
						JOURNEY FOR A SUCCESSFUL CAREER STARTS HERE</h2>
					<img src="img/exam-flow.png" class="center-auto w-70 mt-5"
						alt="exam Flow">
				</div>


				<div class="card m-5">
					<div class="card-body">
						<div
							class="row align-items-start justify-content-center CetForm_row mt-5">
							<div class="col-12 col-md-7 CetForm_formCol">
								<form class="text-left" id="Cet_form">
									<h2
										class="font-weight-bold text-center font-size-res-24 font-family-'Times New Roman', Times, serif"
										style="color: rgb(0, 0, 128);">STUDENT DETAILS</h2>
									<BR></BR>
									<div
										class="form-row justify-content-between align-items-center mt-3 mt-md-2">

										<div class="col-12 col-md-5">
											<label class="CetForm_labels" for="Cet_rank"> <b>
													Percentage: </b></label> <span class="text-danger">*</span><input
												class="form-control" id="percentage" name="percentage"
												required="" type="Percentage" value="" min="0" max="100"
												placeholder="Enter Percentage" />
										</div>

										<div id="cat" class="col-12 col-md-5 mt-3 mt-md-0">
											<label class="CetForm_labels" for="Cet_category"><b>
													Category: </b></label> <span class="text-danger">*</span> <input
												class="form-control" id="category" name="category"
												required="" type="text" value="" min="0" max="100"
												placeholder="Enter Category" />


										</div>

									</div>

									<div class="mt-3 mt-md-4">
										<label class="CetForm_labels" for="Gender"> <b>
												Gender: </b></label> <span class="text-danger">*</span>
									</div>
									<div class="form-row align-items-center">
										<div class="col-4 col-md-3">
											<div class="form-row ml-1">
												<div class="col-3 col-md-2">
													<div class="form-check">
														<input class="form-check-input" id="male" name="gender"
															required="" type="radio" value="male" />
													</div>
												</div>
												<label class="gender" for="male"
													style="font-size: 17px; margin-top: -1px;">Male</label>
											</div>
										</div>
										<div class="col-4 col-md-3">
											<div class="form-row">
												<div class="col-3 col-md-2">
													<div class="form-check">
														<input class="form-check-input" id="female" name="gender"
															required="" type="radio" value="female" />
													</div>
												</div>
												<label class="Gender" for="female"
													style="font-size: 17px; margin-top: -1px;">Female</label>
											</div>
										</div>
									</div>
									<centre>
									<div id="outerDiv" class="form-row justify-content-center mt-5">
										<div class="col-md-4 col-1">
											<button type="button" class="btn btn-outline-danger btn-lg">Clear
												Form</button>
										</div>
										<div class="col-md-4 col-6">
											<button type="button" class="btn btn-outline-primary btn-lg"
												onclick='getColleges()' id="predict">Predict
												Results</button>
										</div>
									</div>
									</centre>
								</form>
							</div>
						</div>
					</div>


					<table id="collegeTable">
						<thead>
							<tr>
								<th>College ID</th>
								<th>College Name</th>
								<th>City</th>
								<th>Type</th>
								<th>Branch ID</th>
								<th>Branch Name</th>
								<th>Ranking</th>
								<th>Percentage</th>
							</tr>
						</thead>
						<tbody id="college-list">
						</tbody>
					</table>



					<div
						class="col-2 col-md-12 text-left Form_textPara font-weight-bold"
						style="margin-left: 7%;">

						<p class="">
						<li>Know your chances and cutoff Ranks of prestigious
							colleges like COEP, VJTI, SPCE, SPIT, PICT, WCE, and many more.</li>
						</p>
						<p>
						<li>Get Rank for all Categories (Open, SC, ST, OBC, NT, EWS,
							TFWS, DEF, ORPHAN, PWD) and Gender.</li>
						</p>
						<li>Get a full list and make a wise career decision.</li>
						</p>
						<p>
						<li>Note :</li>
						<ul>
							<p>
							<li>Start Character : G-General, L-Ladies.</li>
							</p>
							<p>
							<li>End Character : H-Home University, O-Other than Home
								University, S-State Level.</li>
							</p>
							<p>
							<li>Maharashtra State Seats : Cut Off Indicates State
								General Merit No. , Figures in bracket Indicates MHT-CET PCM
								Percentile.</li>
							</p>
						</ul>
						</ul>
						</p>
					</div>
				</div>
			</div>
		</div>
		<!-- <hr class="mt-2 mb-2" /> -->
		<div class="row Footer_Div justify-content-center">
			<p class="Footer_text">Copyright ©2023 | All Rights Reserved To
				Tech-Trail Technologies Pvt. Ltd. | Privacy Policy | Terms and
				Conditions</p>
		</div>
	</div>
	</div>
	</div>
	<script>
	
	$(document).ready(function() {
        $('#collegeTable').DataTable({
          "order": [[0, "asc"]],
          "paging": true,
          "searching": true,
          "lengthChange": true,
          "pageLength": 10,
          "language": {
            "emptyTable": "No data available in table"
          },
          /* "ajax": {
            "url": "/api/colleges",
            "dataSrc": ""
          }, */
          "columns": [
            { "data": "College ID" },
            { "data": "College Name" },
            { "data": "City" },
            { "data": "Type" },
            { "data": "Branch Id" },
            { "data": "Branch Name" },
            { "data": "Ranking" },
            { "data": "percentage" }
          ]
        });
      });
	
	 function getColleges() {
	       
		  var percentage = $('#percentage').val();
	        var category = $('#category').val();
	        var gender = $('input[name=gender]:checked').val();
	        
var url = "/college-predict/colleges?";
if (percentage) {
    url += "percentage=" + percentage + "&";
}
if (category) {
    url += "category=" + category + "&";
}
if (gender) {
    url += "gender=" + gender;
}

/* console.log(url);
fetch(url)
.then(response => response.json())
.then(data => {
  const tableBody = document.querySelector('#college-list');
  data.forEach(college => {
    const row = tableBody.insertRow();
    row.insertCell().textContent = college.college_ID;
    row.insertCell().textContent = college.college_name;
    row.insertCell().textContent = college.city;
    row.insertCell().textContent = college.type;
    row.insertCell().textContent = college.branch_ID;
    row.insertCell().textContent = college.branch_name;
    /* row.insertCell().textContent = college.stage; */
    /* row.insertCell().textContent = college.ranking;
    row.insertCell().textContent = college.percentage; */
    /* row.insertCell().textContent = college.category_name; */
  /* });
})
.catch(error => console.error(error));

	} */  
	
	const tableBody = document.querySelector('#college-list');
	const pageSize = 10; // Number of rows per page
	let currentPage = 1; // Current page

	fetch(url)
	  .then(response => response.json())
	  .then(data => {
	    const totalRows = data.length;
	    const totalPages = Math.ceil(totalRows / pageSize);

	    function renderTable() {
	      // Clear the current table
	      tableBody.innerHTML = '';

	      // Determine the start and end index for the current page
	      const startIndex = (currentPage - 1) * pageSize;
	      const endIndex = Math.min(startIndex + pageSize, totalRows);

	      // Loop through the data for the current page and insert a row for each college
	      for (let i = startIndex; i < endIndex; i++) {
	        const college = data[i];
	        const row = tableBody.insertRow();
	        row.insertCell().textContent = college.college_ID;
	        row.insertCell().textContent = college.college_name;
	        row.insertCell().textContent = college.city;
	        row.insertCell().textContent = college.type;
	        row.insertCell().textContent = college.branch_ID;
	        row.insertCell().textContent = college.branch_name;
	        /* row.insertCell().textContent = college.stage; */
	        row.insertCell().textContent = college.ranking;
	        row.insertCell().textContent = college.percentage;
	        /* row.insertCell().textContent = college.category_name; */
	      }
	    }

	    // Create the table headers
	    const tableHeader = tableBody.createTHead();
	    const headerRow = tableHeader.insertRow();
	    headerRow.insertCell().textContent = "College ID";
	    headerRow.insertCell().textContent = "College Name";
	    headerRow.insertCell().textContent = "City";
	    headerRow.insertCell().textContent = "Type";
	    headerRow.insertCell().textContent = "Branch ID";
	    headerRow.insertCell().textContent = "Branch Name";
	    /* headerRow.insertCell().textContent = "Stage"; */
	    headerRow.insertCell().textContent = "Ranking";
	    headerRow.insertCell().textContent = "Percentage";
	    /* headerRow.insertCell().textContent = "Category Name"; */

	    // Render the first page
	    renderTable();

	    // Create the pagination links
	    const pagination = document.querySelector('#pagination');
	    for (let i = 1; i <= totalPages; i++) {
	      const link = document.createElement('a');
	      link.href = '#';
	      link.textContent = i;

	      if (i === currentPage) {
	        link.classList.add('active');
	      }

	      link.addEventListener('click', (event) => {
	        event.preventDefault();
	        currentPage = i;
	        renderTable();

	        // Update the active link
	        const activeLink = pagination.querySelector('.active');
	        if (activeLink) {
	          activeLink.classList.remove('active');
	        }
	        link.classList.add('active');
	      });

	      pagination.appendChild(link);
	    }
	  })
	  .catch(error => console.error(error));
	}
	
	
       
    </script>

	</div>
</body>
</html>
