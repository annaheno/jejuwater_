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
	
//	회원가입 화면
	@RequestMapping(value="member",method=RequestMethod.GET)
	public void memberGet() {
	}
//	회원가입
	@RequestMapping(value="member", method=RequestMethod.POST)
	public void memberPost(MemberVO vo,HttpSession session) {
		session.setAttribute("info", vo);
		meservice.createMember(vo);
	}
//	아이디 중복 체크
	@ResponseBody
	@RequestMapping(value="idCheck",method=RequestMethod.GET)
	public int idCheck(@RequestParam("userid") String userid) throws Exception{
		logger.info("userid :"+userid);
		int result = meservice.idCheck(userid);
		return result;
	}
// 로그인 화면
	@RequestMapping(value="login",method=RequestMethod.GET)
	public void loginGet() throws Exception{
		logger.info("로그인 화면 이동");
	}
// 로그인
	@RequestMapping(value="loginPost",method=RequestMethod.POST)
	public String loginPost(MemberVO member, Model model, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		HttpSession session = request.getSession();
		logger.info("로그인 처리");
		MemberVO vo = meservice.login(member);
		logger.info("vo : " + vo);
		
		if(vo != null) {
			session.setAttribute("login", vo);
			logger.info("세션 값 : "+session.getAttribute("login"));
			return "redirect:/";
		}else {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/login";
		}
	}
//	로그아웃
	@RequestMapping(value="logout")
	public ModelAndView logout(HttpSession session) {
		meservice.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		mav.addObject("msg","logout");
		logger.info("로그아웃 완료"+session);
		return mav;
		
	}
//	마이페이지
	@RequestMapping(value="mypage")
	public void myPage() throws Exception{
	}
	
////	회원 정보 확인
//	@RequestMapping("mypage")
//	public String readMember (MemberVO member, Model model,HttpSession session) throws Exception{
//		MemberVO sessionmem  = (MemberVO) session.getAttribute("login");
//		logger.info("회원 정보 조회"+member);
//		return "/member/mypage";
//	}
	
//	회원 정보 수정 화면
	@RequestMapping(value="updateMemberView",method=RequestMethod.GET)
	public String updateGet(HttpSession session, MemberVO member, Model model) throws Exception{
		MemberVO sessionmem  =(MemberVO) session.getAttribute("login");
		
		if(sessionmem != null) {
			member.setUserid(sessionmem.getUserid());
			logger.info("회원 정보 조회"+member);
		}
		
		model.addAttribute("info",meservice.readMember(member));
//		model.addAttribute("info", meservice.)
		return "/member/updateMemberView";
	}
//	회원 정보 수정
	@RequestMapping(value="updateMember",method=RequestMethod.POST)
	public String updatePost(@ModelAttribute MemberVO vo) throws Exception{
		meservice.updateMember(vo);
		return "redirect:/";
	}
}