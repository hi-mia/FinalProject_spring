package manager.dao;

import java.util.List;
import java.util.Map;

import freeboard.bean.FreeboardCommentDTO;
import freeboard.bean.FreeboardCommentPaging;
import freeboard.bean.FreeboardDTO;
import member.bean.MemberDTO;

public interface ManagerDAO {


	public List<MemberDTO> getManagerMember(Map<String, String> map);

<<<<<<< HEAD
	public void changeMemberState(Map<String, String[]> map);

	public void managerMemberForm(Map<String, String[]> map);

	public List<MemberDTO> getSearchMemberInfo(Map<String, String> map);

	public List<MemberDTO> getManagerMemberBlack(Map<String, String> map);
=======
	public List<FreeboardDTO> getManagerFreeboardList(Map<String, String> map);

	public int getTotalA();

	public FreeboardDTO getManagerFreeboardView(int board_seq);

	public List<FreeboardCommentDTO> getManagerFreeboardComment(Map<String, String> map);

	public FreeboardCommentDTO getManagerFreeboardCommentOne(String string);

	public int getCommentTotal2(int board_seq);

	public FreeboardDTO getPage(int board_seq);

	public void managerFreeboardDelete(int board_seq);

	public void managerCommentDelete(FreeboardCommentDTO freeboardCommentDTO);
>>>>>>> idleline12
}
