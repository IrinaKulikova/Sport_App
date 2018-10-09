<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="../template/head.jsp"></c:import>
</head>

<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container main-div mt-md-5">
    <div class="tools-div form-control text-right">
        <a class="btn btn-outline-warning ml-2" href="./admins/create">Create</a>
    </div>
    <div>
        <table class="table table-bordered mt-2">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Login</th>
                <th scope="col">Email</th>
                <th colspan="2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${admins}" var="admin">
                <tr>
                    <th scope="row">${admin.id}</th>
                    <td scope="row">${admin.login}</td>
                    <td scope="row">${admin.email}</td>
                    <td colspan="2">
                        <c:set var="current" scope="session" value="${login}"/>
                        <c:choose>
                            <c:when test="${admin.login!=current}">
                                <button class="btn btn-outline-danger m-2 del" type="submit" value="${admin.id}">
                                    Delete
                                </button>
                            </c:when>
                            <c:otherwise>
                                <a href="/admins/${admin.id}">
                                    <button class="btn btn-outline-info m-2" name="id" type="submit"
                                            value="${admin.id}">
                                        Edit
                                    </button>
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<c:import url="../template/footer.jsp"></c:import>
<!--Scripts-->
<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/jquery-ui/jquery-ui.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="../../../resources/js/services/AJAXService.js" type="text/javascript"></script>
<script src="../../../resources/js/admins/admins.js" type="text/javascript"></script>
</body>
</html>

