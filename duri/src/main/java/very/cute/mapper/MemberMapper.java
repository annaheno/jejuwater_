package very.cute.mapper;

import java.util.List;
import javax.servlet.http.HttpSession;
import very.cute.domain.MemberVO;

public interface MemberMapper {
	
//	 회원가입 (insert)
	public void createMember(MemberVO vo);
	
//	 회원가입시 중복 체크 (나중에)
	public int idCheck (String userid);
	
//	 회원 정보 수정 하기 전 데이터 조회 (select)
	public MemberVO readMember(MemberVO vo);
//	public List <MemberVO> memberList();
	
//	 회원 정보 수정 (update)
	public void updateMember(MemberVO vo);
	
//회원 삭제 (delete)
	public void deleteMember(MemberVO vo);
	
//	로그인
	public MemberVO login(MemberVO vo);
	
//	로그아웃
	public void logout(HttpSession session);
}