package very.cute.service;

import java.util.List;
import org.springframework.stereotype.Service;
import very.cute.domain.AdminVO;

@Service
public interface AdminService {
	
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
