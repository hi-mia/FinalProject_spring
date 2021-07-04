package managerMember.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managerMember.bean.ManagerMainDTO;
import managerMember.bean.ManagerPaging;
import managerMember.dao.ManagerMemberDAO;
import member.bean.MemberDTO;

@Service
public class ManagerMemberServiceImpl implements ManagerMemberService {
	@Autowired
	private ManagerMemberDAO managerMemberDAO;
	@Autowired
	private ManagerPaging managerPaging;

	@Override
	public List<MemberDTO> getManagerMember(Map<String, String> map) {
		// 1페이지당 10개씩
		int endNum = Integer.parseInt(map.get("pg")) * 10;
		int startNum = endNum - 9;

		map.put("startNum", startNum + "");
		map.put("endNum", endNum + "");

		return managerMemberDAO.getManagerMember(map);
	}

	// 삭제
	@Override
	public void deleteMemberId(String[] check) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("array", check);
		managerMemberDAO.managerMemberForm(map);
	}

	@Override
	public void changeMemberState(String[] check) {
//		Map<String, List> map = new HashMap<String, List>();
//		map.put("array", array);
//		managerDAO.changeMemberState(map);
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("array", check);
		managerMemberDAO.changeMemberState(map);
	}

	@Override
	public List<MemberDTO> getSearchMemberInfo(Map<String, String> map) {
		// 1페이지당 10개씩
		int endNum = Integer.parseInt(map.get("pg")) * 10;
		int startNum = endNum - 9;

		map.put("startNum", startNum + "");
		map.put("endNum", endNum + "");

		return managerMemberDAO.getSearchMemberInfo(map);
	}

	@Override
	public List<MemberDTO> getManagerMemberBlack(Map<String, String> map) {
		// 1페이지당 10개씩
		int endNum = Integer.parseInt(map.get("pg")) * 10;
		int startNum = endNum - 9;

		map.put("startNum", startNum + "");
		map.put("endNum", endNum + "");

		return managerMemberDAO.getManagerMemberBlack(map);
	}

	// 페이징처리 하는 곳.
	@Override
	public ManagerPaging managerPaging(Map<String, String> map) {
		int memberCount = managerMemberDAO.getMemberTotalA();
		// System.out.println(memberCount);
		managerPaging.setCurrentPage(Integer.parseInt(map.get("pg")));
		managerPaging.setPageBlock(4);
		managerPaging.setPageSize(10);
		managerPaging.setTotalA(memberCount);
		managerPaging.makePagingHTML();
		return managerPaging;
	}

	@Override
	public ManagerPaging managerSearchPaging(Map<String, String> map) {
		int memberSearchCount = managerMemberDAO.getSearchTotalA(map);
		// System.out.println(memberCount);
		managerPaging.setCurrentPage(Integer.parseInt(map.get("pg")));
		managerPaging.setPageBlock(4);
		managerPaging.setPageSize(10);
		managerPaging.setTotalA(memberSearchCount);
		managerPaging.makePagingHTML();
		return managerPaging;
	}

	@Override
	public ManagerPaging managerPagingBlack(Map<String, String> map) {
		int memberBlackCount = managerMemberDAO.getMemberBlackTotalA();
		// System.out.println(memberCount);
		managerPaging.setCurrentPage(Integer.parseInt(map.get("pg")));
		managerPaging.setPageBlock(4);
		managerPaging.setPageSize(10);
		managerPaging.setTotalA(memberBlackCount);
		managerPaging.makePagingHTML();
		return managerPaging;
	}
	/*==차트 구현을 위한 카테고리, 카테고리 count 가져오기 ==*/
	@Override
	public List<ManagerMainDTO> getMemberCategory() {
		return managerMemberDAO.getMemberCategory();
	}

	@Override
	public ManagerMainDTO getSaleAvg() {
		return managerMemberDAO.getSaleAvg();
	}
	
	@Override
	public List<ManagerMainDTO> getLocationInfo() {
		return managerMemberDAO.getLocationInfo();
	}
	
	/*==== MAINCHART COUNT(*) NUM FROM DB ====*/
	@Override
	public int getManagerInquireCount() {
		return managerMemberDAO.getManagerInquireCount();
	}

	@Override
	public int getManagerReportCount() {
		return managerMemberDAO.getManagerReportCount();
	}

	@Override
	public int getManagerMemberCount() {
		return managerMemberDAO.getManagerMemberCount();
	}

	@Override
	public int getManagerSaleReportCount() {
		return managerMemberDAO.getManagerSaleReportCount();
	}



}
