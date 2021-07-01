package managerNotice.dao;

import java.util.List;
import java.util.Map;

import notice.bean.NoticeDTO;

public interface ManagerNoticeDAO {

	public void ManagerNoticeWrite(NoticeDTO noticeDTO);
	
	public List<NoticeDTO> getManagerNoticeList(Map<String, String> map);

	public int getNoticeTotalA();

	public NoticeDTO getNotice(String notice_seq);

	public NoticeDTO getNoticePage(String notice_seq);

}
