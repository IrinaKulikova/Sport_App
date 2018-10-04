<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="template/head.jsp"></c:import>
</head>

<body>
    <c:import url="template/header.jsp"></c:import>
    <div class="container main-div max-margin">

    </div>
    <c:import url="template/footer.jsp"></c:import>
    <!--Scripts-->
    <script th:src="@{/webjars/jquery/jquery.min.js}"></script>
    <script th:src="@{/webjars/jquery-ui/jquery-ui.min.js}"></script>
    <script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</body>

</html>
