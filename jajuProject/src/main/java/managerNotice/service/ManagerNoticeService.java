package managerNotice.service;

import java.util.List;
import java.util.Map;

import notice.bean.NoticeDTO;
import notice.bean.NoticePaging;

public interface ManagerNoticeService {

	public void ManagerNoticeWrite(NoticeDTO noticeDTO);

	public List<NoticeDTO> getManagerNoticeList(Map<String, String> map);

	public NoticePaging noticePaging(String pg);

	public NoticeDTO getNotice(String notice_seq);
	
	public NoticeDTO getNoticePage(String notice_seq);
}
