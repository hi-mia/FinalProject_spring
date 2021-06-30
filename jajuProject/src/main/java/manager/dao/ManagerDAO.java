package manager.dao;

import java.util.List;
import java.util.Map;

import freeboard.bean.FreeboardDTO;
import member.bean.MemberDTO;

public interface ManagerDAO {

	public List<MemberDTO> getManagerMember(Map<String, String> map);

	public List<FreeboardDTO> getManagerFreeboardList(Map<String, String> map);

	public int getTotalA();
}
