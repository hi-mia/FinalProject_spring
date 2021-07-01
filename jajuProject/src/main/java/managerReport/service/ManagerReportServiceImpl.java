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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReportPaging reportPaging(String pg) {
		// TODO Auto-generated method stub
		return null;
	}

}
