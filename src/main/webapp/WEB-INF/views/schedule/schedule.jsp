<%@ page import="application.entity.Schedule" %>
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

<%  List<List<ScheduleSenderDTO>> scheduleListTable=( List<List<ScheduleSenderDTO>>) request.getAttribute("schedulelist");%>
<div class="conteiner">
    <div class="container main-div mt-md-5" style="padding: 0px !important;">
        <div class="tools-div form-control">
            <a class="btn btn btn-outline-primary ml-2" href="/filiation">Main</a>
            <a class="btn btn-outline-success" href="/schedules">Schedules</a>
            <a class="btn btn-outline-success" href="/schedules/schedule_edit">Schedule</a>
            <a class="btn btn-outline-success" href="/events">EventShedule</a>
        </div>
    </div>
   <table class="table table-bordered">
     <thead>
     <tr>
         <th scope="col"></th>
         <c:forEach items="${daylist}" var="dayweek">
             <th scope="col">${dayweek.nameDay}</th>
         </c:forEach>
     </tr>
     </thead>
       <tbody>
       <%for (int i=0;i<scheduleListTable.size();i++){%>
       <tr>
          <% for( int j=0;j<scheduleListTable.get(i).size();j++){ %>
            <% if(j==0){%>
                   <th scope="row"><%=scheduleListTable.get(i).get(j).getName()%></th>
               <%}else{%>
                   <td data-time= <%=scheduleListTable.get(i).get(j).getAttributeTime()%> data-week=<%=scheduleListTable.get(i).get(j).getAttributeDay()%>>
                 <%  if(scheduleListTable.get(i).get(j).getScheduleList()!=null){%>
                    <%   List<Schedule> scheduleList=scheduleListTable.get(i).get(j).getScheduleList(); %>
                       <% for (int k=0;k<scheduleList.size();k++){%>
                       <div class="td-tab" data-id=<%=scheduleList.get(k).getId()%> data-title='<%=scheduleList.get(k).getScheduleEvent().getDescription()%>'  ><%= scheduleList.get(k).getScheduleEvent().getName() %></div>
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
    document.addEventListener('dblclick',function (e){
        if(e.target.matches(".td-tab")) return  window.location.href="/schedules/dbclickedit/"+e.target.dataset.id;
        if(e.target.matches("td")) return window.location.href="/schedules/dbclickcreate?time="+e.target.dataset.time+"&id="+e.target.dataset.week;// alert(e.target.dataset.time+" & "+e.target.dataset.week);
    });
</script>
</body>
</html>
