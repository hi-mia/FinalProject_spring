package managerReport.dao;

import java.util.List;
import java.util.Map;

import report.bean.ReportDTO;

public interface ManagerReportDAO {
	
	public List<ReportDTO> getManagerReportList(Map<String, String> map);

	public int getReportTotalA();
}
