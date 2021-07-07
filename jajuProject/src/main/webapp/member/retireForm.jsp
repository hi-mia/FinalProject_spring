<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jaju/css/retireForm.css" />
</head>
<body>
<div id="daumWrap" class="">
    
    <div id="daumContent" role="main">
      <div id="cMain">
        <div id="mArticle">
          <div class="dimmed_layer" style="display:none"></div>
          <h2 id="daumBody" class="screen_out">회원탈퇴 안내동의 본문</h2>
          <div class="myinfo_intro intro_out">
            <span class="bg_intro"></span>
            <div class="cont_intro">
              <h3 class="tit_comm tit_outagree">회원탈퇴에 앞서 유의사항 및 안내를 반드시 읽고 진행해 주세요!</h3>
            </div>
          </div>
          <form>

            <div class="info_agree">

              <div class="info_user">
                <strong class="tit_agree">JajuMarket 아이디는 재사용 및 복구 불가 안내</strong>
                <span class="txt_agree">회원탈퇴 진행 시 본인을 포함한 타인 모두 <em class="emph_g">아이디 재사용이나 복구가 불가능합니다.</em><br>
                신중히 선택하신 후 결정해주세요.</span>
                <span class="check_notice">
                  <input type="checkbox" id="idAgree" name="idAgree" class="tf_check">
                  <label for="idAgree" class="lab_check">
                    <span class="ico_comm ico_check"></span>
                    동의
                  </label>
                </span>
              </div>

              <div class="info_user">
                <strong class="tit_agree">내정보 및 개인형 서비스 이용 기록 삭제 안내</strong>
                <span class="txt_agree">내정보 및 개인형 서비스 이용기록이 모두 삭제되며,<em class="emph_g">삭제된 데이터는 복구되지 않습니다.</em><br>삭제되는 서비스를 확인하시고, 필요한 데이터는 미리 백업을 해주세요.</span>
                <span class="check_notice">
                  <input type="checkbox" id="serviceAgree" name="serviceAgree" class="tf_check">
                  <label for="serviceAgree" class="lab_check">
                    <span class="ico_comm ico_check"></span>
                    동의
                  </label>
                </span>
              </div>

              <div class="info_user">
                <strong class="tit_agree">게시판형 서비스에 등록한 게시글 삭제 불가 안내</strong>
                <span class="txt_agree">삭제를 원하는 게시글이 있다면 반드시 회원탈퇴 전 삭제하시기 바랍니다.<br>탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어, <em class="emph_g">게시글을 임의로 삭제해드릴 수 없습니다.</em></span>
                <span class="check_notice">
                  <input type="checkbox" id="boardAgree" name="boardAgree" class="tf_check">
                  <label for="boardAgree" class="lab_check">
                    <span class="ico_comm ico_check"></span>
                    동의
                  </label>
                </span>
              </div>
            </div>
            <div class="wrap_btn">
              <a href="/jaju/" class="btn_type2 btn_retire"><span class="txt_type">탈퇴 취소</span></a>
              <button type="button" class="btn_type1" id="nextBtn"><span class="txt_type">다음 단계</span></button>
            </div>
          </form>

          <!-- 회원탈퇴_안내동의 팝업 -->
          <div id="wrongLayer" class="userinfo_layer" style="top:300px;margin-left:-188px;display:none;">
            <div class="inner_myinfo_layer">
              <div class="layer_head">
                <strong class="screen_out">회원탈퇴 안내동의 레이어</strong>
              </div>
              <div class="layer_body">
                <strong class="tit_layer">안내사항을 확인하신 후, 동의해 주세요.</strong>
                <div class="btn_process">
                  <button type="button" class="btn_comm btn_ok" data-tiara-action-name="확인"><span class="screen_out">확인</span></button>
                </div>
              </div>
              <div class="layer_foot">
                <button type="button" class="btn_comm btn_close" data-tiara-action-name="닫기">닫기</button>
              </div>
            </div>
          </div>

        </div><!--// mArticle -->
      </div><!-- // cMain -->
    </div>
  <!-- // daumContent -->
</div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/jaju/js/retireForm.js"></script>
</html>