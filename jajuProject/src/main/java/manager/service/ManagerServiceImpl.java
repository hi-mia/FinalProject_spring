package manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manager.dao.ManagerDAO;
import member.bean.MemberDTO;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private ManagerDAO managerDAO;

	@Override
	public List<MemberDTO> getManagerMember(Map<String, String> map) {
		//1페이지당 10개씩
		int endNum = Integer.parseInt(map.get("pg"))*10;
		int startNum = endNum-9;

		map.put("startNum",startNum+"");
		map.put("endNum",endNum+"");
		
		return managerDAO.getManagerMember(map);
	}

	//삭제
	@Override
	public void deleteMemberId(String[] check) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("array", check);
		managerDAO.managerMemberForm(map);
	}
	
	@Override
	public void changeMemberState(String[] check) {
//		Map<String, List> map = new HashMap<String, List>();
//		map.put("array", array);
//		managerDAO.changeMemberState(map);
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("array", check);
		managerDAO.changeMemberState(map);
	}

	@Override
	public List<MemberDTO> getSearchMemberInfo(Map<String, String> map) {
		//1페이지당 10개씩
		int endNum = Integer.parseInt(map.get("pg"))*10;
		int startNum = endNum-9;

		map.put("startNum",startNum+"");
		map.put("endNum",endNum+"");
		
		return managerDAO.getSearchMemberInfo(map);
	}

	@Override
	public List<MemberDTO> getManagerMemberBlack(Map<String, String> map) {
		//1페이지당 10개씩
		int endNum = Integer.parseInt(map.get("pg"))*10;
		int startNum = endNum-9;

		map.put("startNum",startNum+"");
		map.put("endNum",endNum+"");
		
		return managerDAO.getManagerMemberBlack(map);
	}

}
