package managerMember.dao;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;

public interface ManagerMemberDAO {
	public List<MemberDTO> getManagerMember(Map<String, String> map);
	
	public void changeMemberState(Map<String, String[]> map);

	public void managerMemberForm(Map<String, String[]> map);

	public List<MemberDTO> getSearchMemberInfo(Map<String, String> map);

	public List<MemberDTO> getManagerMemberBlack(Map<String, String> map);

	//페이징처리, 토탈 int 가져오기
	public int getMemberTotalA();
	//검색 페이징 처리. 
	public int getSearchTotalA(Map<String, String> map);
	
}
