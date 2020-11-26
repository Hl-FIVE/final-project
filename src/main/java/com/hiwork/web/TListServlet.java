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
import com.hiwork.domain.TList;
import com.hiwork.service.TListService;

@WebServlet("/tlist/list")
public class TListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    TListService tListService =
        (TListService) ctx.getAttribute("tListService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<style>"
        + "#header{background-color:navy;color:white;padding: 2px 10px}"
        + "#footer{background-color:gray;color:white;padding: 10px}</style>");
    out.println("<title>팀 목록</title></head>");
    out.println("<body>");
    try {
      out.println("<div id=header><h1>팀 목록</h1></div>");

      List<TList> list = tListService.list();
      out.println("<table border='1'>");
      out.println("<tr>"
          + "<th>팀 코드</th>"
          + "<th>법인등록번호</th>"
          + "<th>팀 부서</th>"
          + "</tr>");

      for (TList tList : list) {
        out.printf("<tr>"
            + "<td>%s</td>"
            + "<td>%d</td>"
            + "<td>%s</td>"
            + "</tr>\n",
            tList.gettCode(),
            tList.getCrNo(),
            tList.gettName());
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
