//package com.hiwork.web;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import java.util.List;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import com.hiwork.domain.Board;
//import com.hiwork.service.BoardService;
//
//@WebServlet("/board/list")
//public class BoardServlet extends HttpServlet {
//  private static final long serialVersionUID = 1L;
//
//  @Override
//  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//
//    ServletContext ctx = request.getServletContext();
//    BoardService boardService =
//        (BoardService) ctx.getAttribute("BoardService");
//
//    response.setContentType("text/html;charset=UTF-8");
//    PrintWriter out = response.getWriter();
//
//    out.println("<!DOCTYPE html>");
//    out.println("<html>");
//    out.println("<head>");
//    out.println("<title>게시판 목록</title></head>");
//    out.println("<body>");
//    try {
//      out.println("<div id=header><h1>게시판 목록</h1></div>");
//      out.println("<table border='1'>");
//
//      List<Board> list = boardService.findAll();
//      out.println("<tr>"
//          + "<th>게시글 정보</th>"
//          + "</tr>");
//
//      for (Board board : list) {
//        out.printf("<tr>"
//            + "<td>%d</td>"
//            + "<td>%d</td>"
//            + "<td>%d</td>"
//            + "<td>%s</td>"
//            + "<td>%s</td>"
//            + "<td>%d</td>"
//            + "<td>%s</td>"
//            + "<td>%d</td>"
//            + "<td>%s</td>"
//            + "</tr>\n",
//            board.getbNo(),
//            board.getbNo2(),
//            board.getwNo(),
//            board.getTitle(),
//            board.getRegiDate(),
//            board.getvCount(),
//            board.getaFile(),
//            board.getfSize(),
//            board.getContent());
//      }
//      out.println("</table>");
//    } catch (Exception e) {
//      out.printf("<p>작업 처리 중 오류 발생! - %s</p>\n", e.getMessage());
//
//      StringWriter errOut = new StringWriter();
//      e.printStackTrace(new PrintWriter(errOut));
//
//      out.printf("<pre>%s</pre>\n", errOut.toString());
//    }
//    out.println("</body>");
//    out.println("</html>");
//  }
//
//}
