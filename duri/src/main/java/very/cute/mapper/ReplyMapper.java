package very.cute.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import very.cute.domain.Criteria;
import very.cute.domain.ReplyVO;

public interface ReplyMapper {
	
//	댓글 리스트 보기
	public List<ReplyVO> list(@Param ("bno") int bno, @Param("cri") Criteria cri) throws Exception;
//	댓글 리스트 페이지
//	public List<ReplyVO> list(int bno) throws Exception;
//	댓글 쓰기
	public void create(ReplyVO vo)throws Exception;
//	댓글 수정
	public void update(ReplyVO vo) throws Exception;
//	댓글 삭제
	public void delete (int rno) throws Exception;
//	현재 게시물 전체 댓글 수
	public int getCountByBno(int bno);
}
