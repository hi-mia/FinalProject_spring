package managerInquire.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import inquire.bean.InquireDTO;
import inquire.bean.InquirePaging;
import managerInquire.service.ManagerInquireService;
@Controller
@RequestMapping(value = "/manager")
public class ManagerInquireController {
	@Autowired
	private ManagerInquireService managerInquireService;
	
	
	@RequestMapping(value="/managerServiceInquire", method=RequestMethod.GET)
	public ModelAndView managerServiceInquire(@RequestParam(required = false, defaultValue = "1") String pg) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.setViewName("/manager/managerServiceInquire");
		
		return mav;
	}
	
	@RequestMapping(value="/getManagerInquire",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerInquire(@RequestParam(required = false, defaultValue = "1") String pg,
										  @RequestParam String inquiry_id,
										  HttpSession session) {
		
		List<InquireDTO>list = managerInquireService.getManagerInquire(pg);
		
		InquirePaging inquirePaging = managerInquireService.managerinquirePaging(pg);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("inquiry_id", inquiry_id);
		mav.addObject("inquirePaging", inquirePaging);
		mav.setViewName("jsonView");
		
		return mav;
		
	}
	
	@RequestMapping(value="/managerInquireReplyForm", method=RequestMethod.GET)
	public ModelAndView managerInquireReplyForm(@RequestParam(required = false, defaultValue = "1") String pg,
												@RequestParam String seq) {
		//답글 - 원글페이지, 원글 밑
		ModelAndView mav = new ModelAndView();
		mav.addObject("pseq",seq);//원글번호
		mav.addObject("pg",pg);//원글 페이지번호
		mav.setViewName("/manager/managerInquireReplyForm");
		
		return mav;
	}

	@RequestMapping(value = "managerInquireDelete", method=RequestMethod.GET)
	public ModelAndView managerInquireDelete(String[] check) {
		
		managerInquireService.managerInquireDelete(check);
		return new ModelAndView("redirect:/manager/managerServiceInquire");
	}
	
	@RequestMapping(value = "getInquireSearchList", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getInquireSearchList(@RequestParam Map<String, String>map) {

		List<InquireDTO>list = managerInquireService.getInquireSearchList(map);
		
		InquirePaging inquirePaging = managerInquireService.managerinquirePaging(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", map.get("pg"));
		mav.addObject("list", list);
		mav.addObject("inquirePaging", inquirePaging);
		mav.setViewName("jsonView");
		
		return mav;
		
}
}