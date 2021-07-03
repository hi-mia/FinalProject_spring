package managerSaleboard.service;

import java.util.List;
import java.util.Map;

import saleboard.bean.SaleboardDTO;
import saleboard.bean.SaleboardPaging;

public interface ManagerSaleboardService {

	public List<SaleboardDTO> getManagerSaleboardList(Map<String, String> map);

	public SaleboardPaging managerSaleboardPaging(Map<String, String> map);

	public List<SaleboardDTO> getManagerSaleboardSearchList(Map<String, String> map);

	public SaleboardPaging managerSaleboardSearchPaging(Map<String, String> map);

	public void managerSaleboardListDelete(String[] check);

	public void managerSaleboardDelete(int sale_seq);

	public SaleboardDTO getPage_sale(Map<String, String> map);

}
