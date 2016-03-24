<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>index</title>
</head>
<body>
	
	<div class="smile0">
	<form action="/RecallService/Email" method="get" name="form0">
	<input type="hidden" name="clientMark" value="0">
	<input type="image" src="img/0.png" style="width: 150px; height: 150px;" onclick="forma0.submit()">
	</form>
	</div>
	
	<div class="smile1">
	<form action="/RecallService/Email" method="get" name="form1">
	<input type="hidden" name="clientMark" value="1">
	<input type="image" src="img/1.png" style="width: 150px; height: 150px;" onclick="forma1.submit()">
	</form> 
	</div>
	
    <div class="smile2">
    <form action="/RecallService/Email" method="get" name="form2">
	<input type="hidden" name="clientMark" value="2">
	<input type="image" src="img/2.png" style="width: 150px; height: 150px;" onclick="forma2.submit()">
	</form>
	</div>
	
</body>
</html>