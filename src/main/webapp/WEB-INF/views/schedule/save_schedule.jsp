<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <c:import url="../template/head.jsp"></c:import>
    <style>
        .conteiner, form{width: 500px;margin:  0 auto;margin-top: 0px;}
    </style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<c:import url="../template/headerschedule.jsp"></c:import>

<form  method="post" accept-charset="UTF-8">
    <div class="form-group">
        <label for="sheduleevent">Event</label>
        <select class="form-control" id="sheduleEvent" name="sheduleEvent" >
            <c:forEach items="${eventshedule}" var="schedule">
                <option value="${schedule.id}">${schedule.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group" accept-charset="UTF-8">
        <label for="week">Day of week</label>
        <select class="form-control" id="week" name="day">
            <c:forEach items="${weekday}" var="day">
                <option value="${day.id}">${day.nameDay}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-row">
        <div class="form-group">
            <label for="starttime">Time</label>
            <select  class="form-control" id="starttime" name="starttime" style="width: 100px"  >
                <c:forEach var="i" begin="8" end="20">
                    <option value="${i}:00">${i}:00</option>
                </c:forEach>

            </select>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Save</button>
</form>
</body>
</html>
