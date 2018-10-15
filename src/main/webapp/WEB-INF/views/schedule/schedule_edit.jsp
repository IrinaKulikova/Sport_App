
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
    <div class="tools-div form-control text-center">
        <a class="btn btn btn-outline-primary m-2" href="/filiation">Main</a>
        <a class="btn btn-outline-success m-2" href="/schedules">Schedules</a>
        <a class="btn btn-outline-success m-2" href="/schedules/schedule_edit">Schedule</a>
        <a class="btn btn-outline-success m-2" href="/events">EventShedule</a>
        <a class="btn btn-outline-warning m-2" href="/schedules/save_shedule">Create</a>
    </div>
    <div class="us-div">
        <table class="table table-bordered mt-2">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Week</th>
                <th scope="col">Time</th>
                <th scope="col">Schelule</th>
                <th colspan="2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${schedule}" var="schedules">
                <tr>
                    <th scope="row">${schedules.numbersort}</th>
                    <td>${schedules.attributeDay}</td>
                    <td>${schedules.attributeTime}</td>
                    <td>${schedules.name}</td>
                    <td colspan="2">
                        <a class="btn-edit btn btn-outline-info m-2" href="/schedules//dbclickedit/${schedules.id}">Edit</a>
                        <button class="btn-delete btn btn-outline-danger m-2" name="id" value="${schedules.id}">Delete
                        </button>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
 <script type="text/javascript" src="../../../resources/js/services/AJAXService.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/js/schedule/schedule.js"></script>
</body>

</html>
