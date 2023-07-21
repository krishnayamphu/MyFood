<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="../head.jsp" %>
    <title>Edit Food</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <div class="d-flex justify-content-between py-5">
        <h4>Food Management</h4>
        <a class="btn btn-primary" href="food">All Foods</a>
    </div>

    <form method="post" action="/myfood/admin/food-edit">
        <input type="hidden" name="id" value="${food.id}">
        <div class="row row-cols-1 row-cols-lg-2">
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input type="text" class="form-control" name="name" value="${food.name}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Size</label>
                    <input type="text" class="form-control" name="size" value="${food.size}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Price</label>
                    <input type="number" class="form-control" name="price" value="${food.price}">
                </div>
            </div>
            <div class="col">
                <label class="form-label">Image</label>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" name="image" id="image" value="${food.image}">
                    <button class="btn btn-outline-secondary" type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">Choose</button>
                </div>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-xl">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>All Media Files</h4>
                                <c:choose>
                                    <c:when test="${!files.isEmpty()}">
                                        <div class="row row-cols-1 row-cols-lg-6">
                                            <c:forEach var="item" items="${allFiles}">
                                                <div class="col">
                                                    <div class="card">
                                                        <img data-bs-dismiss="modal" onclick="setImage('${item}')" class="img-fluid" src="/myfood/uploads/${item}" alt="">
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </c:when>
                                    <c:otherwise>No media files</c:otherwise>
                                </c:choose>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end Modal -->
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>


</div>

<%@ include file="../script.jsp" %>
<script>
    function setImage(image){
        document.getElementById("image").value=image;
    }
</script>
</body>
</html>
