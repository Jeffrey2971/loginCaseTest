package web;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("utf-8");
        // 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 封装User对象
        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);

        // 调用UserDao方法
        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        // 判断user
        if (user != null) {
            // 登陆成功
            request.setAttribute("user", user);
            // 转发
            request.getRequestDispatcher("/successServlet").forward(request, response);
        } else {
            // 登录失败
            request.getRequestDispatcher("/failServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
