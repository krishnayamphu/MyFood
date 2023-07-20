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
        <a class="btn btn-primary" href="food">All Foods</a>
    </div>

    <form method="post" action="/myfood/admin/food-add">
        <div class="row row-cols-1 row-cols-lg-2">
            <div class="col">
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
            </div>
            <div class="col">
                <label class="form-label">Image</label>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" name="image">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">Choose</button>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>


</div>

<%@ include file="../script.jsp" %>
</body>
</html>
