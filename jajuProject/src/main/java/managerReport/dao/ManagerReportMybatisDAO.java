package managerReport.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ManagerReportMybatisDAO implements ManagerReportDAO {
	@Autowired
	private SqlSession sqlSession;
}
