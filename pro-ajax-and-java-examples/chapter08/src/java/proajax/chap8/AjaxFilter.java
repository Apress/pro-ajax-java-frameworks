/*
 * AjaxFilter.java
 *
 * Created on April 8, 2006, 6:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package proajax.chap8;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
                                throws IOException, ServletException {
        HttpServletRequest  request  = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String value = request.getParameter("payTo");

        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(getResponseForValue(value));

        filterChain.doFilter(request, response);
    }

    public void destroy() {
    }

    private String getResponseForValue(String value) {
        String response = "";
        if("Foo".equals(value)) {
            response = "<value><amount>40.92</amount><value>";
        }
        return response;
    }
}