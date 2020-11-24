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
import com.hiwork.domain.Board2;
import com.hiwork.service.BoardService2;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    BoardService2 boardService =
        (BoardService2) ctx.getAttribute("boardService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>게시글목록</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>게시물 목록</h1>");

      List<Board2> list = boardService.list();
      out.println("<table border='1'>");
      out.println("<tr>" // table row
          + "<th>번호</th>" // table header
          + "<th>제목</th>"
          + "<th>작성자</th>"
          + "<th>등록일</th>"
          + "<th>조회수</th>"
          + "</tr>");

      for (Board2 board : list) {
        out.printf("<tr>"
            + "<td>%d</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%d</td>"
            + "</tr>\n",
            board.getNo(),
            board.getTitle(),
            board.getWriter().getName(),
            board.getRegisteredDate(),
            board.getViewCount());
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
