<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="../head.jsp" %>
    <title>Manage Orders</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <div class="d-flex justify-content-between py-5">
        <h4>Order Management</h4>
    </div>
    <table class="table table-sm">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Food Name</th>
            <th scope="col">User</th>
            <th scope="col">Total</th>
            <th scope="col">Status</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <th scope="row">${order.id}</th>
                <td>${order.foodId}</td>
                <td>${order.userId}</td>
                <td>${order.total}</td>
                <td>
                    <c:choose>
                        <c:when test="${order.status==1}">Complete</c:when>
                        <c:when test="${order.status==2}">Cancel</c:when>
                        <c:otherwise>Pending</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <div class="d-flex">
                        <a class="btn btn-sm btn-outline-success me-3" href="/myfood/admin/order-edit?id=${order.id}">View</a>
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
