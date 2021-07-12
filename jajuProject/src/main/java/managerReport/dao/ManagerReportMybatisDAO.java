package managerReport.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import member.bean.MemberDTO;
import report.bean.CommentDTO;
import report.bean.ReportDTO;

@Transactional
@Repository
public class ManagerReportMybatisDAO implements ManagerReportDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ReportDTO> getManagerReportList(Map<String, String> map) {
		return sqlSession.selectList("managerReportSQL.getManagerReportList",map);
	}
	
	@Override
	public int getReportTotalA() {
		return sqlSession.selectOne("managerReportSQL.getReportTotalA");
	}
	
	@Override
	public ReportDTO getReport(String report_seq) {
		return sqlSession.selectOne("memberreportSQL.getReport", Integer.parseInt(report_seq));
	}
	
	@Override
	public void getShowList(String sale_seq) {
		sqlSession.update("memberreportSQL.getShowList", Integer.parseInt(sale_seq));
		
	}
	
	@Override
	public List<ReportDTO> getReportSearchList(Map<String, String> map) {
		List<ReportDTO> list =  sqlSession.selectList("managerReportSQL.getReportSearchList", map);
		return list;
	}

	@Override
	public int getTotalSearchA(Map<String, String> map) {
		return sqlSession.selectOne("managerReportSQL.getTotalSearchA", map);
	}
	
	@Override
	public void managerReportDelete(int[] check, int[]sale_check) {
		//sqlSession.update("managerReportSQL.managerReportDelete2", Integer.parseInt(sale_seq));
		
		sqlSession.delete("managerReportSQL.managerReportDelete", check);

		sqlSession.update("managerReportSQL.managerReportDelete2", sale_check);
	}

	@Override
	public void commentWriteShow(Map<String, String> map) {
		sqlSession.insert("managerReportSQL.commentWriteShow", map);
	}
	@Override
	public void commentWriteHide(Map<String, String> map) {
		sqlSession.insert("managerReportSQL.commentWriteHide", map);
	}
	
	@Override
	public List<CommentDTO> getCommentList(String report_seq) {
		return sqlSession.selectList("managerReportSQL.getCommentList", Integer.parseInt(report_seq));
	}
	
	@Override
	public CommentDTO getComment(String comment_seq) {
		return sqlSession.selectOne("managerReportSQL.getComment", Integer.parseInt(comment_seq));
	}
	
	@Override
	public void commentModify(CommentDTO commentDTO) {
		sqlSession.update("managerReportSQL.commentModify", commentDTO);
	}
	
	@Override
	public void commentDelete(Map<String, String> map) {
		sqlSession.delete("managerReportSQL.commentDelete", map);
	}

	@Override
	public ReportDTO getReportOne(String string) {
		return sqlSession.selectOne("managerReportSQL.getReportOne", string);
	}

}
