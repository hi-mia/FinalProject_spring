package manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freeboard.bean.FreeboardCommentDTO;
import freeboard.bean.FreeboardCommentPaging;
import freeboard.bean.FreeboardDTO;
import freeboard.bean.FreeboardPaging;
import manager.bean.ManagerPaging;
import manager.dao.ManagerDAO;
import member.bean.MemberDTO;

@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ManagerDAO managerDAO;
	
	@Autowired
	private FreeboardPaging freeboardPaging;
	
	@Autowired
	private FreeboardCommentPaging freeboardCommentPaging;

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

		
	@Override
	public List<FreeboardDTO> getManagerFreeboardList(String pg) {
		//1페이지당 10개씩
		int endNum = Integer.parseInt(pg)*10;
		int startNum = endNum-9;
				
		Map<String, String> map = new HashMap<String, String>();
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		return managerDAO.getManagerFreeboardList(map);
	}

	@Override
	public FreeboardPaging managerfreeboardPaging(String pg) {
		int totalA = managerDAO.getTotalA();
		
		freeboardPaging.setCurrentPage(Integer.parseInt(pg));
		freeboardPaging.setPageBlock(5);
		freeboardPaging.setPageSize(10);
		freeboardPaging.setTotalA(totalA);
		freeboardPaging.makePagingHTML();
		
		return freeboardPaging;
	}

	@Override
	public FreeboardDTO getManagerFreeboardView(int board_seq) {
		return managerDAO.getManagerFreeboardView(board_seq);
	}

	@Override
	public List<FreeboardCommentDTO> getManagerFreeboardComment(Map<String, String> map) {
		int pg = Integer.parseInt(map.get("pg"));
		
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		
		map.put("startNum", startNum+"");
		map.put("endNum", endNum +"");
		return managerDAO.getManagerFreeboardComment(map);
	}

	@Override
	public FreeboardCommentPaging freeboardCommentPaging(Map<String, String> map) {
		int pg = Integer.parseInt(map.get("pg"));
		freeboardCommentPaging.setCurrentPage(pg);
		freeboardCommentPaging.setPageBlock(3);
		freeboardCommentPaging.setPageSize(5);
		int board_seq = Integer.parseInt(map.get("board_seq"));
		int totalA = managerDAO.getCommentTotal2(board_seq);
		freeboardCommentPaging.setTotalA(totalA);
		
		freeboardCommentPaging.makePagingHTML();
		
		return freeboardCommentPaging;
	}

	@Override
	public FreeboardCommentDTO getManagerFreeboardCommentOne(String comment_seq) {
		return managerDAO.getManagerFreeboardCommentOne(comment_seq);
	}

	@Override
	public FreeboardDTO getPage(int board_seq) {
		return managerDAO.getPage(board_seq);
	}

	@Override
	public void managerFreeboardDelete(int board_seq) {
		managerDAO.managerFreeboardDelete(board_seq);
	}

	@Override
	public void managerCommentDelete(FreeboardCommentDTO freeboardCommentDTO) {
		managerDAO.managerCommentDelete(freeboardCommentDTO);

	}

	@Override
	public FreeboardPaging freeboardPaging(Map<String, String> map) {
		int totalA = managerDAO.getSearchTotal(map); //검색한 총 글수
		
		freeboardPaging.setCurrentPage(Integer.parseInt(map.get("pg"))); //현재 페이지
		freeboardPaging.setPageBlock(5);
		freeboardPaging.setPageSize(10);
		freeboardPaging.setTotalA(totalA);
		freeboardPaging.makePagingHTML();
		
		return freeboardPaging;
	}

	@Override
	public List<FreeboardDTO> getManagerFreeboardSearchList(Map<String, String> map) {
		int endNum = Integer.parseInt(map.get("searchPg"))*10; //map에서 pg를 꺼냄
		int startNum = endNum - 9;
		
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		
		return managerDAO.getManagerFreeboardSearchList(map);
	}

	@Override
	public void managerFreeboardListDelete(String[] check) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("array", check);
		managerDAO.managerFreeboardListDelete(map);
	}
	//페이징처리 하는 곳.
	@Override
	public ManagerPaging managerPaging(Map<String, String> map) {
		int memberCount = managerDAO.getMemberTotalA();
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
