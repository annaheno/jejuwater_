package very.cute.mapper;

import java.util.List;
import very.cute.domain.BoardAttachVO;
import very.cute.domain.BoardVO;

public interface BoardAttachMapper {
	
//	���� ���ε带 t_attach ���̺� insert
	public void insert(BoardAttachVO vo);
//	���� ���ε带 t_attach ���̺� delete
	public void delete(BoardVO vo);
//	���� ���ε带 t_attach ���̺� select
	public List<BoardAttachVO> select(int bno);
}