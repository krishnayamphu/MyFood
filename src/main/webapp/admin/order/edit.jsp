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
        <h4>Order Detail</h4>
    </div>

    <form method="post" action="/myfood/admin/order-edit">
        <input type="hidden" name="id" value="${order.id}">
        <div class="row row-cols-1 row-cols-lg-2">
            <div class="col">
            <p>${food.id}</p>
                <p>${user.id}</p>
                <p>${total.id}</p>
                <p><p>${food.created_at}</p></p>
            </div>
            <div class="col">
                <label class="form-label">Status</label>
                <select name="status" id="">
                    <option value="0">Pending</option>
                    <option value="1">Complete</option>
                    <option value="2">Cancel</option>
                </select>

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
