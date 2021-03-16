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
	
//	userVO�� ������ ������
	if(userVO != null) {
		logger.info("�α��� ����");
		session.setAttribute("login",userVO); // ������ ���� ��
		Cookie loginCookie = new Cookie("loginCookie",session.getId()); // ��Ű ����
		loginCookie.setPath("/");
		loginCookie.setMaxAge(60*60*24*7); // ������ ���� ��Ű ����
		response.addCookie(loginCookie);
//		response.sendRedirect("/redirect"); // �������� ���ư���
	}
	}
	@Override
	public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		System.out.println("pre handle....");
		return true;
	}
}