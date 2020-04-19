


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coordination Protocol</title>
<link href="css/form.css"
        rel="stylesheet">
</head>
<body>
    <div align="center" class="maincontainer">
        <h2>User DashBoard</h2>
        
        <form:form action="intialRequest" method="POST" modelAttribute="user">
            <form:label path="UserName">Full name:</form:label>
            <form:input path="UserName"/><br/>
            <br>
            <br>
           
          
            <form:label path="service">service:</form:label>
            <form:select path="service" items="${servicesList}" /><br/>
                     <br>
                     <br>
            
                 
            <form:button>Upload Protocol</form:button>
        </form:form>
    </div>
</body>
</html>