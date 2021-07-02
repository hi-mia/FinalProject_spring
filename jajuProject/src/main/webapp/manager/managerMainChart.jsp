<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
	margin: 33px 0 0 60px;
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
	height: 166px;
	box-sizing: border-box;
	border: 1px solid #e2e2e2;
	background-color: #fafafa;
}

.box_stat .stat {
	position: relative;
	display: inline-block;
	width: 150px;
	height: 88px;
	padding: 38px 30px;
	vertical-align: top;
	float: left;
}

.stat_title {
	display: inline-block;
	/*height: 18px;*/
	font-size: 13px;
	line-height: 18px;
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
	position: relative;
	top: 1px;
	display: inline-block;
	height: 18px;
	font-size: 13px;
	line-height: 18px;
	vertical-align: middle;
}

.box_stat {
	position: relative;
	margin-top: 20px;
	width: 860px;
	height: 166px;
	box-sizing: border-box;
	border: 1px solid #e2e2e2;
	background-color: #fafafa;
}

.box_stat .stat {
	position: relative;
	display: inline-block;
	width: 150px;
	height: 88px;
	padding: 38px 30px;
	vertical-align: top;
	float: left;
}
</style>


</head>
<body>

<div style="width: 1280px; margin: auto;">

<jsp:include page="/manager/managerMenu.jsp"/>

<div id="content" class="adm_home">
		<div class="date_info">
			<div class="date_selector">
				<a role="button" class="stat_btn prev_stat_btn" id="prevBtn">
					<span class="sr_only">이전 날짜 버튼</span>
				</a>
				<span id="date" class="stat_date">2021.07.01.</span>
				<a role="button" class="stat_btn next_stat_btn end" id="nextBtn">
					<span class="sr_only">다음 날짜 버튼</span>
				</a>
			</div>
			<span class="stat_collect_dt">2021.07.01. 16:08 기준</span>
		</div>

				<div class="box_stat" id="statBox">
			<div class="stat">
				<span class="stat_title">1:1문의<br> 신규게시글 수</span>
				<!--[if gt IE 7]><!-->
				<span class="ico_etc_tip" id="btn_tip_uv">
					<span class="sr_only">1:1문의란?</span>
					<span class="sr_only">자주마켓에 대한 고객님의 1:1 질문을 모두 볼 수 있는 게시판 입니다.</span>
				</span>
				<div class="tip_box" id="tip_uv" aria-hidden="true">
					<div class="box_tooltip_title">1:1문의란?</div>
					<div class="box_tooltip_contents">자주마켓에 대한 고객님의 1:1 질문을 모두 볼 수 있는 게시판 입니다.</div>
				</div>
				<!--<![endif]-->
				<span class="stat_value" id="uvValue">1</span>
				<span class="stat_increase" id="uvDelta">
					<span class="ico_increase up"><span class="sr_only">방문자수 증가</span></span>
					<span class="value_increase up">1</span>
				</span>
			</div>
			<div class="stat">
				<span class="stat_title">신고게시판<br> 신규게시글 수</span>
				<!--[if gt IE 7]><!-->
				<span class="ico_etc_tip" id="btn_tip_pv">
					<span class="sr_only">신고글이란?</span>
					<span class="sr_only">자주마켓을 이용하는 고객님께서 .</span>
				</span>
				<div class="tip_box" id="tip_pv" aria-hidden="true">
					<div class="box_tooltip_title">방문수란?</div>
					<div class="box_tooltip_contents">카페 회원여부와 관계없이 PC와 모바일 웹, 앱을 통해 카페를 방문한 횟수입니다.</div>
				</div>
				<!--<![endif]-->
				<a id="pvValue" href="/_c21_/founder_stat_cafe?grpid=1Z5bV&amp;kind=VISIT" class="stat_value">1</a>
				<span class="stat_increase" id="pvDelta">
					<span class="ico_increase up"><span class="sr_only">방문수 증가</span></span>
					<span class="value_increase up">1</span>
				</span>
			</div>
			<div class="stat">
				<span class="stat_title">신규 가입자수<br><br></span>
				<a id="newMemberValue" class="stat_value" href="/_c21_/founder_stat_cafe?grpid=1Z5bV&amp;kind=JOIN">0</a>
				<span class="stat_increase" id="newMemberDelta">
					<span class="ico_increase"><span class="sr_only">가입자수 변동없음</span></span>
					<span class="value_increase"></span>
				</span>
			</div>
			
			<div class="stat last_child">
				<span class="stat_title">일별 판매 게시글 수<br><br></span>
				<a id="newArticleValue" class="stat_value" href="/_c21_/founder_stat_cafe?grpid=1Z5bV&amp;kind=WRITE_ARTICLE">0</a>
				<span class="stat_increase" id="newArticleDelta">
					<span class="ico_increase"><span class="sr_only">새글수 변동없음</span></span>
					<span class="value_increase"></span>
				</span>
			</div>
		</div>
	</div>
	
				<div id="chart_div"></div>
	
				<h1>게시물데이터그래프화</h1>
			
			
				<canvas id="myChart" align="center"></canvas>
				<canvas id="myChart2"></canvas>
				<canvas id="myChart3"></canvas>
				<canvas id="myChart4"></canvas>
	
	
