package managerQuestion.service;

import java.util.List;
import java.util.Map;

import inquire.bean.InquireDTO;
import question.bean.QuestionDTO;
import question.bean.QuestionPaging;

public interface ManagerQuestionService {

	public void managerQuestionWrite(QuestionDTO questionDTO);

	public List<QuestionDTO> getManagerQuestionList(String pg);

	public QuestionPaging questionPaging(String pg);

	public QuestionDTO getManagerQuestionView(String seq);

	public QuestionDTO getManagerQuestionModify(String seq);

	public void managerQuestionModify(QuestionDTO questionDTO);

	public void managerQuestionDelete(String[] check);

	public List<InquireDTO> getQuestionSearchList(Map<String, String> map);

	public QuestionPaging managerQuestionPaging(Map<String, String> map);

}
