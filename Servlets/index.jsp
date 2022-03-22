<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Week 07 - CIT 360</title>
</head>
<body>
<h1>Welcome to Week 07 - CIT 360</h1>
<p>To invoke the Java "GET" request, and view the existing database, click <a href="${pageContext.request.contextPath}/Servlet">here</a></p>

<p>To invoke the Java "POST" request, and add a contact to the database, fill out contact information form below and click "Submit".</p>
<form action="Servlet" method="post">
    <p>Enter Name:<input name="name" type="text" /> </p>
    <p>Enter Email:<input name="email" type="email" /></p>
    <p>Enter Date of Birth:<input name="dob" type="date" /></p>
    <p>Enter Phone #:<input name="phone" type="tel" /></p>
    <p><input type="submit" value="Submit" /></p>
</form>

</body>
</html>
