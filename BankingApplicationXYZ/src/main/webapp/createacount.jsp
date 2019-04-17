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
  <h2>CREATE ACCOUNT</h2>
  <form action="/xyzcompany/register" method = post>
    <div class="form-group">
      <label >Name:</label>
      <input  class="form-control" placeholder="Enter your Name" name="uname">
    </div>
    
    <div class="form-group">
      <label>DOB:</label>
      <input  class="form-control" placeholder="dd-mm-yyyy" name="dob">
    </div>
    
    
    <div class="form-group">
      <label>Password:</label>
      <input type="password" class="form-control"  placeholder="Type password" name="password">
    </div>
    
    <div class="form-group">
      <label>Re-Enter Password:</label>
      <input type="password" class="form-control"  placeholder="Re-type password" name="re-password">
    </div>
    
    <button type="submit" class="btn btn-default">Create Account</button>

    
  </form>
</div>

</body>
</html>

