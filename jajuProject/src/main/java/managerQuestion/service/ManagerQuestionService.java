package managerQuestion.service;

import java.util.List;

import question.bean.QuestionDTO;
import question.bean.QuestionPaging;

public interface ManagerQuestionService {

	public void managerQuestionWrite(QuestionDTO questionDTO);

	public List<QuestionDTO> getManagerQuestionList(String pg);

	public QuestionPaging questionPaging(String pg);

}
