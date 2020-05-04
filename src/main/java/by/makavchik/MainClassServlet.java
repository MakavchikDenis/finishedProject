package main.java.by.makavchik;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import main.java.by.makavchik.dao.UserDao;
import main.java.by.makavchik.model.HashPassword;

import java.time.*;


@WebServlet (urlPatterns = "/MainServlet")
public class MainClassServlet extends HttpServlet {

   /* private boolean funChecks(String nameInputChecksLogin,String passwordInputChecksLogin){
        String varName=nameInputChecksLogin;
        String varPassword=passwordInputChecksLogin;
        if((varName.equalsIgnoreCase("Denis"))&&(varPassword.equalsIgnoreCase("123"))){
            return true;
        }
        else {
            return false;
        }
    };*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("nameInputChecksLogin");
        String password=req.getParameter("passwordInputChecksLogin");
        main.java.by.makavchik.dao.UserDao daoUser=new UserDao();

        if(daoUser.isValidUser(name, HashPassword.getHash(password))){
            req.getSession().setAttribute("username",name);
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    Cookie cookie = c;
                    System.out.println(cookie.getName() + cookie.getValue());
                    if (name.equals(cookie.getName())) {
                        req.setAttribute("lastdate", cookie.getValue());
                    }
                }
            }
            Cookie userCookie = new Cookie(name, LocalDateTime.now().toString());
            userCookie.setMaxAge(60 * 60 * 24 * 100); //хранить куки 100 дней
            resp.addCookie(userCookie);
            resp.sendRedirect("ServletGroup");
            //req.getRequestDispatcher("ServletGroup").forward(req,resp);
        }
        else {
            req.setAttribute("errorMassage","ERROR");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    };

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
