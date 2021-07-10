package managerReviewboard.service;

import java.util.List;
import java.util.Map;

import reviewboard.bean.ReviewboardDTO;
import reviewboard.bean.ReviewboardPaging;

public interface ManagerReviewboardService {

	public List<ReviewboardDTO> getManagerReviewboardList(String pg);

	public ReviewboardPaging managerReviewboardPaging(String pg);

	public ReviewboardDTO getManagerReviewboardView(int review_seq);

	public ReviewboardDTO getPage_review(int review_seq);

	public List<ReviewboardDTO> getManagerReviewboardSearchList(Map<String, String> map);

	public ReviewboardPaging reviewboardPaging(Map<String, String> map);

	public void managerReviewboardDelete(int review_seq);

	public void managerReviewboardListDelete(String[] check);

	public List<ReviewboardDTO> getReviewListMember(String member_id);

	public void updateManner(double d, String check);

}
