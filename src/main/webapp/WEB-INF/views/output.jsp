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
        
        <form:form method="POST" modelAttribute="result" action="nextRequest">
            <form:label path="userName">Hello! ${userName}</form:label>
            <form:hidden path="fileName"/>
            <form:hidden path="userName"/>
             <form:hidden path="lastProcessedCharacter"/>
            <br>
            <br>
            <p>RESPONSE FOR PREVIOUS INVOCATION</p>
            <br>
            <br>
            <form:label path="finalResponseObject">Response</form:label>
            <br>
            <br>
            <form:textarea path="finalResponseObject" rows="9" cols="30"></form:textarea>>
           <br>
           <br>
           <br>
            <br>
            <form:label path="possibleServicesList">service:</form:label>
            <form:select path="possibleServicesList" items="${possibleServices}" /><br/>
                     <br>          
            <form:button>Invoke Service</form:button>
        </form:form>
    </div>
</body>
</html>