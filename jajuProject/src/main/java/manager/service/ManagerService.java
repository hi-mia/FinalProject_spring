package manager.service;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;

public interface ManagerService {

	public List<MemberDTO> getManagerMember(Map<String, String> map);
	
	public void deleteMemberId(String[] check);
	
	public void changeMemberState(String[] check);

	public List<MemberDTO> getSearchMemberInfo(Map<String, String> map);

	public List<MemberDTO> getManagerMemberBlack(Map<String, String> map);


}
