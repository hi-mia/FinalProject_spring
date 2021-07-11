package managerNotice.dao;

import java.util.List;
import java.util.Map;

import notice.bean.NoticeDTO;

public interface ManagerNoticeDAO {

	public void managerNoticeWrite(NoticeDTO noticeDTO);
	
	public List<NoticeDTO> getManagerNoticeList(Map<String, String> map);

	public int getNoticeTotalA();

	public NoticeDTO getNotice(String notice_seq);

	public NoticeDTO getNoticePage(String notice_seq);

	public void managerNoticeDelete(Map<String, String[]> map);
	
	public List<NoticeDTO> getNoticeSearchList(Map<String, String> map);

	public int getTotalSearchA(Map<String, String> map);

	public void managerNoticeModify(NoticeDTO noticeDTO);

}
