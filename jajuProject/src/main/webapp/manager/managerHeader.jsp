<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" href="/jaju/css/header.css" />
</head>
<body>
	<div align="center" class="header_bar">
			<ul class="member_items">
				<li class="map_item"><a href="javascript: homePage()">홈페이지</a></li>
			</ul>
		</div>

	<!-- header -->
	<div class="header">
		<div class="logo_image">
			<h1 class="logo">
				<a href="/jaju/manager/index"> 
					<img src="/jaju/logo/jaju_final_logo_blueBack.png" />
				</a>
			</h1>
		</div>
	</div>



<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function homePage() {
		window.open('/jaju/', 'homePage', 'scrollbars=yes')
	}
</script>
</body>
</html>