import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

@WebServlet("/connect")
public class Databaseconnect extends HttpServlet {
    // JDBC 驱动名及数据库 URL
    static  String JDBC_DRIVER ;
    static  String DB_URL ;

    // 数据库的用户名与密码，需要根据自己的设置
    static  String USER ;
    static String PASS ;
    public static String username1 =null;
    public static String password1 =null;
public  static String userset;
    public  static String passwordset;
    Properties mysql_properties=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //读取配置文件
        mysql_properties=new Properties();
        mysql_properties.load(new FileReader("E:\\22\\myweb\\web\\DataConnect.properties"));
        USER=mysql_properties.getProperty("mysql_username");
        PASS=mysql_properties.getProperty("mysql_password");
        DB_URL=mysql_properties.getProperty("DB_URL");
        Connection conn = null;
        Statement stmt = null;
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // 注册 JDBC 驱动器
            Class.forName("com.mysql.jdbc.Driver");
            // 打开一个连接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行 SQL 查询
            stmt = conn.createStatement();
            String sql;
            sql = "select username1,password1 from user";
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
while (rs.next()) {
    // 通过字段检索

    username1 = (rs.getString("username1"));
    password1 = (rs.getString("password1"));
    userset+=username1;
    passwordset+=password1;
}
ServletContext servletContext = request.getServletContext();
servletContext.setAttribute("users_",userset);
servletContext.setAttribute("password_",passwordset);

            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 最后是用于关闭资源的块
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
