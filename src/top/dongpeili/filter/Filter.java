package top.dongpeili.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter implements javax.servlet.Filter {

	// @Override
	// public void doFilter(ServletRequest req, ServletResponse resq, FilterChain
	// fc) {
	// try {
	// // HttpServletRequest hreq = (HttpServletRequest) req;
	// // String uri = hreq.getRequestURI();
	// // if(uri.endsWith(".do")) {
	// //
	// // }
	// fc.doFilter(req, resq);
	// } catch (IOException e) {
	// e.printStackTrace();
	// } catch (ServletException e) {
	// e.printStackTrace();
	// }
	// }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		javax.servlet.Filter.super.destroy();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 获取初始化参数
		String site = filterConfig.getInitParameter("Site");
		// 输出初始化参数
		System.out.println("网站名称: " + site);
		// TODO Auto-generated method stub
		javax.servlet.Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(arg0, arg1);
	}

}
