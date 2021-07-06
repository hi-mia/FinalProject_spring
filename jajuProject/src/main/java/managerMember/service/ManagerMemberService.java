package managerMember.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import managerMember.bean.ManagerMainDTO;
import managerMember.bean.ManagerPaging;
import member.bean.MemberDTO;

public interface ManagerMemberService {
	
	public List<MemberDTO> getManagerMember(Map<String, String> map);
	
	public void deleteMemberId(String[] check);
	
	public void changeMemberState(String[] check);
	//블랙리스트 회원 활동정지 해제
	public void changeBlackMemberStateRollback(String[] check);
	
	public List<MemberDTO> getSearchMemberInfo(Map<String, String> map);

	public List<MemberDTO> getManagerMemberBlack(Map<String, String> map);
	//전체회원 리스트 페이징 처리하기
	public ManagerPaging managerPaging(Map<String, String> map);
	//검색 후 페이징 처리하기
	public ManagerPaging managerSearchPaging(Map<String, String> map);
	//블랙리스트 회원 리스트 페이징 처리하기
	public ManagerPaging managerPagingBlack(Map<String, String> map);
	//블랙리스트 회원 검색(search) 리스트 페이징
	public ManagerPaging managerSearchBlackPaging(Map<String, String> map);
	//블랙리스트 회원 검색(search) 리스트
	public List<MemberDTO> getSearchManagerMemberBlack(Map<String, String> map);
	
	//차트 - 키워드 , 키워드 개수 
	public List<ManagerMainDTO> getMemberCategory();

	public ManagerMainDTO getSaleAvg();

	public List<ManagerMainDTO> getLocationInfo();
	
	/*==== MAINCHART COUNT(*) NUM FROM DB ====*/
	//1:1문의
	public int getManagerInquireCount();
	//신고글 
	public int getManagerReportCount();
	//신규회원가입 멤버수 
	public int getManagerMemberCount();
	//당일 판매 게시글 수 
	public int getManagerSaleReportCount();

	//어제 날짜 1:1
	public int getPrevInquireCount();
	//어제 날짜
	public int getPrevReportCount();
	//어제 날짜 
	public int getPrevMemberCount();
	//어제 날짜
	public int getPrevSaleReportCount();

	//datepicker지정날짜 가져오기	
	public int getInquirePickerCount(Map<String, String> map);

	public int getReportPickerCount(Map<String, String> map);

	public int getNewMemberPickerCount(Map<String, String> map);

	public int getSaleReportPickerCount(Map<String, String> map);


	//date 달력 선택 날짜 가져오기
	public List<String> getCalenderInfo(Map<String, String> map);

	

}
