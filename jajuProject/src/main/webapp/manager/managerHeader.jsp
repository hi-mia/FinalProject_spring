<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<link href="/jaju/manager_css/managerHeader.css" rel="stylesheet">

<div class="main">
<a href="javascript: homePage()" class="homePageBtn">HomePage</a>
<section class="header">
    <h1 class="market_h1">
    	<a href="/jaju/manager/index" class="mainBtn">Jaju Market</a>
    </h1>
    <p class="market_p">JajuMarket Admin Page</p>   
</section>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function homePage() {
	window.open('/jaju/', 'homePage', 'scrollbars=yes')
	
}
</script>