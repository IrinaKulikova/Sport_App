<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="../template/head.jsp"></c:import>
</head>

<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container main-div mt-3">
    <h1>Administrator: ${admin.login}</h1>
    <form id="form" class="form edit-admin-form mt-3 mb-5">
        <input type="text" id="id" name="id" hidden>
        <div class="row">
            <div class="col mt-2">
                <label for="login">Login: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="login" class="form-control" readonly name="login"
                       value="${admin.login}" placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="email">Email: </label>
            </div>
            <div class="col-md-8">
                <input type="email" id="email" class="form-control" readonly name="email"
                       value="${admin.email}" placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="password1">Password: </label>
            </div>
            <div class="col-md-8">
                <input type="password" id="password1" class="form-control" name="password"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="password2">Confirm: </label>
            </div>
            <div class="col-md-8">
                <input type="password" id="password2" class="form-control" name="confirm"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="mt-4 row">
            <div class="col-md-12 text-center">
                <button type="submit" id="save" value="${admin.id}" class="btn btn-outline-success pl-5 pr-5">
                    Save
                </button>
            </div>
        </div>
    </form>
</div>
<c:import url="../template/footer.jsp"></c:import>
<script src="../../../resources/js/services/FormsValidator.js" type="text/javascript"></script>
<script src="../../../resources/js/services/jquery.validate.js" type="text/javascript"></script>
<script src="../../../resources/js/DTO/DTOAdministrator.js" type="text/javascript"></script>
<script src="../../../resources/js/services/AJAXService.js" type="text/javascript"></script>
<script src="../../../resources/js/admins/admin_edit.js" type="text/javascript"></script>
</body>
</html>

