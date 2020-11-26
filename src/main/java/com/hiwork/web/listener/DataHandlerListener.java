package com.hiwork.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.hiwork.dao.CInfoDao;
import com.hiwork.dao.CRoomDao;
import com.hiwork.dao.mariadb.CInfoDaoImpl;
import com.hiwork.dao.mariadb.CRoomDaoImpl;
import com.hiwork.service.CInfoService;
import com.hiwork.service.CRoomService;
import com.hiwork.service.DefaultCInfoService;
import com.hiwork.service.DefaultCRoomService;
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
      CRoomDao cRoomDao = new CRoomDaoImpl(sqlSessionFactory);

      // Service 구현체 생성
      CInfoService cInfoService = new DefaultCInfoService(cInfoDao);
      CRoomService cRoomService = new DefaultCRoomService(cRoomDao);

      ServletContext ctx = sce.getServletContext();

      // 다른 객체가 사용할 수 있도록 context 맵 보관소에 저장해둔다.
      ctx.setAttribute("cInfoService", cInfoService);
      ctx.setAttribute("cRoomService", cRoomService);

    } catch (Exception e) {
      System.out.println("Mybatis 및 DAO, 서비스 객체 준비 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
