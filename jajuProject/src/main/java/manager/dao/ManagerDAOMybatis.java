package manager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import freeboard.bean.FreeboardDTO;
import member.bean.MemberDTO;

@Transactional
@Repository

public class ManagerDAOMybatis implements ManagerDAO{

	
	@Autowired
	private SqlSession sqlSession;


	@Override
	public List<MemberDTO> getManagerMember(Map<String, String> map) {
		return sqlSession.selectList("managerSQL.getManagerMember",map);

	}


	@Override
	public List<FreeboardDTO> getManagerFreeboardList(Map<String, String> map) {
		return sqlSession.selectList("managerSQL.getManagerFreeboardList", map);
	}


	@Override
	public int getTotalA() {
		return sqlSession.selectOne("managerSQL.getTotalA");
	}
	


}
