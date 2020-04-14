<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE HTML>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Getting Started: Serving Web Content</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/index.css"
        rel="stylesheet">
</head>
<body>

	<div class="maincontainer">
		<h1>Coordination protocol</h1>

		<hr>








		<label for="UserName"><b>User Name</b></label> <input type="text"
			placeholder=" Please Enter Your Name" name="user" required>


		<p>please upload the coordination protocol file:</p>
		<input type="file" id="myFile" name="filename"> <br> <br>
		<br>
		<p>Please Select Desired Service</p>
<select id="Select">
  <option value="Service 1">Service 1</option>
  <option value="Service 2">Service 2</option>
  <option value="Service 3">Service 3</option>
  <option value="Service 4">Service 4</option>
  <option value="Service 5">Service 5</option>
  <option value="Service 6">Service 6</option>
  <option value="Service 7">Service 7</option>
  <option value="Service 8">Service 8</option>
  <option value="Service 9">Service 9</option>
   <option value="Service 10">Service 10</option>
  <option value="Select" selected>none</option>
</select>

<!-- 
		<div class="dropdown">
			<button onclick="myFunction()" class="dropbtn">Dropdown</button>
			<div id="myDropdown" class="dropdown-content">
				<a href="#home">Sevice 1</a> <a href="#about">Sevice 2</a> <a
					href="#contact">Sevice 3</a> <a href="#contact">Sevice 4</a> <a
					href="#contact">Sevice 5</a> <a href="#contact">Sevice 6</a> <a
					href="#contact">Sevice 7</a> <a href="#contact">Sevice 8</a> <a
					href="#contact">Sevice 9</a> <a href="#contact">Sevice 10</a>
			</div>
		</div> -->

		<br> <br> <br>
		<div align="right">
			<button type="button" class="cancelbtn">Invoke Service</button>
		</div>
	</div>
	
<script src="js/index.js"></script>


	<p>
		Get your greeting <a href="/hello">here</a>
	</p>
</body>
</html>