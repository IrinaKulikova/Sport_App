<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="template/head.jsp"></c:import>
</head>

<body>
<c:import url="template/header.jsp"></c:import>
<div class="container main-div mt-md-5">
    <c:import url="template/search.jsp"></c:import>
    <div>
        <table class="table table-bordered mt-2">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">Name</th>
                <th scope="col">Address</th>
                <th colspan="2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${filiation}" var="item">
                <tr>
                    <th scope="row">${item.id}</th>
                    <th scope="row">${item.caption}</th>
                    <th scope="row">${item.country} ${item.city} ${item.street} ${item.building}</th>
                    <td colspan="2">
                        <a href="/filiation/${item.id}">
                            <button class="btn btn-outline-info" name="id" type="submit" value="${item.id}">Edit
                            </button>
                        </a>
                        <button id="delete" class="btn btn-outline-danger ml-2" type="submit" value="${item.id}">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<c:import url="template/footer.jsp"></c:import>
<!--Scripts-->
<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/jquery-ui/jquery-ui.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</body>
<script type="text/javascript">
    $(function () {
        let button = $("#delete");
        $("#delete").click(function (e) {
            $.ajax({
                type: 'DELETE',
                url: "/api/1.0/filiation/" + button.val(),
            }).done(function () {
                alert('done!');
            }).fail(function () {
                alert('fail');
            });
            e.preventDefault();
        });
    });
</script>
</html>
