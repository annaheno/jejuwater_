package very.cute.service;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import very.cute.domain.MemberVO;

@Service
public interface MemberService {
	
//	로그인
	public MemberVO login(MemberVO member);
//	로그 아웃
	public void logout(HttpSession session);
//	회원 정보 확인
	public MemberVO readMember(MemberVO member);
//	회원 정보 수정
	public void updateMember(MemberVO vo) throws Exception;
//	회원 삭제
	public void deleteMember(MemberVO vo) throws Exception;
//	회원가입 insert 하기 위한 service
	public void createMember (MemberVO vo);
//	회원가입시 아이디 중복 체크
	public int idCheck (String userid);
}
