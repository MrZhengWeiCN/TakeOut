package edu.zhwei.comment.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XssFilter implements Filter,
		com.sun.org.apache.xalan.internal.xsltc.dom.Filter {

	@Override
	public boolean test(int node) {
		return false;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/*XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(
				(HttpServletRequest) request);*/
		//设置http头来放置XSS攻击
		/*setXSSHeadProtect((HttpServletResponse)response);*/
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		httpServletResponse.setHeader("Set-Cookie", "HttpOnly");
		chain.doFilter(request, httpServletResponse);
	}
	
	private void setXSSHeadProtect(HttpServletResponse response){
		/*response.setHeader("X-XSS-Protection", "1;mode=block");
		response.setHeader("X-Fram-Options", "deny");
		response.setHeader("X-Content-Type-Options", "nosniff");
		response.setHeader("Content-Security-Policy", "default-src 'self'");*/
		response.setHeader("Set-Cookie", "HttpOnly");
		/*return response;*/
	}

	@Override
	public void destroy() {
	}

}
