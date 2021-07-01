package manager.service;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import notice.bean.NoticePaging;
import report.bean.ReportDTO;
import report.bean.ReportPaging;

public interface ManagerService {

	public List<MemberDTO> getManagerMember(Map<String, String> map);
	
	public void deleteMemberId(String[] check);
	
	public void changeMemberState(String[] check);

	public List<MemberDTO> getSearchMemberInfo(Map<String, String> map);

	public List<MemberDTO> getManagerMemberBlack(Map<String, String> map);

	public List<ReportDTO> getManagerNoticeList(Map<String, String> map);
	
	public NoticePaging noticePaging(String pg);
	
	public List<ReportDTO> getManagerReportList(Map<String, String> map);

	public ReportPaging reportPaging(String pg);

	public ReportDTO getManagerReport(String report_seq);

}
