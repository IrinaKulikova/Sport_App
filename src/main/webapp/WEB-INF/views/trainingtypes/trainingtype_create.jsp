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

    <form class="create-event-form" accept-charset="UTF-8">
        <h1>Training Type create</h1>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" placeholder="" name="name">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" placeholder="" name="description" row="5"></textarea>
        </div>
        <div class="mt-4 row">
            <div class="col-md-12 text-center">
                <button type="submit" id="save" class="btn btn-save-event btn-outline-danger pl-5 pr-5">
                    Save
                </button>
            </div>
        </div>
    </form>
</div>
<c:import url="../template/footer.jsp"></c:import>
<script src="../../../resources/js/services/FormsValidator.js" type="text/javascript"></script>
<script src="../../../resources/js/services/jquery.validate.js" type="text/javascript"></script>
<script src="../../../resources/js/services/AJAXService.js" type="text/javascript"></script>
<script src="../../../resources/js/DTO/DTOTrainingType.js" type="text/javascript"></script>
<script src="../../../resources/js/trainingtypes/trainingtype_create.js" type="text/javascript"></script>
</body>
</html>