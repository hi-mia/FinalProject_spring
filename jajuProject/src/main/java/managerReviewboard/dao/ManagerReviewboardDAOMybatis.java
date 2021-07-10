package managerReviewboard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import reviewboard.bean.ReviewboardDTO;

@Transactional
@Repository
public class ManagerReviewboardDAOMybatis implements ManagerReviewboardDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ReviewboardDTO> getManagerReviewboardList(Map<String, String> map) {
		return sqlSession.selectList("managerReviewboardSQL.getManagerReviewboardList", map);
	}

	@Override
	public int getTotalA() {
		return sqlSession.selectOne("managerReviewboardSQL.getTotalA");
	}

	@Override
	public ReviewboardDTO getManagerReviewboardView(int review_seq) {
		return sqlSession.selectOne("managerReviewboardSQL.getManagerReviewboardView", review_seq);
	}

	@Override
	public ReviewboardDTO getPage_review(int review_seq) {
		return sqlSession.selectOne("managerReviewboardSQL.getPage_review", review_seq);
	}

	@Override
	public List<ReviewboardDTO> getManagerReviewboardSearchList(Map<String, String> map) {
		return sqlSession.selectList("managerReviewboardSQL.getManagerReviewboardSearchList", map);
	}

	@Override
	public int getSearchTotal_review(Map<String, String> map) {
		return sqlSession.selectOne("managerReviewboardSQL.getSearchTotal_review",map);
	}

	@Override
	public void managerReviewboardDelete(int review_seq) {
		sqlSession.delete("managerReviewboardSQL.managerReviewboardDelete", review_seq);
	}

	@Override
	public void managerReviewboardListDelete(Map<String, String[]> map) {
		sqlSession.delete("managerReviewboardSQL.managerReviewboardListDelete", map);
	}

	@Override
	public List<ReviewboardDTO> getReviewListMember(String member_id) {
		
		return sqlSession.selectList("managerReviewboardSQL.getReviewListMember", member_id);
	}

	@Override
	public void updateManner(double d, String check) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("review_manner", d+"");
		map.put("member_id", check);
		
		sqlSession.update("managerReviewboardSQL.updateManner", map);
	}
}
