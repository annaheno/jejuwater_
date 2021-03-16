package very.cute.mapper;

import java.util.List;
import javax.servlet.http.HttpSession;
import very.cute.domain.MemberVO;

public interface MemberMapper {
	
//	 ȸ������ (insert)
	public void createMember(MemberVO vo);
	
//	 ȸ�����Խ� �ߺ� üũ (���߿�)
	public int idCheck (String userid);
	
//	 ȸ�� ���� ���� �ϱ� �� ������ ��ȸ (select)
	public MemberVO readMember(MemberVO vo);
//	public List <MemberVO> memberList();
	
//	 ȸ�� ���� ���� (update)
	public void updateMember(MemberVO vo);
	
//ȸ�� ���� (delete)
	public void deleteMember(MemberVO vo);
	
//	�α���
	public MemberVO login(MemberVO vo);
	
//	�α׾ƿ�
	public void logout(HttpSession session);
}