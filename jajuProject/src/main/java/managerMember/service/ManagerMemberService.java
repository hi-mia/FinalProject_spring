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

	public List<MemberDTO> getSearchMemberInfo(Map<String, String> map);

	public List<MemberDTO> getManagerMemberBlack(Map<String, String> map);
	//전체회원 리스트 페이징 처리하기
	public ManagerPaging managerPaging(Map<String, String> map);
	//검색 후 페이징 처리하기
	public ManagerPaging managerSearchPaging(Map<String, String> map);
	//블랙리스트 회원 리스트 페이징 처리하기
	public ManagerPaging managerPagingBlack(Map<String, String> map);

	//차트 - 키워드 , 키워드 개수 
	public List<ManagerMainDTO> getMemberCategory();

	public ManagerMainDTO getSaleAvg();

}
