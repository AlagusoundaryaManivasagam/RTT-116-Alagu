<%--
  Created by IntelliJ IDEA.
  User: kumar
  Date: 12/19/2024
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>
<section class="bg-light1 py-5">
    <div class="container">
        <div class="row">
            <h1 class="m-0 text-center">Sign Up</h1>
        </div>
    </div>
</section>

<style>
    .form_input_error {
        color: red;
    }
</style>

<section class="bg-light1 py-5">
    <div class="container bg-light1">
        <form action="">
            <div class="mt-3 row justify-content center">
                <label for="username" class="col-sm-2 col-form-label">User Name</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="username" name="username">
                </div>
            </div>

            <div class="mt-3 row justify-content center">
                <label for="password" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="password" name="password">
                </div>
            </div>

            <div class="mt-3 row justify-content center">
                <label for="email" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="email" name="email">
                </div>
            </div>

            <div class="mb-3 row justify-content-center">
                <div class="col-sm-12 col-lg-8">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>

        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>