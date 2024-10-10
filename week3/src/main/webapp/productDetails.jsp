<%@ page import="vn.edu.iuh.fit.week3.backend.repositories.entities.Product" %>
<%@ page import="vn.edu.iuh.fit.week3.backend.business.ProductBeanRemote" %>
<%@ page import="jakarta.ejb.EJB" %>
<%@ page import="vn.edu.iuh.fit.week3.backend.repositories.entities.ProductPrice" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="Product Details" />
    <meta name="author" content="Your Name" />
    <title>Product Details</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>

<div class="container my-5">
    <h1>Product Details</h1>

    <!-- Nhận đối tượng Product từ Servlet -->
    <%
        Product product = (Product) request.getAttribute("product");
        List<ProductPrice> productPrices = (List<ProductPrice>) request.getAttribute("productPrices");
//        ProductPrice productPrice = (ProductPrice) vector.get(index);

    %>

</div>

<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="#!">Product Details</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                <li class="nav-item"><a class="nav-link" href="#!">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- Product Detail Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <!-- Product Image -->
            <div class="col-md-6">
                <img class="img-fluid" src="https://bmwmiennam.vn/wp-content/uploads/2021/11/BMW-X5-Msport-2.jpg" alt="Product Image" />
            </div>
            <!-- Product Information -->
            <div class="col-md-6">

                <h1 class="display-5 fw-bolder" id="product-name">${product.name}</h1>

                <p class="lead" id="product-id">Product ID: ${product.id}</p>

                <p class="lead" id="product-desc">${product.description}</p>

                <p class="lead" id="product-status">Status: <span class="text-success">${product.status}</span></p>

                <!-- Product Prices -->
                <div class="fs-5 mb-5">
                    <span class="text-decoration-line-through" id="old-price">${productPrices[1].value}</span>
                    <span class="text-danger" id="new-price">${productPrices[0].value}</span>
                </div>

                <!-- Action Buttons -->
                <div class="d-flex">
                    <button class="btn btn-outline-dark flex-shrink-0" type="button">
                        <i class="bi-cart-fill me-1"></i>
                        Add to cart
                    </button>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
