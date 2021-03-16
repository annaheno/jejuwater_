package very.cute.service;

import java.util.List;
import org.springframework.stereotype.Service;
import very.cute.domain.BoardAttachVO;
import very.cute.domain.BoardVO;
import very.cute.domain.Criteria;

@Service
public interface BoardService {
	
//	�� ����
	public void create(BoardVO vo) throws Exception;
//	�� �б�
	public BoardVO read(BoardVO vo) throws Exception;
//	�� ����
	public void update(BoardVO vo) throws Exception;
//	�� ����
	public void delete(BoardVO vo) throws Exception;
//	�Խñ� ���
	public List<BoardVO> listAll() throws Exception;
//	�Խñ� ��� (������)
	public List<BoardVO> listPage(Criteria cri) throws Exception;
//	����¡ ó���� ���� ī���� (�Խñ� �� ����)
	public int getTotalCount(Criteria cri) throws Exception;
	// ��ȸ��
	public int viewCount(BoardVO vo) throws Exception;
//	BoardAttachVO�� �ִ� ������ �������� ����
	public List<BoardAttachVO> getAttachList(int bno) throws Exception;
}
