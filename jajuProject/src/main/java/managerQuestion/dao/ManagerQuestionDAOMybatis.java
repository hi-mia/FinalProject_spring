package managerQuestion.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import inquire.bean.InquireDTO;
import question.bean.QuestionDTO;

@Transactional
@Repository
public class ManagerQuestionDAOMybatis implements ManagerQuestionDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void managerQuestionWrite(QuestionDTO questionDTO) {
		sqlSession.insert("managerQuestionSQL.managerQuestionWrite",questionDTO);
		
	}

	@Override
	public List<QuestionDTO> getManagerQuestionList(Map<String, String> map) {
		List<QuestionDTO> list = sqlSession.selectList("managerQuestionSQL.getManagerQuestionList", map);
		return list;
	}

	@Override
	public int getTotalA() {
		return sqlSession.selectOne("managerQuestionSQL.getTotalA");
	}

	@Override
	public QuestionDTO getManagerQuestionView(String seq) {
		return sqlSession.selectOne("managerQuestionSQL.getManagerQuestionView", Integer.parseInt(seq));
	}

	@Override
	public QuestionDTO getManagerQuestionModify(String seq) {
		return sqlSession.selectOne("managerQuestionSQL.getManagerQuestionModify", Integer.parseInt(seq));
	}

	@Override
	public void managerQuestionModify(QuestionDTO questionDTO) {
		sqlSession.update("managerQuestionSQL.managerQuestionModify", questionDTO);
		
	}

	@Override
	public void managerQuestionDelete(Map<String, String[]> map) {
		sqlSession.delete("managerQuestionSQL.managerQuestionDelete", map);
		
	}

	@Override
	public List<InquireDTO> getQuestionSearchList(Map<String, String> map) {
		List<InquireDTO> list =  sqlSession.selectList("managerQuestionSQL.getQuestionSearchList", map);
		return list;
	}

	@Override
	public int getTotalSearchA(Map<String, String> map) {
		return sqlSession.selectOne("managerQuestionSQL.getTotalSearchA", map);
	}
}
