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
    <div class="tools-div form-control" style="height: 60px">
        <a class="btn btn btn-outline-primary ml-2" href="/filiation">Main</a>
        <a class="btn btn-outline-success" href="/schedules">Schedules</a>
        <a class="btn btn-outline-success" href="/schedules/schedule_edit">Schedule</a>
        <a class="btn btn-outline-success" href="/events">EventShedule</a>
        <a class="btn btn-outline-warning ml-2" href="/events/create">Create</a>
    </div>
    <div>
        <table class="table table-bordered mt-2">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
                <th colspan="2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${events}" var="item">
                <tr>
                    <th scope="row">${item.id}</th>
                    <td scope="row">${item.name}</td>
                    <td scope="row">${item.description}</td>
                    <td colspan="2">
                        <a href="/events/${item.id}">
                            <button class="btn btn-outline-info m-2" name="id" type="submit" value="${item.id}">Edit
                            </button>
                        </a>
                        <button class="btn btn-outline-danger m-2 del" type="submit" value="${item.id}">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<c:import url="../template/footer.jsp"></c:import>
<!--Scripts-->
<script src="../../../resources/js/services/AJAXService.js" type="text/javascript"></script>
<script src="../../../resources/js/events/events.js" type="text/javascript"></script>
</body>
</html>
