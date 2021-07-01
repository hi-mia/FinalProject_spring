package manager.service;

import java.util.List;

import inquire.bean.InquireDTO;
import member.bean.MemberDTO;

public interface ManagerService {

	public List<MemberDTO> getManagerMember(String pg);

	public List<InquireDTO> getManagerInquire(String pg);

}
