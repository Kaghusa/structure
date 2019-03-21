package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.util.Map;
import java.util.HashMap;
import core.*;;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
    db con= new db();
    notification msg= new notification();
    if (msg.sendmail("bojosmuta@gmail.com", "www.terapreneur.com"))
        {
            out.print("weldone");
        }
    else 
            out.print("wapi");     Map Data =  new HashMap();
                Map Conditions  = new HashMap();
                   
                  String TbName= "struc_user";
                  Data.put(" id ", 6);
                  Conditions.put("select","Fname , id");
                  Conditions.put("order_by","id desc");
                  Conditions.put("wheregreaterequal", Data);

               ResultSet users = con.getrows(TbName, Conditions);
               
                 while (users.next())
                    {
                        out.print("<br>");
                        out.print(users.getInt(2));
                        
                        out.print("<br>");
                        
                        out.println(con.get_tblelmt_by_id("Lnam", TbName, users.getInt(2) ));
                    }
               
                 
                  out.print("<br>");
        out.print(" THE MAX IS : ");
                              
out.println(con.GetMax("Lnam", TbName,Conditions));


 out.print("<br>");
        out.print(" THE MIN IS : ");
                              
out.println(con.GetMin("Lnam", TbName,Conditions));

 out.print("<br>");
        out.print(" THE SUM IS : ");
                              
out.println(con.GetSum("Lnam", TbName,Conditions));

 out.print("<br>");
        out.print(" THE Average IS : ");
                              
out.println(con.GetAvg("Lnam", TbName,Conditions) );
//out.println(con.bb );

   //out.println(String.format("%,f",vra));             
                              

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("   ");
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
