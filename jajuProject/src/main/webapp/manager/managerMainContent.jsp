<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상단 수 표시</title>

</head>
<body>

<div class="date">
	<a class="triangle_go">
		<img class="triangle" src="/jaju/jajuImage/trianglePrev.png" alt="triangle">
	</a>
	<div class="avatar avatar-xl">
		<img class="calendar" src="/jaju/jajuImage/calendar.png" alt="calendar">
	</div>	
	<h5 class="font-bold">2021.07.03</h5>
	<a class="triangle_back">
		<img class="triangle" src="/jaju/jajuImage/triangleNext.png" alt="triangle">
	</a>
</div>				
				
	<section class="row" style="margin-top: -25px;">
		<div class="col-12 col-lg-9" >

	<div class="row" >
		<div class="col-6 col-lg-3 col-md-6">
			<div class="card" >
				<div class="card-body px-3 py-4-5">
					<div class="row">
						<div class="col-md-4">
							<div class="stats-icon purple">
								<img class="inquire" src="/jaju/jajuImage/manager_inquire.png" alt="inquire">
								<i class="iconly-boldShow"></i>
							</div>
						</div>
						<div class="col-md-8">
							<h6 class="text-muted font-semibold" style="font-size: 26px; padding-left:13px; padding-top: 5px;">1:1 문의</h6>
							<h6 class="font-extrabold mb-0">200</h6>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-6 col-lg-3 col-md-6">
			<div class="card">
				<div class="card-body px-3 py-4-5">
					<div class="row">
						<div class="col-md-4">
							<div class="stats-icon blue">
							<img class="report" src="/jaju/jajuImage/manager_report.png" alt="report">
								<i class="iconly-boldProfile"></i>
							</div>
						</div>
						<div class="col-md-8">
							<h6 class="text-muted font-semibold" style="font-size: 23px;">신고 게시판</h6>
							<h6 class="font-extrabold mb-0">200</h6>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-6 col-lg-3 col-md-6">
			<div class="card">
				<div class="card-body px-3 py-4-5">
					<div class="row">
						<div class="col-md-4">
							<div class="stats-icon green">
							<img class="member" src="/jaju/jajuImage/manager_member.png" alt="member">
								<i class="iconly-boldAdd-User"></i>
							</div>
						</div>
						<div class="col-md-8">
							<h6 class="text-muted font-semibold" style="font-size: 20px;">신규 가입회원</h6>
							<h6 class="font-extrabold mb-0">200</h6>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-6 col-lg-3 col-md-6">
			<div class="card">
				<div class="card-body px-3 py-4-5">
					<div class="row">
						<div class="col-md-4">
							<div class="stats-icon red">
							<img class="new_board" src="/jaju/jajuImage/manager_new_board.png" alt="new_board">
								<i class="iconly-boldBookmark"></i>
							</div>
						</div>
						<div class="col-md-8">
							<h6 class="text-muted font-semibold" style="font-size: 23px;">판매 게시글</h6>
							<h6 class="font-extrabold mb-0">1000</h6>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
			
		<div class="resize-triggers">
			<div class="expand-trigger" style="width: 970px; height: 30px;">
				<div style="width: 272px; height: 10px;"></div>
			</div>
			<div class="contract-trigger"></div>
		</div>
	</div>

	</section>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>	

<script type="text/javascript">

$(function(){
	//창이 열리자마자 할일 : css color blue 로 변경
	//신규 1:1문의수 inquire_count , 신고 게시글 처리중 수 report_count, 당일 신규 가입자 수 newSaleboard_count, 당일 판매 게시글 등록 수 불러오기  newSaleboard_count
	
	$.ajax({
		url:'/jaju/manager/getManagerMainCount',
		type:'post',
		dataType:'json',
		success:function(data){
			console.log("mainChart에 대한 모든정보" + JSON.stringify(data));
			//만약 모든 정보 가져오는 걸 성공했다면 html로 하나씩 넣어주기. 
			
			$('#inquire_count').html(data.inquire_db+'건');
			$('#report_count').html(data.report_db+'건');
			$('#newMember_count').html(data.newMember_db+'건');
			$('#newSaleboard_count').html(data.saleReport_db+'건');

		},error:function(err){
			console.log("mainChartJSP에 오류 발생" + err);
		}
	});//ajax
});
</script>
</body>
</html>