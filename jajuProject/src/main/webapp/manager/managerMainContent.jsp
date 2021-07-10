<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상단 수 표시</title>
<style type="text/css">
.py-4-5{
cursor:pointer;
}
</style>
<!-- 
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script> -->
<!-- // jQuery UI CSS파일  -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<!-- // jQuery 기본 js파일 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!-- // jQuery UI 라이브러리 js파일 -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
</head>
<body>

<div class="date">
	<a class="triangle_go" id="prev_btn">
		<img class="triangle" src="/jaju/jajuImage/trianglePrev.png" alt="triangle">
	</a>
	<div class="avatar avatar-xl" >
		<img class="calendar" src="/jaju/jajuImage/calendar.png" alt="calendar">
	</div>	
	<h5 class="font-bold" id="today_calender"></h5>
	<a class="triangle_back" id="next_btn">
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
							<h6 class="font-extrabold mb-0" id="inquire_count"></h6>
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
							<img class="member" src="/jaju/jajuImage/manager_member.png" alt="member">
								<i class="iconly-boldAdd-User"></i>
							</div>
						</div>
						<div class="col-md-8">
							<h6 class="text-muted font-semibold" style="font-size: 20px;">신규 가입회원</h6>
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
							<img class="new_board" src="/jaju/jajuImage/manager_new_board.png" alt="new_board">
								<i class="iconly-boldBookmark"></i>
							</div>
						</div>
						<div class="col-md-8">
							<h6 class="text-muted font-semibold" style="font-size: 23px;">판매 게시글</h6>
							<h6 class="font-extrabold mb-0" id="newSaleboard_count"></h6>

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

<script type="text/javascript">
$(".selector").flatpickr({ 
dateFormat: "Y-m-d",
minDate:"today",
maxDate: new Date().fp_incr(30)
});
</script>


<script type="text/javascript">

$(function(){
	getFristInfomation();
});

function getFristInfomation(){
	//창이 열리자마자 할일 : css color blue 로 변경
	//신규 1:1문의수 inquire_count , 신고 게시글 처리중 수 report_count, 당일 신규 가입자 수 newSaleboard_count, 당일 판매 게시글 등록 수 불러오기  newSaleboard_count
	
	var now = new Date();	// 현재 날짜 및 시간
	var year = now.getFullYear();	// 연도
	var month = now.getMonth()+1;
	var date = now.getDate();
	
	
	if(month<10){
		month='0'+month;
	}
	if(date<10){
		date='0'+date;
	}
	
	$('#today_calender').html(year+"."+month+"."+date);
	$('#next_btn').hide();
	$('#prev_btn').show();

	//$('#search_date').hide();
	
	$.ajax({
		url:'/jaju/manager/getManagerMainCount',
		type:'post',
		dataType:'json',
		success:function(data){
			//console.log("mainChart에 대한 모든정보" + JSON.stringify(data));
			//만약 모든 정보 가져오는 걸 성공했다면 html로 하나씩 넣어주기. 
			
			$('#inquire_count').html(data.inquire_db+'건');
			$('#report_count').html(data.report_db+'건');
			$('#newMember_count').html(data.newMember_db+'건');
			$('#newSaleboard_count').html(data.saleReport_db+'건');

		},error:function(err){
			console.log("mainChartJSP에 오류 발생" + err);
		}
	});//ajax
}
//script구문 내부에 해당 메소드를 입력합니다.
$(function() {
    $( "#testDatepicker" ).datepicker({
    });
});

function getDays() {
    var start = new Date($('.selector').val());
   // var end   = new Date($('#to1').val());
   // days  = (end - start) / 1000 / 60 / 60 / 24;
   days  = start/ 1000 / 60 / 60 / 24;
   alert(start); 
}

//앞으로 가는 버튼 누르면 !
$('#prev_btn').click(function(){
	
	var now = new Date();	// 현재 날짜 및 시간
	var year = now.getFullYear();	// 연도
	var month = now.getMonth()+1;
	var date = now.getDate()-1;
	
	if(month<10){
		month='0'+month;
	}
	if(date<10){
		date='0'+date;
	}
	$('#today_calender').html(year+"."+month+"."+date);

	$.ajax({
		url:'/jaju/manager/getManagerPrevCount',
		type:'post',
		dataType:'json',
		success:function(data){
			
			console.log("PrevCount 에 대한 모든정보" + JSON.stringify(data));
			//만약 모든 정보 가져오는 걸 성공했다면 html로 하나씩 넣어주기. 
			
			$('#inquire_count').html(data.inquire_db+'건');
			$('#report_count').html(data.report_db+'건');
			$('#newMember_count').html(data.newMember_db+'건');
			$('#newSaleboard_count').html(data.saleReport_db+'건');

			$('#prev_btn').hide();
			$('#next_btn').show();

		},error:function(err){
			console.log("mainChartJSP에 오류 발생" + err);
		}
	});//ajax
});
$('#next_btn').click(function(){
	
	$('#next_btn').show();
	$('#pre_btn').hide();
	
	getFristInfomation();
	
});

$('.calendar').click(function(){
	$('#search_date').show();
	$( "#datepicker1" ).datepicker();
});

$('.py-4-5').click(function(){
	location.href="/jaju/manager/managerMainCalender.jsp";
});
</script>

</body>
</html>