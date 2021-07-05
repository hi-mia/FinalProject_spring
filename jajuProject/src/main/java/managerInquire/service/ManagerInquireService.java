package managerInquire.service;

import java.util.List;
import java.util.Map;

import inquire.bean.InquireDTO;
import inquire.bean.InquirePaging;

public interface ManagerInquireService {
	public List<InquireDTO> getManagerInquire(String pg);

	public void managerInquireDelete(String[] check);

	public InquirePaging managerinquirePaging(String pg);

	public List<InquireDTO> getInquireSearchList(Map<String, String> map);

	public InquirePaging managerinquirePaging(Map<String, String> map);

}
