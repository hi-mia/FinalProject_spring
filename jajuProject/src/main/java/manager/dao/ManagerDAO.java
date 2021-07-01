package manager.dao;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import report.bean.ReportDTO;

public interface ManagerDAO {


	public List<MemberDTO> getManagerMember(Map<String, String> map);

	public void changeMemberState(Map<String, String[]> map);

	public void managerMemberForm(Map<String, String[]> map);

	public List<MemberDTO> getSearchMemberInfo(Map<String, String> map);

	public List<MemberDTO> getManagerMemberBlack(Map<String, String> map);

	public List<ReportDTO> getManagerNoticeList(Map<String, String> map);
	
	public int getNoticeTotalA();
	
	public List<ReportDTO> getManagerReportList(Map<String, String> map);

	public int getReportTotalA();

}
