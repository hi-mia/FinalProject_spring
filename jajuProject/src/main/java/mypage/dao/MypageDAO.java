package mypage.dao;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import mypage.bean.FollowDTO;
import mypage.bean.MessageDTO;
import mypage.bean.MyCountDTO;
import mypage.bean.MylocationDTO;
import mypage.bean.MypageDTO;
import saleboard.bean.SaleboardDTO;
import mypage.bean.ScrapDTO;
import reviewboard.bean.ReviewboardDTO;

public interface MypageDAO {

	public MypageDTO getKeywordList(String id);

	public void myKeyword(Map<String, Object> map);

	public void updateMyKeyword(Map<String, String> map);

	public int getKeywordCountNum(String id);

	public List<MemberDTO> getFollowList(Map<String, String> map);

	public void deleteFollowList(Map<String, String[]> map);

	public int getTotalA(String id);

	public List<MessageDTO> getMyMessageList(Map<String, String> map);

	public List<ScrapDTO> getMyScrapList(Map<String, String> map);
	
	//location

	public void mylocationWrite(Map<String, String> map);

	public void mylocationWrite2(Map<String, String> map);

	public void mylocationDelete(Map<String, String> map);
	
	public void mylocationDelete2(Map<String, String> map);
	
	public List<MylocationDTO> mylocationList(Map<String, String> map);

	public List<MylocationDTO> mylocationCount(Map<String, String> map);

	public MylocationDTO getMemberLocation(Map<String, String> map);

	public void deleteMyMessage(Map<String, String[]> map);

	public void deleteMyScrap(Map<String, String[]> map);

	public int getScrapTotalA(String id);

	public MessageDTO myMessageView(Map<String, String> map);

	//recode
	//Sale,Buy,Deal 리스트
	public List<SaleboardDTO> mySaleRecodeList(Map<String, String> map);
	//Sale,Buy,Deal 리스트 페이징처리
	public int getTotalASale(String id);

	public List<SaleboardDTO> myBuyRecodeList(Map<String, String> map);

	public int getTotalABuy(Map<String, String> map);

	public List<SaleboardDTO> myDealRecodeList(Map<String, String> map);

	public int getTotalADeal(String id);
	//Sale  리스트 검색
	public List<SaleboardDTO> mySaleRecodeSearchList(Map<String, String> map);
	//Sale  리스트 검색 페이징 처리
	public int getTotalASaleSearch(Map<String, String> map);
	//Buy  리스트 검색
	public List<SaleboardDTO> myBuyRecodeSearchList(Map<String, String> map);
	//Buy  리스트 검색 페이징 처리
	public int getTotalABuySearch(Map<String, String> map);
	//Deal  리스트 검색
	public List<SaleboardDTO> myDealRecodeSearchList(Map<String, String> map);
	//Deal  리스트 검색 페이징 처리
	public int getTotalADealSearch(Map<String, String> map);
	
	public List<MyCountDTO> mysaleStateCount(Map<String, String> map);

	public String getMemberName(String id);

	public String getMemberMannerTemp(String id);
	
	public String getTotalScrapCount(String id);

	public String getTotalFollowCount(String id);

	public String getTotalMessageCount(String id);

	public void writeMyScrap(Map<String, String> map);

	public ScrapDTO getMyScrap(Map<String, String> map);

	public void deleteMyScrapView(Map<String, String> map);

	public String getNotReadMessageCount(String id);

	public void writeMyMessage(Map<String, String> map);

	public MemberDTO getMyProfileInfo(Map<String, String> map);

	public int getMyMessageListPageTotalA(String id);

	public List<SaleboardDTO> getMyFollowSaleList(Map<String, String> map, String followId);

	public int getMyFollowSaleListPageTotalA(String followId);

	public void updateProfileImage(Map<String, String> map);

	public void changeMessageState(String seq);

	public void replyMyMessage(Map<String, String> map);

	public MessageDTO myMessageFormLoad(String seq);

	public List<MemberDTO> getMyFollowProfile(String followId);

	public MemberDTO getFollowerIdManner(Map<String, String> map);

	public void writeMyFollow(Map<String, String> map);

	public FollowDTO getMyFollow(Map<String, String> map);

	public void deleteMyFollow(Map<String, String> map);
	// 프로필 후기 내역
	public List<ReviewboardDTO> getMyProfileReviewList(Map<String, String> map);

	public int getMyProfileReviewListPagetotalA(String id);

	public List<ReviewboardDTO> reviewListCheck(Map<String, String> map);





}
