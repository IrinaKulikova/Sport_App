<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <c:import url="../template/head.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<% String time = (String) request.getAttribute("time");%>
<div class="conteiner">
    <c:import url="../template/headerschedule.jsp"></c:import>
    <form method="post" action="/schedules/save_shedule" accept-charset="UTF-8">
        <div class="form-group">
            <label for="sheduleevent">Event</label>
            <select class="form-control" id="sheduleEvent" name="sheduleEvent"> -->
                <c:forEach items="${eventshedule}" var="schedule">
                    <option value="${schedule.id}">${schedule.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group" accept-charset="UTF-8">
            <label for="week">Day of week</label>
            <select class="form-control" id="week" name="day">
                <c:forEach items="${weekday}" var="day">
                    <c:choose>
                        <c:when test="${day.id == idday}">
                            <option value="${day.id}" selected>${day.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${day.id}">${day.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div class="form-row">
            <div class="form-group">
                <label for="starttime">Time</label>
                <select class="form-control" id="starttime" name="starttime" style="width: 100px">
                    <% for (int i = 8; i <= 20; i++) {
                        String str = i + ":00";
                        if (time.equals(str)) {%>
                    <option value="<%=str%>" selected><%=str%>
                    </option>
                    <%} else {%>
                    <option value="<%=str%>"><%=str%>
                    </option>
                    <%}%>
                    <%}%>
                </select>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>
