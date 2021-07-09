package main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import freeboard.bean.FreeboardDTO;
import main.service.MainService;
import saleboard.bean.SaleboardDTO;

@Controller
@RequestMapping(value="/main")
public class MainController {
	@Autowired
	private MainService mainService;
	
	@RequestMapping(value="/slider01", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView slider01(HttpSession session) {
		List<SaleboardDTO> list = mainService.popularity();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memId", (String) session.getAttribute("memId"));
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	@RequestMapping(value="/recommend", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView recommend(@RequestParam String category, HttpSession session) {
		List<SaleboardDTO> list = mainService.recommend(category);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memId", (String) session.getAttribute("memId"));
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	@RequestMapping(value="/board", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView board(HttpSession session) {
		List<FreeboardDTO> list = mainService.board();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memId", (String) session.getAttribute("memId"));
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
		return mav;
	}
}
