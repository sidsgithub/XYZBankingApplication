<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <h3>the summary of your transaction is :</h3>
  
  <table class="table">
  <thead>
    <tr>
      <th scope="col">Transaction Id</th>
      <th scope="col">Transaction Type</th>
      <th scope="col">Balance</th>
    </tr>
  </thead>
  <tbody>
				<tr>
					<td>0</td>
					<td>No Transaction</td>
					<td>0.00</td>
				</tr>
  </tbody>
</table> 

 <a href = "../options.jsp">back</a>
</div>

</body>
</html>

