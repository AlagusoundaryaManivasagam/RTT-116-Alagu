<%--
  Created by IntelliJ IDEA.
  User: kumar
  Date: 12/13/2024
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<section class="bg-light1 pt-5">
    <h1 class="text-center mb-0">Employee Search</h1>
</section>
<section class="bg-light1 pt-5 pb-5">
    <div class="container">
        <%-- reload the page, vs code does that for us but intellij doesn't--%>
        <form action="/employee/search" class="mb-0">
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

            <h2 class="text-center">Employees found(${employeeKey.size()})</h2>
            <table border="1" class="table mt-5 ">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Id</th>
                    <th>Email</th>
                    <th>Edit</th>

                </tr>
                <c:forEach var="employee" items="${employeeKey}">
                    <tr>
                        <td>${employee.firstName}</td>
                        <td>${employee.lastname}</td>
                        <td>${employee.id}</td>
                        <td>${employee.email}</td>
                        <td><a href="/employee/edit/${employee.id}">Edit</a></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </section>

</c:if>
<jsp:include page="../include/footer.jsp"/>
