package com.hiwork.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.hiwork.dao.AuthDao;
import com.hiwork.dao.BoardDao;
import com.hiwork.dao.CInfoDao;
import com.hiwork.dao.CRoomDao;
import com.hiwork.dao.CalenderDao;
import com.hiwork.dao.ChatDao;
import com.hiwork.dao.TListDao;
import com.hiwork.dao.VKindDao;
import com.hiwork.dao.WorkerDao;
import com.hiwork.dao.mariadb.AuthDaoImpl;
import com.hiwork.dao.mariadb.BoardDaoImpl;
import com.hiwork.dao.mariadb.CInfoDaoImpl;
import com.hiwork.dao.mariadb.CRoomDaoImpl;
import com.hiwork.dao.mariadb.CalenderDaoImpl;
import com.hiwork.dao.mariadb.ChatDaoImpl;
import com.hiwork.dao.mariadb.TListDaoImpl;
import com.hiwork.dao.mariadb.VKindDaoImpl;
import com.hiwork.dao.mariadb.WorkerDaoImpl;
import com.hiwork.service.AuthService;
import com.hiwork.service.BoardService;
import com.hiwork.service.CInfoService;
import com.hiwork.service.CRoomService;
import com.hiwork.service.CalenderService;
import com.hiwork.service.ChatService;
import com.hiwork.service.DefaultAuthService;
import com.hiwork.service.DefaultBoardService;
import com.hiwork.service.DefaultCInfoService;
import com.hiwork.service.DefaultCRoomService;
import com.hiwork.service.DefaultCalenderService;
import com.hiwork.service.DefaultChatService;
import com.hiwork.service.DefaultTListService;
import com.hiwork.service.DefaultVKindService;
import com.hiwork.service.DefaultWorkerService;
import com.hiwork.service.TListService;
import com.hiwork.service.VKindService;
import com.hiwork.service.WorkerService;
import com.hiwork.util.SqlSessionFactoryProxy;

@WebListener
public class DataHandlerListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 시스템에서 사용할 객체를 준비한다.
    try {
      // Mybatis 객체 준비
      SqlSessionFactoryProxy sqlSessionFactory = new SqlSessionFactoryProxy(
          new SqlSessionFactoryBuilder().build(
              Resources.getResourceAsStream("com/hiwork/conf/mybatis-config.xml")));

      // DAO 구현체 생성
      CInfoDao cInfoDao = new CInfoDaoImpl(sqlSessionFactory);
      AuthDao authDao = new AuthDaoImpl(sqlSessionFactory);
      CRoomDao cRoomDao = new CRoomDaoImpl(sqlSessionFactory);
      WorkerDao workerDao = new WorkerDaoImpl(sqlSessionFactory);
      BoardDao boardDao = new BoardDaoImpl(sqlSessionFactory);
      TListDao tListDao = new TListDaoImpl(sqlSessionFactory);
      ChatDao chatDao = new ChatDaoImpl(sqlSessionFactory);
      VKindDao vKindDao = new VKindDaoImpl(sqlSessionFactory);
      CalenderDao calenderDao = new CalenderDaoImpl(sqlSessionFactory);

      // Service 구현체 생성
      CInfoService cInfoService = new DefaultCInfoService(cInfoDao);
      AuthService authService = new DefaultAuthService(authDao);
      CRoomService cRoomService = new DefaultCRoomService(cRoomDao);
      WorkerService workerService = new DefaultWorkerService(workerDao);
      BoardService boardService = new DefaultBoardService(boardDao);
      TListService tListService = new DefaultTListService(tListDao);
      ChatService chatService = new DefaultChatService(chatDao);
      VKindService vKindService = new DefaultVKindService(vKindDao);
      CalenderService calenderService = new DefaultCalenderService(calenderDao);

      ServletContext ctx = sce.getServletContext();

      // 다른 객체가 사용할 수 있도록 context 맵 보관소에 저장해둔다.
      ctx.setAttribute("cInfoService", cInfoService);
      ctx.setAttribute("authService", authService);
      ctx.setAttribute("cRoomService", cRoomService);
      ctx.setAttribute("workerService", workerService);
      ctx.setAttribute("boardService", boardService);
      ctx.setAttribute("tListService", tListService);
      ctx.setAttribute("chatService", chatService);
      ctx.setAttribute("vKindService", vKindService);
      ctx.setAttribute("calenderService", calenderService);

    } catch (Exception e) {
      System.out.println("Mybatis 및 DAO, 서비스 객체 준비 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
