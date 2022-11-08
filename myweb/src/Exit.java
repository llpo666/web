import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/exit")
public class Exit extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        ServletContext servletContext = req.getServletContext();
        Object user = servletContext.getAttribute("list");
        ArrayList users=(ArrayList) user;
        users.remove(users.size()-1);
        req.getRequestDispatcher("form.html").forward(req,resp);

    }
}
