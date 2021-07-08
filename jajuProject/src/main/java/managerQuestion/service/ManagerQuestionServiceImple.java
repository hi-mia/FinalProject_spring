package managerQuestion.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inquire.bean.InquireDTO;
import managerQuestion.dao.ManagerQuestionDAO;
import question.bean.QuestionDTO;
import question.bean.QuestionPaging;

@Service
public class ManagerQuestionServiceImple implements ManagerQuestionService {
	@Autowired
	private ManagerQuestionDAO managerQuestionDAO;
	@Autowired
	private QuestionPaging questionPaging;
	
	@Override
	public void managerQuestionWrite(QuestionDTO questionDTO) {
		managerQuestionDAO.managerQuestionWrite(questionDTO);
		
	}

	@Override
	public List<QuestionDTO> getManagerQuestionList(String pg) {
		int endNum = Integer.parseInt(pg)*10;
		int startNum = endNum-9;
		
		Map<String, String> map = new HashedMap<String, String>();
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		
		return managerQuestionDAO.getManagerQuestionList(map);
	}

	@Override
	public QuestionPaging questionPaging(String pg) {
		int totalA = managerQuestionDAO.getTotalA(); //총글수
		
		questionPaging.setCurrentPage(Integer.parseInt(pg));//현재 페이지
		questionPaging.setPageBlock(5);
		questionPaging.setPageSize(10);
		questionPaging.setTotalA(totalA);
		questionPaging.makePagingHTML();
		
		return questionPaging;
	}

	@Override
	public QuestionDTO getManagerQuestionView(String seq) {
		return managerQuestionDAO.getManagerQuestionView(seq);
	}

	@Override
	public QuestionDTO getManagerQuestionModify(String seq) {
		return managerQuestionDAO.getManagerQuestionModify(seq);
	}

	@Override
	public void managerQuestionModify(QuestionDTO questionDTO) {
		managerQuestionDAO.managerQuestionModify(questionDTO);
		
	}

	@Override
	public void managerQuestionDelete(String[] check) {
		Map<String, String[]>map = new HashedMap<String, String[]>();
		map.put("array", check);
		
		managerQuestionDAO.managerQuestionDelete(map);
		
	}

	@Override
	public List<InquireDTO> getQuestionSearchList(Map<String, String> map) {
		int endNum = Integer.parseInt(map.get("pg"))*10;
		int startNum = endNum-9;
		
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		return managerQuestionDAO.getQuestionSearchList(map);
	}

	@Override
	public QuestionPaging managerQuestionPaging(Map<String, String> map) {
		int totalA = managerQuestionDAO.getTotalSearchA(map);
		
		questionPaging.setCurrentPage(Integer.parseInt(map.get("pg")));
		questionPaging.setPageBlock(5);
		questionPaging.setPageSize(10);
		questionPaging.setTotalA(totalA);
		questionPaging.makePagingHTML();	
		return questionPaging;
	}

}
