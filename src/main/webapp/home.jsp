<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <style>
#slide{
    height: 300px;
}
#slide img{
    height: 300px !important;
    object-fit: cover;
}
    </style>
</head>
<body>
<%@ include file="header.jsp" %>
<section id="slide">
    <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="uploads/pic1.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="uploads/pic2.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="uploads/pic3.jpg" class="d-block w-100" alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</section>

<div class="container">
<h4 class="py-5">Foods</h4>
    <div class="row row-cols-1 row-cols-lg-4">
        <c:forEach var="food" items="${foods}">
            <div class="col">
                <div class="card">
                    <img src="uploads/${food.image}" alt="">
                    <div class="card-body">
                        <h4>${food.name}</h4>
                        <p>Size:${food.size}</p>
                        <p>NPR ${food.price}</p>
                        <form action="/myfood/orders" method="get">
                            <input type="hidden" name="id" value="${food.id}">
                            <button class="btn btn-outline-success" type="submit">Order</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>
