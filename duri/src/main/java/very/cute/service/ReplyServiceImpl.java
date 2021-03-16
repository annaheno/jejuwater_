package very.cute.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import very.cute.domain.Criteria;
import very.cute.domain.ReplyPageVO;
import very.cute.domain.ReplyVO;
import very.cute.mapper.ReplyMapper;


@Repository
@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper remapper;

	@Override
	public ReplyPageVO list(int bno,Criteria cri) throws Exception {
		System.out.println("service bno="+bno);
		return new ReplyPageVO(remapper.list(bno,cri), remapper.getCountByBno(bno));
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		remapper.create(vo);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		remapper.update(vo);
	}

	@Override
	public void delete(int rno) throws Exception {
		remapper.delete(rno);
	}
}
