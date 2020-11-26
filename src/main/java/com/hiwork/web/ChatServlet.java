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
import com.hiwork.domain.Chat;
import com.hiwork.service.ChatService;

@WebServlet("/chat/list")
public class ChatServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    ChatService chatService =
        (ChatService) ctx.getAttribute("chatService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<style>"
        + "#header{background-color:navy;color:white;padding: 2px 10px}"
        + "#footer{background-color:gray;color:white;padding: 10px}</style>");
    out.println("<title>대화</title></head>");
    out.println("<body>");
    try {
      out.println("<div id=header><h1>대화 목록</h1></div>");

      List<Chat> list = chatService.list();
      out.println("<table border='1'>");
      out.println("<tr>" // table row
          + "<th>대화 번호</th>" // table header
          + "<th>사원 번호</th>"
          + "<th>대화방번호</th>"
          + "<th>메시지</th>"
          + "<th>메시지유형</th>"
          + "<th>생성일</th>"
          + "</tr>");

      for (Chat chat : list) {
        out.printf("<tr>"
            + "<td>%d</td>"
            + "<td>%d</td>"
            + "<td>%d</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "</tr>\n",
            chat.getcNo(),
            chat.getwNo(),
            chat.getgChatCode(),
            chat.getcContent(),
            chat.getcName(),
            chat.getcDate());
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
