<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleks
  Date: 06.10.2018
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <meta charset="UTF-8"/>
    <title>Добавить Расписание</title>
    <style>
        form{width: 500px;margin:  0 auto;margin-top: 0px;}
    </style>
</head>
<body>
<!--<button class="btn btn-primary">Добавить событие</button> -->
<form  method="post" accept-charset="UTF-8">
    <div class="form-group">
        <label for="sheduleevent">Событие</label>
        <select class="form-control" id="sheduleevent" name="event_schedule" >
            <c:forEach items="${eventshedule}" var="schedule">
                <option value="${schedule.id}">${schedule.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group" accept-charset="UTF-8">
        <label for="week">День недели</label>
        <select class="form-control" id="week" name="day">
            <c:forEach items="${weekday}" var="day">
                <option value="${day.id}">${day.nameDay}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-row">
        <div class="form-group">
            <label for="hour">Часы</label>
            <select multiple class="form-control" id="hour" name="hour" style="width: 100px"  >
                <c:forEach var="i" begin="8" end="20">
                    <option value="${i}:00">${i}:00</option>
                </c:forEach>

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
    <button type="submit" class="btn btn-primary">Sign in</button>
</form>
</body>
</html>
