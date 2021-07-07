<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<link href="/jaju/manager_css/managerHeader.css" rel="stylesheet">

<div class="main">
<!-- <a href="javascript: homePage()" class="homePageBtn">HomePage</a> -->
<a href="/jaju/" class="homePageBtn">HomePage</a>
<section class="header">
    <h1 class="market_h1">
    	<a href="/jaju/manager/managerMainChart.jsp" class="mainBtn">Jaju Market</a>
    </h1>
    <p class="market_p">JajuMarket Admin Page</p>   
</section>
</div>

<script type="text/javascript">
function homePage() {
	window.open('/jaju/', 'homePage', 'scrollbars=yes, toolbar=yes')
	
}
</script>