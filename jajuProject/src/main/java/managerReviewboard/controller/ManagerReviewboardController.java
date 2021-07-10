package managerReviewboard.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		public ModelAndView managerReviewboardList(@RequestParam(required = false, defaultValue = "1") String pg) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("pg", pg);
			mav.setViewName("/manager/managerReviewboardList");
			return mav;
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
		


  //뷰
	@RequestMapping(value="/managerReviewboardView", method=RequestMethod.GET)
	public ModelAndView managerReviewboardView(@RequestParam int review_seq) { //나에게 들어오는 데이터: seq, pg
		//						HttpSession session,
									
		//ID 세션 가져오기
		//String memId = (String) session.getAttribute("memId");
		//model.addAttribute("memId", memId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("review_seq", review_seq); //seq를 모델에 넣어줌
				
		mav.setViewName("/manager/managerReviewboardView");
		return mav;
	}
	
	@RequestMapping(value="/getManagerReviewboardView", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerReviewboardView(@RequestParam int review_seq) {
										//HttpSession session,
										//HttpServletResponse response,
										//HttpServletRequest request

//		String memId = (String) session.getAttribute("memId");
	
		ModelAndView mav = new ModelAndView();
				
		ReviewboardDTO reviewboardDTO = managerReviewboardService.getManagerReviewboardView(review_seq);
		
		mav.addObject("reviewboardDTO", reviewboardDTO);
		//mav.addObject("memId", memId);
		mav.setViewName("jsonView");
				
		return mav;
		
			}

	//이전글 다음글
		@RequestMapping(value="getPage_review", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getPage_review(@RequestParam int review_seq) {
			
			ReviewboardDTO reviewboardDTO = managerReviewboardService.getPage_review(review_seq);
			
			ModelAndView mav = new ModelAndView();
			
			mav.addObject("reviewboardDTO", reviewboardDTO);
			
			mav.setViewName("jsonView");
			
			return mav;
		}
		
	//검색
		@RequestMapping(value="getManagerReviewboardSearchList", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getManagerReviewboardSearchList(@RequestParam Map<String, String> map) {
												//HttpSession session
					
			//System.out.println(map.get("searchPg"));
			//1페이지당 5개씩
			List<ReviewboardDTO> list = managerReviewboardService.getManagerReviewboardSearchList(map);
					
			//세션
			//String memId = (String) session.getAttribute("memId");
			
			//페이징 처리
			ReviewboardPaging reviewboardPaging = managerReviewboardService.reviewboardPaging(map);
					
			ModelAndView mav = new ModelAndView();
			mav.addObject("pg", map.get("pg"));
			mav.addObject("list", list);
			mav.addObject("reviewboardPaging", reviewboardPaging);
			mav.setViewName("jsonView");
			return mav;
					
		}
		
		//삭제- 게시물
		@RequestMapping(value="managerReviewboardDelete", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView managerReviewboardDelete(@RequestParam int review_seq) {

			managerReviewboardService.managerReviewboardDelete(review_seq);
			
			return new ModelAndView("redirect:/manager/managerReviewboardList");
		}

		//삭제 - 리스트
	      @RequestMapping(value="managerReviewboardListDelete", method=RequestMethod.POST)
	      public ModelAndView managerReviewboardListDelete(String[] check) {
	         
	         
	         //삭제되는 리뷰의 member_id가져오기
	         String[] member_id = new String[check.length];
	         
	         for(int i = 0; i<check.length; i++) {
	            ReviewboardDTO reviewboardDTO = managerReviewboardService.getManagerReviewboardView(Integer.parseInt(check[i]));
	            member_id[i] = reviewboardDTO.getMember_id();
	         }
	         
	         //System.out.println(check);
	         managerReviewboardService.managerReviewboardListDelete(check);
	         
	         //리뷰가 삭제된 후 매너온도 바꾸기
	         //1.각각의 아이디의 리스트를 다 가져오기
	         //2.그 리스트에서 매너온도를 다 더해주기 !기본값은 36.5
	         //3.더한 횟수 카운트 하기
	         //4.매너온도 더한 값을 카운트로 나누고 그 값으로 매너온도 바꾸기
	         //5.위 1~4까지를 반복하기
	         
	         for(int i = 0; i<check.length; i++) {
	            //그 아이디 값의 리뷰 가져오기
	            List<ReviewboardDTO> list = managerReviewboardService.getReviewListMember(member_id[i]);
	                        
	            //리뷰의 매너온도와 횟수 계산
	            double member_manner = 36.5;
	            int count = 1;
	            for(ReviewboardDTO dto : list) {
	               member_manner += Double.parseDouble(dto.getReview_manner());
	               count++;
	            }
	            
	            //계산된 매너온도로  회원의 매너온도 변환
	            managerReviewboardService.updateManner(member_manner/count, member_id[i]);
	            
	         }
         
	         return new ModelAndView("redirect:/manager/managerReviewboardList?pg=1");
	      }

		
}
