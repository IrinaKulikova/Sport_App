<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="../template/head.jsp"></c:import>
</head>

<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container main-div mt-md-5">
    <div class="user-edit-div">
        <h2><strong>Create user</strong></h2>
        <form class="create-user-form">
            <div class="row m-2">
                <div class="col">
                    <input type="text" class="form-control" id="fname" name="firstName" placeholder="First name" required>
                </div>
                <div class="col">
                    <input type="text" class="form-control" id="lname" name="lastName" placeholder="Last name" required>
                </div>
            </div>
            <div class="row m-2">
                <div class="col">
                    <input type="text" class="form-control" id="email" name="email" placeholder="Email" required>
                </div>
            </div>
            <div class="row m-2">
                <div class="col">
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone" required>
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
            </div>
        </form>
    </div>
</div>
<c:import url="../template/footer.jsp"></c:import>
<!--Scripts-->
<script type="text/javascript" src="../../../resources/js/services/FormsValidator.js"></script>
<script type="text/javascript" src="../../../resources/js/services/jquery.validate.js"></script>
<script type="text/javascript" src="../../../resources/js/DTO/DTOUser.js"></script>
<script type="text/javascript" src="../../../resources/js/services/AJAXService.js"></script>
<script type="text/javascript" src="../../../resources/js/users/user_create.js"></script>
</body>

</html>