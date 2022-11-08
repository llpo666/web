import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Usersinformation")
public class Usersinformation extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public Usersinformation() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应到客户端MIME类型和字符编码方式
        response.setContentType("text/html;charset=UTF-8");

        // 设置request对象的解码方式
        request.setCharacterEncoding("utf-8");


        // 获取输出流
        PrintWriter out = response.getWriter();
        out.println("<p>用户名：" + FormServlet.username+ "</p>");
        out.println("<p>密码：" +FormServlet.password+ "</p>");
        out.println("</p>");
        out.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
