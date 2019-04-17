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
  <form action="/xyzcompany/transfer" method = "post">
    <div class="form-group">
      <label for="accntno">Enter amount to transfer from account ${user.accntno}:</label>
      <input  class="form-control" placeholder="Enter Amount" name="amount">
    </div>
    
    <div class="form-group">
      <label for="accntno">Enter the AccountId to transfer funds:</label>
      <input  class="form-control" placeholder="Enter Account Id" name="accntno">
    </div>
    
    <button type="submit" class="btn btn-default">Transfer</button>
    
  </form>
</div>

</body>
</html>

