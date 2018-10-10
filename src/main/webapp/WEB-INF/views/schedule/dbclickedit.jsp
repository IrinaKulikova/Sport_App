<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <meta charset="UTF-8"/>
    <title>Редактировать расписание</title>
    <style>
        form{width: 500px;margin:  0 auto;margin-top: 0px;}
    </style>
</head>
<body>
<%  String time=(String) request.getAttribute("time");%>
<form >
    <div class="form-group">
        <label for="sheduleevent">Событие</label>
        <select class="form-control" id="sheduleEvent" name="sheduleEvent" >
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
        <label for="week">День недели</label>
        <select class="form-control" id="week" name="day">
            <c:forEach items="${weekday}" var="days">
                <c:choose>
                    <c:when test="${days.id == schedule.day.id}">
                        <option value="${days.id}" selected>${days.nameDay}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${days.id}">${days.nameDay}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>
    <div class="form-row">
        <div class="form-group">
            <label for="starttime">Часы</label>

            <select  class="form-control" id="starttime" name="starttime" style="width: 120px"  >
                <% for(int i=8;i<=20;i++){
                    String str=i+":00";
                    if(time.equals(str)){%>
                <option value="<%=str%>" selected><%=str%></option>
                <%}else{%>
                <option value="<%=str%>"><%=str%></option>
                <%}%>
                <%}%>

            </select>
        </div>
        <div class="form-group">
            <!--   <label for="min">Минуты</label>
               <select class="form-control" id="min" name="min" style="width: 100px">
                   <option value="00" selected>00</option>
                   <option value="30">30</option>
               </select> -->
        </div>

    </div>
    <button type="submit" class="btn btn-primary">Зберегти</button>
</form>
<!--Scripts-->
<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/jquery-ui/jquery-ui.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/js/DTO/DTOSchedule.js"></script>
<script type="text/javascript" src="../../../resources/js/services/AJAXService.js"></script>
</body>
</html>

