<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<link rel="stylesheet" href="<c:url value="/css/style.css"/>">--%>

<h1>Create Book</h1>
<form:form method="post" action="/create-book">
    <table>
        <tr>
             <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Isbn:</td>
            <td><form:input path="isbn"/></td>
        </tr>
        <tr>
            <td>Author:</td>
            <td><form:input path="author"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create"/></td>
        </tr>
    </table>
</form:form>
