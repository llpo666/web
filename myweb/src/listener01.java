import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener
public class listener01 implements HttpSessionAttributeListener {
    private int online_num=0;//默认人数
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        online_num++;
        System.out.println("有用户登录，人数加一，当前人数："+online_num+"个人。当前登录用户为："+FormServlet.username);

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        online_num--;
        System.out.println("用户信息输出完了自动退出，人数减一，当前人数："+online_num+"个人");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        online_num++;
        System.out.println("有用户登录，人数加一，当前人数："+online_num+"个人。当前登录用户为："+FormServlet.username);
    }
}
