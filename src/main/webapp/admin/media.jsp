<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="head.jsp" %>
    <title>All Media Files</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container py-5">
    <form method="post" enctype="multipart/form-data" action="/myfood/admin/media">
        <div class="input-group">
            <input type="file" class="form-control" name="upfile">
            <button class="btn btn-outline-secondary" type="submit">Upload</button>
        </div>
    </form>

    <hr>

    <h4>All Media Files</h4>
    <c:choose>
        <c:when test="${!files.isEmpty()}">
            <div class="row row-cols-1 row-cols-lg-6">
                <c:forEach var="item" items="${allFiles}">
                    <div class="col">
                        <div class="card">
                            <a href="/myfood/uploads/${item}">
                                <img class="img-fluid" src="/myfood/uploads/${item}" alt="">
                            </a>
                            <form class="d-flex justify-content-center my-2" action="media-del" method="post">
                                <input type="hidden" name="image" value="${item}">
                                <button class="btn btn-sm btn-outline-danger" type="submit">Remove</button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>No media files</c:otherwise>
    </c:choose>


</div>

<%@ include file="script.jsp" %>
</body>
</html>
