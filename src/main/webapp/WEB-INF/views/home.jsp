<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Admin Panel</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <style type="text/css">
        body {
            padding-top: 5rem;
        }

        .ui-block>div,
        .ui-block>input {
            display: none;
        }

        .ui-block label {
            padding: 5px;
            border: 1px solid #aaa;
            line-height: 28px;
            cursor: pointer;
            position: relative;
            bottom: 1px;
            background: #fff;
        }

        .ui-block input[type="radio"]:checked+label {
            border-bottom: 2px solid #fff;
        }

        .ui-block>input:nth-of-type(1):checked~div:nth-of-type(1),
        .ui-block>input:nth-of-type(2):checked~div:nth-of-type(2),
        .ui-block>input:nth-of-type(3):checked~div:nth-of-type(3) {
            display: block;
            padding: 5px;
            border: 1px solid #aaa;
        }

        #user-block{
            border: 0px;
        }

    </style>
</head>


<body>

    <main role="main" class="container">

        <div class="container-fluid">
            <h1>Sport App</h1>
            <div class="ui-block">

                <input type="radio" name="main" checked="checked" id="tab1" /><label for="tab1">Users</label><input type="radio" name="main" id="tab2" /><label for="tab2">Cards</label><input type="radio" name="main" id="tab3" /><label for="tab3">News</label>
                <div id="user-block">
                        <table class="table table-dark">
                            <tr>
                                <th>ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Password</th>
                                <th></th>
                            </tr>
                            <form method="post" action="/createUser">
                                <tr id="user-create-tr">
                                    <td></td>
                                    <td><input type="text" name="firstName" required></td>
                                    <td><input type="text" name="lastName" required></td>
                                    <td><input type="email" name="email" required></td>
                                    <td><input type="text" name="phone" required></td>
                                    <td><input type="password" name="password" required></td>
                                    <td><input type="submit" value="Create user"></td>
                                </tr>
                            </form>
                            <c:forEach items="${users}" var="user">
                            <form method="post" action="/saveChanges">
                                <tr>
                                <td>${user.id}</td>
                                <td><input type="text" name="firstName" required value="${user.firstName}"></td>
                                <td><input type="text" name="lastName" required value="${user.lastName}"></td>
                                <td><input type="email" name="email" required value="${user.email}"></td>
                                <td><input type="text" name="phone" required value="${user.phone}"></td>
                                <td><input type="password" name="password" ></td>
                                <td><input type="submit" value="Save changes"></td>
                                </tr>
                            </form>
                            </c:forEach>
                        </table>
                </div>
                <div id="cards-block">

                </div>
                <div id="news-block">

                </div>
            </div>

        </div>


    </main><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>

</html>
