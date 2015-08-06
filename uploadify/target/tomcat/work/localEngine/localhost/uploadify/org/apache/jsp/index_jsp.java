package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');

    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\n");
      out.write("<title>Upload</title>\n");
      out.write(" \n");
      out.write("<!--装载文件-->\n");
      out.write("<link href=\"css/uploadify.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<script type=\"text/javascript\" src=\"uploadify/jquery-1.11.1.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"uploadify/jquery.uploadify.min.js\"></script>\n");
      out.write("\n");
      out.write("<!--ready事件-->\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function() {\n");
      out.write("        $(\"#uploadify\").uploadify({\n");
      out.write("            'uploader' : 'servlet/Upload',\n");
      out.write("            'swf' : 'uploadify/uploadify.swf',\n");
      out.write("            'cancelImg' : 'img/uploadify-cancel.png',\n");
      out.write("//             'folder' : 'uploads', //您想将文件保存到的路径\n");
      out.write("            'queueID' : 'fileQueue', //与下面的id对应\n");
      out.write("            'queueSizeLimit' : 5,  //当允许多文件生成时，设置选择文件的个数（就是能选择到页面中就绪的文件个数），默认值：999 。\n");
      out.write("//             'fileDesc' : 'rar文件或zip文件',  //官方文档已无此参数，这个属性值必须设置fileExt属性后才有效，用来设置选择文件对话框中的提示文本。\n");
      out.write("//             'fileExt' : '*.rar;*.zip', //官方文档已无此参数，控制可上传文件的扩展名，启用本项时需同时声明fileDesc,虽然设置的这两个但是好像都可以选\n");
      out.write("            'auto' : false, //设置为true当选择文件后就直接上传了，为false需要点击上传按钮才上传 。\n");
      out.write("            'multi' : true, //设置为true时可以上传多个文件。\n");
      out.write("//             'simUploadLimit' : 2, //官方文档已无此参数，多文件上传时，同时上传文件数目限制。默认1一次可传几个文件。\n");
      out.write("            'buttonText' : '选择文件', //默认按钮的名字。默认BROWER\n");
      out.write("//             'uploadLimit' : 2,//上传到服务器上的总文件数量限制\n");
      out.write("           \t'onDialogOpen' : function() {//当选择文件对话框打开时触发\n");
      out.write("//            \t\talert( 'Open!');\n");
      out.write("           \t},\n");
      out.write("           \t'onSelect' : function(file) {//当每个文件添加至队列后触发\n");
      out.write("//            \t\talert( 'id: ' + file.id\n");
      out.write("//            \t\t\t\t+ ' - 索引: ' + file.index\n");
      out.write("//            \t\t\t\t+ ' - 文件名: ' + file.name\n");
      out.write("//            \t\t\t\t+ ' - 文件大小: ' + file.size\n");
      out.write("//            \t\t\t\t+ ' - 类型: ' + file.type\n");
      out.write("//            \t\t\t\t+ ' - 创建日期: ' + file.creationdate\n");
      out.write("//            \t\t\t\t+ ' - 修改日期: ' + file.modificationdate\n");
      out.write("//            \t\t\t\t+ ' - 文件状态: ' + file.filestatus);\n");
      out.write("           \t},\n");
      out.write("           \t'onSelectError' : function(file,errorCode,errorMsg) {//当文件选定发生错误时触发\n");
      out.write("\t           \t\tswitch(errorCode) {\n");
      out.write("\t                case -100:\n");
      out.write("\t                    alert(\"上传的文件数量已经超出系统限制的 \"+$('#uploadFile').uploadify('settings','queueSizeLimit')+\"个文件！\");\n");
      out.write("\t                    break;\n");
      out.write("\t                case -110:\n");
      out.write("\t                    alert(\"文件 [\"+file.name+\"] 大小超出系统限制的 \"+$('#uploadFile').uploadify('settings','fileSizeLimit')+\"大小！\");\n");
      out.write("\t                    break;\n");
      out.write("\t                case -120:\n");
      out.write("\t                    alert(\"文件 [\"+file.name+\"] 大小异常！\");\n");
      out.write("\t                    break;\n");
      out.write("\t                case -130:\n");
      out.write("\t                    alert(\"文件 [\"+file.name+\"] 类型不正确！\");\n");
      out.write("\t                    break;\n");
      out.write("\t                }\n");
      out.write("//            \t\talert( 'id: ' + file.id\n");
      out.write("//            \t\t\t+ ' - 索引: ' + file.index\n");
      out.write("//            \t\t\t+ ' - 文件名: ' + file.name\n");
      out.write("//          \t\t\t+ ' - 文件大小: ' + file.size\n");
      out.write("//            \t\t\t+ ' - 类型: ' + file.type\n");
      out.write("//            \t\t\t+ ' - 创建日期: ' + file.creationdate\n");
      out.write("//            \t\t\t+ ' - 修改日期: ' + file.modificationdate\n");
      out.write("//            \t\t\t+ ' - 文件状态: ' + file.filestatus\n");
      out.write("//            \t\t\t+ ' - 错误代码: ' + errorCode\n");
      out.write("//            \t\t\t+ ' - 错误信息: ' + errorMsg);\n");
      out.write("           \t},\n");
      out.write("           \t'onDialogClose' : function(swfuploadifyQueue) {//当文件选择对话框关闭时触发\n");
      out.write("\t\t\t\tif( swfuploadifyQueue.filesErrored > 0 ){\n");
      out.write("//           \t\t\talert( '添加至队列时有'\n");
      out.write("// \t\t\t\t\t\t+swfuploadifyQueue.filesErrored\n");
      out.write("// \t           \t\t\t+'个文件发生错误n'\n");
      out.write("// \t           \t\t\t+'错误信息:'\n");
      out.write("// \t           \t\t\t+swfuploadifyQueue.errorMsg\n");
      out.write("// \t           \t\t\t+'n选定的文件数:'\n");
      out.write("// \t           \t\t\t+swfuploadifyQueue.filesSelected\n");
      out.write("// \t           \t\t\t+'n成功添加至队列的文件数:'\n");
      out.write("// \t           \t\t\t+swfuploadifyQueue.filesQueued\n");
      out.write("// \t           \t\t\t+'n队列中的总文件数量:'\n");
      out.write("// \t       \t\t\t\t+swfuploadifyQueue.queueLength);\n");
      out.write("           \t\t}\n");
      out.write("           \t},\n");
      out.write("           \t'onQueueComplete' : function(stats) {//当队列中的所有文件全部完成上传时触发\n");
      out.write("//            \t\talert( '成功上传的文件数: ' + stats.successful_uploads\n");
      out.write("//            \t\t\t+ ' - 上传出错的文件数: ' + stats.upload_errors\n");
      out.write("//            \t\t\t+ ' - 取消上传的文件数: ' + stats.upload_cancelled\n");
      out.write("//            \t\t\t+ ' - 出错的文件数' + stats.queue_errors);\n");
      out.write("           \t},\n");
      out.write("           \t'onUploadComplete' : function(file,swfuploadifyQueue) {//队列中的每个文件上传完成时触发一次\n");
      out.write("//            \t\talert( 'id: ' + file.id\n");
      out.write("//            \t\t\t+ ' - 索引: ' + file.index\n");
      out.write("//            \t\t\t+ ' - 文件名: ' + file.name\n");
      out.write("//            \t\t\t+ ' - 文件大小: ' + file.size\n");
      out.write("//            \t\t\t+ ' - 类型: ' + file.type\n");
      out.write("//            \t\t\t+ ' - 创建日期: ' + file.creationdate\n");
      out.write("//            \t\t\t+ ' - 修改日期: ' + file.modificationdate\n");
      out.write("//            \t\t\t+ ' - 文件状态: ' + file.filestatus);\n");
      out.write("           \t},\n");
      out.write("           \t'onUploadError' : function(file,errorCode,errorMsg,errorString,swfuploadifyQueue) {//上传文件出错是触发（每个出错文件触发一次）\n");
      out.write("//            \t\talert( 'id: ' + file.id\n");
      out.write("//            \t\t\t+ ' - 索引: ' + file.index\n");
      out.write("//            \t\t\t+ ' - 文件名: ' + file.name\n");
      out.write("//            \t\t\t+ ' - 文件大小: ' + file.size\n");
      out.write("//            \t\t\t+ ' - 类型: ' + file.type\n");
      out.write("//            \t\t\t+ ' - 创建日期: ' + file.creationdate\n");
      out.write("//            \t\t\t+ ' - 修改日期: ' + file.modificationdate\n");
      out.write("//            \t\t\t+ ' - 文件状态: ' + file.filestatus\n");
      out.write("//            \t\t\t+ ' - 错误代码: ' + errorCode\n");
      out.write("//            \t\t\t+ ' - 错误描述: ' + errorMsg\n");
      out.write("//            \t\t\t+ ' - 简要错误描述: ' + errorString);\n");
      out.write("           \t},\n");
      out.write("           \t'onUploadProgress' : function(file,fileBytesLoaded,fileTotalBytes,queueBytesLoaded,swfuploadifyQueueUploadSize) {//上传进度发生变更时触发\n");
      out.write("//            \t\talert( 'id: ' + file.id\n");
      out.write("//            \t\t\t+ ' - 索引: ' + file.index\n");
      out.write("//            \t\t\t+ ' - 文件名: ' + file.name\n");
      out.write("//            \t\t\t+ ' - 文件大小: ' + file.size\n");
      out.write("//            \t\t\t+ ' - 类型: ' + file.type\n");
      out.write("//            \t\t\t+ ' - 创建日期: ' + file.creationdate\n");
      out.write("//            \t\t\t+ ' - 修改日期: ' + file.modificationdate\n");
      out.write("//            \t\t\t+ ' - 文件状态: ' + file.filestatus\n");
      out.write("//            \t\t\t+ ' - 当前文件已上传: ' + fileBytesLoaded\n");
      out.write("//            \t\t\t+ ' - 当前文件大小: ' + fileTotalBytes\n");
      out.write("//            \t\t\t+ ' - 队列已上传: ' + queueBytesLoaded\n");
      out.write("//            \t\t\t+ ' - 队列大小: ' + swfuploadifyQueueUploadSize);\n");
      out.write("           \t},\n");
      out.write("           \t'onUploadStart': function(file) {//上传开始时触发（每个文件触发一次）\n");
      out.write("//            \t\talert( 'id: ' + file.id\n");
      out.write("//            \t\t\t+ ' - 索引: ' + file.index\n");
      out.write("//            \t\t\t+ ' - 文件名: ' + file.name\n");
      out.write("//            \t\t\t+ ' - 文件大小: ' + file.size\n");
      out.write("//            \t\t\t+ ' - 类型: ' + file.type\n");
      out.write("//            \t\t\t+ ' - 创建日期: ' + file.creationdate\n");
      out.write("//            \t\t\t+ ' - 修改日期: ' + file.modificationdate\n");
      out.write("//            \t\t\t+ ' - 文件状态: ' + file.filestatus );\n");
      out.write("           \t},\n");
      out.write("           \t'onUploadSuccess' : function(file,data,response) {//上传完成时触发（每个文件触发一次）\n");
      out.write("//            \t\talert( 'id: ' + file.id\n");
      out.write("//            \t\t\t+ ' - 索引: ' + file.index\n");
      out.write("//            \t\t\t+ ' - 文件名: ' + file.name\n");
      out.write("//            \t\t\t+ ' - 文件大小: ' + file.size\n");
      out.write("//            \t\t\t+ ' - 类型: ' + file.type\n");
      out.write("//            \t\t\t+ ' - 创建日期: ' + file.creationdate\n");
      out.write("//            \t\t\t+ ' - 修改日期: ' + file.modificationdate\n");
      out.write("//            \t\t\t+ ' - 文件状态: ' + file.filestatus\n");
      out.write("//            \t\t\t+ ' - 服务器端消息: ' + data\n");
      out.write("//            \t\t\t+ ' - 是否上传成功: ' + response);\n");
      out.write("           \t}\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write(" \n");
      out.write("<body>\n");
      out.write("    <div id=\"fileQueue\"></div>\n");
      out.write("    <input type=\"file\" name=\"uploadify\" id=\"uploadify\" />\n");
      out.write("    <p>\n");
      out.write("    \t<!-- 上传第一个未上传的文件 -->\n");
      out.write("      \t<a href=\"javascript:$('#uploadify').uploadify('upload')\">上传</a>\n");
      out.write("      \t<!-- 取消第一个未取消的文件 -->\n");
      out.write("        <a href=\"javascript:$('#uploadify').uploadify('cancel')\">取消上传</a>\n");
      out.write("        \n");
      out.write("        <a href=\"javascript:$('#uploadify').uploadify('upload','*')\">开始上传所有文件</a>&nbsp;\n");
      out.write("        <a href=\"javascript:$('#uploadify').uploadify('cancel','*')\">取消所有上传</a>\n");
      out.write("    </p>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
