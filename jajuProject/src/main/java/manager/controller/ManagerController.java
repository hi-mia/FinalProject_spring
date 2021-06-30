package manager.controller;

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

import freeboard.bean.FreeboardCommentDTO;
import freeboard.bean.FreeboardCommentPaging;
import freeboard.bean.FreeboardDTO;
import freeboard.bean.FreeboardPaging;
import manager.service.ManagerService;
import member.bean.MemberDTO;

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

//---------------------- 게시판 관리	
		@RequestMapping(value="/managerFreeboardList", method=RequestMethod.GET)
		public String managerFreeboardList(Model model) {
			model.addAttribute("display", "/manager/managerFreeboardList.jsp");
			return "/index";
		}
		
		@RequestMapping(value="/getManagerFreeboardList", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getManagerFreeboardList(@RequestParam(required=false, defaultValue="1") String pg
													//HttpSession session,
													//HttpServletResponse response
				) {
			
			//1페이지당 
			List<FreeboardDTO> list = managerService.getManagerFreeboardList(pg);
			
			//세션
			//String memId = (String) session.getAttribute("memId");
			
			//페이징 처리
			FreeboardPaging freeboardPaging = managerService.managerfreeboardPaging(pg);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("pg", pg);
			mav.addObject("list", list);
			//mav.addObject("memId", memId);
			mav.addObject("freeboardPaging", freeboardPaging);
			
			mav.setViewName("jsonView");
			return mav;
			
		}
		
	//뷰
		@RequestMapping(value="/managerFreeboardView", method=RequestMethod.GET)
		public String managerFreeboardView(@RequestParam int board_seq,
											Model model) { //나에게 들어오는 데이터: seq, pg
			//						HttpSession session,
										
			//ID 세션 가져오기
			//String memId = (String) session.getAttribute("memId");
			//model.addAttribute("memId", memId);
			model.addAttribute("board_seq", board_seq); //seq를 모델에 넣어줌
					
			model.addAttribute("display","/manager/managerFreeboardView.jsp");
			return "/index";
		}
				
		@RequestMapping(value="/getManagerFreeboardView", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getManagerFreeboardView(@RequestParam int board_seq) {
											//HttpSession session,
											//HttpServletResponse response,
											//HttpServletRequest request

//			String memId = (String) session.getAttribute("memId");
		
			ModelAndView mav = new ModelAndView();
					
			FreeboardDTO freeboardDTO = managerService.getManagerFreeboardView(board_seq);
			
			mav.addObject("freeboardDTO", freeboardDTO);
			//mav.addObject("memId", memId);
			mav.setViewName("jsonView");
					
			return mav;
			
				}

	//댓글 가져오기
		@RequestMapping(value="getManagerFreeboardComment", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getManagerFreeboardComment(@RequestParam Map<String, String> map) {

			ModelAndView mav = new ModelAndView();
			
			List<FreeboardCommentDTO> list = managerService.getManagerFreeboardComment(map);
			
			FreeboardCommentPaging freeboardCommentPaging = managerService.freeboardCommentPaging(map);
			
			mav.addObject("freeboardCommentPaging", freeboardCommentPaging);
			mav.addObject("list", list);
			mav.setViewName("jsonView");
			
			return mav;
		}
		
		//댓글 1개 불러오기
		@RequestMapping(value="getManagerFreeboardCommentOne", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getManagerFreeboardCommentOne(@RequestParam String comment_seq) {

			ModelAndView mav = new ModelAndView();
			
			FreeboardCommentDTO freeboardCommentDTO = managerService.getManagerFreeboardCommentOne(comment_seq);
			
			mav.addObject("freeboardCommentDTO", freeboardCommentDTO);
			mav.setViewName("jsonView");
			
			return mav;
		}
		
	//이전글 다음글
		@RequestMapping(value="getPage", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getPage(@RequestParam int board_seq) {
			
			FreeboardDTO freeboardDTO = managerService.getPage(board_seq);
			
			//System.out.println(noticeDTO.getPrev_subject());
			//System.out.println(noticeDTO.getNext_subject());
			ModelAndView mav = new ModelAndView();
			mav.addObject("freeboardDTO", freeboardDTO);
			mav.setViewName("jsonView");
			return mav;
		}

		
		
		//검색
		@RequestMapping(value="getManagerFreeboardSearchList", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getManagerFreeboardSearchList(@RequestParam Map<String, String> map) {
												//HttpSession session
					
			//System.out.println(map.get("searchPg"));
			//1페이지당 5개씩
			List<FreeboardDTO> list = managerService.getManagerFreeboardSearchList(map);
					
			//세션
			//String memId = (String) session.getAttribute("memId");
			
			//페이징 처리
			FreeboardPaging freeboardPaging = managerService.freeboardPaging(map);
					
			ModelAndView mav = new ModelAndView();
			mav.addObject("pg", map.get("pg"));
			mav.addObject("list", list);
			mav.addObject("freeboardPaging", freeboardPaging);
			mav.setViewName("jsonView");
			return mav;
					
		}
		
	//삭제- 게시물
		@RequestMapping(value="managerFreeboardDelete", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView managerFreeboardDelete(@RequestParam int board_seq) {
	
			managerService.managerFreeboardDelete(board_seq);
			
			return new ModelAndView("redirect:/manager/managerFreeboardList");
		}
		
	//삭제 - 리스트
		@RequestMapping(value="managerFreeboardListDelete", method=RequestMethod.POST)
		public ModelAndView managerFreeboardListDelete(String[] check) {
	
			//System.out.println(check);
			managerService.managerFreeboardListDelete(check);
			
			return new ModelAndView("redirect:/manager/managerFreeboardList?pg=1");
		}
		
	
	//삭제-댓글
		@RequestMapping(value="managerCommentDelete", method=RequestMethod.POST)
		@ResponseBody
		public void managerCommentDelete(@RequestParam String comment_seq) {
			
			
			FreeboardCommentDTO freeboardCommentDTO = managerService.getManagerFreeboardCommentOne(comment_seq);
			
			managerService.managerCommentDelete(freeboardCommentDTO);
			
		}
		
		

}