</div><!-- 1280px div -->
 <!--Load the AJAX API-->
 	<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>	
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
   	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
    
    <script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);


      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {
			// Create the data table.
	        var data = new google.visualization.DataTable();
	        data.addColumn('string', 'Topping');
	        data.addColumn('number', 'Slices');
	        data.addRows([
	          ['자', 3],
	          ['주', 1],
	          ['주주', 1],
	          ['주주주', 1],
	          ['주주주ㅜ', 2]
	        ]);

	        // Set chart options
	        var options = {'title':'도넛차트 테스트중..',
	                       'width':500,
	                       'height':500};
	        // Instantiate and draw our chart, passing in some options.
	        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
	        chart.draw(data, options);
	        
	        google.charts.setOnLoadCallback();
      }
</script>

<script>
    	//차트 색상 랜덤
		$(function() {
			function randomColor(labels) {
				var colors = [];
				for (let i = 0; i < labels.length; i++) {
					colors.push("#" + Math.round(Math.random() * 0xffffff).toString(16));
				}
				return colors;
			}
			
			function makeChart(ctx, type, labels, data) {
				var myChart = new Chart(ctx, {
				    type: type,
				    data: {
				        labels: labels,
				        datasets: [{
				            label: '날짜별 게시글 등록 수',//판매게시판에 등록 된 카테고리 통계 %
				            data: data,
				            backgroundColor: randomColor(labels)
				        }]
				    },
				    options: {
					    responsive: false,
				        scales: {
				            yAxes: [{
				                ticks: {
				                    beginAtZero: true
				                }
				            }]
				        }
				    }
				});
			}
			
			$.ajax({
				
				type: "POST",
				url: "/jaju/manager/getMemberCategory",
				dataType : "json",
				success: function(data) {

					console.log(JSON.stringify(data));
					var labels = [];
					var myData = [];
					
					//맵안에 list 였으니 for문으로 돌린다
					$.each(data.list,function(index, items){
					//$.each(data.list, function(index, items){});
						labels.push(items.sale_category);//items.sale_category
						myData.push(items.countCategory);//items.countCategory
					});
					var newLabels = labels.slice(-5);
					var newMyData = myData.slice(-5);
					// Chart.js 막대그래프 그리기
					var ctx = $('#myChart');
					makeChart(ctx, 'bar', newLabels, newMyData);
					// Chart.js 선그래프 그리기
					ctx = $('#myChart2');
					makeChart(ctx, 'line', newLabels, newMyData);
					// Chart.js 원그래프 그리기
					ctx = $('#myChart3');
					makeChart(ctx, 'pie', newLabels, newMyData);
					ctx = $('#myChart4');
					makeChart(ctx, 'doughnut', newLabels, newMyData);
				}
			});
			
		});
</script>
</body>
</html>