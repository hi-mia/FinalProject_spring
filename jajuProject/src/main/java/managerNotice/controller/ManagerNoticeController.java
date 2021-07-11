package managerNotice.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

import managerNotice.service.ManagerNoticeService;
import notice.bean.NoticeDTO;
import notice.bean.NoticePaging;
import report.bean.ReportDTO;

@Controller
@RequestMapping(value = "/manager")
public class ManagerNoticeController {
	@Autowired
	private ManagerNoticeService managerNoticeService;
	
	@RequestMapping(value="managerNoticeWriteForm", method=RequestMethod.GET)
	public ModelAndView managerNoticeWriteForm() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/managerNoticeWriteForm");
		return mav;
	}
	
	@RequestMapping(value="/managerNoticeWrite", method=RequestMethod.POST)
	@ResponseBody
	public void managerNoticeWrite(@ModelAttribute NoticeDTO noticeDTO,
							 @RequestParam ("img[]") List<MultipartFile> list) { //img[] 배열이라고 알려준다, 파일이 여러개가 가능) {


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
				noticeDTO.setImage0(fileName);
			}else if(i==1){
				noticeDTO.setImage1(fileName);
			}else if(i==2){
				noticeDTO.setImage2(fileName);
			}else if(i==3){
				noticeDTO.setImage3(fileName);
			}else if(i==4){
				noticeDTO.setImage4(fileName);
			}else if(i==5){
				noticeDTO.setImage5(fileName);
			}else if(i==6){
				noticeDTO.setImage6(fileName);
			}else if(i==7){
				noticeDTO.setImage7(fileName);
			}else if(i==8){
				noticeDTO.setImage8(fileName);
			}else if(i==9){
				noticeDTO.setImage9(fileName);
			}
			
			i++;
		
		}//for
		
		if(i==0) {
			noticeDTO.setImage0("");
			noticeDTO.setImage1("");
			noticeDTO.setImage2("");
			noticeDTO.setImage3("");
			noticeDTO.setImage4("");
			noticeDTO.setImage5("");
			noticeDTO.setImage6("");
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==1){
			noticeDTO.setImage1("");
			noticeDTO.setImage2("");
			noticeDTO.setImage3("");
			noticeDTO.setImage4("");
			noticeDTO.setImage5("");
			noticeDTO.setImage6("");
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==2){
			noticeDTO.setImage2("");
			noticeDTO.setImage3("");
			noticeDTO.setImage4("");
			noticeDTO.setImage5("");
			noticeDTO.setImage6("");
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==3){
			noticeDTO.setImage3("");
			noticeDTO.setImage4("");
			noticeDTO.setImage5("");
			noticeDTO.setImage6("");
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==4){
			noticeDTO.setImage4("");
			noticeDTO.setImage5("");
			noticeDTO.setImage6("");
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==5){
			noticeDTO.setImage5("");
			noticeDTO.setImage6("");
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==6){
			noticeDTO.setImage6("");
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==7){
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==8){
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==9){
			noticeDTO.setImage9("");
		}
		
		
		//DB
		managerNoticeService.managerNoticeWrite(noticeDTO);
	}
	
	@RequestMapping(value = "/managerNoticeList", method = RequestMethod.GET)
	public ModelAndView managerNoticeList(@RequestParam(required = false, defaultValue = "1") String pg) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.setViewName("/manager/managerNoticeList");
		return mav;
	}
	
	@RequestMapping(value="/getManagerNoticeList",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerNoticeList(@RequestParam Map<String, String> map,
										 @RequestParam(required=false, defaultValue="1") String pg) {
		
		List<NoticeDTO> list = managerNoticeService.getManagerNoticeList(map);
		
		NoticePaging noticePaging = managerNoticeService.noticePaging(pg);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("noticePaging", noticePaging);
		mav.setViewName("jsonView");
		return mav;
		
	}
	
	@RequestMapping(value = "/managerNoticeView", method = RequestMethod.GET)
	public ModelAndView managerNoticeView(@ModelAttribute NoticeDTO noticeDTO,
											@RequestParam String notice_seq,
											@RequestParam String pg) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeDTO", noticeDTO);
		mav.addObject("notice_seq", notice_seq);
		mav.addObject("pg", pg);
		mav.setViewName("/manager/managerNoticeView");
		return mav;
	}	
	
	@RequestMapping(value="/getNotice", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getNotice(@RequestParam String notice_seq) {

		NoticeDTO noticeDTO = managerNoticeService.getNotice(notice_seq);
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeDTO", noticeDTO);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/managerNoticeDelete", method=RequestMethod.POST)
	public ModelAndView managerNoticeDelete(String[] check) {
		
		managerNoticeService.managerNoticeDelete(check);
		
		return new ModelAndView("redirect:/manager/managerNoticeList");
	}
	
	@RequestMapping(value="/getNoticePage", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getNoticePage(@RequestParam String notice_seq) {
		
		NoticeDTO noticeDTO = managerNoticeService.getNoticePage(notice_seq);
		
		//System.out.println(noticeDTO.getPrev_subject());
		//System.out.println(noticeDTO.getNext_subject());
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeDTO", noticeDTO);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="getNoticeSearchList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getReportSearchList(@RequestParam Map<String, String> map) {
		
		List<NoticeDTO> list = managerNoticeService.getNoticeSearchList(map);
		
		//페이징 처리
		NoticePaging noticePaging = managerNoticeService.noticePaging(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", map.get("pg"));
		mav.addObject("list", list);
		mav.addObject("noticePaging", noticePaging);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/managerNoticeModify", method=RequestMethod.GET)
	public ModelAndView managerNoticeModify() {

		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/manager/managerNoticeModify");
		return mav;
	}
	
	@RequestMapping(value="/setNoticeModify", method=RequestMethod.POST)
	@ResponseBody
	public void setNoticeModify(@ModelAttribute NoticeDTO noticeDTO,
							 @RequestParam ("img[]") List<MultipartFile> list) { //img[] 배열이라고 알려준다, 파일이 여러개가 가능) {


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
				noticeDTO.setImage0(fileName);
			}else if(i==1){
				noticeDTO.setImage1(fileName);
			}else if(i==2){
				noticeDTO.setImage2(fileName);
			}else if(i==3){
				noticeDTO.setImage3(fileName);
			}else if(i==4){
				noticeDTO.setImage4(fileName);
			}else if(i==5){
				noticeDTO.setImage5(fileName);
			}else if(i==6){
				noticeDTO.setImage6(fileName);
			}else if(i==7){
				noticeDTO.setImage7(fileName);
			}else if(i==8){
				noticeDTO.setImage8(fileName);
			}else if(i==9){
				noticeDTO.setImage9(fileName);
			}
			
			i++;
		
		}//for
		
		if(i==0) {
			noticeDTO.setImage0("");
			noticeDTO.setImage1("");
			noticeDTO.setImage2("");
			noticeDTO.setImage3("");
			noticeDTO.setImage4("");
			noticeDTO.setImage5("");
			noticeDTO.setImage6("");
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==1){
			noticeDTO.setImage1("");
			noticeDTO.setImage2("");
			noticeDTO.setImage3("");
			noticeDTO.setImage4("");
			noticeDTO.setImage5("");
			noticeDTO.setImage6("");
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==2){
			noticeDTO.setImage2("");
			noticeDTO.setImage3("");
			noticeDTO.setImage4("");
			noticeDTO.setImage5("");
			noticeDTO.setImage6("");
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==3){
			noticeDTO.setImage3("");
			noticeDTO.setImage4("");
			noticeDTO.setImage5("");
			noticeDTO.setImage6("");
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==4){
			noticeDTO.setImage4("");
			noticeDTO.setImage5("");
			noticeDTO.setImage6("");
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==5){
			noticeDTO.setImage5("");
			noticeDTO.setImage6("");
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==6){
			noticeDTO.setImage6("");
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==7){
			noticeDTO.setImage7("");
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==8){
			noticeDTO.setImage8("");
			noticeDTO.setImage9("");
		}else if(i==9){
			noticeDTO.setImage9("");
		}
		
		
		//DB
		managerNoticeService.managerNoticeModify(noticeDTO);
	}
	
}
