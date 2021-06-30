package manager.service;

import java.util.List;

import freeboard.bean.FreeboardDTO;
import freeboard.bean.FreeboardPaging;
import member.bean.MemberDTO;

public interface ManagerService {

	public List<MemberDTO> getManagerMember(String pg);

	public List<FreeboardDTO> getManagerFreeboardList(String pg);

	public FreeboardPaging managerfreeboardPaging(String pg);

	
}
