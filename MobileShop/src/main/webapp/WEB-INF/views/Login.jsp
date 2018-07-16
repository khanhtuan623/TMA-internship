<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" href="<c:url value="/resources/images/icons/favicon.ico" />" >
<!--===============================================================================================-->
		<link rel="stylesheet" href="<c:url  value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" >
<!--===============================================================================================-->
		<link href="<c:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css" />" rel="stylesheet">
<!--===============================================================================================-->
	<link href="<c:url value="/resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css" />" rel="stylesheet">
<!--===============================================================================================-->
	<link href="<c:url value="/resources/vendor/animate/animate.css" />" rel="stylesheet">
<!--===============================================================================================-->	
	<link href="<c:url value="/resources/vendor/css-hamburgers/hamburgers.min.css" />" rel="stylesheet">
<!--===============================================================================================-->
	<link href="<c:url value="/resources/vendor/select2/select2.min.css" />" rel="stylesheet">
<!--===============================================================================================-->
	<link href="<c:url value="/resources/css/util.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-50 p-r-50 p-t-77 p-b-30">
					<form:form class="login100-form validate-form"  action="Check-Login" method="POST" modelAttribute="login">
				
					<span class="login100-form-title p-b-55">
						Login
					</span>

					<div class="wrap-input100 validate-input m-b-16" data-validate = "Valid email is required: ex@abc.xyz">
						<form:input  class="input100" value="admin" path="userName" name="userName" placeholder="USERNAME" required="required"/>
						
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<span class="lnr lnr-envelope"></span>
						</span>
					</div>

					<div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
						<form:password class="input100" value="admin" path="passWord" name="passWord" placeholder="PASSWORD" required="required"/>
						
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<span class="lnr lnr-lock"></span>
						</span>
					</div>

					<div class="contact100-form-checkbox m-l-4">
						<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
						<label class="label-checkbox100" for="ckb1">
							Remember me
						</label>
					</div>
					
					<div class="container-login100-form-btn p-t-25">
						<button class="login100-form-btn">
							Login
						</button>
					</div>

					<div class="text-center w-full p-t-42 p-b-22">
						<span class="txt1">
							Or login with
						</span>
					</div>

					<a href="#" class="btn-face m-b-10">
						<i class="fa fa-facebook-official"></i>
						Facebook
					</a>

					<a href="#" class="btn-google m-b-10">
						<img src="/resources/images/icons/icon-google.png" alt="GOOGLE">
						Google
					</a>

					<div class="text-center w-full p-t-115">
						<span class="txt1">
							Not a member?
						</span>

						<a class="txt1 bo1 hov1" href="#">
							Sign up now							
						</a>
					</div>
					</form:form>
			</div>
		</div>
	</div>
	
	

	
<!--===============================================================================================-->	
    <script src="<c:url value="/resources/vendor/jquery/jquery-3.2.1.min.js" />"></script>
<!--===============================================================================================-->
    <script src="<c:url value="/resources/vendor/bootstrap/js/popper.js" />"></script>
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
<!--===============================================================================================-->
    <script src="<c:url value="/resources/vendor/select2/select2.min.js" />"></script>
<!--==============================================================================================-->
	<script src="<c:url value="/resources/js/main.js" />"></script>
	

</body>
</html>