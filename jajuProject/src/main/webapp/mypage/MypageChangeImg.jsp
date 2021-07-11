<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 이미지 변경</title>
<link rel="stylesheet" href="/jaju/css/myPageChangeImg.css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css" integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">



<style type="text/css">

@font-face {
     font-family: 'S-CoreDream-4Regular';
     src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-4Regular.woff') format('woff');
     font-weight: normal;
     font-style: normal;
}
body {
	font-family: 'S-CoreDream-4Regular';
}
#member_image{
    width: 0.2px;
   height: 0.2px;
   opacity: 0;
   overflow: hidden;
   position: absolute;
   z-index: -1;
}

#member_image + label {
    border: 1px solid #d9e1e8;
    background-color: #fff;
    color: #617aad;
    border-radius: 2rem;
    padding: 8px 15px 8px 17px;
    font-weight: 500;
    font-size: 15px;
    box-shadow: 1px 2px 3px 0px #f2f2f2;
    outline: none;
    margin-left: -10px;
}

#member_image:focus + label,
#member_image + label:hover {
    cursor: pointer;
}
.fa-file-image{
   font-size: 18px;
   margin-right: 6px;
}



</style>
</head>
<body>
<!-- 프로필 이미지 변경 (간단한 정보 변경?) -->

   <form name="myPageChangeImgForm"  id="myPageChangeImgForm">
   
      <input type="hidden" name="pg" id="pg" value="${pg}" />
      <input type="hidden" name="id" id="id" value="${memId}" />

      <h1 id="profile_name" align="center" >프로필 변경</h1>

      <table id="profileFont" border="0" id="table" cellspacing="0" cellpadding="10" bordercolor="#fff" align="center" 
         width="450px" height="270px" frame="hsides" rules="rows">

         <tr>
            <td rowspan="4" class="image" align="center" style="margin-top:5px; margin-bottom:5px;">
            
            <img id="image1"  width="180px" height="180px"></td>
            <td id="profileFont">이름</td>
            <td width="90px"><span id="member_name_span"></span></td>
         </tr>
   
         <tr>
            <td id="profileFont">매너온도</td>
            <td><span id="member_manner_span"></span></td>
         </tr>

         <tr>
            <td id="profileFont">현재지역</td>
            <td><span id="member_location_span"></span></td>
         </tr>

         <tr>
            <!-- <td>이미지 변경 :<span id="totalSpan"></span></td> -->
            <td colspan="3" width="100%" >
                 <input type="file" name="member_image" id="member_image" />
                  <label for="member_image"><i class="far fa-file-image"></i>&nbsp;파일 선택</label>
               </td>
         </tr>

        <tr>
            <td colspan="3" align="right">
            <button id="update_btn" >이미지 수정하기</button></td>
         </tr>
      </table>
   </form>      
   
       	<div class="deal_wrap" height="300">
       	
			<table border="0" id="historyTable" width="450px" cellpadding="5" bordercolor="#ededed" align="center" frame="hsides" rules="rows">
				<tr class="title">
					<th width="200px" align="center" class="tooltip">내가 받은 거래후기
					<span class="tooltip-text" align="left">제목을 클릭하면 해당 페이지로 이동합니다. </span>
					</th>
				</tr>
			</table>
			
			
		</div>
		
					 <div style="margin: 0px; text-align: center;" id="getMyProfileReviewListPagingDiv"></div>
		
         
<!--          <tr>
            <td id="saleContentTd" colspan="3" align="center" height="250px" style="padding-bottom: 0px;">
            <span class="profileFont" id="saleContentSpan">내 판매 후기 내역</span>
            </td>
         </tr>
		<tr>
         <td colspan="3" align="center">
         <div style="margin: 0px; text-align: center;"
			id="getMyProfileReviewListPagingDiv"></div>
		 </td>
		 </tr> -->

         

   
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/jaju/js/myPageChangeImg.js"></script>
<script type="text/javascript">
function myRecodePaging(pg){
	location.href="MypageChangeImg?pg="+pg;
}
</script>
</body>
</html>