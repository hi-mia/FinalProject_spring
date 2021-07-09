package inquire.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import inquire.service.InquireService;

@Controller
@RequestMapping(value="serviceCenter")
public class InquireController {
	@Autowired
	private InquireService inquireService;
	
	//1:1문의 작성
	@RequestMapping(value="inquireList", method=RequestMethod.GET)
	public String InquireList(Model model) {
		model.addAttribute("display", "/serviceCenter/inquireList.jsp");
		return "/index";
	}
	
	@RequestMapping(value="inquireWriteForm", method=RequestMethod.GET)
	public String inquireWriteForm(Model model) {
		model.addAttribute("display", "/serviceCenter/inquireWriteForm.jsp");
		return "/index";
	}
	
	@RequestMapping(value = "inquireWrite", method = RequestMethod.POST)
	@ResponseBody
	public void inquireWrite(@ModelAttribute InquireDTO inquireDTO,
							 @RequestParam ("img[]") List<MultipartFile> list,
							 HttpSession session,
							 Model model) {
		String filePath;
		String fileName;
		File file;	
		
		int i = 0;
		for(MultipartFile img: list) {
			filePath = "C:\\git_home\\git_jajuProject\\jajuProject\\src\\main\\webapp\\storage";
			fileName = img.getOriginalFilename();
			file = new File(filePath,fileName);
			
//			파일 복사
			try {
				FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
			}catch (IOException e) {
				//e.printStackTrace();
			}
			if(i == 0) {
				inquireDTO.setInquiry_image1(fileName);				
			}else if(i == 1) {
				inquireDTO.setInquiry_image2(fileName);				
			}else if(i == 2) {
				inquireDTO.setInquiry_image3(fileName);	
			}
			i++;
		}
	
		if(i == 0) {
			inquireDTO.setInquiry_image1("");
			inquireDTO.setInquiry_image2("");
			inquireDTO.setInquiry_image3("");
		}else if(i == 1) {
			inquireDTO.setInquiry_image2("");
			inquireDTO.setInquiry_image3("");
		}else if(i == 2) {
			inquireDTO.setInquiry_image3("");
		}
		i++;
		inquireDTO.setInquiry_id((String)session.getAttribute("memId"));
		//DB
		inquireService.inquireWrite(inquireDTO);
		
	}
	
	//1:1문의 목록
	@RequestMapping(value = "getInquireList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getInquireList(@RequestParam(required=false, defaultValue="1") String pg,
									   @RequestParam String inquiry_id,
									   HttpSession session) {
		//세션
		String memId = (String) session.getAttribute("memId");
				
	
		List<InquireDTO>list = inquireService.getInquireList(pg, inquiry_id);
		
		//페이징 처리
		InquirePaging inquirePaging = inquireService.inquirePaging(pg, inquiry_id);

		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg",pg);
		mav.addObject("list", list);
		mav.addObject("inquiry_id", inquiry_id);
		mav.addObject("inquirePaging", inquirePaging);
		mav.setViewName("jsonView");
		return mav;
		
	}
	
	//1:1문의확인 창
	@RequestMapping(value = "inquireView", method=RequestMethod.GET)
	public String inquireView(@RequestParam String seq, 
								 @RequestParam String pg,
								 @RequestParam (required=false, defaultValue="1") String inquiry_id,
								 Model model) {
		model.addAttribute("seq", seq);
		model.addAttribute("inquiry_id", inquiry_id);
		model.addAttribute("pg", pg);
		model.addAttribute("display","/serviceCenter/inquireView.jsp");
		return "/index";
		
	}
	
	//1:1문의확인 관리자창
		@RequestMapping(value = "managerInquireView", method=RequestMethod.GET)
		public ModelAndView managerInquireView(@RequestParam String seq, 
									 @RequestParam String pg,
									 @RequestParam (required=false, defaultValue="1") String inquiry_id,
									 Model model) {
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("inquiry_id", inquiry_id);
			mav.addObject("seq", seq);
			mav.addObject("pg", pg);
			mav.setViewName("/serviceCenter/inquireView");
			return mav;
			
		}
	
