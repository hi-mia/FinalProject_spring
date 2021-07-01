package managerNotice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managerNotice.dao.ManagerNoticeDAO;
import notice.bean.NoticeDTO;
import notice.bean.NoticePaging;

@Service
public class ManagerNoticeServiceImpl implements ManagerNoticeService {
	@Autowired
	private ManagerNoticeDAO managerNoticeDAO;
	@Autowired
	private NoticePaging noticePaging;
	
	@Override
	public List<NoticeDTO> getManagerNoticeList(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticePaging noticePaging(String pg) {
		// TODO Auto-generated method stub
		return null;
	}

}
