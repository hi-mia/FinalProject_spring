package managerSaleboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freeboard.bean.FreeboardPaging;
import managerSaleboard.dao.ManagerSaleboardDAO;
import saleboard.bean.SaleboardDTO;
import saleboard.bean.SaleboardPaging;

@Service
public class ManagerSaleboardServiceImpl implements ManagerSaleboardService {
	@Autowired
	private ManagerSaleboardDAO managerSaleboardDAO;
	
	@Autowired
	private SaleboardPaging saleboardPaging;
	
	
	@Override
	public List<SaleboardDTO> getManagerSaleboardList(Map<String, String> map) {
		
		int pg = Integer.parseInt(map.get("pg"));
		//1페이지당 10개씩
		int endNum = pg*10;
		int startNum = endNum-9;
				
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		return managerSaleboardDAO.getManagerSaleboardList(map);
	}


	@Override
	public SaleboardPaging managerSaleboardPaging(Map<String, String> map) {
		
		int totalA = managerSaleboardDAO.getTotalA(map);
		
		int pg = Integer.parseInt(map.get("pg"));
		
		saleboardPaging.setCurrentPage(pg);
		saleboardPaging.setPageBlock(5);
		saleboardPaging.setPageSize(10);
		saleboardPaging.setTotalA(totalA);
		saleboardPaging.makePagingHTML();
		
		return saleboardPaging;
	}


	@Override
	public List<SaleboardDTO> getManagerSaleboardSearchList(Map<String, String> map) {
		int pg = Integer.parseInt(map.get("pg"));
		//1페이지당 10개씩
		int endNum = pg*10;
		int startNum = endNum-9;
				
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		return managerSaleboardDAO.getManagerSaleboardSearchList(map);
	}


	@Override
	public SaleboardPaging managerSaleboardSearchPaging(Map<String, String> map) {
		int totalA = managerSaleboardDAO.getTotalASearch(map);
		
		int pg = Integer.parseInt(map.get("pg"));
		
		saleboardPaging.setCurrentPage(pg);
		saleboardPaging.setPageBlock(5);
		saleboardPaging.setPageSize(10);
		saleboardPaging.setTotalA(totalA);
		saleboardPaging.makePagingHTML();
		
		return saleboardPaging;
	}


	@Override
	public void managerSaleboardListDelete(String[] check) {
		managerSaleboardDAO.managerSaleboardListDelete(check);
	}


	@Override
	public void managerSaleboardDelete(int sale_seq) {
		managerSaleboardDAO.managerSaleboardDelete(sale_seq);
	}


	@Override
	public SaleboardDTO getPage_sale(Map<String, String> map) {
		return managerSaleboardDAO.getPage_sale(map);
	}

}
