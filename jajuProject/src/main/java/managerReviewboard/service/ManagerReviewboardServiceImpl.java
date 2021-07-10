package managerReviewboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managerReviewboard.dao.ManagerReviewboardDAO;
import reviewboard.bean.ReviewboardDTO;
import reviewboard.bean.ReviewboardPaging;

@Service
public class ManagerReviewboardServiceImpl implements ManagerReviewboardService {

	@Autowired
	private ManagerReviewboardDAO managerReviewboardDAO;
	
	@Autowired
	private ReviewboardPaging reviewboardPaging;
	
	@Override
	public List<ReviewboardDTO> getManagerReviewboardList(String pg) {
		//1페이지당 10개씩
		int endNum = Integer.parseInt(pg)*10;
		int startNum = endNum-9;
						
		Map<String, String> map = new HashMap<String, String>();
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
				
		return managerReviewboardDAO.getManagerReviewboardList(map);
	}

	@Override
	public ReviewboardPaging managerReviewboardPaging(String pg) {
		int totalA = managerReviewboardDAO.getTotalA();
		
		reviewboardPaging.setCurrentPage(Integer.parseInt(pg));
		reviewboardPaging.setPageBlock(5);
		reviewboardPaging.setPageSize(10);
		reviewboardPaging.setTotalA(totalA);
		reviewboardPaging.makePagingHTML();
		
		return reviewboardPaging;
	}

	@Override
	public ReviewboardDTO getManagerReviewboardView(int review_seq) {
		return managerReviewboardDAO.getManagerReviewboardView(review_seq);
	}

	@Override
	public ReviewboardDTO getPage_review(int review_seq) {
		return managerReviewboardDAO.getPage_review(review_seq);
	}

	@Override
	public List<ReviewboardDTO> getManagerReviewboardSearchList(Map<String, String> map) {
		int endNum = Integer.parseInt(map.get("searchPg"))*10; //map에서 pg를 꺼냄
		int startNum = endNum - 9;
		
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		
		return managerReviewboardDAO.getManagerReviewboardSearchList(map);
	}

	@Override
	public ReviewboardPaging reviewboardPaging(Map<String, String> map) {
		int totalA = managerReviewboardDAO.getSearchTotal_review(map); //검색한 총 글수
		
		reviewboardPaging.setCurrentPage(Integer.parseInt(map.get("pg"))); //현재 페이지
		reviewboardPaging.setPageBlock(5);
		reviewboardPaging.setPageSize(10);
		reviewboardPaging.setTotalA(totalA);
		reviewboardPaging.makePagingHTML();
		
		return reviewboardPaging;
	}

	@Override
	public void managerReviewboardDelete(int review_seq) {
		managerReviewboardDAO.managerReviewboardDelete(review_seq);
		
	}

	@Override
	public void managerReviewboardListDelete(String[] check) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("array", check);
		managerReviewboardDAO.managerReviewboardListDelete(map);
		
	}

	@Override
	public List<ReviewboardDTO> getReviewListMember(String member_id) {
		return managerReviewboardDAO.getReviewListMember(member_id);
	}

	@Override
	public void updateManner(double d, String check) {
		managerReviewboardDAO.updateManner(d,check);
	}

}
