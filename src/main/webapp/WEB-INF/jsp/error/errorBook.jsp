<jsp:useBean id="message" scope="request" type="java.lang.String"/>
<jsp:useBean id="reference" scope="request" type="java.lang.String"/>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Error Create Book</title>
</head>
<body>
<a href="/read-book">View Books</a>
<p>Code Isbn: ${reference}</p>
<p>${message}</p>
</body>
</html>