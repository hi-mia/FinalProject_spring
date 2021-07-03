package managerSaleboard.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import managerSaleboard.service.ManagerSaleboardService;
import saleboard.bean.SaleboardDTO;
import saleboard.bean.SaleboardPaging;

@Controller
@RequestMapping(value = "/managerSaleboard")
public class ManagerSaleboardController {
	@Autowired
	private SqlSession session;
	@Autowired
	private ManagerSaleboardService managerSaleboardService;
	
	@RequestMapping(value = "managerSaleboardList", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/managerSaleboardList");
		return mav;
	}
	
	@RequestMapping(value="/getManagerSaleboardList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerSaleboardList(@RequestParam Map<String, String> map) {
		
		//1페이지당 
		List<SaleboardDTO> list = managerSaleboardService.getManagerSaleboardList(map);
	
		//페이징 처리
		SaleboardPaging saleboardPaging = managerSaleboardService.managerSaleboardPaging(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", map.get("pg"));
		mav.addObject("list", list);
		mav.addObject("saleboardPaging", saleboardPaging);
		
		mav.setViewName("jsonView");
		return mav;
		
	}
	
	@RequestMapping(value="/getManagerSaleboardSearchList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerSaleboardSearchList(@RequestParam Map<String, String> map) {
		
		//1페이지당 
		List<SaleboardDTO> list = managerSaleboardService.getManagerSaleboardSearchList(map);
	
		//페이징 처리
		SaleboardPaging saleboardPaging = managerSaleboardService.managerSaleboardSearchPaging(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", map.get("pg"));
		mav.addObject("list", list);
		mav.addObject("saleboardPaging", saleboardPaging);
		
		mav.setViewName("jsonView");
		return mav;
		
	}
	
	@RequestMapping(value="managerSaleboardListDelete", method=RequestMethod.POST)
	@ResponseBody
	public void managerSaleboardListDelete(String[] check) {

		//System.out.println(check);
		managerSaleboardService.managerSaleboardListDelete(check);
		
	}
	
	@RequestMapping(value = "managerSaleboardView", method = RequestMethod.GET)
	   public ModelAndView managerSaleboardView() {
	      ModelAndView mav = new ModelAndView();
	      mav.setViewName("/manager/managerSaleboardView");
	      return mav;
	   }
	
	
	//삭제- 게시물
		@RequestMapping(value="managerSaleboardDelete", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView managerSaleboardDelete(@RequestParam int sale_seq) {

			managerSaleboardService.managerSaleboardDelete(sale_seq);
			
			return new ModelAndView("redirect:/manager/managerSaleboardList");
		}
		
		//이전글 다음글
		@RequestMapping(value="getPage_sale", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getPage_sale(@RequestParam Map<String, String> map) {
			
			SaleboardDTO saleboardDTO = managerSaleboardService.getPage_sale(map);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("saleboardDTO", saleboardDTO);
			mav.setViewName("jsonView");
			return mav;
		}



}
