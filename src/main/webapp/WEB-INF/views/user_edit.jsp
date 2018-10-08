<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <c:import url="template/head.jsp"></c:import>
</head>

<body>
<c:import url="template/header.jsp"></c:import>
<div class="container main-div mt-md-5">
    <div class="user-edit-div">
        <h2><strong>Edit user</strong></h2>
        <form>
            <div class="row mt-2">
                <div class="col">
                    <input type="text" class="form-control" id="fname" name="firstName" placeholder="First name" required readonly="true" value="${user.firstName}">
                </div>
                <div class="col">
                    <input type="text" class="form-control" id="lname" d="l" name="lastName" placeholder="Last name" required readonly="true" value="${user.lastName}">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col">
                    <input type="text" class="form-control" id="email" name="email" placeholder="Email" required readonly="true" value="${user.email}">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col">
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone" required readonly="true" value="${user.phone}">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col">
                    <input type="text" class="form-control" id="pass" name="password" placeholder="Password" required readonly="true">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col">
                    <button type="submit" class="btn-save-changes btn btn-outline-success" value="${user.id}">Save changes</button>
                </div>
                <div class="col">
                    <a class="btn-back btn btn-outline-danger" href="/users">Back</a>
                </div>
            </div>
        </form>
    </div>
</div>
<c:import url="template/footer.jsp"></c:import>
<!--Scripts-->
<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/jquery-ui/jquery-ui.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="../../resources/js/UserDTO.js"></script>
<script type="text/javascript">
    $(function () {
            $(".btn-save-changes").click(function (e) {
                    var btn = $(this);
                    var user = new User($('#fname').val(),
                        $('#lname').val(), $('#email').val(),
                        $('#phone').val(), $('#pass').val());

                    $.ajax({
                        type: 'PUT',
                        dataType: 'json',
                        url: "/api/1.0/users/"+btn.val(),
                        contentType: 'application/json; charset=utf-8',
                        data: JSON.stringify(user),
                        async: true,
                        success: function(result) {
                            location.replace("/users");
                        },
                        error: function(jqXHR, textStatus, errorThrown) {

                        }
                    });
                    e.preventDefault();
                }
            );


        }
    );
</script>
<script type="text/javascript">
    $(".form-control").dblclick(function (e) {
        $(this).attr("readonly",false);
    });
</script>
<script type="text/javascript">
    $(".form-control").blur(function (e) {
        $(this).attr("readonly",true);
    });
</script>
</body>

</html>