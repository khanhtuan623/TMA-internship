 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld" %>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 <!DOCTYPE html>
<html lang="en">
<head>
	<link href="<c:url value="/resources/css/Home.css" />" rel="stylesheet">
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" />"></script>
 	<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MOBILE</title>
</head>

<body>
<div id="page">
<div id="header">
<div id="left">
<div id="home">
<div id="in-home"><a href="/Home">HOME</a></div>

</div>
<div id="element">
<ul>
<li> <a class="items" href="#">MOBILE</a>
    <ul class="sub-menu">
        <li class="sub-items" > <a href="/Tab/apple">Apple</a> </li> 
        <li class="sub-items" > <a href="/Tab/samsung">Samsung</a> </li>   
        <li class="sub-items" > <a href="/Tab/oppo">Oppo</a> </li>  
        <li class="sub-items" > <a href="/Tab/lg">LG</a> </li>    
        <li class="sub-items" > <a href="/Tab/sonny">Sony</a> </li> 
        <li class="sub-items" > <a href="/Tab/asus">Asus</a> </li>
        <li class="sub-items" > <a href="/Tab/xiaomi">Xiaomi</a> </li>    
    </ul>
 </li>
<li> <a class="items" href="#">TABLET</a>
        <ul class="sub-menu">
        <li class="sub-items" > <a href="#">Apple</a> </li> 
        <li class="sub-items" > <a href="#">SamSung</a> </li>   
        <li class="sub-items" > <a href="#">Sony</a> </li>
        </ul>
 </li>
<li> <a class="items" href="#">LAPTOP</a>
    <ul class="sub-menu">
        <li class="sub-items"> <a href="#">MacBook</a> </li>   
        <li class="sub-items" > <a href="#">Dell</a> </li>  
        <li class="sub-items" > <a href="#">Asus</a> </li>
        <li class="sub-items" > <a href="#">Acer</a> </li>  
        <li class="sub-items" > <a href="#">SamSung</a> </li>   
        <li class="sub-items" > <a href="#">Sony</a> </li>
        <li class="sub-items" > <a href="#">Hp</a> </li>    
        <li class="sub-items" > <a href="#">Lenovo</a> </li>    
        <li class="sub-items" > <a href="#">LG</a> </li>
    </ul>
 </li>
<li> <a class="items" href="#">AUDIO</a> </li>
<li> <a class="items" href="#">SUPPORT</a> </li>
</ul>
</div>
</div>
<div id="right">
<div id="search">
<form action="/Search-Device/${search}">
      <input type="text" placeholder="Search.." name="search">
      <button type="submit"></button>
    </form>
</div>
<div id="login"><a href="/Login">LOGIN</a></div>
</div>
</div>

<div id="main">
<div id="main-device">
	<ul>
	<c:forEach var="devices" items="${listDevices}">
		<li>
		 <div class="info-device-general">
		  <div class="detail-div"><a href="#">${devices.infor}</a></div>
		  <div class="info-device-general-a">
		<a  href="#"> 
		<div class="images-div"> <img class="images" alt="" src="/resources/images/mobile/${devices.image}"> </div>
		<div class="info-device">
		<p id="name-device" style="text-align: center;">${devices.name}</p>
		<p class="element-info">BRAND: <i>${devices.brand}</i> </p>
		<p class="element-info">COLOR: <i>${devices.color}</i> </p>
		<p class="element-info">MEMORY: <i>${devices.memory}</i> </p>
		<p class="element-info" >STATUS: <i id="status">${devices.status}</i> </p>
		<p class="element-info" style="text-align: center; color: red;font-size: 15px;">${devices.price}d</p>
		</div>
		 </a> 
		 </div>
		 </div>
		 <c:if test="${devices.status !='Unvailable'}">
		 <a class="button-buy"  href="/Buy-Device/${devices.id}">BUY</a>
		 </c:if>
		 
		<c:if test="${devices.status =='Unvailable'}">
		 <a class="button-buy"  href="#">Sold Out</a>
		 </c:if>
		 </li>
		 
		 </c:forEach>
		 
	</ul>
	
</div>
<div id="page-id">
 <tag:paginate  max="10" offset="${offset}" count="${count}" uri="${tab}" next="&raquo;" previous="&laquo;"/>
</div>
</div>
<div id="footer">
<div id="left-footer">
	<h2>CONTACT</h2>
	<ul>
	<li>TMA Solutions-Tiger</li>
	<li>Address : <i> Street #10, Quang Trung Software City, 1 To Ky, District 12, HCMC </i></li>
	<li>Email : <i> Tiger-Team@tma.com.vn </i></li>
	<li>Hotline : <i> 19008000 </i></li>
	</ul>
</div>
</div>
</div>
<script>
$(".sub-items").click(function(){
	var tab=$(this).attr('href');
});
</script>
</body>
</html>
