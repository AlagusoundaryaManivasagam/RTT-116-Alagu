<%--
  Created by IntelliJ IDEA.
  User: kumar
  Date: 12/13/2024
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>
<section class="bg-light1 pt-5">
<h1 class="text-center mb-0">Customer Search</h1>
</section>
<section class="bg-light1">
<div class="container pt-4 pb-5">
    <%-- reload the page, vs code does that for us but intellij doesn't--%>
    <form action="/customer/search" class="mb-0">
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
</section>
<c:if test="${not empty searchTerm}">
<section class="bg-light2 pt-4 pb-4" >
    <div class="container">

        <h2 class="text-center">Customers found(${customerKey.size()})</h2>
        <table border="1" class="table mt-5 ">
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
                    <td><a href="/customer/edit/${customer.id}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>

    </div>
</section>

</c:if>
<jsp:include page="../include/footer.jsp"/>
