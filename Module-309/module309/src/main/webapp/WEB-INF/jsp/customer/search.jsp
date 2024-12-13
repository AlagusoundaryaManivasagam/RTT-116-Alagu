<%--
  Created by IntelliJ IDEA.
  User: kumar
  Date: 12/13/2024
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <%--bootstrap--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <%-- jquery is always loaded at the top of the file because its needed by so many other libraries --%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<h1 class="text-center">Customer Search</h1>
<div class="container">
    <%-- reload the page, vs code does that for us but intellij doesn't--%>
    <form action="/customer/search">
        <%----%>
    <div class="row pt-3 justify-content-center">
        <div class="col-6">

            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" value="${searchTerm}">
                <%--name in the input box is the one that appears in the url--%>
            </div>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-6">
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </div>
    </form>
</div>
<c:if test="${not empty searchTerm}">
<section>
    <div class="container">

        <h2 class="text-center pt-5">Customers found(${customerKey.size()})</h2>
        <table border="1" class="table mt-5">
            <tr>
                <th>Contact First Name</th>
                <th>Contact Last Name</th>
                <th>id</th>
                <th>Customer Name</th>
                <th>Edit</th>

            </tr>
            <c:forEach var="customer" items="${customerKey}">
                <tr>
                    <td>${customer.contactFirstname}</td>
                    <td>${customer.contactLastname}</td>
                    <td>${customer.id}</td>
                    <td>${customer.customerName}</td>
                    <td><a href="/customer/edit/${customer.id}">Edit</td>
                </tr>
            </c:forEach>
        </table>

    </div>
</section>

</c:if>
</body>
</html>
