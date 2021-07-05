package managerInquire.dao;

import java.util.List;
import java.util.Map;

import inquire.bean.InquireDTO;

public interface ManagerInquireDAO {

	public List<InquireDTO> getManagerInquire(Map<String, String> map);

	public void managerInquireDelete(Map<String, String[]> map);

	public int getTotalA();

	public List<InquireDTO> getInquireSearchList(Map<String, String> map);

	public int getTotalSearchA(Map<String, String> map);

	

}
