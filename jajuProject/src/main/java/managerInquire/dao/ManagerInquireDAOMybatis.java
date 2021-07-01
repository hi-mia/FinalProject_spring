package managerInquire.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import inquire.bean.InquireDTO;


@Transactional
@Repository
public class ManagerInquireDAOMybatis implements ManagerInquireDAO {

		@Autowired
		private SqlSession sqlSession;
		

		@Override
		public List<InquireDTO> getManagerInquire(Map<String, String> map) {
			return sqlSession.selectList("managerSQL.getManagerInquire", map);
		}
}
