


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coordination Protocol</title>
<link href="css/form.css" rel="stylesheet">
</head>
<body>
	<div align="center" class="maincontainer">
		<h2>User DashBoard</h2>
		<%--   
       <form action="fileUpload" method="post" enctype="multipart/form-data">  
Upload Protocol File: <input type="file" name="file"/>  
 
<input type="button" value="Request To Invoke Service"/>
</form>   --%>
		<form:form method="POST" modelAttribute="userAcceptRequestObject"
			action="fileUpload" enctype="multipart/form-data">
        Upload your protocol please: 
        <input type="file" name="FileWithProtocol" />
			<br>
			<br>
			<br>
			<form:hidden path="service" />
			<form:hidden path="userName" />
			<input type="submit" value="Request To Invoke Service" />
		</form:form>
	</div>
</body>
</html>



