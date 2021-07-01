package managerFreeboard.controller;

import java.util.List;
import java.util.Map;

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
import managerFreeboard.service.ManagerFreeboardService;

@Controller
@RequestMapping(value = "/manager")
public class ManagerFreeboardController {
	
	@Autowired
	private ManagerFreeboardService managerFreeboardService;

	//---------------------- 게시판 관리	
	@RequestMapping(value="/managerFreeboardList", method=RequestMethod.GET)
	public ModelAndView managerFreeboardList(@RequestParam(required = false, defaultValue = "1") String pg) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.setViewName("/manager/managerFreeboardList");
		return mav;
	}
	
	@RequestMapping(value="/getManagerFreeboardList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerFreeboardList(@RequestParam(required=false, defaultValue="1") String pg
												//HttpSession session,
												//HttpServletResponse response
			) {
		
		//1페이지당 
		List<FreeboardDTO> list = managerFreeboardService.getManagerFreeboardList(pg);
		
		//세션
		//String memId = (String) session.getAttribute("memId");
		
		//페이징 처리
		FreeboardPaging freeboardPaging = managerFreeboardService.managerfreeboardPaging(pg);
		
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
	public ModelAndView managerFreeboardView(@RequestParam int board_seq) { //나에게 들어오는 데이터: seq, pg
		//						HttpSession session,
									
		//ID 세션 가져오기
		//String memId = (String) session.getAttribute("memId");
		//model.addAttribute("memId", memId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("board_seq", board_seq); //seq를 모델에 넣어줌
				
		mav.setViewName("/manager/managerFreeboardView");
		return mav;
	}
			
	@RequestMapping(value="/getManagerFreeboardView", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerFreeboardView(@RequestParam int board_seq) {
										//HttpSession session,
										//HttpServletResponse response,
										//HttpServletRequest request

//		String memId = (String) session.getAttribute("memId");
	
		ModelAndView mav = new ModelAndView();
				
		FreeboardDTO freeboardDTO = managerFreeboardService.getManagerFreeboardView(board_seq);
		
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
		
		List<FreeboardCommentDTO> list = managerFreeboardService.getManagerFreeboardComment(map);
		
		FreeboardCommentPaging freeboardCommentPaging = managerFreeboardService.freeboardCommentPaging(map);
		
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
		
		FreeboardCommentDTO freeboardCommentDTO = managerFreeboardService.getManagerFreeboardCommentOne(comment_seq);
		
		mav.addObject("freeboardCommentDTO", freeboardCommentDTO);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
//이전글 다음글
	@RequestMapping(value="getPage", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getPage(@RequestParam int board_seq) {
		
		FreeboardDTO freeboardDTO = managerFreeboardService.getPage(board_seq);
		
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
		List<FreeboardDTO> list = managerFreeboardService.getManagerFreeboardSearchList(map);
				
		//세션
		//String memId = (String) session.getAttribute("memId");
		
		//페이징 처리
		FreeboardPaging freeboardPaging = managerFreeboardService.freeboardPaging(map);
				
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

		managerFreeboardService.managerFreeboardDelete(board_seq);
		
		return new ModelAndView("redirect:/manager/managerFreeboardList");
	}
	
//삭제 - 리스트
	@RequestMapping(value="managerFreeboardListDelete", method=RequestMethod.POST)
	public ModelAndView managerFreeboardListDelete(String[] check) {

		//System.out.println(check);
		managerFreeboardService.managerFreeboardListDelete(check);
		
		return new ModelAndView("redirect:/manager/managerFreeboardList?pg=1");
	}
	

//삭제-댓글
	@RequestMapping(value="managerCommentDelete", method=RequestMethod.POST)
	@ResponseBody
	public void managerCommentDelete(@RequestParam String comment_seq) {
		
		
		FreeboardCommentDTO freeboardCommentDTO = managerFreeboardService.getManagerFreeboardCommentOne(comment_seq);
		
		managerFreeboardService.managerCommentDelete(freeboardCommentDTO);
		
	}
	
}
