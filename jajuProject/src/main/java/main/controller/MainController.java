package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import main.service.MainService;
import saleboard.bean.SaleboardDTO;

@Controller
@RequestMapping(value="/main")
public class MainController {
	@Autowired
	private MainService mainService;
	
	@RequestMapping(value="/slider01", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView slider01() {
		List<SaleboardDTO> list = mainService.popularity();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	@RequestMapping(value="/recommend", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView recommend(@RequestParam String category) {
		System.out.println(category);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		
		return mav;
	}
}
