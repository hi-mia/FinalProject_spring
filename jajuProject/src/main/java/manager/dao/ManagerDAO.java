package manager.dao;

import java.util.List;
import java.util.Map;

import freeboard.bean.FreeboardCommentDTO;
import freeboard.bean.FreeboardCommentPaging;
import freeboard.bean.FreeboardDTO;
import inquire.bean.InquireDTO;
import member.bean.MemberDTO;
import reviewboard.bean.ReviewboardDTO;

public interface ManagerDAO {


	public List<MemberDTO> getManagerMember(Map<String, String> map);
	
	public void changeMemberState(Map<String, String[]> map);

	public void managerMemberForm(Map<String, String[]> map);

	public List<MemberDTO> getSearchMemberInfo(Map<String, String> map);

	public List<MemberDTO> getManagerMemberBlack(Map<String, String> map);

	public List<FreeboardDTO> getManagerFreeboardList(Map<String, String> map);

	public int getTotalA();

	public FreeboardDTO getManagerFreeboardView(int board_seq);

	public List<FreeboardCommentDTO> getManagerFreeboardComment(Map<String, String> map);

	public FreeboardCommentDTO getManagerFreeboardCommentOne(String string);

	public int getCommentTotal2(int board_seq);

	public FreeboardDTO getPage(int board_seq);

	public void managerFreeboardDelete(int board_seq);

	public void managerCommentDelete(FreeboardCommentDTO freeboardCommentDTO);

	public int getSearchTotal(Map<String, String> map);

	public List<FreeboardDTO> getManagerFreeboardSearchList(Map<String, String> map);

	public void managerFreeboardListDelete(Map<String, String[]> map);


	//페이징처리, 토탈 int 가져오기
	public int getMemberTotalA();
	//검색 페이징 처리. 
	public int getSearchTotalA(Map<String, String> map);

	public List<InquireDTO> getManagerInquire(Map<String, String> map);

	

}
