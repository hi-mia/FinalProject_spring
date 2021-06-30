package manager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import freeboard.bean.FreeboardCommentDTO;
import freeboard.bean.FreeboardCommentPaging;
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
	
}
