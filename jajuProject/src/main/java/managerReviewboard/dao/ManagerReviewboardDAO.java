package managerReviewboard.dao;

import java.util.List;
import java.util.Map;

import reviewboard.bean.ReviewboardDTO;

public interface ManagerReviewboardDAO {

	public List<ReviewboardDTO> getManagerReviewboardList(Map<String, String> map);

	public int getTotalA();

}
