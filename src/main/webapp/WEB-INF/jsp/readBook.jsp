<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<link rel="stylesheet" href="<c:url value="/css/style.css"/>">--%>

<h1>Read Books</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Isbn</th>
        <th>Author</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <jsp:useBean id="books" scope="request" type="java.util.List"/>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.isbn}</td>
            <td>${book.author}</td>
            <td><a href="/update-book/${book.id}">Update</a></td>
            <td><a href="/delete-book/${book.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/create-book">Create Book</a>
