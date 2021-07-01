package managerReport.service;

import java.util.List;
import java.util.Map;

import report.bean.ReportDTO;
import report.bean.ReportPaging;

public interface ManagerReportService {

	public List<ReportDTO> getManagerReportList(Map<String, String> map);

	public ReportPaging reportPaging(String pg);

}
