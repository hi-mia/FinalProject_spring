package notice.dao;

import java.util.List;
import java.util.Map;

import notice.bean.NoticeDTO;

public interface NoticeDAO {
	
	public List<NoticeDTO> getNoticeList(Map<String, String> map);

	public int getTotalA();

	public NoticeDTO getNotice(String notice_seq);

	public List<NoticeDTO> getNoticeSearchList(Map<String, String> map);

	public int getTotalSearchA(Map<String, String> map);

	public NoticeDTO getNoticePage(String notice_seq);

}
