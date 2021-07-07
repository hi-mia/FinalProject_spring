<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jaju/css/retireCheck.css" />
</head>
<body>
	<div id="daumContent" role="main">
		<div id="cMain">
			<div id="mArticle">
				<h2 id="daumBody" class="screen_out">회원탈퇴 별도해지서비스 본문</h2>

				<div class="myinfo_intro intro_out">
					<span class="bg_intro"></span>

					<div class="cont_intro">
						<h3 class="tit_comm tit_termination">비밀번호 확인을
							진행하셔야 회원탈퇴가 가능합니다.</h3>
					</div>
				</div>



				<form>
					<div class="info_termination">
						<div class="content check_password_wrap">
							<div class="margin-wrap">
								<h1>
									<img
										src="/jaju/jajuImage/img_title_check_pw-b5aab5c18cd44aa3169dd84a0baf2cea8fa01a85ed38eb7ab2b78114cf294894.png">
								</h1>
								<p class="info">
									회원님의 소중한 정보 보호를 위해 비밀번호 확인이 필요합니다.<br>
									<br> jajuMarket 현재 비밀번호를 입력해 주세요.<br>확인이
									완료되면 요청하신 탈퇴 서비스로 이동합니다.
								</p>

								<div class="form-holder">
									<div class="form-group">
										<label>아이디</label>
										<div class="email" id="member_id"></div>
									</div>
									<div class="form-group">
										<label class="password">비밀번호</label>
										<div>
											<input type="password" id="password" placeholder="비밀번호">
											<div id="pwdDiv"></div>
										</div>
									</div>
								</div>
								<div class="btn_group">
									<a href="javascript: void(0)" id="check_password" class="btn_check">확인</a>
								</div>
							</div>
						</div>
						<div class="wrap_btn" style="display: none;">
			              <a href="/jaju/" class="btn_type2 btn_retire"><span class="txt_type">탈퇴 취소</span></a>
			              <button type="button" class="btn_type1" id="nextBtn"><span class="txt_type">탈퇴하기</span></button>
			            </div>
					</div>
				</form>
			</div>
			<!--// mArticle -->
		</div>
		<!-- // cMain -->
	</div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/jaju/js/retireCheck.js"></script>
</html>