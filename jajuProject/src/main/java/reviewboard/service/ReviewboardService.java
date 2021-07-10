package reviewboard.service;

import java.util.List;
import java.util.Map;

import reviewboard.bean.ReviewboardDTO;
import reviewboard.bean.ReviewboardPaging;
import saleboard.bean.SaleboardDTO;

public interface ReviewboardService {

	public void reviewboardWrite(ReviewboardDTO reviewboardDTO);

	public void reviewboardModify(ReviewboardDTO reviewboardDTO);

	public void reviewboardDelete(int review_seq);

	public List<SaleboardDTO> review_saleReportList(Map<String, String> map);

	public ReviewboardDTO getReviewboardView(int reivew_seq);

	public List<ReviewboardDTO> getReviewboardList(Map<String, String> map);

	public ReviewboardPaging reviewboardPaging(int pg);

	public List<ReviewboardDTO> getReviewboardSearchList(Map<String, String> map);

	public ReviewboardPaging reviewboardPaging_search(Map<String, String> map);

	public ReviewboardPaging reviewboardPaging(Map<String, String> map);

	public void upHit_review(int review_seq);

	public List<ReviewboardDTO> getAllReviewboardList(String member_id);

	public void review_mannerModify(Map<String, String> map);

	public ReviewboardDTO getPage(int review_seq);

	public ReviewboardPaging reviewboardPagingList(Map<String, String> map);


}
