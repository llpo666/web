import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	public FormServlet() {
		super();
	}
	public static String username=null;
	public static String password=null;
	int i=1;
	ArrayList<Object> list = new ArrayList<>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应到客户端MIME类型和字符编码方式
		response.setContentType("text/html;charset=UTF-8");
		// 设置request对象的解码方式
		request.setCharacterEncoding("utf-8");
		username = request.getParameter("username");
		password = request.getParameter("password");
		ServletContext servletContext = request.getServletContext();
		servletContext.setAttribute("list",list);
		Object users_ = servletContext.getAttribute("users_");
		String userss=(String)users_;
		Object password_ = servletContext.getAttribute("password_");
		String passwords=(String)password_;

		if(username!=""&&password!=""&&!(list.contains(username))&&userss.contains(username) && passwords.contains(password)){
				list.add(username);
////			String s="user"+""+i;
				request.setAttribute("user",list);
				request.getSession().setAttribute("user",list);
				response.sendRedirect("huanying.html");

			}
			else {
				response.sendRedirect("form.html");
			}
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
