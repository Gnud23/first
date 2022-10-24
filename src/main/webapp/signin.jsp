<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>

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
            <h3 class="text-center text-secondary mt-5 mb-3">I</h3>
            <form class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light" action="./signin" method="post">
                <div class="form-group">
                    <label for="name">Your name: </label>
                    <input id="name" name="name" type="text" class="form-control" placeholder="Your name">
                </div>
                <div class="form-group">
                    <label for="username">User name:</label>
                    <input id="username" name="username" type="text" class="form-control" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" name="password" type="password" class="form-control" placeholder="Password">
                </div>
                <div class="form-group">
                    <label for="confirm-pass">Confirm Password:</label>
                    <input id="confirm-pass" name="confirm-pass" type="password" class="form-control" placeholder="Confirm Password">
                </div>
                <div class="form-group">
                    <button class="btn btn-success px-5">Sign in</button>
                </div>
                <div class="form-group">
                    <p>You have account!!! <a href="./login">Click here</a></p>
                </div>
            </form>

        </div>
    </div> 
    </div>
    
</body>
</html>