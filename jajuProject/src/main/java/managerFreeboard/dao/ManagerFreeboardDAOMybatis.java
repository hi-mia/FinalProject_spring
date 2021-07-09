package managerFreeboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import freeboard.bean.FreeboardCommentDTO;
import freeboard.bean.FreeboardDTO;

@Transactional
@Repository
public class ManagerFreeboardDAOMybatis implements ManagerFreeboardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public List<FreeboardDTO> getManagerFreeboardList(Map<String, String> map) {
		return sqlSession.selectList("managerfreeboardSQL.getManagerFreeboardList", map);
	}

	@Override
	public int getTotalA() {
		return sqlSession.selectOne("managerfreeboardSQL.getTotalA");
	}

	@Override
	public FreeboardDTO getManagerFreeboardView(int board_seq) {
		return sqlSession.selectOne("managerfreeboardSQL.getManagerFreeboardView", board_seq);
	}

	@Override
	public List<FreeboardCommentDTO> getManagerFreeboardComment(Map<String, String> map) {
		return sqlSession.selectList("managerfreeboardSQL.getManagerFreeboardComment", map);
	}

	@Override
	public int getCommentTotal2(int board_seq) {
		return sqlSession.selectOne("managerfreeboardSQL.getCommentTotal2", board_seq);
	}

	@Override
	public FreeboardCommentDTO getManagerFreeboardCommentOne(String string) {
		int comment_pseq = Integer.parseInt(string);
		return sqlSession.selectOne("managerfreeboardSQL.getManagerFreeboardCommentOne", comment_pseq);
	}

	@Override
	public FreeboardDTO getPage(int board_seq) {
		return sqlSession.selectOne("managerfreeboardSQL.getPage", board_seq);
	}

	@Override
	public List<FreeboardDTO> getManagerFreeboardSearchList(Map<String, String> map) {
		return sqlSession.selectList("managerfreeboardSQL.getManagerFreeboardSearchList", map);
	}

	@Override
	public int getSearchTotal(Map<String, String> map) {
		return sqlSession.selectOne("managerfreeboardSQL.getSearchTotal",map);
	}

	@Override
	public void managerFreeboardDelete(int board_seq) {
		sqlSession.delete("managerfreeboardSQL.managerFreeboardDelete", board_seq);
		
	}

	@Override
	public void managerFreeboardListDelete(Map<String, String[]> map) {
		sqlSession.delete("managerfreeboardSQL.managerFreeboardListDelete", map);
		sqlSession.delete("managerfreeboardSQL.managerFreeboardListCommentDelete", map);
		
	}

	@Override
	public void managerCommentDelete(FreeboardCommentDTO freeboardCommentDTO) {
		sqlSession.delete("managerfreeboardSQL.managerCommentDelete", freeboardCommentDTO);
		
	}

}
