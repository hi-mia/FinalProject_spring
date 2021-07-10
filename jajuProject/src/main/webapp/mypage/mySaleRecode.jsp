<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jaju/css/myRecode.css" />
<style type="text/css">
*, *:after, *:before {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}
/*
.list_order {
	padding-top: 10px;
	border-top: 2px solid #ededed;
}
*/
.list_order .date {
	/*padding-top: 20px;*/
	font-size: 16px;
	line-height: 24px;
	font-weight: 700;
	color: #666;
}

.list_order .order_goods {
	position: relative;
	margin-top: 10px;
	padding: 0 20px;
	border: 1px solid #dddfe1;
}

.list_order .deal_name {
	padding: 20px 0 13px;
	border-bottom: 1px solid #dddfe1;
}

.list_order .deal_name a {
	display: block;
	overflow: hidden;
	background: url()
		no-repeat 100% 1px;
	font-size: 16px;
	line-height: 24px;
	font-weight: 700;
	color: #000;
	cursor: pointer;
}

.list_order .order_info {
	overflow: hidden;
	padding: 14px 0 0px;
}


.list_order .thumb {
	float: left;
	width: 130px;
    height: 130px;
    margin-bottom: 12px;
}


.list_order .thumb img {
	width: 100%;
	height: 100%;
}


.list_order .desc {
	overflow: hidden;
	padding-top: 1px;
}

.list_order .order_info dl:first-child {
	padding-top: 3px;
}

.order_info dl {
	overflow: hidden;
	padding-top: 6px;
}

.list_order .order_info dt {
	float: left;
	padding-right: 15px;
	font-size: 12px;
	color: #000;
	line-height: 20px;
	text-align: left;
    width: 80px;
}

.list_order .order_info dd {
	float: left;
	font-size: 14px;
	line-height: 20px;
	/*font-weight: 700;*/
	color: #000;
}

.list_order .order_status {
	display: table;
	position: absolute;
	right: 20px;
	bottom: 0;
	height: 114px;
	vertical-align: middle;
}

.list_order .inner_status {
	display: table-cell;
	vertical-align: middle;
}

.list_order .order_info .end {
	color: #514859;
}
.order_info .status {
	color: #5f0080;
}
ol, ul {
	list-style-type: none;
}

#currentPaging {
	display: inline-block;
    width: 34px;
    height: 34px;
    border: 1px solid #ddd;
    border-left: 1;
    vertical-align: top;
    margin-top: 15px;
    margin-bottom: 15px;
    font-weight: 700;
    line-height: 34px;
}
#currentPaging:hover{
	border: 1px solid #47597e;
}
#paging {
	display: inline-block;
    width: 34px;
    height: 34px;
    border: 1px solid #ddd;
    border-left: 1;
    vertical-align: top;
    margin-top: 15px;
    margin-bottom: 15px;
    font-weight: 700;
    line-height: 34px;
}
#paging:hover,#prev_paging:hover,#next_paging:hover{
	border: 1px solid #47597e;
}
#prev_paging{
    background-image: url(https://res.kurly.com/pc/etc/old/images/common/icon-pagination-prev.png);
	width: 34px;
    height: 34px;
    margin-top: 15px;
    margin-bottom: 15px;
    vertical-align: top;
    display: inline-block;
    background-repeat: no-repeat;
    background-position: 50% 50%;
    text-indent: -9999px;
    border: 1px solid #ddd;
}
#next_paging{
    background-image: url(https://res.kurly.com/pc/etc/old/images/common/icon-pagination-next.png);
    width: 34px;
    height: 34px;
    margin-top: 15px;
    margin-bottom: 15px;
    vertical-align: top;
    display: inline-block;
    background-repeat: no-repeat;
    background-position: 50% 50%;
    text-indent: -9999px;
    border: 1px solid #ddd;
    
    
}
/*  */
.box_search .search_input {
    float: left;
    border: 1px solid #cfd2d5;
    /*border-left: none;*/
    margin-left: 2px;
}
.box_search .select_admin {
    float: left;
    border: 1px solid #cfd2d5;
    background: #fff;
}
.box_search .tf_search {
    float: left;
    width: 165px;
    height: 32px;
    padding: 0;
    border: 0;
    font-size: 13px;
    line-height: 28px;
    color: #000;
    box-sizing: border-box;
    text-indent: 9px;
}
select {
    -webkit-writing-mode: horizontal-tb !important;
    text-rendering: auto;
    color: -internal-light-dark(black, white);
    letter-spacing: normal;
    word-spacing: normal;
    text-transform: none;
    text-indent: 0px;
    text-shadow: none;
    display: inline-block;
    text-align: start;
    appearance: auto;
    box-sizing: border-box;
    align-items: center;
    white-space: pre;
    -webkit-rtl-ordering: logical;
    background-color: -internal-light-dark(rgb(255, 255, 255), rgb(59, 59, 59));
    cursor: default;
    margin: 0em;
    border-radius: 2px;
    border-width: 1px;
    border-style: solid;
    border-color: -internal-light-dark(rgb(118, 118, 118), rgb(133, 133, 133));
    border-image: initial;
    height: 30px;
    border-radius: 5px;
    border: 0.5px solid;
	font-family: 'S-CoreDream-4Regular';
}