	@RequestMapping(value = "getInquireView", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getInquireView(@RequestParam String seq) {
		InquireDTO inquireDTO = inquireService.getInquireView(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("inquireDTO",inquireDTO);
		mav.setViewName("jsonView");
		return mav;
	}
	//1:1문의 수정
	@RequestMapping(value="inquireModifyForm", method=RequestMethod.POST)
	public String inquireModifyForm(@RequestParam String seq, 
									 @RequestParam String pg,
									 Model model) {
		model.addAttribute("seq", seq);
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/serviceCenter/inquireModifyForm.jsp");
		return "/index";
	}
	
	@RequestMapping(value="getInquireModify", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getInquireModify(@RequestParam String seq,
										HttpServletResponse response){
		
		InquireDTO inquireDTO = inquireService.getInquireModify(seq);
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("inquireDTO",inquireDTO);
		mav.setViewName("jsonView");
		return mav;	
	}
	
	//1:1문의 수정
	@RequestMapping(value = "inquireModify", method = RequestMethod.POST)
	@ResponseBody
	public void inquireModify(@ModelAttribute InquireDTO inquireDTO,
							  @RequestParam Map<String, MultipartFile> imgMap,
							  @RequestParam Map<String, String> checkMap,
							 Model model) {
		String filePath;
		String fileName;
		File file;	
		
		if(checkMap.get("checkbox1") != null) {
			inquireDTO.setInquiry_image1("");
		}
		else {
			if(imgMap.get("img1").getOriginalFilename() != "") {
				
					filePath = "D:\\git_home\\git_jajuProject\\jajuProject\\src\\main\\webapp\\storage";
					fileName = imgMap.get("img1").getOriginalFilename();
					file = new File(filePath,fileName);
					
					try {
						FileCopyUtils.copy(imgMap.get("img1").getInputStream(), new FileOutputStream(file));
					}catch (IOException e) {
						//e.printStackTrace();
					}
					inquireDTO.setInquiry_image1(fileName);
			}
		}
		
		if(checkMap.get("checkbox2") != null) {
			inquireDTO.setInquiry_image2("");
		}
		else {
			if(imgMap.get("img2").getOriginalFilename() != "") {
				
					filePath = "D:\\git_home\\git_jajuProject\\jajuProject\\src\\main\\webapp\\storage";
					fileName = imgMap.get("img2").getOriginalFilename();
					file = new File(filePath,fileName);
					
					try {
						FileCopyUtils.copy(imgMap.get("img2").getInputStream(), new FileOutputStream(file));
					}catch (IOException e) {
						//e.printStackTrace();
					}
					inquireDTO.setInquiry_image2(fileName);
			}
		}
		
		if(checkMap.get("checkbox3") != null) {
			inquireDTO.setInquiry_image3("");
		}
		else {
			if(imgMap.get("img3").getOriginalFilename() != "") {
			
					filePath = "D:\\git_home\\git_jajuProject\\jajuProject\\src\\main\\webapp\\storage";
					fileName = imgMap.get("img3").getOriginalFilename();
					file = new File(filePath,fileName);
					
					try {
						FileCopyUtils.copy(imgMap.get("img3").getInputStream(), new FileOutputStream(file));
					}catch (IOException e) {
						//e.printStackTrace();
					}
					inquireDTO.setInquiry_image3(fileName);
			}
		}

		//DB
		inquireService.inquireModify(inquireDTO);
	}
	
	@RequestMapping(value = "inquireDelete", method=RequestMethod.POST)
	public ModelAndView inquireDelete(@RequestParam String seq) {
		inquireService.inquireDelete(seq);
		
		return new ModelAndView("redirect:/serviceCenter/inquireList");
		
	}
	

	
	@RequestMapping(value="inquireReply", method=RequestMethod.POST)
	@ResponseBody
	public void inquireReply(@RequestParam Map<String, String>map) {//pseq, pg, subject, content
		inquireService.inquireReply(map);
	}
}
