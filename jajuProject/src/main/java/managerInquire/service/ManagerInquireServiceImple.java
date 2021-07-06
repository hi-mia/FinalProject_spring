package managerInquire.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inquire.bean.InquireDTO;
import inquire.bean.InquirePaging;
import managerInquire.dao.ManagerInquireDAO;
@Service
public class ManagerInquireServiceImple implements ManagerInquireService {
	@Autowired
	private ManagerInquireDAO managerInquireDAO;
	@Autowired
	private InquirePaging inquirePaging;
	
	@Override
	public List<InquireDTO> getManagerInquire(String pg) {
		//1페이지당 10개씩
		int endNum = Integer.parseInt(pg)*10;
		int startNum = endNum-9;
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("startNum",startNum+"");
		map.put("endNum",endNum+"");
		
		return managerInquireDAO.getManagerInquire(map);
	}

	@Override
	public void managerInquireDelete(String[] check) {
		Map<String, String[]>map = new HashedMap<String, String[]>();
		map.put("array", check);
		
		managerInquireDAO.managerInquireDelete(map);
		
	}

	@Override
	public InquirePaging managerinquirePaging(String pg) {
		
		int totalA = managerInquireDAO.getTotalA();
		inquirePaging.setCurrentPage(Integer.parseInt(pg));
		inquirePaging.setPageBlock(5);
		inquirePaging.setPageSize(10);
		inquirePaging.setTotalA(totalA);
		inquirePaging.makePagingHTML();		
				
		return inquirePaging;
	}

	@Override
	public List<InquireDTO> getInquireSearchList(Map<String, String> map) {
		int endNum = Integer.parseInt(map.get("pg"))*10;
		int startNum = endNum-9;
		
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		return managerInquireDAO.getInquireSearchList(map);
	}

	@Override
	public InquirePaging managerinquirePaging(Map<String, String> map) {
		int totalA = managerInquireDAO.getTotalSearchA(map);
		
		inquirePaging.setCurrentPage(Integer.parseInt(map.get("pg")));
		inquirePaging.setPageBlock(5);
		inquirePaging.setPageSize(10);
		inquirePaging.setTotalA(totalA);
		inquirePaging.makePagingHTML();	
		
		return inquirePaging;
	}
}
