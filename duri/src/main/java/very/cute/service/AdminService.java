package very.cute.service;

import java.util.List;
import org.springframework.stereotype.Service;
import very.cute.domain.AdminVO;

@Service
public interface AdminService {
	
//	공지 등록
	public void register (AdminVO vo) throws Exception;
//	공지 목록
	public List<AdminVO> list() throws Exception;
//	공지 조회
	public AdminVO read(AdminVO vo) throws Exception;
//	공지 수정
	public void modify(AdminVO notice) throws Exception;
//	삭제
	public void delete (AdminVO notice) throws Exception;
}
