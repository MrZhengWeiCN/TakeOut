/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-01-22 13:40:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.comment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class Newcomment_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!-- saved from url=(0032)http://www.jq22.com/message12048 -->\r\n");
      out.write("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write(" <title>评论:很有创意的轻量级HTML模板</title>\r\n");
      out.write("<meta name=\"description\" content=\"整站响应式HTML模版，效果超棒！\"> \r\n");
      out.write("<meta name=\"keywords\" content=\"模版HTML自适应兼容，jquery,jquery插件\">\r\n");
      out.write("\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("<link href=\"/css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("<link href=\"/css/font-awesome.min.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/wangEditor.css\">\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"/css/shCoreEclipse.css\">\r\n");
      out.write(" <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/pifu.css\">\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write(" \t<script src=\"/js/respond.min.js\"></script> \r\n");
      out.write("\t<script src=\"/js/html5shiv.min.js\"></script>    \r\n");
      out.write("<![endif]-->\r\n");
      out.write("<link href=\"/css/my.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("<link href=\"/css/dl.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("<!-- <script src=\"/js/hm.js.下载\"></script><script src=\"/js/jquery.min.js.下载\"></script>\r\n");
      out.write("<script src=\"/js/bootstrap.min.js.下载\"></script>\r\n");
      out.write("<script>var n = 1;</script>\r\n");
      out.write("<script src=\"/css/m.js.下载\"></script> -->\r\n");
      out.write(" <style>\r\n");
      out.write("     .project-header p {line-height:30px}\r\n");
      out.write("     .project-header h1 {line-height:50px}\r\n");
      out.write("     .project-content {padding-right: 3.1%;padding-left: 3.1%;background-color: #fff;padding-top: 10px;}\r\n");
      out.write("     .pl .plul{word-wrap: break-word;width: 100%;padding-top:10px; padding-bottom:10px; font-size:14px;background-color: #fafafa;}\r\n");
      out.write("     .z13 {font-size:13px }\r\n");
      out.write("     .plbg { background-color: #fafafa;border-bottom: 1px dotted #DCDCDC;}\r\n");
      out.write("     .pl {  padding: 0px; }\r\n");
      out.write("     a {color: #000;text-decoration: none; }\r\n");
      out.write("       a:hover {color: #337ab7;text-decoration: none; }\r\n");
      out.write("     .project-header .yw {color:#009ade}\r\n");
      out.write("     .in100, .in2,.huif  {border-top: 0px}\r\n");
      out.write("     .huif {padding-top:0px}\r\n");
      out.write("     .y { animation-delay:2s;animation:move 3s infinite;}\r\n");
      out.write("     @keyframes move{\r\n");
      out.write("        0%{ border: 1px solid #e8e8e8; }\r\n");
      out.write("        50%{ border: 1px solid #f96c65; }\r\n");
      out.write("        100%{ border: 1px solid #e8e8e8; }\r\n");
      out.write("     }\r\n");
      out.write("     .zuo h4 { line-height:36px;font-size:16px;font-weight:bold}\r\n");
      out.write("     .zuo a { display:block;line-height:26px;overflow: hidden;text-overflow:ellipsis;white-space: nowrap;}\r\n");
      out.write("     .project-header2 {width:921px; border-bottom: 1px solid #e8e8e8; border-radius: 3px 3px 0 0;border-top: 1px solid #fff;height: auto;margin: auto;padding: 20px 25px 0;z-index:9;background-color:#fff}\r\n");
      out.write("     .affix-top {top:121px}\r\n");
      out.write("     .adcssb {border:1px solid #93d0a8}\r\n");
      out.write("     .foot a{color: #337ab7}\r\n");
      out.write(" </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body data-spy=\"scroll\" data-target=\".navbar-example\" style=\"background-color: rgb(244, 244, 244);\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container m0 bod top70\" id=\"zt\">\r\n");
      out.write("         <div class=\"col-lg-9 col-md-12 col-sm-12\">\r\n");
      out.write("\r\n");
      out.write("             <div class=\"project\">\r\n");
      out.write("               <div class=\"project-content\">\r\n");
      out.write("                 <div class=\"pl  \">\r\n");
      out.write("                   \t <div class=\"tx\"><img src=\"/image/24.png\"></a></div>\r\n");
      out.write("                                \t<ul class=\"plbg\">\r\n");
      out.write("                                    \t<div class=\"f z13\">    66   酱<span class=\"jl\">0</span></div>\r\n");
      out.write("                                        <div class=\"r\"> <span class=\"z13\">2017/10/24 11:14:02</span></div>\r\n");
      out.write("                                        <div class=\"dr\"></div>\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("                                    <ul class=\"plul\">\r\n");
      out.write("                                    <p>有偿收一份~ 谢谢大神~ 274015023</p>\r\n");
      out.write("<ul>\r\n");
      out.write("                <div class=\"pl \">\r\n");
      out.write("                                                    <div class=\"tx tx2\"><a href=\"http://www.jq22.com/mem583001\"><img\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tsrc=\"/image/0.png\"> </a></div>\r\n");
      out.write("                                                    <ul class=\"plbg plbg2\">\r\n");
      out.write("                                    \t                <div class=\"f\"> 流景扬辉<span class=\"jl\">0</span></div>\r\n");
      out.write("                                                        <div class=\"r\"> <span class=\"z12\">2017/11/2 14:04:49</span></div>\r\n");
      out.write("                                                        <div class=\"dr\"></div>\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t                </ul>\r\n");
      out.write("                                                    <ul style=\"padding-top: 10px; padding-bottom: 10px;word-wrap: break-word;width: 100%\">\r\n");
      out.write("                                                         <p>斯蒂芬</p>\r\n");
      out.write("                                                    </ul>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                             </ul>\r\n");
      out.write("                                            \r\n");
      out.write("                                            \r\n");
      out.write("                                          <a class=\"hf\" name=\"45517\">回复</a>\r\n");
      out.write("                                          <div class=\"lyhf\"></div>\r\n");
      out.write("                                           \r\n");
      out.write("                                         <div class=\"dr\"></div>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </div>\r\n");
      out.write("                 <h4 name=\"a1\">讨论这个项目</h4>\r\n");
      out.write("                        \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("</div></body></html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}