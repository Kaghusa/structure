package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;
import java.util.*;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import core.fileupload;;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

      fileupload file = new fileupload();
     
    if (ServletFileUpload.isMultipartContent(request))
    {
        //out.print(request.getParameter("email"));
        List items = file.upload.parseRequest(request);
        String path="/Users/olivier/NetBeansProjects/structure/web/profile/";
        Map field = new HashMap();
       field= file.uploadfile(items, path);
         Set <String> keys = field.keySet();
                for(String key: keys) 
                {
                 out.println(key+" :  "+field.get(key));
                }
    }
   

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head> \n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <title>User|Registration</title>\n");
      out.write("  <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("  <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n");
      out.write("  <!-- Bootstrap 3.3.6 -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"../../bootstrap/css/bootstrap.min.css\">\n");
      out.write("  <!-- Font Awesome -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css\">\n");
      out.write("  <!-- Ionicons -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css\">\n");
      out.write("  <!-- Theme style -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"../../dist/css/AdminLTE.min.css\">\n");
      out.write("  <!-- iCheck -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"../../plugins/iCheck/square/blue.css\">\n");
      out.write("  \n");
      out.write("</head>\n");
      out.write("<body class=\"hold-transition register-page\">\n");
      out.write("<div class=\"register-box\">\n");
      out.write("  <div class=\"register-logo\">\n");
      out.write("    <a href=\"\"><b>USER REGISTRATION</b></a>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"register-box-body\">\n");
      out.write("    <!--<p class=\"login-box-msg\">Register</p>-->\n");
      out.write("\n");
      out.write("    <form action=\"\" method=\"post\" enctype=\"multipart/form-data\"  >\n");
      out.write("  \n");
      out.write("\n");
      out.write("      <div class=\"form-group has-feedback\">\n");
      out.write("        <input type=\"email\" class=\"form-control\" name=\"email\" placeholder=\"Email\">\n");
      out.write("        <span class=\"glyphicon glyphicon-envelope form-control-feedback\"></span>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("     \n");
      out.write("\n");
      out.write("      <div class=\"form-group has-feedback\">\n");
      out.write("          <label> Upload Profile</label>  \n");
      out.write("          <input name=\"profile\"  type=\"file\">\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-xs-8\">\n");
      out.write("          <div class=\"checkbox icheck\">\n");
      out.write("            <!--<label>\n");
      out.write("              <input type=\"checkbox\"> I agree to the <a href=\"#\">terms</a>\n");
      out.write("            </label>-->\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-xs-4\">\n");
      out.write("          \n");
      out.write("       \n");
      out.write("        \n");
      out.write("     <div id=\"app\"></div>    \n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/react/0.14.7/react.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/react/0.14.7/react-dom.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js\"></script>\n");
      out.write("    <script type=\"text/babel\">\n");
      out.write("        \n");
      out.write("        var HelloComponent = React.createClass({\n");
      out.write("                      \n");
      out.write("            render: function() {\n");
      out.write("                return (\n");
      out.write("               <button type=\"submit\" name=\"next\" class=\"btn btn-primary btn-block btn-flat\"> Next</button>\n");
      out.write("                )\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("        \n");
      out.write("        ReactDOM.render(<HelloComponent />, document.querySelector('#app'))\n");
      out.write("    </script>\n");
      out.write("    \n");
      out.write("      </div>\n");
      out.write("         </div> \n");
      out.write("    </form>\n");
      out.write("    ");

        //
    
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("<!-- jQuery 2.2.3 -->\n");
      out.write("<script src=\"../../plugins/jQuery/jquery-2.2.3.min.js\"></script>\n");
      out.write("<!-- Bootstrap 3.3.6 -->\n");
      out.write("<script src=\"../../bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("<!-- iCheck -->\n");
      out.write("<script src=\"../../plugins/iCheck/icheck.min.js\"></script>\n");
      out.write("<script>\n");
      out.write("  $(function () {\n");
      out.write("    $('input').iCheck({\n");
      out.write("      checkboxClass: 'icheckbox_square-blue',\n");
      out.write("      radioClass: 'iradio_square-blue',\n");
      out.write("      increaseArea: '20%' // optional\n");
      out.write("    });\n");
      out.write("  });\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>");
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
