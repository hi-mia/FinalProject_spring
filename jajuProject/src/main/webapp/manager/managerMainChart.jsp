<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자메인</title>
<link rel="stylesheet" href="/jaju/manager_css/managerMainChart.css" />
<link rel="stylesheet" href="/jaju/manager_css/managerMainChartCss.css" />
<link rel="stylesheet" href="/jaju/manager_css/managerMainApp.css" />

</head>

<body>

<div>
	<jsp:include page="/manager/managerHeader.jsp"/>
</div>

<div style="width: 1300px; margin: 0 auto;">

<div>
	<jsp:include page="/manager/managerMenu.jsp"/>
</div>

<div>
	<jsp:include page="/manager/managerMainContent.jsp"/>
</div>

<div style=" margin-left: 250px;">

<div id="content" class="adm_home" style="display:none;">
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
				<span class="stat_title">신규 가입회원<br><br></span>
				<a id="newMemberValue" class="stat_value" href="/_c21_/founder_stat_cafe?grpid=1Z5bV&amp;kind=JOIN">0</a>
				<span class="stat_increase" id="newMemberDelta">
					<span class="ico_increase"><span class="sr_only">가입자수 변동없음</span></span>
					<span class="value_increase"></span>
				</span>
			</div>
			
			<div class="stat last_child">
				<span class="stat_title">판매 게시글<br><br></span>
				<a id="newArticleValue" class="stat_value" href="/_c21_/founder_stat_cafe?grpid=1Z5bV&amp;kind=WRITE_ARTICLE">0</a>
				<span class="stat_increase" id="newArticleDelta">
					<span class="ico_increase"><span class="sr_only">새글수 변동없음</span></span>
					<span class="value_increase"></span>
				</span>
			</div>
		</div>
	</div>



	<!-- 차트 -->
	<div class="drawChart"> 
		<!-- <h1>게시물데이터그래프화</h1> -->
		
		<div class="google_chart" id="chart_div"></div>
		<div class="chart_js">
			<canvas id="myChart"  width="400" height="400" align="center"></canvas>
			<!-- <canvas id="myChart2"  width="400" height="400" align="center"></canvas>
			<canvas id="myChart3"  width="400" height="200" align="center"></canvas>
			<canvas id="myChart4"  width="400" height="200" align="center"></canvas> -->
		</div>
	</div><!-- 차트 -->
	
	<!-- 판매물품 등록 많은 지역 -->
	<div class="drawLocationChart">
		<jsp:include page="/manager/managerMainLocationChart.jsp"/>
	</div>
	
