<%@ page import="application.entity.Schedule" %>
<%@ page import="java.util.List" %>
<%@ page import="application.entity.Day" %>
<%@ page import="application.helper.ScheduleSender" %>
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
        }
        .td-tab{
            border: black 1px solid;
            background-color: lightblue;
            height: 50px;
            position: relative;
            padding:5px;
        }
        td{
            padding: 2px !important;
        }
        .td-tab:hover::after{
            border: 1px solid #fc0;
            padding: 3px 6px;
            background: #fffea1;
            content: attr(data-title);
            position: absolute;
            left: 60px;
            top: 40px;
            z-index: 50;
        }
    </style>
</head>
<body>
<%  List<List<ScheduleSender>> scheduleListTable=( List<List<ScheduleSender>>) request.getAttribute("schedulelist");%>
<%-- <% List<Day> dayList=(List<Day>) request.getAttribute("daylist");%> --%>
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
        if(e.target.matches(".td-tab")) return //     alert("привет id="+e.target.dataset.id);
        if(e.target.matches("td")) return window.location.href="/schedules/dbclickcreate?time="+e.target.dataset.time+"&id="+e.target.dataset.week;// alert(e.target.dataset.time+" & "+e.target.dataset.week);
        //alert("привет");
      //  alert(e.target.dataset.time+" & "+e.target.dataset.week);
    });
</script>
</body>
</html>
