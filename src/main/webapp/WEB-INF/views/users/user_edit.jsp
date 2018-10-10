<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <c:import url="../template/head.jsp"></c:import>
</head>

<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container main-div mt-md-5">
    <div class="user-edit-div">
        <h2><strong>Edit user</strong></h2>
        <form>
            <div class="row m-2">
                <div class="col">
                    <input type="text" class="form-control" id="fname" name="firstName" placeholder="First name" readonly="true" value="${user.firstName}">
                </div>
                <div class="col">
                    <input type="text" class="form-control" id="lname" name="lastName" placeholder="Last name" readonly="true" value="${user.lastName}">
                </div>
            </div>
            <div class="row m-2">
                <div class="col">
                    <input type="text" class="form-control" id="email" name="email" placeholder="Email" readonly="true" value="${user.email}">
                </div>
            </div>
            <div class="row m-2">
                <div class="col">
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone" readonly="true" value="${user.phone}">
                </div>
            </div>
            <div class="row m-2">
                <div class="col">
                    <input type="password" class="form-control" id="pass" name="password" placeholder="Password" readonly="true">
                </div>
            </div>
            <div class="row m-2">
                <div class="col">
                    <button type="submit" class="btn-save-changes btn btn-outline-success" value="${user.id}">Save changes</button>
                </div>
                <div class="col">
                    <a class="btn-back btn btn-outline-danger" href="/users">Back</a>
                </div>
            </div>
        </form>
        <div class="card-edit-div m-2">
            <h3><strong>User cards</strong></h3>
            <form>
                <div class="row ml-2">
                    <select id="selectId" name="id">
                        <option value="-1">New card</option>
                        <c:forEach items="${cards}" var="card">
                            <option value="${card.id}">${card.description}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="row m-2">
                    <div class="col">
                        <input type="text" class="form-control" id="description" name="description" placeholder="Description" readonly="true">
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" id="issueDate" name="issueDate" placeholder="Issue date" readonly="true">
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" id="expirationDate" name="expirationDate" placeholder="Expiration date" readonly="true">
                    </div>
                </div>
                <div class="row m-2">
                    <div class="col">
                        <button type="submit" class="btn-save-card btn btn-outline-success" value="${user.id}">Save card</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<c:import url="../template/footer.jsp"></c:import>
<!--Scripts-->
<script type="text/javascript" src="../../../resources/js/DTO/DTOUser.js"></script>
<script type="text/javascript" src="../../../resources/js/services/AJAXService.js"></script>
<script type="text/javascript" src="../../../resources/js/user/user_edit.js"></script>
</body>

</html>