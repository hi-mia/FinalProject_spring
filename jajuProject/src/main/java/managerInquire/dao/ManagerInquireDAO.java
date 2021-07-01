package managerInquire.dao;

import java.util.List;
import java.util.Map;

import inquire.bean.InquireDTO;

public interface ManagerInquireDAO {

	public List<InquireDTO> getManagerInquire(Map<String, String> map);

}
