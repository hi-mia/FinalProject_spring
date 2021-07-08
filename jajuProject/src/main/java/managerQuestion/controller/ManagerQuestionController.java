package managerQuestion.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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

import inquire.bean.InquireDTO;
import inquire.bean.InquirePaging;
import managerQuestion.service.ManagerQuestionService;
import question.bean.QuestionDTO;
import question.bean.QuestionPaging;
@Controller
@RequestMapping(value = "/manager")
public class ManagerQuestionController {
	@Autowired
	private ManagerQuestionService managerQuestionService;
	
	//자주 하는 질문 관리 게시판 
	@RequestMapping(value="/managerServiceQuestion", method=RequestMethod.GET)
	public ModelAndView managerServiceQuestion(@RequestParam(required = false, defaultValue = "1") String pg) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.setViewName("/manager/managerServiceQuestion");
		
		return mav;
	}
	//자주 하는 질문 게시판 글쓰기 
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
		
		String filePath = "C:\\git_home\\git_jajuProject\\jajuProject\\src\\main\\webapp\\storage";
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
	
	@RequestMapping(value="/managerQuestionView", method=RequestMethod.GET)
	public ModelAndView managerQuestionView(@RequestParam(required = false, defaultValue = "1") String pg,
											@RequestParam String seq) {
		
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pg", pg);
		mav.addObject("seq", seq);
		mav.setViewName("/manager/managerQuestionView");
		
		return mav;
	}
	
	@RequestMapping(value="getManagerQuestionView", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerQuestionView(@RequestParam String seq) {
		
		QuestionDTO questionDTO = managerQuestionService.getManagerQuestionView(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("questionDTO", questionDTO);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/managerQuestionModifyForm", method=RequestMethod.POST)
	public ModelAndView managerQuestionModifyForm(@RequestParam(required = false, defaultValue = "1") String pg,
												  @RequestParam String question_seq) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pg", pg);
		mav.addObject("seq", question_seq);
		mav.setViewName("/manager/managerQuestionModifyForm");
		
		
		return mav;
	}
	
	@RequestMapping(value="getManagerQuestionModify", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerQuestionModify(@RequestParam String seq,
										HttpServletResponse response){
		
		QuestionDTO questionDTO = managerQuestionService.getManagerQuestionModify(seq);
	
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("questionDTO",questionDTO);
		mav.setViewName("jsonView");
		return mav;	
	}
	
		//자주하는 질문 수정
		@RequestMapping(value = "managerQuestionModify", method = RequestMethod.POST)
		@ResponseBody
		public void managerQuestionModify(@ModelAttribute QuestionDTO questionDTO,
								  @RequestParam Map<String, MultipartFile> imgMap,
								  @RequestParam Map<String, String> checkMap,
								 Model model) {
			String filePath;
			String fileName;
			File file;	
			
			
			if(checkMap.get("checkbox1") != null) {
				questionDTO.setQuestion_image1("");
			}
			else {
				if(imgMap.get("img1").getOriginalFilename() != "") {
					
						filePath = "C:\\git_home\\git_jajuProject\\jajuProject\\src\\main\\webapp\\storage";
						fileName = imgMap.get("img1").getOriginalFilename();
						file = new File(filePath,fileName);
						
						try {
							FileCopyUtils.copy(imgMap.get("img1").getInputStream(), new FileOutputStream(file));
						}catch (IOException e) {
							//e.printStackTrace();
						}
						questionDTO.setQuestion_image1(fileName);
				}
			}
			
			if(checkMap.get("checkbox2") != null) {
				questionDTO.setQuestion_image2("");
			}
			else {
				if(imgMap.get("img2").getOriginalFilename() != "") {
					
						filePath = "C:\\git_home\\git_jajuProject\\jajuProject\\src\\main\\webapp\\storage";
						fileName = imgMap.get("img2").getOriginalFilename();
						file = new File(filePath,fileName);
						
						try {
							FileCopyUtils.copy(imgMap.get("img2").getInputStream(), new FileOutputStream(file));
						}catch (IOException e) {
							//e.printStackTrace();
						}
						questionDTO.setQuestion_image2(fileName);
				}
			}
			
			if(checkMap.get("checkbox3") != null) {
				questionDTO.setQuestion_image3("");
			}
			else {
				if(imgMap.get("img3").getOriginalFilename() != "") {
				
						filePath = "C:\\git_home\\git_jajuProject\\jajuProject\\src\\main\\webapp\\storage";
						fileName = imgMap.get("img3").getOriginalFilename();
						file = new File(filePath,fileName);
						
						try {
							FileCopyUtils.copy(imgMap.get("img3").getInputStream(), new FileOutputStream(file));
						}catch (IOException e) {
							//e.printStackTrace();
						}
						questionDTO.setQuestion_image3(fileName);
				}
			}

//			DB
			managerQuestionService.managerQuestionModify(questionDTO);
		}
		
		@RequestMapping(value = "managerQuestionDelete", method=RequestMethod.GET)
		public ModelAndView managerQuestionDelete(String[] check) {
			
			managerQuestionService.managerQuestionDelete(check);
			return new ModelAndView("redirect:/manager/managerServiceQuestion");
		}
		
		@RequestMapping(value = "getQuestionSearchList", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView getQuestionSearchList(@RequestParam Map<String, String>map) {

			List<InquireDTO>list = managerQuestionService.getQuestionSearchList(map);
			
			QuestionPaging questionPaging = managerQuestionService.managerQuestionPaging(map);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("pg", map.get("pg"));
			mav.addObject("list", list);
			mav.addObject("questionPaging", questionPaging);
			mav.setViewName("jsonView");
			
			return mav;
			
	}
}
