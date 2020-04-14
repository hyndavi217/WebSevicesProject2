


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
</head>
<body>
    <div align="center">
        <h2>User Registration</h2>
        
        <form:form action="register" method="POST" modelAttribute="user">
            <form:label path="UserName">Full name:</form:label>
            <form:input path="UserName"/><br/>
          
            <form:label path="profession">Profession:</form:label>
            <form:select path="profession" items="${professionList}" /><br/>
                     
            
                 
            <form:button>Register</form:button>
        </form:form>
    </div>
</body>
</html>