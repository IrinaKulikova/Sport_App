<%@ page import="application.entity.Training" %>
<%@ page import="java.util.List" %>
<%@ page import="application.entity.Day" %>
<%@ page import="application.dto.ScheduleSenderDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <head>
        <c:import url="../template/head.jsp"></c:import>
    </head>
    <link rel="stylesheet" href="../../../resources/css/style.css"/>
<body>
<c:import url="../template/header.jsp"></c:import>

<% List<List<ScheduleSenderDTO>> scheduleListTable = (List<List<ScheduleSenderDTO>>) request.getAttribute("schedulelist");%>
<div class="conteiner">
    <div class="container main-div mt-md-5" style="padding: 0px !important;">
        <div class="tools-div form-control text-center">
            <a class="btn btn btn-outline-primary m-2" href="/filiation">Main</a>
            <a class="btn btn-outline-success m-2" href="/schedules">Schedules</a>
            <a class="btn btn-outline-success m-2" href="/schedules/schedule_edit">Schedule</a>
            <a class="btn btn-outline-success m-2" href="/events">Event Schedule</a>
        </div>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col"></th>
            <c:forEach items="${daylist}" var="dayweek">
                <th scope="col">${dayweek.name}</th>
            </c:forEach>
        </tr>
        </thead>
        <tbody>
        <%for (int i = 0; i < scheduleListTable.size(); i++) {%>
        <tr>
            <% for (int j = 0; j < scheduleListTable.get(i).size(); j++) { %>
            <% if (j == 0) {%>
            <th scope="row"><%=scheduleListTable.get(i).get(j).getName()%>
            </th>
            <%} else {%>
            <td data-time=<%=scheduleListTable.get(i).get(j).getAttributeTime()%> data-week=<%=scheduleListTable.get(i).get(j).getAttributeDay()%>>
                <% if (scheduleListTable.get(i).get(j).getScheduleList() != null) {%>
                <% List<Training> scheduleList = scheduleListTable.get(i).get(j).getScheduleList(); %>
                <% for (int k = 0; k < scheduleList.size(); k++) {%>
                <div class="td-tab"
                     data-id=<%=scheduleList.get(k).getId()%> data-title='<%=scheduleList.get(k).getScheduleEvent().getDescription()%>'><%= scheduleList.get(k).getScheduleEvent().getName() %>
                </div>
                <%}%>
                <%}%>
            </td>
            <%}%>
            <%}%>
        </tr>
        <%}%>
        </tr>

        </tbody>
    </table>
</div>
<script>
    document.addEventListener('dblclick', function (e) {
        if (e.target.matches(".td-tab")) return window.location.href = "/trainings/dbclickedit/" + e.target.dataset.id;
        if (e.target.matches("td")) return window.location.href = "/trainings/dbclickcreate?time=" + e.target.dataset.time + "&id=" + e.target.dataset.week;// alert(e.target.dataset.time+" & "+e.target.dataset.week);
    });
</script>
</body>
</html>
