<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상단 수 표시</title>
<link rel="stylesheet" href="/jaju/manager_css/managerMainChart.css" />
<link rel="stylesheet" href="/jaju/manager_css/managerMainApp.css" />
</head>
<body>

	<section class="row">
		<div class="col-12 col-lg-9">

	<div class="card">
		<div class="card-body py-4 px-5">
			<div class="d-flex align-items-center">
				<div class="avatar avatar-xl">
					<img src="assets/images/faces/1.jpg" alt="Face 1">
				</div>
				<div class="ms-3 name">
					<h5 class="font-bold">관리자</h5>
					<h6 class="text-muted mb-0">@jajuadmin</h6>
				</div>
			</div>
		</div>
	</div>
			
	<div class="row" >
		<div class="col-6 col-lg-3 col-md-6">
			<div class="card" >
				<div class="card-body px-3 py-4-5">
					<div class="row">
						<div class="col-md-4">
							<div class="stats-icon purple">
								<i class="iconly-boldShow"></i>
							</div>
						</div>
						<div class="col-md-8">
							<h6 class="text-muted font-semibold">1:1문의</h6>
							<h6 class="font-extrabold mb-0"  id="inquire_count"></h6>
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
								<i class="iconly-boldProfile"></i>
							</div>
						</div>
						<div class="col-md-8">
							<h6 class="text-muted font-semibold">신고게시판</h6>
							<h6 class="font-extrabold mb-0" id="report_count"></h6>
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
								<i class="iconly-boldAdd-User"></i>
							</div>
						</div>
						<div class="col-md-8">
							<h6 class="text-muted font-semibold">신규 가입자수</h6>
							<h6 class="font-extrabold mb-0" id="newMember_count"></h6>
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
								<i class="iconly-boldBookmark"></i>
							</div>
						</div>
						<div class="col-md-8">
							<h6 class="text-muted font-semibold">일별 판매 게시글 수</h6>
							<h6 class="font-extrabold mb-0" id="newSaleboard_count"></h6>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
			
					<div class="resize-triggers">
						<div class="expand-trigger">
							<div style="width: 272px; height: 256px;"></div>
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