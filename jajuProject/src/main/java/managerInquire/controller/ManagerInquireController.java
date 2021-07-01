package managerInquire.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public ModelAndView managerServiceInquire() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/managerServiceInquire");
		
		return mav;
	}
	
	@RequestMapping(value="/getManagerInquire",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerInquire(@RequestParam(required = false, defaultValue = "1") String pg, 
										  HttpSession session) {
		
		List<InquireDTO>list = managerInquireService.getManagerInquire(pg);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		//mav.addObject("managerPaging", managerPaging);
		return mav;
		
	}

}
