package very.cute.cat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import very.cute.domain.MemberVO;
import very.cute.service.MemberService;

@Controller
@RequestMapping(value="member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService meservice;
	
//	ȸ������ ȭ��
	@RequestMapping(value="member",method=RequestMethod.GET)
	public void memberGet() {
	}
//	ȸ������
	@RequestMapping(value="member", method=RequestMethod.POST)
	public void memberPost(MemberVO vo,HttpSession session) {
		session.setAttribute("info", vo);
		meservice.createMember(vo);
	}
//	���̵� �ߺ� üũ
	@ResponseBody
	@RequestMapping(value="idCheck",method=RequestMethod.GET)
	public int idCheck(@RequestParam("userid") String userid) throws Exception{
		logger.info("userid :"+userid);
		int result = meservice.idCheck(userid);
		return result;
	}
// �α��� ȭ��
	@RequestMapping(value="login",method=RequestMethod.GET)
	public void loginGet() throws Exception{
		logger.info("�α��� ȭ�� �̵�");
	}
// �α���
	@RequestMapping(value="loginPost",method=RequestMethod.POST)
	public String loginPost(MemberVO member, Model model, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		HttpSession session = request.getSession();
		logger.info("�α��� ó��");
		MemberVO vo = meservice.login(member);
		logger.info("vo : " + vo);
		
		if(vo != null) {
			session.setAttribute("login", vo);
			logger.info("���� �� : "+session.getAttribute("login"));
			return "redirect:/";
		}else {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/login";
		}
	}
//	�α׾ƿ�
	@RequestMapping(value="logout")
	public ModelAndView logout(HttpSession session) {
		meservice.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		mav.addObject("msg","logout");
		logger.info("�α׾ƿ� �Ϸ�"+session);
		return mav;
		
	}
//	����������
	@RequestMapping(value="mypage")
	public void myPage() throws Exception{
	}
	
////	ȸ�� ���� Ȯ��
//	@RequestMapping("mypage")
//	public String readMember (MemberVO member, Model model,HttpSession session) throws Exception{
//		MemberVO sessionmem  = (MemberVO) session.getAttribute("login");
//		logger.info("ȸ�� ���� ��ȸ"+member);
//		return "/member/mypage";
//	}
	
//	ȸ�� ���� ���� ȭ��
	@RequestMapping(value="updateMemberView",method=RequestMethod.GET)
	public String updateGet(HttpSession session, MemberVO member, Model model) throws Exception{
		MemberVO sessionmem  =(MemberVO) session.getAttribute("login");
		
		if(sessionmem != null) {
			member.setUserid(sessionmem.getUserid());
			logger.info("ȸ�� ���� ��ȸ"+member);
		}
		
		model.addAttribute("info",meservice.readMember(member));
//		model.addAttribute("info", meservice.)
		return "/member/updateMemberView";
	}
//	ȸ�� ���� ����
	@RequestMapping(value="updateMember",method=RequestMethod.POST)
	public String updatePost(@ModelAttribute MemberVO vo) throws Exception{
		meservice.updateMember(vo);
		return "redirect:/";
	}
}