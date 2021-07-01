package managerReport.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
