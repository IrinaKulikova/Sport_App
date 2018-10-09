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
    <h1>Event ${event.name}</h1>
    <form method="post" accept-charset="UTF-8">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" placeholder="" value="${event.name}" name="name">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" placeholder="" name="description"
                      row="5">${event.description}</textarea>
        </div>
        <div class="mt-4 row">
            <div class="col-md-12 text-center">
                <button type="submit" id="save" value="${event.id}" class="btn btn-outline-danger pl-5 pr-5">
                    Save
                </button>
            </div>
        </div>
    </form>
</div>
<script src="../../../resources/js/services/AJAXService.js" type="text/javascript"></script>
<script src="../../../resources/js/DTO/DTOEvent.js" type="text/javascript"></script>
<script src="../../../resources/js/events/event_edit.js" type="text/javascript"></script>
</body>
</html>