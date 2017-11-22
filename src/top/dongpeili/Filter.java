package top.dongpeili;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter implements javax.servlet.Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resq, FilterChain fc) {
		try {
//			HttpServletRequest hreq = (HttpServletRequest) req;
//			String uri = hreq.getRequestURI();
//			if(uri.endsWith(".do")) {
//				
//			}
			fc.doFilter(req, resq);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
