package managerMember.dao;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import managerMember.bean.ManagerMainDTO;
import member.bean.MemberDTO;

@Transactional
@Repository
public class ManagerMemberDAOMybatis implements ManagerMemberDAO {

	@Autowired
	private SqlSession sqlSession;

	// sortinSelect 한 값에 따라 해당 조건에 맞는 list 가져오기.
	@Override
	public List<MemberDTO> getManagerMember(Map<String, String> map) {
		return sqlSession.selectList("managerMemberSQL.getManagerMember", map);
	}
	
	// 활동중지 상태 0-> 1로 변경
	@Override
	public void changeMemberState(Map<String, String[]> map) {
		sqlSession.update("managerMemberSQL.changeMemberState", map);
	}
	
	// 활동중지 해제  1->0로 변경
	@Override
	public void changeBlackMemberStateRollback(Map<String, String[]> map) {
		sqlSession.update("managerMemberSQL.changeBlackMemberStateRollback", map);		
	}
	
	// 강제탈퇴기능
	@Override
	public void managerMemberForm(Map<String, String[]> map) {
		sqlSession.update("managerMemberSQL.managerMemberForm", map);
	}

	// 검색리스트
	@Override
	public List<MemberDTO> getSearchMemberInfo(Map<String, String> map) {
		return sqlSession.selectList("managerMemberSQL.getSearchMemberInfo", map);
	}

	// 블랙리스트
	@Override
	public List<MemberDTO> getManagerMemberBlack(Map<String, String> map) {
		return sqlSession.selectList("managerMemberSQL.getManagerMemberBlack", map);
	}

	@Override
	public int getMemberTotalA() {
		return sqlSession.selectOne("managerMemberSQL.getMemberTotalA");
	}
	
	@Override
	public int getSearchTotalA(Map<String, String> map) {
		return sqlSession.selectOne("managerMemberSQL.getSearchTotalA", map);
	}
	
	@Override
	public int getMemberBlackTotalA(Map<String, String> map) {
		return sqlSession.selectOne("managerMemberSQL.getMemberBlackTotalA",map);
	}
	
	@Override
	public List<ManagerMainDTO> getMemberCategory() {
		return sqlSession.selectList("managerMemberSQL.getMemberCategory");
	}

	@Override
	public ManagerMainDTO getSaleAvg() {
		return sqlSession.selectOne("managerMemberSQL.getSaleAvg");
	}

	@Override
	public List<ManagerMainDTO> getLocationInfo() {
		return sqlSession.selectList("managerMemberSQL.getLocationInfo");
	}
	@Override
	public int getBlackSearchTotalA(Map<String, String> map) {
		return sqlSession.selectOne("managerMemberSQL.getBlackSearchTotalA", map);
	}

	@Override
	public List<MemberDTO> getSearchManagerMemberBlack(Map<String, String> map) {
		return sqlSession.selectList("managerMemberSQL.getSearchManagerMemberBlack", map);
	}
	/*==== MAINCHART COUNT(*) NUM FROM DB ====*/
	@Override
	public int getManagerInquireCount() {
		return sqlSession.selectOne("managerMemberSQL.getManagerInquireCount");
	}

	@Override
	public int getManagerReportCount() {
		return  sqlSession.selectOne("managerMemberSQL.getManagerReportCount");
	}

	@Override
	public int getManagerMemberCount() {
		return sqlSession.selectOne("managerMemberSQL.getManagerMemberCount");
	}

	@Override
	public int getManagerSaleReportCount() {
		return sqlSession.selectOne("managerMemberSQL.getManagerSaleReportCount");
	}
	//==== 어제날짜(Prev) COUNT ====
	@Override
	public int getPrevInquireCount() {
		return sqlSession.selectOne("managerMemberSQL.getPrevInquireCount");
	}

	@Override
	public int getPrevReportCount() {
		return sqlSession.selectOne("managerMemberSQL.getPrevReportCount");
	}

	@Override
	public int getPrevMemberCount() {
		return sqlSession.selectOne("managerMemberSQL.getPrevMemberCount");
	}

	@Override
	public int getPrevSaleReportCount() {
		return sqlSession.selectOne("managerMemberSQL.getPrevSaleReportCount");
	}
	//datePicker 달력 선택 날짜 
	@Override
	public int getInquirePickerCount(Map<String, String> map) {
		return sqlSession.selectOne("managerMemberSQL.getInquirePickerCount",map);
	}

	@Override
	public int getReportPickerCount(Map<String, String> map) {
		return sqlSession.selectOne("managerMemberSQL.getReportPickerCount",map);
	}

	@Override
	public int getNewMemberPickerCount(Map<String, String> map) {
		return sqlSession.selectOne("managerMemberSQL.getNewMemberPickerCount",map);
	}

	@Override
	public int getSaleReportPickerCount(Map<String, String> map) {
		return sqlSession.selectOne("managerMemberSQL.getSaleReportPickerCount",map);
	}
	//큰 달력 선택 날 하루 
	@Override
	public List<String> getCalenderInfo(Map<String, String> map) {
		return sqlSession.selectList("managerMemberSQL.getCalenderInfo",map);
	}

	



}
