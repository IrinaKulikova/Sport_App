<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <c:import url="../template/head.jsp"></c:import>
    <link rel="stylesheet" href="../../../resources/css/style.css"/>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="col-lg-12">
    <div>
        <div class="text-center mt-4 mb-4">
            <h1>${filiation.caption} schedule</h1>
        </div>
        <div class="table-responsive col-lg-12">
            <table class="table table-bordered mt-2">
                <tr>
                    <th>time</th>
                    <c:forEach items="${days}" var="day">
                        <th>${day.name}</th>
                    </c:forEach>
                </tr>
                <c:forEach items="${times}" var="time">
                    <tr>
                        <td>${time.name}</td>
                        <c:forEach items="${days}" var="day">
                                <th id="${day.id}:${time.id}"></th>
                            </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script src="../../../resources/js/services/AJAXService.js" type="text/javascript"></script>
<script src="../../../resources/js/trainings/trainings.js" type="text/javascript"></script>
</body>
</html>
