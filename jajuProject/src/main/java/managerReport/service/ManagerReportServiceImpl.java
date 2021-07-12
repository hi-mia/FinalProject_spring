package managerReport.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managerReport.dao.ManagerReportDAO;
import member.bean.MemberDTO;
import report.bean.CommentDTO;
import report.bean.ReportDTO;
import report.bean.ReportPaging;

@Service
public class ManagerReportServiceImpl implements ManagerReportService {
	@Autowired
	private ManagerReportDAO managerReportDAO;
	@Autowired
	private ReportPaging reportPaging;
	
	@Override
	public List<ReportDTO> getManagerReportList(Map<String, String> map) {
		
		int endNum = Integer.parseInt(map.get("pg"))*10;
		int startNum = endNum-9;

		map.put("startNum",startNum+"");
		map.put("endNum",endNum+"");
		
		return managerReportDAO.getManagerReportList(map);
	}

	@Override
	public ReportPaging reportPaging(String pg) {
		int totalA = managerReportDAO.getReportTotalA(); //총글수
		
		reportPaging.setCurrentPage(Integer.parseInt(pg));//현재 페이지
		reportPaging.setPageBlock(5);
		reportPaging.setPageSize(10);
		reportPaging.setTotalA(totalA);
		reportPaging.makePagingHTML();
		
		return reportPaging;
	}

	@Override
	public ReportDTO getReport(String report_seq) {
		return managerReportDAO.getReport(report_seq);
	}
	
	@Override
	public void getShowList(String sale_seq) {
		managerReportDAO.getShowList(sale_seq);
		
	}
	
	@Override
	public List<ReportDTO> getReportSearchList(Map<String, String> map) {
		int endNum = Integer.parseInt(map.get("pg"))*10;
		int startNum = endNum-9;
		
		//pg, searchOption, keyword, startNum, endNum
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		
		return managerReportDAO.getReportSearchList(map);
	}

	@Override
	public ReportPaging reportPaging(Map<String, String> map) {
		int totalA = managerReportDAO.getTotalSearchA(map); //검색한 총글수
		
		reportPaging.setCurrentPage(Integer.parseInt(map.get("pg")));//현재 페이지
		reportPaging.setPageBlock(5);
		reportPaging.setPageSize(10);
		reportPaging.setTotalA(totalA);
		reportPaging.makePagingHTML();
		
		return reportPaging;
	}

	@Override
	public void managerReportDelete(int[] check, int[] sale_check) {
		
		managerReportDAO.managerReportDelete(check, sale_check);
		
	}
	
	@Override
	public void commentWriteShow(Map<String, String> map) {
		managerReportDAO.commentWriteShow(map);
		
	}
	@Override
	public void commentWriteHide(Map<String, String> map) {
		managerReportDAO.commentWriteHide(map);
		
	}

	@Override
	public List<CommentDTO> getCommentList(String report_seq) {
		return managerReportDAO.getCommentList(report_seq);
	}

	@Override
	public CommentDTO getComment(String comment_seq) {
		return managerReportDAO.getComment(comment_seq);
	}

	@Override
	public void commentModify(CommentDTO commentDTO) {
		managerReportDAO.commentModify(commentDTO);
		
	}

	@Override
	public void commentDelete(Map<String, String> map) {
		managerReportDAO.commentDelete(map);
		
	}

	@Override
	public ReportDTO getReportOne(String string) {
		return managerReportDAO.getReportOne(string);
	}

}
