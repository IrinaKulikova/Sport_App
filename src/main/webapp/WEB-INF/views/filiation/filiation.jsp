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
    <div class="tools-div form-inline form-control">
        <c:import url="../template/search.jsp"></c:import>
        <a class="btn btn-outline-warning ml-2" href="./filiation/create">Create</a>
    </div>
    <div>
        <table class="table table-bordered mt-2">
            <thead>
            <tr>
                <th scope="col">#</th>
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
                            <button class="btn btn-outline-info m-2" name="id" type="submit" value="${item.id}">Edit
                            </button>
                        </a>
                        <button class="btn btn-outline-danger m-2 del" type="submit" value="${item.id}">
                            Delete
                        </button>
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
</body>
<script type="text/javascript">
    $(function () {

        $("#reloading").attr('href', '/filiation/0');

        $(".del").click(function (e) {
            $del = $(this);
            $.ajax({
                type: 'DELETE',
                url: "/api/1.0/filiation/" + $del.val(),
                success: function () {
                    $del.parent().parent().remove();
                    console.log('done!');
                },
                error: function () {
                    console.log('fail');
                }
            });
            e.preventDefault();
        });
    });
</script>
</html>