</div>
</div><!-- 1280px div -->





 <!--Load the AJAX API-->
 	<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>	
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
   	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
    
    <script type="text/javascript">
    /*================================google chart================================*/
    
      
      /*================================chart.js================================*/
      //차트 색상 랜덤
		$(function() {
			  google.charts.load('current', {'packages':['corechart']}); //구글 차트 load 하기 
		      google.charts.setOnLoadCallback(drawChart); //화면에 그리는 function호출,..
		      
		      function drawChart() {
					var labels = [];
					var myData = [];
					var newLabels = labels.slice(-5);
					var newMyData = myData.slice(-5);
					// Create the data table.
			        var data = new google.visualization.DataTable();
			        data.addColumn('string', 'Topping');
			        data.addColumn('number', 'Slices');
			       /*  data.addRows([
				          [ newLabels , newMyData ]
			        ]); */    
			        
			        $.ajax({
						type: "POST",
						url: "/jaju/manager/getMemberCategory",
						dataType : "json",
						success: function(data1) {
							
							$.each(data1.list,function(index, items){
								labels.push(items.sale_category);//items.sale_category
								myData.push(items.countCategory);//items.countCategory
							});
							
							newLabels = labels.slice(-5);
							newMyData = myData.slice(-5);
							//alert("newLabels: "+newLabels);
							//alert("newMyData: "+newMyData);
					     
					        var arr = new Array();
					        for(var i=0; i < newLabels.length; i++){
					        arr[i] = [newLabels[i], newMyData[i]];
					        }
					        data.addRows(arr);

					        // Set chart options
					        var options = {'title':'판매게시물 등록 카테고리 현황',
					                       'width':450,
					                       'height':450};
					        // Instantiate and draw our chart, passing in some options.
					        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
					        chart.draw(data, options);
					        google.charts.setOnLoadCallback();
					        
						},error:function(err){
							console.log("구글차트 오류발생"+err)
						}
			        });
		      }
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
				            label: '인기 카테고리 BEST 5',//판매게시판에 등록 된 카테고리 통계 %
				            data: data,
				            //backgroundColor: //randomColor(labels)
				            backgroundColor: [
								'rgba(255, 99, 132, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(255, 206, 86, 0.2)',
								'rgba(75, 192, 192, 0.2)',
								'rgba(153, 102, 255, 0.2)',
								'rgba(255, 159, 64, 0.2)'
							],
							borderColor: [
								'rgba(255, 99, 132, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(255, 206, 86, 1)',
								'rgba(75, 192, 192, 1)',
								'rgba(153, 102, 255, 1)',
								'rgba(255, 159, 64, 1)'
							],
							borderWidth: 2
				        }]
				    },
				    options: {
					    responsive: false,
				        scales: {
				            yAxes: [{
				                ticks: {
				                    beginAtZero: true,
				                    fontColor : 'rgba(12, 13, 13, 1)',
									fontSize : 14
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
					//var ctx = $('#myChart');
					//makeChart(ctx, 'bar', newLabels, newMyData);
					
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
			
			//이건 막대 그래프 (일주일 단위, 하루 판매 개수 가져오기 )
$.ajax({
				
				type: "POST",
				url: "/jaju/manager/getSaleAvg",
				dataType : "json",
				success: function(data) {
					
					var labels = [];
					var myData = [];
					/*
					//맵안에 list 였으니 for문으로 돌린다
					$.each(data.list,function(index, items){
					//$.each(data.list, function(index, items){});
						labels.push("여기에 넣기 ");//items.sale_category
						myData.push();//items.countCategory
					});
					var newLabels = labels.slice(-5);
					var newMyData = myData.slice(-5);
					*/
					
					// Chart.js 막대그래프 그리기
					var ctx = $('#myChart');
					/* var chart = new Chart(ctx, 
							{ // type : 'bar' = 막대차트를 의미합니다. 
								type: 'bar', // 
								data: { labels: [data.managerMainDTO.dd7,data.managerMainDTO.dd6,data.managerMainDTO.dd5,data.managerMainDTO.dd4,data.managerMainDTO.dd3,data.managerMainDTO.dd2,data.managerMainDTO.dd1], 
									
										datasets: [{ 
										label: '판매수량', 
										backgroundColor: 'rgb(255, 99, 132)', 
										borderColor: 'rgb(255, 99, 132)', 
										data: [data.managerMainDTO.d7,data.managerMainDTO.d6,data.managerMainDTO.d5,data.managerMainDTO.d4,data.managerMainDTO.d3,data.managerMainDTO.d2,data.managerMainDTO.d1]}] 
					}, 
					});//var chart  */
					
					var myChart = new Chart(ctx, {
					    type: 'bar',
					    data: {
					        labels: [data.managerMainDTO.d7,data.managerMainDTO.d6,data.managerMainDTO.d5,data.managerMainDTO.d4,data.managerMainDTO.d3,data.managerMainDTO.d2,data.managerMainDTO.d1],
					        datasets: [{
					        label: '날짜별 게시글 등록 수',//판매게시판에 등록 된 카테고리 통계 %
					        data: [data.managerMainDTO.dd7,data.managerMainDTO.dd6,data.managerMainDTO.dd5,data.managerMainDTO.dd4,data.managerMainDTO.dd3,data.managerMainDTO.dd2,data.managerMainDTO.dd1],
					        backgroundColor: [
								'rgba(255, 99, 132, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(255, 206, 86, 0.2)',
								'rgba(75, 192, 192, 0.2)',
								'rgba(153, 102, 255, 0.2)',
								'rgba(255, 159, 64, 0.2)'
							],
							borderColor: [
								'rgba(255, 99, 132, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(255, 206, 86, 1)',
								'rgba(75, 192, 192, 1)',
								'rgba(153, 102, 255, 1)',
								'rgba(255, 159, 64, 1)'
							],
							borderWidth: 2
				        }]
					    },
					    options: {
						    responsive: false,
					        scales: {
					            yAxes: [{
					                ticks: {
					                    beginAtZero: true,
					                    fontColor : 'rgba(12, 13, 13, 1)',
										fontSize : 14
					                }
					            }]
					        }
					    }
					});//var chart 
					
				}
			});
		});
      
      
      
</script>
<script type="text/javascript">
$(document).ready(function(){
   
   $('#managerMainChart').addClass('on');
});
</script>
</body>
</html>