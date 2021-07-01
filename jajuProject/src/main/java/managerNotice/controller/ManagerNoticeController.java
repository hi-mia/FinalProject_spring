package managerNotice.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping(value = "managerServiceNoticeList", method = RequestMethod.GET)
	public ModelAndView managerServiceNoticeList(@RequestParam(required = false, defaultValue = "1") String pg) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.setViewName("/manager/managerServiceNoticeList");
		return mav;
	}
	
	@RequestMapping(value="/noticeView", method=RequestMethod.GET)
	public String noticeView(@ModelAttribute NoticeDTO noticeDTO,
							 @RequestParam String notice_seq,
							 @RequestParam String pg,
							 Model model) {
		
		model.addAttribute("noticeDTO", noticeDTO);
		model.addAttribute("notice_seq", notice_seq);
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/serviceCenter/noticeView.jsp");
		return "/index";
	}	
	
	@RequestMapping(value="/getManagerNoticeList",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView managerServiceReportList(@RequestParam Map<String, String> map,
										 @RequestParam(required=false, defaultValue="1") String pg) {
		
		List<NoticeDTO> list = managerNoticeService.getManagerNoticeList(map);
		
		NoticePaging noticePaging = managerNoticeService.noticePaging(pg);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		mav.addObject("noticePaging", noticePaging);
		return mav;
		
	}
	
}
