<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="<c:url value="/resources/css/Confirm.css" />" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm</title>
</head>
<body>
<script type="text/javascript">
	var result=${result};
	if(result==1){
	alert("Auto Redirect To HOME after 10s");
		var count = 10;
		setInterval(function(){
		    count--;
		    document.getElementById('countDown').innerHTML = count;
		    if (count == 0) {
		        window.location = 'http://localhost:8800/Home/'; 
		    }
		},2000);	
	}
	else {
		alert(" PAYMENT FAIL \n\n Auto Redirect To HOME after 10s!");
		var count = 10;
		setInterval(function(){
		    count--;
		    document.getElementById('countDown').innerHTML = count;
		    if (count == 0) {
		        window.location = 'http://localhost:8800/Home/'; 
		    }
		},2000);	
		$(document).ready(function(){
	        $("#confirm").remove();
	        document.getElementById("fail").style.display = "block";
	});
	}
</script>
	<div id="confirm">
		<div id="logo">
		<img class="logo" alt="" src="/resources/images/payment.png" style="width: 70px;height: 70px;">
		<h1 class="logo">Payment Sucssesfull</h1>
		</div>
		<hr style="clear: both;">
		<div id="element">
		<h3 class="info">FULL NAME: <i>${confirm.name}</i> </h3>
		<h3 class="info">PHONE: <i>${confirm.phone }</i> </h3>
		<h3 class="info">EMAIL: <i>${confirm.email}</i></h3>
		<h3 class="info">ADDRESS: <i>${confirm.address}</i></h3>
		<h3 class="info">DEVICE: <i>${confirm.nameDevice}</i></h3>
		<h3 class="info">COLOR: <i>${confirm.colorDevice}</i></h3>
		<h3 class="info">MEMORY: <i>${confirm.memoryDevice}</i></h3>
		<h3  class="info">PRICE: <i>${confirm.price}</i></h3>
		<h3  class="info">DATE PAYMENT: <i>${confirm.datePayment}</i></h3>
		<a href="/Home"><button>HOME ( <i id="countDown"></i>s)</button> </a>
		</div>
	</div>
<div id="fail">
		<div id="logo">
		<img class="logo" alt="" src="/resources/images/fail.png" style="width: 70px;height: 70px;">
		<h1 class="logo">Payment Fail</h1>
		</div>
		<hr style="clear: both;">
		<div id="element">
		<h3>1. Check Information Your Card</h3>
		<h3>2. Check Quantity Product</h3>
		<h3>3. CALL US FOR SUPPORT: 19008800</h3>
		<a href="/Home"><button>HOME ( <i id="countDown"></i>s)</button> </a>
		</div>
</div>
</body>
</html>