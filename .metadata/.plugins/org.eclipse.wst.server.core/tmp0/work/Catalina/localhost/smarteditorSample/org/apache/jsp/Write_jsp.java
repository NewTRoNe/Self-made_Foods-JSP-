/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2019-12-15 16:43:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;

public final class Write_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.io.PrintWriter");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<!-- ????????? -->\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width\" initial-scale=\"1\">\r\n");
      out.write("<!-- ??????????????? ??????  -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\r\n");
      out.write("<title>jsp ????????? ????????????</title>\r\n");
      out.write("</head>\r\n");
      out.write("<!-- Smart Editor -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/SE2/js/HuskyEZCreator.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/SE2/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js\" charset=\"utf-8\"></script>\r\n");
      out.write(" \r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.9.0.min.js\"></script>\r\n");
      out.write(" \r\n");
      out.write("<!-- Smart Editor -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write(" \r\n");
      out.write("var oEditors = [];\r\n");
      out.write("$(function(){\r\n");
      out.write("\tnhn.husky.EZCreator.createInIFrame({\r\n");
      out.write("\t    oAppRef: oEditors,\r\n");
      out.write("\t    elPlaceHolder: \"recipeContent\",\r\n");
      out.write("\t    sSkinURI: \"/smarteditorSample/SE2/SmartEditor2Skin.html\",\r\n");
      out.write("\t    fCreator: \"createSEditor2\"\r\n");
      out.write("\t});\r\n");
      out.write("\t \r\n");
      out.write("\t//???????????? ????????? ????????? ??? ????????? ?????? ????????? ?????? ??? submitContents??? ??????????????? ????????????.\r\n");
      out.write("\t$(\"#save\").click(function() {\r\n");
      out.write("\t    // ???????????? ????????? textarea??? ????????????.\r\n");
      out.write("\t    oEditors.getById[\"recipeContent\"].exec(\"UPDATE_CONTENTS_FIELD\", [ ]);\r\n");
      out.write("\t    $(\"#recipe\").submit();\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("\t \r\n");
      out.write("\t// textArea??? ????????? ??????\r\n");
      out.write("\tfunction pasteHTML(filepath){\r\n");
      out.write("\t    var sHTML = '<img src=C:/Workspace/Project/smarteditorSample/WebContent/img/'+filepath+'>';\r\n");
      out.write("\t    oEditors.getById[\"recipeContent\"].exec(\"PASTE_HTML\", [sHTML]);\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		//????????????????????????	 userID?????? ????????? ?????? ???????????? ????????? ????????? ????????? null???
		String userEmail = null;
		if (session.getAttribute("userEmail") != null) {
			userEmail = (String) session.getAttribute("userEmail");
		}
	
      out.write("\r\n");
      out.write("<!-- ???????????????  -->\r\n");
      out.write("\t<nav class=\"navbar navbar-default \">\r\n");
      out.write("\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\"\r\n");
      out.write("\t\t\t\taria-expaned=\"false\">\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<a class=\"navbar-brand\" href=\"Main.jsp\">????????????</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");

if( (String)session.getAttribute("userEmail") == null) 
 {
      out.write("\r\n");
      out.write("\t\t<div class=\"collapse navbar-collapse\"\r\n");
      out.write("\t\t\tid=\"#bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t<li><a href=\"Login.jsp\">?????????</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"Join.jsp\">????????????</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t<li>????????? ????????????</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
 }else { 
      out.write("\r\n");
      out.write("\t\t<div class=\"collapse navbar-collapse\"\r\n");
      out.write("\t\t\tid=\"#bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t<li><a href=\"BBS.jsp\">?????????</a></li>\r\n");
      out.write("\t\t\t\t<li><a>?????????</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"LogoutAction.jsp\">????????????</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t<li>");
      out.print((String)session.getAttribute("userEmail")+ "??? ????????? ???????????????." );
      out.write("</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
 }
      out.write("\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<!-- ????????? -->\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<form id=\"recipe\" method=\"post\" action=\"WriteAction.jsp\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t<table class=\"table table-striped\"\r\n");
      out.write("\t\t\t\t\tstyle=\"text-align: center; border: 1px solid #dddddd\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th colspan=\"2\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"background-color: #eeeeee; text-align: center;\">?????????\r\n");
      out.write("\t\t\t\t\t\t\t\t????????? ??????</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" class=\"form-control\" placeholder=\"??? ??????\" name=\"recipeTitle\" maxlength=\"50\"/></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"file\" class=\"form-control\" placeholder=\"??? ??????\" name=\"file\" maxlength=\"50\"/></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><textarea class=\"form-control\" placeholder=\"??? ??????\" id=\"recipeContent\" name=\"recipeContent\" maxlength=\"2048\" style=\"height: 350px;\"></textarea></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</table>\t\r\n");
      out.write("\t\t\t\t<input type=\"submit\" class=\"btn btn-primary pull-right\" id=\"save\" value=\"?????????\" /> \r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- ??????????????? ?????? JQUERY -->\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("\t<!-- ??????????????? JS  -->\r\n");
      out.write("\t<script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
