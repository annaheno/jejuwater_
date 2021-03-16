package very.cute.service;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import very.cute.domain.MemberVO;

@Service
public interface MemberService {
	
//	�α���
	public MemberVO login(MemberVO member);
//	�α� �ƿ�
	public void logout(HttpSession session);
//	ȸ�� ���� Ȯ��
	public MemberVO readMember(MemberVO member);
//	ȸ�� ���� ����
	public void updateMember(MemberVO vo) throws Exception;
//	ȸ�� ����
	public void deleteMember(MemberVO vo) throws Exception;
//	ȸ������ insert �ϱ� ���� service
	public void createMember (MemberVO vo);
//	ȸ�����Խ� ���̵� �ߺ� üũ
	public int idCheck (String userid);
}
