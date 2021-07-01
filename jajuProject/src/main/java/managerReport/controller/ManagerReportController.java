package managerReport.controller;

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

import managerNotice.service.ManagerNoticeService;
import managerReport.service.ManagerReportService;
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
							 @RequestParam String pg,
							 HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("report_seq", report_seq);
		mav.addObject("pg", pg);
		mav.setViewName("/manager/managerReportView");
		return mav;
	}
}
