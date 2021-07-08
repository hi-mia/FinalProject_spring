<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지역차트</title>

<style type="text/css">

@font-face {
     font-family: 'S-CoreDream-4Regular';
     src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-4Regular.woff') format('woff');
     font-weight: normal;
     font-style: normal;
}
*{
	font-family: 'S-CoreDream-4Regular';
}
.card {
	width: 970px !important;
	/*+*/
	margin-left: 5px;
	/*height: 300px!important;*/
	
}
.chart_js{
	width: 920px;
	height: 485px;
	display: inline-block;
	background-color: #fff;
	min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 1px solid rgba(0, 0, 0, .125);
    border-radius: .7rem;
    padding-top: 30px;
    padding-left: 15px;
}
</style>
<link rel="stylesheet" href="/jaju/manager_css/managerMainChart.css" />
</head>
<body>

	<div class="col-12 col-xl-4" style="width: 970px; height: 650px;">
		<div class="card" style="width: 970px; height: 650px;">
			<div class="card-header" style="width: 970px; height: 650px;">
				<h2 align="center">관심지역 통계</h2>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-6" style="display: none;">
						<div class="d-flex align-items-center">
							<svg class="bi text-primary" width="32" height="32" fill="blue" style="width: 10px">
                                  <use xlink:href="assets/vendors/bootstrap-icons/bootstrap-icons.svg#circle-fill"></use>
                           		</svg>
						</div>
					</div>

					<div class="col-12" style="position: relative;">

						<!-- 여기 차트 들어갈 위치 -->
						<div class="chart_js">
							<canvas id="myChart3"  style="width:880px; height:445px; align:center; padding: 25px 30px 20px; font-family:'S-CoreDream-4Regular';" ></canvas>
						</div>

						<div class="resize-triggers">
							<div class="expand-trigger" style="width: 970px; height: 30px;">
								<div style="width: 248px; height: 96px;"></div>
							</div>
							<div class="contract-trigger"></div>
						</div>
					</div>
				</div>
				<%--.row{display:table-cell} --%>

			</div>
		</div>
	</div>

	<!--Load the AJAX API-->
 	<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>	
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
   	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
    
    <script>
  //선 여러개로 표현하기 
  //이건 막대 그래프 (일주일 단위, 하루 판매 개수 가져오기 )
  $(function() {

  	function makeChart(ctx, type, labels, data) {
  		
  		var myChart = new Chart(ctx, {
  		    type: type,
  		    data: {
  		        labels: labels,
  		        datasets: [{
  		            label: '관심등록 인기 BEST 5',//판매게시판에 등록 된 카테고리 통계 %
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
  		    	responsive : false,
  		    	tooltips: {
  		          mode: 'index',
  		          bodySpacing: 5,
  		          bodyFontFamily: 'S-CoreDream-4Regular',
  		          bodyFontSize: 20
  		        },
				legend: {
					display:true,
					labels: {
						fontColor: "#333",
						fontSize: 25,
						fontFamily:'S-CoreDream-4Regular',
						fontStyle:'bold'
					}
				},
  		        scales: {
  		        	xAxes: [{ 
  		        		ticks: { 
	        			min: 0,
						max: 10,
  		        		fontColor: 'rgba(12, 13, 13, 1)', 
  		        		fontFamily:'S-CoreDream-4Regular',
  		        		fontSize: 18
  		        		} 
  		        	}],

  		            yAxes: [{
  		                ticks: {
  		                	min: 0,
							max: 25,
  		                    fontColor : 'rgba(12, 13, 13, 1)',
  		                  	fontFamily:'S-CoreDream-4Regular',
  							fontSize : 18
  		                }
  		            }]
  		        }
  		    }
  		});
  	}//makeChart
  	
  	//관심지역 불러오기
  	$.ajax({
  		type : "POST",
  		url : "/jaju/manager/getLocationInfo",
  		dataType : "json",
  		success : function(data) {
  			var labels = [];
  			var myData = [];

  			//맵안에 list 였으니 for문으로 돌린다
  			$.each(data.list, function(index, items) {
  				console.log("관심지역도넛: most_Regist?"+ JSON.stringify(data));

  				labels.push(items.most_Regist);//items.sale_category
  				myData.push(items.count);//items.countCategory
  			});
  			var newLabels = labels.slice(-5);
  			var newMyData = myData.slice(-5);

  			ctx = $('#myChart3');
  			makeChart(ctx, 'horizontalBar', newLabels, newMyData);

  		}
  	});// getLocationInfo ajax
  });
    </script>


</body>
</html>