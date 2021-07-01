package manager.controller;

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

import manager.service.ManagerService;
import member.bean.MemberDTO;
import notice.bean.NoticeDTO;
import notice.bean.NoticePaging;
import report.bean.ReportDTO;
import report.bean.ReportPaging;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/index");
		return mav;
	}

	@RequestMapping(value = "managerMember", method = RequestMethod.GET)
	public ModelAndView managerMember() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/managerMember");
		return mav;
	}

	// 화면 띄웠을 때 리스트 가져오기
	@RequestMapping(value = "/getManagerMember", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerMember(@RequestParam Map<String, String> map,
			@RequestParam(required = false, defaultValue = "1") String pg) {
		System.out.println("관리자 리스트 가져오는 곳 맵 : " + map);

		List<MemberDTO> list = managerService.getManagerMember(map);// pg넘겨서 페이징 처리해서 회원 리스트 가져오기

		// System.out.println("겟메니저맴버= "+list);

		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		// mav.addObject("managerPaging", managerPaging);
		return mav;
	}

	// 활동정지
	@RequestMapping(value = "changeMemberState", method = RequestMethod.POST)
	// check 안에는 id값이 담겨있음.
	public ModelAndView changeMemberState(String[] check,
			@RequestParam(required = false, defaultValue = "1") String pg) {
		System.out.println("check = " + check[0]);
		managerService.changeMemberState(check);
		return new ModelAndView("redirect:/manager/managerMember");
	}

	// 강제탈퇴
	@RequestMapping(value = "deleteMemberId", method = RequestMethod.POST)
	public ModelAndView deleteMemberId(String[] check) {
		System.out.println("check = " + check[0]);
		managerService.deleteMemberId(check);
		return new ModelAndView("redirect:/manager/managerMember");
	}

	// 검색(아이디,이메일,아디+이멜) 검색 후 결과출력
	@RequestMapping(value = "getSearchMemberInfo", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getSearchMemberInfo(@RequestParam Map<String, String> map,
			@RequestParam(required = false, defaultValue = "1") String pg) {
		System.out.println("getSearchMemberInfo : " + map);

		List<MemberDTO> list = managerService.getSearchMemberInfo(map);// pg넘겨서 페이징 처리해서 회원 리스트 가져오기

		System.out.println("getSearchMemberInfo= " + list);

		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		// mav.addObject("managerPaging", managerPaging);
		return mav;
	}

	// 전체회원 페이지 오픈 하는 곳, pg 1로 넘기기
	@RequestMapping(value = "/managerMemberBlack", method = RequestMethod.GET)
	public String managerMemberBlack(Model model, @RequestParam(required = false, defaultValue = "1") String pg) {
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/manager/managerMemberBlack.jsp");
		return "/index";
	}

	// 블랙리스트 불러오기
	@RequestMapping(value = "/getManagerMemberBlack", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerMemberBlack(@RequestParam Map<String, String> map,
		@RequestParam(required = false, defaultValue = "1") String pg) {
		System.out.println("블랙리스트 맵 : " + map);

		List<MemberDTO> list = managerService.getManagerMemberBlack(map);// pg넘겨서 페이징 처리해서 회원 리스트 가져오기

		// System.out.println("블랙리스트 = "+list);

		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		// mav.addObject("managerPaging", managerPaging);
		return mav;
	}
	
	@RequestMapping(value = "managerServiceInquire", method = RequestMethod.GET)
	public ModelAndView managerServiceInquire() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/managerServiceInquire");
		return mav;
	}
	
	@RequestMapping(value = "managerServiceQuestion", method = RequestMethod.GET)
	public ModelAndView managerServiceQuestion() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/managerServiceQuestion");
		return mav;
	}
	
}
