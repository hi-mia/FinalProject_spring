package managerInquire.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inquire.bean.InquireDTO;
import managerInquire.dao.ManagerInquireDAO;
@Service
public class ManagerInquireServiceImple implements ManagerInquireService {
	@Autowired
	private ManagerInquireDAO managerInquireDAO;	
	
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
}
