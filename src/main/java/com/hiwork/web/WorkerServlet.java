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
import com.hiwork.domain.Worker;
import com.hiwork.service.WorkerService;

@WebServlet("/worker/list")
public class WorkerServlet extends HttpServlet {
  private static final long serialVersionUID = 1;

  @Override 
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    WorkerService workerService =
        (WorkerService) ctx.getAttribute("workerService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>직원 목록</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>직원 목록</h1>");

      List<Worker> list = workerService.list();

      out.println("<table border='1'>");
      out.println("<thead><tr>"
          + "<th>번호</th>"
          + "<th>이름</th>"
          + "<th>이메일</th>"
          + "<th>직급</th>"
          + "<th>고용형태</th>"
          + "<th>입사일</th>"
          + "<th>휴대폰번호</th>"
          + "<th>성별</th>"
          + "<th>재직상태</th>"
          + "</tr></thead>");

      for (Worker worker : list) {
        out.printf("<tr>"
            + "<th>%d</th>"
            + "<th>%s</th>"
            + "<th>%s</th>"
            + "<th>%s</th>"
            + "<th>%s</th>"
            + "<th>%s</th>"
            + "<th>%d</th>"
            + "<th>%d</th?>"
            + "<th>%d<th>"
            + "</tr>\n",
            worker.getwNo(),
            worker.getwName(),
            worker.getEmail(),
            worker.geteType(),
            worker.getRank(),
            worker.getRegiDate(),
            worker.getTel(),
            worker.getGender(),
            worker.geteSt());
      }
      out.println("</tbody>");
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
