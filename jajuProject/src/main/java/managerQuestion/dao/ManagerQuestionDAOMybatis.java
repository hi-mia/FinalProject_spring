package managerQuestion.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

}
