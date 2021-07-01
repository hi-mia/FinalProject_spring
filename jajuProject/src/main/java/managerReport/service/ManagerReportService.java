package managerReport.service;

import java.util.List;
import java.util.Map;

import report.bean.ReportDTO;
import report.bean.ReportPaging;

public interface ManagerReportService {

	List<ReportDTO> getManagerReportList(Map<String, String> map);

	ReportPaging reportPaging(String pg);

}
