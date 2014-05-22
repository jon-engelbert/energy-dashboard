package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class setup_005fuser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/jspf/header.jspf");
    _jspx_dependants.add("/WEB-INF/view/setupMenu.jsp");
    _jspx_dependants.add("/WEB-INF/jspf/footer.jspf");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_out_value_nobody.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n");
      out.write("        <link href=\"css/slider.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n");
      out.write("        <title>Cloud View</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body bgcolor=\"#FFFFFF\" text=\"#000000\">\n");
      out.write("\n");
      out.write("        <!-- ===========forms for entering new values============================== -->\n");
      out.write("\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            <div id=\"header-wrapper\">\n");
      out.write("                <div id=\"header\">\n");
      out.write("\n");
      out.write("                    <div id=\"logo\">\n");
      out.write("                        <h1>Cloud View  \n");
      out.write("                        <span style=\"margin:40px;\"><img src=\"./images/oe_logo_small.png\" /></span></h1>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- end #header -->\n");
      out.write("\n");
      out.write("            <div id=\"menu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"dashboard\">Dashboard</a></li>\n");
      out.write("                    <li><a href=\"scenario\">Scenarios</a></li>\n");
      out.write("<!--                    <li><a href=\"reports\">Reports</a></li>-->\n");
      out.write("                    <!--<li><a href=\"lighting\">Lighting</a></li>-->\n");
      out.write("                    <!--<li><a href=\"hvac\">HVAC</a></li>-->\n");
      out.write("<!--                    <li><a href=\"alerts\">Alerts</a></li>-->\n");
      out.write("                    <!--<li><a href=\"setup_entry\">Bills</a></li>-->\n");
      out.write("                    <li><a href=\"setup_building\">Setup</a></li>\n");
      out.write("                    <li><a href=\"logout\">Sign out</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <!-- end #menu -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"submenu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"setup_building\">Buildings</a></li>\n");
      out.write("                    <li><a href=\"setup_meter\">Meters</a></li>\n");
      out.write("<!--                    <li><a href=\"setup_panel\">Electric Panels</a></li>\n");
      out.write("                    <li><a href=\"setup_multibranch\">Multi-Branch Meters</a></li>\n");
      out.write("                    <li><a href=\"#\">End-Uses</a></li>\n");
      out.write("                    <li><a href=\"setup_circuits\">Circuits</a></li>\n");
      out.write("                    <li><a href=\"setup_tenants\">Tenants</a></li>-->\n");
      out.write("                    <li><a href=\"setup_entry\">Bills</a></li>\n");
      out.write("                    <li><a href=\"setup_pcentry\">PC Bills</a></li>\n");
      out.write("                    <li><a href=\"setup_user\">Users</a></li>\n");
      out.write(" <!--                   <li><a href=\"setup_equip\">Equipment</a></li>-->\n");
      out.write(" <!--                   <li><a href=\"setup_limits\">Limits</a></li> -->\n");
      out.write("                    <li><a href=\"setup_schedule\">Schedule</a></li>\n");
      out.write("                    <li><a href=\"setup_client\">Enterprise</a></li>\n");
      out.write("                    <li><a href=\"setup_ws\">Weather-Station</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!-- end #submenu -->\n");
      out.write("\n");
      out.write("            \n");
      out.write("            <div id=\"submenu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"setup_user\"> Add New </a></li>\n");
      out.write("                    <li><a href=\"edit_user\"> Edit/Delete </a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!-- end #submenu -->\n");
      out.write("\n");
      out.write("<div id=\"page\">\n");
      out.write("    <div id=\"content\">\n");
      out.write("        <div class=\"post\">\n");
      out.write("            <h1>Add User</h1>\n");
      out.write("            <div id=\"stylized\" class=\"myform\">\n");
      out.write("                <form name=\"userDataForm\" method=\"post\" action=\"add_user\" onsubmit=\"return validate(this);\">\n");
      out.write("                    <input type=\"hidden\" name=\"userid\" />\n");
      out.write("                    <label>User Name:</label>\n");
      out.write("                        <input type=\"text\" name=\"user\" id=\"user\" /> \n");
      out.write("                    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("                    \n");
      out.write("                    <label>Email Address:</label>\n");
      out.write("                        <input type=\"text\" name=\"email\" id=\"email\" /> \n");
      out.write("                    <label>Password: </label>\n");
      out.write("                        <input type=\"password\" name=\"password\" id=\"password\"> \n");
      out.write("                    <label>Confirm Password: </label>\n");
      out.write("                        <input type=\"password\" name=\"confirm-password\" id=\"confirm-password\"> \n");
      out.write("                    <label>Is Superuser: </label>\n");
      out.write("                        <input type=\"checkbox\" name=\"isSuperUser\"  id=\"isSuperUser\" ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("/>             \n");
      out.write("                    <label>Is Enterprise Admin: </label>\n");
      out.write("                        <input type=\"checkbox\" name=\"isAdmin\"  id=\"isAdmin\" ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("/>             \n");
      out.write("                    <label>Receive Email Alerts: </label>\n");
      out.write("                        <input type=\"checkbox\" name=\"receiveEmailAlert\"  id=\"receiveEmailAlert\"/>             \n");
      out.write("                    <label>Receive Policy Changes: </label>\n");
      out.write("                        <input type=\"checkbox\" name=\"receiveEmailPolicy\"  id=\"receiveEmailPolicy\"/>             \n");
      out.write("                    <label><input name=\"adduser\" type=\"submit\" class=\"box\" value=\" Add User \"></label>\n");
      out.write("                        <input name=\"clear\" type=\"reset\" value=\" Clear \" onClick=\"clearForm()\">\n");
      out.write("                </form>\n");
      out.write("            <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${result}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>                \n");
      out.write("            </div><!-- Stylized MyForm -->\n");
      out.write("\n");
      out.write("        </div><!-- post -->\n");
      out.write("    </div><!-- content -->\n");
      out.write("    <script language=\"javascript\" type=\"text/javascript\" src=\"js/jquery-1.6.2.min.js\"></script>\n");
      out.write("    <script language=\"javascript\" type=\"text/javascript\" src=\"js/jquery.maskedinput-1.3.min.js\"></script>\n");
      out.write("    <script language=\"javascript\" type=\"text/javascript\" src=\"js/input.js\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        function validate(form) {\n");
      out.write("            if ($('#password').val() != $('#confirm-password').val()) {\n");
      out.write("                alert('Your passwords do not match. Please re-enter the passwords.');\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("           return true;\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</div><!-- page -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div id=\"footer\"><p style=\"font-size:10px;font-style:italic\">Copyright &copy; 2012 Beige Bag Software, Inc.</p></div>\n");
      out.write("    </body>\n");
      out.write("</html>        \n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userIsSuper}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                        <label>Client: </label>\n");
        out.write("                            <select name=\"client\" id=\"client\">\n");
        out.write("                             ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write(" \n");
        out.write("                            </select>\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_forEach_0.setVar("cli");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientList}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                    <option value=\"");
          if (_jspx_meth_c_out_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write('"');
          out.write('>');
          if (_jspx_meth_c_out_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</option>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cli.idClient}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cli.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userinfo.isSuperUser}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("checked=\"checked\"");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userinfo.isAdmin}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("checked=\"checked\"");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }
}
