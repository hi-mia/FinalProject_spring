package managerFreeboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freeboard.bean.FreeboardCommentDTO;
import freeboard.bean.FreeboardCommentPaging;
import freeboard.bean.FreeboardDTO;
import freeboard.bean.FreeboardPaging;
import managerFreeboard.dao.ManagerFreeboardDAO;

@Service
public class ManagerFreeboardServiceImpl implements ManagerFreeboardService {

	@Autowired
	private ManagerFreeboardDAO managerFreeboardDAO;
	
	@Autowired
	private FreeboardPaging freeboardPaging;
	
	@Autowired
	private FreeboardCommentPaging freeboardCommentPaging;

	@Override
	public List<FreeboardDTO> getManagerFreeboardList(String pg) {
		//1페이지당 10개씩
				int endNum = Integer.parseInt(pg)*10;
				int startNum = endNum-9;
						
				Map<String, String> map = new HashMap<String, String>();
				map.put("startNum", startNum+"");
				map.put("endNum", endNum+"");
				return managerFreeboardDAO.getManagerFreeboardList(map);
	}

	@Override
	public FreeboardPaging managerfreeboardPaging(String pg) {
	int totalA = managerFreeboardDAO.getTotalA();
		
		freeboardPaging.setCurrentPage(Integer.parseInt(pg));
		freeboardPaging.setPageBlock(5);
		freeboardPaging.setPageSize(10);
		freeboardPaging.setTotalA(totalA);
		freeboardPaging.makePagingHTML();
		
		return freeboardPaging;
	}

	@Override
	public FreeboardDTO getManagerFreeboardView(int board_seq) {
		return managerFreeboardDAO.getManagerFreeboardView(board_seq);
	}

	@Override
	public List<FreeboardCommentDTO> getManagerFreeboardComment(Map<String, String> map) {
int pg = Integer.parseInt(map.get("pg"));
		
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		
		map.put("startNum", startNum+"");
		map.put("endNum", endNum +"");
		return managerFreeboardDAO.getManagerFreeboardComment(map);
	}

	@Override
	public FreeboardCommentPaging freeboardCommentPaging(Map<String, String> map) {
		int pg = Integer.parseInt(map.get("pg"));
		freeboardCommentPaging.setCurrentPage(pg);
		freeboardCommentPaging.setPageBlock(3);
		freeboardCommentPaging.setPageSize(5);
		int board_seq = Integer.parseInt(map.get("board_seq"));
		int totalA = managerFreeboardDAO.getCommentTotal2(board_seq);
		freeboardCommentPaging.setTotalA(totalA);
		
		freeboardCommentPaging.makePagingHTML();
		
		return freeboardCommentPaging;
	}

	@Override
	public FreeboardCommentDTO getManagerFreeboardCommentOne(String comment_seq) {
		return managerFreeboardDAO.getManagerFreeboardCommentOne(comment_seq);
	}

	@Override
	public FreeboardDTO getPage(int board_seq) {
		return managerFreeboardDAO.getPage(board_seq);
	}

	@Override
	public List<FreeboardDTO> getManagerFreeboardSearchList(Map<String, String> map) {
		int endNum = Integer.parseInt(map.get("searchPg"))*10; //map에서 pg를 꺼냄
		int startNum = endNum - 9;
		
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		
		return managerFreeboardDAO.getManagerFreeboardSearchList(map);
	}

	@Override
	public FreeboardPaging freeboardPaging(Map<String, String> map) {
	int totalA = managerFreeboardDAO.getSearchTotal(map); //검색한 총 글수
		
		freeboardPaging.setCurrentPage(Integer.parseInt(map.get("pg"))); //현재 페이지
		freeboardPaging.setPageBlock(5);
		freeboardPaging.setPageSize(10);
		freeboardPaging.setTotalA(totalA);
		freeboardPaging.makePagingHTML();
		
		return freeboardPaging;
	}

	@Override
	public void managerFreeboardDelete(int board_seq) {
		managerFreeboardDAO.managerFreeboardDelete(board_seq);
		
	}

	@Override
	public void managerFreeboardListDelete(String[] check) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("array", check);
		managerFreeboardDAO.managerFreeboardListDelete(map);
		
	}

	@Override
	public void managerCommentDelete(FreeboardCommentDTO freeboardCommentDTO) {
		managerFreeboardDAO.managerCommentDelete(freeboardCommentDTO);

		
	}
	
	
}
