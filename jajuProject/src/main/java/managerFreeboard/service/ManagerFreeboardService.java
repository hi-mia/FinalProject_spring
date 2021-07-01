package managerFreeboard.service;

import java.util.List;
import java.util.Map;

import freeboard.bean.FreeboardCommentDTO;
import freeboard.bean.FreeboardCommentPaging;
import freeboard.bean.FreeboardDTO;
import freeboard.bean.FreeboardPaging;

public interface ManagerFreeboardService {

	public List<FreeboardDTO> getManagerFreeboardList(String pg);

	public FreeboardPaging managerfreeboardPaging(String pg);

	public FreeboardDTO getManagerFreeboardView(int board_seq);

	public List<FreeboardCommentDTO> getManagerFreeboardComment(Map<String, String> map);

	public FreeboardCommentPaging freeboardCommentPaging(Map<String, String> map);

	public FreeboardCommentDTO getManagerFreeboardCommentOne(String comment_seq);

	public FreeboardDTO getPage(int board_seq);

	public List<FreeboardDTO> getManagerFreeboardSearchList(Map<String, String> map);

	public FreeboardPaging freeboardPaging(Map<String, String> map);

	public void managerFreeboardDelete(int board_seq);

	public void managerFreeboardListDelete(String[] check);

	public void managerCommentDelete(FreeboardCommentDTO freeboardCommentDTO);

}
