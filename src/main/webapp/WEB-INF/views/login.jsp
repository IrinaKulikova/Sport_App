<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <c:import url="template/head.jsp"></c:import>
</head>

<body>
<div class="container mt-5">
    <h2><strong>SportApp Control Panel</strong></h2>
    <form class="form-login mt-3" enctype="multipart/form-data" role="form">
        <input type="text" name="login" id="input-login" class="form-control" required placeholder="Login">
        <br/>
        <input type="password" name="password" id="input-password" class="form-control" required placeholder="Password">
        <br/>
        <button class="btn btn-success" type="submit">Login</button>
    </form>
</div>
<script src="/resources/js/login/login.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        $('.form-login').submit(function (e) {
            let $form = $(this);
            $.ajax({
                type: 'POST',
                url: '/login',
                data: $form.serialize()
            }).done(function () {
                location.replace('/');
            }).fail(function () {
                alert('fail');
            });
            e.preventDefault();
        });
    });
</script>
</body>
</html>