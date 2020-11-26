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
    out.println("<head><title>회원 목록</title></head>");

    try {
      List<Worker> list = workerService.list();
      out.println("번호, 이름, 이메일, 직급, 고용형태, 입사일, 휴대폰번호, 성별, 재직상태");
      
      for (Worker worker : list) {
        out.printf("%d, %s, %s, %s, %s, %s, %d, %d, %d\n",
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
