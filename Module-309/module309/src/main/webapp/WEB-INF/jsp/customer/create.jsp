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

<style>
    .form_input_error {
        color: red;
    }
</style>

<section class="bg-light1 py-5">
    <div class="container bg-light1">
        <form action="/customer/create-customer" method="post" enctype="multipart/form-data">

            <!--This is absolute path, without initial / it will become relative path and cause problems  -->
            <input type="hidden" name="id" value="${form.id}"/>
            <div class="mt-3 row justify-content-center">
                <label for="companyName" class="col-sm-2 col-form-label">Company Name</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="companyName" name="companyName"
                           value="${form.companyName}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('companyName')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('companyName')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
            <!--for in label, id, name all should be same
            for is to be same as id because of American Disability Act
            name is essetial for the data transfer from url to controller because the name is what appears in url
            and the name should also be same as the variable we mention in form bean-->
            <div class="mt-3 row justify-content-center">
                <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="firstName" name="firstName" value="${form.firstName}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('firstName')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('firstName')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>


            <div class="mt-3 row justify-content-center">
                <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="lastName" name="lastName" value="${form.lastName}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('lastName')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('lastName')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>


            <div class="mt-3 row justify-content-center">
                <label for="phone" class="col-sm-2 col-form-label">Phone</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="phone" name="phone" value="${form.phone}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('phone')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('phone')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>


            <div class="mt-3 row justify-content-center">
                <label for="addressLine1" class="col-sm-2 col-form-label">Address Line 1</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="addressLine1" name="addressLine1"
                           value="${form.addressLine1}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('addressLine1')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('addressLine1')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>


            <div class="mt-3 row justify-content-center">
                <label for="city" class="col-sm-2 col-form-label">City</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="city" name="city" value="${form.city}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('city')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('city')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>


            <div class="mt-3 row justify-content-center">
                <label for="country" class="col-sm-2 col-form-label">Country</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="country" name="country" value="${form.country}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('country')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('country')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mt-3 row justify-content-center">
                <label for="employeeId" class="col-sm-2 col-form-label">Employee</label>
                <div class="col-sm-10 col-lg-6">
                    <select name="employeeId" id="employeeId" class="form-control">
                        <option value=""></option>
                        <c:forEach var="employee" items="${employeesKey}">
                            <option
                                    value="${employee.id}"
                                    <c:if test="${form.employeeId eq employee.id}">selected</c:if>
                            >${employee.firstName}${employee.lastname}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="mt-3 row justify-content-center">
                <label for="upload" class="col-sm-2 col-form-label">Upload Image</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="file" class="form-control" id="upload" name="upload">
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