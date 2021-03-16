package very.cute.service;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import very.cute.domain.MemberVO;
import very.cute.mapper.MemberMapper;
@Repository
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberMapper memapper;
	@Override
	public MemberVO login(MemberVO member) {
		return memapper.login(member);
	}

	@Override
	public void createMember(MemberVO vo) {
		memapper.createMember(vo);
	}

	@Override
	public int idCheck(String userid) {
		int result = memapper.idCheck(userid);
		return result;
	}

	@Override
	public void updateMember(MemberVO vo) throws Exception {
		memapper.updateMember(vo);
		
	}

	@Override
	public void deleteMember(MemberVO vo) throws Exception {
		memapper.deleteMember(vo);
		
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@Override
	public MemberVO readMember(MemberVO member) {
		return memapper.readMember(member);
	}
}