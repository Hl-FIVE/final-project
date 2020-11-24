package com.hiwork.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hiwork.domain.CInfo;
import com.hiwork.service.CInfoService;

@WebServlet("/board/list")
public class CInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    CInfoService cInfoService =
        (CInfoService) ctx.getAttribute("cInfoService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>회사정보</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>회사정보</h1>");

      List<CInfo> list = cInfoService.list();
      out.println("<table border='1'>");
      out.println("<tr>" // table row
          + "<th>법인 번호</th>" // table header
          + "<th>회사명</th>"
          + "<th>지도</th>"
          + "<th>우편번호</th>"
          + "<th>주소</th>"
          + "<th>전화번호</th>"
          + "<th>팩스번호</th>"
          + "</tr>");

      for (CInfo cInfo : list) {
        out.printf("<tr>"
            + "<td>%d</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%d</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "</tr>\n",
            cInfo.getCrNo(),
            cInfo.getcName(),
            cInfo.getMap(),
            cInfo.getPostNo(),
            cInfo.getAddr(),
            cInfo.getTel(),
            cInfo.getFax());
      }
      out.println("</table>");

    } catch (Exception e) {
      out.printf("<p>작업 처리 중 오류 발생! - %s</p>\n", e.getMessage());

      StringWriter errOut = new StringWriter();
      e.printStackTrace(new PrintWriter(errOut));

      out.printf("<pre>%s</pre>\n", errOut.toString());
    }
    out.println("</body>");
    out.println("</html>");
  }

}
