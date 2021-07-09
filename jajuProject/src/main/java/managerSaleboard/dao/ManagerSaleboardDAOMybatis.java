package managerSaleboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import saleboard.bean.SaleboardDTO;

@Repository
@Transactional
public class ManagerSaleboardDAOMybatis implements ManagerSaleboardDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<SaleboardDTO> getManagerSaleboardList(Map<String, String> map) {
		return sqlSession.selectList("managerSaleboardSQL.getManagerSaleboardList", map);
	}

	@Override
	public int getTotalA(Map<String, String> map) {
		return sqlSession.selectOne("managerSaleboardSQL.getTotalA", map);
	}

	@Override
	public List<SaleboardDTO> getManagerSaleboardSearchList(Map<String, String> map) {
		return sqlSession.selectList("managerSaleboardSQL.getManagerSaleboardSearchList", map);
	}

	@Override
	public int getTotalASearch(Map<String, String> map) {
		return sqlSession.selectOne("managerSaleboardSQL.getTotalASearch", map);
	}

	@Override
	public void managerSaleboardListDelete(String[] check) {
//		sqlSession.delete("managerSaleboardSQL.managerSaleboardListDelete", check);
//		sqlSession.delete("managerSaleboardSQL.managerSaleboardListCommentDelete", check);
		
		for(int i=0; i<check.length; i++ ) {
			sqlSession.delete("managerSaleboardSQL.managerSaleboardDelete", Integer.parseInt(check[i]));
		}
		
	}

	@Override
	public void managerSaleboardDelete(int sale_seq) {
		sqlSession.delete("managerSaleboardSQL.managerSaleboardDelete", sale_seq);
	}

	@Override
	public SaleboardDTO getPage_sale(Map<String, String> map) {
		return sqlSession.selectOne("managerSaleboardSQL.getPage_sale", map);
	}
	
	
	
}
