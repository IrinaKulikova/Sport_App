<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="template/head.jsp"></c:import>
</head>

<body>
<c:import url="template/header.jsp"></c:import>
<div class="container main-div mt-3">
    <h1>Filiation ${filiation.caption}</h1>
    <form class="form mt-3 mb-5">
        <div class="row">
            <div class="col mt-2">
                <label for="caption">Caption: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="caption" class="form-control" value="${filiation.caption}"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="country">Country: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="country" class="form-control" value="${filiation.country}"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="city">City: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="city" class="form-control" value="${filiation.city}"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="street">Street: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="street" class="form-control" value="${filiation.street}"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="building">Building: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="building" class="form-control" value="${filiation.building}"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="indexcity">Index: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="indexcity" class="form-control" value="${filiation.indexCity}"
                       placeholder="Enter here...">
            </div>
        </div>
        <c:forEach items="${filiation.contacts}" var="contact">
            <div class="row mt-2">
                <div class="col mt-2">
                    <label>${contact.contactType.name}:</label>
                </div>
                <div class="col-md-8">
                    <input type="text" class="form-control" value="${contact.data}"
                           placeholder="Enter here...">
                </div>
            </div>
        </c:forEach>
        <div class="row mt-2">
            <div class="col">
                <label for="inputState">Add contact</label>
            </div>
            <div class="col-md-8">
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <select id="inputState" class="form-control">
                            <option selected>Choose...</option>
                            <c:forEach items="${contact_types}" var="ctype">
                                <option value="${ctype.id}">${ctype.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-8">
                        <div class="row-md-8">
                            <input type="text" placeholder="Enter here..." class="form-control" id="addcontact">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-outline-info mt-3 mb-5">Save</button>
    </form>

</div>
<c:import url="template/footer.jsp"></c:import>
<!--Scripts-->
<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/jquery-ui/jquery-ui.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</body>

</html>
