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

	@Override
	public List<MemberDTO> getManagerMember(String pg) {
		//1페이지당 10개씩
		int endNum = Integer.parseInt(pg)*10;
		int startNum = endNum-9;
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("startNum",startNum+"");
		map.put("endNum",endNum+"");
		
		return managerDAO.getManagerMember(map);
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

}
