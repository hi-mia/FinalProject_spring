package manager.service;

import java.util.List;
import java.util.Map;

import freeboard.bean.FreeboardCommentDTO;
import freeboard.bean.FreeboardCommentPaging;
import freeboard.bean.FreeboardDTO;
import freeboard.bean.FreeboardPaging;
import member.bean.MemberDTO;

public interface ManagerService {

	public List<MemberDTO> getManagerMember(String pg);

	public List<FreeboardDTO> getManagerFreeboardList(String pg);

	public FreeboardPaging managerfreeboardPaging(String pg);

	public FreeboardDTO getManagerFreeboardView(int board_seq);

	public List<FreeboardCommentDTO> getManagerFreeboardComment(Map<String, String> map);

	public FreeboardCommentPaging freeboardCommentPaging(Map<String, String> map);

	public FreeboardCommentDTO getManagerFreeboardCommentOne(String comment_seq);

	public FreeboardDTO getPage(int board_seq);

	public void managerFreeboardDelete(int board_seq);

	public void managerCommentDelete(FreeboardCommentDTO freeboardCommentDTO);


	
}
