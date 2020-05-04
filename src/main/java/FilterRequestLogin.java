

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter (filterName = "Filt", urlPatterns ="/ServletGroup" )
public class FilterRequestLogin implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        if(req.getSession().getAttribute("username")!=null){
            filterChain.doFilter(servletRequest,servletResponse);

        }
        else {
           req.getSession().invalidate();
           req.getRequestDispatcher("MainServlet").forward(servletRequest,servletResponse);

        }
    }
}
