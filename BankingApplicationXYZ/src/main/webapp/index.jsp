<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>WELCOME TO XYZ COMPANY</h2>
  <form action="/xyzcompany/login" method = post>
    <div class="form-group">
      <label for="accntno">Account No:</label>
      <input  class="form-control" placeholder="Enter Account Number" name="accntno">
    </div>
    
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control"  placeholder="Enter password" name="password">
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
    <a href = "../createacount.jsp">Create account?</a>
    
  </form>
</div>

</body>
</html>


 
 