<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="../head.jsp" %>
    <title>Manage Food</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <div class="d-flex justify-content-between py-5">
        <h4>Food Management</h4>
        <a class="btn btn-primary" href="food-add">Add Food</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Food Name</th>
            <th scope="col">Size</th>
            <th scope="col">Price</th>
            <th scope="col">Image</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="food" items="${foods}">
            <tr>
                <th scope="row">${food.id}</th>
                <td>${food.name}</td>
                <td>${food.size}</td>
                <td>${food.price}</td>
                <td>${food.image}</td>
                <td>
                    <div class="d-flex">
                        <a class="btn btn-outline-success me-3" href="">Edit</a>
                        <form action="/myfood/admin/food" method="post">
                            <input type="hidden" name="id" value="${food.id}">
                            <button class="btn btn-outline-danger" type="submit">Delete</button>
                        </form>
                    </div>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="../script.jsp" %>
</body>
</html>
