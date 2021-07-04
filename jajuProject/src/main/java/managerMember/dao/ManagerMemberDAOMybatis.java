package managerMember.dao;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import managerMember.bean.ManagerMainDTO;
import member.bean.MemberDTO;

@Transactional
@Repository
public class ManagerMemberDAOMybatis implements ManagerMemberDAO {

	@Autowired
	private SqlSession sqlSession;

	// sortinSelect 한 값에 따라 해당 조건에 맞는 list 가져오기.
	@Override
	public List<MemberDTO> getManagerMember(Map<String, String> map) {
		return sqlSession.selectList("managerMemberSQL.getManagerMember", map);
	}

	// 활동중지 상태 0-> 1로 변경
	@Override
	public void changeMemberState(Map<String, String[]> map) {
		sqlSession.update("managerMemberSQL.changeMemberState", map);
	}

	// 강제탈퇴기능
	@Override
	public void managerMemberForm(Map<String, String[]> map) {
		sqlSession.update("managerMemberSQL.managerMemberForm", map);
	}

	// 검색리스트
	@Override
	public List<MemberDTO> getSearchMemberInfo(Map<String, String> map) {
		return sqlSession.selectList("managerMemberSQL.getSearchMemberInfo", map);
	}

	// 블랙리스트
	@Override
	public List<MemberDTO> getManagerMemberBlack(Map<String, String> map) {
		return sqlSession.selectList("managerMemberSQL.getManagerMemberBlack", map);
	}

	@Override
	public int getMemberTotalA() {
		return sqlSession.selectOne("managerMemberSQL.getMemberTotalA");
	}

	@Override
	public int getSearchTotalA(Map<String, String> map) {
		return sqlSession.selectOne("managerMemberSQL.getSearchTotalA", map);
	}

	@Override
	public int getMemberBlackTotalA() {
		return sqlSession.selectOne("managerMemberSQL.getMemberBlackTotalA");
	}

	@Override
	public List<ManagerMainDTO> getMemberCategory() {
		return sqlSession.selectList("managerMemberSQL.getMemberCategory");
	}

	@Override
	public ManagerMainDTO getSaleAvg() {
		return sqlSession.selectOne("managerMemberSQL.getSaleAvg");
	}

}
