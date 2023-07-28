<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="../head.jsp" %>
    <title>Order Confirmation</title>
</head>
<body>

<div class="container">
    <h4>Order Details</h4>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Food Name</th>
            <th scope="col">Image</th>
            <th scope="col">Total</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">${food.name}</th>
                <td><img height="50px" src="/myfood/uploads/${food.image}" alt=""></td>
                <td>${food.price}</td>
                <td>
                    <div class="d-flex">
                        <form action="/myfood/admin/food" method="post">
                            <input type="hidden" name="id" value="${food.id}">
                            <button class="btn btn-outline-success" type="submit">Order</button>
                        </form>
                    </div>

                </td>
            </tr>
        </tbody>
    </table>
</div>

<%@ include file="../script.jsp" %>
</body>
</html>
