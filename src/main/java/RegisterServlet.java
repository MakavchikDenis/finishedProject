

import com.sun.jdi.connect.Connector;
import dao.UserDao;
import model.HashPassword;
import model.UserNew;
import util.ConnectorDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet (urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/Register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao daoUser=new UserDao();
        UserNew user=new UserNew(req.getParameter("nameNewUser"),
                HashPassword.getHash(req.getParameter("passwordNewUser")));

        if(daoUser.insertUser(user)){
            req.getRequestDispatcher("index.jsp").forward(req,resp);

        }
        else{
            req.setAttribute("error","ERROR LOGIN");
            req.getRequestDispatcher("/WEB-INF/Register.jsp").forward(req,resp);
        }

    }
}
