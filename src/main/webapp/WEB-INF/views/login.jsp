<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">

</head>

<body>
    <div class="container">
        <h1><strong>Login</strong></h1>
        <form class="form" enctype="multipart/form-data" role="form">
            <label for="input-login" class="col-sm-2">Username</label>
            <input type="text" name="login" id="input-login" class="form-control" required="required">
            <br/>
            <label for="input-password" class="col-sm-2">Password</label>
            <input type="password" name="password" id="input-password" class="form-control" required="required">
            <br/>
            <button class="btn btn-success" type="submit">Login</button>
        </form>
        
    </div>
    <script th:src="@{/webjars/jquery/jquery.min.js}"></script>
    <script th:src="@{/webjars/jquery-ui/jquery-ui.min.js}"></script>
    <script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
    <script>
        $(function() {
            $('.form').submit(function(e) {
                var $form = $(this);
                $.ajax({
                    type: 'POST',
                    url: '/login',
                    data: $form.serialize()
                }).done(function() {
                    location.replace('/');
                }).fail(function() {
                    alert('fail');
                });
                e.preventDefault();
            });
        });

    </script>
</body>

</html>
