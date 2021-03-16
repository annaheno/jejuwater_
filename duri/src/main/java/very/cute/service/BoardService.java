package very.cute.service;

import java.util.List;
import org.springframework.stereotype.Service;
import very.cute.domain.BoardAttachVO;
import very.cute.domain.BoardVO;
import very.cute.domain.Criteria;

@Service
public interface BoardService {
	
//	글 쓰기
	public void create(BoardVO vo) throws Exception;
//	글 읽기
	public BoardVO read(BoardVO vo) throws Exception;
//	글 수정
	public void update(BoardVO vo) throws Exception;
//	글 삭제
	public void delete(BoardVO vo) throws Exception;
//	게시글 목록
	public List<BoardVO> listAll() throws Exception;
//	게시글 목록 (페이지)
	public List<BoardVO> listPage(Criteria cri) throws Exception;
//	페이징 처리를 위한 카운팅 (게시글 총 갯수)
	public int getTotalCount(Criteria cri) throws Exception;
	// 조회수
	public int viewCount(BoardVO vo) throws Exception;
//	BoardAttachVO에 있는 정보를 가져오는 서비스
	public List<BoardAttachVO> getAttachList(int bno) throws Exception;
}
