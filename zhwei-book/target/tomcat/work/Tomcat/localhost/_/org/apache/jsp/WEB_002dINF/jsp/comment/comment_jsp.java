/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-01-23 11:05:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.comment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class comment_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script src=\"/js/hm.js\"></script><script src=\"/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script>var n = 1;</script>\r\n");
      out.write("<script src=\"/js/m.js\"></script>\r\n");
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
      out.write("<!--end nav-->\r\n");
      out.write("<div class=\"container m0 bod top70\" id=\"zt\">\r\n");
      out.write("         <div class=\"col-lg-9 col-md-12 col-sm-12\">\r\n");
      out.write("\r\n");
      out.write("             <div class=\"project\">\r\n");
      out.write("               <div class=\"project-content\">\r\n");
      out.write("                     \r\n");
      out.write("                    \r\n");
      out.write("                              <div class=\"pl  \">\r\n");
      out.write("                                \t<div class=\"tx\"><a href=\"http://www.jq22.com/mem249580\"><img src=\"/image/55.png\"></a></div>\r\n");
      out.write("                                \t<ul class=\"plbg\">\r\n");
      out.write("                                    \t<div class=\"f z13\"> ???? ??<span class=\"jl\">0</span></div>\r\n");
      out.write("                                        <div class=\"r\"> <span class=\"z13\">2018/1/5 16:52:49</span></div>\r\n");
      out.write("                                        <div class=\"dr\"></div>\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("                                    <ul class=\"plul\">\r\n");
      out.write("                                    这么贵的吗\r\n");
      out.write("                                        \r\n");
      out.write("                                            \r\n");
      out.write("                                          <a class=\"hf\" name=\"50520\">回复</a>\r\n");
      out.write("                                          <div class=\"lyhf\"></div>\r\n");
      out.write("                                           \r\n");
      out.write("                                         <div class=\"dr\"></div>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                 </div>\r\n");
      out.write("                     <h4 name=\"a1\">讨论这个项目()61)</h4>\r\n");
      out.write("                        <div class=\"in2\">\r\n");
      out.write("                            <div id=\"err\" class=\"alert alert-danger\" role=\"alert\" style=\"display:none\"><i class=\"fa fa-smile-o\"></i> 登录后才可以评论</div>\r\n");
      out.write("                            <div class=\"wangEditor-container\"><div class=\"wangEditor-btn-container clearfix\"><div class=\"wangEditor-btn-container-group\"><div class=\"wangEditor-toolTip\"><div class=\"wangEditor-toolTip-content\">插入代码</div></div><a class=\"wangEditor-btn-container-btn wangEditor-btn-container-btn-default\" href=\"http://www.jq22.com/message12048#\" title=\"\"><i class=\"icon-wangEditor-terminal\"></i></a><div class=\"wangEditor-toolTip\"><div class=\"wangEditor-toolTip-content\">加粗</div></div><a class=\"wangEditor-btn-container-btn wangEditor-btn-container-btn-default\" href=\"http://www.jq22.com/message12048#\" title=\"\" commandname=\"bold\"><i class=\"icon-wangEditor-bold\"></i></a></div><div class=\"wangEditor-btn-container-group\"><div class=\"wangEditor-toolTip\"><div class=\"wangEditor-toolTip-content\">列表</div></div><ul class=\"wangEditor-drop-menu\" style=\"display: none;\"><li><a href=\"http://www.jq22.com/message12048#\" customcommandname=\"InsertUnorderedList\"><i class=\"icon-wangEditor-list-bullet\"> 无序列表</i></a></li><li><a href=\"http://www.jq22.com/message12048#\" customcommandname=\"InsertOrderedList\"><i class=\"icon-wangEditor-list-numbered\"> 有序列表</i></a></li></ul><a class=\"wangEditor-btn-container-btn wangEditor-btn-container-btn-default\" href=\"http://www.jq22.com/message12048#\" title=\"\"><i class=\"icon-wangEditor-list-bullet\"></i><i class=\"icon-wangEditor-angle-down\" style=\"margin-left:3px;\"></i></a><div class=\"wangEditor-toolTip\"><div class=\"wangEditor-toolTip-content\">对齐</div></div><ul class=\"wangEditor-drop-menu\" style=\"display: none;\"><li><a href=\"http://www.jq22.com/message12048#\" customcommandname=\"JustifyLeft\"><i class=\"icon-wangEditor-align-left\"> 左对齐</i></a></li><li><a href=\"http://www.jq22.com/message12048#\" customcommandname=\"JustifyCenter\"><i class=\"icon-wangEditor-align-center\"> 居中</i></a></li><li><a href=\"http://www.jq22.com/message12048#\" customcommandname=\"JustifyRight\"><i class=\"icon-wangEditor-align-right\"> 右对齐</i></a></li></ul><a class=\"wangEditor-btn-container-btn wangEditor-btn-container-btn-default\" href=\"http://www.jq22.com/message12048#\" title=\"\"><i class=\"icon-wangEditor-align-left\"></i><i class=\"icon-wangEditor-angle-down\" style=\"margin-left:3px;\"></i></a></div><div class=\"wangEditor-btn-container-group\"><div class=\"wangEditor-toolTip\"><div class=\"wangEditor-toolTip-content\">横线</div></div><a class=\"wangEditor-btn-container-btn wangEditor-btn-container-btn-default\" href=\"http://www.jq22.com/message12048#\" title=\"\" commandname=\"InsertHorizontalRule\"><i class=\"icon-wangEditor-minus\"></i></a><div class=\"wangEditor-toolTip\"><div class=\"wangEditor-toolTip-content\">撤销</div></div><a class=\"wangEditor-btn-container-btn wangEditor-btn-container-btn-default\" href=\"http://www.jq22.com/message12048#\" title=\"\" commandname=\"commonUndo\"><i class=\"icon-wangEditor-ccw\"></i></a></div></div><div class=\"wangEditor-textarea-container\" style=\"height: 151px;\"><div class=\"wangEditor-textarea\" contenteditable=\"true\" style=\"min-height: 141px;\"><p><br></p></div></div><a href=\"http://www.jq22.com/message12048#\" class=\"wangEditor-elemDeleteBtn\"><i class=\"icon-wangEditor-cancel\"></i></a><div class=\"wangEditor-imgResize\"></div></div><textarea id=\"textarea1\" style=\"height: 200px; width: 100%; display: none;\"></textarea>\r\n");
      out.write("                            \r\n");
      out.write("                            <div class=\"r top10\">\r\n");
      out.write("                            <button onclick=\"getPlainTxt()\" type=\"button\" id=\"myButton\" data-loading-text=\"Loading...\" class=\"btn btn-primary\" autocomplete=\"off\">\r\n");
      out.write("                              发表评论\r\n");
      out.write("                            </button>\r\n");
      out.write("                            \r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"dr\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"huif\">\r\n");
      out.write("                             \r\n");
      out.write("                             <div class=\"wangEditor-container\"><div class=\"wangEditor-btn-container clearfix\"><div class=\"wangEditor-btn-container-group\"><div class=\"wangEditor-toolTip\"><div class=\"wangEditor-toolTip-content\">插入代码</div></div><a class=\"wangEditor-btn-container-btn wangEditor-btn-container-btn-default\" href=\"http://www.jq22.com/message12048#\" title=\"\"><i class=\"icon-wangEditor-terminal\"></i></a><div class=\"wangEditor-toolTip\"><div class=\"wangEditor-toolTip-content\">加粗</div></div><a class=\"wangEditor-btn-container-btn wangEditor-btn-container-btn-default\" href=\"http://www.jq22.com/message12048#\" title=\"\" commandname=\"bold\"><i class=\"icon-wangEditor-bold\"></i></a></div><div class=\"wangEditor-btn-container-group\"><div class=\"wangEditor-toolTip\"><div class=\"wangEditor-toolTip-content\">列表</div></div><ul class=\"wangEditor-drop-menu\" style=\"display: none;\"><li><a href=\"http://www.jq22.com/message12048#\" customcommandname=\"InsertUnorderedList\"><i class=\"icon-wangEditor-list-bullet\"> 无序列表</i></a></li><li><a href=\"http://www.jq22.com/message12048#\" customcommandname=\"InsertOrderedList\"><i class=\"icon-wangEditor-list-numbered\"> 有序列表</i></a></li></ul><a class=\"wangEditor-btn-container-btn wangEditor-btn-container-btn-default\" href=\"http://www.jq22.com/message12048#\" title=\"\"><i class=\"icon-wangEditor-list-bullet\"></i><i class=\"icon-wangEditor-angle-down\" style=\"margin-left:3px;\"></i></a><div class=\"wangEditor-toolTip\"><div class=\"wangEditor-toolTip-content\">对齐</div></div><ul class=\"wangEditor-drop-menu\" style=\"display: none;\"><li><a href=\"http://www.jq22.com/message12048#\" customcommandname=\"JustifyLeft\"><i class=\"icon-wangEditor-align-left\"> 左对齐</i></a></li><li><a href=\"http://www.jq22.com/message12048#\" customcommandname=\"JustifyCenter\"><i class=\"icon-wangEditor-align-center\"> 居中</i></a></li><li><a href=\"http://www.jq22.com/message12048#\" customcommandname=\"JustifyRight\"><i class=\"icon-wangEditor-align-right\"> 右对齐</i></a></li></ul><a class=\"wangEditor-btn-container-btn wangEditor-btn-container-btn-default\" href=\"http://www.jq22.com/message12048#\" title=\"\"><i class=\"icon-wangEditor-align-left\"></i><i class=\"icon-wangEditor-angle-down\" style=\"margin-left:3px;\"></i></a></div><div class=\"wangEditor-btn-container-group\"><div class=\"wangEditor-toolTip\"><div class=\"wangEditor-toolTip-content\">横线</div></div><a class=\"wangEditor-btn-container-btn wangEditor-btn-container-btn-default\" href=\"http://www.jq22.com/message12048#\" title=\"\" commandname=\"InsertHorizontalRule\"><i class=\"icon-wangEditor-minus\"></i></a><div class=\"wangEditor-toolTip\"><div class=\"wangEditor-toolTip-content\">撤销</div></div><a class=\"wangEditor-btn-container-btn wangEditor-btn-container-btn-default\" href=\"http://www.jq22.com/message12048#\" title=\"\" commandname=\"commonUndo\"><i class=\"icon-wangEditor-ccw\"></i></a></div></div><div class=\"wangEditor-textarea-container\" style=\"height: 142px;\"><div class=\"wangEditor-textarea\" contenteditable=\"true\" style=\"min-height: 132px;\"><p><br></p></div></div><a href=\"http://www.jq22.com/message12048#\" class=\"wangEditor-elemDeleteBtn\"><i class=\"icon-wangEditor-cancel\"></i></a><div class=\"wangEditor-imgResize\"></div></div><textarea id=\"textarea2\" style=\"height: 150px; width: 100%; display: none;\"></textarea>\r\n");
      out.write("                             <button onclick=\"hftj()\" type=\"button\" class=\"btn btn-primary top10\">回复</button>\r\n");
      out.write("                            <a class=\"qxhf\" onclick=\"qx()\">取消回复</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("               </div>\r\n");
      out.write("         </div>\r\n");
      out.write("        \r\n");
      out.write("</div>\r\n");
      out.write("    <div class=\"col-lg-2 visible-lg \" style=\"width:200px\">\r\n");
      out.write("                <div class=\"df\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"itop\"></div>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/shCore.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/shBrushXml.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">SyntaxHighlighter.all();</script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/wangEditor.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\">\r\n");
      out.write("    function GetQueryString(name) {\r\n");
      out.write("        var reg = new RegExp(\"(^|&)\" + name + \"=([^&]*)(&|$)\", \"i\");\r\n");
      out.write("        var r = window.location.search.substr(1).match(reg);\r\n");
      out.write("        if (r != null) return (r[2]); return null;\r\n");
      out.write("    }\r\n");
      out.write("    if (GetQueryString(\"pl\") == \"y\") {\r\n");
      out.write("        $(\"html,body\").animate({ scrollTop: $(\".y\").offset().top - 160 }, 1000);\r\n");
      out.write("    }\r\n");
      out.write("    $(\".wen\").each(function () {\r\n");
      out.write("        $(this).html($(this).html().substr(0, 65));\r\n");
      out.write("        $(this).html($(this).html().replace(\"<p>\", \"\"))\r\n");
      out.write("    });\r\n");
      out.write("    $(\".jl\").each(function () {\r\n");
      out.write("        if ($(this).text() != \"0\") {\r\n");
      out.write("            $(this).parent().parent().parent().css(\"border\", \"1px solid #93d0a8\");\r\n");
      out.write("        }      \r\n");
      out.write("    });\r\n");
      out.write("    $(\".y\").each(function () {\r\n");
      out.write("        $(this).children(\"ul\").children(\".r\").prepend(\"<span style='color:#AC4648;font-size: 14px'>回答有奖</span>\");\r\n");
      out.write("    });\r\n");
      out.write("    $(\"#seobut\").click(function () { var seo = $(\"#searchtxt\").val(); if (seo.length > 1) { window.location.href = \"search?seo=\" + seo; } });\r\n");
      out.write("    $('#searchtxt').bind('keypress', function (event) { if (event.keyCode == \"13\") { var seo = $(\"#searchtxt\").val(); if (seo.length > 1) { window.location.href = \"search?seo=\" + seo; } } });\r\n");
      out.write("    $(function () {\r\n");
      out.write("        var editor = $('#textarea1').wangEditor({\r\n");
      out.write("            'menuConfig': [\r\n");
      out.write("\t\t\t\t['insertCode', 'bold'],\r\n");
      out.write("\t\t\t\t['list', 'justify'],\r\n");
      out.write("\t\t\t\t['insertHr', 'undo']\r\n");
      out.write("            ]\r\n");
      out.write("        });\r\n");
      out.write("        var editor2 = $('#textarea2').wangEditor({\r\n");
      out.write("            'menuConfig': [\r\n");
      out.write("\t\t\t\t['insertCode', 'bold'],\r\n");
      out.write("\t\t\t\t['list', 'justify'],\r\n");
      out.write("\t\t\t\t['insertHr', 'undo']\r\n");
      out.write("            ]\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("    var a = \"12048\";\r\n");
      out.write("    var b = \"333534\";\r\n");
      out.write("    var lytjbut = document.getElementById('myButton');\r\n");
      out.write("    function getPlainTxt() {\r\n");
      out.write("        if ($('#textarea1').val().length > 5) {\r\n");
      out.write("            lytjbut.disabled = true;\r\n");
      out.write("        }\r\n");
      out.write("        setTimeout(function () {        \r\n");
      out.write("            var k=\"n\";\r\n");
      out.write("            if(k!=\"n\"){\r\n");
      out.write("                myLogin($('#textarea1').val());\r\n");
      out.write("            }\r\n");
      out.write("            else\r\n");
      out.write("            {\r\n");
      out.write("                $(\"#err\").css(\"display\", \"block\");\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("        }, 1000);        \r\n");
      out.write("    }\r\n");
      out.write("    var pid;\r\n");
      out.write("    $(\".hf\").click(function () {\r\n");
      out.write("        pid=$(this).attr(\"name\");\r\n");
      out.write("        $(\".hf\").css(\"padding-bottom\", \"10px\");\r\n");
      out.write("        $(\".huif\").css({ \"top\": $(this).offset().top -30, \"display\": \"block\" });\r\n");
      out.write("        $(this).css(\"padding-bottom\", \"255px\");\r\n");
      out.write("    });\r\n");
      out.write("    function qx() {\r\n");
      out.write("        $(\".hf\").css(\"padding-bottom\", \"10px\");\r\n");
      out.write("        $(\".huif\").css(\"display\", \"none\");\r\n");
      out.write("    }\r\n");
      out.write("    function hftj() {\r\n");
      out.write("        var jhf = document.getElementById(\"textarea2\").value;\r\n");
      out.write("        jhf = jhf.replace(/<(script)[\\S\\s]*?\\1>|style\\=\".+?\"|title\\=\".+?\"|class\\=\".+?\"/gi, \"\");\r\n");
      out.write("        jhf = jhf.replace(/<p><br><\\/p>|<p><\\/p>/gi, \"\");\r\n");
      out.write("        jhf = jhf.replace(/<\\/?([a-o]|[q-s]|[u-z])[^>]*>/gi, \"\");\r\n");
      out.write("        jhf = jhf.replace(/<\\/?(textarea)[^>]*>/gi, \"\");\r\n");
      out.write("        var hfHTML = encodeURIComponent(jhf);\r\n");
      out.write("        if (hfHTML.length > 5) {\r\n");
      out.write("            var h = $.ajax({\r\n");
      out.write("                type: 'post',\r\n");
      out.write("                url: '/fyadd.aspx',\r\n");
      out.write("                data: { yy: pid, nr:hfHTML, ww:a},\r\n");
      out.write("                cache: false,\r\n");
      out.write("                dataType: 'text',\r\n");
      out.write("                success: function (data){\r\n");
      out.write("                    if (data == \"y\") {\r\n");
      out.write("                        window.location.reload();\r\n");
      out.write("                    } else {\r\n");
      out.write("                        $(\"#err2\").css(\"display\", \"block\");\r\n");
      out.write("                        $(\"#err2\").addClass(\"dou2\");\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                error: function () { }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    function myLogin(aa) {\r\n");
      out.write("        var jhf = aa;\r\n");
      out.write("        jhf = jhf.replace(/<(script)[\\S\\s]*?\\1>|style\\=\".+?\"|title\\=\".+?\"|class\\=\".+?\"/gi, \"\");\r\n");
      out.write("        jhf = jhf.replace(/<p><br><\\/p>|<p><\\/p>/gi, \"\");\r\n");
      out.write("        jhf = jhf.replace(/<\\/?([a-o]|[q-s]|[u-z])[^>]*>/gi, \"\");\r\n");
      out.write("        jhf = jhf.replace(/<\\/?(textarea)[^>]*>/gi, \"\");\r\n");
      out.write("        var encodeHTML = encodeURIComponent(jhf);\r\n");
      out.write("        if (aa.length > 3) {\r\n");
      out.write("            var yz = $.ajax({\r\n");
      out.write("                type: 'post',\r\n");
      out.write("                url: '/lyadd.aspx',\r\n");
      out.write("                data: { wz: a, nr: encodeHTML, zz: b },\r\n");
      out.write("                cache: false,\r\n");
      out.write("                dataType: 'text',\r\n");
      out.write("                success: function (data) {\r\n");
      out.write("                    if (data == \"y\") {                        \r\n");
      out.write("                        window.location.href = window.location.href;\r\n");
      out.write("                    } else {\r\n");
      out.write("                        $(\"#err2\").css(\"display\", \"block\");\r\n");
      out.write("                        $(\"#err2\").addClass(\"dou2\");\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                error: function () { }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    }  \r\n");
      out.write("    function fbcj() {\r\n");
      out.write("        yh = \"n\";\r\n");
      out.write("        if (yh != \"\") {\r\n");
      out.write("            window.location.href = \"jquerySubmit.aspx\";\r\n");
      out.write("        } else {\r\n");
      out.write("            $(\"#myModal\").modal();\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    $(\".jl\").each(function () {\r\n");
      out.write("        if ($(this).text() > 0) {\r\n");
      out.write("            $(this).css('display', 'inline-block');\r\n");
      out.write("            $(this).html(\"评论奖励 \" + $(this).text() + \" jQ币\");\r\n");
      out.write("            $(this).parent().parent().parent()\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("    var str_before;\r\n");
      out.write("\tvar str_after;\r\n");
      out.write("\t\tfunction getStr(string,str){\r\n");
      out.write("\t\t  str_before = string.split(str)[0];\r\n");
      out.write("\t\t  str_after = string.split(str)[1];\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tgetStr(window.location.href, \"message\");\r\n");
      out.write("\t\t$(\".col-lg-2 a\").each(function () {\r\n");
      out.write("\t\t    var tempStr = $(this).attr('href');\r\n");
      out.write("\t\t    var bool = tempStr.indexOf(str_after);\r\n");
      out.write("\t\t    if (bool > 0) {\r\n");
      out.write("\t\t        $(this).css(\"color\", \"#009fff\");\r\n");
      out.write("\t\t        $(this).css(\"font-weight\", \"bold\");\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(function () { var e = $(\".itop\"); $(window).scroll(function () { var t = $(document).scrollTop(); if (t > 300) { e.fadeIn(\"slow\") } else { e.fadeOut(\"slow\") } }); e.click(function () { $(\"html,body\").animate({ scrollTop: 0 }, 500) }) });\r\n");
      out.write("</script>\r\n");
      out.write("<!--底部--><script>\r\n");
      out.write("    var _hmt = _hmt || [];\r\n");
      out.write("    (function () {\r\n");
      out.write("        var hm = document.createElement(\"script\");\r\n");
      out.write("        hm.src = \"//hm.baidu.com/hm.js?b3a3fc356d0af38b811a0ef8d50716b8\";\r\n");
      out.write("        var s = document.getElementsByTagName(\"script\")[0];\r\n");
      out.write("        s.parentNode.insertBefore(hm, s);\r\n");
      out.write("    })();\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write(" \t\r\n");
      out.write("</body></html>");
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
