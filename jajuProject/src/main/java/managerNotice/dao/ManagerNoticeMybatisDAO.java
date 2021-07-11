package managerNotice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import notice.bean.NoticeDTO;

@Transactional
@Repository
public class ManagerNoticeMybatisDAO implements ManagerNoticeDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void managerNoticeWrite(NoticeDTO noticeDTO) {
		sqlSession.insert("managerNoticeSQL.managerNoticeWrite", noticeDTO);
		
	}
	
	@Override
	public List<NoticeDTO> getManagerNoticeList(Map<String, String> map) {
		return sqlSession.selectList("managerNoticeSQL.getManagerNoticeList", map);
	}

	@Override
	public int getNoticeTotalA() {
		return sqlSession.selectOne("managerNoticeSQL.getNoticeTotalA");
	}

	@Override
	public NoticeDTO getNotice(String notice_seq) {
		return sqlSession.selectOne("noticeboardSQL.getNotice", Integer.parseInt(notice_seq));
	}

	@Override
	public NoticeDTO getNoticePage(String notice_seq) {
		return sqlSession.selectOne("managerNoticeSQL.getNoticePage", Integer.parseInt(notice_seq));
	}
	
	@Override
	public void managerNoticeDelete(Map<String, String[]> map) {
		sqlSession.delete("managerNoticeSQL.managerNoticeDelete", map);
		
	}

	@Override
	public List<NoticeDTO> getNoticeSearchList(Map<String, String> map) {
		List<NoticeDTO> list =  sqlSession.selectList("managerNoticeSQL.getNoticeSearchList", map);
		return list;
	}

	@Override
	public int getTotalSearchA(Map<String, String> map) {
		return sqlSession.selectOne("managerNoticeSQL.getTotalSearchA", map);
	}

	@Override
	public void managerNoticeModify(NoticeDTO noticeDTO) {
		sqlSession.update("managerNoticeSQL.managerNoticeModify", noticeDTO);
		
	}
	
}
