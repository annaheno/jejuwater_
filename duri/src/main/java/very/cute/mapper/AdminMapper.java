package very.cute.mapper;

import java.util.List;

import very.cute.domain.AdminVO;

public interface AdminMapper {
	
//	���� ���
	public void register (AdminVO vo) throws Exception;
//	���� ���
	public List<AdminVO> list() throws Exception;
//	���� ��ȸ
	public AdminVO read(AdminVO vo) throws Exception;
//	���� ����
	public void modify(AdminVO notice) throws Exception;
//	����
	public void delete (AdminVO notice) throws Exception;
}
