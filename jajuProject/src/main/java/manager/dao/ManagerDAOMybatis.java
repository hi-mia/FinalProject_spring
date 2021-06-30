package manager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import member.bean.MemberDTO;

@Transactional
@Repository

public class ManagerDAOMybatis implements ManagerDAO{
	@Autowired
	private SqlSession sqlSession;
	
		//sortinSelect 한 값에 따라 해당 조건에 맞는 list 가져오기.
		@Override
		public List<MemberDTO> getManagerMember(Map<String, String> map) {
			return sqlSession.selectList("managerSQL.getManagerMember",map);
		}
		//활동중지 상태 0-> 1로 변경 
		@Override
		public void changeMemberState(Map<String, String[]> map) {
			sqlSession.update("managerSQL.changeMemberState",map);
		}
		//강제탈퇴기능
		@Override
		public void managerMemberForm(Map<String, String[]> map) {
			sqlSession.delete("managerSQL.managerMemberForm", map);		
		}
		//검색리스트
		@Override
		public List<MemberDTO> getSearchMemberInfo(Map<String, String> map) {
			return sqlSession.selectList("managerSQL.getSearchMemberInfo",map);
		}
		//블랙리스트
		@Override
		public List<MemberDTO> getManagerMemberBlack(Map<String, String> map) {
			return sqlSession.selectList("managerSQL.getManagerMemberBlack",map);
		}

}
