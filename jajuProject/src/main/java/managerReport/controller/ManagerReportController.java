package managerReport.controller;

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

import managerReport.service.ManagerReportService;
import member.bean.MemberDTO;
import report.bean.CommentDTO;
import report.bean.ReportDTO;
import report.bean.ReportPaging;

@Controller
@RequestMapping(value = "/manager")
public class ManagerReportController {
	@Autowired
	private ManagerReportService managerReportService;
	
	@RequestMapping(value = "managerReportList", method = RequestMethod.GET)
	public ModelAndView managerReportList(@RequestParam(required = false, defaultValue = "1") String pg) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.setViewName("/manager/managerReportList");
		return mav;
	}
	
	@RequestMapping(value="/getManagerReportList",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerReportList(@RequestParam Map<String, String> map,
											 @RequestParam(required=false, defaultValue="1") String pg) {
		
		List<ReportDTO> list = managerReportService.getManagerReportList(map);
		
		ReportPaging reportPaging = managerReportService.reportPaging(pg);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("reportPaging", reportPaging);
		mav.setViewName("jsonView");
		return mav;
		
	}
	
	@RequestMapping(value="/managerReportView", method=RequestMethod.GET)
	public ModelAndView managerReportView(@RequestParam String report_seq,
										  @RequestParam String pg) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("report_seq", report_seq);
		mav.addObject("pg", pg);
		mav.setViewName("/manager/managerReportView");
		return mav;
	}
	
	@RequestMapping(value="/getReport", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getReport(@RequestParam String report_seq) {

		ReportDTO reportDTO = managerReportService.getReport(report_seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("reportDTO", reportDTO);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/getShowList", method=RequestMethod.POST)
	@ResponseBody
	public void getShowList(@RequestParam String sale_seq) {
		
		managerReportService.getShowList(sale_seq);
	}
	
	@RequestMapping(value="/getReportSearchList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getReportSearchList(@RequestParam Map<String, String> map) {
		
		List<ReportDTO> list = managerReportService.getReportSearchList(map);
		
		//페이징 처리
		ReportPaging reportPaging = managerReportService.reportPaging(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", map.get("pg"));
		mav.addObject("list", list);
		mav.addObject("reportPaging", reportPaging);
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	@RequestMapping(value="/managerReportDelete", method=RequestMethod.POST)
	public ModelAndView managerReportDelete(@RequestParam int[] check) {
		
		int[] sale_check = new int[check.length];
		
		for(int i=0; i<check.length; i++) {
			ReportDTO reportDTO = managerReportService.getReportOne(check[i]+"");
			sale_check[i] = reportDTO.getSale_seq();
		}
		
		managerReportService.managerReportDelete(check, sale_check);
		
		return new ModelAndView("redirect:/manager/managerReportList");
	}

	
	
	//댓글 시작
	
	@RequestMapping(value="/commentWriteShow", method=RequestMethod.POST)
	@ResponseBody
	public void commentWriteShow(@RequestParam Map<String, String> map) {
		
		managerReportService.commentWriteShow(map);
	}
	@RequestMapping(value="/commentWriteHide", method=RequestMethod.POST)
	@ResponseBody
	public void commentWriteHide(@RequestParam Map<String, String> map) {
		//System.out.println(map);
		managerReportService.commentWriteHide(map);
	}
	
	
	@RequestMapping(value="/getCommentList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getCommentList(@RequestParam String report_seq) {
		
		List<CommentDTO> list = managerReportService.getCommentList(report_seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/getComment", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getComment(@RequestParam String comment_seq) {

		CommentDTO commentDTO = managerReportService.getComment(comment_seq);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("report_seq", report_seq);
		//mav.addObject("comment_seq", comment_seq);
		mav.addObject("commentDTO", commentDTO);
		//System.out.println(commentDTO);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/commentModify", method=RequestMethod.POST)
	@ResponseBody
	public void commentModify(@ModelAttribute CommentDTO commentDTO) {
		//System.out.println(commentDTO);
		managerReportService.commentModify(commentDTO);
	}
	
	@RequestMapping(value="/commentDelete", method=RequestMethod.POST)
	@ResponseBody
	public void commentDelete(@RequestParam Map<String, String> map) {
		
		managerReportService.commentDelete(map);
		
	}
}
