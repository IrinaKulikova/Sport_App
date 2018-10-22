package application.filter;

import application.entity.Administrator;
import application.helper.HashHelper;
import application.service.implementations.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Component
@WebFilter("*")
public class AuthorizationFilter implements Filter {

    @Autowired
    AdministratorService administratorService;


    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //test
        //chain.doFilter(request, response);

        if (administratorService == null) {
            ServletContext servletContext = request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            administratorService = webApplicationContext.getBean(AdministratorService.class);
        }

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String requestUri = req.getRequestURI();
        boolean isLogged = false;

        if (requestUri.contains("/api/1.0/shared")) {
            chain.doFilter(request, response);
            return;
        }

        List<Administrator> admins = null;
        try {
            admins = administratorService.getAll();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        String identifier = (String) session.getAttribute("identifier");
        if (identifier != null && admins != null) {
            for (Administrator a : admins) {
                try {
                    if (identifier.equals(HashHelper.makeSHA1Hash(a.getAdminHash()))) {
                        isLogged = true;
                        break;
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        }
        if (requestUri.equals("/login") || isLogged) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {
    }
}
