package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freeboard.bean.FreeboardDTO;
import main.dao.MainDAO;
import saleboard.bean.SaleboardDTO;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	private MainDAO mainDAO;

	@Override
	public List<SaleboardDTO> popularity() {
		return mainDAO.popularity();
	}

	@Override
	public List<SaleboardDTO> recommend(String category) {
		return mainDAO.recommend(category);
	}

	@Override
	public List<FreeboardDTO> board() {
		return mainDAO.board();
	}
}
