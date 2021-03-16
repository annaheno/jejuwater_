package very.cute.mapper;

import java.util.List;
import very.cute.domain.BoardVO;
import very.cute.domain.Criteria;

public interface BoardMapper {
	
//	글쓰기
	public void create (BoardVO vo)throws Exception;
// 글 읽기
	public BoardVO read(BoardVO vo)throws Exception;
//	글 수정
	public void update(BoardVO vo)throws Exception;
//	글 삭제
	public void delete(BoardVO vo)throws Exception;
//	글 목록 보기
	public List<BoardVO> listAll()throws Exception;
//	페이징 처리 된 글목록
	public List<BoardVO> listPage(Criteria cri) throws Exception;
//	페이징 처리를 위한 카운팅 (게시글 총 갯수)
	public int getTotalCount(Criteria cri);
//	조회수
	public int viewCount(BoardVO vo) throws Exception; 
}
