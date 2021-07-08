package main.dao;

import java.util.List;

import freeboard.bean.FreeboardDTO;
import saleboard.bean.SaleboardDTO;

public interface MainDAO {
	public List<SaleboardDTO> popularity();
	public List<SaleboardDTO> recommend(String category);
	public List<FreeboardDTO> board();
}
