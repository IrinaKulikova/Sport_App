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
    <h1>Filiation ${filiation.caption}</h1>
    <form id="form" class="form mt-3 mb-5">
        <input type="text" id="id" value="${filiation.id}" name="id" hidden>
        <div class="row">
            <div class="col mt-2">
                <label for="caption">Caption: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="caption" class="form-control" readonly="true" value="${filiation.caption}" name="caption"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="country">Country: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="country" class="form-control" readonly="true" value="${filiation.country}" name="country"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="city">City: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="city" class="form-control" readonly="true" value="${filiation.city}" name="city"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="street">Street: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="street" class="form-control" readonly="true" value="${filiation.street}" name="street"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="building">Building: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="building" class="form-control" readonly="true" value="${filiation.building}" name="building"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="indexcity">Index: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="indexcity" class="form-control" readonly="true" value="${filiation.indexCity}" name="indexCity"
                       placeholder="Enter here...">
            </div>
        </div>
        <c:forEach items="${filiation.contacts}" var="contact">
            <div class="row mt-2">
                <div class="col mt-2">
                    <label>${contact.contactType.name}:</label>
                </div>
                <div class="col-md-6">
                    <input type="text" class="form-control" readonly="true" value="${contact.data}"
                           placeholder="Enter here...">
                </div>
                <div class="col-md-2">
                    <button value="${contact.id}" class="del btn text-center btn-outline-danger">Delete</button>
                </div>
            </div>
        </c:forEach>

        <%--скрытый блок для вставки нового контакта--%>
        <div class="row mt-2" id="insert" hidden>
            <div class="col mt-2">
                <label></label>
            </div>
            <div class="col-md-6">
                <input type="text" readonly="true" class="form-control">
            </div>
            <div class="col-md-2">
                <button class="del btn text-center btn-outline-danger">Delete</button>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col">
                <label for="contacts">Add contact</label>
            </div>
            <div class="col-md-8">
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <select id="contacts" class="form-control">
                            <c:forEach items="${contact_types}" var="ctype">
                                <option value="${ctype.id}">${ctype.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-8">
                        <div class="row-md-8">
                            <input type="text" placeholder="Enter here..." class="form-control" readonly="true" id="newcontact">
                        </div>
                    </div>
                    <div class="col-md-2">
                        <div class="row-md-2">
                            <button type="submit" id="add" value="${filiation.id}"
                                    class="btn text-center btn-outline-info mt-2">
                                Add
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="mt-4 row">
            <div class="col-md-12 text-center">
                <button type="submit" id="save" value="${filiation.id}" class="btn btn-outline-danger pl-5 pr-5">
                    Save
                </button>
            </div>
        </div>
    </form>
</div>
<c:import url="../template/footer.jsp"></c:import>
<!--Scripts-->
<script src="../../../resources/js/DTO/DTOFiliation.js" type="text/javascript"></script>
<script src="../../../resources/js/DTO/DTOContact.js" type="text/javascript"></script>
<script src="../../../resources/js/DTO/DTOContactType.js" type="text/javascript"></script>
<script src="../../../resources/js/services/AJAXService.js" type="text/javascript"></script>
<script src="../../../resources/js/filiation/filiation_edit.js" type="text/javascript"></script>
</body>
</html>
