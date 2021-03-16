package very.cute.mapper;

import java.util.List;
import very.cute.domain.BoardVO;
import very.cute.domain.Criteria;

public interface BoardMapper {
	
//	�۾���
	public void create (BoardVO vo)throws Exception;
// �� �б�
	public BoardVO read(BoardVO vo)throws Exception;
//	�� ����
	public void update(BoardVO vo)throws Exception;
//	�� ����
	public void delete(BoardVO vo)throws Exception;
//	�� ��� ����
	public List<BoardVO> listAll()throws Exception;
//	����¡ ó�� �� �۸��
	public List<BoardVO> listPage(Criteria cri) throws Exception;
//	����¡ ó���� ���� ī���� (�Խñ� �� ����)
	public int getTotalCount(Criteria cri);
//	��ȸ��
	public int viewCount(BoardVO vo) throws Exception; 
}
