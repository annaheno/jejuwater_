package very.cute.service;

import org.springframework.stereotype.Service;
import very.cute.domain.Criteria;
import very.cute.domain.ReplyPageVO;
import very.cute.domain.ReplyVO;

@Service
public interface ReplyService {
	
//	´ñ±Û ¸®½ºÆ®
	public ReplyPageVO list(int bno, Criteria cri) throws Exception;
//	´ñ±Û ¾²±â
	public void create(ReplyVO vo) throws Exception;
//	´ñ±Û ¼öÁ¤
	public void update(ReplyVO vo) throws Exception;
//	´ñ±Û »èÁ¦
	public void delete(int rno) throws Exception;

}
