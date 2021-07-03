package managerSaleboard.dao;

import java.util.List;
import java.util.Map;

import saleboard.bean.SaleboardDTO;

public interface ManagerSaleboardDAO {

	public List<SaleboardDTO> getManagerSaleboardList(Map<String, String> map);

	public int getTotalA(Map<String, String> map);

	public List<SaleboardDTO> getManagerSaleboardSearchList(Map<String, String> map);

	public int getTotalASearch(Map<String, String> map);

	public void managerSaleboardListDelete(String[] check);

	public void managerSaleboardDelete(int sale_seq);

	public SaleboardDTO getPage_sale(Map<String, String> map);

}
