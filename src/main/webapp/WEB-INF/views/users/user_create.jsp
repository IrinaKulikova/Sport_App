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
    <div class="user-edit-div">
        <h2><strong>Create user</strong></h2>
        <form class="create-form">
            <div class="row mt-2">
                <div class="col">
                    <input type="text" class="form-control" name="firstName" placeholder="First name" required value="${user.firstName}">
                </div>
                <div class="col">
                    <input type="text" class="form-control" name="lastName" placeholder="Last name" required value="${user.lastName}">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col">
                    <input type="text" class="form-control" name="email" placeholder="Email" required value="${user.email}">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col">
                    <input type="text" class="form-control" name="phone" placeholder="Phone" required value="${user.phone}">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col">
                    <input type="password" class="form-control" name="password" placeholder="Password" required>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col">
                    <button type="submit" class="btn-create-user btn btn-outline-success">Create</button>
                </div>
                <div class="col">
                    <a class="btn-back btn btn-outline-danger" href="/users">Back</a>
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
<script type="text/javascript">
    $(function () {
        $('.create-form').submit(function(e) {
            var $form = $(this);
            $.ajax({
                type: 'POST',
                url: '/api/1.0/users',
                data: $form.serialize()
            }).done(function() {
                location.replace('/users');
            }).fail(function() {
                alert('fail');
            });
            e.preventDefault();
        });
    });
</script>
</body>

</html>