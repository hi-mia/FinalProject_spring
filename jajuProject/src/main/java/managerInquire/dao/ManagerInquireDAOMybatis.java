package managerInquire.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import inquire.bean.InquireDTO;
import report.bean.ReportDTO;


@Transactional
@Repository
public class ManagerInquireDAOMybatis implements ManagerInquireDAO {

		@Autowired
		private SqlSession sqlSession;
		

		@Override
		public List<InquireDTO> getManagerInquire(Map<String, String> map) {
			return sqlSession.selectList("managerInquireSQL.getManagerInquire", map);
		}


		@Override
		public void managerInquireDelete(Map<String, String[]> map) {
			sqlSession.delete("managerInquireSQL.managerInquireDelete",map);
			
		}


		@Override
		public int getTotalA() {
			return sqlSession.selectOne("managerInquireSQL.getTotalA");
		}


		@Override
		public List<InquireDTO> getInquireSearchList(Map<String, String> map) {
			List<InquireDTO> list =  sqlSession.selectList("managerInquireSQL.getInquireSearchList", map);
			return list;
		}


		@Override
		public int getTotalSearchA(Map<String, String> map) {
			return sqlSession.selectOne("managerInquireSQL.getTotalSearchA", map);
		}
}
