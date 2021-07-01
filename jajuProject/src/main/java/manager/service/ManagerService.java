package manager.service;

import java.util.List;
import java.util.Map;

import freeboard.bean.FreeboardCommentDTO;
import freeboard.bean.FreeboardCommentPaging;
import freeboard.bean.FreeboardDTO;
import freeboard.bean.FreeboardPaging;
import manager.bean.ManagerPaging;
import inquire.bean.InquireDTO;
import member.bean.MemberDTO;
import reviewboard.bean.ReviewboardDTO;
import reviewboard.bean.ReviewboardPaging;

public interface ManagerService {

	public List<MemberDTO> getManagerMember(Map<String, String> map);
	
	public void deleteMemberId(String[] check);
	
	public void changeMemberState(String[] check);

	public List<MemberDTO> getSearchMemberInfo(Map<String, String> map);

	public List<MemberDTO> getManagerMemberBlack(Map<String, String> map);
	//전체회원 리스트 페이징 처리하기
	public ManagerPaging managerPaging(Map<String, String> map);
	//검색 후 페이징 처리하기
	public ManagerPaging managerSearchPaging(Map<String, String> map);

	public List<FreeboardDTO> getManagerFreeboardList(String pg);

	public FreeboardPaging managerfreeboardPaging(String pg);

	public FreeboardDTO getManagerFreeboardView(int board_seq);

	public List<FreeboardCommentDTO> getManagerFreeboardComment(Map<String, String> map);

	public FreeboardCommentPaging freeboardCommentPaging(Map<String, String> map);

	public FreeboardCommentDTO getManagerFreeboardCommentOne(String comment_seq);

	public FreeboardDTO getPage(int board_seq);

	public void managerFreeboardDelete(int board_seq);

	public void managerCommentDelete(FreeboardCommentDTO freeboardCommentDTO);

	public FreeboardPaging freeboardPaging(Map<String, String> map);

	public List<FreeboardDTO> getManagerFreeboardSearchList(Map<String, String> map);

	public void managerFreeboardListDelete(String[] check);

	public List<InquireDTO> getManagerInquire(String pg);

}
