package managerReviewboard.service;

import java.util.List;

import reviewboard.bean.ReviewboardDTO;
import reviewboard.bean.ReviewboardPaging;

public interface ManagerReviewboardService {

	public List<ReviewboardDTO> getManagerReviewboardList(String pg);

	public ReviewboardPaging managerReviewboardPaging(String pg);

}
