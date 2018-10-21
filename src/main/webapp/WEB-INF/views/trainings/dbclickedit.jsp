<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <c:import url="../template/head.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<c:import url="../template/headerschedule.jsp"></c:import>
<% String time = (String) request.getAttribute("time");%>
<div class="conteiner">
    <form>
        <div class="form-group">
            <label for="sheduleevent">Event</label>
            <select class="form-control" id="sheduleevent" name="sheduleevent">
                <c:forEach items="${eventshedule}" var="sl">
                    <c:choose>
                        <c:when test="${sl.id==schedule.scheduleEvent.id}">
                            <option value="${sl.id}" selected>${sl.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${sl.id}">${sl.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div class="form-group" accept-charset="UTF-8">
            <label for="day">Day of week</label>
            <select class="form-control" id="day" name="day">
                <c:forEach items="${weekday}" var="days">
                    <c:choose>
                        <c:when test="${days.id == schedule.day.id}">
                            <option value="${days.id}" selected>${days.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${days.id}">${days.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div class="form-row">
            <div class="form-group">
                <label for="starttime">Time</label>
                <select class="form-control" id="starttime" name="starttime" style="width: 120px">
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
        <button type="submit" class="btn btn-primary" value="${schedule.id}">Save</button>
    </form>
</div>
<!--Scripts-->
<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/jquery-ui/jquery-ui.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/js/DTO/DTOSchedule.js"></script>
<script type="text/javascript" src="../../../resources/js/services/AJAXService.js"></script>
<script type="text/javascript" src="../../../resources/js/schedule/schedule_edit.js"></script>
</body>
</html>

