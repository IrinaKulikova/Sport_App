<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="../template/head.jsp"></c:import>
</head>

<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container main-div mt-3">
    <h1>Filiation create</h1>
    <form id="form" class="form mt-3 mb-5">
        <input type="text" id="id" name="id" hidden>
        <div class="row">
            <div class="col mt-2">
                <label for="caption">Caption: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="caption" class="form-control" name="caption"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="country">Country: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="country" class="form-control" name="country"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="city">City: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="city" class="form-control" name="city"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="street">Street: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="street" class="form-control" name="street"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="building">Building: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="building" class="form-control" name="building"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="row mt-2">
            <div class="col mt-2">
                <label for="indexcity">Index: </label>
            </div>
            <div class="col-md-8">
                <input type="text" id="indexcity" class="form-control" name="indexCity"
                       placeholder="Enter here...">
            </div>
        </div>
        <div class="mt-4 row">
            <div class="col-md-12 text-center">
                <button type="submit" id="save" class="btn btn-outline-danger pl-5 pr-5">
                    Save
                </button>
            </div>
        </div>
    </form>
</div>
<c:import url="../template/footer.jsp"></c:import>
<!--Scripts-->
<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/jquery-ui/jquery-ui.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</body>
<script src="../../../resources/js/DTOFiliation.js" type="text/javascript"></script>
<script src="../../../resources/js/DTOContact.js" type="text/javascript"></script>
<script src="../../../resources/js/DTOContactType.js" type="text/javascript"></script>

<script type="text/javascript">
    $(function () {
            let button = $("#save");
            $("#save").click(
                function (e) {
                    var newFiliation = new Filiation($('#id').val(),
                        $('#caption').val(), $('#country').val(),
                        $('#city').val(), $('#street').val(),
                        $('#building').val(), $('#indexcity').val());
                    console.log(newFiliation);
                    $.ajax({
                        type: 'POST',
                        dataType: 'json',
                        url: "/api/1.0/filiation/",
                        contentType: 'application/json; charset=utf-8',
                        data: JSON.stringify(newFiliation),
                        async: true,
                        success: function () {
                            $('#info').text("success");
                        },
                        error: function () {
                            $('#info').text("error");
                        }
                    });
                    e.preventDefault();
                }
            );
        }
    );
</script>
</html>
