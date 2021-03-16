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
		HttpSession session = request.getSession(); // session 설정
		if (session.getAttribute("login") == null ) { // session에 로그인 정보가 없다면
			response.sendRedirect("/duri/member/login"); // 글쓰기 권한이 없으므로 로그인 페이지로 이동
			return false; // 글쓰기 제한
		}else {
		response.sendRedirect("/duri/board/register");
		return true; // 로그인 했을 경우 글쓰는 권한 부여
	}
	}
	
	

}
