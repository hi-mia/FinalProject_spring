package manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manager.bean.ManagerPaging;
import manager.dao.ManagerDAO;
import member.bean.MemberDTO;

@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ManagerDAO managerDAO;
	@Autowired
	private ManagerPaging managerPaging;
	
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
	//페이징처리 하는 곳.
	@Override
	public ManagerPaging managerPaging(Map<String, String> map) {
		int memberCount = managerDAO.getTotalA();
		//System.out.println(memberCount);
		managerPaging.setCurrentPage(Integer.parseInt(map.get("pg")));
		managerPaging.setPageBlock(4);
		managerPaging.setPageSize(10);
		managerPaging.setTotalA(memberCount);
		managerPaging.makePagingHTML();
		return managerPaging;
	}

	@Override
	public ManagerPaging managerSearchPaging(Map<String, String> map) {
		int memberSearchCount = managerDAO.getSearchTotalA(map);
		//System.out.println(memberCount);
		managerPaging.setCurrentPage(Integer.parseInt(map.get("pg")));
		managerPaging.setPageBlock(4);
		managerPaging.setPageSize(10);
		managerPaging.setTotalA(memberSearchCount);
		managerPaging.makePagingHTML();
		return managerPaging;
	}

}
