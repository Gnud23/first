<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Update</title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <h3 class="text-center text-secondary mt-5 mb-3">Update Product</h3>
            <form class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light" action="./update" method="post">
                <div class="form-group">
                    <label for="pid">Id Product: </label>
                    <input id="pid" name="pid" type="text" class="form-control" placeholder="Id Product" value="<%=request.getAttribute("pId")%>">
                </div>
                <div class="form-group">
                    <label for="pname">Product's name:</label>
                    <input id="pname" name="pname" type="text" class="form-control" placeholder="Product's name" value="<%=request.getAttribute("pName")%>">
                </div>
                <div class="form-group">
                    <label for="pprice">Password:</label>
                    <input id="pprice" name="pprice" type="text" class="form-control" placeholder="Product's price" value="<%=request.getAttribute("pPrice")%>">
                </div>
                <div class="form-group">
                    <button class="btn btn-success px-5">Update</button>
                </div>
            </form>

        </div>
    </div> 
    </div>
</body>
</html>