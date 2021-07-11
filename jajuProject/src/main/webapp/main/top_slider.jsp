<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.single-item {
	width: 100%;
	margin: 0 auto;
}
.single-item img{
 width: 100%;
 height: auto;
 align-content: center;
}
.single-item .slick-slide img {
    display: block;
    margin-top: 70px;
}
.single-item .slick-prev.slick-arrow {
	position: absolute;
	display: none!important;
	/*left: -85px;*/
	top: 50%;
	transform: translateY(-50%);
	background: url(/img/bx_left.png);
	display: hidden;
	text-indent: -9999px;
	width: 60px;
	height: 60px;
	background-size: cover;
}

.single-item .slick-next.slick-arrow {
	position: absolute;
	display: none!important;
	right: -85px;
	top: 50%;
	transform: translateY(-50%);
	background: url(/img/bx_right.png);
	display: hidden;
	text-indent: -9999px;
	width: 60px;
	height: 60px;
	background-size: cover;
	color:#333;
}
.slick-next:before, .slick-prev:before {
	font-family: slick;
	font-size: 20px;
	line-height: 1;
	opacity: .75;
	color: #333 !important;
	-webkit-font-smoothing: antialiased;
}

</style>
<!-- 제이쿼리 불러오기 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<!-- Slick 불러오기 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">
</head>

<body>

	<div class="single-item">
		<div>
			<img src="/jaju/jajuImage/top_slider02.png">
		</div>

		<div>
			<img src="/jaju/jajuImage/top_slider01.png">
		</div>

		<div>
			<img src="/jaju/jajuImage/top_slider03.png">
		</div>

		<div>
			<img src="/jaju/jajuImage/top_slider04.png">
		</div>
		
		
		<div>
			<img src="/jaju/jajuImage/top_slider05.png">
		</div>
		
		
		<div>
			<img src="/jaju/jajuImage/top_slider06.png">
		</div>
		

	</div>

	<script type="text/javascript"
		src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript"
		src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

</body>
</html>