<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <c:import url="../template/head.jsp"></c:import>
    <%--<link rel="stylesheet" href="../../../resources/css/style.css"/>--%>
<body>
<c:import url="../template/header.jsp"></c:import>

<%--modal-dialog--%>
<div class="modal fade" id="addmodal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modal">Training</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="type-id" class="col-form-label"> Choose Training Type: </label>
                        <select class="form-control" id="type-id" name="type-id">
                            <c:forEach items="${trainingtypes}" var="triningtype">
                                <c:choose>
                                    <c:when test="${triningtype.id == 1}">
                                        <option value="${triningtype.id}" selected>${triningtype.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${triningtype.id}">${triningtype.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" id="save" class="btn btn-primary">Save</button>
            </div>
        </div>
    </div>
</div>
<%--modal-dialog--%>

<div class="col-lg-12">
    <div class="text-center mt-4 mb-4">
        <h1>${filiation.caption} schedule</h1>
    </div>
    <input id="id" value="${filiation.id}" hidden/>
    <div class="table-responsive col-lg-12">
        <table class="table table-bordered mt-2" data-toggle="modal" data-target="#addmodal">
            <tr>
                <th>time</th>
                <c:forEach items="${days}" var="day">
                    <th>${day.name}</th>
                </c:forEach>
            </tr>
            <c:forEach items="${times}" var="time">
                <tr>
                    <td>${time.name}</td>
                    <c:forEach items="${days}" var="day">
                        <td id="${day.id}:${time.id}"></td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script src="../../../resources/js/DTO/DTOTraining.js" type="text/javascript"></script>
<script src="../../../resources/js/services/AJAXService.js" type="text/javascript"></script>
<script src="../../../resources/js/trainings/trainings.js" type="text/javascript"></script>
</body>
</html>
