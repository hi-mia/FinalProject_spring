package manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freeboard.bean.FreeboardDTO;
import freeboard.bean.FreeboardPaging;
import manager.dao.ManagerDAO;
import member.bean.MemberDTO;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private ManagerDAO managerDAO;
	
	@Autowired
	private FreeboardPaging freeboardPaging;

	@Override
	public List<MemberDTO> getManagerMember(String pg) {
		//1페이지당 10개씩
		int endNum = Integer.parseInt(pg)*10;
		int startNum = endNum-9;
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("startNum",startNum+"");
		map.put("endNum",endNum+"");
		
		return managerDAO.getManagerMember(map);
	}

	@Override
	public List<FreeboardDTO> getManagerFreeboardList(String pg) {
		//1페이지당 10개씩
		int endNum = Integer.parseInt(pg)*10;
		int startNum = endNum-9;
				
		Map<String, String> map = new HashMap<String, String>();
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		return managerDAO.getManagerFreeboardList(map);
	}

	@Override
	public FreeboardPaging managerfreeboardPaging(String pg) {
		int totalA = managerDAO.getTotalA();
		
		freeboardPaging.setCurrentPage(Integer.parseInt(pg));
		freeboardPaging.setPageBlock(5);
		freeboardPaging.setPageSize(10);
		freeboardPaging.setTotalA(totalA);
		freeboardPaging.makePagingHTML();
		
		return freeboardPaging;
	}
}
