<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="BankOperation" method="POST">
		Client:
		<input type="text" name="client" value="${request.scope.client} ">
		</br>
		Current Amount:
		<input type="text" name="currentAmount" value="${request.scope.currentAmount} ">
		</br>
		Operation:
		</br>
		<input type="radio" name="operation" value="withdraw" checked>
		Withdraw
		</br>
		<input type="radio" name="operation" value="deposit">
		Deposit..
		</br>
		Amount:
		<input type="amount">
		</br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>