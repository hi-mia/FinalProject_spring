package notice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import notice.bean.NoticeDTO;
import notice.bean.NoticePaging;
import notice.service.NoticeService;

@Controller
@RequestMapping(value="serviceCenter")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="noticeList", method=RequestMethod.GET)
	public String noticeList(@RequestParam(required=false, defaultValue="1") String pg,
							 Model model) {
		
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/serviceCenter/noticeList.jsp");
		return "/index";
	}
	
	@RequestMapping(value="getNoticeList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getNoticeList(@RequestParam(required=false, defaultValue="1") String pg) {
		
		//1 페이지당 10개씩
		List<NoticeDTO> list = noticeService.getNoticeList(pg);
		
		//페이징 처리
		NoticePaging noticePaging = noticeService.noticePaging(pg); 
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		//System.out.println(list);
		mav.addObject("list", list);
		mav.addObject("noticePaging", noticePaging);
		
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="noticeView", method=RequestMethod.GET)
	public String noticeView(@ModelAttribute NoticeDTO noticeDTO,
							 @RequestParam String notice_seq,
							 @RequestParam String pg,
							 Model model) {
		
		//System.out.println(notice_seq);
		//System.out.println(pg);
		model.addAttribute("noticeDTO", noticeDTO);
		model.addAttribute("notice_seq", notice_seq);
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/serviceCenter/noticeView.jsp");
		return "/index";
	}	
	
	@RequestMapping(value="getNotice", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getNotice(@RequestParam String notice_seq) {

		NoticeDTO noticeDTO = noticeService.getNotice(notice_seq);
		
		//noticeDTO = noticeService.getPage(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeDTO", noticeDTO);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="getNoticeSearchList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getReportSearchList(@RequestParam Map<String, String> map) {
		
		List<NoticeDTO> list = noticeService.getNoticeSearchList(map);
		
		//페이징 처리
		NoticePaging noticePaging = noticeService.noticePaging(map);
		
		ModelAndView mav = new ModelAndView();
		//System.out.println(map.get("pg"));
		mav.addObject("pg", map.get("pg"));
		mav.addObject("list", list);
		mav.addObject("noticePaging", noticePaging);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="getNoticePage", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getNoticePage(@RequestParam String notice_seq) {
		
		NoticeDTO noticeDTO = noticeService.getNoticePage(notice_seq);
		
		//System.out.println(noticeDTO.getPrev_subject());
		//System.out.println(noticeDTO.getNext_subject());
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeDTO", noticeDTO);
		mav.setViewName("jsonView");
		return mav;
	}

}
