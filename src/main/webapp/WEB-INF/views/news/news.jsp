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
        <a class="btn btn-outline-warning ml-2" href="/news/create">Create</a>
    </div>
    <div class="news-div">
        <table class="table table-bordered mt-2">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">Date</th>
                <th colspan="2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${news}" var="item">
                <tr>
                    <th scope="row">${item.id}</th>
                    <td>${item.title}</td>
                    <td>${item.date}</td>

                    <td colspan="2">
                        <a class="btn-edit btn btn-outline-info m-2" href="/news/edit/${item.id}">Edit</a>
                        <button class="btn-delete btn btn-outline-danger m-2" name="id" value="${item.id}" >Delete</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/js/services/AJAXService.js"></script>
<script type="text/javascript" src="../../../resources/js/news/news.js"></script>
</body>
</html>
