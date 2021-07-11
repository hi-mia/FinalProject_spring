package managerNotice.service;

import java.util.List;
import java.util.Map;

import notice.bean.NoticeDTO;
import notice.bean.NoticePaging;

public interface ManagerNoticeService {

	public void managerNoticeWrite(NoticeDTO noticeDTO);

	public List<NoticeDTO> getManagerNoticeList(Map<String, String> map);

	public NoticePaging noticePaging(String pg);

	public NoticeDTO getNotice(String notice_seq);
	
	public NoticeDTO getNoticePage(String notice_seq);
	
	public void managerNoticeDelete(String[] check);
	
	public List<NoticeDTO> getNoticeSearchList(Map<String, String> map);

	public NoticePaging noticePaging(Map<String, String> map);

	public void managerNoticeModify(NoticeDTO noticeDTO);
	
}
