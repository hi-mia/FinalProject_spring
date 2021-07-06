package main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
