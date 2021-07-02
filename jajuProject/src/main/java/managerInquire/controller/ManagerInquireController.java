package managerInquire.controller;

import java.util.List;

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
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("inquiry_id", inquiry_id);
		mav.setViewName("jsonView");
		//mav.addObject("managerPaging", managerPaging);
		
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
		System.out.println(mav);
		return mav;
	}

	@RequestMapping(value = "managerInquireDelete", method=RequestMethod.GET)
	public ModelAndView managerInquireDelete(String[] check) {
		System.out.println(check);
		managerInquireService.managerInquireDelete(check);
		return new ModelAndView("redirect:/manager/managerServiceInquire");
	}
}
