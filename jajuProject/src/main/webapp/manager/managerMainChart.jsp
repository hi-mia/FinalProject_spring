<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자메인</title>
<style type="text/css">

</style>
<link rel="stylesheet" href="/jaju/manager_css/managerMainChartCss.css" />
<link rel="stylesheet" href="/jaju/manager_css/managerMainChart.css" />
<link rel="stylesheet" href="/jaju/manager_css/managerMainApp.css" />
</head>

<body>

	<div>
		<jsp:include page="/manager/managerHeader.jsp" />
	</div>

	<div style="width: 1260px; margin: 0 auto;">

		<div>
			<jsp:include page="/manager/managerMenu.jsp" />
		</div>

		<div>
			<jsp:include page="/manager/managerMainContent.jsp" />
		</div>

		<div style="margin-left: 250px;">



	<!-- 차트 -->
	<div class="drawChart"> 
		
		<!-- <h1>구글 /chart.js</h1> -->
		
		 <div class="google_chart" id="chart_div">
			<h5 style="text-align: center; class="mb-0 ms-3">판매게시판 등록 카테고리 현황</h5>
		</div>
		<!--
		<div class="chart_js_category" style="width: 485px; height:485px;">
			<h5 style="text-align: center; class="mb-0 ms-3">판매게시판 등록 카테고리 현황</h5>
			<canvas id="myChart2" style="display:inline-block; " width="400" height="400" ></canvas>
		</div> -->
		
		<div class="chart_js" style="width: 485px; height:485px;">
				<h5 style="text-align: center; class="mb-0 ms-3">판매게시판 일별(7일) 게시물</h5>
			<canvas id="myChart" style="display:inline-block; " width="400" height="422" ></canvas>
		</div>
	</div><!-- 차트 -->
	
	<!-- 판매물품 등록 많은 지역 -->
	<div class="drawLocationChart" style="margin-top: 30px;">
		
		<jsp:include page="/manager/managerMainLocationChart.jsp"/>
	</div>
	


	<!--Load the AJAX API-->
	<script type="text/javascript"	src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript"	src="https://www.gstatic.com/charts/loader.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script	src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
		
	<script type="text/javascript">
		//차트 색상 랜덤
		$(function() {
			
			$('#managerMainChart').addClass('on');
			
			google.charts.load('current', {
				'packages' : [ 'corechart' ]
			}); //구글 차트 load 하기 
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
					type : "POST",
					url : "/jaju/manager/getMemberCategory",
					dataType : "json",
					async: false,
					success : function(data1) {

						$.each(data1.list, function(index, items) {
							labels.push(items.sale_category);//items.sale_category
							myData.push(items.countCategory);//items.countCategory
						});

						newLabels = labels.slice(-5);
						newMyData = myData.slice(-5);
						//alert("newLabels: "+newLabels);
						//alert("newMyData: "+newMyData);

						var arr = new Array();
						for (var i = 0; i < newLabels.length; i++) {
							arr[i] = [ newLabels[i], newMyData[i] ];
						}
						data.addRows(arr);

						// Set chart options
						var options = {
							'title' : '              판매게시물 등록 카테고리 현황',
							fontSize: 20,
							titlePosition: 'out',
							'width' : 485,
							'height' : 485,
							legend : { position: "bottom"},
							pointSize : 5,
							isStacked: false,
				            tooltip:{textStyle : {fontSize:12}, showColorCode : true},
				            animation: { //차트가 뿌려질때 실행될 애니메이션 효과
				            startup: true,
				            duration: 1000,
				            easing: 'linear' 
				            },
				            annotations: {
				            textStyle: {
				            fontSize: 15,
				            bold: true,
				            italic: true,
				            color: '#871b47',
				            auraColor: '#d799ae',
				            opacity: 0.8
				               }
				            }
						};
						// Instantiate and draw our chart, passing in some options.
						var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
						chart.draw(data, options);
						window.addEventListener('resize', drawChart, false);
						google.charts.setOnLoadCallback();

					},
					error : function(err) {
						console.log("구글차트 오류발생" + err)
					}
				});
			}//drawChart
			
			/*========================= here ==========================*/
			function randomColor(labels) {
				var colors = [];
				for (let i = 0; i < labels.length; i++) {
					colors.push("#"	+ Math.round(Math.random() * 0xffffff).toString(16));
				}
				return colors;
			}

			function makeChart(ctx, type, labels, data) {
				var myChart = new Chart(ctx, {
					type : type,
					data : {
						labels : labels,
						datasets : [ {
							label : '인기 카테고리 BEST 5',//판매게시판에 등록 된 카테고리 통계 %
							data : data,
							//backgroundColor: //randomColor(labels)
							backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 206, 86, 0.2)',
									'rgba(75, 192, 192, 0.2)',
									'rgba(153, 102, 255, 0.2)',
									'rgba(255, 159, 64, 0.2)' ],
							borderColor : [ 'rgba(255, 99, 132, 1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255, 206, 86, 1)',
									'rgba(75, 192, 192, 1)',
									'rgba(153, 102, 255, 1)',
									'rgba(255, 159, 64, 1)' ],
							borderWidth : 2
						} ]
					},
					options: {
						responsive: false,
						legend: {
							labels: {
								fontColor: "#333",
								fontSize: 15,
							}
						},
						scales: {
							yAxes: [{
								ticks: {
									beginAtZero: true,
									stepSize : 2,
									fontColor : "rgba(251, 203, 9, 1)",
									fontSize : 14,
								}
							}],
							xAxes: [{
								ticks:{
									fontColor : 'rgba(12, 13, 13, 1)',
									fontSize : 14
								}
							}]
						}
					}
				});
			}//makeChart

			$.ajax({
				type : "POST",
				url : "/jaju/manager/getMemberCategory",
				dataType : "json",
				async: false,
				success : function(data) {

					//console.log(JSON.stringify(data));
					var labels = [];
					var myData = [];

					//맵안에 list 였으니 for문으로 돌린다
					$.each(data.list, function(index, items) {
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
					makeChart(ctx, 'doughnut', newLabels, newMyData);

					// Chart.js 원그래프 그리기
					//ctx = $('#myChart3');
					//makeChart(ctx, 'pie', newLabels, newMyData);

					//ctx = $('#myChart4');
					//makeChart(ctx, 'doughnut', newLabels, newMyData);
				}
			});//getMemberCategory ajax

			//이건 막대 그래프 (일주일 단위, 하루 판매 개수 가져오기 )
			$.ajax({
				type : "POST",
				url : "/jaju/manager/getSaleAvg",
				dataType : "json",
				async: false,
				success : function(data) {
					//consoloe.log(JSON.stringify(data));
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

					var myChart = new Chart(ctx, {
						type : 'line',
						data : {
							labels : [ data.managerMainDTO.d7,
									data.managerMainDTO.d6,
									data.managerMainDTO.d5,
									data.managerMainDTO.d4,
									data.managerMainDTO.d3,
									data.managerMainDTO.d2,
									data.managerMainDTO.d1 ],
							datasets : [ {
								label : '날짜별 게시글 등록 수',//판매게시판에 등록 된 카테고리 통계 %
								data : [ data.managerMainDTO.dd7,
										data.managerMainDTO.dd6,
										data.managerMainDTO.dd5,
										data.managerMainDTO.dd4,
										data.managerMainDTO.dd3,
										data.managerMainDTO.dd2,
										data.managerMainDTO.dd1 ],
								backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
										'rgba(54, 162, 235, 0.2)',
										'rgba(255, 206, 86, 0.2)',
										'rgba(75, 192, 192, 0.2)',
										'rgba(153, 102, 255, 0.2)',
										'rgba(255, 159, 64, 0.2)' ],
								borderColor : [ 'rgba(255, 99, 132, 1)',
										'rgba(54, 162, 235, 1)',
										'rgba(255, 206, 86, 1)',
										'rgba(75, 192, 192, 1)',
										'rgba(153, 102, 255, 1)',
										'rgba(255, 159, 64, 1)' ],
								borderWidth : 2
							} ]
						},
						options : {
							responsive : false,
							
							legend: {
								display:true,
								labels: {
									fontColor: "#333",
									fontFamily:'S-CoreDream-4Regular',
									fontSize: 15									
								}
							},

							scales : {
								yAxes : [ {
									ticks : {
										min: 0,//x축
										max: 50,//y축 숫자 
										fontColor : 'rgba(12, 13, 13, 1)',
										fontFamily:'S-CoreDream-4Regular',
										fontSize : 18
									}
								} ]
							}
						}
					});//var chart 

				}
			});//getSaleAvg ajax

			

		});//$(function())
</script>

</body>
</html>