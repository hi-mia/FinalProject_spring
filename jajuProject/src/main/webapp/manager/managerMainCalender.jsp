<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- // jQuery UI CSS파일  -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<!-- // jQuery 기본 js파일 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!-- // jQuery UI 라이브러리 js파일 -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script type="text/javascript">
//script구문 내부에 해당 메소드를 입력합니다.
$(function() {
	
	$('#managerMainCalender').addClass('on');

    $( "#testDatepicker" ).datepicker({
    	dateFormat: 'yy-mm-dd' //Input Display Format 변경
            ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
            ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
            ,changeYear: true //콤보박스에서 년 선택 가능
            ,changeMonth: true //콤보박스에서 월 선택 가능                
            //,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시
            //,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
            //,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
            ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
            ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
            ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
            ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
            ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
            ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
            ,minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
            ,maxDate: "0M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)         
   });
});
</script>


<style type="text/css">
html, body {
	box-sizing: border-box;
	padding: 0;
	margin: 0;
}

*, *:before, *:after {
	box-sizing: inherit;
}

.clearfix:after {
	content: '';
	display: block;
	clear: both;
	float: none;
}

/* ======== Calendar ======== */
.my-calendar {
	display: inline-block;
	width: 700px;
	margin-left: 80px;
	margin: 60px 180px;
	padding: 20px 20px 10px;
	text-align: center;
	font-weight: 800;
	border: 1px solid #ddd;
	cursor: default;
}

.my-calendar .clicked-date {
	border-radius: 25px;
	margin-top: 36px;
	float: left;
	width: 42%;
	padding: 46px 0 26px;
	background: #ddd;
}

.my-calendar .calendar-box {
	float: right;
	width: 58%;
	padding-left: 30px;
}

.clicked-date .cal-day {
	font-size: 24px;
}

.clicked-date .cal-date {
	font-size: 130px;
}

.ctr-box {
	padding: 0 16px;
	margin-bottom: 20px;
	font-size: 20px;
}

.ctr-box .btn-cal {
	position: relative;
	float: left;
	width: 25px;
	height: 25px;
	margin-top: 5px;
	font-size: 16px;
	cursor: pointer;
	border: none;
	background: none;
}

.ctr-box .btn-cal:after {
	content: '<';
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	line-height: 25px;
	font-weight: bold;
	font-size: 20px;
}

.ctr-box .btn-cal.next {
	float: right;
}

.ctr-box .btn-cal.next:after {
	content: '>';
}

.cal-table {
	width: 100%;
}

.cal-table th {
	width: 14.2857%;
	padding-bottom: 5px;
	font-size: 16px;
	font-weight: 900;
}

.cal-table td {
	padding: 3px 0;
	height: 50px;
	font-size: 15px;
	vertical-align: middle;
}

.cal-table td.day {
	position: relative;
	cursor: pointer;
}

.cal-table td.today {
	background: #ffd255;
	border-radius: 50%;
	color: #fff;
}

.cal-table td.day-active {
	background: #ff8585;
	border-radius: 50%;
	color: #fff;
}

.cal-table td.has-event:after {
	content: '';
	display: block;
	position: absolute;
	left: 0;
	bottom: 0;
	width: 100%;
	height: 4px;
	background: #FFC107;
}
#chart_div {
	display: inline-block;
}

#container {
	position: relative;
}

#piechart {
	width: 900px;
	height: 500px;
}

#overlay {
	position: absolute;
	width: 80px;
	height: 80px;
	top: 110px;
	left: 110px;
	border-radius: 40px;
}

#content {
	float: left;
	padding:50px 50px;
	margin: 0 0 0 60px;
	padding-bottom: 40px;
	background: #fff;
	width: 840px;
}

body#cafeAdmin #content {
	color: #444;
}

body#cafeAdmin #content.adm_home {
	margin: 61px 0 0 60px;
}

.date_info {
	position: relative;
	width: 840px;
	height: 19px;
}

.date_selector {
	position: relative;
	top: 1px;
	display: inline-block;
}

