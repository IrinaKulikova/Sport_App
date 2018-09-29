package application.filter;

import application.entity.Administrator;
import application.service.helper.HashHelper;
import application.service.implementations.AdministratorService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@WebFilter("*")
public class AuthorizationFilter implements Filter {

    List<Administrator> admins = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            admins = new AdministratorService().getAll();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String requestUri = req.getRequestURI();
        boolean isLogged = false;
        String identifier = (String)session.getAttribute("identifier");
        if(identifier != null && admins!=null){
            for(Administrator a: admins){
                try {
                    if(identifier.equals(HashHelper.makeSHA1Hash(a.getLogin()+a.getPassword()+"Sport_App"))){
                        isLogged=true;
                        break;
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        }

        if(requestUri.equals("/login") || isLogged){
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect("/login");
        }

    }

    @Override
    public void destroy() {

    }
}
