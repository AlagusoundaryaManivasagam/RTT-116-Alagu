<%--
  Created by IntelliJ IDEA.
  User: kumar
  Date: 12/16/2024
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>
<section class="bg-light1 py-5">
    <div class="container">
        <div class="row">
        <h1 class="m-0 text-center">Create Customer</h1>
        </div>
    </div>
</section>
<section class="bg-light1 py-5">
    <div class="container bg-light1">
        <form action="">
            <div class="mb-3 row justify-content-center">
                <label for="CompanyName" class="col-sm-2 col-form-label">Company Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="CompanyName" name="CompanyName" value="">
                </div>
            </div>
            <div class="mb-3 row justify-content-center">
                <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="firstName" name="firstName" value="">
                </div>
            </div>
            <div class="mb-3 row justify-content-center">
                <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="lastName" name="lastName" value="">
                </div>
            </div>

        </form>
    </div>
</section>
<jsp:include page="../include/footer.jsp"/>