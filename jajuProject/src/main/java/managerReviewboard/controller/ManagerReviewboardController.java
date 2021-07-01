package managerReviewboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import managerReviewboard.service.ManagerReviewboardService;
import reviewboard.bean.ReviewboardDTO;
import reviewboard.bean.ReviewboardPaging;

@Controller
@RequestMapping(value = "/manager")
public class ManagerReviewboardController {
	@Autowired
	private ManagerReviewboardService managerReviewboardService;
	
	
	//---------리뷰 게시판 관리
		@RequestMapping(value="/managerReviewboardList", method=RequestMethod.GET)
		public String managerReviewboardList(Model model) {
			model.addAttribute("display", "/manager/managerReviewboardList.jsp");
			return "/index";
		}
			
		@RequestMapping(value="/getManagerReviewboardList", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getManagerReviewboardList(@RequestParam(required=false, defaultValue="1") String pg
													//HttpSession session,
													//HttpServletResponse response
			) {
				
			//1페이지당 
			List<ReviewboardDTO> list = managerReviewboardService.getManagerReviewboardList(pg);
					
			//세션
			//String memId = (String) session.getAttribute("memId");
					
			//페이징 처리
			ReviewboardPaging reviewboardPaging = managerReviewboardService.managerReviewboardPaging(pg);
				
			ModelAndView mav = new ModelAndView();
			mav.addObject("pg", pg);
			mav.addObject("list", list);
			//mav.addObject("memId", memId);
			mav.addObject("reviewboardPaging", reviewboardPaging);
				
			mav.setViewName("jsonView");
			return mav;
				
			}
}
