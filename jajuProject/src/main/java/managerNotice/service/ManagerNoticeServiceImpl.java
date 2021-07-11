package managerNotice.service;

import java.util.HashMap;
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
	public void managerNoticeWrite(NoticeDTO noticeDTO) {
		//System.out.println(reportDTO);
		managerNoticeDAO.managerNoticeWrite(noticeDTO);
		
	}
	
	@Override
	public List<NoticeDTO> getManagerNoticeList(Map<String, String> map) {
		
		int endNum = Integer.parseInt(map.get("pg"))*10;
		int startNum = endNum-9;

		map.put("startNum",startNum+"");
		map.put("endNum",endNum+"");
		
		return managerNoticeDAO.getManagerNoticeList(map);
	}
	
	@Override
	public NoticePaging noticePaging(String pg) {
		int totalA = managerNoticeDAO.getNoticeTotalA(); //총글수
		
		noticePaging.setCurrentPage(Integer.parseInt(pg));//현재 페이지
		noticePaging.setPageBlock(5);
		noticePaging.setPageSize(10);
		noticePaging.setTotalA(totalA);
		noticePaging.makePagingHTML();
		
		return noticePaging;
	}

	@Override
	public NoticeDTO getNotice(String notice_seq) {
		return managerNoticeDAO.getNotice(notice_seq);
	}

	@Override
	public NoticeDTO getNoticePage(String notice_seq) {
		return managerNoticeDAO.getNoticePage(notice_seq);
	}

	@Override
	public void managerNoticeDelete(String[] check) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("array", check);
		
		managerNoticeDAO.managerNoticeDelete(map);
		
	}
	
	@Override
	public List<NoticeDTO> getNoticeSearchList(Map<String, String> map) {
		
		int endNum = Integer.parseInt(map.get("pg"))*10;
		int startNum = endNum-9;
		
		//pg, searchOption, keyword, startNum, endNum
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		
		return managerNoticeDAO.getNoticeSearchList(map);
	}

	@Override
	public NoticePaging noticePaging(Map<String, String> map) {
		int totalA = managerNoticeDAO.getTotalSearchA(map); //검색한 총글수
		
		noticePaging.setCurrentPage(Integer.parseInt(map.get("pg")));//현재 페이지
		noticePaging.setPageBlock(5);
		noticePaging.setPageSize(10);
		noticePaging.setTotalA(totalA);
		noticePaging.makePagingHTML();
		
		return noticePaging;
	}

	@Override
	public void managerNoticeModify(NoticeDTO noticeDTO) {
		managerNoticeDAO.managerNoticeModify(noticeDTO);
		
	}

	
}
