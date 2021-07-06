package managerQuestion.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import managerQuestion.service.ManagerQuestionService;
import question.bean.QuestionDTO;
import question.bean.QuestionPaging;
@Controller
@RequestMapping(value = "/manager")
public class ManagerQuestionController {
	@Autowired
	private ManagerQuestionService managerQuestionService;
	
	@RequestMapping(value="/managerServiceQuestion", method=RequestMethod.GET)
	public ModelAndView managerServiceQuestion(@RequestParam(required = false, defaultValue = "1") String pg) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.setViewName("/manager/managerServiceQuestion");
		
		return mav;
	}
	@RequestMapping(value="managerQuestionWriteForm", method=RequestMethod.GET)
	public ModelAndView managerQuestionWriteForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/managerQuestionWriteForm");
		return mav;
	}
	
	@RequestMapping(value="managerQuestionWrite", method=RequestMethod.POST)
	@ResponseBody
	public void managerQuestionWrite(@ModelAttribute QuestionDTO questionDTO,
							 @RequestParam ("img[]") List<MultipartFile> list,
							 @RequestParam Map<String, String> map) { //img[] 배열이라고 알려준다, 파일이 여러개가 가능) {
		
		String filePath = "D:\\git_home\\git_jajuProject\\jajuProject\\src\\main\\webapp\\storage";
		String fileName;
		File file;

		//파일 복사
		int i=0;
		for(MultipartFile img : list) {
			fileName = img.getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
			} catch (IOException e) {
				//e.printStackTrace();
			}
			
			if(i==0) {
				questionDTO.setQuestion_image1(fileName);
			}else if(i==1){
				questionDTO.setQuestion_image2(fileName);
			}else if(i==2){
				questionDTO.setQuestion_image3(fileName);
			}
			
			i++;
		
		}//for
		
		if(i==0) {
			questionDTO.setQuestion_image1("");
			questionDTO.setQuestion_image2("");
			questionDTO.setQuestion_image3("");
		}else if(i==1){
			questionDTO.setQuestion_image2("");
			questionDTO.setQuestion_image3("");
		}else if(i==2){
			questionDTO.setQuestion_image3("");
		}
		i++;
		
		//DB
		managerQuestionService.managerQuestionWrite(questionDTO);
	}
	
	@RequestMapping(value="getManagerQuestionList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerQuestionList(@RequestParam(required=false, defaultValue="1") String pg) {
		//1 페이지당 10개씩
		List<QuestionDTO> list = managerQuestionService.getManagerQuestionList(pg);
		
		//페이징 처리
		QuestionPaging questionPaging = managerQuestionService.questionPaging(pg); 
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("questionPaging", questionPaging);
		
		mav.setViewName("jsonView");
		return mav;
	}
}
