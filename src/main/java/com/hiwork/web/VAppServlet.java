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
import com.hiwork.domain.VApp;
import com.hiwork.service.VAppService;

@WebServlet("/vapp/list")
public class VAppServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    VAppService vAppService =
        (VAppService) ctx.getAttribute("vAppService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<style>"
        + "#header{background-color:navy;color:white;padding: 2px 10px}"
        + "#footer{background-color:gray;color:white;padding: 10px}</style>");
    out.println("<title>휴가신청</title></head>");
    out.println("<body>");
    try {
      out.println("<div id=header><h1>휴가신청</h1></div>");

      List<VApp> list = vAppService.list();
      out.println("<table border='1'>");
      out.println("<tr>"
          + "<th>휴가 신청 번호</th>"
          + "<th>휴가 코드</th>"
          + "<th>사원 번호</th>"
          + "<th>신청일/th>"
          + "<th>시작일</th>"
          + "<th>종료일</th>"
          + "<th>사용 연차일수</th>"
          + "<th>신청 사유</th>"
          + "<th>승인 여부</th>"
          + "</tr>");

      for (VApp vApp : list) {
        out.printf("<tr>"
            + "<td>%d</td>"
            + "<td>%s</td>"
            + "<td>%d</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%d</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "</tr>\n",
            vApp.getvNo(),
            vApp.getvCode(),
            vApp.getwNo(),
            vApp.getAdt(),
            vApp.getSdt(),
            vApp.getEdt(),
            vApp.getUsed(),
            vApp.getRs(),
            vApp.getAppr());
      }
      out.println("</table>");
      out.println("<div id=footer><span>Copyright2020.하이워크.All rights reserved.</span></footer>");
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
