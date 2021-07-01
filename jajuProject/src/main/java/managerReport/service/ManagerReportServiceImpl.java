package managerReport.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managerReport.dao.ManagerReportDAO;
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

}
