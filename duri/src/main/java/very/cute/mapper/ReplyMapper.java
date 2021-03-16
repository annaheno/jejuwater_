package very.cute.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import very.cute.domain.Criteria;
import very.cute.domain.ReplyVO;

public interface ReplyMapper {
	
//	��� ����Ʈ ����
	public List<ReplyVO> list(@Param ("bno") int bno, @Param("cri") Criteria cri) throws Exception;
//	��� ����Ʈ ������
//	public List<ReplyVO> list(int bno) throws Exception;
//	��� ����
	public void create(ReplyVO vo)throws Exception;
//	��� ����
	public void update(ReplyVO vo) throws Exception;
//	��� ����
	public void delete (int rno) throws Exception;
//	���� �Խù� ��ü ��� ��
	public int getCountByBno(int bno);
}
