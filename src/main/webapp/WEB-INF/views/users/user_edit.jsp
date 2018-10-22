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
        <form class="user-form">
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
            </div>
        </form>
        <div class="card-edit-div m-2">
            <input type="text" id="userId" value="${user.id}" hidden>
            <h3><strong>User cards</strong></h3>
            <form class="card-form">
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
                    <div class="col">
                        <input type="password" class="form-control" id="pinCode" name="pinCode" placeholder="Pin code" pattern="\d{4}" readonly="true">
                    </div>
                </div>
                <div class="row m-2">
                    <div class="col">
                        <button type="submit" class="btn-save-card btn btn-outline-success" id="id" value="${user.id}">Save card</button>
                    </div>
                </div>
            </form>
                <table class="table table-bordered mt-2">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Issue Date</th>
                        <th scope="col">Expiration Date</th>
                        <th scope="col">Description</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cards}" var="card">
                        <c:if test="${card.user.id == user.id}">
                        <tr>
                            <th scope="row">${card.id}</th>
                            <td>${card.issueDate}</td>
                            <td>${card.expirationDate}</td>
                            <td>${card.description}</td>
                            <td>
                                <button class="btn-del-card btn btn-outline-danger m-2" name="id" value="${card.id}">Delete</button>
                            </td>
                        </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
        </div>
    </div>
</div>
<c:import url="../template/footer.jsp"></c:import>
<!--Scripts-->
<script type="text/javascript" src="../../../resources/js/services/FormsValidator.js"></script>
<script type="text/javascript" src="../../../resources/js/services/jquery.validate.js"></script>
<script type="text/javascript" src="../../../resources/js/DTO/DTOCard.js"></script>
<script type="text/javascript" src="../../../resources/js/DTO/DTOUser.js"></script>
<script type="text/javascript" src="../../../resources/js/services/AJAXService.js"></script>
<script type="text/javascript" src="../../../resources/js/users/user_edit.js"></script>
<script type="text/javascript" src="../../../resources/js/users/card.js"></script>
</body>

</html>