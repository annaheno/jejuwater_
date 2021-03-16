package very.cute.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		HttpSession session = request.getSession();
		Object userVO = modelAndView.getModel().get("userVO");
	
//	userVO에 정보가 있으면
	if(userVO != null) {
		logger.info("로그인 성공");
		session.setAttribute("login",userVO); // 세션의 변수 값
		Cookie loginCookie = new Cookie("loginCookie",session.getId()); // 쿠키 생성
		loginCookie.setPath("/");
		loginCookie.setMaxAge(60*60*24*7); // 일주일 동안 쿠키 보관
		response.addCookie(loginCookie);
//		response.sendRedirect("/redirect"); // 메인으로 돌아가기
	}
	}
	@Override
	public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		System.out.println("pre handle....");
		return true;
	}
}