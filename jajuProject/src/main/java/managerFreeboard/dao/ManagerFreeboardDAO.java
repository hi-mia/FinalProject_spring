package managerFreeboard.dao;

import java.util.List;
import java.util.Map;

import freeboard.bean.FreeboardCommentDTO;
import freeboard.bean.FreeboardDTO;

public interface ManagerFreeboardDAO {

	public List<FreeboardDTO> getManagerFreeboardList(Map<String, String> map);

	public int getTotalA();

	public FreeboardDTO getManagerFreeboardView(int board_seq);

	public List<FreeboardCommentDTO> getManagerFreeboardComment(Map<String, String> map);

	public int getCommentTotal2(int board_seq);

	public FreeboardCommentDTO getManagerFreeboardCommentOne(String comment_seq);

	public FreeboardDTO getPage(int board_seq);

	public List<FreeboardDTO> getManagerFreeboardSearchList(Map<String, String> map);

	public int getSearchTotal(Map<String, String> map);

	public void managerFreeboardDelete(int board_seq);

	public void managerFreeboardListDelete(Map<String, String[]> map);

	public void managerCommentDelete(FreeboardCommentDTO freeboardCommentDTO);

}
