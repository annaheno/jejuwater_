package very.cute.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import very.cute.domain.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception{
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) {
			logger.info("member");
			res.sendRedirect("/duri/member/login");
			return false;
		}
		
		if(member.getVerify() != 3) {
			res.sendRedirect("/");
			return false;
		}
		return true;
	}
}