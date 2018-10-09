<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="../template/head.jsp"></c:import>
</head>

<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container main-div m-5">
    <div class="user-edit-div">
        <h2><strong>Create user</strong></h2>
        <form class="create-form">
            <div class="row m-2">
                <div class="col">
                    <input type="text" class="form-control" id="fname" name="firstName" placeholder="First name" value="${user.firstName}" required>
                </div>
                <div class="col">
                    <input type="text" class="form-control" id="lname" name="lastName" placeholder="Last name" value="${user.lastName}" required>
                </div>
            </div>
            <div class="row m-2">
                <div class="col">
                    <input type="text" class="form-control" id="email" name="email" placeholder="Email" value="${user.email}" required>
                </div>
            </div>
            <div class="row m-2">
                <div class="col">
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone" value="${user.phone}" required>
                </div>
            </div>
            <div class="row m-2">
                <div class="col">
                    <input type="password" class="form-control" id="pass" name="password" placeholder="Password" required>
                </div>
            </div>
            <div class="row m-2">
                <div class="col">
                    <button type="submit" class="btn-create-user btn btn-outline-success">Create</button>
                </div>
                <div class="col">
                    <a class="btn-back btn btn-outline-danger" href="/users">Back</a>
                </div>
            </div>
        </form>
    </div>
</div>
<c:import url="../template/footer.jsp"></c:import>
<!--Scripts-->
<script type="text/javascript" src="../../../resources/js/DTO/DTOUser.js"></script>
<script type="text/javascript" src="../../../resources/js/services/AJAXService.js"></script>
<script type="text/javascript" src="../../../resources/js/user/user_create.js"></script>
</body>

</html>