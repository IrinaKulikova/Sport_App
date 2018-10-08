<%@ page import="application.entity.Schedule" %>
<%@ page import="java.util.List" %>
<%@ page import="application.entity.Day" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleks
  Date: 07.10.2018
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        .conteiner{
            width: 1000px;
            margin: auto;
          /*  text-align: center;*/
        }
        .td-tab{
            border: black 1px solid;
            height: 60px;
        }
        /*    td,th{
                border: black 1px solid;

            }*/
    </style>
</head>
<body>
<% List<Schedule> scheduleList=(List<Schedule>) request.getAttribute("schedulelist");%>
<% List<Day> dayList=(List<Day>) request.getAttribute("daylist");%>
<div class="conteiner">
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
       <tr>
           <th scope="row">8:00</th>
          <% for(int i=0;i<dayList.size();i++){%>
          <td data-time="8:00" data-week="monday"><%=scheduleList.get(i).getScheduleEvent().getName()%> <%--<% scheduleList.get(i).getScheduleEvent().getName(); %> --%></td>


         <%}%>


       </tr>

       </tbody>
   </table>
</div>
</body>
</html>
