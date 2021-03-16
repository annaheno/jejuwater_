package very.cute.mapper;

import java.util.List;
import very.cute.domain.BoardAttachVO;
import very.cute.domain.BoardVO;

public interface BoardAttachMapper {
	
//	파일 업로드를 t_attach 테이블에 insert
	public void insert(BoardAttachVO vo);
//	파일 업로드를 t_attach 테이블에 delete
	public void delete(BoardVO vo);
//	파일 업로드를 t_attach 테이블에 select
	public List<BoardAttachVO> select(int bno);
}