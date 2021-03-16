package very.cute.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		HttpSession session = request.getSession(); // session ����
		if (session.getAttribute("login") == null ) { // session�� �α��� ������ ���ٸ�
			response.sendRedirect("/duri/member/login"); // �۾��� ������ �����Ƿ� �α��� �������� �̵�
			return false; // �۾��� ����
		}else {
		response.sendRedirect("/duri/board/register");
		return true; // �α��� ���� ��� �۾��� ���� �ο�
	}
	}
	
	

}
