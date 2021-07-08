package main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import freeboard.bean.FreeboardDTO;
import saleboard.bean.SaleboardDTO;

@Repository
@Transactional
public class MainDAOMybatis implements MainDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<SaleboardDTO> popularity() {
		return sqlSession.selectList("mainSQL.popularity");
	}

	@Override
	public List<SaleboardDTO> recommend(String category) {
		return sqlSession.selectList("mainSQL.recommend", category);
	}

	@Override
	public List<FreeboardDTO> board() {
		return sqlSession.selectList("mainSQL.board");
	}
}
