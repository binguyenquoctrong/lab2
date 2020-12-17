package org.apache.jsp.css;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"newcss.css\" type=\"text/css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2>Responsive Table</h2>\n");
      out.write("        <div class=\"table-wrapper\">\n");
      out.write("            <table class=\"fl-table\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Header 1</th>\n");
      out.write("                        <th>Header 2</th>\n");
      out.write("                        <th>Header 3</th>\n");
      out.write("                        <th>Header 4</th>\n");
      out.write("                        <th>Header 5</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Content 1</td>\n");
      out.write("                        <td>Content 1</td>\n");
      out.write("                        <td>Content 1</td>\n");
      out.write("                        <td>Content 1</td>\n");
      out.write("                        <td>Content 1</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Content 2</td>\n");
      out.write("                        <td>Content 2</td>\n");
      out.write("                        <td>Content 2</td>\n");
      out.write("                        <td>Content 2</td>\n");
      out.write("                        <td>Content 2</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Content 3</td>\n");
      out.write("                        <td>Content 3</td>\n");
      out.write("                        <td>Content 3</td>\n");
      out.write("                        <td>Content 3</td>\n");
      out.write("                        <td>Content 3</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Content 4</td>\n");
      out.write("                        <td>Content 4</td>\n");
      out.write("                        <td>Content 4</td>\n");
      out.write("                        <td>Content 4</td>\n");
      out.write("                        <td>Content 4</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Content 5</td>\n");
      out.write("                        <td>Content 5</td>\n");
      out.write("                        <td>Content 5</td>\n");
      out.write("                        <td>Content 5</td>\n");
      out.write("                        <td>Content 5</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Content 6</td>\n");
      out.write("                        <td>Content 6</td>\n");
      out.write("                        <td>Content 6</td>\n");
      out.write("                        <td>Content 6</td>\n");
      out.write("                        <td>Content 6</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Content 7</td>\n");
      out.write("                        <td>Content 7</td>\n");
      out.write("                        <td>Content 7</td>\n");
      out.write("                        <td>Content 7</td>\n");
      out.write("                        <td>Content 7</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Content 8</td>\n");
      out.write("                        <td>Content 8</td>\n");
      out.write("                        <td>Content 8</td>\n");
      out.write("                        <td>Content 8</td>\n");
      out.write("                        <td>Content 8</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Content 9</td>\n");
      out.write("                        <td>Content 9</td>\n");
      out.write("                        <td>Content 9</td>\n");
      out.write("                        <td>Content 9</td>\n");
      out.write("                        <td>Content 9</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Content 10</td>\n");
      out.write("                        <td>Content 10</td>\n");
      out.write("                        <td>Content 10</td>\n");
      out.write("                        <td>Content 10</td>\n");
      out.write("                        <td>Content 10</td>\n");
      out.write("                    </tr>\n");
      out.write("                <tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}