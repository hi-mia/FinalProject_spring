package managerNotice.service;

import java.util.List;
import java.util.Map;

import notice.bean.NoticeDTO;
import notice.bean.NoticePaging;

public interface ManagerNoticeService {

	List<NoticeDTO> getManagerNoticeList(Map<String, String> map);

	NoticePaging noticePaging(String pg);

}
