<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Home</title>

	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div class="border rounded w-100 mb-5 mt-5 mx-auto px-3 pt-3">
	<div class="container">
		<div class="row align-items-center">			
					<div class="col-md-3 col-lg-5 d-flex">
						<h2>Product Management</h2>
					</div>
					<div class="col-md-9 col-lg-7 d-flex flex-row-reverse">
						<h5>
							<span>Hello <span id="username" style="color:red;">
							<%
							      String name = (String) session.getAttribute("user");
							      out.print(name);
							  %></span>,</span>
							<a href="./logout"><span style="color:blue;">Log out</span></a>	
						</h5>
					</div>
				</div>
    <div class="row justify-content-start">
        <div class="col-md-3 col-lg-3">
            <h3 class="text-center text-secondary mt-5 mb-3">Add Product</h3>
            <form class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light" action="./homepage" method="post">
                <div class="form-group">
                    <label for="name-product">Name's product</label>
                    <input id="name-product" name="name-product" type="text" class="form-control" placeholder="Enter name's product">
                </div>
                <div class="form-group">
                    <label for="price-product">Price's product</label>
                    <input id="price-product" name="price-product" type="text" class="form-control" placeholder="Enter price's product">
                </div>
                <div class="form-group">
                    <button class="btn btn-success px-3 text-center">Add product</button>
                </div>
            </form>
            
            <%
            	String errorProduct = (String) session.getAttribute("errorProduct");
                out.println(errorProduct);
            %>

        </div>
        
        <div class="col-md-9 col-lg-9">
            <h3 class="text-secondary mt-5 mb-3">List Product</h3>
            <table class="table table-striped table-hover">
				  <thead>
					    <tr>
						      <th scope="col">Index</th>
						      <th scope="col">Name's product</th>
						      <th scope="col">Price</th>
						      <th scope="col">#Update</th>
						      <th scope="col">#Delete</th>
					    </tr>
				  </thead>
			  <tbody>
				<%
			    ArrayList<Product> lstProduct = (ArrayList<Product>) request.getAttribute("data");
				int num = 0;
		        for(Product p : lstProduct){
		        %>
		           		<tr id="row-<%=p.getpId()%>">
			            	<!-- <th scope="row" ><%=p.getpId()%></th> -->
			            	<th scope="row" ><%out.print(++num); %></th>
			                <td class="text-primary"><%=p.getpName()%></td>
			                <td><%=p.getpPrice()%></td>
			                <td class="text-primary">
			                	<a href="./update?pid=<%=p.getpId()%>" onclick="">Update</a>
			                </td>
			                <td class="text-primary">
			                	<a href="#" onclick="showMess(<%=p.getpId()%>)">Delete</a>
			                </td>
		            	</tr>
		        <%}%>
			  </tbody>
			</table>
        </div>
    </div> 
    </div>
    </div>
</div>
   
</body>
	<script type="text/javascript">
		function showMess(pid) {
			var option = confirm("Are you sure to delete?")
			if(option === true){
				window.location.href = "delete?pid="+pid
			}
		}
		
		var button = document.querySelector(".btn")
		button.onclick = function () {
		}
	</script>
</html>