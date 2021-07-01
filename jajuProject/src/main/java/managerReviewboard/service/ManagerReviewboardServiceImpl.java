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

}
