package top.dongpeili.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @summary 必须要登录页面的过滤处理
 * @date 2017年11月29日
 * @author dpl
 */
public class Login implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String param = request.getParameter("name");
		
		System.out.println("进入登录过滤器");
		if("dpl".equals(param)) {
			chain.doFilter(request, response);
		}else {
			//设置返回内容类型
	        response.setContentType("text/html;charset=utf-8");

	        //在页面输出响应信息
	        PrintWriter out = response.getWriter();
	        out.print("<b>name不正确，请求被拦截，不能访问web资源</b>");
	        out.flush();
	        out.close();
	        
	        // 之后做页面跳转到登录界面
		}
	}

}