.next_stat_btn, .prev_stat_btn {
	float: left;
	display: inline-block;
	width: 10px;
	height: 17px;
	cursor: pointer;
}

.prev_stat_btn {
	background: url(//t1.daumcdn.net/cafe_image/founder/2018/prevBtn.png)
		no-repeat;
	background-size: 10px 17px;
}

.stat_btn.end {
	display: none;
}

.next_stat_btn {
	position: relative;
	left: -2px;
	background: url(//t1.daumcdn.net/cafe_image/founder/2018/nextBtn.png)
		no-repeat;
	background-size: 10px 17px;
}

a {
	font-size: inherit;
}

a, a:hover {
	color: #000;
}

.sr_only {
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}

.stat_date {
	position: relative;
	top: -2px;
	float: left;
	display: inline-block;
	padding: 0 14px;
	height: 19px;
	font-size: 16px;
	font-weight: 700;
	line-height: 19px;
	vertical-align: middle;
	color: #000;
}

.stat_collect_dt {
	position: absolute;
	top: 0;
	right: 0;
	font-size: 13px;
	color: #888;
}

}
.box_stat {
	position: relative;
	margin-top: 20px;
	width: 840px;
	height: 200px;
	box-sizing: border-box;
	border: 1px solid #e2e2e2;
	background-color: #fafafa;
}

.box_stat .stat {
	position: relative;
	display: inline-block;
	width: 180px;
	height: 88px;
	padding: 38px 30px;
	vertical-align: top;
	float: left;
}

.stat_title {
font-weight: 700;
    display: inline-block;
    /* height: 18px; */
    font-size: 20px;
    line-height: 1.2;
    vertical-align: top;
    color: #222;
}

.ico_etc_tip {
	position: relative;
	top: 1px;
	left: 2px;
	display: inline-block;
	width: 17px;
	height: 17px;
	background:
		url(//t1.daumcdn.net/cafe_image/founder/2018/ico-etc-tip@1x.png)
		no-repeat;
}

.tip_box {
	position: absolute;
	display: none;
	width: 268px;
	padding: 18px 16px 20px;
	margin-top: 4px;
	border: 1px solid #565a60;
	box-shadow: 0 2px 4px 0 rgb(0 0 0/ 10%);
	background-color: #fff;
}

.box_tooltip_title {
	height: 18px;
	font-size: 14px;
	font-weight: 700;
	line-height: 18px;
	color: #222;
}

.box_tooltip_contents {
	padding-top: 8px;
	font-size: 13px;
	line-height: 18px;
	color: #444;
}

.stat_value {
	display: block;
	width: 170px;
	height: 34px;
	padding-top: 2px;
	font-size: 32px;
	font-weight: 700;
	line-height: 34px;
	color: #222;
	margin-top: 10px;
}

.stat_increase {
	/*position: absolute;*/
	bottom: 40px;
	display: inline-block;
}

.ico_increase.up {
	background:
		url(//t1.daumcdn.net/cafe_image/founder/2018/ico-ranking-up-r@1x.png)
		no-repeat;
}

.ico_increase {
	position: relative;
	top: 4px;
	display: inline-block;
	width: 8px;
	height: 8px;
}

.value_increase.up {
	color: #ed3e49;
}

.value_increase {
	text-align:center;
	font-weight:700;
	position: relative;
	top: 1px;
	display: inline-block;
	height: 18px;
	font-size: 25px;
	line-height: 18px;
	vertical-align: middle;
}

.box_stat {
	position: relative;
	margin-top: 20px;
	width: 860px;
	height: 200px;
	box-sizing: border-box;
	border: 1px solid #e2e2e2;
	background-color: #fafafa;
	padding: 0px 0px 0 60px;
}

.box_stat .stat {
position: relative;
    display: inline-block;
    width: 196px;
    height: 88px;
    padding: 38px 30px;
    vertical-align: top;
    float: left;
}

.testDatePicker{
    width: 220px;
    height: 40px;
    border-radius: 5px;
    float: left;
    margin-left: 10px;
    text-align: center;
    font-size: 20px;
}
.avatar.avatar-xl{
	background: #ddd;
    border-radius: 50%;
    width: 55px;
    height: 55px;
    margin-left: 410px;
    /* margin-bottom: 20px; */
    /* margin-left: 370px; */
    align: center;
    margin-top: -8px;
    float: left;
}
div.avatar.avatar-xl > img.calendar{
	width: 30px;
	height: 30px;
	border-radius: 0; 
	margin-top: 13px;
}

</style>

</head>
<body>


	<div>
		<jsp:include page="/manager/managerHeader.jsp" />
	</div>

	<div style="width: 1260px; margin: 0 auto;">

		<div>
			<jsp:include page="/manager/managerMenu.jsp" />
		</div>

		<div class="container">
			<div class="my-calendar clearfix">
				<div class="clicked-date">
					<div class="cal-day"></div>
					<div class="cal-date"></div>
				</div>
				<div class="calendar-box">
					<div class="ctr-box clearfix">
						<button type="button" title="prev" class="btn-cal prev">
						</button>
						<span class="cal-month"></span> <span class="cal-year"></span>
						<button type="button" title="next" class="btn-cal next">
						</button>
					</div>
					<table class="cal-table">
						<thead>
							<tr>
								<th>일</th>
								<th>월</th>
								<th>화</th>
								<th>수</th>
								<th>목</th>
								<th>금</th>
								<th>토</th>
							</tr>
						</thead>
						<tbody class="cal-body"></tbody>
					</table>
				</div>
			</div>
			<!-- // .my-calendar -->
		</div>

	
	<div align="center">
		<div class="avatar avatar-xl" >
			<img class="calendar" src="/jaju/jajuImage/calendar.png" alt="calendar">
		</div>
			<input type="text" class="testDatePicker" id="testDatepicker"  placeholder="조회 날짜를 선택하세요.">
		<a class="input-button" title="toggle" data-toggle>
		<i class="icon-calendar"></i></a>
	</div>	
		
<div id="content" class="adm_home">
		<div class="date_info">
			<div class="date_selector">
				<a role="button" class="stat_btn prev_stat_btn" id="prevBtn">
					<span class="sr_only">이전 날짜 버튼</span>
				</a>
				<span id="date" class="stat_date" style="user-select: none;"></span>
				<a role="button" class="stat_btn next_stat_btn end" id="nextBtn">
					<span class="sr_only">다음 날짜 버튼</span>
				</a>
			</div>
			<span class="stat_collect_dt"></span>
		</div>

				<div class="box_stat" id="statBox">
				
					<div class="stat">
						<span class="stat_title">1:1문의<br> 신규게시글 수<br><br></span>
							<span class="value_increase" id="inquire_span">0</span>
					</div>
			
					<div class="stat">
						<span class="stat_title">신고게시판<br> 신규게시글 수<br><br></span>
							<span class="value_increase" id="report_span">0</span>
					</div>
						
					<div class="stat">
						<span class="stat_title">신규 <br>가입자수<br><br></span>
						<br>
							<span class="value_increase" id="newMember_span">0</span>
							
					</div>
			
					<div class="stat">
						<span class="stat_title">일별 판매<br> 게시글 수<br><br></span>
						<br>
							<span class="value_increase" id="saleBoard_span">0</span>
					</div>
		</div>
	</div>
		

</div>


<script type="text/javascript">
//달력생성소스
const init = {
monList: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
dayList: ['일', '월', '화', '수', '목', '금', '토'],
today: new Date(),
monForChange: new Date().getMonth(),
activeDate: new Date(),
getFirstDay: (yy, mm) => new Date(yy, mm, 1),
getLastDay: (yy, mm) => new Date(yy, mm + 1, 0),
nextMonth: function () {
 let d = new Date();
 d.setDate(1);
 d.setMonth(++this.monForChange);
 this.activeDate = d;
 return d;
},
prevMonth: function () {
 let d = new Date();
 d.setDate(1);
 d.setMonth(--this.monForChange);
 this.activeDate = d;
 return d;
},
addZero: (num) => (num < 10) ? '0' + num : num,
activeDTag: null,
getIndex: function (node) {
 let index = 0;
 while (node = node.previousElementSibling) {
   index++;
 }
 return index;
}
};

const $calBody = document.querySelector('.cal-body');
const $btnNext = document.querySelector('.btn-cal.next');
const $btnPrev = document.querySelector('.btn-cal.prev');
function loadDate (date, dayIn) {
document.querySelector('.cal-date').textContent = date;
document.querySelector('.cal-day').textContent = init.dayList[dayIn];
}

function loadYYMM (fullDate) {
let yy = fullDate.getFullYear();
let mm = fullDate.getMonth();
let firstDay = init.getFirstDay(yy, mm);
let lastDay = init.getLastDay(yy, mm);
let markToday;  // for marking today date
if (mm === init.today.getMonth() && yy === init.today.getFullYear()) {
 markToday = init.today.getDate();
}
document.querySelector('.cal-month').textContent = init.monList[mm];
document.querySelector('.cal-year').textContent = yy;
let trtd = '';
let startCount;
let countDay = 0;
for (let i = 0; i < 6; i++) {
 trtd += '<tr>';
 for (let j = 0; j < 7; j++) {
   if (i === 0 && !startCount && j === firstDay.getDay()) {
     startCount = 1;
   }
   if (!startCount) {
     trtd += '<td>'
   } else {
     let fullDate = yy + '.' + init.addZero(mm + 1) + '.' + init.addZero(countDay + 1);
     trtd += '<td class="day';
     trtd += (markToday && markToday === countDay + 1) ? ' today" ' : '"';
     trtd += ` data-date="${countDay + 1}" data-fdate="${fullDate}">`;
   }
   trtd += (startCount) ? ++countDay : '';
   if (countDay === lastDay.getDate()) { 
     startCount = 0; 
   }
   trtd += '</td>';
 }
 trtd += '</tr>';
}
$calBody.innerHTML = trtd;
}
function createNewList (val) {
let id = new Date().getTime() + '';
let yy = init.activeDate.getFullYear();
let mm = init.activeDate.getMonth() + 1;
let dd = init.activeDate.getDate();
const $target = $calBody.querySelector(`.day[data-date="${dd}"]`);

let date = yy + '.' + init.addZero(mm) + '.' + init.addZero(dd);

let eventData = {};
eventData['date'] = date;
eventData['memo'] = val;
eventData['complete'] = false;
eventData['id'] = id;
init.event.push(eventData);
$todoList.appendChild(createLi(id, val, date));
}

loadYYMM(init.today);
loadDate(init.today.getDate(), init.today.getDay());

$btnNext.addEventListener('click', () => loadYYMM(init.nextMonth()));
$btnPrev.addEventListener('click', () => loadYYMM(init.prevMonth()));

$calBody.addEventListener('click', (e) => {
if (e.target.classList.contains('day')) {
 if (init.activeDTag) {
   init.activeDTag.classList.remove('day-active');
 }
 let day = Number(e.target.textContent);
 loadDate(day, e.target.cellIndex);
 e.target.classList.add('day-active');
 init.activeDTag = e.target;
 init.activeDate.setDate(day);
 reloadTodo();
}
});
</script>

<script type="text/javascript">
$(function(){
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
	
	$('.cal-day').html(month+"월");
	$('.cal-date').html(date);
	$('.stat_collect_dt').html(year+"."+month+"."+date+" 기준");
	$('.stat_date').html(year+"."+month+"."+date+" 기준");
	
	$.ajax({
		url:'/jaju/manager/getManagerMainCount',
		type:'post',
		dataType:'json',
		success:function(data){
			console.log("mainChart에 대한 모든정보" + JSON.stringify(data));
			//만약 모든 정보 가져오는 걸 성공했다면 html로 하나씩 넣어주기. 
			
			$('#inquire_span').html(data.inquire_db+'건');
			$('#report_span').html(data.report_db+'건');
			$('#newMember_span').html(data.newMember_db+'건');
			$('#saleBoard_span').html(data.saleReport_db+'건');

		},error:function(err){
			console.log("mainChartJSP에 오류 발생" + err);
		}
	});//ajax
});
function getFormatDate(date){
    var year = date.getFullYear();              //yyyy
    var month = (1 + date.getMonth());          //M
    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
    var day = date.getDate();                   //d
    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
    return  year + '-' + month + '-' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
}
$('.cal-body').click(function (){
	var calyear = $('.cal-year').text();
	var calmonth = $('.cal-month').text();
	var dayactive = $('.day-active').text();
	var calmonthMinus = calmonth.substring(0,1); 
	//alert("cal-year/cal-month/day-active : "+calyear+calmonthMinus+dayactive);
	
	if(calmonthMinus<10){
		calmonthMinus='0'+calmonthMinus;
	}
	if(dayactive<10){
		dayactive='0'+dayactive;
	}
	
	var date = new Date(calyear,calmonthMinus-1,dayactive);
	date= getFormatDate(date);
	//alert(date);
	
	if(confirm(date+" 일자로 조회하시겠습니까?")){
	
	$.ajax({
    	url:'/jaju/manager/getCalenderInfo',
    	data: {'date': date },
    	type:'post',
    	dataType:'json',
    	success:function(data){
    		//alert("getCalenderInfo 결과물  : " +JSON.stringify(data));
    		//console.log("datepicker 결과물  : " +JSON.stringify(data));
			$.each(data.list, function(index, items){
				//console.log(JSON.stringify(data.list[0]));
				
				$('.cal-table td.today').css('background', '#fff');
				$('.cal-table td.today').css('color', '#000000');

				$('.stat_collect_dt').html(date+" 기준");
				$('.stat_date').html(date+" 기준");
				
				$('#inquire_span').html(data.list[0]+'건');
				$('#report_span').html(data.list[1]+'건');
				$('#newMember_span').html(data.list[2]+'건');
				$('#saleBoard_span').html(data.list[3]+'건');
				
			});//each

    		
    	},error:function(err){
    		console.log("managerCalender 에러발생" + err)	
    	}
    });
	}
	else{
		alert("다시 선택해주세요.")
	}
});


//$( "#testDatepicker" ).datepicker( "getDate" );
$('#testDatepicker').change(function (){
    var date = $('#testDatepicker').val();
    //alert("date???" + date);
    
    var arr = date.split('-'); 
	//alert("arr"+arr);

	var now = new Date();	// 현재 날짜 및 시간
	var year = arr[0];	// 연도
	var month = arr[1];
	var dateArr = arr[2];

	$('.cal-day').html(month+"월");
	$('.cal-date').html(dateArr);
	$('.stat_collect_dt').html(year+"."+month+"."+dateArr+" 기준");
	$('.stat_date').html(year+"."+month+"."+dateArr+" 기준");
	
	$('.cal-table td.today').css("background","#fff");
	$('.cal-table td.today').css("color","#333");

    $.ajax({
    	url:'/jaju/manager/getDatePickerInfo',
    	data: {'date': date },
    	type:'post',
    	dataType:'json',
    	success:function(data){
    		$('#ui-datepicker-div').hide();
    		
    		//console.log("datepicker 결과물  : " +JSON.stringify(data));
    		$('.stat_collect_dt').html(date+" 기준");
			$('.stat_date').html(date+" 기준");
				
			$('#inquire_span').html(data.inquirePickerCount+'건');
			$('#report_span').html(data.reportPickerCount+'건');
			$('#newMember_span').html(data.newMemberPickerCount+'건');
			$('#saleBoard_span').html(data.saleReportPickerCount+'건');
			
		 
			/* $.each(arr, function(index, value) { 
			      console.log(index + ':값 = ' + value); 
			}); */

			
    	},error:function(err){
    		console.log("managerCalender 에러발생" + err)	
    	}
    	
    });
    var arr = date.split('-'); 
	//alert("arr"+arr);
});
</script>

</body>
</html>