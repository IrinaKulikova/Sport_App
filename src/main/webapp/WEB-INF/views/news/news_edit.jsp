<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <c:import url="../template/head.jsp"></c:import>
</head>

<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container main-div mt-md-5">
    <div class="news-edit-div">
        <h2><strong>Edit news</strong></h2>
        <form class="edit-news-form">
            <div class="row m-2">
                <div class="col">
                    <input type="text" class="form-control" id="date" name="date" placeholder="Date name" readonly="true" value="${news.date}">
                </div>
                <div class="col">
                    <input type="text" class="form-control" id="title" name="title" placeholder="Title" readonly="true" value="${news.title}">
                </div>
            </div>
            <div class="row m-2">
                <div class="col">
                    <textarea type="text" class="form-control" id="description" name="description" placeholder="Description" readonly="true">${news.description}</textarea>
                </div>
            </div>
            <div class="row m-2">
                <div class="col">
                    <img src="${news.imageURL}" id="news_image" alt="image news" width="250px" height="250px">
                </div>
                <div class="col">
                    <input type="text" class="form-control" id="imageURL" name="imageURL" placeholder="ImageURL" readonly="true" value="${news.imageURL}">
                </div>
                <div class="col">
                    <button type="button" class="btn-update-img btn btn-outline-dark">+</button>
                </div>
            </div>
            <div class="row m-2">
                <div class="col">
                    <button type="submit" class="btn-save-changes btn btn-outline-success" value="${news.id}">Save changes</button>
                </div>
            </div>
        </form>
    </div>
</div>
<c:import url="../template/footer.jsp"></c:import>
<!--Scripts-->

<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/jquery-ui/jquery-ui.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/js/services/FormsValidator.js"></script>
<script type="text/javascript" src="../../../resources/js/services/jquery.validate.js"></script>
<script type="text/javascript" src="../../../resources/js/DTO/DTONews.js"></script>
<script type="text/javascript" src="../../../resources/js/services/AJAXService.js"></script>
<script type="text/javascript" src="../../../resources/js/news/news_edit.js"></script>
</body>

</html>