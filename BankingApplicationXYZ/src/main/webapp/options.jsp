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
  <h4>The following banking options are available:</h4>
    <a href = "../xyzcompany/showbalance/${user.accntno}">Show Balance</a>
    <br>
    <a href = "../xyzcompany/deposit/${user.accntno}">Deposit</a>
    <!--<a href = "../deposit.jsp">Deposit</a>-->
    <br>
    <a href = "../xyzcompany/withdraw/${user.accntno}">Withdraw</a>
    <br>
    <a href = "../xyzcompany/transfer/${user.accntno}">Fund Transfer</a>
    <br>
    <a href = "../xyzcompany/print/${user.accntno}">Print Transactions</a> 
    
</div>

</body>
</html>
