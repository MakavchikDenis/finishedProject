
import ClassCollection.*;
import model.PersonDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/ServletGroup")
public class ServletGroup extends HttpServlet {

    private boolean funCheck(String name, String surname, String email) {
        if ((name.equals("")) || (surname.equals("")) || (email.equals(""))) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonDao group = new PersonDao();
        req.setAttribute("group", group.getGroup());
        group.closeConnection();
        req.getRequestDispatcher("WEB-INF/finalPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        PersonDao group = new PersonDao();
        switch (req.getParameter("checkBut")) {
            case ("Add"):
                if (funCheck(req.getParameter("newName"), req.getParameter("newSurname"),
                        req.getParameter("newEmail"))) {
                    group.insertPerson(req.getParameter("newName"), req.getParameter("newSurname"),
                            req.getParameter("newEmail"));
                    req.setAttribute("group", group.getGroup());
                    req.getRequestDispatcher("WEB-INF/finalPage.jsp").forward(req, resp);
                } else {
                    req.setAttribute("errorMessage", "ERROR");
                    req.setAttribute("group", group.getGroup());
                    req.getRequestDispatcher("WEB-INF/finalPage.jsp").forward(req, resp);
                }
                break;
            case ("Select"):
                req.setAttribute("group",group.getSelectMember(req.getParameter("ChoiseName")));
                req.getRequestDispatcher("WEB-INF/finalPage.jsp").forward(req,resp);
                break;
            case ("Update"):
                group.funUpdate(req.getParameter("UpdateName"),req.getParameter("UpdateEmail"));
                req.setAttribute("group",group.getGroup());
                req.getRequestDispatcher("WEB-INF/finalPage.jsp").forward(req, resp);
                break;
            case("Delete"):
                group.funDelete(req.getParameter("DeleteName"),req.getParameter("DeleteSurname"));
                req.setAttribute("group",group.getGroup());
                req.getRequestDispatcher("WEB-INF/finalPage.jsp").forward(req, resp);
                break;
        }
        group.closeConnection();
    }
}

