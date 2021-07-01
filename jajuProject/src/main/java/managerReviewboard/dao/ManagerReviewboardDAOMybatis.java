package managerReviewboard.dao;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalA() {
		// TODO Auto-generated method stub
		return 0;
	}
}
