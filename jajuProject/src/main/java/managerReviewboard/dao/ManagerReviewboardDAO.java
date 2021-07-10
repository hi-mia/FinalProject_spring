package managerReviewboard.dao;

import java.util.List;
import java.util.Map;

import reviewboard.bean.ReviewboardDTO;

public interface ManagerReviewboardDAO {

	public List<ReviewboardDTO> getManagerReviewboardList(Map<String, String> map);

	public int getTotalA();

	public ReviewboardDTO getManagerReviewboardView(int review_seq);
	
	public ReviewboardDTO getPage_review(int review_seq);

	public List<ReviewboardDTO> getManagerReviewboardSearchList(Map<String, String> map);

	public int getSearchTotal_review(Map<String, String> map);

	public void managerReviewboardDelete(int review_seq);

	public void managerReviewboardListDelete(Map<String, String[]> map);

	public List<ReviewboardDTO> getReviewListMember(String member_id);

	public void updateManner(double d, String check);


}
