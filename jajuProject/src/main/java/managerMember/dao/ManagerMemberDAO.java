package managerMember.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import managerMember.bean.ManagerMainDTO;
import member.bean.MemberDTO;

public interface ManagerMemberDAO {
	public List<MemberDTO> getManagerMember(Map<String, String> map);
	
	public void changeMemberState(Map<String, String[]> map);

	public void managerMemberForm(Map<String, String[]> map);
	
	public void changeBlackMemberStateRollback(Map<String, String[]> map);
	
	public List<MemberDTO> getSearchMemberInfo(Map<String, String> map);

	public List<MemberDTO> getManagerMemberBlack(Map<String, String> map);

	//페이징처리, 토탈 int 가져오기
	public int getMemberTotalA();
	//검색 페이징 처리. 
	public int getSearchTotalA(Map<String, String> map);
	//블랙리스트 페이징 처리, 블랙토탈 int 가져오기
	public int getMemberBlackTotalA();

	//차트
	public List<ManagerMainDTO> getMemberCategory();

	public ManagerMainDTO getSaleAvg();

	public List<ManagerMainDTO> getLocationInfo();

	/*==== MAINCHART COUNT(*) NUM FROM DB ====*/
	//1:1
	public int getManagerInquireCount();
	//신고글
	public int getManagerReportCount();
	//신규 회원 가입 멤버 수 (당일) 
	public int getManagerMemberCount();
	//판매 게시글 수 (당일)
	public int getManagerSaleReportCount();


}
