package managerNotice.service;

import java.util.List;
import java.util.Map;

import notice.bean.NoticeDTO;
import notice.bean.NoticePaging;

public interface ManagerNoticeService {

	public List<NoticeDTO> getManagerNoticeList(Map<String, String> map);

	public NoticePaging noticePaging(String pg);

}
