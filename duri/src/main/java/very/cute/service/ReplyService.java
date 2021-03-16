package very.cute.service;

import org.springframework.stereotype.Service;
import very.cute.domain.Criteria;
import very.cute.domain.ReplyPageVO;
import very.cute.domain.ReplyVO;

@Service
public interface ReplyService {
	
//	��� ����Ʈ
	public ReplyPageVO list(int bno, Criteria cri) throws Exception;
//	��� ����
	public void create(ReplyVO vo) throws Exception;
//	��� ����
	public void update(ReplyVO vo) throws Exception;
//	��� ����
	public void delete(int rno) throws Exception;

}
