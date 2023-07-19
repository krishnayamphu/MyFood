<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="../head.jsp" %>
    <title>Create Food</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <div class="d-flex justify-content-between py-5">
        <h4>Food Management</h4>
        <a class="btn btn-primary" href="#">All Foods</a>
    </div>

    <form method="post" action="food-add">
        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="mb-3">
            <label class="form-label">Size</label>
            <input type="text" class="form-control" name="size">
        </div>
        <div class="mb-3">
            <label class="form-label">Price</label>
            <input type="number" class="form-control" name="price">
        </div>
        <div class="mb-3">
            <label class="form-label">Image</label>
            <input type="text" class="form-control" name="image">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>


</div>

<%@ include file="../script.jsp" %>
</body>
</html>
