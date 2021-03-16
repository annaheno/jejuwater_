package very.cute.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import very.cute.domain.BoardAttachVO;
import very.cute.domain.BoardVO;
import very.cute.domain.Criteria;
import very.cute.mapper.BoardAttachMapper;
import very.cute.mapper.BoardMapper;

@Repository
@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	@Autowired
	private BoardAttachMapper attachmapper;
	
	@Transactional
	@Override
	public void create(BoardVO vo) throws Exception {

//		if(vo.getAttachList()== null) {
			mapper.create(vo);
//		} else {
			vo.getAttachList().forEach(attach->{
				attach.setBno(vo.getBno());
				attachmapper.insert(attach);
			});
//		}
		

	}

	@Transactional
	@Override
	public BoardVO read(BoardVO vo) throws Exception {
		mapper.viewCount(vo);
		return mapper.read(vo);
	}
	
	@Override
	public void update(BoardVO vo) throws Exception {
		mapper.update(vo);
	}

	@Override
	@Transactional
	public void delete(BoardVO vo) throws Exception {
		mapper.delete(vo);
		attachmapper.delete(vo);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return mapper.listAll();
	}
	
	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		return mapper.listPage(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) throws Exception {
		return mapper.getTotalCount(cri);
	}


	@Override
	public int viewCount(BoardVO vo) throws Exception {
		return mapper.viewCount(vo);
	}

	@Override
	public List<BoardAttachVO> getAttachList(int bno) throws Exception {
		return attachmapper.select(bno);
	}
}