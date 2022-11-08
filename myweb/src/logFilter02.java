import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 处理非法请求
 *需要放行的资源：
 * 1.指定页面，例如登录页面，注册页面等
 * 2.静态资源，放行例如（css,image,js文件等等），把这些文件放到包内，通过判断uri.contains(/js)实现
 * 3.指定操作
 * 4.登录状态放行，判断session中信息是否为空
 */
@WebFilter("/*")
public class logFilter02 implements Filter {//Filter是javax.servlet下的
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //多个过滤器的话，首字母在前的过滤器先执行
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;
        //获取请求的路径
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        String request_URI = httpServletRequest.getRequestURI();
        if(request_URI.contains("/form.html")||request_URI.contains("/index.jsp")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        if(request_URI.contains("/FormServlet")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        if(request_URI.contains("/huan.jsp")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        Object user1 =((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        if(user1!=null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

       httpServletResponse.sendRedirect("index.jsp");//这么写会导致重定向次数过，因为访问index.jsp也属于一次请求
    }

    @Override
    public void destroy() {

    }
}
