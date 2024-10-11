<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container w-50">
    <form action="controller" method="post">

        <input type="hidden" name="action" value="addProduct">

        <!-- Text input   Product ID-->
        <div class="form-group">
            <label class="control-label" for="product_id">product_id</label>
            <input id="product_id" name="product_id" class="form-control input-md" type="text" disabled>
        </div>

        <!-- Text input product_name-->
        <div class="form-group">
            <label class="control-label" for="product_name">product_name</label>
            <input id="product_name" name="product_name" class="form-control input-md" required="" type="text">
        </div>

        <!-- Textarea product_description-->
        <div class="form-group">
            <label class="control-label" for="product_description">product_description</label>
            <textarea class="form-control" id="product_description" name="product_description" ></textarea>
        </div>

        <!-- Text input image_path-->
        <div class="form-group">
            <label class="control-label" for="image_path">image_path</label>
            <input id="image_path" name="image_path" class="form-control input-md" required="" type="text">
        </div>

        <!-- Text input price-->
        <div class="form-group">
            <label class="control-label" for="price">price</label>
            <input id="price" name="price" class="form-control input-md" required="" type="text">
        </div>

        <!-- Text input note-->
        <div class="form-group">
            <label class="control-label" for="note">note</label>
            <input id="note" name="note" class="form-control input-md" required="" type="text">
        </div>

        <!-- Text input apply_date-->
<%--        <div class="form-group">--%>
<%--            <label class="control-label" for="apply_date">apply_date</label>--%>
<%--            <input id="apply_date" name="apply_date" class="form-control input-md" required="" type="text">--%>
<%--        </div>--%>

        <!-- Select input for status -->
        <div class="form-group">
            <label class="control-label" for="status">Status</label>
            <select id="status" name="status" class="form-control input-md" required="">
                <option value="1">Active</option>
                <option value="0">Inactive</option>
            </select>
        </div>

        <!-- Button -->
        <div class="form-group my-2">
            <button type="submit" class="btn btn-primary">Submit</button>
            <button class="btn btn-secondary">Clear</button>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
