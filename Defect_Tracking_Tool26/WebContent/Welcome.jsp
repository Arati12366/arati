<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
 <link  rel="stylesheet" type="text/css" href="required/dist/css/style1.css" >
     <link href="required/dist/css/style.min.css" rel="stylesheet">
 
 <style type="text/css">
 body{
	margin:600px;
	padding:0px;
	background:url(required/assets/images/img1.jpg);
	background-repeat: no-repeat;
	background-size:cover;
	background-position:center;
	font-family:sans-serif;
}
::placeholder{
	
	color:white;
}
</style>
</head>
<body>
<div class="login-box">
<img src="required/assets/images/avtar.png"class="avtar">
<h1>Login </h1>
<form action="LoginAction" method="post">

<input type="text" placeholder="Enter Username" name="Uname">

<input type="password" placeholder="Enter Password" name="Password">
<br>
 <button class="btn btn-info" id="to-recover" type="button"><i class="fa fa-lock m-r-5"></i>Forgot Password?</button>
<button class="btn btn-success float-right" type="submit">Login</button>

</form>
</div>
</body>
</html>