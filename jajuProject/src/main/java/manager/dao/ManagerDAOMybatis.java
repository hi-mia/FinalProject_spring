package manager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import freeboard.bean.FreeboardCommentDTO;
import freeboard.bean.FreeboardDTO;
import member.bean.MemberDTO;
import reviewboard.bean.ReviewboardDTO;

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
			sqlSession.update("managerSQL.managerMemberForm", map);		
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
		@Override
		public int getMemberTotalA() {
			return sqlSession.selectOne("managerSQL.getMemberTotalA");
		}
		@Override
		public int getSearchTotalA(Map<String, String> map) {
			return sqlSession.selectOne("managerSQL.getSearchTotalA",map);

		}


	@Override
	public List<FreeboardDTO> getManagerFreeboardList(Map<String, String> map) {
		return sqlSession.selectList("managerSQL.getManagerFreeboardList", map);
	}


	@Override
	public int getTotalA() {
		return sqlSession.selectOne("managerSQL.getTotalA");
	}


	@Override
	public FreeboardDTO getManagerFreeboardView(int board_seq) {
		return sqlSession.selectOne("managerSQL.getManagerFreeboardView", board_seq);
	}


	@Override
	public List<FreeboardCommentDTO> getManagerFreeboardComment(Map<String, String> map) {
		return sqlSession.selectList("managerSQL.getManagerFreeboardComment", map);
	}

	@Override
	public FreeboardCommentDTO getManagerFreeboardCommentOne(String string) {
		int comment_pseq = Integer.parseInt(string);
		return sqlSession.selectOne("managerSQL.getManagerFreeboardCommentOne", comment_pseq);
	}


	@Override
	public int getCommentTotal2(int board_seq) {
		return sqlSession.selectOne("managerSQL.getCommentTotal2", board_seq);
	}

	@Override
	public FreeboardDTO getPage(int board_seq) {
		return sqlSession.selectOne("managerSQL.getPage", board_seq);
	}

	@Override
	public void managerFreeboardDelete(int board_seq) {
		sqlSession.delete("managerSQL.managerFreeboardDelete", board_seq);
	}

	@Override
	public void managerCommentDelete(FreeboardCommentDTO freeboardCommentDTO) {
		sqlSession.delete("managerSQL.managerCommentDelete", freeboardCommentDTO);
	}
	@Override
	public int getSearchTotal(Map<String, String> map) {
		return sqlSession.selectOne("managerSQL.getSearchTotal",map);
	}
	@Override
	public List<FreeboardDTO> getManagerFreeboardSearchList(Map<String, String> map) {
		return sqlSession.selectList("managerSQL.getManagerFreeboardSearchList", map);
	}
	@Override
	public void managerFreeboardListDelete(Map<String, String[]> map) {
		sqlSession.delete("managerSQL.managerFreeboardListDelete", map);
	}
	
}
