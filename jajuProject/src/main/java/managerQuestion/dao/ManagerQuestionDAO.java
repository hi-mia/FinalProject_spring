package managerQuestion.dao;

import java.util.List;
import java.util.Map;

import question.bean.QuestionDTO;

public interface ManagerQuestionDAO {

	public void managerQuestionWrite(QuestionDTO questionDTO);

	public List<QuestionDTO> getManagerQuestionList(Map<String, String> map);

	public int getTotalA();

}
