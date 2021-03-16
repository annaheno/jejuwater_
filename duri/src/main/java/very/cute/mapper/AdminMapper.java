package very.cute.mapper;

import java.util.List;

import very.cute.domain.AdminVO;

public interface AdminMapper {
	
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