.textbox_default {
    display: inline-block;
    width: auto;
    height: 18px;
    padding: 7px;
    border: 1px solid #cfd2d5;
    background: #fff;
    font-size: 13px;
    line-height: 18px;
    color: #000;
    text-indent: 4px;
    outline: 0;
    vertical-align: top;
}
.box_search .btn_search .ico_admin {
    display: block;
    width: 16px;
    height: 16px;
    background-position: -20px -60px;
}
.ico_admin {
    display: inline-block;
    overflow: hidden;
    background: url(//t1.daumcdn.net/cafe_image/cf_img3/admin_2018/ico_admin_190808.png) no-repeat 0 0;
}
.box_search .btn_search {
    float: right;
    margin: 1px 2px 0 0;
    height: 30px;
    width: 30px;
    padding: 5px;
    background: rgba(0,0,0,0);
}
.ico_admin {
    background-position: -80px -40px;
}
.ico_admin {
    background-position: -70px -40px;
  
}
/*  */
</style>
</head>
<body>
	<!-- controller에서 넘어온 id/pg ,id는 임의로 만들어둔 변수명. 나중에 session값 처리-->
	<input type="hidden" id="id" name="id" value="${memId}">
	<input type="hidden" id="pg" name="pg" value="${pg}">

	<jsp:include page="/mypage/mypageMain.jsp" />

	<div class="section_review">

		<div class="head_aticle">
			<h2 class="tit">&emsp;판매 완료 내역</h2>
		</div>

		<div class="board-header-container">
			<ul class="list-description">
				<li>나의 판매완료 내역을 확인해보세요.</li>
			</ul>
		</div>

		<form name="searchform" onsubmit="" style="float:right;" >
			
				<!-- 선택한 값으로 sort하기  -->
				<div class="box_search">
					<div class="select_admin">
						<select id="searchMode" fixedsize="110" class="selectbox_styled">
							<option value="subject" selected="selected">제목</option>
							<option value="content">내용</option>
							<option value="subject_content">제목+내용</option>
						</select>
						
						<!--  <a id="searchMode_img" class="img_selectbox" tabindex="0" style="width: 90px;">닉네임+이메일</a>-->
					</div>
					
					<!-- 선택한 값으로 검색 하기  -->
					<div class="search_input">
						<input id="search-text" maxlength="20" size="25" class="tf_search textbox_default" title="검색어">
						<button type="button" id="search-text_Btn" class="btn_admin btn_search button-search">
							<span class="ico_admin"> </span>
						</button>
					</div>
				</div><!-- box_search -->
			</form>

		<div class="tabTable" align="left" id="tabTable">
			<!-- 동적 태그 들어오는 곳  -->
			<table border="1" id="mySaleRecordTable" cellpadding="5" width="750px" bordercolor="#ededed" align="center" frame="hsides" rules="rows">
				<tr class="title">

				</tr>
			</table>
		</div>

		<div style="margin: 25px; width: 700px; text-align: center;"
			id="mySaleRecodePagingDiv"></div>
	</div>

	<input type="hidden" id="searchPg" value="1">

	<script type="text/javascript"
		src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/jaju/js/mySaleRecode.js"></script>
	
	
	<script type="text/javascript">
	function mySalePaging(pg){
		
		//location.href="mySaleRecode?pg="+pg;

		var keyword = document.getElementById('search-text').value;
	if(keyword == ''){
		location.href="mySaleRecode?pg="+pg;
	}else{
		$('#searchPg').val(pg);
		//alert($('#searchPg').val())
		$('#search-text_Btn').trigger('click','research');
		
		//$('#searchPg').val(1);
		
	}
}
	</script>
</body>
</html>