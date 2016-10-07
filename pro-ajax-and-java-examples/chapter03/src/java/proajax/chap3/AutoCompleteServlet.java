/*
 * AutoCompleteServlet.java
 *
 * Created on June 20, 2005, 7:24 PM
 */

package proajax.chap3;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author nate
 * @version
 */
public class AutoCompleteServlet extends HttpServlet {

    private List names = new ArrayList();

    public void init(ServletConfig config) throws ServletException {
        names.add("Abe");
        names.add("Abel");
        names.add("Abigail");
        names.add("Abner");
        names.add("Abraham");
        names.add("Marcus");
        names.add("Marcy");
        names.add("Marge");
        names.add("Marie");
    }
    
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String prefix = request.getParameter("name");
        NameService service = NameService.getInstance(names);
        List matching = service.findNames(prefix);

        if (matching.size() > 0) {
            PrintWriter out = response.getWriter();

            response.setContentType("text/html");
            StringBuffer results = new StringBuffer("<ul>");
            Iterator iter = matching.iterator();
            while(iter.hasNext()) {
                String name = (String) iter.next();
                results.append("<li>" + name + "</li>");
            }
            results.append("</ul>");
            matching = null;
            service = null;
            out.println(results); 
            out.close();
        } else {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }

    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
        
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
}
