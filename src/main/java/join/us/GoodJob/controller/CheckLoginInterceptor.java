package join.us.GoodJob.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CheckLoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null) {
			String uri=request.getRequestURI();
			System.out.println("** HandlerInterceptor preHandle 실행 ** "+uri);
			System.out.println("** 로그인 후 이용 가능합니다 **");
			response.sendRedirect("home.do");
			return false; // 해당 컨트롤러(Handler) 실행 안됨
		}
			
			
		return true;
	}
}
