package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")
public class EncodingFilter extends HttpFilter implements Filter {
	ServletContext context;
	
	public EncodingFilter() {
		super();
	}

	public void destroy() {
		System.out.println("destroy 호출");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 호출");
		
		//한글 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		//요청 필터에서 요청 처리 전의 시각을 구함.
		long begin = System.currentTimeMillis();
		
		//다음 필터로 넘겨주는 작업.
		chain.doFilter(request, response);
		
		//응답 필터에서 요청 처리 후의 시각을 구함.
		long end = System.currentTimeMillis();
		
		//작업 요청 전과 후의 시각 차를 구해 작업 수행 시간을 구함.
		System.out.println("작업시간 : " + (end-begin) + "ms");
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 인코딩....................");
	}

}
