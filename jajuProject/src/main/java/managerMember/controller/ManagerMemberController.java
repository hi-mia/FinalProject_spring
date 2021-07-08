package managerMember.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import managerMember.bean.ManagerMainDTO;
import managerMember.bean.ManagerPaging;
import managerMember.service.ManagerMemberService;
import member.bean.MemberDTO;

@Controller
@RequestMapping(value = "/manager")
public class ManagerMemberController {

	@Autowired
	private ManagerMemberService managerMemberService;
	
	@RequestMapping(value = "managerMainChart", method = RequestMethod.GET)
	public ModelAndView managerMainChart(@RequestParam(required = false, defaultValue = "1") String pg) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg",pg);
		mav.setViewName("/manager/managerMainChart");
		return mav;
	}
	
	@RequestMapping(value = "managerMember", method = RequestMethod.GET)
	public ModelAndView managerMember(@RequestParam(required = false, defaultValue = "1") String pg,
			@RequestParam(required = false, defaultValue = "member_date_desc") String sortinSelectHidden) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg",pg);
		mav.addObject("sortinSelectHidden",sortinSelectHidden);
		mav.setViewName("/manager/managerMember");
		return mav;
	}

	// 화면 띄웠을 때 리스트 가져오기
	@RequestMapping(value = "/getManagerMember", method = RequestMethod.POST)
	@ResponseBody
	
	public ModelAndView getManagerMember(@RequestParam Map<String, String> map,
											@RequestParam(required = false, defaultValue = "1") String pg) {
		//System.out.println("관리자 리스트 가져오는 곳 맵 : " + map);

		List<MemberDTO> list = managerMemberService.getManagerMember(map);// pg넘겨서 페이징 처리해서 회원 리스트 가져오기

		ManagerPaging managerPaging = managerMemberService.managerPaging(map);


		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("managerPaging", managerPaging);
		mav.setViewName("jsonView");
		return mav;
	}

	// 활동정지
	@RequestMapping(value = "changeMemberState", method = RequestMethod.POST)
	// check 안에는 id값이 담겨있음.
	public ModelAndView changeMemberState(String[] check,
			@RequestParam(required = false, defaultValue = "1") String pg) {
		//System.out.println("check = " + check[0]);
		managerMemberService.changeMemberState(check);
		return new ModelAndView("redirect:/manager/managerMember?sortinSelect=member_date_desc");
	}
	
	// 활동정지해제
	@RequestMapping(value = "changeBlackMemberStateRollback", method = RequestMethod.POST)
	// check 안에는 id값이 담겨있음.
	public ModelAndView changeBlackMemberStateRollback(String[] check,
		@RequestParam(required = false, defaultValue = "1") String pg) {
		//System.out.println("check = " + check[0]);
		managerMemberService.changeBlackMemberStateRollback(check);
		return new ModelAndView("redirect:/manager/managerMemberBlack?sortinSelect=break_member");
		}
	
	// 강제탈퇴
	@RequestMapping(value = "deleteMemberId", method = RequestMethod.POST)
	public ModelAndView deleteMemberId(String[] check) {
		//System.out.println("check = " + check[0]);
		managerMemberService.deleteMemberId(check);
		return new ModelAndView("redirect:/manager/managerMember?sortinSelect=member_date_desc");
	}

	// 검색(아이디,이메일,아디+이멜) 검색 후 결과출력
	@RequestMapping(value = "getSearchMemberInfo", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getSearchMemberInfo(@RequestParam Map<String, String> map,
			@RequestParam(required = false, defaultValue = "1") String pg) {
		//System.out.println("getSearchMemberInfo : " + map);

		List<MemberDTO> list = managerMemberService.getSearchMemberInfo(map);// pg넘겨서 페이징 처리해서 회원 리스트 가져오기
		
		ManagerPaging managerSearchPaging = managerMemberService.managerSearchPaging(map);

		//System.out.println("getSearchMemberInfo= " + list);

		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		mav.addObject("managerSearchPaging", managerSearchPaging);
		return mav;
	}

	//전체회원 페이지 오픈 하는 곳, pg 1로 넘기기
	@RequestMapping(value = "/managerMemberBlack", method = RequestMethod.GET)
	public ModelAndView managerMemberBlack(Model model, @RequestParam(required = false, defaultValue = "1") String pg) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg",pg);
		mav.setViewName("/manager/managerMemberBlack");
		return mav;
	}

	// 블랙리스트 불러오기
	@RequestMapping(value = "/getManagerMemberBlack", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerMemberBlack(@RequestParam Map<String, String> map,
		@RequestParam(required = false, defaultValue = "1") String pg) {
		//System.out.println("블랙리스트 맵 : " + map);
		//System.out.println("elqjrm1"+map);
		List<MemberDTO> list = managerMemberService.getManagerMemberBlack(map);// pg넘겨서 페이징 처리해서 회원 리스트 가져오기

		// System.out.println("블랙리스트 = "+list);
		ManagerPaging managerPagingBlack = managerMemberService.managerPagingBlack(map);

		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		mav.addObject("managerPagingBlack", managerPagingBlack);
		return mav;
	}
	
	//changeBlackMemberState 에 대한 변경 컨트롤러 작성하기
	// 활동정지해제~ black-> 일반으로
	@RequestMapping(value = "changeBlackMemberState", method = RequestMethod.POST)
	// check 안에는 id값이 담겨있음.
	public ModelAndView changeBlackMemberState(String[] check,
			@RequestParam(required = false, defaultValue = "1") String pg) {
		//System.out.println("check = " + check[0]);
		//managerMemberService.changeBlackMemberState(check); ---> 이거 해결하기~ 
		return new ModelAndView("redirect:/manager/managerMemberBlack");
	}
	
	// 블랙리스트 검색(아이디,이메일,아디+이멜) 검색 후 결과출력
		@RequestMapping(value = "getSearchManagerMemberBlack", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView getSearchManagerMemberBlack(@RequestParam Map<String, String> map,
				@RequestParam(required = false, defaultValue = "1") String pg) {
			//System.out.println("getSearchMemberInfo : " + map);

			List<MemberDTO> list = managerMemberService.getSearchManagerMemberBlack(map);// pg넘겨서 페이징 처리해서 회원 Black리스트 가져오기
			
			ManagerPaging managerSearchBlackPaging = managerMemberService.managerSearchBlackPaging(map);

			ModelAndView mav = new ModelAndView();
			mav.addObject("pg", pg);
			mav.addObject("list", list);
			mav.setViewName("jsonView");
			mav.addObject("managerSearchBlackPaging", managerSearchBlackPaging);
			return mav;
		}
	/*------- 차트 구현을 위한 controller --------*/
	//카테고리
	@RequestMapping(value = "/getMemberCategory", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getMemberCategory(@RequestParam Map<String, String> map,
		@RequestParam(required = false, defaultValue = "1") String pg) {
		
		List<ManagerMainDTO> list = managerMemberService.getMemberCategory();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	//1일 판매 게시글 개수(7일)
	@RequestMapping(value = "/getSaleAvg", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getSaleAvg(@RequestParam Map<String, String> map,
		@RequestParam(required = false, defaultValue = "1") String pg) {
		
		ManagerMainDTO managerMainDTO = managerMemberService.getSaleAvg();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("managerMainDTO", managerMainDTO);
		mav.setViewName("jsonView");
		return mav;
	}
	//자주마켓 회원 관심지역 등록 best 5 
	@RequestMapping(value = "/getLocationInfo", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getLocationInfo(@RequestParam Map<String, String> map,
										@RequestParam(required = false, defaultValue = "1") String pg) {
		
		List<ManagerMainDTO> list = managerMemberService.getLocationInfo();
		
		//System.out.println("관심지역 베스트5 리스트"+list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	//mainChart의 count수 가져오기
	@RequestMapping(value = "/getManagerMainCount", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerMainCount() {
		//신규 1:1문의수
		int inquire_db = managerMemberService.getManagerInquireCount();
		//신고 게시글 처리중 수
		int report_db = managerMemberService.getManagerReportCount();
		//당일 신규 가입자 수
		int newMember_db = managerMemberService.getManagerMemberCount();
		//당일 판매 게시글 등록 수 불러오기 
		int saleReport_db = managerMemberService.getManagerSaleReportCount();
		
		/*
		 * Map<String, String> mapData = new HashMap<String, String>();
		 * mapData.put("inquire_db", inquire_db+""); mapData.put("report_db",
		 * report_db+""); mapData.put("newMember_db", newMember_db+"");
		 * mapData.put("saleReport_db", saleReport_db+"");
		 */
		
		//System.out.println("db에서 불러온 COUNT NUM = "+inquire_db+","+report_db+","+newMember_db+","+saleReport_db);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("inquire_db",inquire_db+"");
		mav.addObject("report_db",report_db+"");
		mav.addObject("newMember_db",newMember_db+"");
		mav.addObject("saleReport_db",saleReport_db+"");
		
		mav.setViewName("jsonView");
		return mav;
	}
	//mainChart의 어제 날짜 count 가져오기  getManagerPrevCount
	@RequestMapping(value = "/getManagerPrevCount", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerPrevCount() {
		//신규 1:1문의수
		int inquirePrevCount = managerMemberService.getPrevInquireCount();
		//신고 게시글 처리중 수
		int reportPrevCount = managerMemberService.getPrevReportCount();
		//당일 신규 가입자 수
		int newMemberPrevCount = managerMemberService.getPrevMemberCount();
		//당일 판매 게시글 등록 수 불러오기 
		int saleReportPrevCount = managerMemberService.getPrevSaleReportCount();
		
		/*
		 * Map<String, String> mapData = new HashMap<String, String>();
		 * mapData.put("inquire_db", inquire_db+""); mapData.put("report_db",
		 * report_db+""); mapData.put("newMember_db", newMember_db+"");
		 * mapData.put("saleReport_db", saleReport_db+"");
		 */
		
		//System.out.println("db에서 불러온 COUNT NUM = "+inquirePrevCount+","+reportPrevCount+","+newMemberPrevCount+","+saleReportPrevCount);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("inquire_db",inquirePrevCount+"");
		mav.addObject("report_db",reportPrevCount+"");
		mav.addObject("newMember_db",newMemberPrevCount+"");
		mav.addObject("saleReport_db",saleReportPrevCount+"");
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	@RequestMapping(value = "/getDatePickerInfo", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getDatePickerInfo(@RequestParam Map<String, String> map) {
		//System.out.println("map, getDatePickerInfo date의 값 넘어와야 함 "+map);
	
		//신규 1:1문의수
		int inquirePickerCount = managerMemberService.getInquirePickerCount(map);
		//신고 게시글 처리중 수
		int reportPickerCount = managerMemberService.getReportPickerCount(map);
		//당일 신규 가입자 수
		int newMemberPickerCount = managerMemberService.getNewMemberPickerCount(map);
		//당일 판매 게시글 등록 수 불러오기 
		int saleReportPickerCount = managerMemberService.getSaleReportPickerCount(map);
		//System.out.println("db에서 불러온 COUNT NUM = "+inquirePickerCount+","+reportPickerCount+","+newMemberPickerCount+","+saleReportPickerCount);
		ModelAndView mav = new ModelAndView();
		mav.addObject("inquirePickerCount",inquirePickerCount+"");
		mav.addObject("reportPickerCount",reportPickerCount+"");
		mav.addObject("newMemberPickerCount",newMemberPickerCount+"");
		mav.addObject("saleReportPickerCount",saleReportPickerCount+"");
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	@RequestMapping(value = "/getCalenderInfo", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getCalenderInfo(@RequestParam Map<String, String> map) {
		//System.out.println("map, getCalenderInfo date의 값 넘어와야 함 "+map);
		
		List<String> list = managerMemberService.getCalenderInfo(map);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list",list);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	
	//(관리자 확인용 프로필)
	   @RequestMapping(value="/managerMemberHistory", method=RequestMethod.GET)
	   public String managerMemberHistory(Model model,String id,@RequestParam(required = false, defaultValue = "1") String pg) {
	      model.addAttribute("id",id);
	      model.addAttribute("pg",pg);
	      return "/manager/managerMemberHistory";
	   }
	   //(관리자 확인용 프로필_판매완료)
	   @RequestMapping(value="/managerMemberSale", method=RequestMethod.GET)
	   public String managerMemberSale(Model model,String id,@RequestParam(required = false, defaultValue = "1") String pg) {
	      model.addAttribute("id",id);
	      model.addAttribute("pg",pg);
	      return "/manager/managerMemberSale";
	   }
	   //(관리자 확인용 프로필_판매후기)
	   @RequestMapping(value="/managerMemberReview", method=RequestMethod.GET)
	   public String managerMemberReview(Model model,String id,@RequestParam(required = false, defaultValue = "1") String pg) {
	      model.addAttribute("id",id);
	      model.addAttribute("pg",pg);
	      return "/manager/managerMemberReview";
	   }
	   //(관리자 확인용 프로필_구매완료)
	   @RequestMapping(value="/managerMemberBuy", method=RequestMethod.GET)
	   public String managerMemberBuy(Model model,String id,@RequestParam(required = false, defaultValue = "1") String pg) {
	      model.addAttribute("id",id);
	      model.addAttribute("pg",pg);
	      return "/manager/managerMemberBuy";
	   }
	   //(관리자 확인용 프로필_판매중)
	   @RequestMapping(value="/managerMemberDeal", method=RequestMethod.GET)
	   public String managerMemberDeal(Model model,String id,@RequestParam(required = false, defaultValue = "1") String pg) {
	      model.addAttribute("id",id);
	      model.addAttribute("pg",pg);
	      return "/manager/managerMemberDeal";
	   }
	
}
